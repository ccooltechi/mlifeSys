package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.ParternsOperatorOffersMapper;
import com.mobilelife.persistance.dao.ParternsOperatorOffersDao;


public class ParternsOperatorOffersServices {

	private static Logger logger = LoggerFactory.getLogger(ParternsOperatorOffersServices.class);
	ParternsOperatorOffersDao repository = new ParternsOperatorOffersDao();
	ParternsOperatorOffersMapper mapper = new ParternsOperatorOffersMapper();

}