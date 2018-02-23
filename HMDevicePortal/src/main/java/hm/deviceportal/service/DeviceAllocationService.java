package hm.deviceportal.service;

import java.util.List;

import hm.deviceportal.model.DeviceAllocation;

public interface DeviceAllocationService {

	public void addAllocation(DeviceAllocation deviceAllocation);
	
	public DeviceAllocation updateAllocation(DeviceAllocation deviceAllocation);
	
	public List<DeviceAllocation> getAllAllocations();
		
	public void deleteAllocation(long deviceAllocationId);	
	
	public DeviceAllocation getAllocation(long deviceAllocationId);
	
	public void deviceReallocation(int deviceId, int availableValue);
	
}
