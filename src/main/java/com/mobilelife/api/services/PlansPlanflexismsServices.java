package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanflexismsMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanflexismsBean;
import com.mobilelife.persistance.dao.PlansPlanFlexiSMSDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanflexisms;
import com.mobilelife.persistance.entities.PlansPlanprimary;


public class PlansPlanflexismsServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanflexismsServices.class);
	PlansPlanFlexiSMSDao repository = new PlansPlanFlexiSMSDao();
	PlansPlanflexismsMapper mapper = new PlansPlanflexismsMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlanflexismsBean getByPlanId(Integer id)
    {
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlanflexisms entity = plansPlanprimaryEntity.getPlansPlanflexisms();
        if(null!=entity) {
        	PlansPlanflexismsBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlanflexismsBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlanflexisms existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlanflexisms entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlanflexisms entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlanflexisms entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


	
	
}