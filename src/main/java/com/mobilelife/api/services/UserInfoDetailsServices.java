package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.UserInfoDetailsMapper;
import com.mobilelife.persistance.dao.UserInfoDetailsDao;

public class UserInfoDetailsServices {

	private static Logger logger = LoggerFactory.getLogger(UserInfoDetailsServices.class);
	UserInfoDetailsDao repository = new UserInfoDetailsDao();
	UserInfoDetailsMapper mapper = new UserInfoDetailsMapper();

}