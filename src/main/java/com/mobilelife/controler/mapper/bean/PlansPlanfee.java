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

public class PlansPlanfee implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Double simActivationFee;
    private Double planMonthlyFee;
    private boolean isActive;
    private String setupInfo;
    private Double planMonthlyFeeWas;
    private Integer planPrimaryId;

    public PlansPlanfee() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getSimActivationFee() {
		return simActivationFee;
	}

	public void setSimActivationFee(Double simActivationFee) {
		this.simActivationFee = simActivationFee;
	}

	public Double getPlanMonthlyFee() {
		return planMonthlyFee;
	}

	public void setPlanMonthlyFee(Double planMonthlyFee) {
		this.planMonthlyFee = planMonthlyFee;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getSetupInfo() {
		return setupInfo;
	}

	public void setSetupInfo(String setupInfo) {
		this.setupInfo = setupInfo;
	}

	public Double getPlanMonthlyFeeWas() {
		return planMonthlyFeeWas;
	}

	public void setPlanMonthlyFeeWas(Double planMonthlyFeeWas) {
		this.planMonthlyFeeWas = planMonthlyFeeWas;
	}

	public Integer getPlanPrimaryId() {
		return planPrimaryId;
	}

	public void setPlanPrimaryId(Integer planPrimaryId) {
		this.planPrimaryId = planPrimaryId;
	}

    
}
