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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "plans_operator", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansOperatorEntity.findAll", query = "SELECT p FROM PlansOperatorEntity p")
    , @NamedQuery(name = "PlansOperatorEntity.findById", query = "SELECT p FROM PlansOperatorEntity p WHERE p.id = :id")
    , @NamedQuery(name = "PlansOperatorEntity.findByOperatorName", query = "SELECT p FROM PlansOperatorEntity p WHERE p.operatorName = :operatorName")
    , @NamedQuery(name = "PlansOperatorEntity.findByCountry", query = "SELECT p FROM PlansOperatorEntity p WHERE p.operatorCountry = :operatorCountry")
    , @NamedQuery(name = "PlansOperatorEntity.findByCreationDatetime", query = "SELECT p FROM PlansOperatorEntity p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansOperatorEntity.findByLastModifiedDatetime", query = "SELECT p FROM PlansOperatorEntity p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansOperatorEntity.findByIsActive", query = "SELECT p FROM PlansOperatorEntity p WHERE p.isActive = :isActive")})
public class PlansOperatorEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "operator_name")
    private String operatorName;
    @Lob
    @Column(name = "operator_country")
    private String operatorCountry;
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
    @Column(name = "logo")
    private String logo;
    @Basic(optional = false)
    @Column(name = "support_retail")
    private boolean supportRetail;
    @Basic(optional = false)
    @Column(name = "support_online")
    private boolean supportOnline;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operatorId")
    private Collection<PlansPlanprimaryEntity> plansPlanprimaryCollection;
    @OneToMany(mappedBy = "operatorId")
    private Collection<PlansPlantypeEntity> plansPlantypeCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "plansOperator")
    private UserAccountEntity userAccount;
    @OneToMany(mappedBy = "operatorId")
    private Collection<PlansPlanbucketEntity> plansPlanbucketCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operatorId")
    private Collection<PlansDeviceprimaryEntity> plansDeviceprimaryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operatorId")
    private Collection<PlansOperatorTncEntity> plansOperatorTncCollection;
    
    public PlansOperatorEntity() {
    }

    public PlansOperatorEntity(Integer id) {
        this.id = id;
    }

    public PlansOperatorEntity(Integer id, String operatorName, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.operatorName = operatorName;
        this.creationDatetime = creationDatetime;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorCountry() {
        return operatorCountry;
    }

    public void setOperatorCountry(String operatorCountry) {
        this.operatorCountry = operatorCountry;
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
    public Collection<PlansPlanprimaryEntity> getPlansPlanprimaryCollection() {
        return plansPlanprimaryCollection;
    }

    public void setPlansPlanprimaryCollection(Collection<PlansPlanprimaryEntity> plansPlanprimaryCollection) {
        this.plansPlanprimaryCollection = plansPlanprimaryCollection;
    }

    @XmlTransient
    public Collection<PlansPlantypeEntity> getPlansPlantypeCollection() {
        return plansPlantypeCollection;
    }

    public void setPlansPlantypeCollection(Collection<PlansPlantypeEntity> plansPlantypeCollection) {
        this.plansPlantypeCollection = plansPlantypeCollection;
    }

    public UserAccountEntity getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccountEntity userAccount) {
        this.userAccount = userAccount;
    }

    public Collection<PlansPlanbucketEntity> getPlansPlanbucketCollection() {
        return plansPlanbucketCollection;
    }

    public void setPlansPlanbucketCollection(Collection<PlansPlanbucketEntity> plansPlanbucketCollection) {
        this.plansPlanbucketCollection = plansPlanbucketCollection;
    }

    public Collection<PlansDeviceprimaryEntity> getPlansDeviceprimaryCollection() {
        return plansDeviceprimaryCollection;
    }

    public void setPlansDeviceprimaryCollection(Collection<PlansDeviceprimaryEntity> plansDeviceprimaryCollection) {
        this.plansDeviceprimaryCollection = plansDeviceprimaryCollection;
    }
  
    public Collection<PlansOperatorTncEntity> getPlansOperatorTncCollection() {
        return plansOperatorTncCollection;
    }

    public void setPlansOperatorTncCollection(Collection<PlansOperatorTncEntity> plansOperatorTncCollection) {
        this.plansOperatorTncCollection = plansOperatorTncCollection;
    }
    
    /**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	
	public boolean isSupportRetail() {
		return supportRetail;
	}

	public void setSupportRetail(boolean supportRetail) {
		this.supportRetail = supportRetail;
	}

	public boolean isSupportOnline() {
		return supportOnline;
	}

	public void setSupportOnline(boolean supportOnline) {
		this.supportOnline = supportOnline;
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
        if (!(object instanceof PlansOperatorEntity)) {
            return false;
        }
        PlansOperatorEntity other = (PlansOperatorEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansOperator[ id=" + id + " ]";
    }
    
}
