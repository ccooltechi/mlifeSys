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
    @NamedQuery(name = "AlianceParterns.findAll", query = "SELECT a FROM AlianceParterns a")
    , @NamedQuery(name = "AlianceParterns.findById", query = "SELECT a FROM AlianceParterns a WHERE a.id = :id")
    , @NamedQuery(name = "AlianceParterns.findByCreationDatetime", query = "SELECT a FROM AlianceParterns a WHERE a.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "AlianceParterns.findByLastModifiedDatetime", query = "SELECT a FROM AlianceParterns a WHERE a.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "AlianceParterns.findByIsActive", query = "SELECT a FROM AlianceParterns a WHERE a.isActive = :isActive")
    , @NamedQuery(name = "AlianceParterns.findByAliancePartnerCode", query = "SELECT a FROM AlianceParterns a WHERE a.aliancePartnerCode = :aliancePartnerCode")
    , @NamedQuery(name = "AlianceParterns.findByAliancePartnerName", query = "SELECT a FROM AlianceParterns a WHERE a.aliancePartnerName = :aliancePartnerName")
    , @NamedQuery(name = "AlianceParterns.findByAliancePartnerLogo", query = "SELECT a FROM AlianceParterns a WHERE a.aliancePartnerLogo = :aliancePartnerLogo")
    , @NamedQuery(name = "AlianceParterns.findByAliancePartnerTnc", query = "SELECT a FROM AlianceParterns a WHERE a.aliancePartnerTnc = :aliancePartnerTnc")})
public class AlianceParterns implements Serializable {

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
    private Collection<AlianceParternsAge> alianceParternsAgeCollection;
    @JoinColumn(name = "aliance_campaign_id", referencedColumnName = "id")
    @ManyToOne
    private AlianceCampaign alianceCampaignId;
    @OneToMany(mappedBy = "alianceParternsId")
    private Collection<ParternsOperatorOffers> parternsOperatorOffersCollection;

    public AlianceParterns() {
    }

    public AlianceParterns(Integer id) {
        this.id = id;
    }

    public AlianceParterns(Integer id, Date creationDatetime, boolean isActive) {
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
    public Collection<AlianceParternsAge> getAlianceParternsAgeCollection() {
        return alianceParternsAgeCollection;
    }

    public void setAlianceParternsAgeCollection(Collection<AlianceParternsAge> alianceParternsAgeCollection) {
        this.alianceParternsAgeCollection = alianceParternsAgeCollection;
    }

    public AlianceCampaign getAlianceCampaignId() {
        return alianceCampaignId;
    }

    public void setAlianceCampaignId(AlianceCampaign alianceCampaignId) {
        this.alianceCampaignId = alianceCampaignId;
    }

    @XmlTransient
    public Collection<ParternsOperatorOffers> getParternsOperatorOffersCollection() {
        return parternsOperatorOffersCollection;
    }

    public void setParternsOperatorOffersCollection(Collection<ParternsOperatorOffers> parternsOperatorOffersCollection) {
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
        if (!(object instanceof AlianceParterns)) {
            return false;
        }
        AlianceParterns other = (AlianceParterns) object;
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
