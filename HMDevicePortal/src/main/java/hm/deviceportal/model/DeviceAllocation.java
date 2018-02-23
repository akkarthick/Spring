package hm.deviceportal.model;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name="device_allocation_enity")
public class DeviceAllocation {

	@Id
	@GeneratedValue
	@Column(name="device_allocation_id")
	private Long deviceAllocationId;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="approved_by")
	private String approvedBy;

	@Column(name="blocked_by")
	private String blockedBy;
		
	@ManyToOne
	@JoinColumn(name="device_id")
	private Device device;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Generated(GenerationTime.INSERT) 
	@Column(name="create_date", insertable=false,updatable=false)
	private Calendar createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Generated(GenerationTime.ALWAYS)
	@Column(name = "modified_date", updatable = false, insertable = false)
	private Calendar modifiedDate;
	
	public String getApprovedBy() {
		return approvedBy;
	}
			
	public String getBlockedBy() {
		return blockedBy;
	}

	public Device getDevice() {
		return device;
	}

	public Long getDeviceAllocationId() {
		return deviceAllocationId;
	}

	public Date getEndDate() {
		return endDate;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public void setBlockedBy(String blockedBy) {
		this.blockedBy = blockedBy;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public void setDeviceAllocationId(Long deviceAllocationId) {
		this.deviceAllocationId = deviceAllocationId;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Calendar getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}

	public Calendar getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Calendar modifiedDate) {
		this.modifiedDate = modifiedDate;
	}	
	
							
}




