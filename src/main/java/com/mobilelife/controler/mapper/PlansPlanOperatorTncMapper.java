package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanOperatorTncBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanOperatorTnc;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlanOperatorTncMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanOperatorTncMapper.class);

    public List<PlansPlanOperatorTncBean> mapBean(List<PlansPlanOperatorTnc> entityList) {
        List<PlansPlanOperatorTncBean> retBean = new ArrayList<PlansPlanOperatorTncBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanOperatorTnc entity = entityList.get(i);
            PlansPlanOperatorTncBean bean = new PlansPlanOperatorTncBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setPlanFaq(entity.getPlanFaq());
            bean.setPlanFaqUrl(entity.getPlanFaqUrl());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanOperatorTncBean mapBean(PlansPlanOperatorTnc entity) {
        PlansPlanOperatorTncBean bean = new PlansPlanOperatorTncBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setPlanFaq(entity.getPlanFaq());
        bean.setPlanFaqUrl(entity.getPlanFaqUrl());

        return bean;
    }

    public PlansPlanOperatorTnc mapBeanToEntity(PlansPlanOperatorTncBean bean, PlansPlanOperatorTnc existEntity) {
        PlansPlanOperatorTnc updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanFaq(bean.getPlanFaq());
        updateEntity.setPlanFaqUrl(bean.getPlanFaqUrl());

        return updateEntity;
    }

    public PlansPlanOperatorTnc mapBeanToEntity(PlansPlanOperatorTncBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanOperatorTnc updateEntity = new PlansPlanOperatorTnc();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setPlanFaq(bean.getPlanFaq());
        updateEntity.setPlanFaqUrl(bean.getPlanFaqUrl());

        return updateEntity;
    }
}

