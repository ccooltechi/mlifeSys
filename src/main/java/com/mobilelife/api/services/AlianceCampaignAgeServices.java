package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.AlianceCampaignAgeMapper;
import com.mobilelife.persistance.dao.AlianceCampaignAgeDao;

public class AlianceCampaignAgeServices {

	private static Logger logger = LoggerFactory.getLogger(AlianceCampaignAgeServices.class);
	AlianceCampaignAgeDao repository = new AlianceCampaignAgeDao();
	AlianceCampaignAgeMapper mapper = new AlianceCampaignAgeMapper();

}