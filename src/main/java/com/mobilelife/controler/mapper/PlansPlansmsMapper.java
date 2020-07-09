package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlansmsBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanprimary;
import com.mobilelife.persistance.entities.PlansPlansms;

public class PlansPlansmsMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlansmsMapper.class);

    public List<PlansPlansmsBean> mapBean(List<PlansPlansms> entityList) {
        List<PlansPlansmsBean> retBean = new ArrayList<PlansPlansmsBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlansms entity = entityList.get(i);
            PlansPlansmsBean bean = new PlansPlansmsBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setLocalSms(entity.getLocalSms());
            bean.setLocalSmsUnitrate(entity.getLocalSmsUnitrate());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlansmsBean mapBean(PlansPlansms entity) {
        PlansPlansmsBean bean = new PlansPlansmsBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setLocalSms(entity.getLocalSms());
        bean.setLocalSmsUnitrate(entity.getLocalSmsUnitrate());

        return bean;
    }

    public PlansPlansms mapBeanToEntity(PlansPlansmsBean bean, PlansPlansms existEntity) {
        PlansPlansms updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLocalSms(bean.getLocalSms());
        updateEntity.setLocalSmsUnitrate(bean.getLocalSmsUnitrate());

        return updateEntity;
    }

    public PlansPlansms mapBeanToEntity(PlansPlansmsBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlansms updateEntity = new PlansPlansms();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLocalSms(bean.getLocalSms());
        updateEntity.setLocalSmsUnitrate(bean.getLocalSmsUnitrate());

        return updateEntity;
    }
}

