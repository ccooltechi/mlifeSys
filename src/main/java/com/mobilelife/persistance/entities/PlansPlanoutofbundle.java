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
@Table(name = "plans_planoutofbundle", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlanoutofbundle.findAll", query = "SELECT p FROM PlansPlanoutofbundle p")
    , @NamedQuery(name = "PlansPlanoutofbundle.findById", query = "SELECT p FROM PlansPlanoutofbundle p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlanoutofbundle.findByOutOfBundleRateNationalMins", query = "SELECT p FROM PlansPlanoutofbundle p WHERE p.outOfBundleRateNationalMins = :outOfBundleRateNationalMins")
    , @NamedQuery(name = "PlansPlanoutofbundle.findByOutOfBundleRateNationalOnnetMins", query = "SELECT p FROM PlansPlanoutofbundle p WHERE p.outOfBundleRateNationalOnnetMins = :outOfBundleRateNationalOnnetMins")
    , @NamedQuery(name = "PlansPlanoutofbundle.findByOutOfBundleRateNationalOffnetMins", query = "SELECT p FROM PlansPlanoutofbundle p WHERE p.outOfBundleRateNationalOffnetMins = :outOfBundleRateNationalOffnetMins")
    , @NamedQuery(name = "PlansPlanoutofbundle.findByOutOfBundleRateInternationalMinsBucketcode", query = "SELECT p FROM PlansPlanoutofbundle p WHERE p.outOfBundleRateInternationalMinsBucketcode = :outOfBundleRateInternationalMinsBucketcode")
    , @NamedQuery(name = "PlansPlanoutofbundle.findByOutofbundleratenationaldataMb", query = "SELECT p FROM PlansPlanoutofbundle p WHERE p.outofbundleratenationaldataMb = :outofbundleratenationaldataMb")
    , @NamedQuery(name = "PlansPlanoutofbundle.findByOutOfBundleRateNationalSms", query = "SELECT p FROM PlansPlanoutofbundle p WHERE p.outOfBundleRateNationalSms = :outOfBundleRateNationalSms")
    , @NamedQuery(name = "PlansPlanoutofbundle.findByOutOfBundleRateInternationalSms", query = "SELECT p FROM PlansPlanoutofbundle p WHERE p.outOfBundleRateInternationalSms = :outOfBundleRateInternationalSms")
    , @NamedQuery(name = "PlansPlanoutofbundle.findByOutOfBundleRateNationalOnnetSms", query = "SELECT p FROM PlansPlanoutofbundle p WHERE p.outOfBundleRateNationalOnnetSms = :outOfBundleRateNationalOnnetSms")
    , @NamedQuery(name = "PlansPlanoutofbundle.findByOutOfBundleRateNationalOffnetSms", query = "SELECT p FROM PlansPlanoutofbundle p WHERE p.outOfBundleRateNationalOffnetSms = :outOfBundleRateNationalOffnetSms")
    , @NamedQuery(name = "PlansPlanoutofbundle.findByOutOfBundleRateNationalMms", query = "SELECT p FROM PlansPlanoutofbundle p WHERE p.outOfBundleRateNationalMms = :outOfBundleRateNationalMms")
    , @NamedQuery(name = "PlansPlanoutofbundle.findByOutOfBundleRateInternationalMms", query = "SELECT p FROM PlansPlanoutofbundle p WHERE p.outOfBundleRateInternationalMms = :outOfBundleRateInternationalMms")
    , @NamedQuery(name = "PlansPlanoutofbundle.findByCreationDatetime", query = "SELECT p FROM PlansPlanoutofbundle p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlanoutofbundle.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlanoutofbundle p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlanoutofbundle.findByIsActive", query = "SELECT p FROM PlansPlanoutofbundle p WHERE p.isActive = :isActive")})
