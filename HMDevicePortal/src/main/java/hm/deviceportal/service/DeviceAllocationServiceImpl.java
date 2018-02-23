package hm.deviceportal.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hm.deviceportal.dao.DeviceAllocationDAO;
import hm.deviceportal.model.DeviceAllocation;

@Service
@Transactional
public class DeviceAllocationServiceImpl implements DeviceAllocationService {

	@Autowired
	private DeviceAllocationDAO deviceAllocationDAO;
		
	@Override
	@Transactional
	public void addAllocation(DeviceAllocation deviceAllocation) {
		deviceAllocationDAO.addAllocation(deviceAllocation);
	}

	public DeviceAllocation updateAllocation(DeviceAllocation deviceAllocation) {
		return deviceAllocationDAO.updateAllocation(deviceAllocation);
	}

	@Override
	@Transactional
	public List<DeviceAllocation> getAllAllocations() {
		return deviceAllocationDAO.getAllAllocations();
	}

	@Override
	@Transactional
	public void deleteAllocation(long deviceAllocationId) {
		 deviceAllocationDAO.deleteAllocation(deviceAllocationId);
	}
	
	public DeviceAllocation getAllocation(long deviceAllocationId) {
		return deviceAllocationDAO.getAllocation(deviceAllocationId);
	}
	
	public void setDeviceAllocationDAO(DeviceAllocationDAO deviceAllocationDAO) {
		this.deviceAllocationDAO = deviceAllocationDAO;
	}
	
	
	@Override
	@Transactional
	public void deviceReallocation(int deviceId, int availableValue) {
		deviceAllocationDAO.deviceReallocation(deviceId, availableValue);
	}

}
