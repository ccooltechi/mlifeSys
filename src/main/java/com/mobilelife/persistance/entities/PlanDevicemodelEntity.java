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
@Table(name = "plan_devicemodel", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanDevicemodelEntity.findAll", query = "SELECT p FROM PlanDevicemodelEntity p")
    , @NamedQuery(name = "PlanDevicemodelEntity.findById", query = "SELECT p FROM PlanDevicemodelEntity p WHERE p.id = :id")
    , @NamedQuery(name = "PlanDevicemodelEntity.findByDeviceModel", query = "SELECT p FROM PlanDevicemodelEntity p WHERE p.deviceModel = :deviceModel")
    , @NamedQuery(name = "PlanDevicemodelEntity.findByIsActive", query = "SELECT p FROM PlanDevicemodelEntity p WHERE p.isActive = :isActive")
    , @NamedQuery(name = "PlanDevicemodelEntity.findByCreationDatetime", query = "SELECT p FROM PlanDevicemodelEntity p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlanDevicemodelEntity.findByLastModifiedDatetime", query = "SELECT p FROM PlanDevicemodelEntity p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")})
public class PlanDevicemodelEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "device_model")
    private String deviceModel;
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
    @OneToMany(mappedBy = "deviceModel")
    private Collection<PlansDeviceprimaryEntity> plansDeviceprimaryCollection;

    public PlanDevicemodelEntity() {
    }

    public PlanDevicemodelEntity(Integer id) {
        this.id = id;
    }

    public PlanDevicemodelEntity(Integer id, boolean isActive, Date creationDatetime) {
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

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
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
    public Collection<PlansDeviceprimaryEntity> getPlansDeviceprimaryCollection() {
        return plansDeviceprimaryCollection;
    }

    public void setPlansDeviceprimaryCollection(Collection<PlansDeviceprimaryEntity> plansDeviceprimaryCollection) {
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
        if (!(object instanceof PlanDevicemodelEntity)) {
            return false;
        }
        PlanDevicemodelEntity other = (PlanDevicemodelEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlanDevicemodel[ id=" + id + " ]";
    }
    
}
