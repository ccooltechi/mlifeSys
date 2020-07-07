package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.AuthGroupMapper;


public class AuthGroupServices {

	private static Logger logger = LoggerFactory.getLogger(AuthGroupServices.class);
//	AuthGroupDao repository = new AuthGroupDao();
	AuthGroupMapper mapper = new AuthGroupMapper();

}