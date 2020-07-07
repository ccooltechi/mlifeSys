package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.PlansPlanOperatorTncMapper;
import com.mobilelife.persistance.dao.PlansPlanOperatorTncDao;


public class PlansPlanOperatorTncServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanOperatorTncServices.class);
	PlansPlanOperatorTncDao repository = new PlansPlanOperatorTncDao();
	PlansPlanOperatorTncMapper mapper = new PlansPlanOperatorTncMapper();

}