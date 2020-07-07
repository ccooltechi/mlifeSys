package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.UserInfoMapper;
import com.mobilelife.persistance.dao.UserInfoDao;

public class UserInfoServices {

	private static Logger logger = LoggerFactory.getLogger(UserInfoServices.class);
	UserInfoDao repository = new UserInfoDao();
	UserInfoMapper mapper = new UserInfoMapper();

}