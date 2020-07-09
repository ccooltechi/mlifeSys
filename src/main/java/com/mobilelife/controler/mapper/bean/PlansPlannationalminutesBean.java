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

public class PlansPlannationalminutesBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer nationalMinutes;
    private String nationalMinutePulse;
    private Double nationalMinutesUnitrate;
    private boolean isActive;
    private Integer planPrimaryId;

    private Integer nationalMinutesWas;
    private Integer nationalMinutesDiscount;

    public PlansPlannationalminutesBean() {
    }

    public PlansPlannationalminutesBean(Integer id) {
        this.id = id;
    }

    public PlansPlannationalminutesBean(Integer id, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNationalMinutes() {
        return nationalMinutes;
    }

    public void setNationalMinutes(Integer nationalMinutes) {
        this.nationalMinutes = nationalMinutes;
    }

    public String getNationalMinutePulse() {
        return nationalMinutePulse;
    }

    public void setNationalMinutePulse(String nationalMinutePulse) {
        this.nationalMinutePulse = nationalMinutePulse;
    }

    public Double getNationalMinutesUnitrate() {
        return nationalMinutesUnitrate;
    }

    public void setNationalMinutesUnitrate(Double nationalMinutesUnitrate) {
        this.nationalMinutesUnitrate = nationalMinutesUnitrate;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    
    public Integer getNationalMinutesWas() {
		return nationalMinutesWas;
	}

	public void setNationalMinutesWas(Integer nationalMinutesWas) {
		this.nationalMinutesWas = nationalMinutesWas;
	}

	public Integer getNationalMinutesDiscount() {
		return nationalMinutesDiscount;
	}

	public void setNationalMinutesDiscount(Integer nationalMinutesDiscount) {
		this.nationalMinutesDiscount = nationalMinutesDiscount;
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
        if (!(object instanceof PlansPlannationalminutesBean)) {
            return false;
        }
        PlansPlannationalminutesBean other = (PlansPlannationalminutesBean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlannationalminutes[ id=" + id + " ]";
    }
    
}
