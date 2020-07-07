package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanroamingdataMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanroamingdata;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.dao.PlansPlanroamingdataDao;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;
import com.mobilelife.persistance.entities.PlansPlanroamingdataEntity;


public class PlansPlanroamingdataServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanroamingdataServices.class);
//	PlansPlanroamingdataDao repository = new PlansPlanroamingdataDao();
//	PlansPlanroamingdataMapper mapper = new PlansPlanroamingdataMapper();
//	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
//
//    public PlansPlanroamingdata getByPlanId(Integer id)
//    {
//    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
//    	PlansPlanroamingdataEntity entity = plansPlanprimaryEntity.getPlansPlanroamingdata();
//        if(null!=entity) {
//        	PlansPlanroamingdata bean = mapper.mapBean(entity);
//            return bean;
//        } else {
//            throw new RecordNotFoundException("No record exist for given id "+id);
//        }
//    }
//     
//    public boolean createOrUpdate(PlansPlanroamingdata bean)
//    {
//    	boolean retVal = false;
//    	if ((bean.getId()!=null) && (bean.getId()>0))
//    	{
//    		PlansPlanroamingdataEntity existEntity = repository.findById(bean.getId());
//    		if(null!=existEntity)
//	        {
//    			PlansPlanroamingdataEntity entity = mapper.mapBeanToEntity(bean, existEntity);
//	            retVal = repository.updateData(entity);
//	            return retVal;
//	        } else {
//	        	PlansPlanroamingdataEntity entity = mapper.mapBeanToEntity(bean);
//    			int id = repository.findId()+1;
//    			entity.setId(id);		
//	        	retVal = repository.saveData(entity);
//	            return retVal;
//	        }
//    	}
//    	else
//    	{
//    		PlansPlanroamingdataEntity entity = mapper.mapBeanToEntity(bean);
//			int id = repository.findId()+1;
//			entity.setId(id);		
//    		retVal = repository.saveData(entity);
//    		return retVal;
//    	}	    
//    }


}