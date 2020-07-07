/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.persistance.entities;

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

/**
 *
 * @author pods
 */
@Entity
@Table(name = "auth_group_permissions", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthGroupPermissionsEntity.findAll", query = "SELECT a FROM AuthGroupPermissionsEntity a")
    , @NamedQuery(name = "AuthGroupPermissionsEntity.findById", query = "SELECT a FROM AuthGroupPermissionsEntity a WHERE a.id = :id")
    , @NamedQuery(name = "AuthGroupPermissionsEntity.findByCreationDatetime", query = "SELECT a FROM AuthGroupPermissionsEntity a WHERE a.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "AuthGroupPermissionsEntity.findByLastModifiedDatetime", query = "SELECT a FROM AuthGroupPermissionsEntity a WHERE a.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "AuthGroupPermissionsEntity.findByIsActive", query = "SELECT a FROM AuthGroupPermissionsEntity a WHERE a.isActive = :isActive")})
public class AuthGroupPermissionsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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
    @JoinColumn(name = "permission_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AuthPermissionEntity permissionId;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AuthGroupEntity groupId;

    public AuthGroupPermissionsEntity() {
    }

    public AuthGroupPermissionsEntity(Integer id) {
        this.id = id;
    }

    public AuthGroupPermissionsEntity(Integer id, Date creationDatetime, boolean isActive) {
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

    public AuthPermissionEntity getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(AuthPermissionEntity permissionId) {
        this.permissionId = permissionId;
    }

    public AuthGroupEntity getGroupId() {
        return groupId;
    }

    public void setGroupId(AuthGroupEntity groupId) {
        this.groupId = groupId;
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
        if (!(object instanceof AuthGroupPermissionsEntity)) {
            return false;
        }
        AuthGroupPermissionsEntity other = (AuthGroupPermissionsEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.AuthGroupPermissions[ id=" + id + " ]";
    }
    
}
