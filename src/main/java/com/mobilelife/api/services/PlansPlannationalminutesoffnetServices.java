package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlannationalminutesoffnetMapper;
import com.mobilelife.controler.mapper.bean.PlansPlannationalminutesoffnet;
import com.mobilelife.persistance.dao.PlansPlannationalminutesoffnetDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlannationalminutesoffnetEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;


public class PlansPlannationalminutesoffnetServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlannationalminutesoffnetServices.class);
	PlansPlannationalminutesoffnetDao repository = new PlansPlannationalminutesoffnetDao();
	PlansPlannationalminutesoffnetMapper mapper = new PlansPlannationalminutesoffnetMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlannationalminutesoffnet getByPlanId(Integer id)
    {
    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlannationalminutesoffnetEntity entity = plansPlanprimaryEntity.getPlansPlannationalminutesoffnet();
        if(null!=entity) {
        	PlansPlannationalminutesoffnet bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlannationalminutesoffnet bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlannationalminutesoffnetEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlannationalminutesoffnetEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlannationalminutesoffnetEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlannationalminutesoffnetEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}