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
    @NamedQuery(name = "PlansPlantypeEntity.findAll", query = "SELECT p FROM PlansPlantypeEntity p")
    , @NamedQuery(name = "PlansPlantypeEntity.findById", query = "SELECT p FROM PlansPlantypeEntity p WHERE  p.id = :id")
    , @NamedQuery(name = "PlansPlantypeEntity.findByPlanType", query = "SELECT p FROM PlansPlantypeEntity p WHERE  p.planType = :planType")
    , @NamedQuery(name = "PlansPlantypeEntity.findByCountry", query = "SELECT p FROM PlansPlantypeEntity p WHERE p.country = :country")
    , @NamedQuery(name = "PlansPlantypeEntity.findByCreationDatetime", query = "SELECT p FROM PlansPlantypeEntity p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlantypeEntity.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlantypeEntity p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlantypeEntity.findByIsActive", query = "SELECT p FROM PlansPlantypeEntity p WHERE p.isActive = :isActive")})
public class PlansPlantypeEntity implements Serializable {

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
    private Collection<PlanFiltersEntity> planFiltersCollection;
    @OneToMany(mappedBy = "planTypeId")
    private Collection<PlansPlantypeConfEntity> plansPlantypeConfCollection;
    @JoinColumn(name = "operator_id", referencedColumnName = "id")
    @ManyToOne
    private PlansOperatorEntity operatorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planType")
    private Collection<PlansDeviceprimaryEntity> plansDeviceprimaryCollection;

    public PlansPlantypeEntity() {
    }

    public PlansPlantypeEntity(Integer id) {
        this.id = id;
    }

    public PlansPlantypeEntity(Integer id, Date creationDatetime, boolean isActive) {
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
    public Collection<PlanFiltersEntity> getPlanFiltersCollection() {
        return planFiltersCollection;
    }

    public void setPlanFiltersCollection(Collection<PlanFiltersEntity> planFiltersCollection) {
        this.planFiltersCollection = planFiltersCollection;
    }

    @XmlTransient
    public Collection<PlansPlantypeConfEntity> getPlansPlantypeConfCollection() {
        return plansPlantypeConfCollection;
    }

    public void setPlansPlantypeConfCollection(Collection<PlansPlantypeConfEntity> plansPlantypeConfCollection) {
        this.plansPlantypeConfCollection = plansPlantypeConfCollection;
    }

    public PlansOperatorEntity getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(PlansOperatorEntity operatorId) {
        this.operatorId = operatorId;
    }

    public Collection<PlansDeviceprimaryEntity> getPlansDeviceprimaryCollection() {
        return plansDeviceprimaryCollection;
    }

    public void setPlansDeviceprimaryCollection(Collection<PlansDeviceprimaryEntity> plansDeviceprimaryCollection) {
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
        if (!(object instanceof PlansPlantypeEntity)) {
            return false;
        }
        PlansPlantypeEntity other = (PlansPlantypeEntity) object;
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
