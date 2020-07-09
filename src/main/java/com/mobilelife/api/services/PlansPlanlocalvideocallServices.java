package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanlocalvideocallMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanlocalvideocallBean;
import com.mobilelife.persistance.dao.PlansPlanlocalvideocallDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanlocalvideocall;
import com.mobilelife.persistance.entities.PlansPlanprimary;


public class PlansPlanlocalvideocallServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanlocalvideocallServices.class);
	PlansPlanlocalvideocallDao repository = new PlansPlanlocalvideocallDao();
	PlansPlanlocalvideocallMapper mapper = new PlansPlanlocalvideocallMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlanlocalvideocallBean getByPlanId(Integer id)
    {
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlanlocalvideocall entity = plansPlanprimaryEntity.getPlansPlanlocalvideocall();
        if(null!=entity) {
        	PlansPlanlocalvideocallBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlanlocalvideocallBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlanlocalvideocall existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlanlocalvideocall entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlanlocalvideocall entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlanlocalvideocall entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}