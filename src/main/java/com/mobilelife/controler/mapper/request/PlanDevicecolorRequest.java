package com.mobilelife.controler.mapper.request;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.mobilelife.controler.mapper.bean.PlanDevicecolor;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel("plantypes")
public class PlanDevicecolorRequest {
    @XmlAttribute
	private String authtoken ;
    @XmlElement
	private PlanDevicecolor request;
    @XmlAttribute
	private String userID;
    @XmlAttribute
	private String userEmail;

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
	@ApiModelProperty(value = "authtoken")
	public String getAuthtoken() {
		return authtoken;
	}
	public void setAuthtoken(String authtoken) {
		this.authtoken = authtoken;
	}

	@ApiModelProperty(value = "request")
	public PlanDevicecolor getRequest() {
		return request;
	}
	public void setRequest(PlanDevicecolor request) {
		this.request = request;
	}
       
}
