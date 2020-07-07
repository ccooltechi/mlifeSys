package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.AuthUserGroupsMapper;


public class AuthUserGroupsServices {

	private static Logger logger = LoggerFactory.getLogger(AuthUserGroupsServices.class);
//	AuthUserGroupsDao repository = new AuthUserGroupsDao();
	AuthUserGroupsMapper mapper = new AuthUserGroupsMapper();

}