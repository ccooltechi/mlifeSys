package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlannationalminutes;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlannationalminutesEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansPlannationalminutesMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlannationalminutesMapper.class);

    public List<PlansPlannationalminutes> mapBean(List<PlansPlannationalminutesEntity> entityList) {
        List<PlansPlannationalminutes> retBean = new ArrayList<PlansPlannationalminutes>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlannationalminutesEntity entity = entityList.get(i);
            PlansPlannationalminutes bean = new PlansPlannationalminutes();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setNationalMinutes(entity.getNationalMinutes());
            bean.setNationalMinutePulse(entity.getNationalMinutePulse());
            bean.setNationalMinutesDiscount(entity.getNationalMinutesDiscount());
            bean.setNationalMinutesUnitrate(entity.getNationalMinutesUnitrate());
            bean.setNationalMinutesWas(entity.getNationalMinutesWas());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlannationalminutes mapBean(PlansPlannationalminutesEntity entity) {
        PlansPlannationalminutes bean = new PlansPlannationalminutes();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setNationalMinutes(entity.getNationalMinutes());
        bean.setNationalMinutePulse(entity.getNationalMinutePulse());
        bean.setNationalMinutesDiscount(entity.getNationalMinutesDiscount());
        bean.setNationalMinutesUnitrate(entity.getNationalMinutesUnitrate());
        bean.setNationalMinutesWas(entity.getNationalMinutesWas());

        return bean;
    }

    public PlansPlannationalminutesEntity mapBeanToEntity(PlansPlannationalminutes bean, PlansPlannationalminutesEntity existEntity) {
        PlansPlannationalminutesEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setNationalMinutes(bean.getNationalMinutes());
        updateEntity.setNationalMinutePulse(bean.getNationalMinutePulse());
        updateEntity.setNationalMinutesDiscount(bean.getNationalMinutesDiscount());
        updateEntity.setNationalMinutesUnitrate(bean.getNationalMinutesUnitrate());
        updateEntity.setNationalMinutesWas(bean.getNationalMinutesWas());

        return updateEntity;
    }

    public PlansPlannationalminutesEntity mapBeanToEntity(PlansPlannationalminutes bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlannationalminutesEntity updateEntity = new PlansPlannationalminutesEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setNationalMinutes(bean.getNationalMinutes());
        updateEntity.setNationalMinutePulse(bean.getNationalMinutePulse());
        updateEntity.setNationalMinutesDiscount(bean.getNationalMinutesDiscount());
        updateEntity.setNationalMinutesUnitrate(bean.getNationalMinutesUnitrate());
        updateEntity.setNationalMinutesWas(bean.getNationalMinutesWas());

        return updateEntity;
    }
}

