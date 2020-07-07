package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanlocalcallsmsMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanlocalcallsms;
import com.mobilelife.persistance.dao.PlansPlanlocalcallsmsDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanlocalcallsmsEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;


public class PlansPlanlocalcallsmsServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanlocalcallsmsServices.class);
	PlansPlanlocalcallsmsDao repository = new PlansPlanlocalcallsmsDao();
	PlansPlanlocalcallsmsMapper mapper = new PlansPlanlocalcallsmsMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlanlocalcallsms getByPlanId(Integer id)
    {
    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlanlocalcallsmsEntity entity = plansPlanprimaryEntity.getPlansPlanlocalcallsms();
        if(null!=entity) {
        	PlansPlanlocalcallsms bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlanlocalcallsms bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlanlocalcallsmsEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlanlocalcallsmsEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlanlocalcallsmsEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlanlocalcallsmsEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}