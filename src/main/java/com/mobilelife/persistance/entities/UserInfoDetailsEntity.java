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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "user_info_details", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserInfoDetailsEntity.findAll", query = "SELECT u FROM UserInfoDetailsEntity u")
    , @NamedQuery(name = "UserInfoDetailsEntity.findBySubId", query = "SELECT u FROM UserInfoDetailsEntity u WHERE u.subId = :subId")
    , @NamedQuery(name = "UserInfoDetailsEntity.findByTokenid", query = "SELECT u FROM UserInfoDetailsEntity u WHERE u.tokenid = :tokenid")
    , @NamedQuery(name = "UserInfoDetailsEntity.findByAppid", query = "SELECT u FROM UserInfoDetailsEntity u WHERE u.appid = :appid")
    , @NamedQuery(name = "UserInfoDetailsEntity.findByIp", query = "SELECT u FROM UserInfoDetailsEntity u WHERE u.ip = :ip")
    , @NamedQuery(name = "UserInfoDetailsEntity.findByLocation", query = "SELECT u FROM UserInfoDetailsEntity u WHERE u.location = :location")
    , @NamedQuery(name = "UserInfoDetailsEntity.findByDevice", query = "SELECT u FROM UserInfoDetailsEntity u WHERE u.device = :device")
    , @NamedQuery(name = "UserInfoDetailsEntity.findByBrowser", query = "SELECT u FROM UserInfoDetailsEntity u WHERE u.browser = :browser")
    , @NamedQuery(name = "UserInfoDetailsEntity.findByIsMobile", query = "SELECT u FROM UserInfoDetailsEntity u WHERE u.isMobile = :isMobile")
    , @NamedQuery(name = "UserInfoDetailsEntity.findByMobileNo", query = "SELECT u FROM UserInfoDetailsEntity u WHERE u.mobileNo = :mobileNo")
    , @NamedQuery(name = "UserInfoDetailsEntity.findByMobileInfo", query = "SELECT u FROM UserInfoDetailsEntity u WHERE u.mobileInfo = :mobileInfo")
    , @NamedQuery(name = "UserInfoDetailsEntity.findByLongitude", query = "SELECT u FROM UserInfoDetailsEntity u WHERE u.longitude = :longitude")
    , @NamedQuery(name = "UserInfoDetailsEntity.findByLatitude", query = "SELECT u FROM UserInfoDetailsEntity u WHERE u.latitude = :latitude")
    , @NamedQuery(name = "UserInfoDetailsEntity.findByCreationDatetime", query = "SELECT u FROM UserInfoDetailsEntity u WHERE u.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "UserInfoDetailsEntity.findByLastModifiedDatetime", query = "SELECT u FROM UserInfoDetailsEntity u WHERE u.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "UserInfoDetailsEntity.findByIsActive", query = "SELECT u FROM UserInfoDetailsEntity u WHERE u.isActive = :isActive")})
public class UserInfoDetailsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sub_id")
    private Integer subId;
    @Column(name = "tokenid")
    private String tokenid;
    @Column(name = "appid")
    private String appid;
    @Column(name = "ip")
    private String ip;
    @Column(name = "location")
    private String location;
    @Column(name = "device")
    private String device;
    @Column(name = "browser")
    private String browser;
    @Column(name = "is_mobile")
    private String isMobile;
    @Column(name = "mobile_no")
    private String mobileNo;
    @Column(name = "mobile_info")
    private String mobileInfo;
    @Column(name = "longitude")
    private String longitude;
    @Column(name = "latitude")
    private String latitude;
    @Lob
    @Column(name = "searchRequest")
    private String searchRequest;
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
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserInfoEntity id;

    public UserInfoDetailsEntity() {
    }

    public UserInfoDetailsEntity(Integer subId) {
        this.subId = subId;
    }

    public UserInfoDetailsEntity(Integer subId, Date creationDatetime, boolean isActive) {
        this.subId = subId;
        this.creationDatetime = creationDatetime;
        this.isActive = isActive;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getTokenid() {
        return tokenid;
    }

    public void setTokenid(String tokenid) {
        this.tokenid = tokenid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getIsMobile() {
        return isMobile;
    }

    public void setIsMobile(String isMobile) {
        this.isMobile = isMobile;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getMobileInfo() {
        return mobileInfo;
    }

    public void setMobileInfo(String mobileInfo) {
        this.mobileInfo = mobileInfo;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getSearchRequest() {
        return searchRequest;
    }

    public void setSearchRequest(String searchRequest) {
        this.searchRequest = searchRequest;
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

    public UserInfoEntity getId() {
        return id;
    }

    public void setId(UserInfoEntity id) {
        this.id = id;
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
        if (!(object instanceof UserInfoDetailsEntity)) {
            return false;
        }
        UserInfoDetailsEntity other = (UserInfoDetailsEntity) object;
        if ((this.subId == null && other.subId != null) || (this.subId != null && !this.subId.equals(other.subId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.UserInfoDetails[ subId=" + subId + " ]";
    }
    
}
