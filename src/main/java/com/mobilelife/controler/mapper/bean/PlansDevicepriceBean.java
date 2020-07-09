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

public class PlansDevicepriceBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cost")
    private double cost;
    @Basic(optional = false)
    @Column(name = "stock")
    private int stock;
    @Column(name = "data_offer")
    private String dataOffer;
    @Column(name = "gifts")
    private String gifts;
    @Basic(optional = false)
    @Column(name = "is_active")
    private boolean isActive;
    @Basic(optional = false)
    @Column(name = "creation_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDatetime;
    @Column(name = "last_modified_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDatetime;
    @Column(name = "deviceImage")
    private String deviceImage;
    @Column(name = "deviceColorHex")
    private String deviceColorHex;
    @Column(name = "deviceImage_thumbnail")
    private String deviceImageThumbnail;
    @Column(name = "flexi_national")
    private String flexiNational;
    @JoinColumn(name = "device_color", referencedColumnName = "id")
    @ManyToOne
    private PlanDevicecolorBean deviceColor;
    @JoinColumn(name = "deviceprimary_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PlansDeviceprimaryBean deviceprimaryId;

    public PlansDevicepriceBean() {
    }

    public PlansDevicepriceBean(Integer id) {
        this.id = id;
    }

    public PlansDevicepriceBean(Integer id, int cost, int stock, boolean isActive, Date creationDatetime) {
        this.id = id;
        this.cost = cost;
        this.stock = stock;
        this.isActive = isActive;
        this.creationDatetime = creationDatetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDataOffer() {
        return dataOffer;
    }

    public void setDataOffer(String dataOffer) {
        this.dataOffer = dataOffer;
    }

    public String getGifts() {
        return gifts;
    }

    public void setGifts(String gifts) {
        this.gifts = gifts;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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

    public String getDeviceImage() {
        return deviceImage;
    }

    public void setDeviceImage(String deviceImage) {
        this.deviceImage = deviceImage;
    }

    public String getDeviceColorHex() {
        return deviceColorHex;
    }

    public void setDeviceColorHex(String deviceColorHex) {
        this.deviceColorHex = deviceColorHex;
    }

    public PlanDevicecolorBean getDeviceColor() {
        return deviceColor;
    }

    public void setDeviceColor(PlanDevicecolorBean deviceColor) {
        this.deviceColor = deviceColor;
    }

    public String getDeviceImageThumbnail() {
		return deviceImageThumbnail;
	}

	public void setDeviceImageThumbnail(String deviceImageThumbnail) {
		this.deviceImageThumbnail = deviceImageThumbnail;
	}

	public PlansDeviceprimaryBean getDeviceprimaryId() {
        return deviceprimaryId;
    }

    public void setDeviceprimaryId(PlansDeviceprimaryBean deviceprimaryId) {
        this.deviceprimaryId = deviceprimaryId;
    }

    public String getFlexiNational() {
		return flexiNational;
	}

	public void setFlexiNational(String flexiNational) {
		this.flexiNational = flexiNational;
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
        if (!(object instanceof PlansDevicepriceBean)) {
            return false;
        }
        PlansDevicepriceBean other = (PlansDevicepriceBean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansDeviceprice[ id=" + id + " ]";
    }
    
}
