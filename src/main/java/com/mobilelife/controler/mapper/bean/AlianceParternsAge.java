/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.controler.mapper.bean;

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

public class AlianceParternsAge implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Date creationDatetime;
    private Date lastModifiedDatetime;
    private boolean isActive;
    private Date aliancePartnerAgeFrom;
    private Date aliancePartnerAgeTo;
    private String aliancePartnerTnc;

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
}
