package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanroamingincomingminsBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanprimary;
import com.mobilelife.persistance.entities.PlansPlanroamingincomingmins;

public class PlansPlanroamingincomingminsMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanroamingincomingminsMapper.class);

    public List<PlansPlanroamingincomingminsBean> mapBean(List<PlansPlanroamingincomingmins> entityList) {
        List<PlansPlanroamingincomingminsBean> retBean = new ArrayList<PlansPlanroamingincomingminsBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanroamingincomingmins entity = entityList.get(i);
            PlansPlanroamingincomingminsBean bean = new PlansPlanroamingincomingminsBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setRoamingIncomingBucketcode(entity.getRoamingIncomingBucketcode());
            bean.setRoamingIncomingMins(entity.getRoamingIncomingMins());

            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanroamingincomingminsBean mapBean(PlansPlanroamingincomingmins entity) {
        PlansPlanroamingincomingminsBean bean = new PlansPlanroamingincomingminsBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setRoamingIncomingBucketcode(entity.getRoamingIncomingBucketcode());
        bean.setRoamingIncomingMins(entity.getRoamingIncomingMins());

        return bean;
    }

    public PlansPlanroamingincomingmins mapBeanToEntity(PlansPlanroamingincomingminsBean bean, PlansPlanroamingincomingmins existEntity) {
        PlansPlanroamingincomingmins updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setRoamingIncomingBucketcode(bean.getRoamingIncomingBucketcode());
        updateEntity.setRoamingIncomingMins(bean.getRoamingIncomingMins());

        return updateEntity;
    }

    public PlansPlanroamingincomingmins mapBeanToEntity(PlansPlanroamingincomingminsBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanroamingincomingmins updateEntity = new PlansPlanroamingincomingmins();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setRoamingIncomingBucketcode(bean.getRoamingIncomingBucketcode());
        updateEntity.setRoamingIncomingMins(bean.getRoamingIncomingMins());

        return updateEntity;
    }
}

