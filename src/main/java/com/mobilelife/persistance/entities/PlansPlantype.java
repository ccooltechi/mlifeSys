/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.persistance.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pods
 */
@Entity
@Table(name = "plans_plantype", catalog = "", schema = "")

@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlantype.findAll", query = "SELECT p FROM PlansPlantype p WHERE p.isActive =1")
    , @NamedQuery(name = "PlansPlantype.findById", query = "SELECT p FROM PlansPlantype p WHERE p.isActive =1 and p.id = :id")
    , @NamedQuery(name = "PlansPlantype.findByPlanType", query = "SELECT p FROM PlansPlantype p WHERE p.isActive =1 and p.planType = :planType")
    , @NamedQuery(name = "PlansPlantype.findByCountry", query = "SELECT p FROM PlansPlantype p WHERE p.isActive =1 and p.country = :country")
    , @NamedQuery(name = "PlansPlantype.findByCreationDatetime", query = "SELECT p FROM PlansPlantype p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlantype.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlantype p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlantype.findByIsActive", query = "SELECT p FROM PlansPlantype p WHERE p.isActive = :isActive")})
public class PlansPlantype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "plan_type")
    private String planType;
    @Column(name = "plan_label")
    private String planLabel;
    @Column(name = "country")
    private String country;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planType")
    private Collection<PlanFilters> planFiltersCollection;
    @OneToMany(mappedBy = "planTypeId")
    private Collection<PlansPlantypeConf> plansPlantypeConfCollection;
    @JoinColumn(name = "operator_id", referencedColumnName = "id")
    @ManyToOne
    private PlansOperator operatorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planType")
    private Collection<PlansDeviceprimary> plansDeviceprimaryCollection;

    public PlansPlantype() {
    }

    public PlansPlantype(Integer id) {
        this.id = id;
    }

    public PlansPlantype(Integer id, Date creationDatetime, boolean isActive) {
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

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    @XmlTransient
    public Collection<PlanFilters> getPlanFiltersCollection() {
        return planFiltersCollection;
    }

    public void setPlanFiltersCollection(Collection<PlanFilters> planFiltersCollection) {
        this.planFiltersCollection = planFiltersCollection;
    }

    @XmlTransient
    public Collection<PlansPlantypeConf> getPlansPlantypeConfCollection() {
        return plansPlantypeConfCollection;
    }

    public void setPlansPlantypeConfCollection(Collection<PlansPlantypeConf> plansPlantypeConfCollection) {
        this.plansPlantypeConfCollection = plansPlantypeConfCollection;
    }

    public PlansOperator getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(PlansOperator operatorId) {
        this.operatorId = operatorId;
    }

    public Collection<PlansDeviceprimary> getPlansDeviceprimaryCollection() {
        return plansDeviceprimaryCollection;
    }

    public void setPlansDeviceprimaryCollection(Collection<PlansDeviceprimary> plansDeviceprimaryCollection) {
        this.plansDeviceprimaryCollection = plansDeviceprimaryCollection;
    }

    public String getPlanLabel() {
		return planLabel;
	}

	public void setPlanLabel(String planLabel) {
		this.planLabel = planLabel;
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
        if (!(object instanceof PlansPlantype)) {
            return false;
        }
        PlansPlantype other = (PlansPlantype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlantype[ id=" + id + " ]";
    }
    
}
