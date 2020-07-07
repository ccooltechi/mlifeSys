/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.controler.mapper.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;



@ApiModel("request")
public class PlansOperator implements Serializable {

    private static final long serialVersionUID = 1L;
    @XmlAttribute
    private Integer id;
    @XmlAttribute
    private String operatorName;
    @XmlAttribute
    private boolean isActive;
    @XmlAttribute
    private boolean supportRetail;
    @XmlAttribute
    private boolean supportOnline;
    @XmlAttribute
	private String logo;

    public PlansOperator() {
    }

    public PlansOperator(Integer id) {
        this.id = id;
    }

    public PlansOperator(Integer id, String operatorName, boolean isActive) {
        this.id = id;
        this.operatorName = operatorName;
        this.isActive = isActive;
    }

    @ApiModelProperty(value = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ApiModelProperty(value = "operatorName")
    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    @ApiModelProperty(value = "isActive")
    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    
    /**
	 * @return the logo
	 */
    @ApiModelProperty(value = "logo")
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	
    @ApiModelProperty(value = "supportRetail")
	public boolean isSupportRetail() {
		return supportRetail;
	}

	public void setSupportRetail(boolean supportRetail) {
		this.supportRetail = supportRetail;
	}

    @ApiModelProperty(value = "supportOnline")
	public boolean isSupportOnline() {
		return supportOnline;
	}

	public void setSupportOnline(boolean supportOnline) {
		this.supportOnline = supportOnline;
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
        if (!(object instanceof PlansOperator)) {
            return false;
        }
        PlansOperator other = (PlansOperator) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mobilelife.persistance.entities.PlansOperator[ id=" + id + " ]";
    }
    
}
