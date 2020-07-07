package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.PlansFeedbackMapper;


public class PlansFeedbackServices {

	private static Logger logger = LoggerFactory.getLogger(PlansFeedbackServices.class);
//	PlansFeedbackDao repository = new PlansFeedbackDao();
	PlansFeedbackMapper mapper = new PlansFeedbackMapper();

}