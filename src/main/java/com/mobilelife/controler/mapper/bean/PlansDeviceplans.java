/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.controler.mapper.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

public class PlansDeviceplans implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "plan_primary_id")
    private int planPrimaryId;
    @Basic(optional = false)
    @Column(name = "cost")
    private int cost;
    @Basic(optional = false)
    @Column(name = "is_active")
    private boolean isActive;
    @Basic(optional = false)
    @Column(name = "isNational")
    private boolean isNational;
    @Basic(optional = false)
    @Column(name = "isFlexi")
    private boolean isFlexi;
    @Basic(optional = false)
    @Column(name = "isData")
    private boolean isData;
    @Basic(optional = false)
    
    @Column(name = "creation_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDatetime;
    @Column(name = "last_modified_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDatetime;
    @JoinColumn(name = "deviceprimary_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PlansDeviceprimary deviceprimaryId;

    @Column(name = "device_plan_cost")
    private double devicePlanCost;
    

    public PlansDeviceplans() {
    }

    public PlansDeviceplans(Integer id) {
        this.id = id;
    }

    public PlansDeviceplans(Integer id, int planPrimaryId, int cost, boolean isActive, Date creationDatetime) {
        this.id = id;
        this.planPrimaryId = planPrimaryId;
        this.cost = cost;
        this.isActive = isActive;
        this.creationDatetime = creationDatetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPlanPrimaryId() {
        return planPrimaryId;
    }

    public void setPlanPrimaryId(int planPrimaryId) {
        this.planPrimaryId = planPrimaryId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
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

    public PlansDeviceprimary getDeviceprimaryId() {
        return deviceprimaryId;
    }

    public void setDeviceprimaryId(PlansDeviceprimary deviceprimaryId) {
        this.deviceprimaryId = deviceprimaryId;
    }
    
    public boolean getIsNational() {
        return isNational;
    }

    public void setIsNational(boolean isNational) {
        this.isNational = isNational;
    }
    public boolean getIsFlexi() {
        return isFlexi;
    }

    public void setIsFlexi(boolean isFlexi) {
        this.isFlexi = isFlexi;
    }
    public boolean getIsData() {
        return isData;
    }

    public void setIsData(boolean isData) {
        this.isData = isData;
    }
    
    public double getDevicePlanCost() {
		return devicePlanCost;
	}

	public void setDevicePlanCost(double devicePlanCost) {
		this.devicePlanCost = devicePlanCost;
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
        if (!(object instanceof PlansDeviceplans)) {
            return false;
        }
        PlansDeviceplans other = (PlansDeviceplans) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansDeviceplans[ id=" + id + " ]";
    }
    
}
