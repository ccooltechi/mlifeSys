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
@Table(name = "plans_planroamingincomingmins_locale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlanroamingincomingminsLocale.findAll", query = "SELECT p FROM PlansPlanroamingincomingminsLocale p")
    , @NamedQuery(name = "PlansPlanroamingincomingminsLocale.findById", query = "SELECT p FROM PlansPlanroamingincomingminsLocale p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlanroamingincomingminsLocale.findByPlanPrimaryId", query = "SELECT p FROM PlansPlanroamingincomingminsLocale p WHERE p.planPrimaryId = :planPrimaryId")
    , @NamedQuery(name = "PlansPlanroamingincomingminsLocale.findByLocale", query = "SELECT p FROM PlansPlanroamingincomingminsLocale p WHERE p.locale = :locale")
    , @NamedQuery(name = "PlansPlanroamingincomingminsLocale.findByRoamingIncomingBucketcode", query = "SELECT p FROM PlansPlanroamingincomingminsLocale p WHERE p.roamingIncomingBucketcode = :roamingIncomingBucketcode")
    , @NamedQuery(name = "PlansPlanroamingincomingminsLocale.findByCreationDatetime", query = "SELECT p FROM PlansPlanroamingincomingminsLocale p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlanroamingincomingminsLocale.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlanroamingincomingminsLocale p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlanroamingincomingminsLocale.findByIsActive", query = "SELECT p FROM PlansPlanroamingincomingminsLocale p WHERE p.isActive = :isActive")})
public class PlansPlanroamingincomingminsLocale implements Serializable {

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
    @Column(name = "roaming_incoming_bucketcode")
    private String roamingIncomingBucketcode;
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

    public PlansPlanroamingincomingminsLocale() {
    }

    public PlansPlanroamingincomingminsLocale(Integer id) {
        this.id = id;
    }

    public PlansPlanroamingincomingminsLocale(Integer id, int planPrimaryId, Date creationDatetime, boolean isActive) {
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

    public String getRoamingIncomingBucketcode() {
        return roamingIncomingBucketcode;
    }

    public void setRoamingIncomingBucketcode(String roamingIncomingBucketcode) {
        this.roamingIncomingBucketcode = roamingIncomingBucketcode;
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
        if (!(object instanceof PlansPlanroamingincomingminsLocale)) {
            return false;
        }
        PlansPlanroamingincomingminsLocale other = (PlansPlanroamingincomingminsLocale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanroamingincomingminsLocale[ id=" + id + " ]";
    }
    
}
