package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlannationalminutesoffnet;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlannationalminutesoffnetEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansPlannationalminutesoffnetMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlannationalminutesoffnetMapper.class);

    public List<PlansPlannationalminutesoffnet> mapBean(List<PlansPlannationalminutesoffnetEntity> entityList) {
        List<PlansPlannationalminutesoffnet> retBean = new ArrayList<PlansPlannationalminutesoffnet>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlannationalminutesoffnetEntity entity = entityList.get(i);
            PlansPlannationalminutesoffnet bean = new PlansPlannationalminutesoffnet();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setNationalMinutesOffnet(entity.getNationalMinutesOffnet());
            bean.setNationalMinutesOffnetUnitrate(entity.getNationalMinutesOffnetUnitrate());
            bean.setNationalMinutesRollover(entity.getNationalMinutesRollover());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlannationalminutesoffnet mapBean(PlansPlannationalminutesoffnetEntity entity) {
        PlansPlannationalminutesoffnet bean = new PlansPlannationalminutesoffnet();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setNationalMinutesOffnet(entity.getNationalMinutesOffnet());
        bean.setNationalMinutesOffnetUnitrate(entity.getNationalMinutesOffnetUnitrate());
        bean.setNationalMinutesRollover(entity.getNationalMinutesRollover());

        return bean;
    }

    public PlansPlannationalminutesoffnetEntity mapBeanToEntity(PlansPlannationalminutesoffnet bean, PlansPlannationalminutesoffnetEntity existEntity) {
        PlansPlannationalminutesoffnetEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setNationalMinutesOffnet(bean.getNationalMinutesOffnet());
        updateEntity.setNationalMinutesOffnetUnitrate(bean.getNationalMinutesOffnetUnitrate());
        updateEntity.setNationalMinutesRollover(bean.getNationalMinutesRollover());

        return updateEntity;
    }

    public PlansPlannationalminutesoffnetEntity mapBeanToEntity(PlansPlannationalminutesoffnet bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlannationalminutesoffnetEntity updateEntity = new PlansPlannationalminutesoffnetEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setNationalMinutesOffnet(bean.getNationalMinutesOffnet());
        updateEntity.setNationalMinutesOffnetUnitrate(bean.getNationalMinutesOffnetUnitrate());
        updateEntity.setNationalMinutesRollover(bean.getNationalMinutesRollover());

        return updateEntity;
    }
}

