package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.UserAccountDetailsMapper;


public class UserAccountDetailsServices {

	private static Logger logger = LoggerFactory.getLogger(UserAccountDetailsServices.class);
//	UserAccountDetailsDao repository = new UserAccountDetailsDao();
	UserAccountDetailsMapper mapper = new UserAccountDetailsMapper();

}