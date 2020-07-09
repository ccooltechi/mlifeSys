package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanflexiMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanflexiBean;
import com.mobilelife.persistance.dao.PlansPlanflexiDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanflexi;
import com.mobilelife.persistance.entities.PlansPlanprimary;


public class PlansPlanflexiServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanflexiServices.class);
	PlansPlanflexiDao repository = new PlansPlanflexiDao();
	PlansPlanflexiMapper mapper = new PlansPlanflexiMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlanflexiBean getByPlanId(Integer id)
    {
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlanflexi entity = plansPlanprimaryEntity.getPlansPlanflexi();
        if(null!=entity) {
        	PlansPlanflexiBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlanflexiBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlanflexi existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlanflexi entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlanflexi entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlanflexi entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }

}