package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.PlansMisFeaturesMapper;
import com.mobilelife.persistance.dao.PlansMisFeaturesDao;


public class PlansMisFeaturesServices {

	private static Logger logger = LoggerFactory.getLogger(PlansMisFeaturesServices.class);
	PlansMisFeaturesDao repository = new PlansMisFeaturesDao();
	PlansMisFeaturesMapper mapper = new PlansMisFeaturesMapper();

}