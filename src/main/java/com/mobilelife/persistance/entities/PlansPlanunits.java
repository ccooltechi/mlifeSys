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
@Table(name = "plans_planunits", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlanunits.findAll", query = "SELECT p FROM PlansPlanunits p")
    , @NamedQuery(name = "PlansPlanunits.findById", query = "SELECT p FROM PlansPlanunits p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlanunits.findByUnits", query = "SELECT p FROM PlansPlanunits p WHERE p.units = :units")
    , @NamedQuery(name = "PlansPlanunits.findByUnitsLabel", query = "SELECT p FROM PlansPlanunits p WHERE p.unitsLabel = :unitsLabel")
    , @NamedQuery(name = "PlansPlanunits.findByUnitsRollover", query = "SELECT p FROM PlansPlanunits p WHERE p.unitsRollover = :unitsRollover")
    , @NamedQuery(name = "PlansPlanunits.findByCreationDatetime", query = "SELECT p FROM PlansPlanunits p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlanunits.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlanunits p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlanunits.findByIsActive", query = "SELECT p FROM PlansPlanunits p WHERE p.isActive = :isActive")})
public class PlansPlanunits implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "units")
    private Integer units;
    @Column(name = "units_label")
    private String unitsLabel;
    @Column(name = "units_rollover")
    private Integer unitsRollover;
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

    public PlansPlanunits() {
    }

    public PlansPlanunits(Integer id) {
        this.id = id;
    }

    public PlansPlanunits(Integer id, Date creationDatetime, boolean isActive) {
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

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public String getUnitsLabel() {
        return unitsLabel;
    }

    public void setUnitsLabel(String unitsLabel) {
        this.unitsLabel = unitsLabel;
    }

    public Integer getUnitsRollover() {
        return unitsRollover;
    }

    public void setUnitsRollover(Integer unitsRollover) {
        this.unitsRollover = unitsRollover;
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
        if (!(object instanceof PlansPlanunits)) {
            return false;
        }
        PlansPlanunits other = (PlansPlanunits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanunits[ id=" + id + " ]";
    }
    
}
