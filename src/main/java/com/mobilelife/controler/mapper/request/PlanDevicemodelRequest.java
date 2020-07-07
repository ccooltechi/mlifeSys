package com.mobilelife.controler.mapper.request;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.mobilelife.controler.mapper.bean.PlanDevicecolor;
import com.mobilelife.controler.mapper.bean.PlanDevicemodel;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel("plantypes")
public class PlanDevicemodelRequest {
    @XmlAttribute
	private String authtoken ;
    @XmlElement
	private PlanDevicemodel request;
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
	public PlanDevicemodel getRequest() {
		return request;
	}
	public void setRequest(PlanDevicemodel request) {
		this.request = request;
	}
       
}
