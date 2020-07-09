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
    @NamedQuery(name = "PlansPlanprimary.findAll", query = "SELECT p FROM PlansPlanprimary p")
    , @NamedQuery(name = "PlansPlanprimary.findById", query = "SELECT p FROM PlansPlanprimary p WHERE p.id = :id")
    , @NamedQuery(name = "PlansPlanprimary.findByPlanId", query = "SELECT p FROM PlansPlanprimary p WHERE p.planId = :planId")
    , @NamedQuery(name = "PlansPlanprimary.findByPlanName", query = "SELECT p FROM PlansPlanprimary p WHERE p.planName = :planName")
    , @NamedQuery(name = "PlansPlanprimary.findByPlanStartDate", query = "SELECT p FROM PlansPlanprimary p WHERE p.planStartDate = :planStartDate")
    , @NamedQuery(name = "PlansPlanprimary.findByPlanEndDate", query = "SELECT p FROM PlansPlanprimary p WHERE p.planEndDate = :planEndDate")
    , @NamedQuery(name = "PlansPlanprimary.findByPlanUrl", query = "SELECT p FROM PlansPlanprimary p WHERE p.planUrl = :planUrl")
    , @NamedQuery(name = "PlansPlanprimary.findByIsTaxIncluded", query = "SELECT p FROM PlansPlanprimary p WHERE p.isTaxIncluded = :isTaxIncluded")
    , @NamedQuery(name = "PlansPlanprimary.findByPlanValidity", query = "SELECT p FROM PlansPlanprimary p WHERE p.planValidity = :planValidity")
    , @NamedQuery(name = "PlansPlanprimary.findByPlanValidityUnit", query = "SELECT p FROM PlansPlanprimary p WHERE p.planValidityUnit = :planValidityUnit")
    , @NamedQuery(name = "PlansPlanprimary.findByContractPeriod", query = "SELECT p FROM PlansPlanprimary p WHERE p.contractPeriod = :contractPeriod")
    , @NamedQuery(name = "PlansPlanprimary.findByContractPeriodUnit", query = "SELECT p FROM PlansPlanprimary p WHERE p.contractPeriodUnit = :contractPeriodUnit")
    , @NamedQuery(name = "PlansPlanprimary.findByAutorenewedFlag", query = "SELECT p FROM PlansPlanprimary p WHERE p.autorenewedFlag = :autorenewedFlag")
    , @NamedQuery(name = "PlansPlanprimary.findByIsActive", query = "SELECT p FROM PlansPlanprimary p WHERE p.isActive = :isActive")
    , @NamedQuery(name = "PlansPlanprimary.findByTopupsallowedFlag", query = "SELECT p FROM PlansPlanprimary p WHERE p.topupsallowedFlag = :topupsallowedFlag")
    , @NamedQuery(name = "PlansPlanprimary.findByNumberOfMultiSims", query = "SELECT p FROM PlansPlanprimary p WHERE p.numberOfMultiSims = :numberOfMultiSims")
    , @NamedQuery(name = "PlansPlanprimary.findByPriority", query = "SELECT p FROM PlansPlanprimary p WHERE p.priority = :priority")
    , @NamedQuery(name = "PlansPlanprimary.findByLocalExpat", query = "SELECT p FROM PlansPlanprimary p WHERE p.localExpat = :localExpat")
    , @NamedQuery(name = "PlansPlanprimary.findByRechargeFrequency", query = "SELECT p FROM PlansPlanprimary p WHERE p.rechargeFrequency = :rechargeFrequency")
    , @NamedQuery(name = "PlansPlanprimary.findByPlanFeature", query = "SELECT p FROM PlansPlanprimary p WHERE p.planFeature = :planFeature")
    , @NamedQuery(name = "PlansPlanprimary.findByFeatured", query = "SELECT p FROM PlansPlanprimary p WHERE p.featured = :featured")
    , @NamedQuery(name = "PlansPlanprimary.findByCreationDatetime", query = "SELECT p FROM PlansPlanprimary p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlansPlanprimary.findByLastModifiedDatetime", query = "SELECT p FROM PlansPlanprimary p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")})
