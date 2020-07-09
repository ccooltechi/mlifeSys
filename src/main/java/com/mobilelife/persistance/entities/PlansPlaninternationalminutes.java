/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.persistance.entities;

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

/**
 *
 * @author pods
 */
@Entity
@Table(name = "plans_planinternationalminutes", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlaninternationalminutes.findAll", query = "SELECT p FROM PlansPlaninternationalminutes p")
    , @NamedQuery(name = "PlansPlaninternationalminutes.findById", query = "SELECT p FROM PlansPlaninternationalminutes p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlaninternationalminutes.findByInternationalMinutes", query = "SELECT p FROM PlansPlaninternationalminutes p WHERE p.internationalMinutes = :internationalMinutes")
    , @NamedQuery(name = "PlansPlaninternationalminutes.findByInternationalMinutePulse", query = "SELECT p FROM PlansPlaninternationalminutes p WHERE p.internationalMinutePulse = :internationalMinutePulse")
    , @NamedQuery(name = "PlansPlaninternationalminutes.findByInternationalMinutesRollover", query = "SELECT p FROM PlansPlaninternationalminutes p WHERE p.internationalMinutesRollover = :internationalMinutesRollover")
    , @NamedQuery(name = "PlansPlaninternationalminutes.findByInternationalMinBucketcode", query = "SELECT p FROM PlansPlaninternationalminutes p WHERE p.internationalMinBucketcode = :internationalMinBucketcode")
    , @NamedQuery(name = "PlansPlaninternationalminutes.findByCreationDatetime", query = "SELECT p FROM PlansPlaninternationalminutes p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlaninternationalminutes.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlaninternationalminutes p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlaninternationalminutes.findByIsActive", query = "SELECT p FROM PlansPlaninternationalminutes p WHERE p.isActive = :isActive")})
public class PlansPlaninternationalminutes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "international_minutes")
    private Integer internationalMinutes;
    @Column(name = "international_minute_pulse")
    private String internationalMinutePulse;
    @Column(name = "international_minutes_rollover")
    private Integer internationalMinutesRollover;
    @Column(name = "international_min_bucketcode")
    private String internationalMinBucketcode;
    @Column(name = "international_minutes_unitrate")
    private Double international_minutes_unitrate;
    @Basic(optional = false)
    @Column(name = "creation_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDatetime;
    @Column(name = "last_modified_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDatetime;
    @Basic(optional = false)
    @Column(name = "is_active")
    private boolean isActive;
    @JoinColumn(name = "plan_primary_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private PlansPlanprimary planPrimaryId;
    @Column(name = "network_specific_calling")
    private String networkSpecificCalling;
    @Column(name = "calling_card_bucket")
    private String callingCardBucket;

    public PlansPlaninternationalminutes() {
    }

    public PlansPlaninternationalminutes(Integer id) {
        this.id = id;
    }

    public PlansPlaninternationalminutes(Integer id, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.creationDatetime = creationDatetime;
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

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public PlansPlanprimary getPlanPrimaryId() {
        return planPrimaryId;
    }

    public void setPlanPrimaryId(PlansPlanprimary planPrimaryId) {
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
