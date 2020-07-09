package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlaninternationalsmsBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlaninternationalsms;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlaninternationalsmsMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalsmsMapper.class);

    public List<PlansPlaninternationalsmsBean> mapBean(List<PlansPlaninternationalsms> entityList) {
        List<PlansPlaninternationalsmsBean> retBean = new ArrayList<PlansPlaninternationalsmsBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlaninternationalsms entity = entityList.get(i);
            PlansPlaninternationalsmsBean bean = new PlansPlaninternationalsmsBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setInternationalSms(entity.getInternationalSms());
            bean.setInternationalSmsBucketcode(entity.getInternationalSmsBucketcode());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlaninternationalsmsBean mapBean(PlansPlaninternationalsms entity) {
        PlansPlaninternationalsmsBean bean = new PlansPlaninternationalsmsBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setInternationalSms(entity.getInternationalSms());
        bean.setInternationalSmsBucketcode(entity.getInternationalSmsBucketcode());

        return bean;
    }

    public PlansPlaninternationalsms mapBeanToEntity(PlansPlaninternationalsmsBean bean, PlansPlaninternationalsms existEntity) {
        PlansPlaninternationalsms updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setInternationalSms(bean.getInternationalSms());
        updateEntity.setInternationalSmsBucketcode(bean.getInternationalSmsBucketcode());

        return updateEntity;
    }

    public PlansPlaninternationalsms mapBeanToEntity(PlansPlaninternationalsmsBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlaninternationalsms updateEntity = new PlansPlaninternationalsms();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setInternationalSms(bean.getInternationalSms());
        updateEntity.setInternationalSmsBucketcode(bean.getInternationalSmsBucketcode());

        return updateEntity;
    }
}

