package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanflexisms;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanflexismsEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansPlanflexismsMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanflexismsMapper.class);

    public List<PlansPlanflexisms> mapBean(List<PlansPlanflexismsEntity> entityList) {
        List<PlansPlanflexisms> retBean = new ArrayList<PlansPlanflexisms>();
        for (int i=0; i<entityList.size();i++)
        {
        	PlansPlanflexismsEntity entity = entityList.get(i);
            PlansPlanflexisms bean = new PlansPlanflexisms();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setFlexiSms(entity.getFlexiSms());
            bean.setFlexiSmsUnitrate(entity.getFlexiSmsUnitrate());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanflexisms mapBean(PlansPlanflexismsEntity entity) {
    	PlansPlanflexisms bean = new PlansPlanflexisms();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setFlexiSms(entity.getFlexiSms());
        bean.setFlexiSmsUnitrate(entity.getFlexiSmsUnitrate());

        return bean;
    }

    public PlansPlanflexismsEntity mapBeanToEntity(PlansPlanflexisms bean, PlansPlanflexismsEntity existEntity) {
    	PlansPlanflexismsEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setFlexiSms(bean.getFlexiSms());
        updateEntity.setFlexiSmsUnitrate(bean.getFlexiSmsUnitrate());

        return updateEntity;
    }

    public PlansPlanflexismsEntity mapBeanToEntity(PlansPlanflexisms bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanflexismsEntity updateEntity = new PlansPlanflexismsEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setFlexiSms(bean.getFlexiSms());
        updateEntity.setFlexiSmsUnitrate(bean.getFlexiSmsUnitrate());

        return updateEntity;
    }
}

