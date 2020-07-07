package com.mobilelife.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansOperatorMapper;
import com.mobilelife.controler.mapper.bean.PlansOperator;
import com.mobilelife.persistance.dao.OperatorDao;
import com.mobilelife.persistance.entities.PlansOperatorEntity;


public class PlansOperatorServices {

	private static Logger logger = LoggerFactory.getLogger(PlansOperatorServices.class);
	OperatorDao repository = new OperatorDao();
	PlansOperatorMapper mapper = new PlansOperatorMapper();

	public List<PlansOperator> getAll() {
        List<PlansOperatorEntity> entityList = repository.findAll();
        List<PlansOperator> bean = mapper.mapBean(entityList);
		return bean;
	}

    public PlansOperator getById(Integer id)
    {
    	PlansOperatorEntity entity = repository.findById(id);
    	PlansOperator bean = mapper.mapBean(entity);
        if(null!=entity) {
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansOperator bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansOperatorEntity existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansOperatorEntity entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
    			PlansOperatorEntity entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
			PlansOperatorEntity entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }
    
    public boolean delete(Integer id)
    {
    	boolean retVal =false;
    	PlansOperatorEntity entity = repository.findById(id);
		if(null!=entity)
        {
			retVal = repository.deleteData(entity);
			return retVal;
        } else {
            throw new RecordNotFoundException("No student record exist for given id "+id);
        }
    }	

}