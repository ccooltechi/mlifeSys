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
@Table(name = "plans_device_plan", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansDevicePlanEntity.findAll", query = "SELECT p FROM PlansDevicePlanEntity p")
    , @NamedQuery(name = "PlansDevicePlanEntity.findById", query = "SELECT p FROM PlansDevicePlanEntity p WHERE p.id = :id")
    , @NamedQuery(name = "PlansDevicePlanEntity.findByIsActive", query = "SELECT p FROM PlansDevicePlanEntity p WHERE p.isActive = :isActive")
    , @NamedQuery(name = "PlansDevicePlanEntity.findByCreationDatetime", query = "SELECT p FROM PlansDevicePlanEntity p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansDevicePlanEntity.findByLastModifiedDatetime", query = "SELECT p FROM PlansDevicePlanEntity p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlansDevicePlanEntity.findByWifiPlan", query = "SELECT p FROM PlansDevicePlanEntity p WHERE p.wifiPlan = :wifiPlan")
    , @NamedQuery(name = "PlansDevicePlanEntity.findBySocialData", query = "SELECT p FROM PlansDevicePlanEntity p WHERE p.socialData = :socialData")
    , @NamedQuery(name = "PlansDevicePlanEntity.findByDataBundel", query = "SELECT p FROM PlansDevicePlanEntity p WHERE p.dataBundel = :dataBundel")
    , @NamedQuery(name = "PlansDevicePlanEntity.findByFlexiDetails", query = "SELECT p FROM PlansDevicePlanEntity p WHERE p.flexiDetails = :flexiDetails")
    , @NamedQuery(name = "PlansDevicePlanEntity.findByPlanOutofBundel", query = "SELECT p FROM PlansDevicePlanEntity p WHERE p.planOutofBundel = :planOutofBundel")
    , @NamedQuery(name = "PlansDevicePlanEntity.findByNationalMin", query = "SELECT p FROM PlansDevicePlanEntity p WHERE p.nationalMin = :nationalMin")
    , @NamedQuery(name = "PlansDevicePlanEntity.findByRoamingIncomingMin", query = "SELECT p FROM PlansDevicePlanEntity p WHERE p.roamingIncomingMin = :roamingIncomingMin")
    , @NamedQuery(name = "PlansDevicePlanEntity.findByNationalMinOffnet", query = "SELECT p FROM PlansDevicePlanEntity p WHERE p.nationalMinOffnet = :nationalMinOffnet")
    , @NamedQuery(name = "PlansDevicePlanEntity.findByPlanPreffNumber", query = "SELECT p FROM PlansDevicePlanEntity p WHERE p.planPreffNumber = :planPreffNumber")
    , @NamedQuery(name = "PlansDevicePlanEntity.findByInternationalSms", query = "SELECT p FROM PlansDevicePlanEntity p WHERE p.internationalSms = :internationalSms")
    , @NamedQuery(name = "PlansDevicePlanEntity.findByPlanFee", query = "SELECT p FROM PlansDevicePlanEntity p WHERE p.planFee = :planFee")
    , @NamedQuery(name = "PlansDevicePlanEntity.findByMisFeatures", query = "SELECT p FROM PlansDevicePlanEntity p WHERE p.misFeatures = :misFeatures")
    , @NamedQuery(name = "PlansDevicePlanEntity.findByPlanId", query = "SELECT p FROM PlansDevicePlanEntity p WHERE p.planId = :planId")
    , @NamedQuery(name = "PlansDevicePlanEntity.findByPlanUrl", query = "SELECT p FROM PlansDevicePlanEntity p WHERE p.planUrl = :planUrl")
    , @NamedQuery(name = "PlansDevicePlanEntity.findByPlanRefid", query = "SELECT p FROM PlansDevicePlanEntity p WHERE p.planRefid = :planRefid")})
