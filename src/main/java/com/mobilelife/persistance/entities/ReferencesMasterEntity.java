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

/**
 *
 * @author deepakupadhyay
 */
@Entity
@Table(name = "references_master", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReferencesMasterEntity.findAll", query = "SELECT r FROM ReferencesMasterEntity r")
    , @NamedQuery(name = "ReferencesMasterEntity.findById", query = "SELECT r FROM ReferencesMasterEntity r WHERE r.id = :id")
    , @NamedQuery(name = "ReferencesMasterEntity.findByAppid", query = "SELECT r FROM ReferencesMasterEntity r WHERE r.appid = :appid")
    , @NamedQuery(name = "ReferencesMasterEntity.findBySsoUserId", query = "SELECT r FROM ReferencesMasterEntity r WHERE r.ssoUserId = :ssoUserId")
    , @NamedQuery(name = "ReferencesMasterEntity.findByCreationDatetime", query = "SELECT r FROM ReferencesMasterEntity r WHERE r.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "ReferencesMasterEntity.findByLastModifiedDatetime", query = "SELECT r FROM ReferencesMasterEntity r WHERE r.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "ReferencesMasterEntity.findByIsActive", query = "SELECT r FROM ReferencesMasterEntity r WHERE r.isActive = :isActive")
    , @NamedQuery(name = "ReferencesMasterEntity.findByPlanId", query = "SELECT r FROM ReferencesMasterEntity r WHERE r.planId = :planId")})
public class ReferencesMasterEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "appid")
    private String appid;
    @Column(name = "sso_user_id")
    private String ssoUserId;
    @Basic(optional = false)
    @Column(name = "creation_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDatetime;
    @Column(name = "last_modified_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDatetime;
    @Basic(optional = false)
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "plan_id")
    private String planId;
    @OneToMany(mappedBy = "referencesId")
    private Collection<ReferencesChildEntity> referencesChildCollection;

    public ReferencesMasterEntity() {
    }

    public ReferencesMasterEntity(Integer id) {
        this.id = id;
    }

    public ReferencesMasterEntity(Integer id, Date creationDatetime, boolean isActive) {
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

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSsoUserId() {
        return ssoUserId;
    }

    public void setSsoUserId(String ssoUserId) {
        this.ssoUserId = ssoUserId;
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

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    @XmlTransient
    public Collection<ReferencesChildEntity> getReferencesChildCollection() {
        return referencesChildCollection;
    }

    public void setReferencesChildCollection(Collection<ReferencesChildEntity> referencesChildCollection) {
        this.referencesChildCollection = referencesChildCollection;
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
        if (!(object instanceof ReferencesMasterEntity)) {
            return false;
        }
        ReferencesMasterEntity other = (ReferencesMasterEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.ReferencesMaster[ id=" + id + " ]";
    }
    
}
