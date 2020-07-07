package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanOperatorTnc;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanOperatorTncEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansPlanOperatorTncMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanOperatorTncMapper.class);

    public List<PlansPlanOperatorTnc> mapBean(List<PlansPlanOperatorTncEntity> entityList) {
        List<PlansPlanOperatorTnc> retBean = new ArrayList<PlansPlanOperatorTnc>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanOperatorTncEntity entity = entityList.get(i);
            PlansPlanOperatorTnc bean = new PlansPlanOperatorTnc();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setPlanFaq(entity.getPlanFaq());
            bean.setPlanFaqUrl(entity.getPlanFaqUrl());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanOperatorTnc mapBean(PlansPlanOperatorTncEntity entity) {
        PlansPlanOperatorTnc bean = new PlansPlanOperatorTnc();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setPlanFaq(entity.getPlanFaq());
        bean.setPlanFaqUrl(entity.getPlanFaqUrl());

        return bean;
    }

    public PlansPlanOperatorTncEntity mapBeanToEntity(PlansPlanOperatorTnc bean, PlansPlanOperatorTncEntity existEntity) {
        PlansPlanOperatorTncEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanFaq(bean.getPlanFaq());
        updateEntity.setPlanFaqUrl(bean.getPlanFaqUrl());

        return updateEntity;
    }

    public PlansPlanOperatorTncEntity mapBeanToEntity(PlansPlanOperatorTnc bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanOperatorTncEntity updateEntity = new PlansPlanOperatorTncEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setPlanFaq(bean.getPlanFaq());
        updateEntity.setPlanFaqUrl(bean.getPlanFaqUrl());

        return updateEntity;
    }
}

