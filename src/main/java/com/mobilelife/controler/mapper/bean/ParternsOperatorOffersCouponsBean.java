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

public class ParternsOperatorOffersCouponsBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Date creationDatetime;
    private Date lastModifiedDatetime;
    private boolean isActive;
    private String couponCode;
    private String couponName;
    private Date couponAgeFrom;
    private Date couponAgeTo;
    private String couponType;
    private Integer couponValue;
    private int isConsumed;

    public ParternsOperatorOffersCouponsBean() {
    }

    public ParternsOperatorOffersCouponsBean(Integer id) {
        this.id = id;
    }

    public ParternsOperatorOffersCouponsBean(Integer id, Date creationDatetime, boolean isActive, int isConsumed) {
        this.id = id;
        this.creationDatetime = creationDatetime;
        this.isActive = isActive;
        this.isConsumed = isConsumed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Date getCouponAgeFrom() {
        return couponAgeFrom;
    }

    public void setCouponAgeFrom(Date couponAgeFrom) {
        this.couponAgeFrom = couponAgeFrom;
    }

    public Date getCouponAgeTo() {
        return couponAgeTo;
    }

    public void setCouponAgeTo(Date couponAgeTo) {
        this.couponAgeTo = couponAgeTo;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public Integer getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(Integer couponValue) {
        this.couponValue = couponValue;
    }

    public int getIsConsumed() {
        return isConsumed;
    }

    public void setIsConsumed(int isConsumed) {
        this.isConsumed = isConsumed;
    }

    
}
