package com.mobilelife.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanfeeMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanfeeBean;
import com.mobilelife.persistance.dao.PlansPlanfeeDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanfee;
import com.mobilelife.persistance.entities.PlansPlanprimary;


public class PlansPlanfeeServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanfeeServices.class);
	PlansPlanfeeDao repository = new PlansPlanfeeDao();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
	PlansPlanfeeMapper mapper = new PlansPlanfeeMapper();

    public PlansPlanfeeBean getByPlanId(Integer id)
    {
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlanfee entity = plansPlanprimaryEntity.getPlansPlanfee();
        if(null!=entity) {
        	PlansPlanfeeBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlanfeeBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlanfee existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlanfee entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlanfee entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlanfee entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }
}