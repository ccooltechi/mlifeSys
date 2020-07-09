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
import javax.persistence.Lob;
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
@Table(name = "plans_planmiscellaneous_locale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlanmiscellaneousLocale.findAll", query = "SELECT p FROM PlansPlanmiscellaneousLocale p")
    , @NamedQuery(name = "PlansPlanmiscellaneousLocale.findById", query = "SELECT p FROM PlansPlanmiscellaneousLocale p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlanmiscellaneousLocale.findByPlanPrimaryId", query = "SELECT p FROM PlansPlanmiscellaneousLocale p WHERE p.planPrimaryId = :planPrimaryId")
    , @NamedQuery(name = "PlansPlanmiscellaneousLocale.findByLocale", query = "SELECT p FROM PlansPlanmiscellaneousLocale p WHERE p.locale = :locale")
    , @NamedQuery(name = "PlansPlanmiscellaneousLocale.findByCreationDatetime", query = "SELECT p FROM PlansPlanmiscellaneousLocale p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlanmiscellaneousLocale.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlanmiscellaneousLocale p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlanmiscellaneousLocale.findByIsActive", query = "SELECT p FROM PlansPlanmiscellaneousLocale p WHERE p.isActive = :isActive")})
public class PlansPlanmiscellaneousLocale implements Serializable {

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
    @Lob
    @Column(name = "sim_activation_info")
    private String simActivationInfo;
    @Lob
    @Column(name = "added_benefits_info")
    private String addedBenefitsInfo;
    @Lob
    @Column(name = "optional_benefits_info")
    private String optionalBenefitsInfo;
    @Lob
    @Column(name = "plan_activation_info")
    private String planActivationInfo;
    @Lob
    @Column(name = "peak_off_peak_info")
    private String peakOffPeakInfo;
    @Lob
    @Column(name = "how_to_subscribe_info")
    private String howToSubscribeInfo;
    @Lob
    @Column(name = "how_to_unsubscribe_info")
    private String howToUnsubscribeInfo;
    @Lob
    @Column(name = "early_termination_fees")
    private String earlyTerminationFees;
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

    public PlansPlanmiscellaneousLocale() {
    }

    public PlansPlanmiscellaneousLocale(Integer id) {
        this.id = id;
    }

    public PlansPlanmiscellaneousLocale(Integer id, int planPrimaryId, Date creationDatetime, boolean isActive) {
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

    public String getSimActivationInfo() {
        return simActivationInfo;
    }

    public void setSimActivationInfo(String simActivationInfo) {
        this.simActivationInfo = simActivationInfo;
    }

    public String getAddedBenefitsInfo() {
        return addedBenefitsInfo;
    }

    public void setAddedBenefitsInfo(String addedBenefitsInfo) {
        this.addedBenefitsInfo = addedBenefitsInfo;
    }

    public String getOptionalBenefitsInfo() {
        return optionalBenefitsInfo;
    }

    public void setOptionalBenefitsInfo(String optionalBenefitsInfo) {
        this.optionalBenefitsInfo = optionalBenefitsInfo;
    }

    public String getPlanActivationInfo() {
        return planActivationInfo;
    }

    public void setPlanActivationInfo(String planActivationInfo) {
        this.planActivationInfo = planActivationInfo;
    }

    public String getPeakOffPeakInfo() {
        return peakOffPeakInfo;
    }

    public void setPeakOffPeakInfo(String peakOffPeakInfo) {
        this.peakOffPeakInfo = peakOffPeakInfo;
    }

    public String getHowToSubscribeInfo() {
        return howToSubscribeInfo;
    }

    public void setHowToSubscribeInfo(String howToSubscribeInfo) {
        this.howToSubscribeInfo = howToSubscribeInfo;
    }

    public String getHowToUnsubscribeInfo() {
        return howToUnsubscribeInfo;
    }

    public void setHowToUnsubscribeInfo(String howToUnsubscribeInfo) {
        this.howToUnsubscribeInfo = howToUnsubscribeInfo;
    }

    public String getEarlyTerminationFees() {
        return earlyTerminationFees;
    }

    public void setEarlyTerminationFees(String earlyTerminationFees) {
        this.earlyTerminationFees = earlyTerminationFees;
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
        if (!(object instanceof PlansPlanmiscellaneousLocale)) {
            return false;
        }
        PlansPlanmiscellaneousLocale other = (PlansPlanmiscellaneousLocale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanmiscellaneousLocale[ id=" + id + " ]";
    }
    
}
