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
    @NamedQuery(name = "PlansOperator.findAll", query = "SELECT p FROM PlansOperator p where p.isActive =1")
    , @NamedQuery(name = "PlansOperator.findById", query = "SELECT p FROM PlansOperator p WHERE p.isActive =1 and p.id = :id")
    , @NamedQuery(name = "PlansOperator.findByOperatorName", query = "SELECT p FROM PlansOperator p WHERE p.isActive =1 and p.operatorName = :operatorName")
    , @NamedQuery(name = "PlansOperator.findByCountry", query = "SELECT p FROM PlansOperator p WHERE p.isActive =1 and p.operatorCountry = :operatorCountry")
    , @NamedQuery(name = "PlansOperator.findByCreationDatetime", query = "SELECT p FROM PlansOperator p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansOperator.findByLastModifiedDatetime", query = "SELECT p FROM PlansOperator p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansOperator.findByIsActive", query = "SELECT p FROM PlansOperator p WHERE p.isActive = :isActive")})
public class PlansOperator implements Serializable {

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
    private Collection<PlansPlanprimary> plansPlanprimaryCollection;
    @OneToMany(mappedBy = "operatorId")
    private Collection<PlansPlantype> plansPlantypeCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "plansOperator")
    private UserAccount userAccount;
    @OneToMany(mappedBy = "operatorId")
    private Collection<PlansPlanbucket> plansPlanbucketCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operatorId")
    private Collection<PlansDeviceprimary> plansDeviceprimaryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operatorId")
    private Collection<PlansOperatorTnc> plansOperatorTncCollection;
    
    public PlansOperator() {
    }

    public PlansOperator(Integer id) {
        this.id = id;
    }

    public PlansOperator(Integer id, String operatorName, Date creationDatetime, boolean isActive) {
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
    public Collection<PlansPlanprimary> getPlansPlanprimaryCollection() {
        return plansPlanprimaryCollection;
    }

    public void setPlansPlanprimaryCollection(Collection<PlansPlanprimary> plansPlanprimaryCollection) {
        this.plansPlanprimaryCollection = plansPlanprimaryCollection;
    }

    @XmlTransient
    public Collection<PlansPlantype> getPlansPlantypeCollection() {
        return plansPlantypeCollection;
    }

    public void setPlansPlantypeCollection(Collection<PlansPlantype> plansPlantypeCollection) {
        this.plansPlantypeCollection = plansPlantypeCollection;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Collection<PlansPlanbucket> getPlansPlanbucketCollection() {
        return plansPlanbucketCollection;
    }

    public void setPlansPlanbucketCollection(Collection<PlansPlanbucket> plansPlanbucketCollection) {
        this.plansPlanbucketCollection = plansPlanbucketCollection;
    }

    public Collection<PlansDeviceprimary> getPlansDeviceprimaryCollection() {
        return plansDeviceprimaryCollection;
    }

    public void setPlansDeviceprimaryCollection(Collection<PlansDeviceprimary> plansDeviceprimaryCollection) {
        this.plansDeviceprimaryCollection = plansDeviceprimaryCollection;
    }
  
    public Collection<PlansOperatorTnc> getPlansOperatorTncCollection() {
        return plansOperatorTncCollection;
    }

    public void setPlansOperatorTncCollection(Collection<PlansOperatorTnc> plansOperatorTncCollection) {
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
        if (!(object instanceof PlansOperator)) {
            return false;
        }
        PlansOperator other = (PlansOperator) object;
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
