package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanmiscellaneousMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanmiscellaneous;
import com.mobilelife.persistance.dao.PlansPlanmiscellaneousDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanmiscellaneousEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;


public class PlansPlanmiscellaneousServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanmiscellaneousServices.class);
	PlansPlanmiscellaneousDao repository = new PlansPlanmiscellaneousDao();
	PlansPlanmiscellaneousMapper mapper = new PlansPlanmiscellaneousMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlanmiscellaneous getByPlanId(Integer id)
    {
    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlanmiscellaneousEntity entity = plansPlanprimaryEntity.getPlansPlanmiscellaneous();
        if(null!=entity) {
        	PlansPlanmiscellaneous bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlanmiscellaneous bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlanmiscellaneousEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlanmiscellaneousEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlanmiscellaneousEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlanmiscellaneousEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}