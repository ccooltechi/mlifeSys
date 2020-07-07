package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.SearchDetailsMapper;
import com.mobilelife.persistance.dao.SearchDetailsDao;


public class SearchDetailsServices {

	private static Logger logger = LoggerFactory.getLogger(SearchDetailsServices.class);
	SearchDetailsDao repository = new SearchDetailsDao();
	SearchDetailsMapper mapper = new SearchDetailsMapper();

}