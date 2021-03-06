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
@Table(name = "plans_planspecialminutes", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlanspecialminutes.findAll", query = "SELECT p FROM PlansPlanspecialminutes p")
    , @NamedQuery(name = "PlansPlanspecialminutes.findById", query = "SELECT p FROM PlansPlanspecialminutes p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlanspecialminutes.findBySpecialMinutes", query = "SELECT p FROM PlansPlanspecialminutes p WHERE p.specialMinutes = :specialMinutes")
    , @NamedQuery(name = "PlansPlanspecialminutes.findBySpecialMinutesDescription", query = "SELECT p FROM PlansPlanspecialminutes p WHERE p.specialMinutesDescription = :specialMinutesDescription")
    , @NamedQuery(name = "PlansPlanspecialminutes.findByCreationDatetime", query = "SELECT p FROM PlansPlanspecialminutes p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlanspecialminutes.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlanspecialminutes p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlanspecialminutes.findByIsActive", query = "SELECT p FROM PlansPlanspecialminutes p WHERE p.isActive = :isActive")})
public class PlansPlanspecialminutes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "special_minutes")
    private Integer specialMinutes;
    @Column(name = "special_minutes_description")
    private String specialMinutesDescription;
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

    public PlansPlanspecialminutes() {
    }

    public PlansPlanspecialminutes(Integer id) {
        this.id = id;
    }

    public PlansPlanspecialminutes(Integer id, Date creationDatetime, boolean isActive) {
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

    public Integer getSpecialMinutes() {
        return specialMinutes;
    }

    public void setSpecialMinutes(Integer specialMinutes) {
        this.specialMinutes = specialMinutes;
    }

    public String getSpecialMinutesDescription() {
        return specialMinutesDescription;
    }

    public void setSpecialMinutesDescription(String specialMinutesDescription) {
        this.specialMinutesDescription = specialMinutesDescription;
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
        if (!(object instanceof PlansPlanspecialminutes)) {
            return false;
        }
        PlansPlanspecialminutes other = (PlansPlanspecialminutes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanspecialminutes[ id=" + id + " ]";
    }
    
}
