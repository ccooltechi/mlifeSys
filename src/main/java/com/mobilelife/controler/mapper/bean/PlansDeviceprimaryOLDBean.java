/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.controler.mapper.bean;

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
//@Entity
//@Table(name = "plans_deviceprimary", catalog = "telco", schema = "")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "PlansDeviceprimary.findAll", query = "SELECT p FROM PlansDeviceprimary p")
//    , @NamedQuery(name = "PlansDeviceprimary.findById", query = "SELECT p FROM PlansDeviceprimary p WHERE p.id = :id")
//    , @NamedQuery(name = "PlansDeviceprimary.findByPlanName", query = "SELECT p FROM PlansDeviceprimary p WHERE p.planName = :planName")
//    , @NamedQuery(name = "PlansDeviceprimary.findByDeviceModel", query = "SELECT p FROM PlansDeviceprimary p WHERE p.deviceModel = :deviceModel")
//    , @NamedQuery(name = "PlansDeviceprimary.findByDeviceType", query = "SELECT p FROM PlansDeviceprimary p WHERE p.deviceType = :deviceType")
//    , @NamedQuery(name = "PlansDeviceprimary.findByDeviceColor", query = "SELECT p FROM PlansDeviceprimary p WHERE p.deviceColor = :deviceColor")
//    , @NamedQuery(name = "PlansDeviceprimary.findByDeviceMemory", query = "SELECT p FROM PlansDeviceprimary p WHERE p.deviceMemory = :deviceMemory")
//    , @NamedQuery(name = "PlansDeviceprimary.findByDeviceMemoryUnit", query = "SELECT p FROM PlansDeviceprimary p WHERE p.deviceMemoryUnit = :deviceMemoryUnit")
//    , @NamedQuery(name = "PlansDeviceprimary.findByFlexiNat", query = "SELECT p FROM PlansDeviceprimary p WHERE p.flexiNat = :flexiNat")
//    , @NamedQuery(name = "PlansDeviceprimary.findByStock", query = "SELECT p FROM PlansDeviceprimary p WHERE p.stock = :stock")
//    , @NamedQuery(name = "PlansDeviceprimary.findByCost", query = "SELECT p FROM PlansDeviceprimary p WHERE p.cost = :cost")
//    , @NamedQuery(name = "PlansDeviceprimary.findByAddOns", query = "SELECT p FROM PlansDeviceprimary p WHERE p.addOns = :addOns")
//    , @NamedQuery(name = "PlansDeviceprimary.findByAddOnsCost", query = "SELECT p FROM PlansDeviceprimary p WHERE p.addOnsCost = :addOnsCost")
//    , @NamedQuery(name = "PlansDeviceprimary.findByPriority", query = "SELECT p FROM PlansDeviceprimary p WHERE p.priority = :priority")
//    , @NamedQuery(name = "PlansDeviceprimary.findByIsActive", query = "SELECT p FROM PlansDeviceprimary p WHERE p.isActive = :isActive")
//    , @NamedQuery(name = "PlansDeviceprimary.findByCreationDatetime", query = "SELECT p FROM PlansDeviceprimary p WHERE p.creationDatetime = :creationDatetime")
//    , @NamedQuery(name = "PlansDeviceprimary.findByLastModifiedDatetime", query = "SELECT p FROM PlansDeviceprimary p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")})
public class PlansDeviceprimaryOLDBean implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "id")
//    private Integer id;
//    @Column(name = "plan_name")
//    private String planName;
//    @Column(name = "device_model")
//    private String deviceModel;
//    @Column(name = "device_type")
//    private String deviceType;
//    @Column(name = "device_color")
//    private String deviceColor;
//    @Basic(optional = false)
//    @Column(name = "device_memory")
//    private int deviceMemory;
//    @Column(name = "device_memory_unit")
//    private String deviceMemoryUnit;
//    @Column(name = "flexi_nat")
//    private String flexiNat;
//    @Basic(optional = false)
//    @Column(name = "stock")
//    private int stock;
//    @Basic(optional = false)
//    @Column(name = "cost")
//    private int cost;
//    @Column(name = "add_ons")
//    private String addOns;
//    @Basic(optional = false)
//    @Column(name = "add_ons_cost")
//    private int addOnsCost;
//    @Column(name = "priority")
//    private Integer priority;
//    @Column(name = "deviceImage")
//    private String deviceImage;
//    @Column(name = "deviceColorHex")
//    private String deviceColorHex;
//    @Basic(optional = false)
//    @Column(name = "is_active")
//    private boolean isActive;
//    @Basic(optional = false)
//    @Column(name = "creation_datetime")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date creationDatetime;
//    @Column(name = "last_modified_datetime")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDatetime;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deviceprimaryid")
//    private Collection<PlansDeviceprice> plansDevicepriceCollection;
//    @JoinColumn(name = "brand_type", referencedColumnName = "id")
//    @ManyToOne(optional = false)
//    private PlanDevicebrand brandType;
//    @JoinColumn(name = "operator_id", referencedColumnName = "id")
//    @ManyToOne(optional = false)
//    private PlansOperator operatorId;
////    @JoinColumn(name = "plan_type", referencedColumnName = "id")
////    @ManyToOne(optional = false)
////    private PlansPlantype planType;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deviceprimaryid")
//    private Collection<DeviceFeedback> deviceFeedbackCollection;
////    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deviceprimaryid")
////    private Collection<PlansDevicePlan> plansDevicePlanCollection;
//
//    public PlansDeviceprimaryOLD() {
//    }
//
//    public PlansDeviceprimaryOLD(Integer id) {
//        this.id = id;
//    }
//
//    public PlansDeviceprimaryOLD(Integer id, int deviceMemory, int stock, int cost, int addOnsCost, boolean isActive, Date creationDatetime) {
//        this.id = id;
//        this.deviceMemory = deviceMemory;
//        this.stock = stock;
//        this.cost = cost;
//        this.addOnsCost = addOnsCost;
//        this.isActive = isActive;
//        this.creationDatetime = creationDatetime;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getPlanName() {
//        return planName;
//    }
//
//    public void setPlanName(String planName) {
//        this.planName = planName;
//    }
//
//    public String getDeviceModel() {
//        return deviceModel;
//    }
//
//    public void setDeviceModel(String deviceModel) {
//        this.deviceModel = deviceModel;
//    }
//
//    public String getDeviceType() {
//        return deviceType;
//    }
//
//    public void setDeviceType(String deviceType) {
//        this.deviceType = deviceType;
//    }
//
//    public String getDeviceColor() {
//        return deviceColor;
//    }
//
//    public void setDeviceColor(String deviceColor) {
//        this.deviceColor = deviceColor;
//    }
//
//    public int getDeviceMemory() {
//        return deviceMemory;
//    }
//
//    public void setDeviceMemory(int deviceMemory) {
//        this.deviceMemory = deviceMemory;
//    }
//
//    public String getDeviceMemoryUnit() {
//        return deviceMemoryUnit;
//    }
//
//    public void setDeviceMemoryUnit(String deviceMemoryUnit) {
//        this.deviceMemoryUnit = deviceMemoryUnit;
//    }
//
//    public String getFlexiNat() {
//        return flexiNat;
//    }
//
//    public void setFlexiNat(String flexiNat) {
//        this.flexiNat = flexiNat;
//    }
//
//    public int getStock() {
//        return stock;
//    }
//
//    public void setStock(int stock) {
//        this.stock = stock;
//    }
//
//    public int getCost() {
//        return cost;
//    }
//
//    public void setCost(int cost) {
//        this.cost = cost;
//    }
//
//    public String getAddOns() {
//        return addOns;
//    }
//
//    public void setAddOns(String addOns) {
//        this.addOns = addOns;
//    }
//
//    public int getAddOnsCost() {
//        return addOnsCost;
//    }
//
//    public void setAddOnsCost(int addOnsCost) {
//        this.addOnsCost = addOnsCost;
//    }
//
//    public Integer getPriority() {
//        return priority;
//    }
//
//    public void setPriority(Integer priority) {
//        this.priority = priority;
//    }
//
//    public boolean getIsActive() {
//        return isActive;
//    }
//
//    public void setIsActive(boolean isActive) {
//        this.isActive = isActive;
//    }
//
//    public Date getCreationDatetime() {
//        return creationDatetime;
//    }
//
//    public void setCreationDatetime(Date creationDatetime) {
//        this.creationDatetime = creationDatetime;
//    }
//
//    public Date getLastModifiedDatetime() {
//        return lastModifiedDatetime;
//    }
//
//    public void setLastModifiedDatetime(Date lastModifiedDatetime) {
//        this.lastModifiedDatetime = lastModifiedDatetime;
//    }
//
//    @XmlTransient
//    public Collection<PlansDeviceprice> getPlansDevicepriceCollection() {
//        return plansDevicepriceCollection;
//    }
//
//    public void setPlansDevicepriceCollection(Collection<PlansDeviceprice> plansDevicepriceCollection) {
//        this.plansDevicepriceCollection = plansDevicepriceCollection;
//    }
//
//    public PlanDevicebrand getBrandType() {
//        return brandType;
//    }
//
//    public void setBrandType(PlanDevicebrand brandType) {
//        this.brandType = brandType;
//    }
//
//    public PlansOperator getOperatorId() {
//        return operatorId;
//    }
//
//    public void setOperatorId(PlansOperator operatorId) {
//        this.operatorId = operatorId;
//    }
//
////    public PlansPlantype getPlanType() {
////        return planType;
////    }
////
////    public void setPlanType(PlansPlantype planType) {
////        this.planType = planType;
////    }
//
//    
//    public String getDeviceImage() {
//		return deviceImage;
//	}
//
//	public void setDeviceImage(String deviceImage) {
//		this.deviceImage = deviceImage;
//	}
//	
//
//	public String getDeviceColorHex() {
//		return deviceColorHex;
//	}
//
//	public void setDeviceColorHex(String deviceColorHex) {
//		this.deviceColorHex = deviceColorHex;
//	}
//
//	@XmlTransient
//    public Collection<DeviceFeedback> getDeviceFeedbackCollection() {
//        return deviceFeedbackCollection;
//    }
//
//    public void setDeviceFeedbackCollection(Collection<DeviceFeedback> deviceFeedbackCollection) {
//        this.deviceFeedbackCollection = deviceFeedbackCollection;
//    }
//
////	public Collection<PlansDevicePlan> getPlansDevicePlanCollection() {
////		return plansDevicePlanCollection;
////	}
////
////	public void setPlansDevicePlanCollection(Collection<PlansDevicePlan> plansDevicePlanCollection) {
////		this.plansDevicePlanCollection = plansDevicePlanCollection;
////	}
//
//	@Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof PlansDeviceprimaryOLD)) {
//            return false;
//        }
//        PlansDeviceprimaryOLD other = (PlansDeviceprimaryOLD) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "com.mycompany.mavenproject1.PlansDeviceprimary[ id=" + id + " ]";
//    }
    
}
