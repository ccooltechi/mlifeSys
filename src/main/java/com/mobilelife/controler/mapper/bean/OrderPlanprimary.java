/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.controler.mapper.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

public class OrderPlanprimary implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String orderId;
    private Date creationDatetime;
    private Date lastModifiedDatetime;
    private boolean isActive;
    private String planReffId;
    private String orderValue;
    private Date orderValidityDate;
    private String userId;
    private String emailId;
    private String userName;
    private String orderGeneratedFrom;
    private String orderCouponCode;
    private String addons;

    public OrderPlanprimary() {
    }

    public OrderPlanprimary(Integer id) {
        this.id = id;
    }

    public OrderPlanprimary(Integer id, Date creationDatetime, boolean isActive) {
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getPlanReffId() {
        return planReffId;
    }

    public void setPlanReffId(String planReffId) {
        this.planReffId = planReffId;
    }

    public String getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(String orderValue) {
        this.orderValue = orderValue;
    }

    public Date getOrderValidityDate() {
        return orderValidityDate;
    }

    public void setOrderValidityDate(Date orderValidityDate) {
        this.orderValidityDate = orderValidityDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderGeneratedFrom() {
        return orderGeneratedFrom;
    }

    public void setOrderGeneratedFrom(String orderGeneratedFrom) {
        this.orderGeneratedFrom = orderGeneratedFrom;
    }

    public String getOrderCouponCode() {
        return orderCouponCode;
    }

    public void setOrderCouponCode(String orderCouponCode) {
        this.orderCouponCode = orderCouponCode;
    }
    
    public String getAddons() {
		return addons;
	}

	public void setAddons(String addons) {
		this.addons = addons;
	}

    public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
