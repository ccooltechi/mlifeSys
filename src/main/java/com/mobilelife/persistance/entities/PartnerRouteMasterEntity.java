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
 * @author deepakupadhyay
 */
@Entity
@Table(name = "partner_route_master", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartnerRouteMasterEntity.findAll", query = "SELECT p FROM PartnerRouteMasterEntity p")
    , @NamedQuery(name = "PartnerRouteMasterEntity.findById", query = "SELECT p FROM PartnerRouteMasterEntity p WHERE p.id = :id")
    , @NamedQuery(name = "PartnerRouteMasterEntity.findByCreationDatetime", query = "SELECT p FROM PartnerRouteMasterEntity p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PartnerRouteMasterEntity.findByLastModifiedDatetime", query = "SELECT p FROM PartnerRouteMasterEntity p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PartnerRouteMasterEntity.findByIsActive", query = "SELECT p FROM PartnerRouteMasterEntity p WHERE p.isActive = :isActive")
    , @NamedQuery(name = "PartnerRouteMasterEntity.findByRoutingCode", query = "SELECT p FROM PartnerRouteMasterEntity p WHERE p.routingCode = :routingCode")
    , @NamedQuery(name = "PartnerRouteMasterEntity.findByRoutingName", query = "SELECT p FROM PartnerRouteMasterEntity p WHERE p.routingName = :routingName")})
public class PartnerRouteMasterEntity implements Serializable {

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
    @Column(name = "routing_code")
    private String routingCode;
    @Column(name = "routing_name")
    private String routingName;
    @OneToMany(mappedBy = "routingCode")
    private Collection<PartnerRouteChildEntity> partnerRouteChildCollection;

    public PartnerRouteMasterEntity() {
    }

    public PartnerRouteMasterEntity(Integer id) {
        this.id = id;
    }

    public PartnerRouteMasterEntity(Integer id, Date creationDatetime, boolean isActive) {
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

    public String getRoutingCode() {
        return routingCode;
    }

    public void setRoutingCode(String routingCode) {
        this.routingCode = routingCode;
    }

    public String getRoutingName() {
        return routingName;
    }

    public void setRoutingName(String routingName) {
        this.routingName = routingName;
    }

    @XmlTransient
    public Collection<PartnerRouteChildEntity> getPartnerRouteChildCollection() {
        return partnerRouteChildCollection;
    }

    public void setPartnerRouteChildCollection(Collection<PartnerRouteChildEntity> partnerRouteChildCollection) {
        this.partnerRouteChildCollection = partnerRouteChildCollection;
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
        if (!(object instanceof PartnerRouteMasterEntity)) {
            return false;
        }
        PartnerRouteMasterEntity other = (PartnerRouteMasterEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PartnerRouteMaster[ id=" + id + " ]";
    }
    
}
