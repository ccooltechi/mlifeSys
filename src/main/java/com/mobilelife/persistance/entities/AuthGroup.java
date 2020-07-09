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
@Table(name = "auth_group", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthGroup.findAll", query = "SELECT a FROM AuthGroup a")
    , @NamedQuery(name = "AuthGroup.findById", query = "SELECT a FROM AuthGroup a WHERE a.id = :id")
    , @NamedQuery(name = "AuthGroup.findByName", query = "SELECT a FROM AuthGroup a WHERE a.name = :name")
    , @NamedQuery(name = "AuthGroup.findByCreationDatetime", query = "SELECT a FROM AuthGroup a WHERE a.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "AuthGroup.findByLastModifiedDatetime", query = "SELECT a FROM AuthGroup a WHERE a.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "AuthGroup.findByIsActive", query = "SELECT a FROM AuthGroup a WHERE a.isActive = :isActive")})
public class AuthGroup implements Serializable {

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
    @Column(name = "creation_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDatetime;
    @Column(name = "last_modified_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDatetime;
    @Basic(optional = false)
    @Column(name = "is_active")
    private boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private Collection<AuthGroupPermissions> authGroupPermissionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private Collection<AuthUserGroups> authUserGroupsCollection;

    public AuthGroup() {
    }

    public AuthGroup(Integer id) {
        this.id = id;
    }

    public AuthGroup(Integer id, String name, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.name = name;
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
    public Collection<AuthUserGroups> getAuthUserGroupsCollection() {
        return authUserGroupsCollection;
    }

    public void setAuthUserGroupsCollection(Collection<AuthUserGroups> authUserGroupsCollection) {
        this.authUserGroupsCollection = authUserGroupsCollection;
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
        if (!(object instanceof AuthGroup)) {
            return false;
        }
        AuthGroup other = (AuthGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.AuthGroup[ id=" + id + " ]";
    }
    
}
