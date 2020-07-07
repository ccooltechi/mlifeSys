package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanpreferrednumbersMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanpreferrednumbers;
import com.mobilelife.persistance.dao.PlansPlanpreferrednumbersDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanpreferrednumbersEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;


public class PlansPlanpreferrednumbersServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanpreferrednumbersServices.class);
	PlansPlanpreferrednumbersDao repository = new PlansPlanpreferrednumbersDao();
	PlansPlanpreferrednumbersMapper mapper = new PlansPlanpreferrednumbersMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlanpreferrednumbers getByPlanId(Integer id)
    {
    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlanpreferrednumbersEntity entity = plansPlanprimaryEntity.getPlansPlanpreferrednumbers();
        if(null!=entity) {
        	PlansPlanpreferrednumbers bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlanpreferrednumbers bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlanpreferrednumbersEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlanpreferrednumbersEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlanpreferrednumbersEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlanpreferrednumbersEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}