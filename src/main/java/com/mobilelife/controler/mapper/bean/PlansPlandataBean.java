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

public class PlansPlandataBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer roamingData;
    private Integer dataSpeed;
    private boolean isActive;
    private Integer planPrimaryId;

    public PlansPlandataBean() {
    }

    public PlansPlandataBean(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoamingData() {
        return roamingData;
    }

    public void setRoamingData(Integer roamingData) {
        this.roamingData = roamingData;
    }

    public Integer getDataSpeed() {
        return dataSpeed;
    }

    public void setDataSpeed(Integer dataSpeed) {
        this.dataSpeed = dataSpeed;
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

}
