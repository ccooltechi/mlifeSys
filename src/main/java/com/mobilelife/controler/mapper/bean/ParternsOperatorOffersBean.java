/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.controler.mapper.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
public class ParternsOperatorOffersBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer operatorId;
    private Integer plantypeId;
    private Date creationDatetime;
    private Date lastModifiedDatetime;
    private boolean isActive;
    private String offerCode;
    private String offerName;
    private Date offerAgeFrom;
    private Date offerAgeTo;
    private String offerType;
    private Integer offerValue;
    private String codeSuffix;
    private String codePrefix;
    private Integer perCouponValue;
    private Integer couponInvTotal;
    private Integer couponInvUsed;
    private Integer codeSeqStart;
    private Integer status;
    private Integer lastSeqGenerated;

    public ParternsOperatorOffersBean() {
    }

    public ParternsOperatorOffersBean(Integer id) {
        this.id = id;
    }

    public ParternsOperatorOffersBean(Integer id, Date creationDatetime, boolean isActive) {
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

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getPlantypeId() {
        return plantypeId;
    }

    public void setPlantypeId(Integer plantypeId) {
        this.plantypeId = plantypeId;
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

    public String getOfferCode() {
        return offerCode;
    }

    public void setOfferCode(String offerCode) {
        this.offerCode = offerCode;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public Date getOfferAgeFrom() {
        return offerAgeFrom;
    }

    public void setOfferAgeFrom(Date offerAgeFrom) {
        this.offerAgeFrom = offerAgeFrom;
    }

    public Date getOfferAgeTo() {
        return offerAgeTo;
    }

    public void setOfferAgeTo(Date offerAgeTo) {
        this.offerAgeTo = offerAgeTo;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public Integer getOfferValue() {
        return offerValue;
    }

    public void setOfferValue(Integer offerValue) {
        this.offerValue = offerValue;
    }

    public String getCodeSuffix() {
        return codeSuffix;
    }

    public void setCodeSuffix(String codeSuffix) {
        this.codeSuffix = codeSuffix;
    }

    public String getCodePrefix() {
        return codePrefix;
    }

    public void setCodePrefix(String codePrefix) {
        this.codePrefix = codePrefix;
    }

    public Integer getPerCouponValue() {
        return perCouponValue;
    }

    public void setPerCouponValue(Integer perCouponValue) {
        this.perCouponValue = perCouponValue;
    }

    public Integer getCouponInvTotal() {
        return couponInvTotal;
    }

    public void setCouponInvTotal(Integer couponInvTotal) {
        this.couponInvTotal = couponInvTotal;
    }

    public Integer getCouponInvUsed() {
        return couponInvUsed;
    }

    public void setCouponInvUsed(Integer couponInvUsed) {
        this.couponInvUsed = couponInvUsed;
    }

    public Integer getCodeSeqStart() {
		return codeSeqStart;
	}

	public void setCodeSeqStart(Integer codeSeqStart) {
		this.codeSeqStart = codeSeqStart;
	}

	public Integer getLastSeqGenerated() {
		return lastSeqGenerated;
	}

	public void setLastSeqGenerated(Integer lastSeqGenerated) {
		this.lastSeqGenerated = lastSeqGenerated;
	}

}
