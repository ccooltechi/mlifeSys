package com.mobilelife.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanprimaryMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanprimary;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;


public class PlansPlanprimaryServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanprimaryServices.class);
	PlansPlanprimaryDao repository = new PlansPlanprimaryDao();
	PlansPlanprimaryMapper mapper = new PlansPlanprimaryMapper();

	public List<PlansPlanprimary> getAll() {
        List<PlansPlanprimaryEntity> entityList = repository.findAll();
        List<PlansPlanprimary> bean = mapper.mapBean(entityList);
		return bean;
	}

    public PlansPlanprimary getById(Integer id)
    {
    	PlansPlanprimaryEntity entity = repository.findById(id);
    	PlansPlanprimary bean = mapper.mapBean(entity);
        if(null!=entity) {
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public Integer createOrUpdate(PlansPlanprimary bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlanprimaryEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlanprimaryEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return entity.getId();
	        } else {
	        	PlansPlanprimaryEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return entity.getId();
	        }
    	}
    	else
    	{
    		PlansPlanprimaryEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
            return entity.getId();
    	}	    
    }
    
    public boolean delete(Integer id)
    {
    	boolean retVal =false;
    	PlansPlanprimaryEntity entity = repository.findById(id);
		if(null!=entity)
        {
			retVal = repository.deleteData(entity);
			return retVal;
        } else {
            throw new RecordNotFoundException("No student record exist for given id "+id);
        }
    }	

}