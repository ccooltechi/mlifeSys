package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlaninternationalvideocallMapper;
import com.mobilelife.controler.mapper.bean.PlansPlaninternationalvideocall;
import com.mobilelife.persistance.dao.PlansPlaninternationalvideocallDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlaninternationalvideocallEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;


public class PlansPlaninternationalvideocallServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalvideocallServices.class);
	PlansPlaninternationalvideocallDao repository = new PlansPlaninternationalvideocallDao();
	PlansPlaninternationalvideocallMapper mapper = new PlansPlaninternationalvideocallMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlaninternationalvideocall getByPlanId(Integer id)
    {
    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlaninternationalvideocallEntity entity = plansPlanprimaryEntity.getPlansPlaninternationalvideocall();
        if(null!=entity) {
        	PlansPlaninternationalvideocall bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlaninternationalvideocall bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlaninternationalvideocallEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlaninternationalvideocallEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlaninternationalvideocallEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlaninternationalvideocallEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}