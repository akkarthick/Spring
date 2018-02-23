package hm.deviceportal.service;

import java.util.List;

import hm.deviceportal.model.Device;

public interface DeviceService {
	
	public void addDevice(Device device);

	public List<Device> getAllDevices();

	public void deleteDevice(Integer deviceId);

	public Device getDevice(int deviceid);
	
	public Device findDeviceByName(String itemmodelnumber);

	public Device updateDevice(Device device);
	
	public List<Device> getIsAavailableDevice(); 
	
	public void setDeviceActive(Integer deviceId, Integer activeValue);
	
	public boolean isDeviceExist(Device device);
	
	Device findById(int deviceId);	
		
}
