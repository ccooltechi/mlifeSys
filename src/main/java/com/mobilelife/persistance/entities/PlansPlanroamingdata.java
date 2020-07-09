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
 * @author pods
 */
@Entity
@Table(name = "plans_planroamingdata", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlanroamingdata.findAll", query = "SELECT p FROM PlansPlanroamingdata p")
    , @NamedQuery(name = "PlansPlanroamingdata.findById", query = "SELECT p FROM PlansPlanroamingdata p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlanroamingdata.findByDataRoamingGb", query = "SELECT p FROM PlansPlanroamingdata p WHERE p.dataRoamingGb = :dataRoamingGb")
    , @NamedQuery(name = "PlansPlanroamingdata.findByDataRoamingRollOverGb", query = "SELECT p FROM PlansPlanroamingdata p WHERE p.dataRoamingRollOverGb = :dataRoamingRollOverGb")
    , @NamedQuery(name = "PlansPlanroamingdata.findByDataRoamingBucketcode", query = "SELECT p FROM PlansPlanroamingdata p WHERE p.dataRoamingBucketcode = :dataRoamingBucketcode")
    , @NamedQuery(name = "PlansPlanroamingdata.findByCreationDatetime", query = "SELECT p FROM PlansPlanroamingdata p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlanroamingdata.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlanroamingdata p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlanroamingdata.findByIsActive", query = "SELECT p FROM PlansPlanroamingdata p WHERE p.isActive = :isActive")})
public class PlansPlanroamingdata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_roaming_gb")
    private Integer dataRoamingGb;
    @Column(name = "data_roaming_roll_over_gb")
    private Integer dataRoamingRollOverGb;
    @Column(name = "data_roaming_bucketcode")
    private String dataRoamingBucketcode;
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

    public PlansPlanroamingdata() {
    }

    public PlansPlanroamingdata(Integer id) {
        this.id = id;
    }

    public PlansPlanroamingdata(Integer id, Date creationDatetime, boolean isActive) {
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

    public Integer getDataRoamingGb() {
        return dataRoamingGb;
    }

    public void setDataRoamingGb(Integer dataRoamingGb) {
        this.dataRoamingGb = dataRoamingGb;
    }

    public Integer getDataRoamingRollOverGb() {
        return dataRoamingRollOverGb;
    }

    public void setDataRoamingRollOverGb(Integer dataRoamingRollOverGb) {
        this.dataRoamingRollOverGb = dataRoamingRollOverGb;
    }

    public String getDataRoamingBucketcode() {
        return dataRoamingBucketcode;
    }

    public void setDataRoamingBucketcode(String dataRoamingBucketcode) {
        this.dataRoamingBucketcode = dataRoamingBucketcode;
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
        if (!(object instanceof PlansPlanroamingdata)) {
            return false;
        }
        PlansPlanroamingdata other = (PlansPlanroamingdata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanroamingdata[ id=" + id + " ]";
    }
    
}
