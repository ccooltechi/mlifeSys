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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

public class PlansPlanmiscellaneous implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String simActivationInfo;
    private String addedBenefitsInfo;
    private String optionalBenefitsInfo;
    private String planActivationInfo;
    private String peakOffPeakInfo;
    private String howToSubscribeInfo;
    private String howToUnsubscribeInfo;
    private String early_Termination_Fees;
    private boolean isActive;
    private Integer planPrimaryId;

    public PlansPlanmiscellaneous() {
    }

    public PlansPlanmiscellaneous(Integer id) {
        this.id = id;
    }

    public PlansPlanmiscellaneous(Integer id, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEarly_Termination_Fees() {
		return early_Termination_Fees;
	}

	public void setEarly_Termination_Fees(String early_Termination_Fees) {
		this.early_Termination_Fees = early_Termination_Fees;
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
        if (!(object instanceof PlansPlanmiscellaneous)) {
            return false;
        }
        PlansPlanmiscellaneous other = (PlansPlanmiscellaneous) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanmiscellaneous[ id=" + id + " ]";
    }
    
}
