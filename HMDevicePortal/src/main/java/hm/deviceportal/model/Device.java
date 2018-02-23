package hm.deviceportal.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


@Entity
@Table(name = "device_entity")
public class Device implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String brand;

	@Column
	private String series;

	@Column
	private String colour;

	@Column
	private String itemheight;

	@Column
	private String itemwidth;

	@Column
	private String itemweight;

	@Column
	private String productdimensions;

	@Column
	private String batteries;

	@Column
	private String itemmodelnumber;

	@Column
	private String batterydescription;

	@Column
	private String averagebatterylife;

	@Column
	private String lithiumbatteryenergycontent;

	@Column
	private String includedcomponents;
	
	@Column(name="is_available", nullable = false, columnDefinition = "tinyint(4) default 0")
	private int isAvailable;

	@Column(name="is_active", nullable = false, columnDefinition = "tinyint(4) default 0")
	private int active;
	
	 @Column(name = "create_date", nullable = false)
	 private Date createDate;
	
	 @Column(name = "modified_date", nullable = false)
	 private Date modifiedDate;
			
	public int getActive() {
		return active;
	}

	public String getAveragebatterylife() {
		return averagebatterylife;
	}

	public String getBatteries() {
		return batteries;
	}

	public String getBatterydescription() {
		return batterydescription;
	}

	public String getBrand() {
		return brand;
	}

	public String getColour() {
		return colour;
	}

	public int getId() {
		return id;
	}
	
	public String getIncludedcomponents() {
		return includedcomponents;
	}

	public int getIsAvailable() {
		return isAvailable;
	}

	public String getItemheight() {
		return itemheight;
	}

	public String getItemmodelnumber() {
		return itemmodelnumber;
	}

	public String getItemweight() {
		return itemweight;
	}

	public String getItemwidth() {
		return itemwidth;
	}

	public String getLithiumbatteryenergycontent() {
		return lithiumbatteryenergycontent;
	}

	public String getProductdimensions() {
		return productdimensions;
	}

	public String getSeries() {
		return series;
	}

	public void setActive(int active) {
		this.active = active;
	}
	
	public void setAveragebatterylife(String averagebatterylife) {
		this.averagebatterylife = averagebatterylife;
	}
	
	public void setBatteries(String batteries) {
		this.batteries = batteries;
	}
	
	public void setBatterydescription(String batterydescription) {
		this.batterydescription = batterydescription;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setIncludedcomponents(String includedcomponents) {
		this.includedcomponents = includedcomponents;
	}
	
	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public void setItemheight(String itemheight) {
		this.itemheight = itemheight;
	}
	
	public void setItemmodelnumber(String itemmodelnumber) {
		this.itemmodelnumber = itemmodelnumber;
	}
	
	public void setItemweight(String itemweight) {
		this.itemweight = itemweight;
	}

	public void setItemwidth(String itemwidth) {
		this.itemwidth = itemwidth;
	}

	public void setLithiumbatteryenergycontent(String lithiumbatteryenergycontent) {
		this.lithiumbatteryenergycontent = lithiumbatteryenergycontent;
	}

	public void setProductdimensions(String productdimensions) {
		this.productdimensions = productdimensions;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public Date getCreateDate() {
		return createDate;
	}

	//public void setCreateDate(Date createDate) {
	//	this.createDate = createDate;
	//}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	//public void setModifiedDate(Date modifiedDate) {
	//		this.modifiedDate = modifiedDate;
	//}
	
	@PreUpdate
    public void preUpdate() {
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis); 
		modifiedDate = date; 
	}
     
    @PrePersist
    public void prePersist() {
    	long millis=System.currentTimeMillis();  
		java.sql.Date now =new java.sql.Date(millis); 
        createDate = now;
        modifiedDate = now;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Device other = (Device) obj;
        if (id != other.id)
            return false;
        return true;
    }
 
			
}