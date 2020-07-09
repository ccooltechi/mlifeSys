package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlaninternationalminutesBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlaninternationalminutes;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlaninternationalminutesMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalminutesMapper.class);

    public List<PlansPlaninternationalminutesBean> mapBean(List<PlansPlaninternationalminutes> entityList) {
        List<PlansPlaninternationalminutesBean> retBean = new ArrayList<PlansPlaninternationalminutesBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlaninternationalminutes entity = entityList.get(i);
            PlansPlaninternationalminutesBean bean = new PlansPlaninternationalminutesBean();
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
    
    public PlansPlaninternationalminutesBean mapBean(PlansPlaninternationalminutes entity) {
        PlansPlaninternationalminutesBean bean = new PlansPlaninternationalminutesBean();
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

    public PlansPlaninternationalminutes mapBeanToEntity(PlansPlaninternationalminutesBean bean, PlansPlaninternationalminutes existEntity) {
        PlansPlaninternationalminutes updateEntity = existEntity;
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

    public PlansPlaninternationalminutes mapBeanToEntity(PlansPlaninternationalminutesBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlaninternationalminutes updateEntity = new PlansPlaninternationalminutes();
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

