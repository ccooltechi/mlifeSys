package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlansmsoffnetMapper;
import com.mobilelife.controler.mapper.bean.PlansPlansmsoffnet;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.dao.PlansPlansmsoffnetDao;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;
import com.mobilelife.persistance.entities.PlansPlansmsoffnetEntity;


public class PlansPlansmsoffnetServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlansmsoffnetServices.class);
	PlansPlansmsoffnetDao repository = new PlansPlansmsoffnetDao();
	PlansPlansmsoffnetMapper mapper = new PlansPlansmsoffnetMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlansmsoffnet getByPlanId(Integer id)
    {
    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlansmsoffnetEntity entity = plansPlanprimaryEntity.getPlansPlansmsoffnet();
        if(null!=entity) {
        	PlansPlansmsoffnet bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlansmsoffnet bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlansmsoffnetEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlansmsoffnetEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlansmsoffnetEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlansmsoffnetEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}