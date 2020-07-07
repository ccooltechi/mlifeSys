package com.mobilelife.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlantypeMapper;
import com.mobilelife.controler.mapper.bean.PlansOperator;
import com.mobilelife.controler.mapper.bean.PlansPlantype;
import com.mobilelife.persistance.dao.PlansTypePlanDao;
import com.mobilelife.persistance.entities.PlansPlantypeEntity;


public class PlansPlantypeServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlantypeServices.class);
	PlansTypePlanDao repository = new PlansTypePlanDao();
	PlansPlantypeMapper mapper = new PlansPlantypeMapper();

	public List<PlansPlantype> getAll() {
        List<PlansPlantypeEntity> entityList = repository.findAll();
        List<PlansPlantype> bean = mapper.mapBean(entityList);
		return bean;
	}

    public PlansPlantype getById(Integer id)
    {
    	PlansPlantypeEntity entity = repository.findById(id);
    	PlansPlantype bean = mapper.mapBean(entity);
        if(null!=entity) {
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlantype bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlantypeEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlantypeEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlantypeEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlantypeEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }
    
    public boolean delete(Integer id)
    {
    	boolean retVal =false;
    	PlansPlantypeEntity entity = repository.findById(id);
		if(null!=entity)
        {
			retVal = repository.deleteData(entity);
			return retVal;
        } else {
            throw new RecordNotFoundException("No student record exist for given id "+id);
        }
    }	


}