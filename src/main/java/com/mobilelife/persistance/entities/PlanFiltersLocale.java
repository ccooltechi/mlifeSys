/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.persistance.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author deepakupadhyay
 */
@Entity
@Table(name = "plan_filters_locale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanFiltersLocale.findAll", query = "SELECT p FROM PlanFiltersLocale p")
    , @NamedQuery(name = "PlanFiltersLocale.findById", query = "SELECT p FROM PlanFiltersLocale p WHERE p.id = :id")
    , @NamedQuery(name = "PlanFiltersLocale.findByFilterId", query = "SELECT p FROM PlanFiltersLocale p WHERE p.filterId = :filterId")
    , @NamedQuery(name = "PlanFiltersLocale.findByLocale", query = "SELECT p FROM PlanFiltersLocale p WHERE p.locale = :locale")
    , @NamedQuery(name = "PlanFiltersLocale.findByKeyNameLabel", query = "SELECT p FROM PlanFiltersLocale p WHERE p.keyNameLabel = :keyNameLabel")
    , @NamedQuery(name = "PlanFiltersLocale.findByLabel", query = "SELECT p FROM PlanFiltersLocale p WHERE p.label = :label")
    , @NamedQuery(name = "PlanFiltersLocale.findByLabel2", query = "SELECT p FROM PlanFiltersLocale p WHERE p.label2 = :label2")
    , @NamedQuery(name = "PlanFiltersLocale.findByIsActive", query = "SELECT p FROM PlanFiltersLocale p WHERE p.isActive = :isActive")
    , @NamedQuery(name = "PlanFiltersLocale.findByKeyNameLabel2", query = "SELECT p FROM PlanFiltersLocale p WHERE p.keyNameLabel2 = :keyNameLabel2")
    , @NamedQuery(name = "PlanFiltersLocale.findByLabel3", query = "SELECT p FROM PlanFiltersLocale p WHERE p.label3 = :label3")})
public class PlanFiltersLocale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "filter_id")
    private int filterId;
    @Column(name = "locale")
    private String locale;
    @Column(name = "key_name_label")
    private String keyNameLabel;
    @Column(name = "label")
    private String label;
    @Column(name = "label2")
    private String label2;
    @Column(name = "isActive")
    private Boolean isActive;
    @Column(name = "key_name_label2")
    private String keyNameLabel2;
    @Column(name = "label3")
    private String label3;

    public PlanFiltersLocale() {
    }

    public PlanFiltersLocale(Integer id) {
        this.id = id;
    }

    public PlanFiltersLocale(Integer id, int filterId) {
        this.id = id;
        this.filterId = filterId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFilterId() {
        return filterId;
    }

    public void setFilterId(int filterId) {
        this.filterId = filterId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getKeyNameLabel() {
        return keyNameLabel;
    }

    public void setKeyNameLabel(String keyNameLabel) {
        this.keyNameLabel = keyNameLabel;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel2() {
        return label2;
    }

    public void setLabel2(String label2) {
        this.label2 = label2;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getKeyNameLabel2() {
        return keyNameLabel2;
    }

    public void setKeyNameLabel2(String keyNameLabel2) {
        this.keyNameLabel2 = keyNameLabel2;
    }

    public String getLabel3() {
        return label3;
    }

    public void setLabel3(String label3) {
        this.label3 = label3;
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
        if (!(object instanceof PlanFiltersLocale)) {
            return false;
        }
        PlanFiltersLocale other = (PlanFiltersLocale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlanFiltersLocale[ id=" + id + " ]";
    }
    
}
