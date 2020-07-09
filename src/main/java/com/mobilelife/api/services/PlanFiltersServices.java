package com.mobilelife.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlanFiltersMapper;
import com.mobilelife.controler.mapper.bean.PlanFiltersBean;
import com.mobilelife.persistance.dao.PlanFilterDao;
import com.mobilelife.persistance.entities.PlanFilters;


public class PlanFiltersServices {

	private static Logger logger = LoggerFactory.getLogger(PlanFiltersServices.class);
	PlanFilterDao repository = new PlanFilterDao();
	PlanFiltersMapper mapper = new PlanFiltersMapper();

	public List<PlanFiltersBean> getAll() {
        List<PlanFilters> entityList = repository.findAll();
        List<PlanFiltersBean> bean = mapper.mapBean(entityList);
		return bean;
	}

    public PlanFiltersBean getById(Integer id)
    {
    	PlanFilters entity = repository.findById(id);
    	PlanFiltersBean bean = mapper.mapBean(entity);
        if(null!=entity) {
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlanFiltersBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlanFilters existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlanFilters entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlanFilters entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlanFilters entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }
    
    public boolean delete(Integer id)
    {
    	boolean retVal =false;
    	PlanFilters entity = repository.findById(id);
		if(null!=entity)
        {
			retVal = repository.deleteData(entity);
			return retVal;
        } else {
            throw new RecordNotFoundException("No student record exist for given id "+id);
        }
    }	

}