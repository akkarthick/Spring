package hm.deviceportal.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hm.deviceportal.model.DeviceAllocation;

@Repository
public class DeviceAllocationDAOImpl implements DeviceAllocationDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void addAllocation(DeviceAllocation deviceAllocation) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(deviceAllocation);
	}

	@SuppressWarnings("unchecked")
	public List<DeviceAllocation> getAllAllocations() {
		return sessionFactory.getCurrentSession().createQuery("from DeviceAllocation")
				.list();
	}
	
	@Override
	public DeviceAllocation updateAllocation(DeviceAllocation deviceAllocation) {
		sessionFactory.getCurrentSession().update(deviceAllocation);
		return deviceAllocation;
	}

	@Override
	public void deleteAllocation(long deviceAllocationId) {
	
		DeviceAllocation deviceAllocation= (DeviceAllocation) sessionFactory.getCurrentSession().load(
					DeviceAllocation.class, deviceAllocationId);
		
		if(null != deviceAllocation) {
			this.sessionFactory.getCurrentSession().delete(deviceAllocation);
		}										
	}

	
	public DeviceAllocation getAllocation(long deviceAllocationId) {
		return (DeviceAllocation) sessionFactory.getCurrentSession().get(
				DeviceAllocation.class, deviceAllocationId);
	}
	
	
	@Override
	public void deviceReallocation(int deviceId, int availableValue) {
		Query query = sessionFactory.getCurrentSession().createQuery("update Device set isAvailable= :available where id= :id");
        query.setParameter("available", availableValue);
        query.setLong("id", deviceId);
        query.executeUpdate();
	}

}
