package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlaninternationalsmsMapper;
import com.mobilelife.controler.mapper.bean.PlansPlaninternationalsms;
import com.mobilelife.persistance.dao.PlansPlaninternationalsmsDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlaninternationalsmsEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;


public class PlansPlaninternationalsmsServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalsmsServices.class);
	PlansPlaninternationalsmsDao repository = new PlansPlaninternationalsmsDao();
	PlansPlaninternationalsmsMapper mapper = new PlansPlaninternationalsmsMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlaninternationalsms getByPlanId(Integer id)
    {
    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlaninternationalsmsEntity entity = plansPlanprimaryEntity.getPlansPlaninternationalsms();
        if(null!=entity) {
        	PlansPlaninternationalsms bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlaninternationalsms bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlaninternationalsmsEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlaninternationalsmsEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlaninternationalsmsEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlaninternationalsmsEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}