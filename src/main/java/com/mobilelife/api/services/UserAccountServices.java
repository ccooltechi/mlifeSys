package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.UserAccountMapper;

public class UserAccountServices {

	private static Logger logger = LoggerFactory.getLogger(UserAccountServices.class);
//	UserAccountDao repository = new UserAccountDao();
	UserAccountMapper mapper = new UserAccountMapper();

}