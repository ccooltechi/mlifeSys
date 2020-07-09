package com.mobilelife.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansOperatorMapper;
import com.mobilelife.controler.mapper.bean.PlansOperatorBean;
import com.mobilelife.persistance.dao.OperatorDao;
import com.mobilelife.persistance.entities.PlansOperator;


public class PlansOperatorServices {

	private static Logger logger = LoggerFactory.getLogger(PlansOperatorServices.class);
	OperatorDao repository = new OperatorDao();
	PlansOperatorMapper mapper = new PlansOperatorMapper();

	public List<PlansOperatorBean> getAll() {
        List<PlansOperator> entityList = repository.findAll();
        List<PlansOperatorBean> bean = mapper.mapBean(entityList);
		return bean;
	}

    public PlansOperatorBean getById(Integer id)
    {
    	PlansOperator entity = repository.findById(id);
    	PlansOperatorBean bean = mapper.mapBean(entity);
        if(null!=entity) {
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansOperatorBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansOperator existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansOperator entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
    			PlansOperator entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
			PlansOperator entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }
    
    public boolean delete(Integer id)
    {
    	boolean retVal =false;
    	PlansOperator entity = repository.findById(id);
		if(null!=entity)
        {
			retVal = repository.deleteData(entity);
			return retVal;
        } else {
            throw new RecordNotFoundException("No student record exist for given id "+id);
        }
    }	

}