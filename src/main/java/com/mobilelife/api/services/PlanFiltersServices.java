package com.mobilelife.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlanFiltersMapper;
import com.mobilelife.controler.mapper.bean.PlanFilters;
import com.mobilelife.persistance.dao.PlanFilterDao;
import com.mobilelife.persistance.entities.PlanFiltersEntity;


public class PlanFiltersServices {

	private static Logger logger = LoggerFactory.getLogger(PlanFiltersServices.class);
	PlanFilterDao repository = new PlanFilterDao();
	PlanFiltersMapper mapper = new PlanFiltersMapper();

	public List<PlanFilters> getAll() {
        List<PlanFiltersEntity> entityList = repository.findAll();
        List<PlanFilters> bean = mapper.mapBean(entityList);
		return bean;
	}

    public PlanFilters getById(Integer id)
    {
    	PlanFiltersEntity entity = repository.findById(id);
    	PlanFilters bean = mapper.mapBean(entity);
        if(null!=entity) {
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlanFilters bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlanFiltersEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlanFiltersEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlanFiltersEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlanFiltersEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }
    
    public boolean delete(Integer id)
    {
    	boolean retVal =false;
    	PlanFiltersEntity entity = repository.findById(id);
		if(null!=entity)
        {
			retVal = repository.deleteData(entity);
			return retVal;
        } else {
            throw new RecordNotFoundException("No student record exist for given id "+id);
        }
    }	

}