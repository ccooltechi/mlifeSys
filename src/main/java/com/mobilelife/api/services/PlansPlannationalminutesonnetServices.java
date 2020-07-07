package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlannationalminutesonnetMapper;
import com.mobilelife.controler.mapper.bean.PlansPlannationalminutesonnet;
import com.mobilelife.persistance.dao.PlansPlannationalminutesonnetDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlannationalminutesonnetEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;


public class PlansPlannationalminutesonnetServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlannationalminutesonnetServices.class);
	PlansPlannationalminutesonnetDao repository = new PlansPlannationalminutesonnetDao();
	PlansPlannationalminutesonnetMapper mapper = new PlansPlannationalminutesonnetMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlannationalminutesonnet getByPlanId(Integer id)
    {
    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlannationalminutesonnetEntity entity = plansPlanprimaryEntity.getPlansPlannationalminutesonnet();
        if(null!=entity) {
        	PlansPlannationalminutesonnet bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlannationalminutesonnet bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlannationalminutesonnetEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlannationalminutesonnetEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlannationalminutesonnetEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlannationalminutesonnetEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}