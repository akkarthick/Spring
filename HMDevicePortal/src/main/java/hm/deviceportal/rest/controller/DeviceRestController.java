package hm.deviceportal.rest.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import hm.deviceportal.service.DeviceService;

import hm.deviceportal.model.Device;

@RestController
public class DeviceRestController {
	
	@Autowired
	DeviceService deviceService;
	
	 //-------------------Retrieve All Devices-----------------------------------
	@RequestMapping(value="/devicerestapi/listdevice/", method=RequestMethod.GET)
	public ResponseEntity<List<Device>> listAllDevices() {
		
		List<Device> device = deviceService.getAllDevices();
		if(device.isEmpty()) {
			return new ResponseEntity<List<Device>>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<List<Device>>(device,HttpStatus.OK);
		}
	}
	
	//-------------------Retrieve Single Device-------------------------------
	
	@RequestMapping(value="/devicerestapi/getdevice/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Device> getDeviceApi(@PathVariable("id") int deviceid) {
		System.out.println("Fetching device with id:" + deviceid);
		Device device = deviceService.getDevice(deviceid);
		if(device == null) {
			System.out.println("Device with id " + deviceid + " not found");
			return new ResponseEntity<Device>(HttpStatus.NOT_FOUND);
		}	
		else {
		return new ResponseEntity<Device>(device, HttpStatus.OK);
		}
	}
	
	 //-------------------Create a Device----------------------------
	@RequestMapping(value = "/devicerestapi/createdevice/", method = RequestMethod.POST)
	public ResponseEntity<Void> createDevice(@RequestBody Device device, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Device " + device.getBrand());
		if(deviceService.isDeviceExist(device)) {
			 System.out.println("A Device with name " + device.getItemmodelnumber()+ " already exist");
			 return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		deviceService.addDevice(device);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/devicerestapi/getdevice/{id}").buildAndExpand(device.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED); 
	}

	//------------------- Update a Device ---------------------------------- 
	 @RequestMapping(value = "/devicerestapi/updatedevice/{id}", method = RequestMethod.PUT)
	 public ResponseEntity<Device> updateDevice(@PathVariable("id") int deviceId, @RequestBody Device device) {
		 System.out.println("Updating Device " + deviceId);
		 Device currentdevice = deviceService.findById(deviceId);
		 
		 if(currentdevice==null) {
			 System.out.println("Device with id " + deviceId + " not found");
			 return new ResponseEntity<Device>(HttpStatus.NOT_FOUND);
		 }
		 
		 currentdevice.setActive(device.getActive());
		 currentdevice.setBrand(device.getBrand());
		 currentdevice.setAveragebatterylife(device.getAveragebatterylife());
		 currentdevice.setBatteries(device.getBatteries());
		 currentdevice.setBatterydescription(device.getBatterydescription());
		 currentdevice.setColour(device.getColour());
		 currentdevice.setIncludedcomponents(device.getIncludedcomponents());
		 currentdevice.setItemheight(device.getItemheight());
		 currentdevice.setItemmodelnumber(device.getItemmodelnumber());
		 currentdevice.setItemweight(device.getItemweight());
		 currentdevice.setItemwidth(device.getItemwidth());
		 currentdevice.setLithiumbatteryenergycontent(device.getLithiumbatteryenergycontent());
		 currentdevice.setProductdimensions(device.getProductdimensions());
		 currentdevice.setSeries(device.getSeries());
		 
		 deviceService.updateDevice(currentdevice);
		 return new ResponseEntity<Device>(currentdevice, HttpStatus.OK);		 
	 }
	 
	 
	//------------------- Delete a Device --------------------------------------------------------
     
	    @RequestMapping(value = "/devicerestapi/deletedevice/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Device> deleteDevice(@PathVariable("id") int deviceId) {
	        System.out.println("Fetching & Deleting device with id " + deviceId);
	 
	        Device device = deviceService.findById(deviceId);
	        if (device == null) {
	            System.out.println("Unable to delete. Device with id " + deviceId + " not found");
	            return new ResponseEntity<Device>(HttpStatus.NOT_FOUND);
	        }
	 
	        deviceService.deleteDevice(deviceId);
	        return new ResponseEntity<Device>(HttpStatus.NO_CONTENT);
	    }
	
}
