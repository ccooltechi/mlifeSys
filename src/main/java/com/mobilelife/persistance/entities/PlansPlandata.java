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
@Table(name = "plans_plandata", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlandata.findAll", query = "SELECT p FROM PlansPlandata p")
    , @NamedQuery(name = "PlansPlandata.findById", query = "SELECT p FROM PlansPlandata p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlandata.findByRoamingData", query = "SELECT p FROM PlansPlandata p WHERE p.roamingData = :roamingData")
    , @NamedQuery(name = "PlansPlandata.findByDataSpeed", query = "SELECT p FROM PlansPlandata p WHERE p.dataSpeed = :dataSpeed")
    , @NamedQuery(name = "PlansPlandata.findByCreationDatetime", query = "SELECT p FROM PlansPlandata p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlandata.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlandata p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlandata.findByIsActive", query = "SELECT p FROM PlansPlandata p WHERE p.isActive = :isActive")})
public class PlansPlandata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "roaming_data")
    private Integer roamingData;
    @Column(name = "data_speed")
    private Integer dataSpeed;
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

    @Column(name = "national_gb_pulse")
    private Integer nationalGbPulse;
    @Column(name = "national_gb_pluse_unit")
    private String nationalGbPluseUnit;

    public PlansPlandata() {
    }

    public PlansPlandata(Integer id) {
        this.id = id;
    }

    public PlansPlandata(Integer id, Date creationDatetime, boolean isActive) {
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

    public Integer getRoamingData() {
        return roamingData;
    }

    public void setRoamingData(Integer roamingData) {
        this.roamingData = roamingData;
    }

    public Integer getDataSpeed() {
        return dataSpeed;
    }

    public void setDataSpeed(Integer dataSpeed) {
        this.dataSpeed = dataSpeed;
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
    
    public Integer getNationalGbPulse() {
		return nationalGbPulse;
	}

	public void setNationalGbPulse(Integer nationalGbPulse) {
		this.nationalGbPulse = nationalGbPulse;
	}

	public String getNationalGbPluseUnit() {
		return nationalGbPluseUnit;
	}

	public void setNationalGbPluseUnit(String nationalGbPluseUnit) {
		this.nationalGbPluseUnit = nationalGbPluseUnit;
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
        if (!(object instanceof PlansPlandata)) {
            return false;
        }
        PlansPlandata other = (PlansPlandata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlandata[ id=" + id + " ]";
    }
    
}
