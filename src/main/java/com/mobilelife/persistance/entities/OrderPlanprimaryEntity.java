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
@Table(name = "order_planprimary", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderPlanprimaryEntity.findAll", query = "SELECT o FROM OrderPlanprimaryEntity o")
    , @NamedQuery(name = "OrderPlanprimaryEntity.findById", query = "SELECT o FROM OrderPlanprimaryEntity o WHERE o.id = :id")
    , @NamedQuery(name = "OrderPlanprimaryEntity.findByOrderId", query = "SELECT o FROM OrderPlanprimaryEntity o WHERE o.orderId = :orderId")
    , @NamedQuery(name = "OrderPlanprimaryEntity.findByCreationDatetime", query = "SELECT o FROM OrderPlanprimaryEntity o WHERE o.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "OrderPlanprimaryEntity.findByLastModifiedDatetime", query = "SELECT o FROM OrderPlanprimaryEntity o WHERE o.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "OrderPlanprimaryEntity.findByIsActive", query = "SELECT o FROM OrderPlanprimaryEntity o WHERE o.isActive = :isActive")
    , @NamedQuery(name = "OrderPlanprimaryEntity.findByPlanReffId", query = "SELECT o FROM OrderPlanprimaryEntity o WHERE o.planReffId = :planReffId")
    , @NamedQuery(name = "OrderPlanprimaryEntity.findByOrderValue", query = "SELECT o FROM OrderPlanprimaryEntity o WHERE o.orderValue = :orderValue")
    , @NamedQuery(name = "OrderPlanprimaryEntity.findByOrderValidityDate", query = "SELECT o FROM OrderPlanprimaryEntity o WHERE o.orderValidityDate = :orderValidityDate")
    , @NamedQuery(name = "OrderPlanprimaryEntity.findByUserId", query = "SELECT o FROM OrderPlanprimaryEntity o WHERE o.userId = :userId")
    , @NamedQuery(name = "OrderPlanprimaryEntity.findByOrderGeneratedFrom", query = "SELECT o FROM OrderPlanprimaryEntity o WHERE o.orderGeneratedFrom = :orderGeneratedFrom")
    , @NamedQuery(name = "OrderPlanprimaryEntity.findByOrderCouponCode", query = "SELECT o FROM OrderPlanprimaryEntity o WHERE o.orderCouponCode = :orderCouponCode")})
public class OrderPlanprimaryEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "order_id")
    private String orderId;
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
    @Column(name = "plan_reff_id")
    private String planReffId;
    @Column(name = "order_value")
    private String orderValue;
    @Column(name = "order_validity_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderValidityDate;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "order_generated_from")
    private String orderGeneratedFrom;
    @Column(name = "order_coupon_code")
    private String orderCouponCode;
    @Column(name = "addons")
    private String addons;
    @OneToMany(mappedBy = "orderPlanprimaryId")
    private Collection<OrderOffersMapEntity> orderOffersMapCollection;
    @OneToMany(mappedBy = "orderPlanprimaryId")
    private Collection<OrderPlanprimaryOffersCouponsEntity> orderPlanprimaryOffersCouponsCollection;
//    @OneToMany(mappedBy = "orderPlanprimaryId")
//    private Collection<ParternsOperatorOffersCoupons> parternsOperatorOffersCouponsCollection;

    public OrderPlanprimaryEntity() {
    }

    public OrderPlanprimaryEntity(Integer id) {
        this.id = id;
    }

    public OrderPlanprimaryEntity(Integer id, Date creationDatetime, boolean isActive) {
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getPlanReffId() {
        return planReffId;
    }

    public void setPlanReffId(String planReffId) {
        this.planReffId = planReffId;
    }

    public String getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(String orderValue) {
        this.orderValue = orderValue;
    }

    public Date getOrderValidityDate() {
        return orderValidityDate;
    }

    public void setOrderValidityDate(Date orderValidityDate) {
        this.orderValidityDate = orderValidityDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderGeneratedFrom() {
        return orderGeneratedFrom;
    }

    public void setOrderGeneratedFrom(String orderGeneratedFrom) {
        this.orderGeneratedFrom = orderGeneratedFrom;
    }

    public String getOrderCouponCode() {
        return orderCouponCode;
    }

    public void setOrderCouponCode(String orderCouponCode) {
        this.orderCouponCode = orderCouponCode;
    }
    
    public String getAddons() {
		return addons;
	}

	public void setAddons(String addons) {
		this.addons = addons;
	}

    public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@XmlTransient
    public Collection<OrderOffersMapEntity> getOrderOffersMapCollection() {
        return orderOffersMapCollection;
    }

    public void setOrderOffersMapCollection(Collection<OrderOffersMapEntity> orderOffersMapCollection) {
        this.orderOffersMapCollection = orderOffersMapCollection;
    }

    @XmlTransient
    public Collection<OrderPlanprimaryOffersCouponsEntity> getOrderPlanprimaryOffersCouponsCollection() {
        return orderPlanprimaryOffersCouponsCollection;
    }

    public void setOrderPlanprimaryOffersCouponsCollection(Collection<OrderPlanprimaryOffersCouponsEntity> orderPlanprimaryOffersCouponsCollection) {
        this.orderPlanprimaryOffersCouponsCollection = orderPlanprimaryOffersCouponsCollection;
    }

    
//    @XmlTransient
//    public Collection<ParternsOperatorOffersCoupons> getParternsOperatorOffersCouponsCollection() {
//        return parternsOperatorOffersCouponsCollection;
//    }
//
//    public void setParternsOperatorOffersCouponsCollection(Collection<ParternsOperatorOffersCoupons> parternsOperatorOffersCouponsCollection) {
//        this.parternsOperatorOffersCouponsCollection = parternsOperatorOffersCouponsCollection;
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
        if (!(object instanceof OrderPlanprimaryEntity)) {
            return false;
        }
        OrderPlanprimaryEntity other = (OrderPlanprimaryEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.OrderPlanprimary[ id=" + id + " ]";
    }
    
}
