package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanflexiBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanflexi;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlanflexiMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanflexiMapper.class);

    public List<PlansPlanflexiBean> mapBean(List<PlansPlanflexi> entityList) {
        List<PlansPlanflexiBean> retBean = new ArrayList<PlansPlanflexiBean>();
        for (int i=0; i<entityList.size();i++)
        {
        	PlansPlanflexi entity = entityList.get(i);
            PlansPlanflexiBean bean = new PlansPlanflexiBean();
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
    
    public PlansPlanflexiBean mapBean(PlansPlanflexi entity) {
    	PlansPlanflexiBean bean = new PlansPlanflexiBean();
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

    public PlansPlanflexi mapBeanToEntity(PlansPlanflexiBean bean, PlansPlanflexi existEntity) {
    	PlansPlanflexi updateEntity = existEntity;
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

    public PlansPlanflexi mapBeanToEntity(PlansPlanflexiBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanflexi updateEntity = new PlansPlanflexi();
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

