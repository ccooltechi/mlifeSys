package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.AuthPermissionMapper;


public class AuthPermissionServices {

	private static Logger logger = LoggerFactory.getLogger(AuthPermissionServices.class);
//	AuthPermissionDao repository = new AuthPermissionDao();
	AuthPermissionMapper mapper = new AuthPermissionMapper();

}