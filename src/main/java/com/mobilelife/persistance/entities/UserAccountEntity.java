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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pods
 */
@Entity
@Table(name = "user_account", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAccountEntity.findAll", query = "SELECT u FROM UserAccountEntity u")
    , @NamedQuery(name = "UserAccountEntity.findById", query = "SELECT u FROM UserAccountEntity u WHERE u.id = :id")
    , @NamedQuery(name = "UserAccountEntity.findBySubId", query = "SELECT u FROM UserAccountEntity u WHERE u.subId = :subId")
    , @NamedQuery(name = "UserAccountEntity.findByOperatorId", query = "SELECT u FROM UserAccountEntity u WHERE u.operatorId = :operatorId")
    , @NamedQuery(name = "UserAccountEntity.findByCreationDatetime", query = "SELECT u FROM UserAccountEntity u WHERE u.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "UserAccountEntity.findByLastModifiedDatetime", query = "SELECT u FROM UserAccountEntity u WHERE u.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "UserAccountEntity.findByIsActive", query = "SELECT u FROM UserAccountEntity u WHERE u.isActive = :isActive")})
public class UserAccountEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "sub_id")
    private Integer subId;
    @Column(name = "operator_id")
    private Integer operatorId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Collection<UserAccountDetailsEntity> userAccountDetailsCollection;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PlansOperatorEntity plansOperator;

    public UserAccountEntity() {
    }

    public UserAccountEntity(Integer id) {
        this.id = id;
    }

    public UserAccountEntity(Integer id, Date creationDatetime, boolean isActive) {
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

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
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

    @XmlTransient
    public Collection<UserAccountDetailsEntity> getUserAccountDetailsCollection() {
        return userAccountDetailsCollection;
    }

    public void setUserAccountDetailsCollection(Collection<UserAccountDetailsEntity> userAccountDetailsCollection) {
        this.userAccountDetailsCollection = userAccountDetailsCollection;
    }

    public PlansOperatorEntity getPlansOperator() {
        return plansOperator;
    }

    public void setPlansOperator(PlansOperatorEntity plansOperator) {
        this.plansOperator = plansOperator;
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
        if (!(object instanceof UserAccountEntity)) {
            return false;
        }
        UserAccountEntity other = (UserAccountEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.UserAccount[ id=" + id + " ]";
    }
    
}
