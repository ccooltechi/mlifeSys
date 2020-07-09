package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanlocalcallsmsMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanlocalcallsmsBean;
import com.mobilelife.persistance.dao.PlansPlanlocalcallsmsDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanlocalcallsms;
import com.mobilelife.persistance.entities.PlansPlanprimary;


public class PlansPlanlocalcallsmsServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanlocalcallsmsServices.class);
	PlansPlanlocalcallsmsDao repository = new PlansPlanlocalcallsmsDao();
	PlansPlanlocalcallsmsMapper mapper = new PlansPlanlocalcallsmsMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlanlocalcallsmsBean getByPlanId(Integer id)
    {
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlanlocalcallsms entity = plansPlanprimaryEntity.getPlansPlanlocalcallsms();
        if(null!=entity) {
        	PlansPlanlocalcallsmsBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlanlocalcallsmsBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlanlocalcallsms existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlanlocalcallsms entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlanlocalcallsms entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlanlocalcallsms entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}