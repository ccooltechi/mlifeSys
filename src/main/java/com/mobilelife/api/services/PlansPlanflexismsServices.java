package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanflexismsMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanflexisms;
import com.mobilelife.persistance.dao.PlansPlanFlexiSMSDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanflexismsEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;


public class PlansPlanflexismsServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanflexismsServices.class);
	PlansPlanFlexiSMSDao repository = new PlansPlanFlexiSMSDao();
	PlansPlanflexismsMapper mapper = new PlansPlanflexismsMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlanflexisms getByPlanId(Integer id)
    {
    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlanflexismsEntity entity = plansPlanprimaryEntity.getPlansPlanflexisms();
        if(null!=entity) {
        	PlansPlanflexisms bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlanflexisms bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlanflexismsEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlanflexismsEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlanflexismsEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlanflexismsEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


	
	
}