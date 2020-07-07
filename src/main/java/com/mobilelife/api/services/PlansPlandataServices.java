package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlandataMapper;
import com.mobilelife.controler.mapper.bean.PlansPlandata;
import com.mobilelife.persistance.dao.PlansPlandataDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlandataEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;


public class PlansPlandataServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlandataServices.class);
	PlansPlandataDao repository = new PlansPlandataDao();
	PlansPlandataMapper mapper = new PlansPlandataMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlandata getByPlanId(Integer id)
    {
    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlandataEntity entity = plansPlanprimaryEntity.getPlansPlandata();
        if(null!=entity) {
        	PlansPlandata bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlandata bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlandataEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlandataEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlandataEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlandataEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }

}