package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlansocialdataMapper;
import com.mobilelife.controler.mapper.bean.PlansPlansocialdata;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.dao.PlansPlansocialdataDao;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;
import com.mobilelife.persistance.entities.PlansPlansocialdataEntity;


public class PlansPlansocialdataServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlansocialdataServices.class);
	PlansPlansocialdataDao repository = new PlansPlansocialdataDao();
	PlansPlansocialdataMapper mapper = new PlansPlansocialdataMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlansocialdata getByPlanId(Integer id)
    {
    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlansocialdataEntity entity = plansPlanprimaryEntity.getPlansPlansocialdata();
        if(null!=entity) {
        	PlansPlansocialdata bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlansocialdata bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlansocialdataEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlansocialdataEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlansocialdataEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlansocialdataEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}