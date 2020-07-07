package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.DeviceFeedbackMapper;


public class DeviceFeedbackServices {

	private static Logger logger = LoggerFactory.getLogger(DeviceFeedbackServices.class);
//	DeviceFeedbackDao repository = new DeviceFeedbackDao();
	DeviceFeedbackMapper mapper = new DeviceFeedbackMapper();

}