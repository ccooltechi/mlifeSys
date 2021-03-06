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
import javax.persistence.CascadeType;
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
@Table(name = "plan_devicebrand", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanDevicebrand.findAll", query = "SELECT p FROM PlanDevicebrand p")
    , @NamedQuery(name = "PlanDevicebrand.findById", query = "SELECT p FROM PlanDevicebrand p WHERE p.id = :id")
    , @NamedQuery(name = "PlanDevicebrand.findByDeviceBrand", query = "SELECT p FROM PlanDevicebrand p WHERE p.deviceBrand = :deviceBrand")
    , @NamedQuery(name = "PlanDevicebrand.findByDeviceType", query = "SELECT p FROM PlanDevicebrand p WHERE p.deviceType = :deviceType")
    , @NamedQuery(name = "PlanDevicebrand.findByIsActive", query = "SELECT p FROM PlanDevicebrand p WHERE p.isActive = :isActive")
    , @NamedQuery(name = "PlanDevicebrand.findByCreationDatetime", query = "SELECT p FROM PlanDevicebrand p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlanDevicebrand.findByLastModifiedDatetime", query = "SELECT p FROM PlanDevicebrand p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")})
public class PlanDevicebrand implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "device_brand")
    private String deviceBrand;
    @Column(name = "device_type")
    private String deviceType;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brandType")
    private Collection<PlansDeviceprimary> plansDeviceprimaryCollection;

    public PlanDevicebrand() {
    }

    public PlanDevicebrand(Integer id) {
        this.id = id;
    }

    public PlanDevicebrand(Integer id, boolean isActive, Date creationDatetime) {
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

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
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
    public Collection<PlansDeviceprimary> getPlansDeviceprimaryCollection() {
        return plansDeviceprimaryCollection;
    }

    public void setPlansDeviceprimaryCollection(Collection<PlansDeviceprimary> plansDeviceprimaryCollection) {
        this.plansDeviceprimaryCollection = plansDeviceprimaryCollection;
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
        if (!(object instanceof PlanDevicebrand)) {
            return false;
        }
        PlanDevicebrand other = (PlanDevicebrand) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlanDevicebrand[ id=" + id + " ]";
    }
    
}
