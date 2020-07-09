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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

public class PlansPartnerRouteBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "retailstore")
    private boolean retailstore;
    @Lob
    @Column(name = "retailstore_url")
    private String retailstoreUrl;
    @Basic(optional = false)
    @Column(name = "callback")
    private boolean callback;
    @Lob
    @Column(name = "callback_url")
    private String callbackUrl;
    @Basic(optional = false)
    @Column(name = "telcoredirect")
    private boolean telcoredirect;
    @Lob
    @Column(name = "telcoredirect_url")
    private String telcoredirectUrl;
    @Basic(optional = false)
    @Column(name = "affiliate")
    private boolean affiliate;
    @Lob
    @Column(name = "affiliate_url")
    private String affiliateUrl;
    @Column(name = "callback_merchant_code")
    private String callback_merchant_code;
    @Column(name = "affiliate_merchant_code")
    private String affiliate_merchant_code;    
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
    @JoinColumn(name = "plan_primary_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private PlansPlanprimaryBean planPrimaryId;

    public PlansPartnerRouteBean() {
    }

    public PlansPartnerRouteBean(Integer id) {
        this.id = id;
    }

    public PlansPartnerRouteBean(Integer id, boolean retailstore, boolean callback, boolean telcoredirect, boolean affiliate, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.retailstore = retailstore;
        this.callback = callback;
        this.telcoredirect = telcoredirect;
        this.affiliate = affiliate;
        this.creationDatetime = creationDatetime;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getRetailstore() {
        return retailstore;
    }

    public void setRetailstore(boolean retailstore) {
        this.retailstore = retailstore;
    }

    public String getRetailstoreUrl() {
        return retailstoreUrl;
    }

    public void setRetailstoreUrl(String retailstoreUrl) {
        this.retailstoreUrl = retailstoreUrl;
    }

    public boolean getCallback() {
        return callback;
    }

    public void setCallback(boolean callback) {
        this.callback = callback;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public boolean getTelcoredirect() {
        return telcoredirect;
    }

    public void setTelcoredirect(boolean telcoredirect) {
        this.telcoredirect = telcoredirect;
    }

    public String getTelcoredirectUrl() {
        return telcoredirectUrl;
    }

    public void setTelcoredirectUrl(String telcoredirectUrl) {
        this.telcoredirectUrl = telcoredirectUrl;
    }

    public boolean getAffiliate() {
        return affiliate;
    }

    public void setAffiliate(boolean affiliate) {
        this.affiliate = affiliate;
    }

    public String getAffiliateUrl() {
        return affiliateUrl;
    }

    public void setAffiliateUrl(String affiliateUrl) {
        this.affiliateUrl = affiliateUrl;
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

    public PlansPlanprimaryBean getPlanPrimaryId() {
        return planPrimaryId;
    }

    public void setPlanPrimaryId(PlansPlanprimaryBean planPrimaryId) {
        this.planPrimaryId = planPrimaryId;
    }

    public String getCallback_merchant_code() {
		return callback_merchant_code;
	}

	public void setCallback_merchant_code(String callback_merchant_code) {
		this.callback_merchant_code = callback_merchant_code;
	}

	public String getAffiliate_merchant_code() {
		return affiliate_merchant_code;
	}

	public void setAffiliate_merchant_code(String affiliate_merchant_code) {
		this.affiliate_merchant_code = affiliate_merchant_code;
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
        if (!(object instanceof PlansPartnerRouteBean)) {
            return false;
        }
        PlansPartnerRouteBean other = (PlansPartnerRouteBean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPartnerRoute[ id=" + id + " ]";
    }
    
}
