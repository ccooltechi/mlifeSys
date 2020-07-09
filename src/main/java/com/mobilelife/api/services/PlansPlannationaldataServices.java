package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlannationaldataMapper;
import com.mobilelife.controler.mapper.bean.PlansPlannationaldataBean;
import com.mobilelife.persistance.dao.PlansPlannationaldataDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlannationaldata;
import com.mobilelife.persistance.entities.PlansPlanprimary;


public class PlansPlannationaldataServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlannationaldataServices.class);
	PlansPlannationaldataDao repository = new PlansPlannationaldataDao();
	PlansPlannationaldataMapper mapper = new PlansPlannationaldataMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlannationaldataBean getByPlanId(Integer id)
    {
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlannationaldata entity = plansPlanprimaryEntity.getPlansPlannationaldata();
        if(null!=entity) {
        	PlansPlannationaldataBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlannationaldataBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlannationaldata existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlannationaldata entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlannationaldata entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlannationaldata entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}