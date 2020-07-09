package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlaninternationalcallsmsMapper;
import com.mobilelife.controler.mapper.bean.PlansPlaninternationalcallsmsBean;
import com.mobilelife.persistance.dao.PlansPlaninternationalcallsmsDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlaninternationalcallsms;
import com.mobilelife.persistance.entities.PlansPlanprimary;


public class PlansPlaninternationalcallsmsServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalcallsmsServices.class);
	PlansPlaninternationalcallsmsDao repository = new PlansPlaninternationalcallsmsDao();
	PlansPlaninternationalcallsmsMapper mapper = new PlansPlaninternationalcallsmsMapper();

	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlaninternationalcallsmsBean getByPlanId(Integer id)
    {
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlaninternationalcallsms entity = plansPlanprimaryEntity.getPlansPlaninternationalcallsms();
        if(null!=entity) {
        	PlansPlaninternationalcallsmsBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlaninternationalcallsmsBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlaninternationalcallsms existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlaninternationalcallsms entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlaninternationalcallsms entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlaninternationalcallsms entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}