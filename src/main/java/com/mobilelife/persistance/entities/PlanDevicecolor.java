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

/**
 *
 * @author pods
 */
@Entity
@Table(name = "plan_devicecolor", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanDevicecolor.findAll", query = "SELECT p FROM PlanDevicecolor p")
    , @NamedQuery(name = "PlanDevicecolor.findById", query = "SELECT p FROM PlanDevicecolor p WHERE p.id = :id")
    , @NamedQuery(name = "PlanDevicecolor.findByDeviceColor", query = "SELECT p FROM PlanDevicecolor p WHERE p.deviceColor = :deviceColor")
    , @NamedQuery(name = "PlanDevicecolor.findByDeviceColorHex", query = "SELECT p FROM PlanDevicecolor p WHERE p.deviceColorHex = :deviceColorHex")
    , @NamedQuery(name = "PlanDevicecolor.findByIsActive", query = "SELECT p FROM PlanDevicecolor p WHERE p.isActive = :isActive")
    , @NamedQuery(name = "PlanDevicecolor.findByCreationDatetime", query = "SELECT p FROM PlanDevicecolor p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlanDevicecolor.findByLastModifiedDatetime", query = "SELECT p FROM PlanDevicecolor p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")})
public class PlanDevicecolor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "device_color")
    private String deviceColor;
    @Column(name = "device_color_hex")
    private String deviceColorHex;
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
    @OneToMany(mappedBy = "deviceColor")
    private Collection<PlansDeviceprice> plansDevicepriceCollection;

    public PlanDevicecolor() {
    }

    public PlanDevicecolor(Integer id) {
        this.id = id;
    }

    public PlanDevicecolor(Integer id, boolean isActive, Date creationDatetime) {
        this.id = id;
        this.isActive = isActive;
        this.creationDatetime = creationDatetime;
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

    @XmlTransient
    public Collection<PlansDeviceprice> getPlansDevicepriceCollection() {
        return plansDevicepriceCollection;
    }

    public void setPlansDeviceprimaryCollection(Collection<PlansDeviceprice> plansDevicepriceCollection) {
        this.plansDevicepriceCollection = plansDevicepriceCollection;
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
        if (!(object instanceof PlanDevicecolor)) {
            return false;
        }
        PlanDevicecolor other = (PlanDevicecolor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlanDevicecolor[ id=" + id + " ]";
    }
    
}
