package hm.deviceportal.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hm.deviceportal.model.Device;
import hm.deviceportal.model.DeviceAllocation;
import hm.deviceportal.service.DeviceAllocationService;
import hm.deviceportal.service.DeviceService;

@Controller
public class DeviceAllocationController {
			
	public DeviceAllocationController() {
		System.out.println("DeviceAllocationController");
	}
	
	@Autowired
	private DeviceAllocationService deviceAllocationService;
	
	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping(value = "/deviceallocation/listAllocation", method = RequestMethod.GET)
	public ModelAndView listAllocation(ModelAndView model) throws IOException {
		
		List<DeviceAllocation> listAllocation = deviceAllocationService.getAllAllocations();
		model.addObject("listAllocation", listAllocation);
		model.setViewName("allocationlist");
		return model;
	}
	
	@RequestMapping(value="/deviceallocation/newAllocation", method=RequestMethod.GET)
	public ModelAndView newAllocation(ModelAndView model) {		
		
		List<Device> deviceList = deviceService.getIsAavailableDevice(); 
		model.addObject("deviceList", deviceList);
		DeviceAllocation deviceAllocation = new DeviceAllocation();
		model.addObject("deviceAllocation", deviceAllocation);		
		model.setViewName("DeviceAllocationForm");
		return model;		
	}
		
	
	@RequestMapping(value = "/deviceallocation/saveAllocation", method = RequestMethod.POST)
	public ModelAndView saveAllocation(@ModelAttribute DeviceAllocation deviceAllocation) {
		System.out.println("test");
		if (deviceAllocation.getDeviceAllocationId() == 0) { // if device id is 0 then creating the
			deviceAllocationService.addAllocation(deviceAllocation);
		} else {
			deviceAllocationService.updateAllocation(deviceAllocation);
		}
		return new ModelAndView("redirect:/deviceallocation/listAllocation");
	}

	@RequestMapping(value = "/deviceallocation/deleteAllocation", method = RequestMethod.GET)
	public ModelAndView deleteAllocation(HttpServletRequest request) {
		long deviceAllocationId = Long.parseLong(request.getParameter("id"));
		deviceAllocationService.deleteAllocation(deviceAllocationId);
		return new ModelAndView("redirect:/deviceallocation/listAllocation");
	}

	@RequestMapping(value = "/deviceallocation/editAllocation", method = RequestMethod.GET)
	public ModelAndView editAllocation(HttpServletRequest request) {
		long deviceAllocationId = Long.parseLong(request.getParameter("id"));						
		DeviceAllocation deviceAllocation = deviceAllocationService.getAllocation(deviceAllocationId);
		ModelAndView model = new ModelAndView("DeviceAllocationForm");
		model.addObject("deviceAllocation", deviceAllocation);
		return model;
	}
	
	@RequestMapping(value = "/deviceallocation/cancel",  method = RequestMethod.GET)
	public String cancelSave() {
			 return "redirect:/deviceallocation/listAllocation";
			}
	
	@RequestMapping(value = "/setdeviceReallocation", method = RequestMethod.GET)
	public ModelAndView deviceReallocation(HttpServletRequest request) {
		int deviceId = Integer.parseInt(request.getParameter("id"));
		int availableValue = Integer.parseInt(request.getParameter("value"));
		deviceAllocationService.deviceReallocation(deviceId, availableValue);
		return new ModelAndView("redirect:/deviceallocation/listAllocation");
	}
}
