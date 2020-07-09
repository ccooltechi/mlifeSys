package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlansmsonnetMapper;
import com.mobilelife.controler.mapper.bean.PlansPlansmsonnetBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.dao.PlansPlansmsonnetDao;
import com.mobilelife.persistance.entities.PlansPlanprimary;
import com.mobilelife.persistance.entities.PlansPlansmsonnet;


public class PlansPlansmsonnetServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlansmsonnetServices.class);
	PlansPlansmsonnetDao repository = new PlansPlansmsonnetDao();
	PlansPlansmsonnetMapper mapper = new PlansPlansmsonnetMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlansmsonnetBean getByPlanId(Integer id)
    {
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlansmsonnet entity = plansPlanprimaryEntity.getPlansPlansmsonnet();
        if(null!=entity) {
        	PlansPlansmsonnetBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlansmsonnetBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlansmsonnet existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlansmsonnet entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlansmsonnet entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlansmsonnet entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}