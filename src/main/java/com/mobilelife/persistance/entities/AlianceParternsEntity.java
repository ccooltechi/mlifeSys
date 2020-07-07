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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "aliance_parterns", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlianceParternsEntity.findAll", query = "SELECT a FROM AlianceParternsEntity a")
    , @NamedQuery(name = "AlianceParternsEntity.findById", query = "SELECT a FROM AlianceParternsEntity a WHERE a.id = :id")
    , @NamedQuery(name = "AlianceParternsEntity.findByCreationDatetime", query = "SELECT a FROM AlianceParternsEntity a WHERE a.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "AlianceParternsEntity.findByLastModifiedDatetime", query = "SELECT a FROM AlianceParternsEntity a WHERE a.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "AlianceParternsEntity.findByIsActive", query = "SELECT a FROM AlianceParternsEntity a WHERE a.isActive = :isActive")
    , @NamedQuery(name = "AlianceParternsEntity.findByAliancePartnerCode", query = "SELECT a FROM AlianceParternsEntity a WHERE a.aliancePartnerCode = :aliancePartnerCode")
    , @NamedQuery(name = "AlianceParternsEntity.findByAliancePartnerName", query = "SELECT a FROM AlianceParternsEntity a WHERE a.aliancePartnerName = :aliancePartnerName")
    , @NamedQuery(name = "AlianceParternsEntity.findByAliancePartnerLogo", query = "SELECT a FROM AlianceParternsEntity a WHERE a.aliancePartnerLogo = :aliancePartnerLogo")
    , @NamedQuery(name = "AlianceParternsEntity.findByAliancePartnerTnc", query = "SELECT a FROM AlianceParternsEntity a WHERE a.aliancePartnerTnc = :aliancePartnerTnc")})
public class AlianceParternsEntity implements Serializable {

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
    @Column(name = "aliance_partner_code")
    private String aliancePartnerCode;
    @Column(name = "aliance_partner_name")
    private String aliancePartnerName;
    @Column(name = "aliance_partner_logo")
    private String aliancePartnerLogo;
    @Column(name = "aliance_partner_tnc")
    private String aliancePartnerTnc;
    @OneToMany(mappedBy = "alianceParternsId")
    private Collection<AlianceParternsAgeEntity> alianceParternsAgeCollection;
    @JoinColumn(name = "aliance_campaign_id", referencedColumnName = "id")
    @ManyToOne
    private AlianceCampaignEntity alianceCampaignId;
    @OneToMany(mappedBy = "alianceParternsId")
    private Collection<ParternsOperatorOffersEntity> parternsOperatorOffersCollection;

    public AlianceParternsEntity() {
    }

    public AlianceParternsEntity(Integer id) {
        this.id = id;
    }

    public AlianceParternsEntity(Integer id, Date creationDatetime, boolean isActive) {
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

    public String getAliancePartnerCode() {
        return aliancePartnerCode;
    }

    public void setAliancePartnerCode(String aliancePartnerCode) {
        this.aliancePartnerCode = aliancePartnerCode;
    }

    public String getAliancePartnerName() {
        return aliancePartnerName;
    }

    public void setAliancePartnerName(String aliancePartnerName) {
        this.aliancePartnerName = aliancePartnerName;
    }

    public String getAliancePartnerLogo() {
        return aliancePartnerLogo;
    }

    public void setAliancePartnerLogo(String aliancePartnerLogo) {
        this.aliancePartnerLogo = aliancePartnerLogo;
    }

    public String getAliancePartnerTnc() {
        return aliancePartnerTnc;
    }

    public void setAliancePartnerTnc(String aliancePartnerTnc) {
        this.aliancePartnerTnc = aliancePartnerTnc;
    }

    @XmlTransient
    public Collection<AlianceParternsAgeEntity> getAlianceParternsAgeCollection() {
        return alianceParternsAgeCollection;
    }

    public void setAlianceParternsAgeCollection(Collection<AlianceParternsAgeEntity> alianceParternsAgeCollection) {
        this.alianceParternsAgeCollection = alianceParternsAgeCollection;
    }

    public AlianceCampaignEntity getAlianceCampaignId() {
        return alianceCampaignId;
    }

    public void setAlianceCampaignId(AlianceCampaignEntity alianceCampaignId) {
        this.alianceCampaignId = alianceCampaignId;
    }

    @XmlTransient
    public Collection<ParternsOperatorOffersEntity> getParternsOperatorOffersCollection() {
        return parternsOperatorOffersCollection;
    }

    public void setParternsOperatorOffersCollection(Collection<ParternsOperatorOffersEntity> parternsOperatorOffersCollection) {
        this.parternsOperatorOffersCollection = parternsOperatorOffersCollection;
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
        if (!(object instanceof AlianceParternsEntity)) {
            return false;
        }
        AlianceParternsEntity other = (AlianceParternsEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.AlianceParterns[ id=" + id + " ]";
    }
    
}
