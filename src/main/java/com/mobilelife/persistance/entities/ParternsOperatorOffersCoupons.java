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
@Table(name = "parterns_operator_offers_coupons", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParternsOperatorOffersCoupons.findAll", query = "SELECT p FROM ParternsOperatorOffersCoupons p")
    , @NamedQuery(name = "ParternsOperatorOffersCoupons.findById", query = "SELECT p FROM ParternsOperatorOffersCoupons p WHERE p.id = :id")
    , @NamedQuery(name = "ParternsOperatorOffersCoupons.findByCreationDatetime", query = "SELECT p FROM ParternsOperatorOffersCoupons p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "ParternsOperatorOffersCoupons.findByLastModifiedDatetime", query = "SELECT p FROM ParternsOperatorOffersCoupons p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "ParternsOperatorOffersCoupons.findByIsActive", query = "SELECT p FROM ParternsOperatorOffersCoupons p WHERE p.isActive = :isActive")
    , @NamedQuery(name = "ParternsOperatorOffersCoupons.findByCouponCode", query = "SELECT p FROM ParternsOperatorOffersCoupons p WHERE p.couponCode = :couponCode")
    , @NamedQuery(name = "ParternsOperatorOffersCoupons.findByCouponName", query = "SELECT p FROM ParternsOperatorOffersCoupons p WHERE p.couponName = :couponName")
    , @NamedQuery(name = "ParternsOperatorOffersCoupons.findByCouponAgeFrom", query = "SELECT p FROM ParternsOperatorOffersCoupons p WHERE p.couponAgeFrom = :couponAgeFrom")
    , @NamedQuery(name = "ParternsOperatorOffersCoupons.findByCouponAgeTo", query = "SELECT p FROM ParternsOperatorOffersCoupons p WHERE p.couponAgeTo = :couponAgeTo")
    , @NamedQuery(name = "ParternsOperatorOffersCoupons.findByCouponType", query = "SELECT p FROM ParternsOperatorOffersCoupons p WHERE p.couponType = :couponType")
    , @NamedQuery(name = "ParternsOperatorOffersCoupons.findByCouponValue", query = "SELECT p FROM ParternsOperatorOffersCoupons p WHERE p.couponValue = :couponValue")
    , @NamedQuery(name = "ParternsOperatorOffersCoupons.findByIsConsumed", query = "SELECT p FROM ParternsOperatorOffersCoupons p WHERE p.isConsumed = :isConsumed")})
public class ParternsOperatorOffersCoupons implements Serializable {

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
    @Column(name = "coupon_code")
    private String couponCode;
    @Column(name = "coupon_name")
    private String couponName;
    @Column(name = "coupon_age_from")
    @Temporal(TemporalType.TIMESTAMP)
    private Date couponAgeFrom;
    @Column(name = "coupon_age_to")
    @Temporal(TemporalType.TIMESTAMP)
    private Date couponAgeTo;
    @Column(name = "coupon_type")
    private String couponType;
    @Column(name = "coupon_value")
    private Integer couponValue;
    @Basic(optional = false)
    @Column(name = "is_consumed")
    private int isConsumed;
    @OneToMany(mappedBy = "parternsOperatorOffersCouponsId")
    private Collection<OrderPlanprimaryOffersCoupons> orderPlanprimaryOffersCouponsCollection;
    @JoinColumn(name = "parterns_operator_offers_id", referencedColumnName = "id")
    @ManyToOne
    private ParternsOperatorOffers parternsOperatorOffersId;
//    @JoinColumn(name = "order_planprimary_id", referencedColumnName = "id")
//    @ManyToOne
//    private OrderPlanprimary orderPlanprimaryId;

    public ParternsOperatorOffersCoupons() {
    }

    public ParternsOperatorOffersCoupons(Integer id) {
        this.id = id;
    }

    public ParternsOperatorOffersCoupons(Integer id, Date creationDatetime, boolean isActive, int isConsumed) {
        this.id = id;
        this.creationDatetime = creationDatetime;
        this.isActive = isActive;
        this.isConsumed = isConsumed;
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

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Date getCouponAgeFrom() {
        return couponAgeFrom;
    }

    public void setCouponAgeFrom(Date couponAgeFrom) {
        this.couponAgeFrom = couponAgeFrom;
    }

    public Date getCouponAgeTo() {
        return couponAgeTo;
    }

    public void setCouponAgeTo(Date couponAgeTo) {
        this.couponAgeTo = couponAgeTo;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    public Integer getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(Integer couponValue) {
        this.couponValue = couponValue;
    }

//    public boolean getIsConsumed() {
//        return isConsumed;
//    }
//
//    public void setIsConsumed(boolean isConsumed) {
//        this.isConsumed = isConsumed;
//    }

    public int getIsConsumed() {
        return isConsumed;
    }

    public void setIsConsumed(int isConsumed) {
        this.isConsumed = isConsumed;
    }

    @XmlTransient
    public Collection<OrderPlanprimaryOffersCoupons> getOrderPlanprimaryOffersCouponsCollection() {
        return orderPlanprimaryOffersCouponsCollection;
    }

    public void setOrderPlanprimaryOffersCouponsCollection(Collection<OrderPlanprimaryOffersCoupons> orderPlanprimaryOffersCouponsCollection) {
        this.orderPlanprimaryOffersCouponsCollection = orderPlanprimaryOffersCouponsCollection;
    }

    public ParternsOperatorOffers getParternsOperatorOffersId() {
        return parternsOperatorOffersId;
    }

    public void setParternsOperatorOffersId(ParternsOperatorOffers parternsOperatorOffersId) {
        this.parternsOperatorOffersId = parternsOperatorOffersId;
    }

//    public OrderPlanprimary getOrderPlanprimaryId() {
//        return orderPlanprimaryId;
//    }
//
//    public void setOrderPlanprimaryId(OrderPlanprimary orderPlanprimaryId) {
//        this.orderPlanprimaryId = orderPlanprimaryId;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParternsOperatorOffersCoupons)) {
            return false;
        }
        ParternsOperatorOffersCoupons other = (ParternsOperatorOffersCoupons) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.ParternsOperatorOffersCoupons[ id=" + id + " ]";
    }
    
}
