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
@Table(name = "plans_plannationaldata", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlannationaldata.findAll", query = "SELECT p FROM PlansPlannationaldata p")
    , @NamedQuery(name = "PlansPlannationaldata.findById", query = "SELECT p FROM PlansPlannationaldata p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlannationaldata.findByDataNationalGb", query = "SELECT p FROM PlansPlannationaldata p WHERE p.dataNationalGb = :dataNationalGb")
    , @NamedQuery(name = "PlansPlannationaldata.findByDataNationalRollOverGb", query = "SELECT p FROM PlansPlannationaldata p WHERE p.dataNationalRollOverGb = :dataNationalRollOverGb")
    , @NamedQuery(name = "PlansPlannationaldata.findByDataNationalGbUnitrate", query = "SELECT p FROM PlansPlannationaldata p WHERE p.dataNationalGbUnitrate = :dataNationalGbUnitrate")
    , @NamedQuery(name = "PlansPlannationaldata.findByCreationDatetime", query = "SELECT p FROM PlansPlannationaldata p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlannationaldata.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlannationaldata p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlannationaldata.findByIsActive", query = "SELECT p FROM PlansPlannationaldata p WHERE p.isActive = :isActive")})
public class PlansPlannationaldata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "data_national_gb")
    private Double dataNationalGb;
    @Column(name = "data_national_roll_over_gb")
    private Integer dataNationalRollOverGb;
    @Column(name = "data_national_gb_unitrate")
    private Double dataNationalGbUnitrate;
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
    @Column(name = "data_national_gb_was")
    private Double dataNationalGbWas;
    @Column(name = "data_national_gb_discount")
    private Double dataNationalGbDiscount;

    public PlansPlannationaldata() {
    }

    public PlansPlannationaldata(Integer id) {
        this.id = id;
    }

    public PlansPlannationaldata(Integer id, Date creationDatetime, boolean isActive) {
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

    public Double getDataNationalGb() {
        return dataNationalGb;
    }

    public void setDataNationalGb(Double dataNationalGb) {
        this.dataNationalGb = dataNationalGb;
    }

    public Integer getDataNationalRollOverGb() {
        return dataNationalRollOverGb;
    }

    public void setDataNationalRollOverGb(Integer dataNationalRollOverGb) {
        this.dataNationalRollOverGb = dataNationalRollOverGb;
    }

    public Double getDataNationalGbUnitrate() {
        return dataNationalGbUnitrate;
    }

    public void setDataNationalGbUnitrate(Double dataNationalGbUnitrate) {
        this.dataNationalGbUnitrate = dataNationalGbUnitrate;
    }
    

    public Double getDataNationalGbWas() {
		return dataNationalGbWas;
	}

	public void setDataNationalGbWas(Double dataNationalGbWas) {
		this.dataNationalGbWas = dataNationalGbWas;
	}

	public Double getDataNationalGbDiscount() {
		return dataNationalGbDiscount;
	}

	public void setDataNationalGbDiscount(Double dataNationalGbDiscount) {
		this.dataNationalGbDiscount = dataNationalGbDiscount;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlansPlannationaldata)) {
            return false;
        }
        PlansPlannationaldata other = (PlansPlannationaldata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlannationaldata[ id=" + id + " ]";
    }
    
}
