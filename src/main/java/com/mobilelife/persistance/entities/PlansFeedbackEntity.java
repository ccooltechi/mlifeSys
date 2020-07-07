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
 * @author pods
 */
@Entity
@Table(name = "plans_feedback", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansFeedbackEntity.findAll", query = "SELECT p FROM PlansFeedbackEntity p")
    , @NamedQuery(name = "PlansFeedbackEntity.findById", query = "SELECT p FROM PlansFeedbackEntity p WHERE p.id = :id")
    , @NamedQuery(name = "PlansFeedbackEntity.findByUserId", query = "SELECT p FROM PlansFeedbackEntity p WHERE p.userId = :userId")
    , @NamedQuery(name = "PlansFeedbackEntity.findByRating", query = "SELECT p FROM PlansFeedbackEntity p WHERE p.rating = :rating")
    , @NamedQuery(name = "PlansFeedbackEntity.findByRemarks", query = "SELECT p FROM PlansFeedbackEntity p WHERE p.remarks = :remarks")
    , @NamedQuery(name = "PlansFeedbackEntity.findByCreationDatetime", query = "SELECT p FROM PlansFeedbackEntity p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansFeedbackEntity.findByLastModifiedDatetime", query = "SELECT p FROM PlansFeedbackEntity p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansFeedbackEntity.findByIsActive", query = "SELECT p FROM PlansFeedbackEntity p WHERE p.isActive = :isActive")})
public class PlansFeedbackEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "remarks")
    private String remarks;
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
    @ManyToOne(optional = false)
    private PlansPlanprimaryEntity planPrimaryId;

    public PlansFeedbackEntity() {
    }

    public PlansFeedbackEntity(Integer id) {
        this.id = id;
    }

    public PlansFeedbackEntity(Integer id, int userId, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.userId = userId;
        this.creationDatetime = creationDatetime;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
        if (!(object instanceof PlansFeedbackEntity)) {
            return false;
        }
        PlansFeedbackEntity other = (PlansFeedbackEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansFeedback[ id=" + id + " ]";
    }
    
}
