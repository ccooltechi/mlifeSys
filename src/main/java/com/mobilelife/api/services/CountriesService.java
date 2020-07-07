package com.mobilelife.api.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.api.resources.CountryResource;
import com.mobilelife.controler.mapper.CountryMapper;
import com.mobilelife.controler.mapper.bean.Countries;
import com.mobilelife.persistance.dao.CountryDao;
import com.mobilelife.persistance.entities.CountriesEntity;

public class CountriesService {

	private static Logger logger = LoggerFactory.getLogger(CountriesService.class);
	CountryDao repository = new CountryDao();
	CountryMapper mapper = new CountryMapper();

	public List<Countries> getAll() {
        List<CountriesEntity> entity = repository.findAll();
        List<Countries> bean = mapper.mapBean(entity);
		return bean;
	}

    public Countries getById(Integer id)
    {
        CountriesEntity entity = repository.findById(id);
        Countries bean = mapper.mapBean(entity);
        if(null!=entity) {
        	repository.findByCodes("'"+entity.getCountryCode()+"'");
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(CountriesEntity entity)
    {
    	boolean retVal = false;
    	if(entity.getId()!=null)
    	{
    		CountriesEntity existEntity = repository.findById(entity.getId());
    		if(null!=existEntity)
	        {
	    		CountriesEntity updateEntity = existEntity;
	    		updateEntity.setCountryCode(entity.getCountryCode());
	    		updateEntity.setCountryName(entity.getCountryName());
	            retVal = repository.updateData(updateEntity);
	            return retVal;
	        } else {
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }
    
    public boolean delete(Integer id)
    {
    	boolean retVal =false;
		CountriesEntity entity = repository.findById(id);
		if(null!=entity)
        {
			retVal = repository.deleteData(entity);
			return retVal;
        } else {
            throw new RecordNotFoundException("No student record exist for given id "+id);
        }
    }	

}
