/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.controler.mapper.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

public class UserAccessTokenBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "rid")
    private long rid;
    @Column(name = "creation_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDatetime;
    @Column(name = "last_mod_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModDatetime;
    @Column(name = "app_id")
    private String appId;
    @Column(name = "access_token")
    private String accessToken;
    @Column(name = "token_validity")
    private String tokenValidity;
    @Column(name = "online")
    private Integer online;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sub_id")
    private Integer subId;

    public UserAccessTokenBean() {
    }

    public UserAccessTokenBean(Integer subId) {
        this.subId = subId;
    }

    public UserAccessTokenBean(Integer subId, long rid) {
        this.subId = subId;
        this.rid = rid;
    }

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
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

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenValidity() {
        return tokenValidity;
    }

    public void setTokenValidity(String tokenValidity) {
        this.tokenValidity = tokenValidity;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subId != null ? subId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAccessTokenBean)) {
            return false;
        }
        UserAccessTokenBean other = (UserAccessTokenBean) object;
        if ((this.subId == null && other.subId != null) || (this.subId != null && !this.subId.equals(other.subId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.UserAccessToken[ subId=" + subId + " ]";
    }
    
}
