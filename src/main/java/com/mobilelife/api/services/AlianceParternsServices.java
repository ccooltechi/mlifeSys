package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.AlianceParternsMapper;
import com.mobilelife.persistance.dao.AlianceParternsDao;


public class AlianceParternsServices {

	private static Logger logger = LoggerFactory.getLogger(AlianceParternsServices.class);
	AlianceParternsDao repository = new AlianceParternsDao();
	AlianceParternsMapper mapper = new AlianceParternsMapper();

}