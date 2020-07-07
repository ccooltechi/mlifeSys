/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.controler.mapper.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

public class PlansPlanprimary implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String planId;
    private String planName;
    private String planLongName;
    
    private String recurringBbundle;
    private String oneTimeAddon;
    private String discountext;
  
    private Date planStartDate;
    private Date planEndDate;
    private String planUrl;
    private boolean isTaxIncluded;
    private Integer planValidity;
    private String planValidityUnit;
    private Integer contractPeriod;
    private Integer priority;
    private String contractPeriodUnit;
    private String localExpat;
    private Integer autorenewedFlag;
    private boolean isActive;
    private boolean discountedUpfrontPayment;
    private Double planVatPer;
    private boolean topupsallowedFlag;
    private Integer numberOfMultiSims;
    private Integer rechargeFrequency;
    private String rechargeFrequencyUnit;
    private int featured;
    private String planFeature;
    
    private String planBucket;
    private String planParent;
    private String planStatus;

    private String linkTopUp;
    private String subscriptionCode;

    
    private boolean isAddon;
    private boolean isDataOnly;
    private int planLayout;
   
    private Integer planType;
    private Integer operatorId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanLongName() {
		return planLongName;
	}
	public void setPlanLongName(String planLongName) {
		this.planLongName = planLongName;
	}
	public String getRecurringBbundle() {
		return recurringBbundle;
	}
	public void setRecurringBbundle(String recurringBbundle) {
		this.recurringBbundle = recurringBbundle;
	}
	public String getOneTimeAddon() {
		return oneTimeAddon;
	}
	public void setOneTimeAddon(String oneTimeAddon) {
		this.oneTimeAddon = oneTimeAddon;
	}
	public String getDiscountext() {
		return discountext;
	}
	public void setDiscountext(String discountext) {
		this.discountext = discountext;
	}
	public Date getPlanStartDate() {
		return planStartDate;
	}
	public void setPlanStartDate(Date planStartDate) {
		this.planStartDate = planStartDate;
	}
	public Date getPlanEndDate() {
		return planEndDate;
	}
	public void setPlanEndDate(Date planEndDate) {
		this.planEndDate = planEndDate;
	}
	public String getPlanUrl() {
		return planUrl;
	}
	public void setPlanUrl(String planUrl) {
		this.planUrl = planUrl;
	}
	public boolean isTaxIncluded() {
		return isTaxIncluded;
	}
	public void setTaxIncluded(boolean isTaxIncluded) {
		this.isTaxIncluded = isTaxIncluded;
	}
	public Integer getPlanValidity() {
		return planValidity;
	}
	public void setPlanValidity(Integer planValidity) {
		this.planValidity = planValidity;
	}
	public String getPlanValidityUnit() {
		return planValidityUnit;
	}
	public void setPlanValidityUnit(String planValidityUnit) {
		this.planValidityUnit = planValidityUnit;
	}
	public Integer getContractPeriod() {
		return contractPeriod;
	}
	public void setContractPeriod(Integer contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getContractPeriodUnit() {
		return contractPeriodUnit;
	}
	public void setContractPeriodUnit(String contractPeriodUnit) {
		this.contractPeriodUnit = contractPeriodUnit;
	}
	public String getLocalExpat() {
		return localExpat;
	}
	public void setLocalExpat(String localExpat) {
		this.localExpat = localExpat;
	}
	public Integer getAutorenewedFlag() {
		return autorenewedFlag;
	}
	public void setAutorenewedFlag(Integer autorenewedFlag) {
		this.autorenewedFlag = autorenewedFlag;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isDiscountedUpfrontPayment() {
		return discountedUpfrontPayment;
	}
	public void setDiscountedUpfrontPayment(boolean discountedUpfrontPayment) {
		this.discountedUpfrontPayment = discountedUpfrontPayment;
	}
	public Double getPlanVatPer() {
		return planVatPer;
	}
	public void setPlanVatPer(Double planVatPer) {
		this.planVatPer = planVatPer;
	}
	public boolean isTopupsallowedFlag() {
		return topupsallowedFlag;
	}
	public void setTopupsallowedFlag(boolean topupsallowedFlag) {
		this.topupsallowedFlag = topupsallowedFlag;
	}
	public Integer getNumberOfMultiSims() {
		return numberOfMultiSims;
	}
	public void setNumberOfMultiSims(Integer numberOfMultiSims) {
		this.numberOfMultiSims = numberOfMultiSims;
	}
	public Integer getRechargeFrequency() {
		return rechargeFrequency;
	}
	public void setRechargeFrequency(Integer rechargeFrequency) {
		this.rechargeFrequency = rechargeFrequency;
	}
	public String getRechargeFrequencyUnit() {
		return rechargeFrequencyUnit;
	}
	public void setRechargeFrequencyUnit(String rechargeFrequencyUnit) {
		this.rechargeFrequencyUnit = rechargeFrequencyUnit;
	}
	public int getFeatured() {
		return featured;
	}
	public void setFeatured(int featured) {
		this.featured = featured;
	}
	public String getPlanFeature() {
		return planFeature;
	}
	public void setPlanFeature(String planFeature) {
		this.planFeature = planFeature;
	}
	public String getPlanBucket() {
		return planBucket;
	}
	public void setPlanBucket(String planBucket) {
		this.planBucket = planBucket;
	}
	public String getPlanParent() {
		return planParent;
	}
	public void setPlanParent(String planParent) {
		this.planParent = planParent;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public String getLinkTopUp() {
		return linkTopUp;
	}
	public void setLinkTopUp(String linkTopUp) {
		this.linkTopUp = linkTopUp;
	}
	public String getSubscriptionCode() {
		return subscriptionCode;
	}
	public void setSubscriptionCode(String subscriptionCode) {
		this.subscriptionCode = subscriptionCode;
	}
	public boolean isAddon() {
		return isAddon;
	}
	public void setAddon(boolean isAddon) {
		this.isAddon = isAddon;
	}
	public boolean isDataOnly() {
		return isDataOnly;
	}
	public void setDataOnly(boolean isDataOnly) {
		this.isDataOnly = isDataOnly;
	}
	public int getPlanLayout() {
		return planLayout;
	}
	public void setPlanLayout(int planLayout) {
		this.planLayout = planLayout;
	}
	public Integer getPlanType() {
		return planType;
	}
	public void setPlanType(Integer planType) {
		this.planType = planType;
	}
	public Integer getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}
    
}
