package com.mobilelife.persistance.entities;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "plans_operator_plan", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansOperatorPlanEntity.findAll", query = "SELECT p FROM PlansOperatorPlanEntity p")
    , @NamedQuery(name = "PlansOperatorPlanEntity.findById", query = "SELECT p FROM PlansOperatorPlanEntity p WHERE p.id = :id")
    , @NamedQuery(name = "PlansOperatorPlanEntity.findByCreationDatetime", query = "SELECT p FROM PlansOperatorPlanEntity p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansOperatorPlanEntity.findByLastModifiedDatetime", query = "SELECT p FROM PlansOperatorPlanEntity p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansOperatorPlanEntity.findByIsActive", query = "SELECT p FROM PlansOperatorPlanEntity p WHERE p.isActive = :isActive")})
public class PlansOperatorPlanEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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

    public PlansOperatorPlanEntity() {
    }

    public PlansOperatorPlanEntity(Integer id) {
        this.id = id;
    }

    public PlansOperatorPlanEntity(Integer id, Date creationDatetime, boolean isActive) {
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
        if (!(object instanceof PlansOperatorPlanEntity)) {
            return false;
        }
        PlansOperatorPlanEntity other = (PlansOperatorPlanEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenprojecta.PlansOperatorPlan[ id=" + id + " ]";
    }
    
}
