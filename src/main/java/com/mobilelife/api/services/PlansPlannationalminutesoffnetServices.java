package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlannationalminutesoffnetMapper;
import com.mobilelife.controler.mapper.bean.PlansPlannationalminutesoffnetBean;
import com.mobilelife.persistance.dao.PlansPlannationalminutesoffnetDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlannationalminutesoffnet;
import com.mobilelife.persistance.entities.PlansPlanprimary;


public class PlansPlannationalminutesoffnetServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlannationalminutesoffnetServices.class);
	PlansPlannationalminutesoffnetDao repository = new PlansPlannationalminutesoffnetDao();
	PlansPlannationalminutesoffnetMapper mapper = new PlansPlannationalminutesoffnetMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlannationalminutesoffnetBean getByPlanId(Integer id)
    {
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlannationalminutesoffnet entity = plansPlanprimaryEntity.getPlansPlannationalminutesoffnet();
        if(null!=entity) {
        	PlansPlannationalminutesoffnetBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlannationalminutesoffnetBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlannationalminutesoffnet existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlannationalminutesoffnet entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlannationalminutesoffnet entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlannationalminutesoffnet entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}