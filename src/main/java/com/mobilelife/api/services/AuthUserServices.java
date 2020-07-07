package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.AuthUserMapper;


public class AuthUserServices {

	private static Logger logger = LoggerFactory.getLogger(AuthUserServices.class);
//	AuthUserDao repository = new AuthUserDao();
	AuthUserMapper mapper = new AuthUserMapper();

}