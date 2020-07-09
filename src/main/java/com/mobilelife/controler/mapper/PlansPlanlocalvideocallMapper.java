package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanlocalvideocallBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanlocalvideocall;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlanlocalvideocallMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanlocalvideocallMapper.class);

    public List<PlansPlanlocalvideocallBean> mapBean(List<PlansPlanlocalvideocall> entityList) {
        List<PlansPlanlocalvideocallBean> retBean = new ArrayList<PlansPlanlocalvideocallBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanlocalvideocall entity = entityList.get(i);
            PlansPlanlocalvideocallBean bean = new PlansPlanlocalvideocallBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setLocalVideoCall(entity.getLocalVideoCall());
            bean.setLocalVideoCallUnitrate(entity.getLocalVideoCallUnitrate());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanlocalvideocallBean mapBean(PlansPlanlocalvideocall entity) {
        PlansPlanlocalvideocallBean bean = new PlansPlanlocalvideocallBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setLocalVideoCall(entity.getLocalVideoCall());
        bean.setLocalVideoCallUnitrate(entity.getLocalVideoCallUnitrate());

        return bean;
    }

    public PlansPlanlocalvideocall mapBeanToEntity(PlansPlanlocalvideocallBean bean, PlansPlanlocalvideocall existEntity) {
        PlansPlanlocalvideocall updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLocalVideoCall(bean.getLocalVideoCall());
        updateEntity.setLocalVideoCallUnitrate(bean.getLocalVideoCallUnitrate());

        return updateEntity;
    }

    public PlansPlanlocalvideocall mapBeanToEntity(PlansPlanlocalvideocallBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanlocalvideocall updateEntity = new PlansPlanlocalvideocall();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLocalVideoCall(bean.getLocalVideoCall());
        updateEntity.setLocalVideoCallUnitrate(bean.getLocalVideoCallUnitrate());

        return updateEntity;
    }
}