public class PlansDevicePlanEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "is_active")
    private boolean isActive;
    @Basic(optional = false)
    @Column(name = "creation_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDatetime;
    @Column(name = "last_modified_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDatetime;
    @Column(name = "plan_mis_details")
    private String plan_mis_details;
    @Column(name = "wifi_plan")
    private String wifiPlan;
    @Column(name = "social_data")
    private String socialData;
    @Column(name = "data_bundel")
    private String dataBundel;
    @Column(name = "flexi_details")
    private String flexiDetails;
    @Column(name = "plan_outof_bundel")
    private String planOutofBundel;
    @Column(name = "national_min")
    private String nationalMin;
    @Column(name = "roaming_incoming_min")
    private String roamingIncomingMin;
    @Column(name = "national_min_offnet")
    private String nationalMinOffnet;
    @Column(name = "plan_preff_number")
    private String planPreffNumber;
    @Column(name = "international_sms")
    private String internationalSms;
    @Column(name = "plan_fee")
    private String planFee;
    @Column(name = "mis_features")
    private String misFeatures;
    @Column(name = "plan_id")
    private String planId;
    @Column(name = "plan_url")
    private String planUrl;
    @Column(name = "planRefid")
    private String planRefid;
    @JoinColumn(name = "deviceprimaryid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PlansDeviceprimaryEntity deviceprimaryid;

    public PlansDevicePlanEntity() {
    }

    public PlansDevicePlanEntity(Integer id) {
        this.id = id;
    }

    public PlansDevicePlanEntity(Integer id, boolean isActive, Date creationDatetime) {
        this.id = id;
        this.isActive = isActive;
        this.creationDatetime = creationDatetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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

    public String getWifiPlan() {
        return wifiPlan;
    }

    public void setWifiPlan(String wifiPlan) {
        this.wifiPlan = wifiPlan;
    }

    public String getSocialData() {
        return socialData;
    }

    public void setSocialData(String socialData) {
        this.socialData = socialData;
    }

    public String getDataBundel() {
        return dataBundel;
    }

    public void setDataBundel(String dataBundel) {
        this.dataBundel = dataBundel;
    }

    public String getFlexiDetails() {
        return flexiDetails;
    }

    public void setFlexiDetails(String flexiDetails) {
        this.flexiDetails = flexiDetails;
    }

    public String getPlanOutofBundel() {
        return planOutofBundel;
    }

    public void setPlanOutofBundel(String planOutofBundel) {
        this.planOutofBundel = planOutofBundel;
    }

    public String getNationalMin() {
        return nationalMin;
    }

    public void setNationalMin(String nationalMin) {
        this.nationalMin = nationalMin;
    }

    public String getRoamingIncomingMin() {
        return roamingIncomingMin;
    }

    public void setRoamingIncomingMin(String roamingIncomingMin) {
        this.roamingIncomingMin = roamingIncomingMin;
    }

    public String getNationalMinOffnet() {
        return nationalMinOffnet;
    }

    public void setNationalMinOffnet(String nationalMinOffnet) {
        this.nationalMinOffnet = nationalMinOffnet;
    }

    public String getPlanPreffNumber() {
        return planPreffNumber;
    }

    public void setPlanPreffNumber(String planPreffNumber) {
        this.planPreffNumber = planPreffNumber;
    }

    public String getInternationalSms() {
        return internationalSms;
    }

    public void setInternationalSms(String internationalSms) {
        this.internationalSms = internationalSms;
    }

    public String getPlanFee() {
        return planFee;
    }

    public void setPlanFee(String planFee) {
        this.planFee = planFee;
    }

    public String getMisFeatures() {
        return misFeatures;
    }

    public void setMisFeatures(String misFeatures) {
        this.misFeatures = misFeatures;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPlanUrl() {
        return planUrl;
    }

    public void setPlanUrl(String planUrl) {
        this.planUrl = planUrl;
    }

    public String getPlanRefid() {
        return planRefid;
    }

    public void setPlanRefid(String planRefid) {
        this.planRefid = planRefid;
    }

    public PlansDeviceprimaryEntity getDeviceprimaryid() {
        return deviceprimaryid;
    }

    public void setDeviceprimaryid(PlansDeviceprimaryEntity deviceprimaryid) {
        this.deviceprimaryid = deviceprimaryid;
    }

    
    public String getPlan_mis_details() {
		return plan_mis_details;
	}

	public void setPlan_mis_details(String plan_mis_details) {
		this.plan_mis_details = plan_mis_details;
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
        if (!(object instanceof PlansDevicePlanEntity)) {
            return false;
        }
        PlansDevicePlanEntity other = (PlansDevicePlanEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansDevicePlan[ id=" + id + " ]";
    }
    
}
