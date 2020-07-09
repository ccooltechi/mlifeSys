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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author deepakupadhyay
 */
@Entity
@Table(name = "common_locale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommonLocale.findAll", query = "SELECT c FROM CommonLocale c")
    , @NamedQuery(name = "CommonLocale.findById", query = "SELECT c FROM CommonLocale c WHERE c.id = :id")
    , @NamedQuery(name = "CommonLocale.findByLocale", query = "SELECT c FROM CommonLocale c WHERE c.locale = :locale")
    , @NamedQuery(name = "CommonLocale.findByKeyPair", query = "SELECT c FROM CommonLocale c WHERE c.keyPair = :keyPair")
    , @NamedQuery(name = "CommonLocale.findByValuePair", query = "SELECT c FROM CommonLocale c WHERE c.valuePair = :valuePair")
    , @NamedQuery(name = "CommonLocale.findByCreationDatetime", query = "SELECT c FROM CommonLocale c WHERE c.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "CommonLocale.findByLastModifiedDatetime", query = "SELECT c FROM CommonLocale c WHERE c.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "CommonLocale.findByIsActive", query = "SELECT c FROM CommonLocale c WHERE c.isActive = :isActive")})
public class CommonLocale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "locale")
    private String locale;
    @Column(name = "key_pair")
    private String keyPair;
    @Column(name = "value_pair")
    private String valuePair;
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

    public CommonLocale() {
    }

    public CommonLocale(Integer id) {
        this.id = id;
    }

    public CommonLocale(Integer id, Date creationDatetime, boolean isActive) {
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

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getKeyPair() {
        return keyPair;
    }

    public void setKeyPair(String keyPair) {
        this.keyPair = keyPair;
    }

    public String getValuePair() {
        return valuePair;
    }

    public void setValuePair(String valuePair) {
        this.valuePair = valuePair;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommonLocale)) {
            return false;
        }
        CommonLocale other = (CommonLocale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.CommonLocale[ id=" + id + " ]";
    }
    
}
