package com.mobilelife.controler.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlansPlanroamingdataMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanroamingdataMapper.class);

//    public List<PlansPlanroamingdata> mapBean(List<PlansPlanroamingdataEntity> entityList) {
//        List<PlansPlanroamingdata> retBean = new ArrayList<PlansPlanroamingdata>();
//        for (int i=0; i<entityList.size();i++)
//        {
//            PlansPlanroamingdataEntity entity = entityList.get(i);
//            PlansPlanroamingdata bean = new PlansPlanroamingdata();
//            bean.setId(entity.getId());
//            bean.setIsActive(entity.getIsActive());
//            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
//
//            retBean.add(bean);
//        }
//        return retBean;
//    }
//    
//    public PlansPlanroamingdata mapBean(PlansPlanroamingdataEntity entity) {
//        PlansPlanroamingdata bean = new PlansPlanroamingdata();
//        bean.setId(entity.getId());
//        bean.setIsActive(entity.getIsActive());
//        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
//
//        return bean;
//    }
//
//    public PlansPlanroamingdataEntity mapBeanToEntity(PlansPlanroamingdata bean, PlansPlanroamingdataEntity existEntity) {
//        PlansPlanroamingdataEntity updateEntity = existEntity;
//        updateEntity.setIsActive(bean.getIsActive());
//        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
//
//        return updateEntity;
//    }
//
//    public PlansPlanroamingdataEntity mapBeanToEntity(PlansPlanroamingdata bean) {
//        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
//        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
//        PlansPlanroamingdataEntity updateEntity = new PlansPlanroamingdataEntity();
//        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
//        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
//        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
//        updateEntity.setIsActive(bean.getIsActive());
//
//        return updateEntity;
//    }
}

