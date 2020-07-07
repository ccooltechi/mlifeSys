package com.mobilelife.controler.mapper.bean;

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

public class AlianceCampaign implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Date creationDatetime;
    private Date lastModifiedDatetime;
    private boolean isActive;
    private String campaignCode;
    private String campaignName;
    private String campaignLogo;
    private String campaignTnc;

    public AlianceCampaign() {
    }

    public Integer getId() {
        return id;
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
    
}
