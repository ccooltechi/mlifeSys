package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlansmsoffnetMapper;
import com.mobilelife.controler.mapper.bean.PlansPlansmsoffnetBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.dao.PlansPlansmsoffnetDao;
import com.mobilelife.persistance.entities.PlansPlanprimary;
import com.mobilelife.persistance.entities.PlansPlansmsoffnet;


public class PlansPlansmsoffnetServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlansmsoffnetServices.class);
	PlansPlansmsoffnetDao repository = new PlansPlansmsoffnetDao();
	PlansPlansmsoffnetMapper mapper = new PlansPlansmsoffnetMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlansmsoffnetBean getByPlanId(Integer id)
    {
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlansmsoffnet entity = plansPlanprimaryEntity.getPlansPlansmsoffnet();
        if(null!=entity) {
        	PlansPlansmsoffnetBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlansmsoffnetBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlansmsoffnet existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlansmsoffnet entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlansmsoffnet entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlansmsoffnet entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}