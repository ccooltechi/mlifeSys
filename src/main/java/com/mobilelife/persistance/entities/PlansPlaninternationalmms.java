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
@Table(name = "plans_planinternationalmms", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlaninternationalmms.findAll", query = "SELECT p FROM PlansPlaninternationalmms p")
    , @NamedQuery(name = "PlansPlaninternationalmms.findById", query = "SELECT p FROM PlansPlaninternationalmms p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlaninternationalmms.findByInternationalMms", query = "SELECT p FROM PlansPlaninternationalmms p WHERE p.internationalMms = :internationalMms")
    , @NamedQuery(name = "PlansPlaninternationalmms.findByInternationalMmsUnitrate", query = "SELECT p FROM PlansPlaninternationalmms p WHERE p.internationalMmsUnitrate = :internationalMmsUnitrate")
    , @NamedQuery(name = "PlansPlaninternationalmms.findByCreationDatetime", query = "SELECT p FROM PlansPlaninternationalmms p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlaninternationalmms.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlaninternationalmms p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlaninternationalmms.findByIsActive", query = "SELECT p FROM PlansPlaninternationalmms p WHERE p.isActive = :isActive")})
public class PlansPlaninternationalmms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "international_mms")
    private Integer internationalMms;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "international_mms_unitrate")
    private Double internationalMmsUnitrate;
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

    public PlansPlaninternationalmms() {
    }

    public PlansPlaninternationalmms(Integer id) {
        this.id = id;
    }

    public PlansPlaninternationalmms(Integer id, Date creationDatetime, boolean isActive) {
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

    public Integer getInternationalMms() {
        return internationalMms;
    }

    public void setInternationalMms(Integer internationalMms) {
        this.internationalMms = internationalMms;
    }

    public Double getInternationalMmsUnitrate() {
        return internationalMmsUnitrate;
    }

    public void setInternationalMmsUnitrate(Double internationalMmsUnitrate) {
        this.internationalMmsUnitrate = internationalMmsUnitrate;
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
        if (!(object instanceof PlansPlaninternationalmms)) {
            return false;
        }
        PlansPlaninternationalmms other = (PlansPlaninternationalmms) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlaninternationalmms[ id=" + id + " ]";
    }
    
}
