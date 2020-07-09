/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.controler.mapper.bean;

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

public class PlansPlanoutofbundleBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Double outOfBundleRateNationalMins;
    private Double outOfBundleRateNationalOnnetMins;
    private Double outOfBundleRateNationalOffnetMins;
    private String outOfBundleRateInternationalMinsBucketcode;
    private Double outofbundleratenationaldataMb;
    private Double outOfBundleRateNationalSms;
    private Double outOfBundleRateInternationalSms;
    private Double outOfBundleRateNationalOnnetSms;
    private Double outOfBundleRateNationalOffnetSms;
    private Double outOfBundleRateNationalMms;
    private Double outOfBundleRateInternationalMms;
    private boolean isActive;
    private Integer planPrimaryId;

    public PlansPlanoutofbundleBean() {
    }

    public PlansPlanoutofbundleBean(Integer id) {
        this.id = id;
    }

    public PlansPlanoutofbundleBean(Integer id, Date creationDatetime, boolean isActive) {
        this.id = id;
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

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getPlanPrimaryId() {
        return planPrimaryId;
    }

    public void setPlanPrimaryId(Integer planPrimaryId) {
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
        if (!(object instanceof PlansPlanoutofbundleBean)) {
            return false;
        }
        PlansPlanoutofbundleBean other = (PlansPlanoutofbundleBean) object;
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
