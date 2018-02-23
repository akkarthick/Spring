package hm.deviceportal.dao;

import java.util.List;

import hm.deviceportal.model.DeviceAllocation;

public interface DeviceAllocationDAO {
	
	public void addAllocation(DeviceAllocation deviceAllocation);
	
	public List<DeviceAllocation> getAllAllocations();
	
	public DeviceAllocation updateAllocation(DeviceAllocation deviceAllocation);
	
	public void deleteAllocation(long deviceAllocationId);
	
	public DeviceAllocation getAllocation(long deviceAllocationId);
	
	public void deviceReallocation(int deviceId, int availableValue);

}
