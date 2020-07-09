/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class AlianceParternsBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Date creationDatetime;
    private Date lastModifiedDatetime;
    private boolean isActive;
    private String aliancePartnerCode;
    private String aliancePartnerName;
    private String aliancePartnerLogo;
    private String aliancePartnerTnc;

    public AlianceParternsBean() {
    }

    public AlianceParternsBean(Integer id) {
        this.id = id;
    }

    public AlianceParternsBean(Integer id, Date creationDatetime, boolean isActive) {
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
}
