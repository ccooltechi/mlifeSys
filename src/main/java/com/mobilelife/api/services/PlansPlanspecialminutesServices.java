package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanspecialminutesMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanspecialminutesBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.dao.PlansPlanspecialminutesDao;
import com.mobilelife.persistance.entities.PlansPlanprimary;
import com.mobilelife.persistance.entities.PlansPlanspecialminutes;


public class PlansPlanspecialminutesServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanspecialminutesServices.class);
	PlansPlanspecialminutesDao repository = new PlansPlanspecialminutesDao();
	PlansPlanspecialminutesMapper mapper = new PlansPlanspecialminutesMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlanspecialminutesBean getByPlanId(Integer id)
    {
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlanspecialminutes entity = plansPlanprimaryEntity.getPlansPlanspecialminutes();
        if(null!=entity) {
        	PlansPlanspecialminutesBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlanspecialminutesBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlanspecialminutes existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlanspecialminutes entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlanspecialminutes entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlanspecialminutes entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}