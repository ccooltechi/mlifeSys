package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.UserAccessMapper;


public class UserAccessServices {

	private static Logger logger = LoggerFactory.getLogger(UserAccessServices.class);
//	UserAccessDao repository = new UserAccessDao();
	UserAccessMapper mapper = new UserAccessMapper();

}