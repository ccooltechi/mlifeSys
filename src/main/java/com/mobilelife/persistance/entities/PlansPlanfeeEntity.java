/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.persistance.entities;

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

/**
 *
 * @author pods
 */
@Entity
@Table(name = "plans_planfee", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlanfeeEntity.findAll", query = "SELECT p FROM PlansPlanfeeEntity p")
    , @NamedQuery(name = "PlansPlanfeeEntity.findById", query = "SELECT p FROM PlansPlanfeeEntity p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlanfeeEntity.findBySimActivationFee", query = "SELECT p FROM PlansPlanfeeEntity p WHERE p.simActivationFee = :simActivationFee")
    , @NamedQuery(name = "PlansPlanfeeEntity.findByPlanMonthlyFee", query = "SELECT p FROM PlansPlanfeeEntity p WHERE p.planMonthlyFee = :planMonthlyFee")
    , @NamedQuery(name = "PlansPlanfeeEntity.findByCreationDatetime", query = "SELECT p FROM PlansPlanfeeEntity p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlanfeeEntity.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlanfeeEntity p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlanfeeEntity.findByIsActive", query = "SELECT p FROM PlansPlanfeeEntity p WHERE p.isActive = :isActive")})
public class PlansPlanfeeEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sim_activation_fee")
    private Double simActivationFee;
    @Column(name = "plan_monthly_fee")
    private Double planMonthlyFee;
    @Basic(optional = false)
    @Column(name = "creation_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDatetime;
    @Column(name = "last_modified_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDatetime;
    @Basic(optional = false)
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "setup_info")
    private String setupInfo;
    
    @Column(name = "plan_monthly_fee_was")
    private Double planMonthlyFeeWas;
    
    @JoinColumn(name = "plan_primary_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private PlansPlanprimaryEntity planPrimaryId;

    public PlansPlanfeeEntity() {
    }

    public PlansPlanfeeEntity(Integer id) {
        this.id = id;
    }

    public PlansPlanfeeEntity(Integer id, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.creationDatetime = creationDatetime;
        this.isActive = isActive;
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
    
    

    public Double getPlanMonthlyFeeWas() {
		return planMonthlyFeeWas;
	}

	public void setPlanMonthlyFeeWas(Double planMonthlyFeeWas) {
		this.planMonthlyFeeWas = planMonthlyFeeWas;
	}

	public Date getCreationDatetime() {
        return creationDatetime;
    }

    public void setCreationDatetime(Date creationDatetime) {
        this.creationDatetime = creationDatetime;
    }

    public Date getLastModifiedDatetime() {
        return lastModifiedDatetime;
    }

    public void setLastModifiedDatetime(Date lastModifiedDatetime) {
        this.lastModifiedDatetime = lastModifiedDatetime;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public PlansPlanprimaryEntity getPlanPrimaryId() {
        return planPrimaryId;
    }

    public void setPlanPrimaryId(PlansPlanprimaryEntity planPrimaryId) {
        this.planPrimaryId = planPrimaryId;
    }

    
    /**
	 * @return the setupInfo
	 */
	public String getSetupInfo() {
		return setupInfo;
	}

	/**
	 * @param setupInfo the setupInfo to set
	 */
	public void setSetupInfo(String setupInfo) {
		this.setupInfo = setupInfo;
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
        if (!(object instanceof PlansPlanfeeEntity)) {
            return false;
        }
        PlansPlanfeeEntity other = (PlansPlanfeeEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanfee[ id=" + id + " ]";
    }
    
}
