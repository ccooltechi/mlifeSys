/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.controler.mapper.bean;
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

public class PlanFiltersBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String keyMajor;
    private String keyName;
    private String keyNameLabel;
    private String iconsClass;
    private Integer steps;
    private Integer stepValues;
    private String keyValueMin;
    private String keyUnitsMin;
    private String keyValueMax;
    private String keyUnitsMax;
    private String returnType;
    private String label;
    private String country;
    private String language;
    private Integer orderno;
    private String label2;
    private boolean concatinate;
    private boolean isAddon;
    private boolean isActive;
    private Integer planType;

    
    private String keyNameLabel2;
    
    private String label3;
    
    public PlanFiltersBean() {
    }

    public PlanFiltersBean(Integer id) {
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getPlanType() {
		return planType;
	}

	public void setPlanType(Integer planType) {
		this.planType = planType;
	}
	
}
