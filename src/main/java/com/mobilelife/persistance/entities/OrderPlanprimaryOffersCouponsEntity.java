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
@Table(name = "order_planprimary_offers_coupons", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderPlanprimaryOffersCouponsEntity.findAll", query = "SELECT o FROM OrderPlanprimaryOffersCouponsEntity o")
    , @NamedQuery(name = "OrderPlanprimaryOffersCouponsEntity.findById", query = "SELECT o FROM OrderPlanprimaryOffersCouponsEntity o WHERE o.id = :id")
    , @NamedQuery(name = "OrderPlanprimaryOffersCouponsEntity.findByCreationDatetime", query = "SELECT o FROM OrderPlanprimaryOffersCouponsEntity o WHERE o.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "OrderPlanprimaryOffersCouponsEntity.findByLastModifiedDatetime", query = "SELECT o FROM OrderPlanprimaryOffersCouponsEntity o WHERE o.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "OrderPlanprimaryOffersCouponsEntity.findByIsActive", query = "SELECT o FROM OrderPlanprimaryOffersCouponsEntity o WHERE o.isActive = :isActive")})
public class OrderPlanprimaryOffersCouponsEntity implements Serializable {

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
    @JoinColumn(name = "order_planprimary_id", referencedColumnName = "id")
    @ManyToOne
    private OrderPlanprimaryEntity orderPlanprimaryId;
    @JoinColumn(name = "parterns_operator_offers_coupons_id", referencedColumnName = "id")
    @ManyToOne
    private ParternsOperatorOffersCouponsEntity parternsOperatorOffersCouponsId;

    public OrderPlanprimaryOffersCouponsEntity() {
    }

    public OrderPlanprimaryOffersCouponsEntity(Integer id) {
        this.id = id;
    }

    public OrderPlanprimaryOffersCouponsEntity(Integer id, Date creationDatetime, boolean isActive) {
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

    public OrderPlanprimaryEntity getOrderPlanprimaryId() {
        return orderPlanprimaryId;
    }

    public void setOrderPlanprimaryId(OrderPlanprimaryEntity orderPlanprimaryId) {
        this.orderPlanprimaryId = orderPlanprimaryId;
    }

    public ParternsOperatorOffersCouponsEntity getParternsOperatorOffersCouponsId() {
        return parternsOperatorOffersCouponsId;
    }

    public void setParternsOperatorOffersCouponsId(ParternsOperatorOffersCouponsEntity parternsOperatorOffersCouponsId) {
        this.parternsOperatorOffersCouponsId = parternsOperatorOffersCouponsId;
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
        if (!(object instanceof OrderPlanprimaryOffersCouponsEntity)) {
            return false;
        }
        OrderPlanprimaryOffersCouponsEntity other = (OrderPlanprimaryOffersCouponsEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.OrderPlanprimaryOffersCoupons[ id=" + id + " ]";
    }
    
}
