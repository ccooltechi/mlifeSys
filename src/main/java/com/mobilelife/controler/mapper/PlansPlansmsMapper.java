package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlansms;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;
import com.mobilelife.persistance.entities.PlansPlansmsEntity;

public class PlansPlansmsMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlansmsMapper.class);

    public List<PlansPlansms> mapBean(List<PlansPlansmsEntity> entityList) {
        List<PlansPlansms> retBean = new ArrayList<PlansPlansms>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlansmsEntity entity = entityList.get(i);
            PlansPlansms bean = new PlansPlansms();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setLocalSms(entity.getLocalSms());
            bean.setLocalSmsUnitrate(entity.getLocalSmsUnitrate());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlansms mapBean(PlansPlansmsEntity entity) {
        PlansPlansms bean = new PlansPlansms();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setLocalSms(entity.getLocalSms());
        bean.setLocalSmsUnitrate(entity.getLocalSmsUnitrate());

        return bean;
    }

    public PlansPlansmsEntity mapBeanToEntity(PlansPlansms bean, PlansPlansmsEntity existEntity) {
        PlansPlansmsEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLocalSms(bean.getLocalSms());
        updateEntity.setLocalSmsUnitrate(bean.getLocalSmsUnitrate());

        return updateEntity;
    }

    public PlansPlansmsEntity mapBeanToEntity(PlansPlansms bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlansmsEntity updateEntity = new PlansPlansmsEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLocalSms(bean.getLocalSms());
        updateEntity.setLocalSmsUnitrate(bean.getLocalSmsUnitrate());

        return updateEntity;
    }
}

