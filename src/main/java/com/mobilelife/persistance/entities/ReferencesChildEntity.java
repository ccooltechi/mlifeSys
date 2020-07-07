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
@Table(name = "references_child", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReferencesChildEntity.findAll", query = "SELECT r FROM ReferencesChildEntity r")
    , @NamedQuery(name = "ReferencesChildEntity.findById", query = "SELECT r FROM ReferencesChildEntity r WHERE r.id = :id")
    , @NamedQuery(name = "ReferencesChildEntity.findByEmailId", query = "SELECT r FROM ReferencesChildEntity r WHERE r.emailId = :emailId")
    , @NamedQuery(name = "ReferencesChildEntity.findByFname", query = "SELECT r FROM ReferencesChildEntity r WHERE r.fname = :fname")
    , @NamedQuery(name = "ReferencesChildEntity.findByLname", query = "SELECT r FROM ReferencesChildEntity r WHERE r.lname = :lname")
    , @NamedQuery(name = "ReferencesChildEntity.findByCreationDatetime", query = "SELECT r FROM ReferencesChildEntity r WHERE r.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "ReferencesChildEntity.findByLastModifiedDatetime", query = "SELECT r FROM ReferencesChildEntity r WHERE r.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "ReferencesChildEntity.findByIsActive", query = "SELECT r FROM ReferencesChildEntity r WHERE r.isActive = :isActive")})
public class ReferencesChildEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "fname")
    private String fname;
    @Column(name = "lname")
    private String lname;
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
    @JoinColumn(name = "references_id", referencedColumnName = "id")
    @ManyToOne
    private ReferencesMasterEntity referencesId;

    public ReferencesChildEntity() {
    }

    public ReferencesChildEntity(Integer id) {
        this.id = id;
    }

    public ReferencesChildEntity(Integer id, Date creationDatetime, boolean isActive) {
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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

    public ReferencesMasterEntity getReferencesId() {
        return referencesId;
    }

    public void setReferencesId(ReferencesMasterEntity referencesId) {
        this.referencesId = referencesId;
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
        if (!(object instanceof ReferencesChildEntity)) {
            return false;
        }
        ReferencesChildEntity other = (ReferencesChildEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.ReferencesChild[ id=" + id + " ]";
    }
    
}
