package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.AlianceParternsAgeMapper;
import com.mobilelife.persistance.dao.AlianceParternsAgeDao;

public class AlianceParternsAgeServices {

	private static Logger logger = LoggerFactory.getLogger(AlianceParternsAgeServices.class);
	AlianceParternsAgeDao repository = new AlianceParternsAgeDao();
	AlianceParternsAgeMapper mapper = new AlianceParternsAgeMapper();

}