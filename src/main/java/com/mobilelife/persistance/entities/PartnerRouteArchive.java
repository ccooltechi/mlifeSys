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
 * @author deepakupadhyay
 */
@Entity
@Table(name = "partner_route_archive", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartnerRouteArchive.findAll", query = "SELECT p FROM PartnerRouteArchive p")
    , @NamedQuery(name = "PartnerRouteArchive.findById", query = "SELECT p FROM PartnerRouteArchive p WHERE p.id = :id")
    , @NamedQuery(name = "PartnerRouteArchive.findByCreationDatetime", query = "SELECT p FROM PartnerRouteArchive p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PartnerRouteArchive.findByLastModifiedDatetime", query = "SELECT p FROM PartnerRouteArchive p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PartnerRouteArchive.findByMerchantCode", query = "SELECT p FROM PartnerRouteArchive p WHERE p.merchantCode = :merchantCode")
    , @NamedQuery(name = "PartnerRouteArchive.findByMerchantName", query = "SELECT p FROM PartnerRouteArchive p WHERE p.merchantName = :merchantName")
    , @NamedQuery(name = "PartnerRouteArchive.findByMerchantUrl", query = "SELECT p FROM PartnerRouteArchive p WHERE p.merchantUrl = :merchantUrl")
    , @NamedQuery(name = "PartnerRouteArchive.findByActivationStartDate", query = "SELECT p FROM PartnerRouteArchive p WHERE p.activationStartDate = :activationStartDate")
    , @NamedQuery(name = "PartnerRouteArchive.findByActivationEndDate", query = "SELECT p FROM PartnerRouteArchive p WHERE p.activationEndDate = :activationEndDate")
    , @NamedQuery(name = "PartnerRouteArchive.findByCallsAllowed", query = "SELECT p FROM PartnerRouteArchive p WHERE p.callsAllowed = :callsAllowed")
    , @NamedQuery(name = "PartnerRouteArchive.findByCallsUsed", query = "SELECT p FROM PartnerRouteArchive p WHERE p.callsUsed = :callsUsed")
    , @NamedQuery(name = "PartnerRouteArchive.findByPriorityLevel", query = "SELECT p FROM PartnerRouteArchive p WHERE p.priorityLevel = :priorityLevel")})
public class PartnerRouteArchive implements Serializable {

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
    @Column(name = "merchant_code")
    private String merchantCode;
    @Column(name = "merchant_name")
    private String merchantName;
    @Column(name = "merchant_url")
    private String merchantUrl;
    @Column(name = "activation_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date activationStartDate;
    @Column(name = "activation_end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date activationEndDate;
    @Column(name = "calls_allowed")
    private Integer callsAllowed;
    @Column(name = "calls_used")
    private Integer callsUsed;
    @Column(name = "priority_level")
    private Integer priorityLevel;
    @JoinColumn(name = "routing_code", referencedColumnName = "id")
    @ManyToOne
    private PartnerRouteMaster routingCode;

    public PartnerRouteArchive() {
    }

    public PartnerRouteArchive(Integer id) {
        this.id = id;
    }

    public PartnerRouteArchive(Integer id, Date creationDatetime) {
        this.id = id;
        this.creationDatetime = creationDatetime;
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

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantUrl() {
        return merchantUrl;
    }

    public void setMerchantUrl(String merchantUrl) {
        this.merchantUrl = merchantUrl;
    }

    public Date getActivationStartDate() {
        return activationStartDate;
    }

    public void setActivationStartDate(Date activationStartDate) {
        this.activationStartDate = activationStartDate;
    }

    public Date getActivationEndDate() {
        return activationEndDate;
    }

    public void setActivationEndDate(Date activationEndDate) {
        this.activationEndDate = activationEndDate;
    }

    public Integer getCallsAllowed() {
        return callsAllowed;
    }

    public void setCallsAllowed(Integer callsAllowed) {
        this.callsAllowed = callsAllowed;
    }

    public Integer getCallsUsed() {
        return callsUsed;
    }

    public void setCallsUsed(Integer callsUsed) {
        this.callsUsed = callsUsed;
    }

    public Integer getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(Integer priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public PartnerRouteMaster getRoutingCode() {
        return routingCode;
    }

    public void setRoutingCode(PartnerRouteMaster routingCode) {
        this.routingCode = routingCode;
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
        if (!(object instanceof PartnerRouteArchive)) {
            return false;
        }
        PartnerRouteArchive other = (PartnerRouteArchive) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PartnerRouteArchive[ id=" + id + " ]";
    }
    
}
