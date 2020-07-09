package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanoutofbundleMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanoutofbundleBean;
import com.mobilelife.persistance.dao.PlansPlanoutofbundleDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanoutofbundle;
import com.mobilelife.persistance.entities.PlansPlanprimary;


public class PlansPlanoutofbundleServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanoutofbundleServices.class);
	PlansPlanoutofbundleDao repository = new PlansPlanoutofbundleDao();
	PlansPlanoutofbundleMapper mapper = new PlansPlanoutofbundleMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlanoutofbundleBean getByPlanId(Integer id)
    {
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlanoutofbundle entity = plansPlanprimaryEntity.getPlansPlanoutofbundle();
        if(null!=entity) {
        	PlansPlanoutofbundleBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlanoutofbundleBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlanoutofbundle existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlanoutofbundle entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlanoutofbundle entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlanoutofbundle entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}