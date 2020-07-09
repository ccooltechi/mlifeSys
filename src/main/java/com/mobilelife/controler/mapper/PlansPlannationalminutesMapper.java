package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlannationalminutesBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlannationalminutes;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlannationalminutesMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlannationalminutesMapper.class);

    public List<PlansPlannationalminutesBean> mapBean(List<PlansPlannationalminutes> entityList) {
        List<PlansPlannationalminutesBean> retBean = new ArrayList<PlansPlannationalminutesBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlannationalminutes entity = entityList.get(i);
            PlansPlannationalminutesBean bean = new PlansPlannationalminutesBean();
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
    
    public PlansPlannationalminutesBean mapBean(PlansPlannationalminutes entity) {
        PlansPlannationalminutesBean bean = new PlansPlannationalminutesBean();
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

    public PlansPlannationalminutes mapBeanToEntity(PlansPlannationalminutesBean bean, PlansPlannationalminutes existEntity) {
        PlansPlannationalminutes updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setNationalMinutes(bean.getNationalMinutes());
        updateEntity.setNationalMinutePulse(bean.getNationalMinutePulse());
        updateEntity.setNationalMinutesDiscount(bean.getNationalMinutesDiscount());
        updateEntity.setNationalMinutesUnitrate(bean.getNationalMinutesUnitrate());
        updateEntity.setNationalMinutesWas(bean.getNationalMinutesWas());

        return updateEntity;
    }

    public PlansPlannationalminutes mapBeanToEntity(PlansPlannationalminutesBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlannationalminutes updateEntity = new PlansPlannationalminutes();
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

