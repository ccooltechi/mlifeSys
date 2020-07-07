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
    @NamedQuery(name = "PlanDevicecolorEntity.findAll", query = "SELECT p FROM PlanDevicecolorEntity p")
    , @NamedQuery(name = "PlanDevicecolorEntity.findById", query = "SELECT p FROM PlanDevicecolorEntity p WHERE p.id = :id")
    , @NamedQuery(name = "PlanDevicecolorEntity.findByDeviceColor", query = "SELECT p FROM PlanDevicecolorEntity p WHERE p.deviceColor = :deviceColor")
    , @NamedQuery(name = "PlanDevicecolorEntity.findByDeviceColorHex", query = "SELECT p FROM PlanDevicecolorEntity p WHERE p.deviceColorHex = :deviceColorHex")
    , @NamedQuery(name = "PlanDevicecolorEntity.findByIsActive", query = "SELECT p FROM PlanDevicecolorEntity p WHERE p.isActive = :isActive")
    , @NamedQuery(name = "PlanDevicecolorEntity.findByCreationDatetime", query = "SELECT p FROM PlanDevicecolorEntity p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlanDevicecolorEntity.findByLastModifiedDatetime", query = "SELECT p FROM PlanDevicecolorEntity p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")})
public class PlanDevicecolorEntity implements Serializable {

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
    private Collection<PlansDevicepriceEntity> plansDevicepriceCollection;

    public PlanDevicecolorEntity() {
    }

    public PlanDevicecolorEntity(Integer id) {
        this.id = id;
    }

    public PlanDevicecolorEntity(Integer id, boolean isActive, Date creationDatetime) {
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
    public Collection<PlansDevicepriceEntity> getPlansDevicepriceCollection() {
        return plansDevicepriceCollection;
    }

    public void setPlansDeviceprimaryCollection(Collection<PlansDevicepriceEntity> plansDevicepriceCollection) {
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
        if (!(object instanceof PlanDevicecolorEntity)) {
            return false;
        }
        PlanDevicecolorEntity other = (PlanDevicecolorEntity) object;
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
