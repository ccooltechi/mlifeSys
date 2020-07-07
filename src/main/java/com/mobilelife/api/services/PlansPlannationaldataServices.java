package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlannationaldataMapper;
import com.mobilelife.controler.mapper.bean.PlansPlannationaldata;
import com.mobilelife.persistance.dao.PlansPlannationaldataDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlannationaldataEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;


public class PlansPlannationaldataServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlannationaldataServices.class);
	PlansPlannationaldataDao repository = new PlansPlannationaldataDao();
	PlansPlannationaldataMapper mapper = new PlansPlannationaldataMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlannationaldata getByPlanId(Integer id)
    {
    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlannationaldataEntity entity = plansPlanprimaryEntity.getPlansPlannationaldata();
        if(null!=entity) {
        	PlansPlannationaldata bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlannationaldata bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlannationaldataEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlannationaldataEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlannationaldataEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlannationaldataEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}