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
@Table(name = "user_info", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserInfoEntity.findAll", query = "SELECT u FROM UserInfoEntity u")
    , @NamedQuery(name = "UserInfoEntity.findById", query = "SELECT u FROM UserInfoEntity u WHERE u.id = :id")
    , @NamedQuery(name = "UserInfoEntity.findByUserId", query = "SELECT u FROM UserInfoEntity u WHERE u.userId = :userId")
    , @NamedQuery(name = "UserInfoEntity.findBySsoUserId", query = "SELECT u FROM UserInfoEntity u WHERE u.ssoUserId = :ssoUserId")
    , @NamedQuery(name = "UserInfoEntity.findByCreationDatetime", query = "SELECT u FROM UserInfoEntity u WHERE u.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "UserInfoEntity.findByLastModifiedDatetime", query = "SELECT u FROM UserInfoEntity u WHERE u.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "UserInfoEntity.findByIsActive", query = "SELECT u FROM UserInfoEntity u WHERE u.isActive = :isActive")})
public class UserInfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Collection<UserInfoDetailsEntity> userInfoDetailsCollection;

    public UserInfoEntity() {
    }

    public UserInfoEntity(Integer id) {
        this.id = id;
    }

    public UserInfoEntity(Integer id, Date creationDatetime, boolean isActive) {
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    @XmlTransient
    public Collection<UserInfoDetailsEntity> getUserInfoDetailsCollection() {
        return userInfoDetailsCollection;
    }

    public void setUserInfoDetailsCollection(Collection<UserInfoDetailsEntity> userInfoDetailsCollection) {
        this.userInfoDetailsCollection = userInfoDetailsCollection;
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
        if (!(object instanceof UserInfoEntity)) {
            return false;
        }
        UserInfoEntity other = (UserInfoEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.UserInfo[ id=" + id + " ]";
    }
    
}
