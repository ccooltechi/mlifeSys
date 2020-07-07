package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlannationalminutesonnet;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlannationalminutesonnetEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansPlannationalminutesonnetMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlannationalminutesonnetMapper.class);

    public List<PlansPlannationalminutesonnet> mapBean(List<PlansPlannationalminutesonnetEntity> entityList) {
        List<PlansPlannationalminutesonnet> retBean = new ArrayList<PlansPlannationalminutesonnet>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlannationalminutesonnetEntity entity = entityList.get(i);
            PlansPlannationalminutesonnet bean = new PlansPlannationalminutesonnet();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setNationalMinutesOnnet(entity.getNationalMinutesOnnet());
            bean.setNationalMinutesOnnetUnitrate(entity.getNationalMinutesOnnetUnitrate());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlannationalminutesonnet mapBean(PlansPlannationalminutesonnetEntity entity) {
        PlansPlannationalminutesonnet bean = new PlansPlannationalminutesonnet();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setNationalMinutesOnnet(entity.getNationalMinutesOnnet());
        bean.setNationalMinutesOnnetUnitrate(entity.getNationalMinutesOnnetUnitrate());

        return bean;
    }

    public PlansPlannationalminutesonnetEntity mapBeanToEntity(PlansPlannationalminutesonnet bean, PlansPlannationalminutesonnetEntity existEntity) {
        PlansPlannationalminutesonnetEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setNationalMinutesOnnet(bean.getNationalMinutesOnnet());
        updateEntity.setNationalMinutesOnnetUnitrate(bean.getNationalMinutesOnnetUnitrate());

        return updateEntity;
    }

    public PlansPlannationalminutesonnetEntity mapBeanToEntity(PlansPlannationalminutesonnet bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlannationalminutesonnetEntity updateEntity = new PlansPlannationalminutesonnetEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setNationalMinutesOnnet(bean.getNationalMinutesOnnet());
        updateEntity.setNationalMinutesOnnetUnitrate(bean.getNationalMinutesOnnetUnitrate());

        return updateEntity;
    }
}

