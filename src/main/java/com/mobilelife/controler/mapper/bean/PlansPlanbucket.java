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

public class PlansPlanbucket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "plan_group")
    private String planGroup;
    @Column(name = "bucket")
    private String bucket;
    @Column(name = "foreignOperator")
    private String foreignOperator;
    @Column(name = "country_in_bundle")
    private String countryInBundle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "oob_rate")
    private Double oobRate;
    @Column(name = "cal_intrabundle_rate")
    private String calIntrabundleRate;
    @Column(name = "min_pluse")
    private String minPluse;
    @Column(name = "label")
    private String label;
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
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne
    private Countries countryId;
    @JoinColumn(name = "operator_id", referencedColumnName = "id")
    @ManyToOne
    private PlansOperator operatorId;
    @JoinColumn(name = "plan_primary_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PlansPlanprimary planPrimaryId;

    @Column(name = "specific_network")
    private String specificNetwork;
    @Column(name = "rate_off_peak")
    private Double rateOffPeak;
    @Column(name = "rate_friends_family")
    private Double rateFriendsFamily;
    @Column(name = "unit")
    private Integer unit;
    
    public PlansPlanbucket() {
    }

    public PlansPlanbucket(Integer id) {
        this.id = id;
    }

    public PlansPlanbucket(Integer id, Date creationDatetime, boolean isActive) {
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

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getForeignOperator() {
        return foreignOperator;
    }

    public void setForeignOperator(String foreignOperator) {
        this.foreignOperator = foreignOperator;
    }

    public String getCountryInBundle() {
        return countryInBundle;
    }

    public void setCountryInBundle(String countryInBundle) {
        this.countryInBundle = countryInBundle;
    }

    public Double getOobRate() {
        return oobRate;
    }

    public void setOobRate(Double oobRate) {
        this.oobRate = oobRate;
    }

    public String getCalIntrabundleRate() {
        return calIntrabundleRate;
    }

    public void setCalIntrabundleRate(String calIntrabundleRate) {
        this.calIntrabundleRate = calIntrabundleRate;
    }

    public String getMinPluse() {
        return minPluse;
    }

    public void setMinPluse(String minPluse) {
        this.minPluse = minPluse;
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

    public Countries getCountryId() {
        return countryId;
    }

    public void setCountryId(Countries countryId) {
        this.countryId = countryId;
    }

    public PlansOperator getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(PlansOperator operatorId) {
        this.operatorId = operatorId;
    }

    public PlansPlanprimary getPlanPrimaryId() {
        return planPrimaryId;
    }

    public void setPlanPrimaryId(PlansPlanprimary planPrimaryId) {
        this.planPrimaryId = planPrimaryId;
    }

	public String getPlanGroup() {
		return planGroup;
	}

	public void setPlanGroup(String planGroup) {
		this.planGroup = planGroup;
	}

	
	public String getSpecificNetwork() {
		return specificNetwork;
	}

	public void setSpecificNetwork(String specificNetwork) {
		this.specificNetwork = specificNetwork;
	}

	public Double getRateOffPeak() {
		return rateOffPeak;
	}

	public void setRateOffPeak(Double rateOffPeak) {
		this.rateOffPeak = rateOffPeak;
	}

	public Double getRateFriendsFamily() {
		return rateFriendsFamily;
	}

	public void setRateFriendsFamily(Double rateFriendsFamily) {
		this.rateFriendsFamily = rateFriendsFamily;
	}

	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
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
        if (!(object instanceof PlansPlanbucket)) {
            return false;
        }
        PlansPlanbucket other = (PlansPlanbucket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanbucket[ id=" + id + " ]";
    }
    
}
