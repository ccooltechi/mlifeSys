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
 * @author deepakupadhyay
 */
@Entity
@Table(name = "plans_planflexisms", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlanflexismsEntity.findAll", query = "SELECT p FROM PlansPlanflexismsEntity p")
    , @NamedQuery(name = "PlansPlanflexismsEntity.findById", query = "SELECT p FROM PlansPlanflexismsEntity p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlanflexismsEntity.findByFlexiSms", query = "SELECT p FROM PlansPlanflexismsEntity p WHERE p.flexiSms = :flexiSms")
    , @NamedQuery(name = "PlansPlanflexismsEntity.findByFlexiSmsUnitrate", query = "SELECT p FROM PlansPlanflexismsEntity p WHERE p.flexiSmsUnitrate = :flexiSmsUnitrate")
    , @NamedQuery(name = "PlansPlanflexismsEntity.findByCreationDatetime", query = "SELECT p FROM PlansPlanflexismsEntity p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlanflexismsEntity.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlanflexismsEntity p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlanflexismsEntity.findByIsActive", query = "SELECT p FROM PlansPlanflexismsEntity p WHERE p.isActive = :isActive")})
public class PlansPlanflexismsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "flexi_sms")
    private Integer flexiSms;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "flexi_sms_unitrate")
    private Double flexiSmsUnitrate;
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

    public PlansPlanflexismsEntity() {
    }

    public PlansPlanflexismsEntity(Integer id) {
        this.id = id;
    }

    public PlansPlanflexismsEntity(Integer id, Date creationDatetime, boolean isActive) {
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

    public Integer getFlexiSms() {
        return flexiSms;
    }

    public void setFlexiSms(Integer flexiSms) {
        this.flexiSms = flexiSms;
    }

    public Double getFlexiSmsUnitrate() {
        return flexiSmsUnitrate;
    }

    public void setFlexiSmsUnitrate(Double flexiSmsUnitrate) {
        this.flexiSmsUnitrate = flexiSmsUnitrate;
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
        if (!(object instanceof PlansPlanflexismsEntity)) {
            return false;
        }
        PlansPlanflexismsEntity other = (PlansPlanflexismsEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenprojectx.PlansPlanflexisms[ id=" + id + " ]";
    }
    
}
