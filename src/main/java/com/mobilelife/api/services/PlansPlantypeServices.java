package com.mobilelife.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlantypeMapper;
import com.mobilelife.controler.mapper.bean.PlansOperatorBean;
import com.mobilelife.controler.mapper.bean.PlansPlantypeBean;
import com.mobilelife.persistance.dao.PlansTypePlanDao;
import com.mobilelife.persistance.entities.PlansPlantype;


public class PlansPlantypeServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlantypeServices.class);
	PlansTypePlanDao repository = new PlansTypePlanDao();
	PlansPlantypeMapper mapper = new PlansPlantypeMapper();

	public List<PlansPlantypeBean> getAll() {
        List<PlansPlantype> entityList = repository.findAll();
        List<PlansPlantypeBean> bean = mapper.mapBean(entityList);
		return bean;
	}

    public PlansPlantypeBean getById(Integer id)
    {
    	PlansPlantype entity = repository.findById(id);
    	PlansPlantypeBean bean = mapper.mapBean(entity);
        if(null!=entity) {
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlantypeBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlantype existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlantype entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlantype entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlantype entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }
    
    public boolean delete(Integer id)
    {
    	boolean retVal =false;
    	PlansPlantype entity = repository.findById(id);
		if(null!=entity)
        {
			retVal = repository.deleteData(entity);
			return retVal;
        } else {
            throw new RecordNotFoundException("No student record exist for given id "+id);
        }
    }	


}