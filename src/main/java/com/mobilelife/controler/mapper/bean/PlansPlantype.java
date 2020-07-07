/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilelife.controler.mapper.bean;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;


@ApiModel("request")
public class PlansPlantype implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private boolean isActive;
    private String planType;
    private String planLabel;

    public PlansPlantype() {
    }

    @ApiModelProperty(value = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    @ApiModelProperty(value = "isActive")
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

    @ApiModelProperty(value = "planType")
	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

    @ApiModelProperty(value = "planLabel")
	public String getPlanLabel() {
		return planLabel;
	}

	public void setPlanLabel(String planLabel) {
		this.planLabel = planLabel;
	}
}
