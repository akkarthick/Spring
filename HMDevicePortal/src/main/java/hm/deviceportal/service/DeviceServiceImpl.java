package hm.deviceportal.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hm.deviceportal.dao.DeviceDAO;
import hm.deviceportal.model.Device;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {

	private static final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private DeviceDAO deviceDAO;

	@Override
	@Transactional
	public void addDevice(Device device) {
		deviceDAO.addDevice(device);
	}

	@Override
	@Transactional
	public List<Device> getAllDevices() {
		return deviceDAO.getAllDevices();
	}
	
	@Override
	@Transactional
	public List<Device> getIsAavailableDevice() {
		return deviceDAO.getIsAavailableDevice();	
	}

	@Override
	@Transactional
	public void deleteDevice(Integer deviceId) {
		deviceDAO.deleteDevice(deviceId);
	}

	public Device getDevice(int deviceId) {
		return deviceDAO.getDevice(deviceId);
	}

	public Device updateDevice(Device device) {
		// TODO Auto-generated method stub
		return deviceDAO.updateDevice(device);
	}

	public void setDeviceDAO(DeviceDAO deviceDAO) {
		this.deviceDAO = deviceDAO;
	}
	
	@Override
	@Transactional
	public void setDeviceActive(Integer deviceId, Integer activeValue ) {
		deviceDAO.setDeviceActive(deviceId, activeValue);
	}
	
	public Device findDeviceByName(String itemmodelnumber) {
		for(Device device: getAllDevices()) {
			if(device.getItemmodelnumber().equalsIgnoreCase(itemmodelnumber)) {
				return device;
			}
		}
		return null;
	}
	
	public boolean isDeviceExist(Device device) {
		return findDeviceByName(device.getItemmodelnumber())!=null;	
	}
	
	public Device findById(int deviceId) {		
		for(Device device : getAllDevices()) {
			if(device.getId()== deviceId) {
				return device;
			}
		}
		return null;	
	}
		
}
