package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlaninternationalmmsMapper;
import com.mobilelife.controler.mapper.bean.PlansPlaninternationalmmsBean;
import com.mobilelife.persistance.dao.PlansPlaninternationalmmsDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlaninternationalmms;
import com.mobilelife.persistance.entities.PlansPlanprimary;


public class PlansPlaninternationalmmsServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalmmsServices.class);
	PlansPlaninternationalmmsDao repository = new PlansPlaninternationalmmsDao();
	PlansPlaninternationalmmsMapper mapper = new PlansPlaninternationalmmsMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlaninternationalmmsBean getByPlanId(Integer id)
    {
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlaninternationalmms entity = plansPlanprimaryEntity.getPlansPlaninternationalmms();
        if(null!=entity) {
        	PlansPlaninternationalmmsBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlaninternationalmmsBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlaninternationalmms existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlaninternationalmms entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlaninternationalmms entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlaninternationalmms entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}