public class PlansPlanoutofbundle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "out_of_bundle_rate_national_mins")
    private Double outOfBundleRateNationalMins;
    @Column(name = "out_of_bundle_rate_national_onnet_mins")
    private Double outOfBundleRateNationalOnnetMins;
    @Column(name = "out_of_bundle_rate_national_offnet_mins")
    private Double outOfBundleRateNationalOffnetMins;
    @Column(name = "out_of_bundle_rate_international_mins_bucketcode")
    private String outOfBundleRateInternationalMinsBucketcode;
    @Column(name = "out_of_bundle_rate_national_data_Mb")
    private Double outofbundleratenationaldataMb;
    @Column(name = "out_of_bundle_rate_national_sms")
    private Double outOfBundleRateNationalSms;
    @Column(name = "out_of_bundle_rate_international_sms")
    private Double outOfBundleRateInternationalSms;
    @Column(name = "out_of_bundle_rate_national_onnet_sms")
    private Double outOfBundleRateNationalOnnetSms;
    @Column(name = "out_of_bundle_rate_national_offnet_sms")
    private Double outOfBundleRateNationalOffnetSms;
    @Column(name = "out_of_bundle_rate_national_mms")
    private Double outOfBundleRateNationalMms;
    @Column(name = "out_of_bundle_rate_international_mms")
    private Double outOfBundleRateInternationalMms;
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

    public PlansPlanoutofbundle() {
    }

    public PlansPlanoutofbundle(Integer id) {
        this.id = id;
    }

    public PlansPlanoutofbundle(Integer id, Date creationDatetime, boolean isActive) {
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

    public Double getOutOfBundleRateNationalMins() {
        return outOfBundleRateNationalMins;
    }

    public void setOutOfBundleRateNationalMins(Double outOfBundleRateNationalMins) {
        this.outOfBundleRateNationalMins = outOfBundleRateNationalMins;
    }

    public Double getOutOfBundleRateNationalOnnetMins() {
        return outOfBundleRateNationalOnnetMins;
    }

    public void setOutOfBundleRateNationalOnnetMins(Double outOfBundleRateNationalOnnetMins) {
        this.outOfBundleRateNationalOnnetMins = outOfBundleRateNationalOnnetMins;
    }

    public Double getOutOfBundleRateNationalOffnetMins() {
        return outOfBundleRateNationalOffnetMins;
    }

    public void setOutOfBundleRateNationalOffnetMins(Double outOfBundleRateNationalOffnetMins) {
        this.outOfBundleRateNationalOffnetMins = outOfBundleRateNationalOffnetMins;
    }

    public String getOutOfBundleRateInternationalMinsBucketcode() {
        return outOfBundleRateInternationalMinsBucketcode;
    }

    public void setOutOfBundleRateInternationalMinsBucketcode(String outOfBundleRateInternationalMinsBucketcode) {
        this.outOfBundleRateInternationalMinsBucketcode = outOfBundleRateInternationalMinsBucketcode;
    }

    public Double getOutofbundleratenationaldataMb() {
        return outofbundleratenationaldataMb;
    }

    public void setOutofbundleratenationaldataMb(Double outofbundleratenationaldataMb) {
        this.outofbundleratenationaldataMb = outofbundleratenationaldataMb;
    }

    public Double getOutOfBundleRateNationalSms() {
        return outOfBundleRateNationalSms;
    }

    public void setOutOfBundleRateNationalSms(Double outOfBundleRateNationalSms) {
        this.outOfBundleRateNationalSms = outOfBundleRateNationalSms;
    }

    public Double getOutOfBundleRateInternationalSms() {
        return outOfBundleRateInternationalSms;
    }

    public void setOutOfBundleRateInternationalSms(Double outOfBundleRateInternationalSms) {
        this.outOfBundleRateInternationalSms = outOfBundleRateInternationalSms;
    }

    public Double getOutOfBundleRateNationalOnnetSms() {
        return outOfBundleRateNationalOnnetSms;
    }

    public void setOutOfBundleRateNationalOnnetSms(Double outOfBundleRateNationalOnnetSms) {
        this.outOfBundleRateNationalOnnetSms = outOfBundleRateNationalOnnetSms;
    }

    public Double getOutOfBundleRateNationalOffnetSms() {
        return outOfBundleRateNationalOffnetSms;
    }

    public void setOutOfBundleRateNationalOffnetSms(Double outOfBundleRateNationalOffnetSms) {
        this.outOfBundleRateNationalOffnetSms = outOfBundleRateNationalOffnetSms;
    }

    public Double getOutOfBundleRateNationalMms() {
        return outOfBundleRateNationalMms;
    }

    public void setOutOfBundleRateNationalMms(Double outOfBundleRateNationalMms) {
        this.outOfBundleRateNationalMms = outOfBundleRateNationalMms;
    }

    public Double getOutOfBundleRateInternationalMms() {
        return outOfBundleRateInternationalMms;
    }

    public void setOutOfBundleRateInternationalMms(Double outOfBundleRateInternationalMms) {
        this.outOfBundleRateInternationalMms = outOfBundleRateInternationalMms;
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
        if (!(object instanceof PlansPlanoutofbundle)) {
            return false;
        }
        PlansPlanoutofbundle other = (PlansPlanoutofbundle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanoutofbundle[ id=" + id + " ]";
    }
    
}
