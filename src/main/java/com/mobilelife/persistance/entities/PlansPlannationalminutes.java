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
@Table(name = "plans_plannationalminutes", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlannationalminutes.findAll", query = "SELECT p FROM PlansPlannationalminutes p")
    , @NamedQuery(name = "PlansPlannationalminutes.findById", query = "SELECT p FROM PlansPlannationalminutes p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlannationalminutes.findByNationalMinutes", query = "SELECT p FROM PlansPlannationalminutes p WHERE p.nationalMinutes = :nationalMinutes")
    , @NamedQuery(name = "PlansPlannationalminutes.findByNationalMinutePulse", query = "SELECT p FROM PlansPlannationalminutes p WHERE p.nationalMinutePulse = :nationalMinutePulse")
    , @NamedQuery(name = "PlansPlannationalminutes.findByNationalMinutesUnitrate", query = "SELECT p FROM PlansPlannationalminutes p WHERE p.nationalMinutesUnitrate = :nationalMinutesUnitrate")
    , @NamedQuery(name = "PlansPlannationalminutes.findByCreationDatetime", query = "SELECT p FROM PlansPlannationalminutes p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlannationalminutes.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlannationalminutes p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlannationalminutes.findByIsActive", query = "SELECT p FROM PlansPlannationalminutes p WHERE p.isActive = :isActive")})
public class PlansPlannationalminutes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "national_minutes")
    private Integer nationalMinutes;
    @Column(name = "national_minute_pulse")
    private String nationalMinutePulse;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "national_minutes_unitrate")
    private Double nationalMinutesUnitrate;
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

    @Column(name = "national_minutes_was")
    private Integer nationalMinutesWas;
    @Column(name = "national_minutes_discount")
    private Integer nationalMinutesDiscount;

    public PlansPlannationalminutes() {
    }

    public PlansPlannationalminutes(Integer id) {
        this.id = id;
    }

    public PlansPlannationalminutes(Integer id, Date creationDatetime, boolean isActive) {
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

    public Integer getNationalMinutes() {
        return nationalMinutes;
    }

    public void setNationalMinutes(Integer nationalMinutes) {
        this.nationalMinutes = nationalMinutes;
    }

    public String getNationalMinutePulse() {
        return nationalMinutePulse;
    }

    public void setNationalMinutePulse(String nationalMinutePulse) {
        this.nationalMinutePulse = nationalMinutePulse;
    }

    public Double getNationalMinutesUnitrate() {
        return nationalMinutesUnitrate;
    }

    public void setNationalMinutesUnitrate(Double nationalMinutesUnitrate) {
        this.nationalMinutesUnitrate = nationalMinutesUnitrate;
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

    
    public Integer getNationalMinutesWas() {
		return nationalMinutesWas;
	}

	public void setNationalMinutesWas(Integer nationalMinutesWas) {
		this.nationalMinutesWas = nationalMinutesWas;
	}

	public Integer getNationalMinutesDiscount() {
		return nationalMinutesDiscount;
	}

	public void setNationalMinutesDiscount(Integer nationalMinutesDiscount) {
		this.nationalMinutesDiscount = nationalMinutesDiscount;
	}

	public PlansPlanprimary getPlanPrimaryId() {
        return planPrimaryId;
    }

    public void setPlanPrimaryId(PlansPlanprimary planPrimaryId) {
        this.planPrimaryId = planPrimaryId;
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
        if (!(object instanceof PlansPlannationalminutes)) {
            return false;
        }
        PlansPlannationalminutes other = (PlansPlannationalminutes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlannationalminutes[ id=" + id + " ]";
    }
    
}
