package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanroamingincomingminsMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanroamingincomingminsBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.dao.PlansPlanroamingincomingminsDao;
import com.mobilelife.persistance.entities.PlansPlanprimary;
import com.mobilelife.persistance.entities.PlansPlanroamingincomingmins;


public class PlansPlanroamingincomingminsServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanroamingincomingminsServices.class);
	PlansPlanroamingincomingminsDao repository = new PlansPlanroamingincomingminsDao();
	PlansPlanroamingincomingminsMapper mapper = new PlansPlanroamingincomingminsMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlanroamingincomingminsBean getByPlanId(Integer id)
    {
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlanroamingincomingmins entity = plansPlanprimaryEntity.getPlansPlanroamingincomingmins();
        if(null!=entity) {
        	PlansPlanroamingincomingminsBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlanroamingincomingminsBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlanroamingincomingmins existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlanroamingincomingmins entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlanroamingincomingmins entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlanroamingincomingmins entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}