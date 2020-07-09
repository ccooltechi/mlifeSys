package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanflexismsBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanflexisms;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlanflexismsMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanflexismsMapper.class);

    public List<PlansPlanflexismsBean> mapBean(List<PlansPlanflexisms> entityList) {
        List<PlansPlanflexismsBean> retBean = new ArrayList<PlansPlanflexismsBean>();
        for (int i=0; i<entityList.size();i++)
        {
        	PlansPlanflexisms entity = entityList.get(i);
            PlansPlanflexismsBean bean = new PlansPlanflexismsBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setFlexiSms(entity.getFlexiSms());
            bean.setFlexiSmsUnitrate(entity.getFlexiSmsUnitrate());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanflexismsBean mapBean(PlansPlanflexisms entity) {
    	PlansPlanflexismsBean bean = new PlansPlanflexismsBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setFlexiSms(entity.getFlexiSms());
        bean.setFlexiSmsUnitrate(entity.getFlexiSmsUnitrate());

        return bean;
    }

    public PlansPlanflexisms mapBeanToEntity(PlansPlanflexismsBean bean, PlansPlanflexisms existEntity) {
    	PlansPlanflexisms updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setFlexiSms(bean.getFlexiSms());
        updateEntity.setFlexiSmsUnitrate(bean.getFlexiSmsUnitrate());

        return updateEntity;
    }

    public PlansPlanflexisms mapBeanToEntity(PlansPlanflexismsBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanflexisms updateEntity = new PlansPlanflexisms();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setFlexiSms(bean.getFlexiSms());
        updateEntity.setFlexiSmsUnitrate(bean.getFlexiSmsUnitrate());

        return updateEntity;
    }
}

