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
import javax.persistence.Lob;
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
@Table(name = "plans_planaddons")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlanaddons.findAll", query = "SELECT p FROM PlansPlanaddons p")
    , @NamedQuery(name = "PlansPlanaddons.findById", query = "SELECT p FROM PlansPlanaddons p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlanaddons.findByOperatorId", query = "SELECT p FROM PlansPlanaddons p WHERE p.operatorId = :operatorId")
    , @NamedQuery(name = "PlansPlanaddons.findByValidityCount", query = "SELECT p FROM PlansPlanaddons p WHERE p.validityCount = :validityCount")
    , @NamedQuery(name = "PlansPlanaddons.findByAllowance", query = "SELECT p FROM PlansPlanaddons p WHERE p.allowance = :allowance")
    , @NamedQuery(name = "PlansPlanaddons.findByPrice", query = "SELECT p FROM PlansPlanaddons p WHERE p.price = :price")
    , @NamedQuery(name = "PlansPlanaddons.findByRatePerUnit", query = "SELECT p FROM PlansPlanaddons p WHERE p.ratePerUnit = :ratePerUnit")
    , @NamedQuery(name = "PlansPlanaddons.findByCreationDatetime", query = "SELECT p FROM PlansPlanaddons p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlanaddons.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlanaddons p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlanaddons.findByIsActive", query = "SELECT p FROM PlansPlanaddons p WHERE p.isActive = :isActive")})
public class PlansPlanaddons implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "operator_id")
    private int operatorId;
    @Lob
    @Column(name = "add_on_code")
    private String addOnCode;
    @Lob
    @Column(name = "add_on_group")
    private String addOnGroup;
    @Lob
    @Column(name = "add_on_name")
    private String addOnName;
    @Lob
    @Column(name = "bucket")
    private String bucket;
    @Lob
    @Column(name = "permanent_promo")
    private String permanentPromo;
    @Lob
    @Column(name = "promo_on_flag")
    private String promoOnFlag;
    @Lob
    @Column(name = "validity_unit")
    private String validityUnit;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "validity_count")
    private Double validityCount;
    @Column(name = "allowance")
    private Double allowance;
    @Lob
    @Column(name = "allowance_unit")
    private String allowanceUnit;
    @Lob
    @Column(name = "allowance_description")
    private String allowanceDescription;
    @Column(name = "price")
    private Double price;
    @Lob
    @Column(name = "text")
    private String text;
    @Column(name = "rate_per_unit")
    private Double ratePerUnit;
    @Lob
    @Column(name = "code_parent_plan")
    private String codeParentPlan;
    @Lob
    @Column(name = "associated_list")
    private String associatedList;
    @Lob
    @Column(name = "ib_oob")
    private String ibOob;
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

    public PlansPlanaddons() {
    }

    public PlansPlanaddons(Integer id) {
        this.id = id;
    }

    public PlansPlanaddons(Integer id, int operatorId, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.operatorId = operatorId;
        this.creationDatetime = creationDatetime;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public String getAddOnCode() {
        return addOnCode;
    }

    public void setAddOnCode(String addOnCode) {
        this.addOnCode = addOnCode;
    }

    public String getAddOnGroup() {
        return addOnGroup;
    }

    public void setAddOnGroup(String addOnGroup) {
        this.addOnGroup = addOnGroup;
    }

    public String getAddOnName() {
        return addOnName;
    }

    public void setAddOnName(String addOnName) {
        this.addOnName = addOnName;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getPermanentPromo() {
        return permanentPromo;
    }

    public void setPermanentPromo(String permanentPromo) {
        this.permanentPromo = permanentPromo;
    }

    public String getPromoOnFlag() {
        return promoOnFlag;
    }

    public void setPromoOnFlag(String promoOnFlag) {
        this.promoOnFlag = promoOnFlag;
    }

    public String getValidityUnit() {
        return validityUnit;
    }

    public void setValidityUnit(String validityUnit) {
        this.validityUnit = validityUnit;
    }

    public Double getValidityCount() {
        return validityCount;
    }

    public void setValidityCount(Double validityCount) {
        this.validityCount = validityCount;
    }

    public Double getAllowance() {
        return allowance;
    }

    public void setAllowance(Double allowance) {
        this.allowance = allowance;
    }

    public String getAllowanceUnit() {
        return allowanceUnit;
    }

    public void setAllowanceUnit(String allowanceUnit) {
        this.allowanceUnit = allowanceUnit;
    }

    public String getAllowanceDescription() {
        return allowanceDescription;
    }

    public void setAllowanceDescription(String allowanceDescription) {
        this.allowanceDescription = allowanceDescription;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getRatePerUnit() {
        return ratePerUnit;
    }

    public void setRatePerUnit(Double ratePerUnit) {
        this.ratePerUnit = ratePerUnit;
    }

    public String getCodeParentPlan() {
        return codeParentPlan;
    }

    public void setCodeParentPlan(String codeParentPlan) {
        this.codeParentPlan = codeParentPlan;
    }

    public String getAssociatedList() {
        return associatedList;
    }

    public void setAssociatedList(String associatedList) {
        this.associatedList = associatedList;
    }

    public String getIbOob() {
        return ibOob;
    }

    public void setIbOob(String ibOob) {
        this.ibOob = ibOob;
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
        if (!(object instanceof PlansPlanaddons)) {
            return false;
        }
        PlansPlanaddons other = (PlansPlanaddons) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanaddons[ id=" + id + " ]";
    }
    
}
