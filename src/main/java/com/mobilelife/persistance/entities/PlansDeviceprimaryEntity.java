/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.persistance.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author deepakupadhyay
 */
@Entity
@Table(name = "plans_deviceprimary", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansDeviceprimaryEntity.findAll", query = "SELECT p FROM PlansDeviceprimaryEntity p")
    , @NamedQuery(name = "PlansDeviceprimaryEntity.findById", query = "SELECT p FROM PlansDeviceprimaryEntity p WHERE p.id = :id")
    , @NamedQuery(name = "PlansDeviceprimaryEntity.findByPlanType", query = "SELECT p FROM PlansDeviceprimaryEntity p WHERE p.planType = :planType")
    , @NamedQuery(name = "PlansDeviceprimaryEntity.findByPlansPlanprimaryIds", query = "SELECT p FROM PlansDeviceprimaryEntity p WHERE p.plansPlanprimaryIds = :plansPlanprimaryIds")
    , @NamedQuery(name = "PlansDeviceprimaryEntity.findByDeviceType", query = "SELECT p FROM PlansDeviceprimaryEntity p WHERE p.deviceType = :deviceType")
    , @NamedQuery(name = "PlansDeviceprimaryEntity.findByFlexiNat", query = "SELECT p FROM PlansDeviceprimaryEntity p WHERE p.flexiNat = :flexiNat")
    , @NamedQuery(name = "PlansDeviceprimaryEntity.findByDeviceMemory", query = "SELECT p FROM PlansDeviceprimaryEntity p WHERE p.deviceMemory = :deviceMemory")
    , @NamedQuery(name = "PlansDeviceprimaryEntity.findByDeviceMemoryUnit", query = "SELECT p FROM PlansDeviceprimaryEntity p WHERE p.deviceMemoryUnit = :deviceMemoryUnit")
    , @NamedQuery(name = "PlansDeviceprimaryEntity.findByCommitment", query = "SELECT p FROM PlansDeviceprimaryEntity p WHERE p.commitment = :commitment")
    , @NamedQuery(name = "PlansDeviceprimaryEntity.findBySmartpay", query = "SELECT p FROM PlansDeviceprimaryEntity p WHERE p.smartpay = :smartpay")
    , @NamedQuery(name = "PlansDeviceprimaryEntity.findByExistingonly", query = "SELECT p FROM PlansDeviceprimaryEntity p WHERE p.existingonly = :existingonly")
    , @NamedQuery(name = "PlansDeviceprimaryEntity.findByAddOns", query = "SELECT p FROM PlansDeviceprimaryEntity p WHERE p.addOns = :addOns")
    , @NamedQuery(name = "PlansDeviceprimaryEntity.findByAddOnsCost", query = "SELECT p FROM PlansDeviceprimaryEntity p WHERE p.addOnsCost = :addOnsCost")
    , @NamedQuery(name = "PlansDeviceprimaryEntity.findByPriority", query = "SELECT p FROM PlansDeviceprimaryEntity p WHERE p.priority = :priority")
    , @NamedQuery(name = "PlansDeviceprimaryEntity.findByIsActive", query = "SELECT p FROM PlansDeviceprimaryEntity p WHERE p.isActive = :isActive")
    , @NamedQuery(name = "PlansDeviceprimaryEntity.findByCreationDatetime", query = "SELECT p FROM PlansDeviceprimaryEntity p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansDeviceprimaryEntity.findByLastModifiedDatetime", query = "SELECT p FROM PlansDeviceprimaryEntity p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansDeviceprimaryEntity.findByDeviceImage", query = "SELECT p FROM PlansDeviceprimaryEntity p WHERE p.deviceImage = :deviceImage")
    , @NamedQuery(name = "PlansDeviceprimaryEntity.findByDeviceColorHex", query = "SELECT p FROM PlansDeviceprimaryEntity p WHERE p.deviceColorHex = :deviceColorHex")})
