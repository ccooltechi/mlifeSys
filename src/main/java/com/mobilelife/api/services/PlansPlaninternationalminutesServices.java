package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlaninternationalminutesMapper;
import com.mobilelife.controler.mapper.bean.PlansPlaninternationalminutes;
import com.mobilelife.persistance.dao.PlansPlaninternationalminutesDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlaninternationalminutesEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;


public class PlansPlaninternationalminutesServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalminutesServices.class);
	PlansPlaninternationalminutesDao repository = new PlansPlaninternationalminutesDao();
	PlansPlaninternationalminutesMapper mapper = new PlansPlaninternationalminutesMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlaninternationalminutes getByPlanId(Integer id)
    {
    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlaninternationalminutesEntity entity = plansPlanprimaryEntity.getPlansPlaninternationalminutes();
        if(null!=entity) {
        	PlansPlaninternationalminutes bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlaninternationalminutes bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlaninternationalminutesEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlaninternationalminutesEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlaninternationalminutesEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlaninternationalminutesEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}