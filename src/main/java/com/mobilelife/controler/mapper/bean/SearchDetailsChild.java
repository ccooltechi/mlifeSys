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

public class SearchDetailsChild implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "request_type")
    private String requestType;
    @Column(name = "category")
    private String category;
    @Column(name = "subcategory")
    private String subcategory;
    @Column(name = "moresaving")
    private String moresaving;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "monthlyBudget")
    private String monthlyBudget;
    @Column(name = "data")
    private String data;
    @Column(name = "rechargeFrequency")
    private String rechargeFrequency;
    @Column(name = "flexi")
    private String flexi;
    @Column(name = "national")
    private String national;
    @Column(name = "international")
    private String international;
    @Column(name = "deviceBrand")
    private String deviceBrand;
    @Column(name = "deviceModels")
    private String deviceModels;
    @Column(name = "deviceMemory")
    private String deviceMemory;
    @Column(name = "deviceColor")
    private String deviceColor;
    @Column(name = "operator")
    private String operator;
    @Column(name = "countries")
    private String countries;
    @Column(name = "autoRenew")
    private String autoRenew;
    @Column(name = "dataOnly")
    private String dataOnly;
    @Column(name = "prepaidInline")
    private String prepaidInline;
    @Column(name = "prepaidTypeFilter")
    private String prepaidTypeFilter;
    @Column(name = "callPlanType")
    private String callPlanType;
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
    @JoinColumn(name = "search_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private SearchDetails searchId;
    @Column(name = "token")
    private String token;
    @Column(name = "plan_reponse")
    private String planReponse;

    public SearchDetailsChild() {
    }

    public SearchDetailsChild(Integer id) {
        this.id = id;
    }

    public SearchDetailsChild(Integer id, Date creationDatetime, boolean isActive) {
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

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getMoresaving() {
        return moresaving;
    }

    public void setMoresaving(String moresaving) {
        this.moresaving = moresaving;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMonthlyBudget() {
        return monthlyBudget;
    }

    public void setMonthlyBudget(String monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRechargeFrequency() {
        return rechargeFrequency;
    }

    public void setRechargeFrequency(String rechargeFrequency) {
        this.rechargeFrequency = rechargeFrequency;
    }

    public String getFlexi() {
        return flexi;
    }

    public void setFlexi(String flexi) {
        this.flexi = flexi;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getInternational() {
        return international;
    }

    public void setInternational(String international) {
        this.international = international;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getDeviceModels() {
        return deviceModels;
    }

    public void setDeviceModels(String deviceModels) {
        this.deviceModels = deviceModels;
    }

    public String getDeviceMemory() {
        return deviceMemory;
    }

    public void setDeviceMemory(String deviceMemory) {
        this.deviceMemory = deviceMemory;
    }

    public String getDeviceColor() {
        return deviceColor;
    }

    public void setDeviceColor(String deviceColor) {
        this.deviceColor = deviceColor;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getAutoRenew() {
        return autoRenew;
    }

    public void setAutoRenew(String autoRenew) {
        this.autoRenew = autoRenew;
    }

    public String getDataOnly() {
        return dataOnly;
    }

    public void setDataOnly(String dataOnly) {
        this.dataOnly = dataOnly;
    }

    public String getPrepaidInline() {
        return prepaidInline;
    }

    public void setPrepaidInline(String prepaidInline) {
        this.prepaidInline = prepaidInline;
    }

    public String getPrepaidTypeFilter() {
        return prepaidTypeFilter;
    }

    public void setPrepaidTypeFilter(String prepaidTypeFilter) {
        this.prepaidTypeFilter = prepaidTypeFilter;
    }

    public String getCallPlanType() {
        return callPlanType;
    }

    public void setCallPlanType(String callPlanType) {
        this.callPlanType = callPlanType;
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

    public SearchDetails getSearchId() {
        return searchId;
    }

    public void setSearchId(SearchDetails searchId) {
        this.searchId = searchId;
    }
    
    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPlanReponse() {
		return planReponse;
	}

	public void setPlanReponse(String planReponse) {
		this.planReponse = planReponse;
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
        if (!(object instanceof SearchDetailsChild)) {
            return false;
        }
        SearchDetailsChild other = (SearchDetailsChild) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.SearchDetailsChild[ id=" + id + " ]";
    }
    
}
