package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlannationalminutesonnetMapper;
import com.mobilelife.controler.mapper.bean.PlansPlannationalminutesonnetBean;
import com.mobilelife.persistance.dao.PlansPlannationalminutesonnetDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlannationalminutesonnet;
import com.mobilelife.persistance.entities.PlansPlanprimary;


public class PlansPlannationalminutesonnetServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlannationalminutesonnetServices.class);
	PlansPlannationalminutesonnetDao repository = new PlansPlannationalminutesonnetDao();
	PlansPlannationalminutesonnetMapper mapper = new PlansPlannationalminutesonnetMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlannationalminutesonnetBean getByPlanId(Integer id)
    {
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlannationalminutesonnet entity = plansPlanprimaryEntity.getPlansPlannationalminutesonnet();
        if(null!=entity) {
        	PlansPlannationalminutesonnetBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlannationalminutesonnetBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlannationalminutesonnet existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlannationalminutesonnet entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlannationalminutesonnet entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlannationalminutesonnet entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}