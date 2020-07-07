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

public class PlansPlanflexi implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer flexiMinutes;
    private String flexiMinutesPulse;
    private Integer flexiMinutesRollover;
    private boolean isActive;
    private Integer planPrimaryId;
    private Integer flexiMinutesWas;
    private Integer flexiMinutesDiscount;
    private Integer flexiMinutesSms;

    public PlansPlanflexi() {
    }

    public PlansPlanflexi(Integer id) {
        this.id = id;
    }

    public PlansPlanflexi(Integer id, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlexiMinutes() {
        return flexiMinutes;
    }

    public void setFlexiMinutes(Integer flexiMinutes) {
        this.flexiMinutes = flexiMinutes;
    }

    public String getFlexiMinutesPulse() {
        return flexiMinutesPulse;
    }

    public void setFlexiMinutesPulse(String flexiMinutesPulse) {
        this.flexiMinutesPulse = flexiMinutesPulse;
    }

    public Integer getFlexiMinutesRollover() {
        return flexiMinutesRollover;
    }

    public void setFlexiMinutesRollover(Integer flexiMinutesRollover) {
        this.flexiMinutesRollover = flexiMinutesRollover;
    }


    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getFlexiMinutesWas() {
		return flexiMinutesWas;
	}

	public void setFlexiMinutesWas(Integer flexiMinutesWas) {
		this.flexiMinutesWas = flexiMinutesWas;
	}

	public Integer getFlexiMinutesDiscount() {
		return flexiMinutesDiscount;
	}

	public void setFlexiMinutesDiscount(Integer flexiMinutesDiscount) {
		this.flexiMinutesDiscount = flexiMinutesDiscount;
	}

	public Integer getPlanPrimaryId() {
        return planPrimaryId;
    }

    public void setPlanPrimaryId(Integer planPrimaryId) {
        this.planPrimaryId = planPrimaryId;
    }

	public Integer getFlexiMinutesSms() {
		return flexiMinutesSms;
	}

	public void setFlexiMinutesSms(Integer flexiMinutesSms) {
		this.flexiMinutesSms = flexiMinutesSms;
	}    
}
