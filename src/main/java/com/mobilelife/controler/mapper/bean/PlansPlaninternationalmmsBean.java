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

public class PlansPlaninternationalmmsBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer internationalMms;
    private Double internationalMmsUnitrate;
    private boolean isActive;
    private Integer planPrimaryId;

    public PlansPlaninternationalmmsBean() {
    }

    public PlansPlaninternationalmmsBean(Integer id) {
        this.id = id;
    }

    public PlansPlaninternationalmmsBean(Integer id, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInternationalMms() {
        return internationalMms;
    }

    public void setInternationalMms(Integer internationalMms) {
        this.internationalMms = internationalMms;
    }

    public Double getInternationalMmsUnitrate() {
        return internationalMmsUnitrate;
    }

    public void setInternationalMmsUnitrate(Double internationalMmsUnitrate) {
        this.internationalMmsUnitrate = internationalMmsUnitrate;
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
        if (!(object instanceof PlansPlaninternationalmmsBean)) {
            return false;
        }
        PlansPlaninternationalmmsBean other = (PlansPlaninternationalmmsBean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlaninternationalmms[ id=" + id + " ]";
    }
    
}
