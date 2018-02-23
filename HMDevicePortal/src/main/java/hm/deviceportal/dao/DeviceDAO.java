package hm.deviceportal.dao;

import java.util.List;
import hm.deviceportal.model.Device;;

public interface DeviceDAO {

	public void addDevice(Device device);

	public List<Device> getAllDevices();

	public void deleteDevice(Integer deviceId);

	public Device updateDevice(Device device);

	public Device getDevice(int deviceId);
	
	public List<Device> getIsAavailableDevice(); 
	
	public void setDeviceActive(Integer deviceId, Integer activeValue);
}
