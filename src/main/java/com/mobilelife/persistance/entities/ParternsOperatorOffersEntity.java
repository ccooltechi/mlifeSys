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
@Table(name = "parterns_operator_offers", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParternsOperatorOffersEntity.findAll", query = "SELECT p FROM ParternsOperatorOffersEntity p")
    , @NamedQuery(name = "ParternsOperatorOffersEntity.findById", query = "SELECT p FROM ParternsOperatorOffersEntity p WHERE p.id = :id")
    , @NamedQuery(name = "ParternsOperatorOffersEntity.findByOperatorId", query = "SELECT p FROM ParternsOperatorOffersEntity p WHERE p.operatorId = :operatorId")
    , @NamedQuery(name = "ParternsOperatorOffersEntity.findByPlantypeId", query = "SELECT p FROM ParternsOperatorOffersEntity p WHERE p.plantypeId = :plantypeId")
    , @NamedQuery(name = "ParternsOperatorOffersEntity.findByCreationDatetime", query = "SELECT p FROM ParternsOperatorOffersEntity p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "ParternsOperatorOffersEntity.findByLastModifiedDatetime", query = "SELECT p FROM ParternsOperatorOffersEntity p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "ParternsOperatorOffersEntity.findByIsActive", query = "SELECT p FROM ParternsOperatorOffersEntity p WHERE p.isActive = :isActive")
    , @NamedQuery(name = "ParternsOperatorOffersEntity.findByOfferCode", query = "SELECT p FROM ParternsOperatorOffersEntity p WHERE p.offerCode = :offerCode")
    , @NamedQuery(name = "ParternsOperatorOffersEntity.findByOfferName", query = "SELECT p FROM ParternsOperatorOffersEntity p WHERE p.offerName = :offerName")
    , @NamedQuery(name = "ParternsOperatorOffersEntity.findByOfferAgeFrom", query = "SELECT p FROM ParternsOperatorOffersEntity p WHERE p.offerAgeFrom = :offerAgeFrom")
    , @NamedQuery(name = "ParternsOperatorOffersEntity.findByOfferAgeTo", query = "SELECT p FROM ParternsOperatorOffersEntity p WHERE p.offerAgeTo = :offerAgeTo")
    , @NamedQuery(name = "ParternsOperatorOffersEntity.findByOfferType", query = "SELECT p FROM ParternsOperatorOffersEntity p WHERE p.offerType = :offerType")
    , @NamedQuery(name = "ParternsOperatorOffersEntity.findByOfferValue", query = "SELECT p FROM ParternsOperatorOffersEntity p WHERE p.offerValue = :offerValue")
    , @NamedQuery(name = "ParternsOperatorOffersEntity.findByCodeSuffix", query = "SELECT p FROM ParternsOperatorOffersEntity p WHERE p.codeSuffix = :codeSuffix")
    , @NamedQuery(name = "ParternsOperatorOffersEntity.findByCodePrefix", query = "SELECT p FROM ParternsOperatorOffersEntity p WHERE p.codePrefix = :codePrefix")
    , @NamedQuery(name = "ParternsOperatorOffersEntity.findByPerCouponValue", query = "SELECT p FROM ParternsOperatorOffersEntity p WHERE p.perCouponValue = :perCouponValue")
    , @NamedQuery(name = "ParternsOperatorOffersEntity.findByCouponInvTotal", query = "SELECT p FROM ParternsOperatorOffersEntity p WHERE p.couponInvTotal = :couponInvTotal")
    , @NamedQuery(name = "ParternsOperatorOffersEntity.findByCouponInvUsed", query = "SELECT p FROM ParternsOperatorOffersEntity p WHERE p.couponInvUsed = :couponInvUsed")})
