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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

public class UserAccountDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sub_id")
    private Integer subId;
    @Column(name = "operator_type")
    private String operatorType;
    @Column(name = "registered_email")
    private String registeredEmail;
    @Column(name = "mobile_no")
    private String mobileNo;
    @Column(name = "location")
    private String location;
    @Column(name = "user_account_detailscol")
    private String userAccountDetailscol;
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
    private UserAccount id;

    public UserAccountDetails() {
    }

    public UserAccountDetails(Integer subId) {
        this.subId = subId;
    }

    public UserAccountDetails(Integer subId, Date creationDatetime, boolean isActive) {
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

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public String getRegisteredEmail() {
        return registeredEmail;
    }

    public void setRegisteredEmail(String registeredEmail) {
        this.registeredEmail = registeredEmail;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUserAccountDetailscol() {
        return userAccountDetailscol;
    }

    public void setUserAccountDetailscol(String userAccountDetailscol) {
        this.userAccountDetailscol = userAccountDetailscol;
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

    public UserAccount getId() {
        return id;
    }

    public void setId(UserAccount id) {
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
        if (!(object instanceof UserAccountDetails)) {
            return false;
        }
        UserAccountDetails other = (UserAccountDetails) object;
        if ((this.subId == null && other.subId != null) || (this.subId != null && !this.subId.equals(other.subId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.UserAccountDetails[ subId=" + subId + " ]";
    }
    
}
