package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanroamingoutgoingmins;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;
import com.mobilelife.persistance.entities.PlansPlanroamingoutgoingminsEntity;

public class PlansPlanroamingoutgoingminsMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanroamingoutgoingminsMapper.class);

    public List<PlansPlanroamingoutgoingmins> mapBean(List<PlansPlanroamingoutgoingminsEntity> entityList) {
        List<PlansPlanroamingoutgoingmins> retBean = new ArrayList<PlansPlanroamingoutgoingmins>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanroamingoutgoingminsEntity entity = entityList.get(i);
            PlansPlanroamingoutgoingmins bean = new PlansPlanroamingoutgoingmins();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setRoamingOutgoingBucketcode(entity.getRoamingOutgoingBucketcode());
            bean.setRoamingOutgoingMins(entity.getRoamingOutgoingMins());
            bean.setRoamingOutgoingMinsPulse(entity.getRoamingOutgoingMinsPulse());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanroamingoutgoingmins mapBean(PlansPlanroamingoutgoingminsEntity entity) {
        PlansPlanroamingoutgoingmins bean = new PlansPlanroamingoutgoingmins();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setRoamingOutgoingBucketcode(entity.getRoamingOutgoingBucketcode());
        bean.setRoamingOutgoingMins(entity.getRoamingOutgoingMins());
        bean.setRoamingOutgoingMinsPulse(entity.getRoamingOutgoingMinsPulse());

        return bean;
    }

    public PlansPlanroamingoutgoingminsEntity mapBeanToEntity(PlansPlanroamingoutgoingmins bean, PlansPlanroamingoutgoingminsEntity existEntity) {
        PlansPlanroamingoutgoingminsEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setRoamingOutgoingBucketcode(bean.getRoamingOutgoingBucketcode());
        updateEntity.setRoamingOutgoingMins(bean.getRoamingOutgoingMins());
        updateEntity.setRoamingOutgoingMinsPulse(bean.getRoamingOutgoingMinsPulse());

        return updateEntity;
    }

    public PlansPlanroamingoutgoingminsEntity mapBeanToEntity(PlansPlanroamingoutgoingmins bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanroamingoutgoingminsEntity updateEntity = new PlansPlanroamingoutgoingminsEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setRoamingOutgoingBucketcode(bean.getRoamingOutgoingBucketcode());
        updateEntity.setRoamingOutgoingMins(bean.getRoamingOutgoingMins());
        updateEntity.setRoamingOutgoingMinsPulse(bean.getRoamingOutgoingMinsPulse());

        return updateEntity;
    }
}

