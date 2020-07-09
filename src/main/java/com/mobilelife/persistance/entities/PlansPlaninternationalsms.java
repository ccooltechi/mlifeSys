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
@Table(name = "plans_planinternationalsms", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlaninternationalsms.findAll", query = "SELECT p FROM PlansPlaninternationalsms p")
    , @NamedQuery(name = "PlansPlaninternationalsms.findById", query = "SELECT p FROM PlansPlaninternationalsms p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlaninternationalsms.findByInternationalSms", query = "SELECT p FROM PlansPlaninternationalsms p WHERE p.internationalSms = :internationalSms")
    , @NamedQuery(name = "PlansPlaninternationalsms.findByInternationalSmsBucketcode", query = "SELECT p FROM PlansPlaninternationalsms p WHERE p.internationalSmsBucketcode = :internationalSmsBucketcode")
    , @NamedQuery(name = "PlansPlaninternationalsms.findByCreationDatetime", query = "SELECT p FROM PlansPlaninternationalsms p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlaninternationalsms.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlaninternationalsms p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlaninternationalsms.findByIsActive", query = "SELECT p FROM PlansPlaninternationalsms p WHERE p.isActive = :isActive")})
public class PlansPlaninternationalsms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "international_sms")
    private Integer internationalSms;
    @Column(name = "international_sms_bucketcode")
    private String internationalSmsBucketcode;
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

    public PlansPlaninternationalsms() {
    }

    public PlansPlaninternationalsms(Integer id) {
        this.id = id;
    }

    public PlansPlaninternationalsms(Integer id, Date creationDatetime, boolean isActive) {
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

    public Integer getInternationalSms() {
        return internationalSms;
    }

    public void setInternationalSms(Integer internationalSms) {
        this.internationalSms = internationalSms;
    }

    public String getInternationalSmsBucketcode() {
        return internationalSmsBucketcode;
    }

    public void setInternationalSmsBucketcode(String internationalSmsBucketcode) {
        this.internationalSmsBucketcode = internationalSmsBucketcode;
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
        if (!(object instanceof PlansPlaninternationalsms)) {
            return false;
        }
        PlansPlaninternationalsms other = (PlansPlaninternationalsms) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlaninternationalsms[ id=" + id + " ]";
    }
    
}
