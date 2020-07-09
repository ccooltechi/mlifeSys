package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlansmsMapper;
import com.mobilelife.controler.mapper.bean.PlansPlansmsBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.dao.PlansPlansmsDao;
import com.mobilelife.persistance.entities.PlansPlanprimary;
import com.mobilelife.persistance.entities.PlansPlansms;


public class PlansPlansmsServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlansmsServices.class);
	PlansPlansmsDao repository = new PlansPlansmsDao();
	PlansPlansmsMapper mapper = new PlansPlansmsMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlansmsBean getByPlanId(Integer id)
    {
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlansms entity = plansPlanprimaryEntity.getPlansPlansms();
        if(null!=entity) {
        	PlansPlansmsBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlansmsBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlansms existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlansms entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlansms entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlansms entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}