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
 * @author pods
 */
@Entity
@Table(name = "auth_permission", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthPermission.findAll", query = "SELECT a FROM AuthPermission a")
    , @NamedQuery(name = "AuthPermission.findById", query = "SELECT a FROM AuthPermission a WHERE a.id = :id")
    , @NamedQuery(name = "AuthPermission.findByName", query = "SELECT a FROM AuthPermission a WHERE a.name = :name")
    , @NamedQuery(name = "AuthPermission.findByContentTypeId", query = "SELECT a FROM AuthPermission a WHERE a.contentTypeId = :contentTypeId")
    , @NamedQuery(name = "AuthPermission.findByCodename", query = "SELECT a FROM AuthPermission a WHERE a.codename = :codename")
    , @NamedQuery(name = "AuthPermission.findByCreationDatetime", query = "SELECT a FROM AuthPermission a WHERE a.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "AuthPermission.findByLastModifiedDatetime", query = "SELECT a FROM AuthPermission a WHERE a.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "AuthPermission.findByIsActive", query = "SELECT a FROM AuthPermission a WHERE a.isActive = :isActive")})
public class AuthPermission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "content_type_id")
    private int contentTypeId;
    @Basic(optional = false)
    @Column(name = "codename")
    private String codename;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permissionId")
    private Collection<AuthGroupPermissions> authGroupPermissionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permissionId")
    private Collection<AuthUserUserPermissions> authUserUserPermissionsCollection;

    public AuthPermission() {
    }

    public AuthPermission(Integer id) {
        this.id = id;
    }

    public AuthPermission(Integer id, String name, int contentTypeId, String codename, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.name = name;
        this.contentTypeId = contentTypeId;
        this.codename = codename;
        this.creationDatetime = creationDatetime;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContentTypeId() {
        return contentTypeId;
    }

    public void setContentTypeId(int contentTypeId) {
        this.contentTypeId = contentTypeId;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
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

    @XmlTransient
    public Collection<AuthGroupPermissions> getAuthGroupPermissionsCollection() {
        return authGroupPermissionsCollection;
    }

    public void setAuthGroupPermissionsCollection(Collection<AuthGroupPermissions> authGroupPermissionsCollection) {
        this.authGroupPermissionsCollection = authGroupPermissionsCollection;
    }

    @XmlTransient
    public Collection<AuthUserUserPermissions> getAuthUserUserPermissionsCollection() {
        return authUserUserPermissionsCollection;
    }

    public void setAuthUserUserPermissionsCollection(Collection<AuthUserUserPermissions> authUserUserPermissionsCollection) {
        this.authUserUserPermissionsCollection = authUserUserPermissionsCollection;
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
        if (!(object instanceof AuthPermission)) {
            return false;
        }
        AuthPermission other = (AuthPermission) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.AuthPermission[ id=" + id + " ]";
    }
    
}
