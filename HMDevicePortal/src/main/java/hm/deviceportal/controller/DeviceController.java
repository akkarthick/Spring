package hm.deviceportal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import hm.deviceportal.model.Device;
import hm.deviceportal.service.DeviceService;

@Controller
public class DeviceController {

	private static final Logger logger = Logger
					.getLogger(DeviceController.class);

	public DeviceController() {
		System.out.println("DeviceController()");
	}

	@Autowired
	private DeviceService deviceService;

	@RequestMapping(value = "/")
	public ModelAndView listDevice(ModelAndView model) throws IOException {
		List<Device> listDevice = deviceService.getAllDevices();
		model.addObject("listDevice", listDevice);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/newDevice", method = RequestMethod.GET)
	public ModelAndView newDevice(ModelAndView model) {
		Device device = new Device();
		model.addObject("device", device);
		model.setViewName("DeviceForm");
		return model;
	}

	@RequestMapping(value = "/saveDevice", method = RequestMethod.POST)
	public ModelAndView saveDevice(@ModelAttribute Device device) {
		if (device.getId() == 0) { // if device id is 0 then creating the
			deviceService.addDevice(device);
		} else {
			deviceService.updateDevice(device);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteDevice", method = RequestMethod.GET)
	public ModelAndView deleteDevice(HttpServletRequest request) {
		int deviceId = Integer.parseInt(request.getParameter("id"));
		deviceService.deleteDevice(deviceId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editDevice", method = RequestMethod.GET)
	public ModelAndView editDevice(HttpServletRequest request) {
		int deviceId = Integer.parseInt(request.getParameter("id"));
		Device device = deviceService.getDevice(deviceId);
		ModelAndView model = new ModelAndView("DeviceForm");
		model.addObject("device", device);

		return model;
	}
	
	@RequestMapping(value = "cancel",  method = RequestMethod.GET)
	public String cancelSave() {
			 return "redirect:/";
			}
	
	@RequestMapping(value = "/setDeviceActive", method = RequestMethod.GET)
	public ModelAndView deviceActive(HttpServletRequest request) {
		int deviceId = Integer.parseInt(request.getParameter("id"));
		int activeValue = Integer.parseInt(request.getParameter("value"));
		deviceService.setDeviceActive(deviceId, activeValue);
		return new ModelAndView("redirect:/");
	}
	
}