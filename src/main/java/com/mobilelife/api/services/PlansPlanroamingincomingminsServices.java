package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanroamingincomingminsMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanroamingincomingmins;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.dao.PlansPlanroamingincomingminsDao;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;
import com.mobilelife.persistance.entities.PlansPlanroamingincomingminsEntity;


public class PlansPlanroamingincomingminsServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanroamingincomingminsServices.class);
	PlansPlanroamingincomingminsDao repository = new PlansPlanroamingincomingminsDao();
	PlansPlanroamingincomingminsMapper mapper = new PlansPlanroamingincomingminsMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlanroamingincomingmins getByPlanId(Integer id)
    {
    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlanroamingincomingminsEntity entity = plansPlanprimaryEntity.getPlansPlanroamingincomingmins();
        if(null!=entity) {
        	PlansPlanroamingincomingmins bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlanroamingincomingmins bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlanroamingincomingminsEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlanroamingincomingminsEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlanroamingincomingminsEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlanroamingincomingminsEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}