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
@Table(name = "aliance_parterns_age", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlianceParternsAge.findAll", query = "SELECT a FROM AlianceParternsAge a")
    , @NamedQuery(name = "AlianceParternsAge.findById", query = "SELECT a FROM AlianceParternsAge a WHERE a.id = :id")
    , @NamedQuery(name = "AlianceParternsAge.findByCreationDatetime", query = "SELECT a FROM AlianceParternsAge a WHERE a.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "AlianceParternsAge.findByLastModifiedDatetime", query = "SELECT a FROM AlianceParternsAge a WHERE a.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "AlianceParternsAge.findByIsActive", query = "SELECT a FROM AlianceParternsAge a WHERE a.isActive = :isActive")
    , @NamedQuery(name = "AlianceParternsAge.findByAliancePartnerAgeFrom", query = "SELECT a FROM AlianceParternsAge a WHERE a.aliancePartnerAgeFrom = :aliancePartnerAgeFrom")
    , @NamedQuery(name = "AlianceParternsAge.findByAliancePartnerAgeTo", query = "SELECT a FROM AlianceParternsAge a WHERE a.aliancePartnerAgeTo = :aliancePartnerAgeTo")
    , @NamedQuery(name = "AlianceParternsAge.findByAliancePartnerTnc", query = "SELECT a FROM AlianceParternsAge a WHERE a.aliancePartnerTnc = :aliancePartnerTnc")})
public class AlianceParternsAge implements Serializable {

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
    @Column(name = "aliance_partner_age_from")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aliancePartnerAgeFrom;
    @Column(name = "aliance_partner_age_to")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aliancePartnerAgeTo;
    @Column(name = "aliance_partner_tnc")
    private String aliancePartnerTnc;
    @JoinColumn(name = "aliance_parterns_id", referencedColumnName = "id")
    @ManyToOne
    private AlianceParterns alianceParternsId;

    public AlianceParternsAge() {
    }

    public AlianceParternsAge(Integer id) {
        this.id = id;
    }

    public AlianceParternsAge(Integer id, Date creationDatetime, boolean isActive) {
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

    public Date getAliancePartnerAgeFrom() {
        return aliancePartnerAgeFrom;
    }

    public void setAliancePartnerAgeFrom(Date aliancePartnerAgeFrom) {
        this.aliancePartnerAgeFrom = aliancePartnerAgeFrom;
    }

    public Date getAliancePartnerAgeTo() {
        return aliancePartnerAgeTo;
    }

    public void setAliancePartnerAgeTo(Date aliancePartnerAgeTo) {
        this.aliancePartnerAgeTo = aliancePartnerAgeTo;
    }

    public String getAliancePartnerTnc() {
        return aliancePartnerTnc;
    }

    public void setAliancePartnerTnc(String aliancePartnerTnc) {
        this.aliancePartnerTnc = aliancePartnerTnc;
    }

    public AlianceParterns getAlianceParternsId() {
        return alianceParternsId;
    }

    public void setAlianceParternsId(AlianceParterns alianceParternsId) {
        this.alianceParternsId = alianceParternsId;
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
        if (!(object instanceof AlianceParternsAge)) {
            return false;
        }
        AlianceParternsAge other = (AlianceParternsAge) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.AlianceParternsAge[ id=" + id + " ]";
    }
    
}
