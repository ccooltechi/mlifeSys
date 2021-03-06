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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

public class PlansPlanOperatorTncBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private boolean isActive;
    private Integer planPrimaryId;
    private String planFaq;
    private String planFaqUrl;

    public PlansPlanOperatorTncBean() {
    }

    public PlansPlanOperatorTncBean(Integer id) {
        this.id = id;
    }

    public PlansPlanOperatorTncBean(Integer id, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    
    public String getPlanFaq() {
		return planFaq;
	}

	public void setPlanFaq(String planFaq) {
		this.planFaq = planFaq;
	}

	public String getPlanFaqUrl() {
		return planFaqUrl;
	}

	public void setPlanFaqUrl(String planFaqUrl) {
		this.planFaqUrl = planFaqUrl;
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
        if (!(object instanceof PlansPlanOperatorTncBean)) {
            return false;
        }
        PlansPlanOperatorTncBean other = (PlansPlanOperatorTncBean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanOperatorTnc[ id=" + id + " ]";
    }
    
}
