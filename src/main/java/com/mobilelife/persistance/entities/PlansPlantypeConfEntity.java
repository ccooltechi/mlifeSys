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
@Table(name = "plans_plantype_conf", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlantypeConfEntity.findAll", query = "SELECT p FROM PlansPlantypeConfEntity p")
    , @NamedQuery(name = "PlansPlantypeConfEntity.findById", query = "SELECT p FROM PlansPlantypeConfEntity p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlantypeConfEntity.findByFilterType", query = "SELECT p FROM PlansPlantypeConfEntity p WHERE p.filterType = :filterType")
    , @NamedQuery(name = "PlansPlantypeConfEntity.findByFilterBuffer", query = "SELECT p FROM PlansPlantypeConfEntity p WHERE p.filterBuffer = :filterBuffer")
    , @NamedQuery(name = "PlansPlantypeConfEntity.findByCreationDatetime", query = "SELECT p FROM PlansPlantypeConfEntity p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlantypeConfEntity.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlantypeConfEntity p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlantypeConfEntity.findByIsActive", query = "SELECT p FROM PlansPlantypeConfEntity p WHERE p.isActive = :isActive")})
public class PlansPlantypeConfEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "filter_type")
    private String filterType;
    @Column(name = "filter_buffer")
    private Integer filterBuffer;
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
    @JoinColumn(name = "plan_type_id", referencedColumnName = "id")
    @ManyToOne
    private PlansPlantypeEntity planTypeId;

    public PlansPlantypeConfEntity() {
    }

    public PlansPlantypeConfEntity(Integer id) {
        this.id = id;
    }

    public PlansPlantypeConfEntity(Integer id, Date creationDatetime, boolean isActive) {
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

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public Integer getFilterBuffer() {
        return filterBuffer;
    }

    public void setFilterBuffer(Integer filterBuffer) {
        this.filterBuffer = filterBuffer;
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

    public PlansPlantypeEntity getPlanTypeId() {
        return planTypeId;
    }

    public void setPlanTypeId(PlansPlantypeEntity planTypeId) {
        this.planTypeId = planTypeId;
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
        if (!(object instanceof PlansPlantypeConfEntity)) {
            return false;
        }
        PlansPlantypeConfEntity other = (PlansPlantypeConfEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlantypeConf[ id=" + id + " ]";
    }
    
}
