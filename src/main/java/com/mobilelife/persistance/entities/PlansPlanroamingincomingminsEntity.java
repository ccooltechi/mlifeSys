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
@Table(name = "plans_planroamingincomingmins", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlanroamingincomingminsEntity.findAll", query = "SELECT p FROM PlansPlanroamingincomingminsEntity p")
    , @NamedQuery(name = "PlansPlanroamingincomingminsEntity.findById", query = "SELECT p FROM PlansPlanroamingincomingminsEntity p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlanroamingincomingminsEntity.findByRoamingIncomingMins", query = "SELECT p FROM PlansPlanroamingincomingminsEntity p WHERE p.roamingIncomingMins = :roamingIncomingMins")
    , @NamedQuery(name = "PlansPlanroamingincomingminsEntity.findByRoamingIncomingBucketcode", query = "SELECT p FROM PlansPlanroamingincomingminsEntity p WHERE p.roamingIncomingBucketcode = :roamingIncomingBucketcode")
    , @NamedQuery(name = "PlansPlanroamingincomingminsEntity.findByCreationDatetime", query = "SELECT p FROM PlansPlanroamingincomingminsEntity p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlanroamingincomingminsEntity.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlanroamingincomingminsEntity p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlanroamingincomingminsEntity.findByIsActive", query = "SELECT p FROM PlansPlanroamingincomingminsEntity p WHERE p.isActive = :isActive")})
public class PlansPlanroamingincomingminsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "roaming_incoming_mins")
    private Integer roamingIncomingMins;
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
    @JoinColumn(name = "plan_primary_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private PlansPlanprimaryEntity planPrimaryId;

    public PlansPlanroamingincomingminsEntity() {
    }

    public PlansPlanroamingincomingminsEntity(Integer id) {
        this.id = id;
    }

    public PlansPlanroamingincomingminsEntity(Integer id, Date creationDatetime, boolean isActive) {
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

    public Integer getRoamingIncomingMins() {
        return roamingIncomingMins;
    }

    public void setRoamingIncomingMins(Integer roamingIncomingMins) {
        this.roamingIncomingMins = roamingIncomingMins;
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

    public PlansPlanprimaryEntity getPlanPrimaryId() {
        return planPrimaryId;
    }

    public void setPlanPrimaryId(PlansPlanprimaryEntity planPrimaryId) {
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
        if (!(object instanceof PlansPlanroamingincomingminsEntity)) {
            return false;
        }
        PlansPlanroamingincomingminsEntity other = (PlansPlanroamingincomingminsEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanroamingincomingmins[ id=" + id + " ]";
    }
    
}
