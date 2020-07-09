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
import javax.persistence.Lob;
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
@Table(name = "plans_operator_locale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansOperatorLocale.findAll", query = "SELECT p FROM PlansOperatorLocale p")
    , @NamedQuery(name = "PlansOperatorLocale.findById", query = "SELECT p FROM PlansOperatorLocale p WHERE p.id = :id")
    , @NamedQuery(name = "PlansOperatorLocale.findByOperatorId", query = "SELECT p FROM PlansOperatorLocale p WHERE p.operatorId = :operatorId")
    , @NamedQuery(name = "PlansOperatorLocale.findByLocale", query = "SELECT p FROM PlansOperatorLocale p WHERE p.locale = :locale")
    , @NamedQuery(name = "PlansOperatorLocale.findByLogo", query = "SELECT p FROM PlansOperatorLocale p WHERE p.logo = :logo")
    , @NamedQuery(name = "PlansOperatorLocale.findByCreationDatetime", query = "SELECT p FROM PlansOperatorLocale p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansOperatorLocale.findByLastModifiedDatetime", query = "SELECT p FROM PlansOperatorLocale p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansOperatorLocale.findByIsActive", query = "SELECT p FROM PlansOperatorLocale p WHERE p.isActive = :isActive")})
public class PlansOperatorLocale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "operator_id")
    private int operatorId;
    @Column(name = "locale")
    private String locale;
    @Basic(optional = false)
    @Lob
    @Column(name = "operator_name")
    private String operatorName;
    @Column(name = "logo")
    private String logo;
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

    public PlansOperatorLocale() {
    }

    public PlansOperatorLocale(Integer id) {
        this.id = id;
    }

    public PlansOperatorLocale(Integer id, int operatorId, String operatorName, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.creationDatetime = creationDatetime;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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
        if (!(object instanceof PlansOperatorLocale)) {
            return false;
        }
        PlansOperatorLocale other = (PlansOperatorLocale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansOperatorLocale[ id=" + id + " ]";
    }
    
}
