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
@Table(name = "aliance_campaign", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlianceCampaign.findAll", query = "SELECT a FROM AlianceCampaign a")
    , @NamedQuery(name = "AlianceCampaign.findById", query = "SELECT a FROM AlianceCampaign a WHERE a.id = :id")
    , @NamedQuery(name = "AlianceCampaign.findByCreationDatetime", query = "SELECT a FROM AlianceCampaign a WHERE a.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "AlianceCampaign.findByLastModifiedDatetime", query = "SELECT a FROM AlianceCampaign a WHERE a.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "AlianceCampaign.findByIsActive", query = "SELECT a FROM AlianceCampaign a WHERE a.isActive = :isActive")
    , @NamedQuery(name = "AlianceCampaign.findByCampaignCode", query = "SELECT a FROM AlianceCampaign a WHERE a.campaignCode = :campaignCode")
    , @NamedQuery(name = "AlianceCampaign.findByCampaignName", query = "SELECT a FROM AlianceCampaign a WHERE a.campaignName = :campaignName")
    , @NamedQuery(name = "AlianceCampaign.findByCampaignLogo", query = "SELECT a FROM AlianceCampaign a WHERE a.campaignLogo = :campaignLogo")
    , @NamedQuery(name = "AlianceCampaign.findByCampaignTnc", query = "SELECT a FROM AlianceCampaign a WHERE a.campaignTnc = :campaignTnc")})
public class AlianceCampaign implements Serializable {

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
    @Column(name = "campaign_code")
    private String campaignCode;
    @Column(name = "campaign_name")
    private String campaignName;
    @Column(name = "campaign_logo")
    private String campaignLogo;
    @Column(name = "campaign_tnc")
    private String campaignTnc;
    @OneToMany(mappedBy = "alianceCampaignId")
    private Collection<AlianceParterns> alianceParternsCollection;
    @OneToMany(mappedBy = "alianceCampaignId")
    private Collection<AlianceCampaignAge> alianceCampaignAgeCollection;

    public AlianceCampaign() {
    }

    public AlianceCampaign(Integer id) {
        this.id = id;
    }

    public AlianceCampaign(Integer id, Date creationDatetime, boolean isActive) {
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

    public String getCampaignCode() {
        return campaignCode;
    }

    public void setCampaignCode(String campaignCode) {
        this.campaignCode = campaignCode;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getCampaignLogo() {
        return campaignLogo;
    }

    public void setCampaignLogo(String campaignLogo) {
        this.campaignLogo = campaignLogo;
    }

    public String getCampaignTnc() {
        return campaignTnc;
    }

    public void setCampaignTnc(String campaignTnc) {
        this.campaignTnc = campaignTnc;
    }

    @XmlTransient
    public Collection<AlianceParterns> getAlianceParternsCollection() {
        return alianceParternsCollection;
    }

    public void setAlianceParternsCollection(Collection<AlianceParterns> alianceParternsCollection) {
        this.alianceParternsCollection = alianceParternsCollection;
    }

    @XmlTransient
    public Collection<AlianceCampaignAge> getAlianceCampaignAgeCollection() {
        return alianceCampaignAgeCollection;
    }

    public void setAlianceCampaignAgeCollection(Collection<AlianceCampaignAge> alianceCampaignAgeCollection) {
        this.alianceCampaignAgeCollection = alianceCampaignAgeCollection;
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
        if (!(object instanceof AlianceCampaign)) {
            return false;
        }
        AlianceCampaign other = (AlianceCampaign) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.AlianceCampaign[ id=" + id + " ]";
    }
    
}