public class ParternsOperatorOffersEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "operator_id")
    private Integer operatorId;
    @Column(name = "plantype_id")
    private Integer plantypeId;
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
    @Column(name = "offer_code")
    private String offerCode;
    @Column(name = "offer_name")
    private String offerName;
    @Column(name = "offer_age_from")
    @Temporal(TemporalType.TIMESTAMP)
    private Date offerAgeFrom;
    @Column(name = "offer_age_to")
    @Temporal(TemporalType.TIMESTAMP)
    private Date offerAgeTo;
    @Column(name = "offer_type")
    private String offerType;
    @Column(name = "offer_value")
    private Integer offerValue;
    @Column(name = "code_suffix")
    private String codeSuffix;
    @Column(name = "code_prefix")
    private String codePrefix;
    @Column(name = "per_coupon_value")
    private Integer perCouponValue;
    @Column(name = "coupon_inv_total")
    private Integer couponInvTotal;
    @Column(name = "coupon_inv_used")
    private Integer couponInvUsed;
    @Column(name = "code_seq_start")
    private Integer codeSeqStart;
    @Column(name = "status")
    private Integer status;
    @Column(name = "last_seq_generated")
    private Integer lastSeqGenerated;
    @OneToMany(mappedBy = "parternsOperatorOffersId")
    private Collection<OrderOffersMapEntity> orderOffersMapCollection;
    @JoinColumn(name = "aliance_parterns_id", referencedColumnName = "id")
    @ManyToOne
    private AlianceParternsEntity alianceParternsId;
    @OneToMany(mappedBy = "parternsOperatorOffersId")
    private Collection<ParternsOperatorOffersCouponsEntity> parternsOperatorOffersCouponsCollection;

    public ParternsOperatorOffersEntity() {
    }

    public ParternsOperatorOffersEntity(Integer id) {
        this.id = id;
    }

    public ParternsOperatorOffersEntity(Integer id, Date creationDatetime, boolean isActive) {
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

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getPlantypeId() {
        return plantypeId;
    }

    public void setPlantypeId(Integer plantypeId) {
        this.plantypeId = plantypeId;
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

    public String getOfferCode() {
        return offerCode;
    }

    public void setOfferCode(String offerCode) {
        this.offerCode = offerCode;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public Date getOfferAgeFrom() {
        return offerAgeFrom;
    }

    public void setOfferAgeFrom(Date offerAgeFrom) {
        this.offerAgeFrom = offerAgeFrom;
    }

    public Date getOfferAgeTo() {
        return offerAgeTo;
    }

    public void setOfferAgeTo(Date offerAgeTo) {
        this.offerAgeTo = offerAgeTo;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public Integer getOfferValue() {
        return offerValue;
    }

    public void setOfferValue(Integer offerValue) {
        this.offerValue = offerValue;
    }

    public String getCodeSuffix() {
        return codeSuffix;
    }

    public void setCodeSuffix(String codeSuffix) {
        this.codeSuffix = codeSuffix;
    }

    public String getCodePrefix() {
        return codePrefix;
    }

    public void setCodePrefix(String codePrefix) {
        this.codePrefix = codePrefix;
    }

    public Integer getPerCouponValue() {
        return perCouponValue;
    }

    public void setPerCouponValue(Integer perCouponValue) {
        this.perCouponValue = perCouponValue;
    }

    public Integer getCouponInvTotal() {
        return couponInvTotal;
    }

    public void setCouponInvTotal(Integer couponInvTotal) {
        this.couponInvTotal = couponInvTotal;
    }

    public Integer getCouponInvUsed() {
        return couponInvUsed;
    }

    public void setCouponInvUsed(Integer couponInvUsed) {
        this.couponInvUsed = couponInvUsed;
    }

    public Integer getCodeSeqStart() {
		return codeSeqStart;
	}

	public void setCodeSeqStart(Integer codeSeqStart) {
		this.codeSeqStart = codeSeqStart;
	}

	public Integer getLastSeqGenerated() {
		return lastSeqGenerated;
	}

	public void setLastSeqGenerated(Integer lastSeqGenerated) {
		this.lastSeqGenerated = lastSeqGenerated;
	}

	@XmlTransient
    public Collection<OrderOffersMapEntity> getOrderOffersMapCollection() {
        return orderOffersMapCollection;
    }

    public void setOrderOffersMapCollection(Collection<OrderOffersMapEntity> orderOffersMapCollection) {
        this.orderOffersMapCollection = orderOffersMapCollection;
    }

    public AlianceParternsEntity getAlianceParternsId() {
        return alianceParternsId;
    }

    public void setAlianceParternsId(AlianceParternsEntity alianceParternsId) {
        this.alianceParternsId = alianceParternsId;
    }
    
    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@XmlTransient
    public Collection<ParternsOperatorOffersCouponsEntity> getParternsOperatorOffersCouponsCollection() {
        return parternsOperatorOffersCouponsCollection;
    }

    public void setParternsOperatorOffersCouponsCollection(Collection<ParternsOperatorOffersCouponsEntity> parternsOperatorOffersCouponsCollection) {
        this.parternsOperatorOffersCouponsCollection = parternsOperatorOffersCouponsCollection;
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
        if (!(object instanceof ParternsOperatorOffersEntity)) {
            return false;
        }
        ParternsOperatorOffersEntity other = (ParternsOperatorOffersEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.ParternsOperatorOffers[ id=" + id + " ]";
    }
    
}
