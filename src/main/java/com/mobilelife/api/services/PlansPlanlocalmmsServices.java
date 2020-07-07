package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanlocalmmsMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanlocalmms;
import com.mobilelife.persistance.dao.PlansPlanlocalmmsDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanlocalmmsEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;


public class PlansPlanlocalmmsServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanlocalmmsServices.class);
	PlansPlanlocalmmsDao repository = new PlansPlanlocalmmsDao();
	PlansPlanlocalmmsMapper mapper = new PlansPlanlocalmmsMapper();

	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlanlocalmms getByPlanId(Integer id)
    {
    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlanlocalmmsEntity entity = plansPlanprimaryEntity.getPlansPlanlocalmms();
        if(null!=entity) {
        	PlansPlanlocalmms bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlanlocalmms bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlanlocalmmsEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlanlocalmmsEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlanlocalmmsEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlanlocalmmsEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}