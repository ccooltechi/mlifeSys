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
@Table(name = "plans_mis_features", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansMisFeaturesEntity.findAll", query = "SELECT p FROM PlansMisFeaturesEntity p")
    , @NamedQuery(name = "PlansMisFeaturesEntity.findById", query = "SELECT p FROM PlansMisFeaturesEntity p WHERE p.id = :id")
    , @NamedQuery(name = "PlansMisFeaturesEntity.findByCode", query = "SELECT p FROM PlansMisFeaturesEntity p WHERE p.code = :code")
    , @NamedQuery(name = "PlansMisFeaturesEntity.findByIcon", query = "SELECT p FROM PlansMisFeaturesEntity p WHERE p.icon = :icon")
    , @NamedQuery(name = "PlansMisFeaturesEntity.findByName", query = "SELECT p FROM PlansMisFeaturesEntity p WHERE p.name = :name")
    , @NamedQuery(name = "PlansMisFeaturesEntity.findByRemarks", query = "SELECT p FROM PlansMisFeaturesEntity p WHERE p.remarks = :remarks")
    , @NamedQuery(name = "PlansMisFeaturesEntity.findByCreationDatetime", query = "SELECT p FROM PlansMisFeaturesEntity p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansMisFeaturesEntity.findByLastModifiedDatetime", query = "SELECT p FROM PlansMisFeaturesEntity p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansMisFeaturesEntity.findByIsActive", query = "SELECT p FROM PlansMisFeaturesEntity p WHERE p.isActive = :isActive")})
public class PlansMisFeaturesEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "icon")
    private String icon;
    @Column(name = "name")
    private String name;
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

//    private int plan_primary_id;
    
    public PlansMisFeaturesEntity() {
    }

    public PlansMisFeaturesEntity(Integer id) {
        this.id = id;
    }

    public PlansMisFeaturesEntity(Integer id, Date creationDatetime, boolean isActive) {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


//	public int getPlan_primary_id() {
//		return plan_primary_id;
//	}
//
//	public void setPlan_primary_id(int plan_primary_id) {
//		this.plan_primary_id = plan_primary_id;
//	}


    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlansMisFeaturesEntity)) {
            return false;
        }
        PlansMisFeaturesEntity other = (PlansMisFeaturesEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansMisFeatures[ id=" + id + " ]";
    }
    
}
