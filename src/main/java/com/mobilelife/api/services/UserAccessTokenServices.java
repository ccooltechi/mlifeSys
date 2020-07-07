package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.UserAccessTokenMapper;


public class UserAccessTokenServices {

	private static Logger logger = LoggerFactory.getLogger(UserAccessTokenServices.class);
//	UserAccessTokenDao repository = new UserAccessTokenDao();
	UserAccessTokenMapper mapper = new UserAccessTokenMapper();

}