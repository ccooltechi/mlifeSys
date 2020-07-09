package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlandataMapper;
import com.mobilelife.controler.mapper.bean.PlansPlandataBean;
import com.mobilelife.persistance.dao.PlansPlandataDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlandata;
import com.mobilelife.persistance.entities.PlansPlanprimary;


public class PlansPlandataServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlandataServices.class);
	PlansPlandataDao repository = new PlansPlandataDao();
	PlansPlandataMapper mapper = new PlansPlandataMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlandataBean getByPlanId(Integer id)
    {
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlandata entity = plansPlanprimaryEntity.getPlansPlandata();
        if(null!=entity) {
        	PlansPlandataBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlandataBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlandata existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlandata entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlandata entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlandata entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }

}