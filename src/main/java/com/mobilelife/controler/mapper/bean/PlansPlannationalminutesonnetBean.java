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

public class PlansPlannationalminutesonnetBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer nationalMinutesOnnet;
    private Double nationalMinutesOnnetUnitrate;
    private boolean isActive;
    private Integer planPrimaryId;

    public PlansPlannationalminutesonnetBean() {
    }

    public PlansPlannationalminutesonnetBean(Integer id) {
        this.id = id;
    }

    public PlansPlannationalminutesonnetBean(Integer id, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNationalMinutesOnnet() {
        return nationalMinutesOnnet;
    }

    public void setNationalMinutesOnnet(Integer nationalMinutesOnnet) {
        this.nationalMinutesOnnet = nationalMinutesOnnet;
    }

    public Double getNationalMinutesOnnetUnitrate() {
        return nationalMinutesOnnetUnitrate;
    }

    public void setNationalMinutesOnnetUnitrate(Double nationalMinutesOnnetUnitrate) {
        this.nationalMinutesOnnetUnitrate = nationalMinutesOnnetUnitrate;
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
        if (!(object instanceof PlansPlannationalminutesonnetBean)) {
            return false;
        }
        PlansPlannationalminutesonnetBean other = (PlansPlannationalminutesonnetBean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlannationalminutesonnet[ id=" + id + " ]";
    }
    
}
