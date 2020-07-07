package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanflexi;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanflexiEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansPlanflexiMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanflexiMapper.class);

    public List<PlansPlanflexi> mapBean(List<PlansPlanflexiEntity> entityList) {
        List<PlansPlanflexi> retBean = new ArrayList<PlansPlanflexi>();
        for (int i=0; i<entityList.size();i++)
        {
        	PlansPlanflexiEntity entity = entityList.get(i);
            PlansPlanflexi bean = new PlansPlanflexi();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setFlexiMinutes(entity.getFlexiMinutes());
            bean.setFlexiMinutesDiscount(entity.getFlexiMinutesDiscount());
            bean.setFlexiMinutesPulse(entity.getFlexiMinutesPulse());
            bean.setFlexiMinutesRollover(entity.getFlexiMinutesRollover());
            bean.setFlexiMinutesSms(entity.getFlexiMinutesSms());
            bean.setFlexiMinutesWas(entity.getFlexiMinutesWas());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanflexi mapBean(PlansPlanflexiEntity entity) {
    	PlansPlanflexi bean = new PlansPlanflexi();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setFlexiMinutes(entity.getFlexiMinutes());
        bean.setFlexiMinutesDiscount(entity.getFlexiMinutesDiscount());
        bean.setFlexiMinutesPulse(entity.getFlexiMinutesPulse());
        bean.setFlexiMinutesRollover(entity.getFlexiMinutesRollover());
        bean.setFlexiMinutesSms(entity.getFlexiMinutesSms());
        bean.setFlexiMinutesWas(entity.getFlexiMinutesWas());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());

        return bean;
    }

    public PlansPlanflexiEntity mapBeanToEntity(PlansPlanflexi bean, PlansPlanflexiEntity existEntity) {
    	PlansPlanflexiEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setFlexiMinutes(bean.getFlexiMinutes());
        updateEntity.setFlexiMinutesDiscount(bean.getFlexiMinutesDiscount());
        updateEntity.setFlexiMinutesPulse(bean.getFlexiMinutesPulse());
        updateEntity.setFlexiMinutesRollover(bean.getFlexiMinutesRollover());
        updateEntity.setFlexiMinutesSms(bean.getFlexiMinutesSms());
        updateEntity.setFlexiMinutesWas(bean.getFlexiMinutesWas());

        return updateEntity;
    }

    public PlansPlanflexiEntity mapBeanToEntity(PlansPlanflexi bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanflexiEntity updateEntity = new PlansPlanflexiEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setFlexiMinutes(bean.getFlexiMinutes());
        updateEntity.setFlexiMinutesDiscount(bean.getFlexiMinutesDiscount());
        updateEntity.setFlexiMinutesPulse(bean.getFlexiMinutesPulse());
        updateEntity.setFlexiMinutesRollover(bean.getFlexiMinutesRollover());
        updateEntity.setFlexiMinutesSms(bean.getFlexiMinutesSms());
        updateEntity.setFlexiMinutesWas(bean.getFlexiMinutesWas());

        return updateEntity;
    }
}

