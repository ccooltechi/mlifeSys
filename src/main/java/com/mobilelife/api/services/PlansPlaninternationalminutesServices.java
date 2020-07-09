package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlaninternationalminutesMapper;
import com.mobilelife.controler.mapper.bean.PlansPlaninternationalminutesBean;
import com.mobilelife.persistance.dao.PlansPlaninternationalminutesDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlaninternationalminutes;
import com.mobilelife.persistance.entities.PlansPlanprimary;


public class PlansPlaninternationalminutesServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalminutesServices.class);
	PlansPlaninternationalminutesDao repository = new PlansPlaninternationalminutesDao();
	PlansPlaninternationalminutesMapper mapper = new PlansPlaninternationalminutesMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlaninternationalminutesBean getByPlanId(Integer id)
    {
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlaninternationalminutes entity = plansPlanprimaryEntity.getPlansPlaninternationalminutes();
        if(null!=entity) {
        	PlansPlaninternationalminutesBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlaninternationalminutesBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlaninternationalminutes existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlaninternationalminutes entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlaninternationalminutes entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlaninternationalminutes entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}