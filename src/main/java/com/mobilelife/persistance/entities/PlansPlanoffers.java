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
 * @author deepakupadhyay
 */
@Entity
@Table(name = "plans_planoffers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlanoffers.findAll", query = "SELECT p FROM PlansPlanoffers p")
    , @NamedQuery(name = "PlansPlanoffers.findById", query = "SELECT p FROM PlansPlanoffers p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlanoffers.findByOffersHeader", query = "SELECT p FROM PlansPlanoffers p WHERE p.offersHeader = :offersHeader")
    , @NamedQuery(name = "PlansPlanoffers.findByCreationDatetime", query = "SELECT p FROM PlansPlanoffers p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlanoffers.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlanoffers p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlanoffers.findByIsActive", query = "SELECT p FROM PlansPlanoffers p WHERE p.isActive = :isActive")})
public class PlansPlanoffers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "offers_desc")
    private String offersDesc;
    @Column(name = "offers_header")
    private String offersHeader;
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

    public PlansPlanoffers() {
    }

    public PlansPlanoffers(Integer id) {
        this.id = id;
    }

    public PlansPlanoffers(Integer id, Date creationDatetime, boolean isActive) {
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

    public String getOffersDesc() {
        return offersDesc;
    }

    public void setOffersDesc(String offersDesc) {
        this.offersDesc = offersDesc;
    }

    public String getOffersHeader() {
        return offersHeader;
    }

    public void setOffersHeader(String offersHeader) {
        this.offersHeader = offersHeader;
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
        if (!(object instanceof PlansPlanoffers)) {
            return false;
        }
        PlansPlanoffers other = (PlansPlanoffers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanoffers[ id=" + id + " ]";
    }
    
}
