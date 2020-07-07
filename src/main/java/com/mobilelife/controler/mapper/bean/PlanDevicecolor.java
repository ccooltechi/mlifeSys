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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

public class PlanDevicecolor implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String deviceColor;
    private String deviceColorHex;
    private boolean isActive;

    public PlanDevicecolor() {
    }

    public PlanDevicecolor(Integer id) {
        this.id = id;
    }

    public PlanDevicecolor(Integer id, boolean isActive, Date creationDatetime) {
        this.id = id;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceColor() {
        return deviceColor;
    }

    public void setDeviceColor(String deviceColor) {
        this.deviceColor = deviceColor;
    }

    public String getDeviceColorHex() {
        return deviceColorHex;
    }

    public void setDeviceColorHex(String deviceColorHex) {
        this.deviceColorHex = deviceColorHex;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

}
