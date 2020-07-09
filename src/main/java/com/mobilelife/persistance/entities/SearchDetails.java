/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.persistance.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author deepakupadhyay
 */
@Entity
@Table(name = "search_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SearchDetails.findAll", query = "SELECT s FROM SearchDetails s where s.isActive=0 ")
    , @NamedQuery(name = "SearchDetails.findById", query = "SELECT s FROM SearchDetails s WHERE s.id = :id")
    , @NamedQuery(name = "SearchDetails.findByTokenid", query = "SELECT s FROM SearchDetails s WHERE s.tokenid = :tokenid")
    , @NamedQuery(name = "SearchDetails.findByAppid", query = "SELECT s FROM SearchDetails s WHERE s.appid = :appid")
    , @NamedQuery(name = "SearchDetails.findBySsoUserId", query = "SELECT s FROM SearchDetails s WHERE s.ssoUserId = :ssoUserId")
    , @NamedQuery(name = "SearchDetails.findByIp", query = "SELECT s FROM SearchDetails s WHERE s.ip = :ip")
    , @NamedQuery(name = "SearchDetails.findByLocation", query = "SELECT s FROM SearchDetails s WHERE s.location = :location")
    , @NamedQuery(name = "SearchDetails.findByDevice", query = "SELECT s FROM SearchDetails s WHERE s.device = :device")
    , @NamedQuery(name = "SearchDetails.findByBrowser", query = "SELECT s FROM SearchDetails s WHERE s.browser = :browser")
    , @NamedQuery(name = "SearchDetails.findByIsMobile", query = "SELECT s FROM SearchDetails s WHERE s.isMobile = :isMobile")
    , @NamedQuery(name = "SearchDetails.findByMobileNo", query = "SELECT s FROM SearchDetails s WHERE s.mobileNo = :mobileNo")
    , @NamedQuery(name = "SearchDetails.findByMobileInfo", query = "SELECT s FROM SearchDetails s WHERE s.mobileInfo = :mobileInfo")
    , @NamedQuery(name = "SearchDetails.findByLongitude", query = "SELECT s FROM SearchDetails s WHERE s.longitude = :longitude")
    , @NamedQuery(name = "SearchDetails.findByLatitude", query = "SELECT s FROM SearchDetails s WHERE s.latitude = :latitude")
    , @NamedQuery(name = "SearchDetails.findByCreationDatetime", query = "SELECT s FROM SearchDetails s WHERE s.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "SearchDetails.findByLastModifiedDatetime", query = "SELECT s FROM SearchDetails s WHERE s.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "SearchDetails.findByIsActive", query = "SELECT s FROM SearchDetails s WHERE s.isActive = :isActive")
    , @NamedQuery(name = "SearchDetails.findByUserEmailid", query = "SELECT s FROM SearchDetails s WHERE s.userEmailid = :userEmailid")
    , @NamedQuery(name = "SearchDetails.findByReferer", query = "SELECT s FROM SearchDetails s WHERE s.referer = :referer")
    , @NamedQuery(name = "SearchDetails.findByClientOS", query = "SELECT s FROM SearchDetails s WHERE s.clientOS = :clientOS")
    , @NamedQuery(name = "SearchDetails.findByUserAgent", query = "SELECT s FROM SearchDetails s WHERE s.userAgent = :userAgent")})
public class SearchDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tokenid")
    private String tokenid;
    @Column(name = "appid")
    private String appid;
    @Column(name = "sso_user_id")
    private String ssoUserId;
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
    @Lob
    @Column(name = "searchResponse")
    private String searchResponse;
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
    @Column(name = "user_emailid")
    private String userEmailid;
    @Column(name = "referer")
    private String referer;
    @Column(name = "clientOS")
    private String clientOS;
    @Column(name = "user_agent")
    private String userAgent;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "searchId")
    private SearchDetailsChild searchDetailsChild;

    public SearchDetails() {
    }

    public SearchDetails(Integer id) {
        this.id = id;
    }

    public SearchDetails(Integer id, Date creationDatetime, boolean isActive) {
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

    public String getSsoUserId() {
        return ssoUserId;
    }

    public void setSsoUserId(String ssoUserId) {
        this.ssoUserId = ssoUserId;
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

    public String getSearchResponse() {
		return searchResponse;
	}

	public void setSearchResponse(String searchResponse) {
		this.searchResponse = searchResponse;
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

    public String getUserEmailid() {
        return userEmailid;
    }

    public void setUserEmailid(String userEmailid) {
        this.userEmailid = userEmailid;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getClientOS() {
        return clientOS;
    }

    public void setClientOS(String clientOS) {
        this.clientOS = clientOS;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public SearchDetailsChild getSearchDetailsChild() {
        return searchDetailsChild;
    }

    public void setSearchDetailsChild(SearchDetailsChild searchDetailsChild) {
        this.searchDetailsChild = searchDetailsChild;
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
        if (!(object instanceof SearchDetails)) {
            return false;
        }
        SearchDetails other = (SearchDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.SearchDetails[ id=" + id + " ]";
    }
    
}
