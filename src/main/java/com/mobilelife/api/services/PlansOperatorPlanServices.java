package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.PlansOperatorPlanMapper;
import com.mobilelife.persistance.dao.PlansOperatorPlanDao;


public class PlansOperatorPlanServices {

	private static Logger logger = LoggerFactory.getLogger(PlansOperatorPlanServices.class);
	PlansOperatorPlanDao repository = new PlansOperatorPlanDao();
	PlansOperatorPlanMapper mapper = new PlansOperatorPlanMapper();

}