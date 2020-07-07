package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.AlianceCampaignMapper;
import com.mobilelife.persistance.dao.AlianceCampaignDao;

public class AlianceCampaignServices {

	private static Logger logger = LoggerFactory.getLogger(AlianceCampaignServices.class);
	AlianceCampaignDao repository = new AlianceCampaignDao();
	AlianceCampaignMapper mapper = new AlianceCampaignMapper();

}