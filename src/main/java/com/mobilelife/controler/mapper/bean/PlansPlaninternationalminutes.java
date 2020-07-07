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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

public class PlansPlaninternationalminutes implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer internationalMinutes;
    private String internationalMinutePulse;
    private Integer internationalMinutesRollover;
    private String internationalMinBucketcode;
    private Double international_minutes_unitrate;
    private boolean isActive;
    private Integer planPrimaryId;
    private String networkSpecificCalling;
    private String callingCardBucket;

    public PlansPlaninternationalminutes() {
    }

    public PlansPlaninternationalminutes(Integer id) {
        this.id = id;
    }

    public PlansPlaninternationalminutes(Integer id, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInternationalMinutes() {
        return internationalMinutes;
    }

    public void setInternationalMinutes(Integer internationalMinutes) {
        this.internationalMinutes = internationalMinutes;
    }

    public String getInternationalMinutePulse() {
        return internationalMinutePulse;
    }

    public void setInternationalMinutePulse(String internationalMinutePulse) {
        this.internationalMinutePulse = internationalMinutePulse;
    }

    public Integer getInternationalMinutesRollover() {
        return internationalMinutesRollover;
    }

    public void setInternationalMinutesRollover(Integer internationalMinutesRollover) {
        this.internationalMinutesRollover = internationalMinutesRollover;
    }

    public String getInternationalMinBucketcode() {
        return internationalMinBucketcode;
    }

    public void setInternationalMinBucketcode(String internationalMinBucketcode) {
        this.internationalMinBucketcode = internationalMinBucketcode;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getPlanPrimaryId() {
        return planPrimaryId;
    }

    public void setPlanPrimaryId(Integer planPrimaryId) {
        this.planPrimaryId = planPrimaryId;
    }

    
    public Double getInternational_minutes_unitrate() {
		return international_minutes_unitrate;
	}

	public void setInternational_minutes_unitrate(Double international_minutes_unitrate) {
		this.international_minutes_unitrate = international_minutes_unitrate;
	}
	
	public String getNetworkSpecificCalling() {
		return networkSpecificCalling;
	}

	public void setNetworkSpecificCalling(String networkSpecificCalling) {
		this.networkSpecificCalling = networkSpecificCalling;
	}

	public String getCallingCardBucket() {
		return callingCardBucket;
	}

	public void setCallingCardBucket(String callingCardBucket) {
		this.callingCardBucket = callingCardBucket;
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
        if (!(object instanceof PlansPlaninternationalminutes)) {
            return false;
        }
        PlansPlaninternationalminutes other = (PlansPlaninternationalminutes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlaninternationalminutes[ id=" + id + " ]";
    }
    
}
