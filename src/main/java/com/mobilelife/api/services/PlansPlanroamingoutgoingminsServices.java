package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanroamingoutgoingminsMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanroamingoutgoingmins;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.dao.PlansPlanroamingoutgoingminsDao;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;
import com.mobilelife.persistance.entities.PlansPlanroamingoutgoingminsEntity;


public class PlansPlanroamingoutgoingminsServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanroamingoutgoingminsServices.class);
	PlansPlanroamingoutgoingminsDao repository = new PlansPlanroamingoutgoingminsDao();
	PlansPlanroamingoutgoingminsMapper mapper = new PlansPlanroamingoutgoingminsMapper();

	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlanroamingoutgoingmins getByPlanId(Integer id)
    {
    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlanroamingoutgoingminsEntity entity = plansPlanprimaryEntity.getPlansPlanroamingoutgoingmins();
        if(null!=entity) {
        	PlansPlanroamingoutgoingmins bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlanroamingoutgoingmins bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlanroamingoutgoingminsEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlanroamingoutgoingminsEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlanroamingoutgoingminsEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlanroamingoutgoingminsEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}