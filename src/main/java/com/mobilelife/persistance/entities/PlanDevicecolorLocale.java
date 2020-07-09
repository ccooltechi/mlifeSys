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
@Table(name = "plan_devicecolor_locale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanDevicecolorLocale.findAll", query = "SELECT p FROM PlanDevicecolorLocale p")
    , @NamedQuery(name = "PlanDevicecolorLocale.findById", query = "SELECT p FROM PlanDevicecolorLocale p WHERE p.id = :id")
    , @NamedQuery(name = "PlanDevicecolorLocale.findByLocale", query = "SELECT p FROM PlanDevicecolorLocale p WHERE p.locale = :locale")
    , @NamedQuery(name = "PlanDevicecolorLocale.findByKeyPair", query = "SELECT p FROM PlanDevicecolorLocale p WHERE p.keyPair = :keyPair")
    , @NamedQuery(name = "PlanDevicecolorLocale.findByValuePair", query = "SELECT p FROM PlanDevicecolorLocale p WHERE p.valuePair = :valuePair")
    , @NamedQuery(name = "PlanDevicecolorLocale.findByCreationDatetime", query = "SELECT p FROM PlanDevicecolorLocale p WHERE p.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "PlanDevicecolorLocale.findByLastModifiedDatetime", query = "SELECT p FROM PlanDevicecolorLocale p WHERE p.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "PlanDevicecolorLocale.findByIsActive", query = "SELECT p FROM PlanDevicecolorLocale p WHERE p.isActive = :isActive")})
public class PlanDevicecolorLocale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "locale")
    private String locale;
    @Column(name = "key_pair")
    private String keyPair;
    @Column(name = "value_pair")
    private String valuePair;
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

    public PlanDevicecolorLocale() {
    }

    public PlanDevicecolorLocale(Integer id) {
        this.id = id;
    }

    public PlanDevicecolorLocale(Integer id, Date creationDatetime, boolean isActive) {
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

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getKeyPair() {
        return keyPair;
    }

    public void setKeyPair(String keyPair) {
        this.keyPair = keyPair;
    }

    public String getValuePair() {
        return valuePair;
    }

    public void setValuePair(String valuePair) {
        this.valuePair = valuePair;
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
        if (!(object instanceof PlanDevicecolorLocale)) {
            return false;
        }
        PlanDevicecolorLocale other = (PlanDevicecolorLocale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlanDevicecolorLocale[ id=" + id + " ]";
    }
    
}
