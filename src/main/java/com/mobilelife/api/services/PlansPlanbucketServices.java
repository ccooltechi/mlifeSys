package com.mobilelife.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.api.exception.RecordNotFoundException;
import com.mobilelife.controler.mapper.PlansPlanbucketMapper;
import com.mobilelife.controler.mapper.bean.PlansPlanbucketBean;
import com.mobilelife.persistance.dao.PlansPlanBucketDao;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanbucket;
import com.mobilelife.persistance.entities.PlansPlanprimary;


public class PlansPlanbucketServices {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanbucketServices.class);
	PlansPlanBucketDao repository = new PlansPlanBucketDao();
	PlansPlanbucketMapper mapper = new PlansPlanbucketMapper();
	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();

//    public PlansPlanbucket getByPlanId(Integer id)
//    {
//    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(id);
//    	PlansPlanbucketEntity entity = plansPlanprimaryEntity.getPlansPlanBucket();
//        if(null!=entity) {
//        	PlansPlanbucket bean = mapper.mapBean(entity);
//            return bean;
//        } else {
//            throw new RecordNotFoundException("No record exist for given id "+id);
//        }
//    }
//     
//    public boolean createOrUpdate(PlansPlanbucket bean)
//    {
//    	boolean retVal = false;
//    	if ((bean.getId()!=null) && (bean.getId()>0))
//    	{
//    		PlansPlanbucketEntity existEntity = repository.findById(bean.getId());
//    		if(null!=existEntity)
//	        {
//    			PlansPlanbucketEntity entity = mapper.mapBeanToEntity(bean, existEntity);
//	            retVal = repository.updateData(entity);
//	            return retVal;
//	        } else {
//	        	PlansPlanbucketEntity entity = mapper.mapBeanToEntity(bean);
//    			int id = repository.findId()+1;
//    			entity.setId(id);		
//	        	retVal = repository.saveData(entity);
//	            return retVal;
//	        }
//    	}
//    	else
//    	{
//    		PlansPlanbucketEntity entity = mapper.mapBeanToEntity(bean);
//			int id = repository.findId()+1;
//			entity.setId(id);		
//    		retVal = repository.saveData(entity);
//    		return retVal;
//    	}	    
//    }


}