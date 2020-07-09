package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlaninternationalvideocallMapper;
import com.mobilelife.controler.mapper.bean.PlansPlaninternationalvideocallBean;
import com.mobilelife.persistance.dao.PlansPlaninternationalvideocallDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlaninternationalvideocall;
import com.mobilelife.persistance.entities.PlansPlanprimary;


public class PlansPlaninternationalvideocallServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalvideocallServices.class);
	PlansPlaninternationalvideocallDao repository = new PlansPlaninternationalvideocallDao();
	PlansPlaninternationalvideocallMapper mapper = new PlansPlaninternationalvideocallMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlaninternationalvideocallBean getByPlanId(Integer id)
    {
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlaninternationalvideocall entity = plansPlanprimaryEntity.getPlansPlaninternationalvideocall();
        if(null!=entity) {
        	PlansPlaninternationalvideocallBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlaninternationalvideocallBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlaninternationalvideocall existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlaninternationalvideocall entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlaninternationalvideocall entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlaninternationalvideocall entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}