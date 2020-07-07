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
    @NamedQuery(name = "AlianceParternsAgeEntity.findAll", query = "SELECT a FROM AlianceParternsAgeEntity a")
    , @NamedQuery(name = "AlianceParternsAgeEntity.findById", query = "SELECT a FROM AlianceParternsAgeEntity a WHERE a.id = :id")
    , @NamedQuery(name = "AlianceParternsAgeEntity.findByCreationDatetime", query = "SELECT a FROM AlianceParternsAgeEntity a WHERE a.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "AlianceParternsAgeEntity.findByLastModifiedDatetime", query = "SELECT a FROM AlianceParternsAgeEntity a WHERE a.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "AlianceParternsAgeEntity.findByIsActive", query = "SELECT a FROM AlianceParternsAgeEntity a WHERE a.isActive = :isActive")
    , @NamedQuery(name = "AlianceParternsAgeEntity.findByAliancePartnerAgeFrom", query = "SELECT a FROM AlianceParternsAgeEntity a WHERE a.aliancePartnerAgeFrom = :aliancePartnerAgeFrom")
    , @NamedQuery(name = "AlianceParternsAgeEntity.findByAliancePartnerAgeTo", query = "SELECT a FROM AlianceParternsAgeEntity a WHERE a.aliancePartnerAgeTo = :aliancePartnerAgeTo")
    , @NamedQuery(name = "AlianceParternsAgeEntity.findByAliancePartnerTnc", query = "SELECT a FROM AlianceParternsAgeEntity a WHERE a.aliancePartnerTnc = :aliancePartnerTnc")})
public class AlianceParternsAgeEntity implements Serializable {

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
    private AlianceParternsEntity alianceParternsId;

    public AlianceParternsAgeEntity() {
    }

    public AlianceParternsAgeEntity(Integer id) {
        this.id = id;
    }

    public AlianceParternsAgeEntity(Integer id, Date creationDatetime, boolean isActive) {
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

    public AlianceParternsEntity getAlianceParternsId() {
        return alianceParternsId;
    }

    public void setAlianceParternsId(AlianceParternsEntity alianceParternsId) {
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
        if (!(object instanceof AlianceParternsAgeEntity)) {
            return false;
        }
        AlianceParternsAgeEntity other = (AlianceParternsAgeEntity) object;
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
