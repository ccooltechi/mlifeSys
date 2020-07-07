package com.mobilelife.controler.mapper.request;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.mobilelife.controler.mapper.bean.PlansPlandata;
import com.mobilelife.controler.mapper.bean.PlansPlanfee;
import com.mobilelife.controler.mapper.bean.PlansPlanprimary;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel("filters")
public class PlansPlandataRequest {
    @XmlAttribute
	private String authtoken ;
    @XmlAttribute
	private String userID;
    @XmlAttribute
	private String userEmail;

    @XmlElement
	private PlansPlandata request;
    
    @ApiModelProperty(value = "authtoken")
	public String getAuthtoken() {
		return authtoken;
	}
	public void setAuthtoken(String authtoken) {
		this.authtoken = authtoken;
	}

	@ApiModelProperty(value = "request")
	public PlansPlandata getRequest() {
		return request;
	}
	public void setRequest(PlansPlandata request) {
		this.request = request;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
       
}
