package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlaninternationalminutes;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlaninternationalminutesEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansPlaninternationalminutesMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalminutesMapper.class);

    public List<PlansPlaninternationalminutes> mapBean(List<PlansPlaninternationalminutesEntity> entityList) {
        List<PlansPlaninternationalminutes> retBean = new ArrayList<PlansPlaninternationalminutes>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlaninternationalminutesEntity entity = entityList.get(i);
            PlansPlaninternationalminutes bean = new PlansPlaninternationalminutes();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setCallingCardBucket(entity.getCallingCardBucket());
            bean.setInternational_minutes_unitrate(entity.getInternational_minutes_unitrate());
            bean.setInternationalMinBucketcode(entity.getInternationalMinBucketcode());
            bean.setInternationalMinutePulse(entity.getInternationalMinutePulse());
            bean.setInternationalMinutes(entity.getInternationalMinutes());
            bean.setInternationalMinutesRollover(entity.getInternationalMinutesRollover());
            bean.setNetworkSpecificCalling(entity.getNetworkSpecificCalling());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlaninternationalminutes mapBean(PlansPlaninternationalminutesEntity entity) {
        PlansPlaninternationalminutes bean = new PlansPlaninternationalminutes();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setCallingCardBucket(entity.getCallingCardBucket());
        bean.setInternational_minutes_unitrate(entity.getInternational_minutes_unitrate());
        bean.setInternationalMinBucketcode(entity.getInternationalMinBucketcode());
        bean.setInternationalMinutePulse(entity.getInternationalMinutePulse());
        bean.setInternationalMinutes(entity.getInternationalMinutes());
        bean.setInternationalMinutesRollover(entity.getInternationalMinutesRollover());
        bean.setNetworkSpecificCalling(entity.getNetworkSpecificCalling());

        return bean;
    }

    public PlansPlaninternationalminutesEntity mapBeanToEntity(PlansPlaninternationalminutes bean, PlansPlaninternationalminutesEntity existEntity) {
        PlansPlaninternationalminutesEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setCallingCardBucket(bean.getCallingCardBucket());
        updateEntity.setInternational_minutes_unitrate(bean.getInternational_minutes_unitrate());
        updateEntity.setInternationalMinBucketcode(bean.getInternationalMinBucketcode());
        updateEntity.setInternationalMinutePulse(bean.getInternationalMinutePulse());
        updateEntity.setInternationalMinutes(bean.getInternationalMinutes());
        updateEntity.setInternationalMinutesRollover(bean.getInternationalMinutesRollover());
        updateEntity.setNetworkSpecificCalling(bean.getNetworkSpecificCalling());

        return updateEntity;
    }

    public PlansPlaninternationalminutesEntity mapBeanToEntity(PlansPlaninternationalminutes bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlaninternationalminutesEntity updateEntity = new PlansPlaninternationalminutesEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setCallingCardBucket(bean.getCallingCardBucket());
        updateEntity.setInternational_minutes_unitrate(bean.getInternational_minutes_unitrate());
        updateEntity.setInternationalMinBucketcode(bean.getInternationalMinBucketcode());
        updateEntity.setInternationalMinutePulse(bean.getInternationalMinutePulse());
        updateEntity.setInternationalMinutes(bean.getInternationalMinutes());
        updateEntity.setInternationalMinutesRollover(bean.getInternationalMinutesRollover());
        updateEntity.setNetworkSpecificCalling(bean.getNetworkSpecificCalling());

        return updateEntity;
    }
}

