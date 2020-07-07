package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlaninternationalmms;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlaninternationalmmsEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansPlaninternationalmmsMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalmmsMapper.class);

    public List<PlansPlaninternationalmms> mapBean(List<PlansPlaninternationalmmsEntity> entityList) {
        List<PlansPlaninternationalmms> retBean = new ArrayList<PlansPlaninternationalmms>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlaninternationalmmsEntity entity = entityList.get(i);
            PlansPlaninternationalmms bean = new PlansPlaninternationalmms();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setInternationalMms(entity.getInternationalMms());
            bean.setInternationalMmsUnitrate(entity.getInternationalMmsUnitrate());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlaninternationalmms mapBean(PlansPlaninternationalmmsEntity entity) {
        PlansPlaninternationalmms bean = new PlansPlaninternationalmms();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setInternationalMms(entity.getInternationalMms());
        bean.setInternationalMmsUnitrate(entity.getInternationalMmsUnitrate());

        return bean;
    }

    public PlansPlaninternationalmmsEntity mapBeanToEntity(PlansPlaninternationalmms bean, PlansPlaninternationalmmsEntity existEntity) {
        PlansPlaninternationalmmsEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setInternationalMms(bean.getInternationalMms());
        updateEntity.setInternationalMmsUnitrate(bean.getInternationalMmsUnitrate());

        return updateEntity;
    }

    public PlansPlaninternationalmmsEntity mapBeanToEntity(PlansPlaninternationalmms bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlaninternationalmmsEntity updateEntity = new PlansPlaninternationalmmsEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setInternationalMms(bean.getInternationalMms());
        updateEntity.setInternationalMmsUnitrate(bean.getInternationalMmsUnitrate());

        return updateEntity;
    }
}

