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
@Table(name = "plans_plantype_locale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlantypeLocale.findAll", query = "SELECT p FROM PlansPlantypeLocale p")
    , @NamedQuery(name = "PlansPlantypeLocale.findById", query = "SELECT p FROM PlansPlantypeLocale p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlantypeLocale.findByPlanTypeIdLocale", query = "SELECT p FROM PlansPlantypeLocale p WHERE  p.planTypeId = :planTypeId AND p.locale = :locale")
    , @NamedQuery(name = "PlansPlantypeLocale.findByPlanTypeId", query = "SELECT p FROM PlansPlantypeLocale p WHERE p.planTypeId = :planTypeId")
    , @NamedQuery(name = "PlansPlantypeLocale.findByLocale", query = "SELECT p FROM PlansPlantypeLocale p WHERE p.locale = :locale")
    , @NamedQuery(name = "PlansPlantypeLocale.findByPlanLabel", query = "SELECT p FROM PlansPlantypeLocale p WHERE p.planLabel = :planLabel")
    , @NamedQuery(name = "PlansPlantypeLocale.findByCreationDatetime", query = "SELECT p FROM PlansPlantypeLocale p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlantypeLocale.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlantypeLocale p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlantypeLocale.findByIsActive", query = "SELECT p FROM PlansPlantypeLocale p WHERE p.isActive = :isActive")})
public class PlansPlantypeLocale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "plan_type_id")
    private int planTypeId;
    @Column(name = "locale")
    private String locale;
    @Column(name = "plan_label")
    private String planLabel;
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

    public PlansPlantypeLocale() {
    }

    public PlansPlantypeLocale(Integer id) {
        this.id = id;
    }

    public PlansPlantypeLocale(Integer id, int planTypeId, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.planTypeId = planTypeId;
        this.creationDatetime = creationDatetime;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPlanTypeId() {
        return planTypeId;
    }

    public void setPlanTypeId(int planTypeId) {
        this.planTypeId = planTypeId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getPlanLabel() {
        return planLabel;
    }

    public void setPlanLabel(String planLabel) {
        this.planLabel = planLabel;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlansPlantypeLocale)) {
            return false;
        }
        PlansPlantypeLocale other = (PlansPlantypeLocale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlantypeLocale[ id=" + id + " ]";
    }
    
}
