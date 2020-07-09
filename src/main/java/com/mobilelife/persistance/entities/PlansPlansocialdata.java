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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pods
 */
@Entity
@Table(name = "plans_plansocialdata", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlansocialdata.findAll", query = "SELECT p FROM PlansPlansocialdata p")
    , @NamedQuery(name = "PlansPlansocialdata.findById", query = "SELECT p FROM PlansPlansocialdata p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlansocialdata.findBySocialDataGb", query = "SELECT p FROM PlansPlansocialdata p WHERE p.socialDataGb = :socialDataGb")
    , @NamedQuery(name = "PlansPlansocialdata.findBySocialDataUnitrate", query = "SELECT p FROM PlansPlansocialdata p WHERE p.socialDataUnitrate = :socialDataUnitrate")
    , @NamedQuery(name = "PlansPlansocialdata.findByCreationDatetime", query = "SELECT p FROM PlansPlansocialdata p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlansocialdata.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlansocialdata p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlansocialdata.findByIsActive", query = "SELECT p FROM PlansPlansocialdata p WHERE p.isActive = :isActive")})
public class PlansPlansocialdata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "social_data_gb")
    private Double socialDataGb;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "social_data_unitrate")
    private Double socialDataUnitrate;
    @Lob
    @Column(name = "social_data_info")
    private String socialDataInfo;
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
    @JoinColumn(name = "plan_primary_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private PlansPlanprimary planPrimaryId;

    public PlansPlansocialdata() {
    }

    public PlansPlansocialdata(Integer id) {
        this.id = id;
    }

    public PlansPlansocialdata(Integer id, Date creationDatetime, boolean isActive) {
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

    public Double getSocialDataGb() {
        return socialDataGb;
    }

    public void setSocialDataGb(Double socialDataGb) {
        this.socialDataGb = socialDataGb;
    }

    public Double getSocialDataUnitrate() {
        return socialDataUnitrate;
    }

    public void setSocialDataUnitrate(Double socialDataUnitrate) {
        this.socialDataUnitrate = socialDataUnitrate;
    }

    public String getSocialDataInfo() {
        return socialDataInfo;
    }

    public void setSocialDataInfo(String socialDataInfo) {
        this.socialDataInfo = socialDataInfo;
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

    public PlansPlanprimary getPlanPrimaryId() {
        return planPrimaryId;
    }

    public void setPlanPrimaryId(PlansPlanprimary planPrimaryId) {
        this.planPrimaryId = planPrimaryId;
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
        if (!(object instanceof PlansPlansocialdata)) {
            return false;
        }
        PlansPlansocialdata other = (PlansPlansocialdata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlansocialdata[ id=" + id + " ]";
    }
    
}
