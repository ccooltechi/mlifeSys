package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.AuthGroupPermissionsMapper;


public class AuthGroupPermissionsServices {

	private static Logger logger = LoggerFactory.getLogger(AuthGroupPermissionsServices.class);
//	AuthGroupPermissionsDao repository = new AuthGroupPermissionsDao();
	AuthGroupPermissionsMapper mapper = new AuthGroupPermissionsMapper();

}