public class PlansPlanprimary implements Serializable {

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
    @Column(name = "great_offers")
    private boolean greatOffers;
    
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlaninternationalvideocall plansPlaninternationalvideocall;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlaninternationalminutes plansPlaninternationalminutes;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanlocalvideocall plansPlanlocalvideocall;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanwifi plansPlanwifi;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanflexi plansPlanflexi;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanroamingincomingmins plansPlanroamingincomingmins;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanmiscellaneous plansPlanmiscellaneous;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlannationalminutesonnet plansPlannationalminutesonnet;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlannationalminutes plansPlannationalminutes;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlannationaldata plansPlannationaldata;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanunits plansPlanunits;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanlocalmms plansPlanlocalmms;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlansms plansPlansms;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlannationalminutesoffnet plansPlannationalminutesoffnet;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlansocialdata plansPlansocialdata;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanoutofbundle plansPlanoutofbundle;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlaninternationalcallsms plansPlaninternationalcallsms;
    @JoinColumn(name = "plan_type", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PlansPlantype planType;
    @JoinColumn(name = "operator_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PlansOperator operatorId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanfee plansPlanfee;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanlocalcallsms plansPlanlocalcallsms;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanroamingoutgoingmins plansPlanroamingoutgoingmins;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlansmsoffnet plansPlansmsoffnet;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlaninternationalmms plansPlaninternationalmms;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlansmsonnet plansPlansmsonnet;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlaninternationalsms plansPlaninternationalsms;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanpreferrednumbers plansPlanpreferrednumbers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private Collection<PlansPlanbucket> plansPlanbucketCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanflexisms plansPlanflexisms;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private Collection<PlansMisFeatures> plansMisFeaturesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private Collection<PlansPlanOperatorTnc> plansPlanOperatorTncCollection;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlandata plansPlandata;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanspecialminutes plansPlanspecialminutes;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPartnerRoute plansPartnerRoute;
    
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "planPrimaryId")
    private PlansPlanoffers plansPlanoffers;

    public PlansPlanprimary() {
    }

    public PlansPlanprimary(Integer id) {
        this.id = id;
    }

    public PlansPlanprimary(Integer id, boolean isTaxIncluded, Integer autorenewedFlag, boolean isActive, boolean topupsallowedFlag, Date creationDatetime) {
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

    public PlansPlaninternationalvideocall getPlansPlaninternationalvideocall() {
        return plansPlaninternationalvideocall;
    }

    public void setPlansPlaninternationalvideocall(PlansPlaninternationalvideocall plansPlaninternationalvideocall) {
        this.plansPlaninternationalvideocall = plansPlaninternationalvideocall;
    }

    public PlansPlaninternationalminutes getPlansPlaninternationalminutes() {
        return plansPlaninternationalminutes;
    }

    public void setPlansPlaninternationalminutes(PlansPlaninternationalminutes plansPlaninternationalminutes) {
        this.plansPlaninternationalminutes = plansPlaninternationalminutes;
    }

    public PlansPlanlocalvideocall getPlansPlanlocalvideocall() {
        return plansPlanlocalvideocall;
    }

    public void setPlansPlanlocalvideocall(PlansPlanlocalvideocall plansPlanlocalvideocall) {
        this.plansPlanlocalvideocall = plansPlanlocalvideocall;
    }

    public PlansPlanwifi getPlansPlanwifi() {
        return plansPlanwifi;
    }

    public void setPlansPlanwifi(PlansPlanwifi plansPlanwifi) {
        this.plansPlanwifi = plansPlanwifi;
    }

    public PlansPlanflexi getPlansPlanflexi() {
        return plansPlanflexi;
    }

    public void setPlansPlanflexi(PlansPlanflexi plansPlanflexi) {
        this.plansPlanflexi = plansPlanflexi;
    }

    public PlansPlanroamingincomingmins getPlansPlanroamingincomingmins() {
        return plansPlanroamingincomingmins;
    }

    public void setPlansPlanroamingincomingmins(PlansPlanroamingincomingmins plansPlanroamingincomingmins) {
        this.plansPlanroamingincomingmins = plansPlanroamingincomingmins;
    }

    public PlansPlanmiscellaneous getPlansPlanmiscellaneous() {
        return plansPlanmiscellaneous;
    }

    public void setPlansPlanmiscellaneous(PlansPlanmiscellaneous plansPlanmiscellaneous) {
        this.plansPlanmiscellaneous = plansPlanmiscellaneous;
    }

    public PlansPlannationalminutesonnet getPlansPlannationalminutesonnet() {
        return plansPlannationalminutesonnet;
    }

    public void setPlansPlannationalminutesonnet(PlansPlannationalminutesonnet plansPlannationalminutesonnet) {
        this.plansPlannationalminutesonnet = plansPlannationalminutesonnet;
    }

    public PlansPlannationalminutes getPlansPlannationalminutes() {
        return plansPlannationalminutes;
    }

    public void setPlansPlannationalminutes(PlansPlannationalminutes plansPlannationalminutes) {
        this.plansPlannationalminutes = plansPlannationalminutes;
    }

    public PlansPlannationaldata getPlansPlannationaldata() {
        return plansPlannationaldata;
    }

    public void setPlansPlannationaldata(PlansPlannationaldata plansPlannationaldata) {
        this.plansPlannationaldata = plansPlannationaldata;
    }

    public PlansPlanunits getPlansPlanunits() {
        return plansPlanunits;
    }

    public void setPlansPlanunits(PlansPlanunits plansPlanunits) {
        this.plansPlanunits = plansPlanunits;
    }

    public PlansPlanlocalmms getPlansPlanlocalmms() {
        return plansPlanlocalmms;
    }

    public void setPlansPlanlocalmms(PlansPlanlocalmms plansPlanlocalmms) {
        this.plansPlanlocalmms = plansPlanlocalmms;
    }

    public PlansPlansms getPlansPlansms() {
        return plansPlansms;
    }

    public void setPlansPlansms(PlansPlansms plansPlansms) {
        this.plansPlansms = plansPlansms;
    }

    public PlansPlannationalminutesoffnet getPlansPlannationalminutesoffnet() {
        return plansPlannationalminutesoffnet;
    }

    public void setPlansPlannationalminutesoffnet(PlansPlannationalminutesoffnet plansPlannationalminutesoffnet) {
        this.plansPlannationalminutesoffnet = plansPlannationalminutesoffnet;
    }

    public PlansPlansocialdata getPlansPlansocialdata() {
        return plansPlansocialdata;
    }

    public void setPlansPlansocialdata(PlansPlansocialdata plansPlansocialdata) {
        this.plansPlansocialdata = plansPlansocialdata;
    }

    public PlansPlanoutofbundle getPlansPlanoutofbundle() {
        return plansPlanoutofbundle;
    }

    public void setPlansPlanoutofbundle(PlansPlanoutofbundle plansPlanoutofbundle) {
        this.plansPlanoutofbundle = plansPlanoutofbundle;
    }

    public PlansPlaninternationalcallsms getPlansPlaninternationalcallsms() {
        return plansPlaninternationalcallsms;
    }

    public void setPlansPlaninternationalcallsms(PlansPlaninternationalcallsms plansPlaninternationalcallsms) {
        this.plansPlaninternationalcallsms = plansPlaninternationalcallsms;
    }

    public PlansPlantype getPlanType() {
        return planType;
    }

    public void setPlanType(PlansPlantype planType) {
        this.planType = planType;
    }

    public PlansOperator getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(PlansOperator operatorId) {
        this.operatorId = operatorId;
    }

    public PlansPlanfee getPlansPlanfee() {
        return plansPlanfee;
    }

    public void setPlansPlanfee(PlansPlanfee plansPlanfee) {
        this.plansPlanfee = plansPlanfee;
    }

    public PlansPlanlocalcallsms getPlansPlanlocalcallsms() {
        return plansPlanlocalcallsms;
    }

    public void setPlansPlanlocalcallsms(PlansPlanlocalcallsms plansPlanlocalcallsms) {
        this.plansPlanlocalcallsms = plansPlanlocalcallsms;
    }

    public PlansPlanroamingoutgoingmins getPlansPlanroamingoutgoingmins() {
        return plansPlanroamingoutgoingmins;
    }

    public void setPlansPlanroamingoutgoingmins(PlansPlanroamingoutgoingmins plansPlanroamingoutgoingmins) {
        this.plansPlanroamingoutgoingmins = plansPlanroamingoutgoingmins;
    }

    public PlansPlansmsoffnet getPlansPlansmsoffnet() {
        return plansPlansmsoffnet;
    }

    public void setPlansPlansmsoffnet(PlansPlansmsoffnet plansPlansmsoffnet) {
        this.plansPlansmsoffnet = plansPlansmsoffnet;
    }

    public PlansPlaninternationalmms getPlansPlaninternationalmms() {
        return plansPlaninternationalmms;
    }

    public void setPlansPlaninternationalmms(PlansPlaninternationalmms plansPlaninternationalmms) {
        this.plansPlaninternationalmms = plansPlaninternationalmms;
    }

    public PlansPlansmsonnet getPlansPlansmsonnet() {
        return plansPlansmsonnet;
    }

    public void setPlansPlansmsonnet(PlansPlansmsonnet plansPlansmsonnet) {
        this.plansPlansmsonnet = plansPlansmsonnet;
    }

    public PlansPlaninternationalsms getPlansPlaninternationalsms() {
        return plansPlaninternationalsms;
    }

    public void setPlansPlaninternationalsms(PlansPlaninternationalsms plansPlaninternationalsms) {
        this.plansPlaninternationalsms = plansPlaninternationalsms;
    }

    public PlansPlanpreferrednumbers getPlansPlanpreferrednumbers() {
        return plansPlanpreferrednumbers;
    }

    public void setPlansPlanpreferrednumbers(PlansPlanpreferrednumbers plansPlanpreferrednumbers) {
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

    public Collection<PlansPlanbucket> getPlansPlanbucketCollection() {
        return plansPlanbucketCollection;
    }

    public void setPlansPlanbucketCollection(Collection<PlansPlanbucket> plansPlanbucketCollection) {
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

    
    public PlansPlanflexisms getPlansPlanflexisms() {
        return plansPlanflexisms;
    }

    public Double getPlanVatPer() {
		return planVatPer;
	}

	public void setPlanVatPer(Double planVatPer) {
		this.planVatPer = planVatPer;
	}

	public void setPlansPlanflexisms(PlansPlanflexisms plansPlanflexisms) {
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
	

    public Collection<PlansMisFeatures> getPlansMisFeaturesCollection() {
        return plansMisFeaturesCollection;
    }

    public void setPlansMisFeaturesCollection(Collection<PlansMisFeatures> plansMisFeaturesCollection) {
        this.plansMisFeaturesCollection = plansMisFeaturesCollection;
    }

    public Collection<PlansPlanOperatorTnc> getPlansPlanOperatorTncCollection() {
        return plansPlanOperatorTncCollection;
    }

    public void setPlansPlanOperatorTncCollection(Collection<PlansPlanOperatorTnc> plansPlanOperatorTncCollection) {
        this.plansPlanOperatorTncCollection = plansPlanOperatorTncCollection;
    }

    public PlansPlandata getPlansPlandata() {
        return plansPlandata;
    }

    public void setPlansPlandata(PlansPlandata plansPlandata) {
        this.plansPlandata = plansPlandata;
    }

    public PlansPlanspecialminutes getPlansPlanspecialminutes() {
        return plansPlanspecialminutes;
    }

    public void setPlansPlanspecialminutes(PlansPlanspecialminutes plansPlanspecialminutes) {
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

	public PlansPartnerRoute getPlansPartnerRoute() {
		return plansPartnerRoute;
	}

	public void setPlansPartnerRoute(PlansPartnerRoute plansPartnerRoute) {
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

    public PlansPlanoffers getPlansPlanoffers() {
        return plansPlanoffers;
    }

    public void setPlansPlanoffers(PlansPlanoffers plansPlanoffers) {
        this.plansPlanoffers = plansPlanoffers;
    }

	public boolean isGreatOffers() {
		return greatOffers;
	}

	public void setGreatOffers(boolean greatOffers) {
		this.greatOffers = greatOffers;
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
        if (!(object instanceof PlansPlanprimary)) {
            return false;
        }
        PlansPlanprimary other = (PlansPlanprimary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansPlanprimary[ id=" + id + " ]";
    }

	public static Comparator<PlansPlanprimary> PLAN_MONTHLYFEE_COMPARATOR = new Comparator<PlansPlanprimary>() {
		public int compare( PlansPlanprimary plansPlanprimary1, PlansPlanprimary plansPlanprimary2) {
			return ((PlansPlanfee) plansPlanprimary1.getPlansPlanfee()).getPlanMonthlyFee().intValue()-((PlansPlanfee) plansPlanprimary2.getPlansPlanfee()).getPlanMonthlyFee().intValue();
		}
	};
}
