package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanlocalvideocall;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanlocalvideocallEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansPlanlocalvideocallMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanlocalvideocallMapper.class);

    public List<PlansPlanlocalvideocall> mapBean(List<PlansPlanlocalvideocallEntity> entityList) {
        List<PlansPlanlocalvideocall> retBean = new ArrayList<PlansPlanlocalvideocall>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanlocalvideocallEntity entity = entityList.get(i);
            PlansPlanlocalvideocall bean = new PlansPlanlocalvideocall();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setLocalVideoCall(entity.getLocalVideoCall());
            bean.setLocalVideoCallUnitrate(entity.getLocalVideoCallUnitrate());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanlocalvideocall mapBean(PlansPlanlocalvideocallEntity entity) {
        PlansPlanlocalvideocall bean = new PlansPlanlocalvideocall();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setLocalVideoCall(entity.getLocalVideoCall());
        bean.setLocalVideoCallUnitrate(entity.getLocalVideoCallUnitrate());

        return bean;
    }

    public PlansPlanlocalvideocallEntity mapBeanToEntity(PlansPlanlocalvideocall bean, PlansPlanlocalvideocallEntity existEntity) {
        PlansPlanlocalvideocallEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLocalVideoCall(bean.getLocalVideoCall());
        updateEntity.setLocalVideoCallUnitrate(bean.getLocalVideoCallUnitrate());

        return updateEntity;
    }

    public PlansPlanlocalvideocallEntity mapBeanToEntity(PlansPlanlocalvideocall bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanlocalvideocallEntity updateEntity = new PlansPlanlocalvideocallEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLocalVideoCall(bean.getLocalVideoCall());
        updateEntity.setLocalVideoCallUnitrate(bean.getLocalVideoCallUnitrate());

        return updateEntity;
    }
}

