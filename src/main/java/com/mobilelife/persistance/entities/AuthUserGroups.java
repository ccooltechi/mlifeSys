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
@Table(name = "auth_user_groups", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthUserGroups.findAll", query = "SELECT a FROM AuthUserGroups a")
    , @NamedQuery(name = "AuthUserGroups.findById", query = "SELECT a FROM AuthUserGroups a WHERE a.id = :id")
    , @NamedQuery(name = "AuthUserGroups.findByCreationDatetime", query = "SELECT a FROM AuthUserGroups a WHERE a.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "AuthUserGroups.findByLastModifiedDatetime", query = "SELECT a FROM AuthUserGroups a WHERE a.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "AuthUserGroups.findByIsActive", query = "SELECT a FROM AuthUserGroups a WHERE a.isActive = :isActive")})
public class AuthUserGroups implements Serializable {

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
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AuthGroup groupId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AuthUser userId;

    public AuthUserGroups() {
    }

    public AuthUserGroups(Integer id) {
        this.id = id;
    }

    public AuthUserGroups(Integer id, Date creationDatetime, boolean isActive) {
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

    public AuthGroup getGroupId() {
        return groupId;
    }

    public void setGroupId(AuthGroup groupId) {
        this.groupId = groupId;
    }

    public AuthUser getUserId() {
        return userId;
    }

    public void setUserId(AuthUser userId) {
        this.userId = userId;
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
        if (!(object instanceof AuthUserGroups)) {
            return false;
        }
        AuthUserGroups other = (AuthUserGroups) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.AuthUserGroups[ id=" + id + " ]";
    }
    
}
