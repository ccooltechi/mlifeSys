package com.mobilelife.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlanDevicecolorMapper;
import com.mobilelife.controler.mapper.bean.PlanDevicecolorBean;
import com.mobilelife.persistance.dao.PlanDevicecolorDao;
import com.mobilelife.persistance.entities.PlanDevicecolor;


public class PlanDevicecolorServices {

	private static Logger logger = LoggerFactory.getLogger(PlanDevicecolorServices.class);
	PlanDevicecolorDao repository = new PlanDevicecolorDao();
	PlanDevicecolorMapper mapper = new PlanDevicecolorMapper();

	public List<PlanDevicecolorBean> getAll() {
        List<PlanDevicecolor> entityList = repository.findAll();
        List<PlanDevicecolorBean> bean = mapper.mapBean(entityList);
		return bean;
	}

    public PlanDevicecolorBean getById(Integer id)
    {
    	PlanDevicecolor entity = repository.findById(id);
        if(null!=entity) {
        	PlanDevicecolorBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlanDevicecolorBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlanDevicecolor existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlanDevicecolor entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlanDevicecolor entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlanDevicecolor entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }
    
    public boolean delete(Integer id)
    {
    	boolean retVal =false;
    	PlanDevicecolor entity = repository.findById(id);
		if(null!=entity)
        {
			retVal = repository.deleteData(entity);
			return retVal;
        } else {
            throw new RecordNotFoundException("No student record exist for given id "+id);
        }
    }	
	
}