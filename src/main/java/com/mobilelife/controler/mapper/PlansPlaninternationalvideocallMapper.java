package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlaninternationalvideocallBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlaninternationalvideocall;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlaninternationalvideocallMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalvideocallMapper.class);

    public List<PlansPlaninternationalvideocallBean> mapBean(List<PlansPlaninternationalvideocall> entityList) {
        List<PlansPlaninternationalvideocallBean> retBean = new ArrayList<PlansPlaninternationalvideocallBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlaninternationalvideocall entity = entityList.get(i);
            PlansPlaninternationalvideocallBean bean = new PlansPlaninternationalvideocallBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setInternationalVideoCall(entity.getInternationalVideoCall());
            bean.setInternationalVideoCallUnitrate(entity.getInternationalVideoCallUnitrate());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlaninternationalvideocallBean mapBean(PlansPlaninternationalvideocall entity) {
        PlansPlaninternationalvideocallBean bean = new PlansPlaninternationalvideocallBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setInternationalVideoCall(entity.getInternationalVideoCall());
        bean.setInternationalVideoCallUnitrate(entity.getInternationalVideoCallUnitrate());

        return bean;
    }

    public PlansPlaninternationalvideocall mapBeanToEntity(PlansPlaninternationalvideocallBean bean, PlansPlaninternationalvideocall existEntity) {
        PlansPlaninternationalvideocall updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setInternationalVideoCall(bean.getInternationalVideoCall());
        updateEntity.setInternationalVideoCallUnitrate(bean.getInternationalVideoCallUnitrate());

        return updateEntity;
    }

    public PlansPlaninternationalvideocall mapBeanToEntity(PlansPlaninternationalvideocallBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlaninternationalvideocall updateEntity = new PlansPlaninternationalvideocall();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setInternationalVideoCall(bean.getInternationalVideoCall());
        updateEntity.setInternationalVideoCallUnitrate(bean.getInternationalVideoCallUnitrate());

        return updateEntity;
    }
}

