package com.mobilelife.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlanDevicebrandMapper;
import com.mobilelife.controler.mapper.bean.PlanDevicebrand;
import com.mobilelife.persistance.dao.PlanDevicebrandDao;
import com.mobilelife.persistance.entities.PlanDevicebrandEntity;


public class PlanDevicebrandServices {

	private static Logger logger = LoggerFactory.getLogger(PlanDevicebrandServices.class);
	PlanDevicebrandDao repository = new PlanDevicebrandDao();
	PlanDevicebrandMapper mapper = new PlanDevicebrandMapper();
	

	public List<PlanDevicebrand> getAll() {
        List<PlanDevicebrandEntity> entityList = repository.findAll();
        List<PlanDevicebrand> bean = mapper.mapBean(entityList);
		return bean;
	}

    public PlanDevicebrand getById(Integer id)
    {
    	PlanDevicebrandEntity entity = repository.findById(id);
        if(null!=entity) {
        	PlanDevicebrand bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlanDevicebrand bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlanDevicebrandEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlanDevicebrandEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlanDevicebrandEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlanDevicebrandEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }
    
    public boolean delete(Integer id)
    {
    	boolean retVal =false;
    	PlanDevicebrandEntity entity = repository.findById(id);
		if(null!=entity)
        {
			retVal = repository.deleteData(entity);
			return retVal;
        } else {
            throw new RecordNotFoundException("No student record exist for given id "+id);
        }
    }	

}