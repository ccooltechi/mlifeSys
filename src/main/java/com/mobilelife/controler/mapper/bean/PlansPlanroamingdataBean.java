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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

public class PlansPlanroamingdataBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer dataRoamingGb;
    private Integer dataRoamingRollOverGb;
    private String dataRoamingBucketcode;
    private boolean isActive;

    public PlansPlanroamingdataBean() {
    }

    public PlansPlanroamingdataBean(Integer id) {
        this.id = id;
    }

    public PlansPlanroamingdataBean(Integer id, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDataRoamingGb() {
        return dataRoamingGb;
    }

    public void setDataRoamingGb(Integer dataRoamingGb) {
        this.dataRoamingGb = dataRoamingGb;
    }

    public Integer getDataRoamingRollOverGb() {
        return dataRoamingRollOverGb;
    }

    public void setDataRoamingRollOverGb(Integer dataRoamingRollOverGb) {
        this.dataRoamingRollOverGb = dataRoamingRollOverGb;
    }

    public String getDataRoamingBucketcode() {
        return dataRoamingBucketcode;
    }

    public void setDataRoamingBucketcode(String dataRoamingBucketcode) {
        this.dataRoamingBucketcode = dataRoamingBucketcode;
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
        if (!(object instanceof PlansPlanroamingdataBean)) {
            return false;
        }
        PlansPlanroamingdataBean other = (PlansPlanroamingdataBean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanroamingdata[ id=" + id + " ]";
    }
    
}
