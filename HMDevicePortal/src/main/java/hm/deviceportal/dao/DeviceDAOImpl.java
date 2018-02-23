package hm.deviceportal.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hm.deviceportal.model.Device;

@Repository
public class DeviceDAOImpl implements DeviceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addDevice(Device device) {
		sessionFactory.getCurrentSession().saveOrUpdate(device);

	}

	@SuppressWarnings("unchecked")
	public List<Device> getAllDevices() {

		return sessionFactory.getCurrentSession().createQuery("from Device")
				.list();		
	}
	
	@SuppressWarnings("unchecked")
	public List<Device> getIsAavailableDevice(){
		return sessionFactory.getCurrentSession().createQuery("from Device where isAvailable=0 and active=1")
				.list();
	}
	
	@Override	
	public void setDeviceActive(Integer deviceId, Integer activeValue) {
		Query query = sessionFactory.getCurrentSession().createQuery("update Device set active= :active where id= :id");
	        query.setParameter("active", activeValue);
	        query.setLong("id", deviceId);
	        query.executeUpdate();
	}

	@Override
	public void deleteDevice(Integer deviceId) {
		Device device = (Device) sessionFactory.getCurrentSession().load(
				Device.class, deviceId);
		if (null != device) {
			this.sessionFactory.getCurrentSession().delete(device);
		}

	}

	public Device getDevice(int deviceid) {
		return (Device) sessionFactory.getCurrentSession().get(
				Device.class, deviceid);
	}

	@Override
	public Device updateDevice(Device device) {
		sessionFactory.getCurrentSession().update(device);
		return device;
	}

}