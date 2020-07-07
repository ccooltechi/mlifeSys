/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.persistance.entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pods
 */
@Entity
@Table(name = "countries")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CountriesEntity.findAll", query = "SELECT c FROM CountriesEntity c")
    , @NamedQuery(name = "CountriesEntity.findById", query = "SELECT c FROM CountriesEntity c WHERE c.id = :id")
    , @NamedQuery(name = "CountriesEntity.findByCountryCode", query = "SELECT c FROM CountriesEntity c WHERE c.countryCode = :countryCode")
    , @NamedQuery(name = "CountriesEntity.findByCountryName", query = "SELECT c FROM CountriesEntity c WHERE c.countryName = :countryName")})
public class CountriesEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "country_name")
    private String countryName;
    @OneToMany(mappedBy = "countryId")
    private Collection<PlansPlanbucketEntity> plansPlanbucketCollection;

    public CountriesEntity() {
    }

    public CountriesEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @XmlTransient
    public Collection<PlansPlanbucketEntity> getPlansPlanbucketCollection() {
        return plansPlanbucketCollection;
    }

    public void setPlansPlanbucketCollection(Collection<PlansPlanbucketEntity> plansPlanbucketCollection) {
        this.plansPlanbucketCollection = plansPlanbucketCollection;
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
        if (!(object instanceof CountriesEntity)) {
            return false;
        }
        CountriesEntity other = (CountriesEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.Countries[ id=" + id + " ]";
    }
    
}
