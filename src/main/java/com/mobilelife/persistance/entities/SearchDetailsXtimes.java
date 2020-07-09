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
 * @author deepakupadhyay
 */
@Entity
@Table(name = "search_details_xtimes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SearchDetailsXtimes.findAll", query = "SELECT s FROM SearchDetailsXtimes s")
    , @NamedQuery(name = "SearchDetailsXtimes.findById", query = "SELECT s FROM SearchDetailsXtimes s WHERE s.id = :id")
    , @NamedQuery(name = "SearchDetailsXtimes.findByPlanName", query = "SELECT s FROM SearchDetailsXtimes s WHERE s.planName = :planName")
    , @NamedQuery(name = "SearchDetailsXtimes.findByGeneData", query = "SELECT s FROM SearchDetailsXtimes s WHERE s.geneData = :geneData")
    , @NamedQuery(name = "SearchDetailsXtimes.findByGeneFlexi", query = "SELECT s FROM SearchDetailsXtimes s WHERE s.geneFlexi = :geneFlexi")
    , @NamedQuery(name = "SearchDetailsXtimes.findByGeneNational", query = "SELECT s FROM SearchDetailsXtimes s WHERE s.geneNational = :geneNational")
    , @NamedQuery(name = "SearchDetailsXtimes.findByGeneInterNational", query = "SELECT s FROM SearchDetailsXtimes s WHERE s.geneInterNational = :geneInterNational")
    , @NamedQuery(name = "SearchDetailsXtimes.findByGeneBudget", query = "SELECT s FROM SearchDetailsXtimes s WHERE s.geneBudget = :geneBudget")
    , @NamedQuery(name = "SearchDetailsXtimes.findByGeneSavingFlat", query = "SELECT s FROM SearchDetailsXtimes s WHERE s.geneSavingFlat = :geneSavingFlat")
    , @NamedQuery(name = "SearchDetailsXtimes.findByCreationDatetime", query = "SELECT s FROM SearchDetailsXtimes s WHERE s.creationDatetime = :creationDatetime")
    , @NamedQuery(name = "SearchDetailsXtimes.findByLastModifiedDatetime", query = "SELECT s FROM SearchDetailsXtimes s WHERE s.lastModifiedDatetime = :lastModifiedDatetime")
    , @NamedQuery(name = "SearchDetailsXtimes.findByIsActive", query = "SELECT s FROM SearchDetailsXtimes s WHERE s.isActive = :isActive")
    , @NamedQuery(name = "SearchDetailsXtimes.findByToken", query = "SELECT s FROM SearchDetailsXtimes s WHERE s.token = :token")})
public class SearchDetailsXtimes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "plan_name")
    private String planName;
    @Basic(optional = false)
    @Column(name = "geneData")
    private Double geneData;
    @Basic(optional = false)
    @Column(name = "geneFlexi")
    private Double geneFlexi;
    @Basic(optional = false)
    @Column(name = "geneNational")
    private Double geneNational;
    @Basic(optional = false)
    @Column(name = "geneInterNational")
    private Double geneInterNational;
    @Basic(optional = false)
    @Column(name = "geneBudget")
    private Double geneBudget;
    @Basic(optional = false)
    @Column(name = "geneSavingFlat")
    private Double geneSavingFlat;
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
    @Column(name = "token")
    private String token;
    @JoinColumn(name = "search_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SearchDetailsChild searchId;

    public SearchDetailsXtimes() {
    }

    public SearchDetailsXtimes(Integer id) {
        this.id = id;
    }

    public SearchDetailsXtimes(Integer id, Double geneData, Double geneFlexi, Double geneNational, Double geneInterNational, Double geneBudget, Double geneSavingFlat, Date creationDatetime, boolean isActive) {
        this.id = id;
        this.geneData = geneData;
        this.geneFlexi = geneFlexi;
        this.geneNational = geneNational;
        this.geneInterNational = geneInterNational;
        this.geneBudget = geneBudget;
        this.geneSavingFlat = geneSavingFlat;
        this.creationDatetime = creationDatetime;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Double getGeneData() {
        return geneData;
    }

    public void setGeneData(Double geneData) {
        this.geneData = geneData;
    }

    public Double getGeneFlexi() {
        return geneFlexi;
    }

    public void setGeneFlexi(Double geneFlexi) {
        this.geneFlexi = geneFlexi;
    }

    public Double getGeneNational() {
        return geneNational;
    }

    public void setGeneNational(Double geneNational) {
        this.geneNational = geneNational;
    }

    public Double getGeneInterNational() {
        return geneInterNational;
    }

    public void setGeneInterNational(Double geneInterNational) {
        this.geneInterNational = geneInterNational;
    }

    public Double getGeneBudget() {
        return geneBudget;
    }

    public void setGeneBudget(Double geneBudget) {
        this.geneBudget = geneBudget;
    }

    public Double getGeneSavingFlat() {
        return geneSavingFlat;
    }

    public void setGeneSavingFlat(Double geneSavingFlat) {
        this.geneSavingFlat = geneSavingFlat;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SearchDetailsChild getSearchId() {
        return searchId;
    }

    public void setSearchId(SearchDetailsChild searchId) {
        this.searchId = searchId;
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
        if (!(object instanceof SearchDetailsXtimes)) {
            return false;
        }
        SearchDetailsXtimes other = (SearchDetailsXtimes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.SearchDetailsXtimes[ id=" + id + " ]";
    }
    
}
