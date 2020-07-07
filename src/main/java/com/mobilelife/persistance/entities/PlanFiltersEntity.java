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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author deepakupadhyay
 */
@Entity
@Table(name = "plan_filters", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanFiltersEntity.findAll", query = "SELECT p FROM PlanFiltersEntity p")
    , @NamedQuery(name = "PlanFiltersEntity.findById", query = "SELECT p FROM PlanFiltersEntity p WHERE p.id = :id")
    , @NamedQuery(name = "PlanFiltersEntity.findByKeyMajor", query = "SELECT p FROM PlanFiltersEntity p WHERE p.keyMajor = :keyMajor")
    , @NamedQuery(name = "PlanFiltersEntity.findByKeyName", query = "SELECT p FROM PlanFiltersEntity p WHERE p.keyName = :keyName")
    , @NamedQuery(name = "PlanFiltersEntity.findByKeyNameLabel", query = "SELECT p FROM PlanFiltersEntity p WHERE p.keyNameLabel = :keyNameLabel")
    , @NamedQuery(name = "PlanFiltersEntity.findByIconsClass", query = "SELECT p FROM PlanFiltersEntity p WHERE p.iconsClass = :iconsClass")
    , @NamedQuery(name = "PlanFiltersEntity.findBySteps", query = "SELECT p FROM PlanFiltersEntity p WHERE p.steps = :steps")
    , @NamedQuery(name = "PlanFiltersEntity.findByStepValues", query = "SELECT p FROM PlanFiltersEntity p WHERE p.stepValues = :stepValues")
    , @NamedQuery(name = "PlanFiltersEntity.findByKeyValueMin", query = "SELECT p FROM PlanFiltersEntity p WHERE p.keyValueMin = :keyValueMin")
    , @NamedQuery(name = "PlanFiltersEntity.findByKeyUnitsMin", query = "SELECT p FROM PlanFiltersEntity p WHERE p.keyUnitsMin = :keyUnitsMin")
    , @NamedQuery(name = "PlanFiltersEntity.findByKeyValueMax", query = "SELECT p FROM PlanFiltersEntity p WHERE p.keyValueMax = :keyValueMax")
    , @NamedQuery(name = "PlanFiltersEntity.findByKeyUnitsMax", query = "SELECT p FROM PlanFiltersEntity p WHERE p.keyUnitsMax = :keyUnitsMax")
    , @NamedQuery(name = "PlanFiltersEntity.findByReturnType", query = "SELECT p FROM PlanFiltersEntity p WHERE p.returnType = :returnType")
    , @NamedQuery(name = "PlanFiltersEntity.findByLabel", query = "SELECT p FROM PlanFiltersEntity p WHERE p.label = :label")
    , @NamedQuery(name = "PlanFiltersEntity.findByCountry", query = "SELECT p FROM PlanFiltersEntity p WHERE p.country = :country")
    , @NamedQuery(name = "PlanFiltersEntity.findByLanguage", query = "SELECT p FROM PlanFiltersEntity p WHERE p.language = :language")
    , @NamedQuery(name = "PlanFiltersEntity.findByOrderno", query = "SELECT p FROM PlanFiltersEntity p WHERE p.orderno = :orderno")})
public class PlanFiltersEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "key_major")
    private String keyMajor;
    @Column(name = "key_name")
    private String keyName;
    @Column(name = "key_name_label")
    private String keyNameLabel;
    @Column(name = "icons_class")
    private String iconsClass;
    @Column(name = "steps")
    private Integer steps;
    @Column(name = "step_values")
    private Integer stepValues;
    @Column(name = "key_value_min")
    private String keyValueMin;
    @Column(name = "key_units_min")
    private String keyUnitsMin;
    @Column(name = "key_value_max")
    private String keyValueMax;
    @Column(name = "key_units_max")
    private String keyUnitsMax;
    @Column(name = "returnType")
    private String returnType;
    @Column(name = "label")
    private String label;
    @Column(name = "country")
    private String country;
    @Column(name = "language")
    private String language;
    @Column(name = "orderno")
    private Integer orderno;
    @JoinColumn(name = "plan_type", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PlansPlantypeEntity planType;
    @Column(name = "label2")
    private String label2;
    @Basic(optional = false)
    @Column(name = "concatinate")
    private boolean concatinate;
    @Basic(optional = false)
    @Column(name = "isAddon")
    private boolean isAddon;


    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;

    @Column(name = "key_name_label2")
    private String keyNameLabel2;
    
    @Column(name = "label3")
    private String label3;
    
    public PlanFiltersEntity() {
    }

    public PlanFiltersEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyMajor() {
        return keyMajor;
    }

    public void setKeyMajor(String keyMajor) {
        this.keyMajor = keyMajor;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyNameLabel() {
        return keyNameLabel;
    }

    public void setKeyNameLabel(String keyNameLabel) {
        this.keyNameLabel = keyNameLabel;
    }

    public String getIconsClass() {
        return iconsClass;
    }

    public void setIconsClass(String iconsClass) {
        this.iconsClass = iconsClass;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public Integer getStepValues() {
        return stepValues;
    }

    public void setStepValues(Integer stepValues) {
        this.stepValues = stepValues;
    }

    public String getKeyValueMin() {
        return keyValueMin;
    }

    public void setKeyValueMin(String keyValueMin) {
        this.keyValueMin = keyValueMin;
    }

    public String getKeyUnitsMin() {
        return keyUnitsMin;
    }

    public void setKeyUnitsMin(String keyUnitsMin) {
        this.keyUnitsMin = keyUnitsMin;
    }

    public String getKeyValueMax() {
        return keyValueMax;
    }

    public void setKeyValueMax(String keyValueMax) {
        this.keyValueMax = keyValueMax;
    }

    public String getKeyUnitsMax() {
        return keyUnitsMax;
    }

    public void setKeyUnitsMax(String keyUnitsMax) {
        this.keyUnitsMax = keyUnitsMax;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    public PlansPlantypeEntity getPlanType() {
        return planType;
    }

    public void setPlanType(PlansPlantypeEntity planType) {
        this.planType = planType;
    }
    
    public String getLabel2() {
		return label2;
	}

	public void setLabel2(String label2) {
		this.label2 = label2;
	}

	public boolean isConcatinate() {
		return concatinate;
	}

	public void setConcatinate(boolean concatinate) {
		this.concatinate = concatinate;
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
	
	public boolean isAddon() {
		return isAddon;
	}

	public void setAddon(boolean isAddon) {
		this.isAddon = isAddon;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

	
    public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanFiltersEntity)) {
            return false;
        }
        PlanFiltersEntity other = (PlanFiltersEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.PlanFilters[ id=" + id + " ]";
    }
    
}
