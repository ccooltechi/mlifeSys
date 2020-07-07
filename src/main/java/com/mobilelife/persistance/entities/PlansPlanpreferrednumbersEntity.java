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
@Table(name = "plans_planpreferrednumbers", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlanpreferrednumbersEntity.findAll", query = "SELECT p FROM PlansPlanpreferrednumbersEntity p")
    , @NamedQuery(name = "PlansPlanpreferrednumbersEntity.findById", query = "SELECT p FROM PlansPlanpreferrednumbersEntity p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlanpreferrednumbersEntity.findByPrefferedNumbersNboflines", query = "SELECT p FROM PlansPlanpreferrednumbersEntity p WHERE p.prefferedNumbersNboflines = :prefferedNumbersNboflines")
    , @NamedQuery(name = "PlansPlanpreferrednumbersEntity.findByPreferredNumbersCallsmin", query = "SELECT p FROM PlansPlanpreferrednumbersEntity p WHERE p.preferredNumbersCallsmin = :preferredNumbersCallsmin")
    , @NamedQuery(name = "PlansPlanpreferrednumbersEntity.findByPrefferedNumbersUnits", query = "SELECT p FROM PlansPlanpreferrednumbersEntity p WHERE p.prefferedNumbersUnits = :prefferedNumbersUnits")
    , @NamedQuery(name = "PlansPlanpreferrednumbersEntity.findByPrefferedNumbersNboflinesOnnet", query = "SELECT p FROM PlansPlanpreferrednumbersEntity p WHERE p.prefferedNumbersNboflinesOnnet = :prefferedNumbersNboflinesOnnet")
    , @NamedQuery(name = "PlansPlanpreferrednumbersEntity.findByPreferredNumbersCallsminOnnet", query = "SELECT p FROM PlansPlanpreferrednumbersEntity p WHERE p.preferredNumbersCallsminOnnet = :preferredNumbersCallsminOnnet")
    , @NamedQuery(name = "PlansPlanpreferrednumbersEntity.findByPrefferedNumbersUnitsOnnet", query = "SELECT p FROM PlansPlanpreferrednumbersEntity p WHERE p.prefferedNumbersUnitsOnnet = :prefferedNumbersUnitsOnnet")
    , @NamedQuery(name = "PlansPlanpreferrednumbersEntity.findByPrefferedNumbersNboflinesOffnet", query = "SELECT p FROM PlansPlanpreferrednumbersEntity p WHERE p.prefferedNumbersNboflinesOffnet = :prefferedNumbersNboflinesOffnet")
    , @NamedQuery(name = "PlansPlanpreferrednumbersEntity.findByPreferredNumbersCallsminOffnet", query = "SELECT p FROM PlansPlanpreferrednumbersEntity p WHERE p.preferredNumbersCallsminOffnet = :preferredNumbersCallsminOffnet")
    , @NamedQuery(name = "PlansPlanpreferrednumbersEntity.findByPrefferedNumbersUnitsOffnet", query = "SELECT p FROM PlansPlanpreferrednumbersEntity p WHERE p.prefferedNumbersUnitsOffnet = :prefferedNumbersUnitsOffnet")
    , @NamedQuery(name = "PlansPlanpreferrednumbersEntity.findByCreationDatetime", query = "SELECT p FROM PlansPlanpreferrednumbersEntity p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlanpreferrednumbersEntity.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlanpreferrednumbersEntity p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlanpreferrednumbersEntity.findByIsActive", query = "SELECT p FROM PlansPlanpreferrednumbersEntity p WHERE p.isActive = :isActive")})
public class PlansPlanpreferrednumbersEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "preffered_numbers_nboflines")
    private Integer prefferedNumbersNboflines;
    @Column(name = "preferred_numbers_callsmin")
    private Integer preferredNumbersCallsmin;
    @Column(name = "preffered_numbers_units")
    private String prefferedNumbersUnits;
    @Column(name = "preffered_numbers_nboflines_onnet")
    private Integer prefferedNumbersNboflinesOnnet;
    @Column(name = "preferred_numbers_callsmin_onnet")
    private String preferredNumbersCallsminOnnet;
    @Column(name = "preffered_numbers_units_onnet")
    private String prefferedNumbersUnitsOnnet;
    @Column(name = "preffered_numbers_nboflines_offnet")
    private Integer prefferedNumbersNboflinesOffnet;
    @Column(name = "preferred_numbers_callsmin_offnet")
    private Integer preferredNumbersCallsminOffnet;
    @Column(name = "preffered_numbers_units_offnet")
    private String prefferedNumbersUnitsOffnet;
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
    private PlansPlanprimaryEntity planPrimaryId;

    public PlansPlanpreferrednumbersEntity() {
    }

    public PlansPlanpreferrednumbersEntity(Integer id) {
        this.id = id;
    }

    public PlansPlanpreferrednumbersEntity(Integer id, Date creationDatetime, boolean isActive) {
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

    public Integer getPrefferedNumbersNboflines() {
        return prefferedNumbersNboflines;
    }

    public void setPrefferedNumbersNboflines(Integer prefferedNumbersNboflines) {
        this.prefferedNumbersNboflines = prefferedNumbersNboflines;
    }

    public Integer getPreferredNumbersCallsmin() {
        return preferredNumbersCallsmin;
    }

    public void setPreferredNumbersCallsmin(Integer preferredNumbersCallsmin) {
        this.preferredNumbersCallsmin = preferredNumbersCallsmin;
    }

    public String getPrefferedNumbersUnits() {
        return prefferedNumbersUnits;
    }

    public void setPrefferedNumbersUnits(String prefferedNumbersUnits) {
        this.prefferedNumbersUnits = prefferedNumbersUnits;
    }

    public Integer getPrefferedNumbersNboflinesOnnet() {
        return prefferedNumbersNboflinesOnnet;
    }

    public void setPrefferedNumbersNboflinesOnnet(Integer prefferedNumbersNboflinesOnnet) {
        this.prefferedNumbersNboflinesOnnet = prefferedNumbersNboflinesOnnet;
    }

    public String getPreferredNumbersCallsminOnnet() {
        return preferredNumbersCallsminOnnet;
    }

    public void setPreferredNumbersCallsminOnnet(String preferredNumbersCallsminOnnet) {
        this.preferredNumbersCallsminOnnet = preferredNumbersCallsminOnnet;
    }

    public String getPrefferedNumbersUnitsOnnet() {
        return prefferedNumbersUnitsOnnet;
    }

    public void setPrefferedNumbersUnitsOnnet(String prefferedNumbersUnitsOnnet) {
        this.prefferedNumbersUnitsOnnet = prefferedNumbersUnitsOnnet;
    }

    public Integer getPrefferedNumbersNboflinesOffnet() {
        return prefferedNumbersNboflinesOffnet;
    }

    public void setPrefferedNumbersNboflinesOffnet(Integer prefferedNumbersNboflinesOffnet) {
        this.prefferedNumbersNboflinesOffnet = prefferedNumbersNboflinesOffnet;
    }

    public Integer getPreferredNumbersCallsminOffnet() {
        return preferredNumbersCallsminOffnet;
    }

    public void setPreferredNumbersCallsminOffnet(Integer preferredNumbersCallsminOffnet) {
        this.preferredNumbersCallsminOffnet = preferredNumbersCallsminOffnet;
    }

    public String getPrefferedNumbersUnitsOffnet() {
        return prefferedNumbersUnitsOffnet;
    }

    public void setPrefferedNumbersUnitsOffnet(String prefferedNumbersUnitsOffnet) {
        this.prefferedNumbersUnitsOffnet = prefferedNumbersUnitsOffnet;
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

    public PlansPlanprimaryEntity getPlanPrimaryId() {
        return planPrimaryId;
    }

    public void setPlanPrimaryId(PlansPlanprimaryEntity planPrimaryId) {
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
        if (!(object instanceof PlansPlanpreferrednumbersEntity)) {
            return false;
        }
        PlansPlanpreferrednumbersEntity other = (PlansPlanpreferrednumbersEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanpreferrednumbers[ id=" + id + " ]";
    }
    
}
