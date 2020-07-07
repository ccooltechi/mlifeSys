package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlaninternationalsms;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlaninternationalsmsEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansPlaninternationalsmsMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalsmsMapper.class);

    public List<PlansPlaninternationalsms> mapBean(List<PlansPlaninternationalsmsEntity> entityList) {
        List<PlansPlaninternationalsms> retBean = new ArrayList<PlansPlaninternationalsms>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlaninternationalsmsEntity entity = entityList.get(i);
            PlansPlaninternationalsms bean = new PlansPlaninternationalsms();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setInternationalSms(entity.getInternationalSms());
            bean.setInternationalSmsBucketcode(entity.getInternationalSmsBucketcode());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlaninternationalsms mapBean(PlansPlaninternationalsmsEntity entity) {
        PlansPlaninternationalsms bean = new PlansPlaninternationalsms();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setInternationalSms(entity.getInternationalSms());
        bean.setInternationalSmsBucketcode(entity.getInternationalSmsBucketcode());

        return bean;
    }

    public PlansPlaninternationalsmsEntity mapBeanToEntity(PlansPlaninternationalsms bean, PlansPlaninternationalsmsEntity existEntity) {
        PlansPlaninternationalsmsEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setInternationalSms(bean.getInternationalSms());
        updateEntity.setInternationalSmsBucketcode(bean.getInternationalSmsBucketcode());

        return updateEntity;
    }

    public PlansPlaninternationalsmsEntity mapBeanToEntity(PlansPlaninternationalsms bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlaninternationalsmsEntity updateEntity = new PlansPlaninternationalsmsEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setInternationalSms(bean.getInternationalSms());
        updateEntity.setInternationalSmsBucketcode(bean.getInternationalSmsBucketcode());

        return updateEntity;
    }
}

