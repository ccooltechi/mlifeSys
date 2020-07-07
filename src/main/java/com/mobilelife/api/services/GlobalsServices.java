package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.GlobalsMapper;


public class GlobalsServices {

	private static Logger logger = LoggerFactory.getLogger(GlobalsServices.class);
//	GlobalsDao repository = new GlobalsDao();
	GlobalsMapper mapper = new GlobalsMapper();

}