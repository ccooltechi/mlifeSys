package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanoutofbundleMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanoutofbundle;
import com.mobilelife.persistance.dao.PlansPlanoutofbundleDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanoutofbundleEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;


public class PlansPlanoutofbundleServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanoutofbundleServices.class);
	PlansPlanoutofbundleDao repository = new PlansPlanoutofbundleDao();
	PlansPlanoutofbundleMapper mapper = new PlansPlanoutofbundleMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlanoutofbundle getByPlanId(Integer id)
    {
    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlanoutofbundleEntity entity = plansPlanprimaryEntity.getPlansPlanoutofbundle();
        if(null!=entity) {
        	PlansPlanoutofbundle bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlanoutofbundle bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlanoutofbundleEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlanoutofbundleEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlanoutofbundleEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlanoutofbundleEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}