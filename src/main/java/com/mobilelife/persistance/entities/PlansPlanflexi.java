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
@Table(name = "plans_planflexi", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlanflexi.findAll", query = "SELECT p FROM PlansPlanflexi p")
    , @NamedQuery(name = "PlansPlanflexi.findById", query = "SELECT p FROM PlansPlanflexi p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlanflexi.findByFlexiMinutes", query = "SELECT p FROM PlansPlanflexi p WHERE p.flexiMinutes = :flexiMinutes")
    , @NamedQuery(name = "PlansPlanflexi.findByFlexiMinutesPulse", query = "SELECT p FROM PlansPlanflexi p WHERE p.flexiMinutesPulse = :flexiMinutesPulse")
    , @NamedQuery(name = "PlansPlanflexi.findByFlexiMinutesRollover", query = "SELECT p FROM PlansPlanflexi p WHERE p.flexiMinutesRollover = :flexiMinutesRollover")
    , @NamedQuery(name = "PlansPlanflexi.findByCreationDatetime", query = "SELECT p FROM PlansPlanflexi p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlanflexi.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlanflexi p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlanflexi.findByIsActive", query = "SELECT p FROM PlansPlanflexi p WHERE p.isActive = :isActive")})
public class PlansPlanflexi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "flexi_minutes")
    private Integer flexiMinutes;
    @Column(name = "flexi_minutes_pulse")
    private String flexiMinutesPulse;
    @Column(name = "flexi_minutes_rollover")
    private Integer flexiMinutesRollover;
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
    @Column(name = "flexi_minutes_was")
    private Integer flexiMinutesWas;
    @Column(name = "flexi_minutes_discount")
    private Integer flexiMinutesDiscount;
    @Column(name = "flexi_minutes_sms")
    private Integer flexiMinutesSms;

    public PlansPlanflexi() {
    }

    public PlansPlanflexi(Integer id) {
        this.id = id;
    }

    public PlansPlanflexi(Integer id, Date creationDatetime, boolean isActive) {
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

    public Integer getFlexiMinutes() {
        return flexiMinutes;
    }

    public void setFlexiMinutes(Integer flexiMinutes) {
        this.flexiMinutes = flexiMinutes;
    }

    public String getFlexiMinutesPulse() {
        return flexiMinutesPulse;
    }

    public void setFlexiMinutesPulse(String flexiMinutesPulse) {
        this.flexiMinutesPulse = flexiMinutesPulse;
    }

    public Integer getFlexiMinutesRollover() {
        return flexiMinutesRollover;
    }

    public void setFlexiMinutesRollover(Integer flexiMinutesRollover) {
        this.flexiMinutesRollover = flexiMinutesRollover;
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

    public Integer getFlexiMinutesWas() {
		return flexiMinutesWas;
	}

	public void setFlexiMinutesWas(Integer flexiMinutesWas) {
		this.flexiMinutesWas = flexiMinutesWas;
	}

	public Integer getFlexiMinutesDiscount() {
		return flexiMinutesDiscount;
	}

	public void setFlexiMinutesDiscount(Integer flexiMinutesDiscount) {
		this.flexiMinutesDiscount = flexiMinutesDiscount;
	}

	public PlansPlanprimary getPlanPrimaryId() {
        return planPrimaryId;
    }

    public void setPlanPrimaryId(PlansPlanprimary planPrimaryId) {
        this.planPrimaryId = planPrimaryId;
    }

	public Integer getFlexiMinutesSms() {
		return flexiMinutesSms;
	}

	public void setFlexiMinutesSms(Integer flexiMinutesSms) {
		this.flexiMinutesSms = flexiMinutesSms;
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
        if (!(object instanceof PlansPlanflexi)) {
            return false;
        }
        PlansPlanflexi other = (PlansPlanflexi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanflexi[ id=" + id + " ]";
    }
    
}
