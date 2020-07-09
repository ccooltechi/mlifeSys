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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author deepakupadhyay
 */
@Entity
@Table(name = "plans_planflexi_locale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlanflexiLocale.findAll", query = "SELECT p FROM PlansPlanflexiLocale p")
    , @NamedQuery(name = "PlansPlanflexiLocale.findById", query = "SELECT p FROM PlansPlanflexiLocale p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlanflexiLocale.findByPlanPrimaryId", query = "SELECT p FROM PlansPlanflexiLocale p WHERE p.planPrimaryId = :planPrimaryId")
    , @NamedQuery(name = "PlansPlanflexiLocale.findByLocale", query = "SELECT p FROM PlansPlanflexiLocale p WHERE p.locale = :locale")
    , @NamedQuery(name = "PlansPlanflexiLocale.findByFlexiMinutesPulse", query = "SELECT p FROM PlansPlanflexiLocale p WHERE p.flexiMinutesPulse = :flexiMinutesPulse")
    , @NamedQuery(name = "PlansPlanflexiLocale.findByCreationDatetime", query = "SELECT p FROM PlansPlanflexiLocale p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlanflexiLocale.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlanflexiLocale p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlanflexiLocale.findByIsActive", query = "SELECT p FROM PlansPlanflexiLocale p WHERE p.isActive = :isActive")})
public class PlansPlanflexiLocale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "plan_primary_id")
    private int planPrimaryId;
    @Column(name = "locale")
    private String locale;
    @Column(name = "flexi_minutes_pulse")
    private String flexiMinutesPulse;
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

    public PlansPlanflexiLocale() {
    }

    public PlansPlanflexiLocale(Integer id) {
        this.id = id;
    }

    public PlansPlanflexiLocale(Integer id, int planPrimaryId, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.planPrimaryId = planPrimaryId;
        this.creationDatetime = creationDatetime;
        this.isActive = isActive;
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

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getFlexiMinutesPulse() {
        return flexiMinutesPulse;
    }

    public void setFlexiMinutesPulse(String flexiMinutesPulse) {
        this.flexiMinutesPulse = flexiMinutesPulse;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlansPlanflexiLocale)) {
            return false;
        }
        PlansPlanflexiLocale other = (PlansPlanflexiLocale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanflexiLocale[ id=" + id + " ]";
    }
    
}
