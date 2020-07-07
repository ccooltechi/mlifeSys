package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlaninternationalcallsmsMapper;
import com.mobilelife.controler.mapper.bean.PlansPlaninternationalcallsms;
import com.mobilelife.persistance.dao.PlansPlaninternationalcallsmsDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlaninternationalcallsmsEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;


public class PlansPlaninternationalcallsmsServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalcallsmsServices.class);
	PlansPlaninternationalcallsmsDao repository = new PlansPlaninternationalcallsmsDao();
	PlansPlaninternationalcallsmsMapper mapper = new PlansPlaninternationalcallsmsMapper();

	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlaninternationalcallsms getByPlanId(Integer id)
    {
    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlaninternationalcallsmsEntity entity = plansPlanprimaryEntity.getPlansPlaninternationalcallsms();
        if(null!=entity) {
        	PlansPlaninternationalcallsms bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlaninternationalcallsms bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlaninternationalcallsmsEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlaninternationalcallsmsEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlaninternationalcallsmsEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlaninternationalcallsmsEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}