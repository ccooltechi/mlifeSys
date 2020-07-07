package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlannationalminutesMapper;
import com.mobilelife.controler.mapper.bean.PlansPlannationalminutes;
import com.mobilelife.persistance.dao.PlansPlannationalminutesDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlannationalminutesEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;


public class PlansPlannationalminutesServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlannationalminutesServices.class);
	PlansPlannationalminutesDao repository = new PlansPlannationalminutesDao();
	PlansPlannationalminutesMapper mapper = new PlansPlannationalminutesMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlannationalminutes getByPlanId(Integer id)
    {
    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlannationalminutesEntity entity = plansPlanprimaryEntity.getPlansPlannationalminutes();
        if(null!=entity) {
        	PlansPlannationalminutes bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlannationalminutes bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlannationalminutesEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlannationalminutesEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlannationalminutesEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlannationalminutesEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}