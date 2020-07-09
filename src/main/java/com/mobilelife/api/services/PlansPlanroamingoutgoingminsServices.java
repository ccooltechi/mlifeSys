package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanroamingoutgoingminsMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanroamingoutgoingminsBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.dao.PlansPlanroamingoutgoingminsDao;
import com.mobilelife.persistance.entities.PlansPlanprimary;
import com.mobilelife.persistance.entities.PlansPlanroamingoutgoingmins;


public class PlansPlanroamingoutgoingminsServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanroamingoutgoingminsServices.class);
	PlansPlanroamingoutgoingminsDao repository = new PlansPlanroamingoutgoingminsDao();
	PlansPlanroamingoutgoingminsMapper mapper = new PlansPlanroamingoutgoingminsMapper();

	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

    public PlansPlanroamingoutgoingminsBean getByPlanId(Integer id)
    {
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(id);
    	PlansPlanroamingoutgoingmins entity = plansPlanprimaryEntity.getPlansPlanroamingoutgoingmins();
        if(null!=entity) {
        	PlansPlanroamingoutgoingminsBean bean = mapper.mapBean(entity);
            return bean;
        } else {
            throw new RecordNotFoundException("No record exist for given id "+id);
        }
    }
     
    public boolean createOrUpdate(PlansPlanroamingoutgoingminsBean bean)
    {
    	boolean retVal = false;
    	if ((bean.getId()!=null) && (bean.getId()>0))
    	{
    		PlansPlanroamingoutgoingmins existEntity = repository.findById(bean.getId());
    		if(null!=existEntity)
	        {
    			PlansPlanroamingoutgoingmins entity = mapper.mapBeanToEntity(bean, existEntity);
	            retVal = repository.updateData(entity);
	            return retVal;
	        } else {
	        	PlansPlanroamingoutgoingmins entity = mapper.mapBeanToEntity(bean);
    			int id = repository.findId()+1;
    			entity.setId(id);		
	        	retVal = repository.saveData(entity);
	            return retVal;
	        }
    	}
    	else
    	{
    		PlansPlanroamingoutgoingmins entity = mapper.mapBeanToEntity(bean);
			int id = repository.findId()+1;
			entity.setId(id);		
    		retVal = repository.saveData(entity);
    		return retVal;
    	}	    
    }


}