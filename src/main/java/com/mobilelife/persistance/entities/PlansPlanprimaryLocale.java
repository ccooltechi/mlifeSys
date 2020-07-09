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
@Table(name = "plans_planprimary_locale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlanprimaryLocale.findAll", query = "SELECT p FROM PlansPlanprimaryLocale p")
    , @NamedQuery(name = "PlansPlanprimaryLocale.findById", query = "SELECT p FROM PlansPlanprimaryLocale p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlanprimaryLocale.findByPlanPrimaryId", query = "SELECT p FROM PlansPlanprimaryLocale p WHERE p.planPrimaryId = :planPrimaryId")
    , @NamedQuery(name = "PlansPlanprimaryLocale.findByLocale", query = "SELECT p FROM PlansPlanprimaryLocale p WHERE p.locale = :locale")
    , @NamedQuery(name = "PlansPlanprimaryLocale.findByPlanName", query = "SELECT p FROM PlansPlanprimaryLocale p WHERE p.planName = :planName")
    , @NamedQuery(name = "PlansPlanprimaryLocale.findByPlanFeature", query = "SELECT p FROM PlansPlanprimaryLocale p WHERE p.planFeature = :planFeature")
    , @NamedQuery(name = "PlansPlanprimaryLocale.findByPlanLongname", query = "SELECT p FROM PlansPlanprimaryLocale p WHERE p.planLongname = :planLongname")
    , @NamedQuery(name = "PlansPlanprimaryLocale.findByRecurringBundle", query = "SELECT p FROM PlansPlanprimaryLocale p WHERE p.recurringBundle = :recurringBundle")
    , @NamedQuery(name = "PlansPlanprimaryLocale.findByOneTimeAddon", query = "SELECT p FROM PlansPlanprimaryLocale p WHERE p.oneTimeAddon = :oneTimeAddon")
    , @NamedQuery(name = "PlansPlanprimaryLocale.findByDiscountText", query = "SELECT p FROM PlansPlanprimaryLocale p WHERE p.discountText = :discountText")
    , @NamedQuery(name = "PlansPlanprimaryLocale.findByPlanBucket", query = "SELECT p FROM PlansPlanprimaryLocale p WHERE p.planBucket = :planBucket")
    , @NamedQuery(name = "PlansPlanprimaryLocale.findByPlanParent", query = "SELECT p FROM PlansPlanprimaryLocale p WHERE p.planParent = :planParent")
    , @NamedQuery(name = "PlansPlanprimaryLocale.findByPlanStatus", query = "SELECT p FROM PlansPlanprimaryLocale p WHERE p.planStatus = :planStatus")
    , @NamedQuery(name = "PlansPlanprimaryLocale.findByLinkTopUp", query = "SELECT p FROM PlansPlanprimaryLocale p WHERE p.linkTopUp = :linkTopUp")
    , @NamedQuery(name = "PlansPlanprimaryLocale.findBySubscriptionCode", query = "SELECT p FROM PlansPlanprimaryLocale p WHERE p.subscriptionCode = :subscriptionCode")
    , @NamedQuery(name = "PlansPlanprimaryLocale.findByCreationDatetime", query = "SELECT p FROM PlansPlanprimaryLocale p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlanprimaryLocale.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlanprimaryLocale p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansPlanprimaryLocale.findByIsActive", query = "SELECT p FROM PlansPlanprimaryLocale p WHERE p.isActive = :isActive")})
public class PlansPlanprimaryLocale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "plan_primary_id")
    private int planPrimaryId;
    @Column(name = "locale")
    private String locale;
    @Column(name = "plan_name")
    private String planName;
    @Column(name = "plan_feature")
    private String planFeature;
    @Column(name = "plan_longname")
    private String planLongname;
    @Column(name = "recurring_bundle")
    private String recurringBundle;
    @Column(name = "one_time_addon")
    private String oneTimeAddon;
    @Column(name = "discount_text")
    private String discountText;
    @Column(name = "plan_bucket")
    private String planBucket;
    @Column(name = "plan_parent")
    private String planParent;
    @Column(name = "plan_status")
    private String planStatus;
    @Column(name = "linkTopUp")
    private String linkTopUp;
    @Column(name = "subscriptionCode")
    private String subscriptionCode;
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

    public PlansPlanprimaryLocale() {
    }

    public PlansPlanprimaryLocale(Integer id) {
        this.id = id;
    }

    public PlansPlanprimaryLocale(Integer id, int planPrimaryId, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.planPrimaryId = planPrimaryId;
        this.creationDatetime = creationDatetime;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPlanPrimaryId() {
        return planPrimaryId;
    }

    public void setPlanPrimaryId(int planPrimaryId) {
        this.planPrimaryId = planPrimaryId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanFeature() {
        return planFeature;
    }

    public void setPlanFeature(String planFeature) {
        this.planFeature = planFeature;
    }

    public String getPlanLongname() {
        return planLongname;
    }

    public void setPlanLongname(String planLongname) {
        this.planLongname = planLongname;
    }

    public String getRecurringBundle() {
        return recurringBundle;
    }

    public void setRecurringBundle(String recurringBundle) {
        this.recurringBundle = recurringBundle;
    }

    public String getOneTimeAddon() {
        return oneTimeAddon;
    }

    public void setOneTimeAddon(String oneTimeAddon) {
        this.oneTimeAddon = oneTimeAddon;
    }

    public String getDiscountText() {
        return discountText;
    }

    public void setDiscountText(String discountText) {
        this.discountText = discountText;
    }

    public String getPlanBucket() {
        return planBucket;
    }

    public void setPlanBucket(String planBucket) {
        this.planBucket = planBucket;
    }

    public String getPlanParent() {
        return planParent;
    }

    public void setPlanParent(String planParent) {
        this.planParent = planParent;
    }

    public String getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus;
    }

    public String getLinkTopUp() {
        return linkTopUp;
    }

    public void setLinkTopUp(String linkTopUp) {
        this.linkTopUp = linkTopUp;
    }

    public String getSubscriptionCode() {
        return subscriptionCode;
    }

    public void setSubscriptionCode(String subscriptionCode) {
        this.subscriptionCode = subscriptionCode;
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
        if (!(object instanceof PlansPlanprimaryLocale)) {
            return false;
        }
        PlansPlanprimaryLocale other = (PlansPlanprimaryLocale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanprimaryLocale[ id=" + id + " ]";
    }
    
}
