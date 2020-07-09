package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlannationalminutesonnetBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlannationalminutesonnet;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlannationalminutesonnetMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlannationalminutesonnetMapper.class);

    public List<PlansPlannationalminutesonnetBean> mapBean(List<PlansPlannationalminutesonnet> entityList) {
        List<PlansPlannationalminutesonnetBean> retBean = new ArrayList<PlansPlannationalminutesonnetBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlannationalminutesonnet entity = entityList.get(i);
            PlansPlannationalminutesonnetBean bean = new PlansPlannationalminutesonnetBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setNationalMinutesOnnet(entity.getNationalMinutesOnnet());
            bean.setNationalMinutesOnnetUnitrate(entity.getNationalMinutesOnnetUnitrate());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlannationalminutesonnetBean mapBean(PlansPlannationalminutesonnet entity) {
        PlansPlannationalminutesonnetBean bean = new PlansPlannationalminutesonnetBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setNationalMinutesOnnet(entity.getNationalMinutesOnnet());
        bean.setNationalMinutesOnnetUnitrate(entity.getNationalMinutesOnnetUnitrate());

        return bean;
    }

    public PlansPlannationalminutesonnet mapBeanToEntity(PlansPlannationalminutesonnetBean bean, PlansPlannationalminutesonnet existEntity) {
        PlansPlannationalminutesonnet updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setNationalMinutesOnnet(bean.getNationalMinutesOnnet());
        updateEntity.setNationalMinutesOnnetUnitrate(bean.getNationalMinutesOnnetUnitrate());

        return updateEntity;
    }

    public PlansPlannationalminutesonnet mapBeanToEntity(PlansPlannationalminutesonnetBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlannationalminutesonnet updateEntity = new PlansPlannationalminutesonnet();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setNationalMinutesOnnet(bean.getNationalMinutesOnnet());
        updateEntity.setNationalMinutesOnnetUnitrate(bean.getNationalMinutesOnnetUnitrate());

        return updateEntity;
    }
}

