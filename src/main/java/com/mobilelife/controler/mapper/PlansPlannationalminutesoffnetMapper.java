package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlannationalminutesoffnetBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlannationalminutesoffnet;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlannationalminutesoffnetMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlannationalminutesoffnetMapper.class);

    public List<PlansPlannationalminutesoffnetBean> mapBean(List<PlansPlannationalminutesoffnet> entityList) {
        List<PlansPlannationalminutesoffnetBean> retBean = new ArrayList<PlansPlannationalminutesoffnetBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlannationalminutesoffnet entity = entityList.get(i);
            PlansPlannationalminutesoffnetBean bean = new PlansPlannationalminutesoffnetBean();
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
    
    public PlansPlannationalminutesoffnetBean mapBean(PlansPlannationalminutesoffnet entity) {
        PlansPlannationalminutesoffnetBean bean = new PlansPlannationalminutesoffnetBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setNationalMinutesOffnet(entity.getNationalMinutesOffnet());
        bean.setNationalMinutesOffnetUnitrate(entity.getNationalMinutesOffnetUnitrate());
        bean.setNationalMinutesRollover(entity.getNationalMinutesRollover());

        return bean;
    }

    public PlansPlannationalminutesoffnet mapBeanToEntity(PlansPlannationalminutesoffnetBean bean, PlansPlannationalminutesoffnet existEntity) {
        PlansPlannationalminutesoffnet updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setNationalMinutesOffnet(bean.getNationalMinutesOffnet());
        updateEntity.setNationalMinutesOffnetUnitrate(bean.getNationalMinutesOffnetUnitrate());
        updateEntity.setNationalMinutesRollover(bean.getNationalMinutesRollover());

        return updateEntity;
    }

    public PlansPlannationalminutesoffnet mapBeanToEntity(PlansPlannationalminutesoffnetBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlannationalminutesoffnet updateEntity = new PlansPlannationalminutesoffnet();
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

