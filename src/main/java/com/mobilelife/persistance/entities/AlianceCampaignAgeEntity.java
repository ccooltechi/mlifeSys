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
@Table(name = "aliance_campaign_age", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlianceCampaignAgeEntity.findAll", query = "SELECT a FROM AlianceCampaignAgeEntity a")
    , @NamedQuery(name = "AlianceCampaignAgeEntity.findById", query = "SELECT a FROM AlianceCampaignAgeEntity a WHERE a.id = :id")
    , @NamedQuery(name = "AlianceCampaignAgeEntity.findByCreationDatetime", query = "SELECT a FROM AlianceCampaignAgeEntity a WHERE a.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "AlianceCampaignAgeEntity.findByLastModifiedDatetime", query = "SELECT a FROM AlianceCampaignAgeEntity a WHERE a.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "AlianceCampaignAgeEntity.findByIsActive", query = "SELECT a FROM AlianceCampaignAgeEntity a WHERE a.isActive = :isActive")
    , @NamedQuery(name = "AlianceCampaignAgeEntity.findByCampaignAgeFrom", query = "SELECT a FROM AlianceCampaignAgeEntity a WHERE a.campaignAgeFrom = :campaignAgeFrom")
    , @NamedQuery(name = "AlianceCampaignAgeEntity.findByCampaignAgeTo", query = "SELECT a FROM AlianceCampaignAgeEntity a WHERE a.campaignAgeTo = :campaignAgeTo")
    , @NamedQuery(name = "AlianceCampaignAgeEntity.findByCampaignTnc", query = "SELECT a FROM AlianceCampaignAgeEntity a WHERE a.campaignTnc = :campaignTnc")})
public class AlianceCampaignAgeEntity implements Serializable {

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
    @Column(name = "campaign_age_from")
    @Temporal(TemporalType.TIMESTAMP)
    private Date campaignAgeFrom;
    @Column(name = "campaign_age_to")
    @Temporal(TemporalType.TIMESTAMP)
    private Date campaignAgeTo;
    @Column(name = "campaign_tnc")
    private String campaignTnc;
    @JoinColumn(name = "aliance_campaign_id", referencedColumnName = "id")
    @ManyToOne
    private AlianceCampaignEntity alianceCampaignId;

    public AlianceCampaignAgeEntity() {
    }

    public AlianceCampaignAgeEntity(Integer id) {
        this.id = id;
    }

    public AlianceCampaignAgeEntity(Integer id, Date creationDatetime, boolean isActive) {
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

    public Date getCampaignAgeFrom() {
        return campaignAgeFrom;
    }

    public void setCampaignAgeFrom(Date campaignAgeFrom) {
        this.campaignAgeFrom = campaignAgeFrom;
    }

    public Date getCampaignAgeTo() {
        return campaignAgeTo;
    }

    public void setCampaignAgeTo(Date campaignAgeTo) {
        this.campaignAgeTo = campaignAgeTo;
    }

    public String getCampaignTnc() {
        return campaignTnc;
    }

    public void setCampaignTnc(String campaignTnc) {
        this.campaignTnc = campaignTnc;
    }

    public AlianceCampaignEntity getAlianceCampaignId() {
        return alianceCampaignId;
    }

    public void setAlianceCampaignId(AlianceCampaignEntity alianceCampaignId) {
        this.alianceCampaignId = alianceCampaignId;
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
        if (!(object instanceof AlianceCampaignAgeEntity)) {
            return false;
        }
        AlianceCampaignAgeEntity other = (AlianceCampaignAgeEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.AlianceCampaignAge[ id=" + id + " ]";
    }
    
}
