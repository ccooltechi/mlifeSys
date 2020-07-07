package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.PlansDevicePlanMapper;
import com.mobilelife.persistance.dao.PlansDevicePlanDao;


public class PlansDevicePlanServices {

	private static Logger logger = LoggerFactory.getLogger(PlansDevicePlanServices.class);
	PlansDevicePlanDao repository = new PlansDevicePlanDao();
	PlansDevicePlanMapper mapper = new PlansDevicePlanMapper();

}