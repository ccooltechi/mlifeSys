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
@Table(name = "plans_planspecialminutes_locale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlanspecialminutesLocale.findAll", query = "SELECT p FROM PlansPlanspecialminutesLocale p")
    , @NamedQuery(name = "PlansPlanspecialminutesLocale.findById", query = "SELECT p FROM PlansPlanspecialminutesLocale p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlanspecialminutesLocale.findByPlanPrimaryId", query = "SELECT p FROM PlansPlanspecialminutesLocale p WHERE p.planPrimaryId = :planPrimaryId")
    , @NamedQuery(name = "PlansPlanspecialminutesLocale.findByLocale", query = "SELECT p FROM PlansPlanspecialminutesLocale p WHERE p.locale = :locale")
    , @NamedQuery(name = "PlansPlanspecialminutesLocale.findBySpecialMinutesDescription", query = "SELECT p FROM PlansPlanspecialminutesLocale p WHERE p.specialMinutesDescription = :specialMinutesDescription")
    , @NamedQuery(name = "PlansPlanspecialminutesLocale.findByCreationDatetime", query = "SELECT p FROM PlansPlanspecialminutesLocale p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlanspecialminutesLocale.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlanspecialminutesLocale p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlanspecialminutesLocale.findByIsActive", query = "SELECT p FROM PlansPlanspecialminutesLocale p WHERE p.isActive = :isActive")})
public class PlansPlanspecialminutesLocale implements Serializable {

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
    @Column(name = "special_minutes_description")
    private String specialMinutesDescription;
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

    public PlansPlanspecialminutesLocale() {
    }

    public PlansPlanspecialminutesLocale(Integer id) {
        this.id = id;
    }

    public PlansPlanspecialminutesLocale(Integer id, int planPrimaryId, Date creationDatetime, boolean isActive) {
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

    public String getSpecialMinutesDescription() {
        return specialMinutesDescription;
    }

    public void setSpecialMinutesDescription(String specialMinutesDescription) {
        this.specialMinutesDescription = specialMinutesDescription;
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
        if (!(object instanceof PlansPlanspecialminutesLocale)) {
            return false;
        }
        PlansPlanspecialminutesLocale other = (PlansPlanspecialminutesLocale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanspecialminutesLocale[ id=" + id + " ]";
    }
    
}
