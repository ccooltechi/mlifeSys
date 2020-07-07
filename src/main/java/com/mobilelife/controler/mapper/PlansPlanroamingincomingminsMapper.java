package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanroamingincomingmins;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;
import com.mobilelife.persistance.entities.PlansPlanroamingincomingminsEntity;

public class PlansPlanroamingincomingminsMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanroamingincomingminsMapper.class);

    public List<PlansPlanroamingincomingmins> mapBean(List<PlansPlanroamingincomingminsEntity> entityList) {
        List<PlansPlanroamingincomingmins> retBean = new ArrayList<PlansPlanroamingincomingmins>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanroamingincomingminsEntity entity = entityList.get(i);
            PlansPlanroamingincomingmins bean = new PlansPlanroamingincomingmins();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setRoamingIncomingBucketcode(entity.getRoamingIncomingBucketcode());
            bean.setRoamingIncomingMins(entity.getRoamingIncomingMins());

            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanroamingincomingmins mapBean(PlansPlanroamingincomingminsEntity entity) {
        PlansPlanroamingincomingmins bean = new PlansPlanroamingincomingmins();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setRoamingIncomingBucketcode(entity.getRoamingIncomingBucketcode());
        bean.setRoamingIncomingMins(entity.getRoamingIncomingMins());

        return bean;
    }

    public PlansPlanroamingincomingminsEntity mapBeanToEntity(PlansPlanroamingincomingmins bean, PlansPlanroamingincomingminsEntity existEntity) {
        PlansPlanroamingincomingminsEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setRoamingIncomingBucketcode(bean.getRoamingIncomingBucketcode());
        updateEntity.setRoamingIncomingMins(bean.getRoamingIncomingMins());

        return updateEntity;
    }

    public PlansPlanroamingincomingminsEntity mapBeanToEntity(PlansPlanroamingincomingmins bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanroamingincomingminsEntity updateEntity = new PlansPlanroamingincomingminsEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setRoamingIncomingBucketcode(bean.getRoamingIncomingBucketcode());
        updateEntity.setRoamingIncomingMins(bean.getRoamingIncomingMins());

        return updateEntity;
    }
}

