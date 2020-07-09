package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlaninternationalmmsBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlaninternationalmms;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlaninternationalmmsMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalmmsMapper.class);

    public List<PlansPlaninternationalmmsBean> mapBean(List<PlansPlaninternationalmms> entityList) {
        List<PlansPlaninternationalmmsBean> retBean = new ArrayList<PlansPlaninternationalmmsBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlaninternationalmms entity = entityList.get(i);
            PlansPlaninternationalmmsBean bean = new PlansPlaninternationalmmsBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setInternationalMms(entity.getInternationalMms());
            bean.setInternationalMmsUnitrate(entity.getInternationalMmsUnitrate());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlaninternationalmmsBean mapBean(PlansPlaninternationalmms entity) {
        PlansPlaninternationalmmsBean bean = new PlansPlaninternationalmmsBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setInternationalMms(entity.getInternationalMms());
        bean.setInternationalMmsUnitrate(entity.getInternationalMmsUnitrate());

        return bean;
    }

    public PlansPlaninternationalmms mapBeanToEntity(PlansPlaninternationalmmsBean bean, PlansPlaninternationalmms existEntity) {
        PlansPlaninternationalmms updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setInternationalMms(bean.getInternationalMms());
        updateEntity.setInternationalMmsUnitrate(bean.getInternationalMmsUnitrate());

        return updateEntity;
    }

    public PlansPlaninternationalmms mapBeanToEntity(PlansPlaninternationalmmsBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlaninternationalmms updateEntity = new PlansPlaninternationalmms();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setInternationalMms(bean.getInternationalMms());
        updateEntity.setInternationalMmsUnitrate(bean.getInternationalMmsUnitrate());

        return updateEntity;
    }
}

