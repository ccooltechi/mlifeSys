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
@Table(name = "plans_plannationalminutes_locale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlannationalminutesLocale.findAll", query = "SELECT p FROM PlansPlannationalminutesLocale p")
    , @NamedQuery(name = "PlansPlannationalminutesLocale.findById", query = "SELECT p FROM PlansPlannationalminutesLocale p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlannationalminutesLocale.findByPlanPrimaryId", query = "SELECT p FROM PlansPlannationalminutesLocale p WHERE p.planPrimaryId = :planPrimaryId")
    , @NamedQuery(name = "PlansPlannationalminutesLocale.findByLocale", query = "SELECT p FROM PlansPlannationalminutesLocale p WHERE p.locale = :locale")
    , @NamedQuery(name = "PlansPlannationalminutesLocale.findByNationalMinutePulse", query = "SELECT p FROM PlansPlannationalminutesLocale p WHERE p.nationalMinutePulse = :nationalMinutePulse")
    , @NamedQuery(name = "PlansPlannationalminutesLocale.findByCreationDatetime", query = "SELECT p FROM PlansPlannationalminutesLocale p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlannationalminutesLocale.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlannationalminutesLocale p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlannationalminutesLocale.findByIsActive", query = "SELECT p FROM PlansPlannationalminutesLocale p WHERE p.isActive = :isActive")})
public class PlansPlannationalminutesLocale implements Serializable {

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
    @Column(name = "national_minute_pulse")
    private String nationalMinutePulse;
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

    public PlansPlannationalminutesLocale() {
    }

    public PlansPlannationalminutesLocale(Integer id) {
        this.id = id;
    }

    public PlansPlannationalminutesLocale(Integer id, int planPrimaryId, Date creationDatetime, boolean isActive) {
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

    public String getNationalMinutePulse() {
        return nationalMinutePulse;
    }

    public void setNationalMinutePulse(String nationalMinutePulse) {
        this.nationalMinutePulse = nationalMinutePulse;
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
        if (!(object instanceof PlansPlannationalminutesLocale)) {
            return false;
        }
        PlansPlannationalminutesLocale other = (PlansPlannationalminutesLocale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlannationalminutesLocale[ id=" + id + " ]";
    }
    
}
