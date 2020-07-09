package com.mobilelife.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanprimaryMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanprimaryBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryLocaleDao;
import com.mobilelife.persistance.entities.PlansPlanprimary;
import com.mobilelife.persistance.entities.PlansPlanprimaryLocale;


public class PlansPlanprimaryServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanprimaryServices.class);
	PlansPlanprimaryDao repository = new PlansPlanprimaryDao();
	PlansPlanprimaryLocaleDao localerepository = new PlansPlanprimaryLocaleDao();
	PlansPlanprimaryMapper mapper = new PlansPlanprimaryMapper();

	public List<PlansPlanprimaryBean> getAll(int pageno, int resultperpage, int operatorid, int plantype) {
        List<PlansPlanprimary> entityList = repository.findAll(pageno, resultperpage, operatorid, plantype);
        List<PlansPlanprimaryBean> bean = mapper.mapBean(entityList);
		return bean;
	}

    public PlansPlanprimaryBean getById(Integer id)
    {
    	PlansPlanprimary entity = repository.findById(id);
    	PlansPlanprimaryBean bean = mapper.mapBean(entity);
        if(null!=entity) {
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public Integer createOrUpdate(PlansPlanprimaryBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlanprimary existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlanprimary entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return entity.getId();
	        } else {
	        	PlansPlanprimary entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return entity.getId();
	        }
    	}
    	else
    	{
    		PlansPlanprimary entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		PlansPlanprimaryLocale localeentity = mapper.mapLocaleBeanToEntity(bean);
			id = localerepository.findId()+1;
			localeentity.setId(id);		

    		return entity.getId();
    	}	    
    }
    
    public boolean delete(Integer id)
    {
    	boolean retVal =false;
    	PlansPlanprimary entity = repository.findById(id);
		if(null!=entity)
        {
			retVal = repository.deleteData(entity);
			return retVal;
        } else {
            throw new RecordNotFoundException("No student record exist for given id "+id);
        }
    }	

}