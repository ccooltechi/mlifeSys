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
import javax.persistence.Id;
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
@Table(name = "user_access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAccess.findAll", query = "SELECT u FROM UserAccess u")
    , @NamedQuery(name = "UserAccess.findByRid", query = "SELECT u FROM UserAccess u WHERE u.rid = :rid")
    , @NamedQuery(name = "UserAccess.findByUserName", query = "SELECT u FROM UserAccess u WHERE u.userName = :userName")
    , @NamedQuery(name = "UserAccess.findByPassword", query = "SELECT u FROM UserAccess u WHERE u.password = :password")
    , @NamedQuery(name = "UserAccess.findByAppId", query = "SELECT u FROM UserAccess u WHERE u.appId = :appId")
    , @NamedQuery(name = "UserAccess.findByCreationDatetime", query = "SELECT u FROM UserAccess u WHERE u.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "UserAccess.findByLastModDatetime", query = "SELECT u FROM UserAccess u WHERE u.lastModDatetime = :lastModDatetime")
    , @NamedQuery(name = "UserAccess.findByOnline", query = "SELECT u FROM UserAccess u WHERE u.online = :online")
    , @NamedQuery(name = "UserAccess.findByRegisteredName", query = "SELECT u FROM UserAccess u WHERE u.registeredName = :registeredName")
    , @NamedQuery(name = "UserAccess.findByContactNo", query = "SELECT u FROM UserAccess u WHERE u.contactNo = :contactNo")
    , @NamedQuery(name = "UserAccess.findByAccessSalt", query = "SELECT u FROM UserAccess u WHERE u.accessSalt = :accessSalt")
    , @NamedQuery(name = "UserAccess.findByAccessKey", query = "SELECT u FROM UserAccess u WHERE u.accessKey = :accessKey")})
public class UserAccess implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rid")
    private Long rid;
    @Basic(optional = false)
    @Column(name = "userName")
    private String userName;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "app_id")
    private String appId;
    @Basic(optional = false)
    @Column(name = "creation_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDatetime;
    @Basic(optional = false)
    @Column(name = "last_mod_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModDatetime;
    @Basic(optional = false)
    @Column(name = "online")
    private int online;
    @Column(name = "registered_name")
    private String registeredName;
    @Column(name = "contact_no")
    private String contactNo;
    @Column(name = "access_key")
    private String accessKey;
    @Column(name = "access_salt")
    private String accessSalt;

    public UserAccess() {
    }

    public UserAccess(Long rid) {
        this.rid = rid;
    }

    public UserAccess(Long rid, String userName, String password, String appId, Date creationDatetime, Date lastModDatetime, int online) {
        this.rid = rid;
        this.userName = userName;
        this.password = password;
        this.appId = appId;
        this.creationDatetime = creationDatetime;
        this.lastModDatetime = lastModDatetime;
        this.online = online;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Date getCreationDatetime() {
        return creationDatetime;
    }

    public void setCreationDatetime(Date creationDatetime) {
        this.creationDatetime = creationDatetime;
    }

    public Date getLastModDatetime() {
        return lastModDatetime;
    }

    public void setLastModDatetime(Date lastModDatetime) {
        this.lastModDatetime = lastModDatetime;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public String getRegisteredName() {
        return registeredName;
    }

    public void setRegisteredName(String registeredName) {
        this.registeredName = registeredName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getAccessSalt() {
        return accessSalt;
    }

    public void setAccessSalt(String accessSalt) {
        this.accessSalt = accessSalt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rid != null ? rid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAccess)) {
            return false;
        }
        UserAccess other = (UserAccess) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.UserAccess[ rid=" + rid + " ]";
    }
    
}
