/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.persistance.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pods
 */
@Entity
@Table(name = "plans_planprimary", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlansPlanprimaryEntity.findAll", query = "SELECT p FROM PlansPlanprimaryEntity p")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findById", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByPlanId", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.planId = :planId")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByPlanName", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.planName = :planName")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByPlanStartDate", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.planStartDate = :planStartDate")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByPlanEndDate", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.planEndDate = :planEndDate")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByPlanUrl", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.planUrl = :planUrl")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByIsTaxIncluded", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.isTaxIncluded = :isTaxIncluded")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByPlanValidity", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.planValidity = :planValidity")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByPlanValidityUnit", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.planValidityUnit = :planValidityUnit")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByContractPeriod", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.contractPeriod = :contractPeriod")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByContractPeriodUnit", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.contractPeriodUnit = :contractPeriodUnit")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByAutorenewedFlag", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.autorenewedFlag = :autorenewedFlag")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByIsActive", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.isActive = :isActive")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByTopupsallowedFlag", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.topupsallowedFlag = :topupsallowedFlag")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByNumberOfMultiSims", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.numberOfMultiSims = :numberOfMultiSims")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByPriority", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.priority = :priority")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByLocalExpat", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.localExpat = :localExpat")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByRechargeFrequency", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.rechargeFrequency = :rechargeFrequency")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByPlanFeature", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.planFeature = :planFeature")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByFeatured", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.featured = :featured")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByCreationDatetime", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlanprimaryEntity.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlanprimaryEntity p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")})
public class PlansPlanprimaryEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "plan_id")
    private String planId;
    @Column(name = "plan_name")
    private String planName;
    @Column(name = "plan_longname")
    private String planLongName;
    
    @Column(name = "recurring_bundle")
    private String recurringBbundle;
    @Column(name = "one_time_addon")
    private String oneTimeAddon;
    @Column(name = "discount_text")
    private String discountext;
  
    @Column(name = "plan_start_date")
    @Temporal(TemporalType.DATE)
    private Date planStartDate;
    @Column(name = "plan_end_date")
    @Temporal(TemporalType.DATE)
    private Date planEndDate;
    @Column(name = "plan_url")
    private String planUrl;
    @Basic(optional = false)
    @Column(name = "is_tax_included")
    private boolean isTaxIncluded;
    @Column(name = "plan_validity")
    private Integer planValidity;
    @Column(name = "plan_validity_unit")
    private String planValidityUnit;
    @Column(name = "contract_period")
    private Integer contractPeriod;
    @Column(name = "priority")
    private Integer priority;
    @Column(name = "contract_period_unit")
    private String contractPeriodUnit;
    @Column(name = "local_expat")
    private String localExpat;
    @Column(name = "autorenewed_flag")
    private Integer autorenewedFlag;
    @Basic(optional = false)
    @Column(name = "is_active")
    private boolean isActive;
    @Basic(optional = false)
    @Column(name = "discountedUpfrontPayment")
    private boolean discountedUpfrontPayment;
    @Column(name = "planVatper")
    private Double planVatPer;
    @Basic(optional = false)
    @Column(name = "topupsallowed_flag")
    private boolean topupsallowedFlag;
    @Column(name = "number_of_multi_sims")
    private Integer numberOfMultiSims;
    @Column(name = "recharge_frequency")
    private Integer rechargeFrequency;
    @Column(name = "recharge_frequency_unit")
    private String rechargeFrequencyUnit;
    @Column(name = "featured")
    private int featured;
    @Column(name = "plan_feature")
    private String planFeature;
    @Basic(optional = false)
    @Column(name = "creation_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDatetime;
    @Column(name = "last_modified_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDatetime;
    
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
    @Column(name = "is_addon")
    private boolean isAddon;
    @Basic(optional = false)
    @Column(name = "is_dataonly")
    private boolean isDataOnly;
    @Column(name = "planLayout")
    private int planLayout;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlaninternationalvideocallEntity plansPlaninternationalvideocall;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlaninternationalminutesEntity plansPlaninternationalminutes;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanlocalvideocallEntity plansPlanlocalvideocall;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanwifiEntity plansPlanwifi;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanflexiEntity plansPlanflexi;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanroamingincomingminsEntity plansPlanroamingincomingmins;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanmiscellaneousEntity plansPlanmiscellaneous;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlannationalminutesonnetEntity plansPlannationalminutesonnet;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlannationalminutesEntity plansPlannationalminutes;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlannationaldataEntity plansPlannationaldata;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanunitsEntity plansPlanunits;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanlocalmmsEntity plansPlanlocalmms;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlansmsEntity plansPlansms;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlannationalminutesoffnetEntity plansPlannationalminutesoffnet;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlansocialdataEntity plansPlansocialdata;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanoutofbundleEntity plansPlanoutofbundle;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlaninternationalcallsmsEntity plansPlaninternationalcallsms;
    @JoinColumn(name = "plan_type", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PlansPlantypeEntity planType;
    @JoinColumn(name = "operator_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PlansOperatorEntity operatorId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanfeeEntity plansPlanfee;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanlocalcallsmsEntity plansPlanlocalcallsms;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanroamingoutgoingminsEntity plansPlanroamingoutgoingmins;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlansmsoffnetEntity plansPlansmsoffnet;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlaninternationalmmsEntity plansPlaninternationalmms;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlansmsonnetEntity plansPlansmsonnet;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlaninternationalsmsEntity plansPlaninternationalsms;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanpreferrednumbersEntity plansPlanpreferrednumbers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private Collection<PlansPlanbucketEntity> plansPlanbucketCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanflexismsEntity plansPlanflexisms;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private Collection<PlansMisFeaturesEntity> plansMisFeaturesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private Collection<PlansPlanOperatorTncEntity> plansPlanOperatorTncCollection;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlandataEntity plansPlandata;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanspecialminutesEntity plansPlanspecialminutes;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPartnerRouteEntity plansPartnerRoute;
    
    public PlansPlanprimaryEntity() {
    }

    public PlansPlanprimaryEntity(Integer id) {
        this.id = id;
    }

    public PlansPlanprimaryEntity(Integer id, boolean isTaxIncluded, Integer autorenewedFlag, boolean isActive, boolean topupsallowedFlag, Date creationDatetime) {
        this.id = id;
        this.isTaxIncluded = isTaxIncluded;
        this.autorenewedFlag = autorenewedFlag;
        this.isActive = isActive;
        this.topupsallowedFlag = topupsallowedFlag;
        this.creationDatetime = creationDatetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanId() {
        return planId;
    }
    
    public String getRecurringBbundle() {
		return recurringBbundle;
	}

	public void setRecurringBbundle(String recurringBbundle) {
		this.recurringBbundle = recurringBbundle;
	}

	public String getOneTimeAddon() {
		return oneTimeAddon;
	}

	public void setOneTimeAddon(String oneTimeAddon) {
		this.oneTimeAddon = oneTimeAddon;
	}

	public String getDiscountext() {
		return discountext;
	}

	public void setDiscountext(String discountext) {
		this.discountext = discountext;
	}

	public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanLongName() {
		return planLongName;
	}

	public void setPlanLongName(String planLongName) {
		this.planLongName = planLongName;
	}

	public Date getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate(Date planStartDate) {
        this.planStartDate = planStartDate;
    }

    public Date getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(Date planEndDate) {
        this.planEndDate = planEndDate;
    }

    public String getPlanUrl() {
        return planUrl;
    }

    public void setPlanUrl(String planUrl) {
        this.planUrl = planUrl;
    }

    public boolean getIsTaxIncluded() {
        return isTaxIncluded;
    }

    public void setIsTaxIncluded(boolean isTaxIncluded) {
        this.isTaxIncluded = isTaxIncluded;
    }

    public Integer getPlanValidity() {
        return planValidity;
    }

    public void setPlanValidity(Integer planValidity) {
        this.planValidity = planValidity;
    }

    public String getPlanValidityUnit() {
        return planValidityUnit;
    }

    public void setPlanValidityUnit(String planValidityUnit) {
        this.planValidityUnit = planValidityUnit;
    }

    public Integer getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(Integer contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    public String getContractPeriodUnit() {
        return contractPeriodUnit;
    }

    public void setContractPeriodUnit(String contractPeriodUnit) {
        this.contractPeriodUnit = contractPeriodUnit;
    }

    public Integer getAutorenewedFlag() {
        return autorenewedFlag;
    }

    public void setAutorenewedFlag(Integer autorenewedFlag) {
        this.autorenewedFlag = autorenewedFlag;
    }
    
    public int getFeatured() {
		return featured;
	}

	public void setFeatured(int featured) {
		this.featured = featured;
	}

	public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getTopupsallowedFlag() {
        return topupsallowedFlag;
    }

    public void setTopupsallowedFlag(boolean topupsallowedFlag) {
        this.topupsallowedFlag = topupsallowedFlag;
    }

    public Integer getNumberOfMultiSims() {
        return numberOfMultiSims;
    }

    public void setNumberOfMultiSims(Integer numberOfMultiSims) {
        this.numberOfMultiSims = numberOfMultiSims;
    }

    public boolean isDiscountedUpfrontPayment() {
		return discountedUpfrontPayment;
	}

	public void setDiscountedUpfrontPayment(boolean discountedUpfrontPayment) {
		this.discountedUpfrontPayment = discountedUpfrontPayment;
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

    public PlansPlaninternationalvideocallEntity getPlansPlaninternationalvideocall() {
        return plansPlaninternationalvideocall;
    }

    public void setPlansPlaninternationalvideocall(PlansPlaninternationalvideocallEntity plansPlaninternationalvideocall) {
        this.plansPlaninternationalvideocall = plansPlaninternationalvideocall;
    }

    public PlansPlaninternationalminutesEntity getPlansPlaninternationalminutes() {
        return plansPlaninternationalminutes;
    }

    public void setPlansPlaninternationalminutes(PlansPlaninternationalminutesEntity plansPlaninternationalminutes) {
        this.plansPlaninternationalminutes = plansPlaninternationalminutes;
    }

    public PlansPlanlocalvideocallEntity getPlansPlanlocalvideocall() {
        return plansPlanlocalvideocall;
    }

    public void setPlansPlanlocalvideocall(PlansPlanlocalvideocallEntity plansPlanlocalvideocall) {
        this.plansPlanlocalvideocall = plansPlanlocalvideocall;
    }

    public PlansPlanwifiEntity getPlansPlanwifi() {
        return plansPlanwifi;
    }

    public void setPlansPlanwifi(PlansPlanwifiEntity plansPlanwifi) {
        this.plansPlanwifi = plansPlanwifi;
    }

    public PlansPlanflexiEntity getPlansPlanflexi() {
        return plansPlanflexi;
    }

    public void setPlansPlanflexi(PlansPlanflexiEntity plansPlanflexi) {
        this.plansPlanflexi = plansPlanflexi;
    }

    public PlansPlanroamingincomingminsEntity getPlansPlanroamingincomingmins() {
        return plansPlanroamingincomingmins;
    }

    public void setPlansPlanroamingincomingmins(PlansPlanroamingincomingminsEntity plansPlanroamingincomingmins) {
        this.plansPlanroamingincomingmins = plansPlanroamingincomingmins;
    }

    public PlansPlanmiscellaneousEntity getPlansPlanmiscellaneous() {
        return plansPlanmiscellaneous;
    }

    public void setPlansPlanmiscellaneous(PlansPlanmiscellaneousEntity plansPlanmiscellaneous) {
        this.plansPlanmiscellaneous = plansPlanmiscellaneous;
    }

    public PlansPlannationalminutesonnetEntity getPlansPlannationalminutesonnet() {
        return plansPlannationalminutesonnet;
    }

    public void setPlansPlannationalminutesonnet(PlansPlannationalminutesonnetEntity plansPlannationalminutesonnet) {
        this.plansPlannationalminutesonnet = plansPlannationalminutesonnet;
    }

    public PlansPlannationalminutesEntity getPlansPlannationalminutes() {
        return plansPlannationalminutes;
    }

    public void setPlansPlannationalminutes(PlansPlannationalminutesEntity plansPlannationalminutes) {
        this.plansPlannationalminutes = plansPlannationalminutes;
    }

    public PlansPlannationaldataEntity getPlansPlannationaldata() {
        return plansPlannationaldata;
    }

    public void setPlansPlannationaldata(PlansPlannationaldataEntity plansPlannationaldata) {
        this.plansPlannationaldata = plansPlannationaldata;
    }

    public PlansPlanunitsEntity getPlansPlanunits() {
        return plansPlanunits;
    }

    public void setPlansPlanunits(PlansPlanunitsEntity plansPlanunits) {
        this.plansPlanunits = plansPlanunits;
    }

    public PlansPlanlocalmmsEntity getPlansPlanlocalmms() {
        return plansPlanlocalmms;
    }

    public void setPlansPlanlocalmms(PlansPlanlocalmmsEntity plansPlanlocalmms) {
        this.plansPlanlocalmms = plansPlanlocalmms;
    }

    public PlansPlansmsEntity getPlansPlansms() {
        return plansPlansms;
    }

    public void setPlansPlansms(PlansPlansmsEntity plansPlansms) {
        this.plansPlansms = plansPlansms;
    }

    public PlansPlannationalminutesoffnetEntity getPlansPlannationalminutesoffnet() {
        return plansPlannationalminutesoffnet;
    }

    public void setPlansPlannationalminutesoffnet(PlansPlannationalminutesoffnetEntity plansPlannationalminutesoffnet) {
        this.plansPlannationalminutesoffnet = plansPlannationalminutesoffnet;
    }

    public PlansPlansocialdataEntity getPlansPlansocialdata() {
        return plansPlansocialdata;
    }

    public void setPlansPlansocialdata(PlansPlansocialdataEntity plansPlansocialdata) {
        this.plansPlansocialdata = plansPlansocialdata;
    }

    public PlansPlanoutofbundleEntity getPlansPlanoutofbundle() {
        return plansPlanoutofbundle;
    }

    public void setPlansPlanoutofbundle(PlansPlanoutofbundleEntity plansPlanoutofbundle) {
        this.plansPlanoutofbundle = plansPlanoutofbundle;
    }

    public PlansPlaninternationalcallsmsEntity getPlansPlaninternationalcallsms() {
        return plansPlaninternationalcallsms;
    }

    public void setPlansPlaninternationalcallsms(PlansPlaninternationalcallsmsEntity plansPlaninternationalcallsms) {
        this.plansPlaninternationalcallsms = plansPlaninternationalcallsms;
    }

    public PlansPlantypeEntity getPlanType() {
        return planType;
    }

    public void setPlanType(PlansPlantypeEntity planType) {
        this.planType = planType;
    }

    public PlansOperatorEntity getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(PlansOperatorEntity operatorId) {
        this.operatorId = operatorId;
    }

    public PlansPlanfeeEntity getPlansPlanfee() {
        return plansPlanfee;
    }

    public void setPlansPlanfee(PlansPlanfeeEntity plansPlanfee) {
        this.plansPlanfee = plansPlanfee;
    }

    public PlansPlanlocalcallsmsEntity getPlansPlanlocalcallsms() {
        return plansPlanlocalcallsms;
    }

    public void setPlansPlanlocalcallsms(PlansPlanlocalcallsmsEntity plansPlanlocalcallsms) {
        this.plansPlanlocalcallsms = plansPlanlocalcallsms;
    }

    public PlansPlanroamingoutgoingminsEntity getPlansPlanroamingoutgoingmins() {
        return plansPlanroamingoutgoingmins;
    }

    public void setPlansPlanroamingoutgoingmins(PlansPlanroamingoutgoingminsEntity plansPlanroamingoutgoingmins) {
        this.plansPlanroamingoutgoingmins = plansPlanroamingoutgoingmins;
    }

    public PlansPlansmsoffnetEntity getPlansPlansmsoffnet() {
        return plansPlansmsoffnet;
    }

    public void setPlansPlansmsoffnet(PlansPlansmsoffnetEntity plansPlansmsoffnet) {
        this.plansPlansmsoffnet = plansPlansmsoffnet;
    }

    public PlansPlaninternationalmmsEntity getPlansPlaninternationalmms() {
        return plansPlaninternationalmms;
    }

    public void setPlansPlaninternationalmms(PlansPlaninternationalmmsEntity plansPlaninternationalmms) {
        this.plansPlaninternationalmms = plansPlaninternationalmms;
    }

    public PlansPlansmsonnetEntity getPlansPlansmsonnet() {
        return plansPlansmsonnet;
    }

    public void setPlansPlansmsonnet(PlansPlansmsonnetEntity plansPlansmsonnet) {
        this.plansPlansmsonnet = plansPlansmsonnet;
    }

    public PlansPlaninternationalsmsEntity getPlansPlaninternationalsms() {
        return plansPlaninternationalsms;
    }

    public void setPlansPlaninternationalsms(PlansPlaninternationalsmsEntity plansPlaninternationalsms) {
        this.plansPlaninternationalsms = plansPlaninternationalsms;
    }

    public PlansPlanpreferrednumbersEntity getPlansPlanpreferrednumbers() {
        return plansPlanpreferrednumbers;
    }

    public void setPlansPlanpreferrednumbers(PlansPlanpreferrednumbersEntity plansPlanpreferrednumbers) {
        this.plansPlanpreferrednumbers = plansPlanpreferrednumbers;
    }

    public Integer getRechargeFrequency() {
		return rechargeFrequency;
	}

    public void setRechargeFrequency(Integer rechargeFrequency) {
		this.rechargeFrequency = rechargeFrequency;
	}

    public String getRechargeFrequencyUnit() {
		return rechargeFrequencyUnit;
	}

	public void setRechargeFrequencyUnit(String rechargeFrequencyUnit) {
		this.rechargeFrequencyUnit = rechargeFrequencyUnit;
	}

	public Integer getPriority() {
		return priority;
	}
	
    public void setPriority(Integer priority) {
		this.priority = priority;
	}

    public Collection<PlansPlanbucketEntity> getPlansPlanbucketCollection() {
        return plansPlanbucketCollection;
    }

    public void setPlansPlanbucketCollection(Collection<PlansPlanbucketEntity> plansPlanbucketCollection) {
        this.plansPlanbucketCollection = plansPlanbucketCollection;
    }
    
    
	public String getLocalExpat() {
		return localExpat;
	}

	public void setLocalExpat(String localExpat) {
		this.localExpat = localExpat;
	}

	public String getPlanFeature() {
        return planFeature;
    }

    public void setPlanFeature(String planFeature) {
        this.planFeature = planFeature;
    }

    
    public PlansPlanflexismsEntity getPlansPlanflexisms() {
        return plansPlanflexisms;
    }

    public Double getPlanVatPer() {
		return planVatPer;
	}

	public void setPlanVatPer(Double planVatPer) {
		this.planVatPer = planVatPer;
	}

	public void setPlansPlanflexisms(PlansPlanflexismsEntity plansPlanflexisms) {
        this.plansPlanflexisms = plansPlanflexisms;
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
	

    public Collection<PlansMisFeaturesEntity> getPlansMisFeaturesCollection() {
        return plansMisFeaturesCollection;
    }

    public void setPlansMisFeaturesCollection(Collection<PlansMisFeaturesEntity> plansMisFeaturesCollection) {
        this.plansMisFeaturesCollection = plansMisFeaturesCollection;
    }

    public Collection<PlansPlanOperatorTncEntity> getPlansPlanOperatorTncCollection() {
        return plansPlanOperatorTncCollection;
    }

    public void setPlansPlanOperatorTncCollection(Collection<PlansPlanOperatorTncEntity> plansPlanOperatorTncCollection) {
        this.plansPlanOperatorTncCollection = plansPlanOperatorTncCollection;
    }

    public PlansPlandataEntity getPlansPlandata() {
        return plansPlandata;
    }

    public void setPlansPlandata(PlansPlandataEntity plansPlandata) {
        this.plansPlandata = plansPlandata;
    }

    public PlansPlanspecialminutesEntity getPlansPlanspecialminutes() {
        return plansPlanspecialminutes;
    }

    public void setPlansPlanspecialminutes(PlansPlanspecialminutesEntity plansPlanspecialminutes) {
        this.plansPlanspecialminutes = plansPlanspecialminutes;
    }

	public boolean getIsAddon() {
        return isAddon;
    }

    public void setIsAddon(boolean isAddon) {
        this.isAddon = isAddon;
    }

    public boolean isDataOnly() {
		return isDataOnly;
	}

	public void setDataOnly(boolean isDataOnly) {
		this.isDataOnly = isDataOnly;
	}
	
	public int getPlanLayout() {
		return planLayout;
	}

	public void setPlanLayout(int planLayout) {
		this.planLayout = planLayout;
	}

	public PlansPartnerRouteEntity getPlansPartnerRoute() {
		return plansPartnerRoute;
	}

	public void setPlansPartnerRoute(PlansPartnerRouteEntity plansPartnerRoute) {
		this.plansPartnerRoute = plansPartnerRoute;
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

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlansPlanprimaryEntity)) {
            return false;
        }
        PlansPlanprimaryEntity other = (PlansPlanprimaryEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanprimary[ id=" + id + " ]";
    }

	public static Comparator<PlansPlanprimaryEntity> PLAN_MONTHLYFEE_COMPARATOR = new Comparator<PlansPlanprimaryEntity>() {
		public int compare( PlansPlanprimaryEntity plansPlanprimary1, PlansPlanprimaryEntity plansPlanprimary2) {
			return ((PlansPlanfeeEntity) plansPlanprimary1.getPlansPlanfee()).getPlanMonthlyFee().intValue()-((PlansPlanfeeEntity) plansPlanprimary2.getPlansPlanfee()).getPlanMonthlyFee().intValue();
		}
	};
}
