package com.mobilelife.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlanDevicebrandMapper;
import com.mobilelife.controler.mapper.bean.PlanDevicebrandBean;
import com.mobilelife.persistance.dao.PlanDevicebrandDao;
import com.mobilelife.persistance.entities.PlanDevicebrand;


public class PlanDevicebrandServices {

	private static Logger logger = LoggerFactory.getLogger(PlanDevicebrandServices.class);
	PlanDevicebrandDao repository = new PlanDevicebrandDao();
	PlanDevicebrandMapper mapper = new PlanDevicebrandMapper();
	

	public List<PlanDevicebrandBean> getAll() {
        List<PlanDevicebrand> entityList = repository.findAll();
        List<PlanDevicebrandBean> bean = mapper.mapBean(entityList);
		return bean;
	}

    public PlanDevicebrandBean getById(Integer id)
    {
    	PlanDevicebrand entity = repository.findById(id);
        if(null!=entity) {
        	PlanDevicebrandBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlanDevicebrandBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlanDevicebrand existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlanDevicebrand entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlanDevicebrand entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlanDevicebrand entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }
    
    public boolean delete(Integer id)
    {
    	boolean retVal =false;
    	PlanDevicebrand entity = repository.findById(id);
		if(null!=entity)
        {
			retVal = repository.deleteData(entity);
			return retVal;
        } else {
            throw new RecordNotFoundException("No student record exist for given id "+id);
        }
    }	

}