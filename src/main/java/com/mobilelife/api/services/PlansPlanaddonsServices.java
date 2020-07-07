package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.PlansPlanaddonsMapper;
import com.mobilelife.persistance.dao.PlansPlanaddonsDao;


public class PlansPlanaddonsServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanaddonsServices.class);
	PlansPlanaddonsDao repository = new PlansPlanaddonsDao();
	PlansPlanaddonsMapper mapper = new PlansPlanaddonsMapper();

}