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

public class PlansPlanpreferrednumbers implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer prefferedNumbersNboflines;
    private Integer preferredNumbersCallsmin;
    private String prefferedNumbersUnits;
    private Integer prefferedNumbersNboflinesOnnet;
    private String preferredNumbersCallsminOnnet;
    private String prefferedNumbersUnitsOnnet;
    private Integer prefferedNumbersNboflinesOffnet;
    private Integer preferredNumbersCallsminOffnet;
    private String prefferedNumbersUnitsOffnet;
    private Date creationDatetime;
    private Date lastModifiedDatetime;
    private boolean isActive;
    private Integer planPrimaryId;

    public PlansPlanpreferrednumbers() {
    }

    public PlansPlanpreferrednumbers(Integer id) {
        this.id = id;
    }

    public PlansPlanpreferrednumbers(Integer id, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrefferedNumbersNboflines() {
        return prefferedNumbersNboflines;
    }

    public void setPrefferedNumbersNboflines(Integer prefferedNumbersNboflines) {
        this.prefferedNumbersNboflines = prefferedNumbersNboflines;
    }

    public Integer getPreferredNumbersCallsmin() {
        return preferredNumbersCallsmin;
    }

    public void setPreferredNumbersCallsmin(Integer preferredNumbersCallsmin) {
        this.preferredNumbersCallsmin = preferredNumbersCallsmin;
    }

    public String getPrefferedNumbersUnits() {
        return prefferedNumbersUnits;
    }

    public void setPrefferedNumbersUnits(String prefferedNumbersUnits) {
        this.prefferedNumbersUnits = prefferedNumbersUnits;
    }

    public Integer getPrefferedNumbersNboflinesOnnet() {
        return prefferedNumbersNboflinesOnnet;
    }

    public void setPrefferedNumbersNboflinesOnnet(Integer prefferedNumbersNboflinesOnnet) {
        this.prefferedNumbersNboflinesOnnet = prefferedNumbersNboflinesOnnet;
    }

    public String getPreferredNumbersCallsminOnnet() {
        return preferredNumbersCallsminOnnet;
    }

    public void setPreferredNumbersCallsminOnnet(String preferredNumbersCallsminOnnet) {
        this.preferredNumbersCallsminOnnet = preferredNumbersCallsminOnnet;
    }

    public String getPrefferedNumbersUnitsOnnet() {
        return prefferedNumbersUnitsOnnet;
    }

    public void setPrefferedNumbersUnitsOnnet(String prefferedNumbersUnitsOnnet) {
        this.prefferedNumbersUnitsOnnet = prefferedNumbersUnitsOnnet;
    }

    public Integer getPrefferedNumbersNboflinesOffnet() {
        return prefferedNumbersNboflinesOffnet;
    }

    public void setPrefferedNumbersNboflinesOffnet(Integer prefferedNumbersNboflinesOffnet) {
        this.prefferedNumbersNboflinesOffnet = prefferedNumbersNboflinesOffnet;
    }

    public Integer getPreferredNumbersCallsminOffnet() {
        return preferredNumbersCallsminOffnet;
    }

    public void setPreferredNumbersCallsminOffnet(Integer preferredNumbersCallsminOffnet) {
        this.preferredNumbersCallsminOffnet = preferredNumbersCallsminOffnet;
    }

    public String getPrefferedNumbersUnitsOffnet() {
        return prefferedNumbersUnitsOffnet;
    }

    public void setPrefferedNumbersUnitsOffnet(String prefferedNumbersUnitsOffnet) {
        this.prefferedNumbersUnitsOffnet = prefferedNumbersUnitsOffnet;
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
        if (!(object instanceof PlansPlanpreferrednumbers)) {
            return false;
        }
        PlansPlanpreferrednumbers other = (PlansPlanpreferrednumbers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanpreferrednumbers[ id=" + id + " ]";
    }
    
}
