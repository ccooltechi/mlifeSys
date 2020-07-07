package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlaninternationalvideocall;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlaninternationalvideocallEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansPlaninternationalvideocallMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalvideocallMapper.class);

    public List<PlansPlaninternationalvideocall> mapBean(List<PlansPlaninternationalvideocallEntity> entityList) {
        List<PlansPlaninternationalvideocall> retBean = new ArrayList<PlansPlaninternationalvideocall>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlaninternationalvideocallEntity entity = entityList.get(i);
            PlansPlaninternationalvideocall bean = new PlansPlaninternationalvideocall();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setInternationalVideoCall(entity.getInternationalVideoCall());
            bean.setInternationalVideoCallUnitrate(entity.getInternationalVideoCallUnitrate());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlaninternationalvideocall mapBean(PlansPlaninternationalvideocallEntity entity) {
        PlansPlaninternationalvideocall bean = new PlansPlaninternationalvideocall();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setInternationalVideoCall(entity.getInternationalVideoCall());
        bean.setInternationalVideoCallUnitrate(entity.getInternationalVideoCallUnitrate());

        return bean;
    }

    public PlansPlaninternationalvideocallEntity mapBeanToEntity(PlansPlaninternationalvideocall bean, PlansPlaninternationalvideocallEntity existEntity) {
        PlansPlaninternationalvideocallEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setInternationalVideoCall(bean.getInternationalVideoCall());
        updateEntity.setInternationalVideoCallUnitrate(bean.getInternationalVideoCallUnitrate());

        return updateEntity;
    }

    public PlansPlaninternationalvideocallEntity mapBeanToEntity(PlansPlaninternationalvideocall bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlaninternationalvideocallEntity updateEntity = new PlansPlaninternationalvideocallEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setInternationalVideoCall(bean.getInternationalVideoCall());
        updateEntity.setInternationalVideoCallUnitrate(bean.getInternationalVideoCallUnitrate());

        return updateEntity;
    }
}