public class PlansDeviceprimaryEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "plan_type")
    private int planType;
    @Column(name = "plans_planprimary_ids")
    private String plansPlanprimaryIds;
    @Column(name = "device_type")
    private String deviceType;
    @Column(name = "flexi_nat")
    private String flexiNat;
    @Basic(optional = false)
    @Column(name = "device_memory")
    private int deviceMemory;
    @Column(name = "device_memory_unit")
    private String deviceMemoryUnit;
    @Basic(optional = false)
    @Column(name = "commitment")
    private String commitment;
    @Column(name = "smartpay")
    private Integer smartpay;
    @Column(name = "existingonly")
    private Integer existingonly;
    @Column(name = "add_ons")
    private String addOns;
    @Basic(optional = false)
    @Column(name = "add_ons_cost")
    private int addOnsCost;
    @Basic(optional = false)
    @Column(name = "priority")
    private int priority;
    @Basic(optional = false)
    @Column(name = "is_active")
    private boolean isActive;
    @Basic(optional = false)
    @Column(name = "upfront_plan")
    private boolean upfront_plan;
    @Basic(optional = false)
    @Column(name = "creation_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDatetime;
    @Column(name = "last_modified_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDatetime;
    @Column(name = "deviceImage")
    private String deviceImage;
    @Column(name = "deviceColorHex")
    private String deviceColorHex;
    @Column(name = "device_memory_extended")
    private String deviceMemoryExtended;
        
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deviceprimaryId")
    private Collection<PlansDevicepriceEntity> plansDevicepriceCollection;
    @JoinColumn(name = "brand_type", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PlanDevicebrandEntity brandType;
    @JoinColumn(name = "device_model", referencedColumnName = "id")
    @ManyToOne
    private PlanDevicemodelEntity deviceModel;
    @JoinColumn(name = "operator_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PlansOperatorEntity operatorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deviceprimaryId")
    private Collection<PlansDeviceplansEntity> plansDeviceplansCollection;

    public PlansDeviceprimaryEntity() {
    }

    public PlansDeviceprimaryEntity(Integer id) {
        this.id = id;
    }

    public PlansDeviceprimaryEntity(Integer id, int planType, int deviceMemory, String commitment, int addOnsCost, int priority, boolean isActive, Date creationDatetime) {
        this.id = id;
        this.planType = planType;
        this.deviceMemory = deviceMemory;
        this.commitment = commitment;
        this.addOnsCost = addOnsCost;
        this.priority = priority;
        this.isActive = isActive;
        this.creationDatetime = creationDatetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPlanType() {
        return planType;
    }

    public void setPlanType(int planType) {
        this.planType = planType;
    }

    public String getPlansPlanprimaryIds() {
        return plansPlanprimaryIds;
    }

    public void setPlansPlanprimaryIds(String plansPlanprimaryIds) {
        this.plansPlanprimaryIds = plansPlanprimaryIds;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getFlexiNat() {
        return flexiNat;
    }

    public void setFlexiNat(String flexiNat) {
        this.flexiNat = flexiNat;
    }

    public int getDeviceMemory() {
        return deviceMemory;
    }

    public void setDeviceMemory(int deviceMemory) {
        this.deviceMemory = deviceMemory;
    }

    public String getDeviceMemoryUnit() {
        return deviceMemoryUnit;
    }

    public void setDeviceMemoryUnit(String deviceMemoryUnit) {
        this.deviceMemoryUnit = deviceMemoryUnit;
    }

    public String getCommitment() {
        return commitment;
    }

    public void setCommitment(String commitment) {
        this.commitment = commitment;
    }

    public Integer getSmartpay() {
        return smartpay;
    }

    public void setSmartpay(Integer smartpay) {
        this.smartpay = smartpay;
    }

    public Integer getExistingonly() {
        return existingonly;
    }

    public void setExistingonly(Integer existingonly) {
        this.existingonly = existingonly;
    }

    public String getAddOns() {
        return addOns;
    }

    public void setAddOns(String addOns) {
        this.addOns = addOns;
    }

    public int getAddOnsCost() {
        return addOnsCost;
    }

    public void setAddOnsCost(int addOnsCost) {
        this.addOnsCost = addOnsCost;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreationDatetime() {
        return creationDatetime;
    }

    public void setCreationDatetime(Date creationDatetime) {
        this.creationDatetime = creationDatetime;
    }

    public Date getLastModifiedDatetime() {
        return lastModifiedDatetime;
    }

    public void setLastModifiedDatetime(Date lastModifiedDatetime) {
        this.lastModifiedDatetime = lastModifiedDatetime;
    }

    public String getDeviceImage() {
        return deviceImage;
    }

    public void setDeviceImage(String deviceImage) {
        this.deviceImage = deviceImage;
    }

    public String getDeviceColorHex() {
        return deviceColorHex;
    }

    public void setDeviceColorHex(String deviceColorHex) {
        this.deviceColorHex = deviceColorHex;
    }

    @XmlTransient
    public Collection<PlansDevicepriceEntity> getPlansDevicepriceCollection() {
        return plansDevicepriceCollection;
    }

    public void setPlansDevicepriceCollection(Collection<PlansDevicepriceEntity> plansDevicepriceCollection) {
        this.plansDevicepriceCollection = plansDevicepriceCollection;
    }

    public PlanDevicebrandEntity getBrandType() {
        return brandType;
    }

    public void setBrandType(PlanDevicebrandEntity brandType) {
        this.brandType = brandType;
    }

    public PlanDevicemodelEntity getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(PlanDevicemodelEntity deviceModel) {
        this.deviceModel = deviceModel;
    }

    public PlansOperatorEntity getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(PlansOperatorEntity operatorId) {
        this.operatorId = operatorId;
    }

    public boolean isUpfront_plan() {
		return upfront_plan;
	}

	public void setUpfront_plan(boolean upfront_plan) {
		this.upfront_plan = upfront_plan;
	}

	
    /**
	 * @return the deviceMemoryExtended
	 */
	public String getDeviceMemoryExtended() {
		return deviceMemoryExtended;
	}

	/**
	 * @param deviceMemoryExtended the deviceMemoryExtended to set
	 */
	public void setDeviceMemoryExtended(String deviceMemoryExtended) {
		this.deviceMemoryExtended = deviceMemoryExtended;
	}

	@XmlTransient
    public Collection<PlansDeviceplansEntity> getPlansDeviceplansCollection() {
        return plansDeviceplansCollection;
    }

    public void setPlansDeviceplansCollection(Collection<PlansDeviceplansEntity> plansDeviceplansCollection) {
        this.plansDeviceplansCollection = plansDeviceplansCollection;
    }

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlansDeviceprimaryEntity)) {
            return false;
        }
        PlansDeviceprimaryEntity other = (PlansDeviceprimaryEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansDeviceprimary[ id=" + id + " ]";
    }
    
}
