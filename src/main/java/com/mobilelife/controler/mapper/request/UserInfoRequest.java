package com.mobilelife.controler.mapper.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user_info")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserInfoRequest {

    @XmlAttribute
	private String location;
    @XmlAttribute
	private String device;
    @XmlAttribute
	private String browserType;
    @XmlAttribute
	private String ipaddress;
    @XmlAttribute
	private String ifmobile;
    @XmlAttribute
	private String mobileno;
    @XmlAttribute
	private String mobileinfo;
    @XmlAttribute
	private String longitude;
    @XmlAttribute
	private String latitude;
    @XmlAttribute
	private String ssoUserID;
    @XmlAttribute
	private String userEmail;
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the device
	 */
	public String getDevice() {
		return device;
	}
	/**
	 * @param device the device to set
	 */
	public void setDevice(String device) {
		this.device = device;
	}
	/**
	 * @return the browserType
	 */
	public String getBrowserType() {
		return browserType;
	}
	/**
	 * @param browserType the browserType to set
	 */
	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}
	/**
	 * @return the ipaddress
	 */
	public String getIpaddress() {
		return ipaddress;
	}
	/**
	 * @param ipaddress the ipaddress to set
	 */
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	/**
	 * @return the ifmobile
	 */
	public String getIfmobile() {
		return ifmobile;
	}
	/**
	 * @param ifmobile the ifmobile to set
	 */
	public void setIfmobile(String ifmobile) {
		this.ifmobile = ifmobile;
	}
	/**
	 * @return the mobileno
	 */
	public String getMobileno() {
		return mobileno;
	}
	/**
	 * @param mobileno the mobileno to set
	 */
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	/**
	 * @return the mobileinfo
	 */
	public String getMobileinfo() {
		return mobileinfo;
	}
	/**
	 * @param mobileinfo the mobileinfo to set
	 */
	public void setMobileinfo(String mobileinfo) {
		this.mobileinfo = mobileinfo;
	}
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the ssoUserID
	 */
	public String getSsoUserID() {
		return ssoUserID;
	}
	/**
	 * @param ssoUserID the ssoUserID to set
	 */
	public void setSsoUserID(String ssoUserID) {
		this.ssoUserID = ssoUserID;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}
