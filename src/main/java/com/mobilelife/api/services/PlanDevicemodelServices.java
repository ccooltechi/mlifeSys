package com.mobilelife.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlanDevicemodelMapper;
import com.mobilelife.controler.mapper.bean.PlanDevicemodelBean;
import com.mobilelife.persistance.dao.PlanDevicemodelDao;
import com.mobilelife.persistance.entities.PlanDevicemodel;


public class PlanDevicemodelServices {

	private static Logger logger = LoggerFactory.getLogger(PlanDevicemodelServices.class);
	PlanDevicemodelDao repository = new PlanDevicemodelDao();
	PlanDevicemodelMapper mapper = new PlanDevicemodelMapper();

	public List<PlanDevicemodelBean> getAll() {
        List<PlanDevicemodel> entityList = repository.findAll();
        List<PlanDevicemodelBean> bean = mapper.mapBean(entityList);
		return bean;
	}

    public PlanDevicemodelBean getById(Integer id)
    {
    	PlanDevicemodel entity = repository.findById(id);
    	PlanDevicemodelBean bean = mapper.mapBean(entity);
        if(null!=entity) {
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlanDevicemodelBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlanDevicemodel existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlanDevicemodel entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlanDevicemodel entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlanDevicemodel entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }
    
    public boolean delete(Integer id)
    {
    	boolean retVal =false;
    	PlanDevicemodel entity = repository.findById(id);
		if(null!=entity)
        {
			retVal = repository.deleteData(entity);
			return retVal;
        } else {
            throw new RecordNotFoundException("No student record exist for given id "+id);
        }
    }	

}