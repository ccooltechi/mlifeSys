package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlansmsoffnet;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;
import com.mobilelife.persistance.entities.PlansPlansmsoffnetEntity;

public class PlansPlansmsoffnetMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlansmsoffnetMapper.class);

    public List<PlansPlansmsoffnet> mapBean(List<PlansPlansmsoffnetEntity> entityList) {
        List<PlansPlansmsoffnet> retBean = new ArrayList<PlansPlansmsoffnet>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlansmsoffnetEntity entity = entityList.get(i);
            PlansPlansmsoffnet bean = new PlansPlansmsoffnet();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setLocalSmsOffnet(entity.getLocalSmsOffnet());
            bean.setLocalSmsOffnetUnitrate(entity.getLocalSmsOffnetUnitrate());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlansmsoffnet mapBean(PlansPlansmsoffnetEntity entity) {
        PlansPlansmsoffnet bean = new PlansPlansmsoffnet();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setLocalSmsOffnet(entity.getLocalSmsOffnet());
        bean.setLocalSmsOffnetUnitrate(entity.getLocalSmsOffnetUnitrate());

        return bean;
    }

    public PlansPlansmsoffnetEntity mapBeanToEntity(PlansPlansmsoffnet bean, PlansPlansmsoffnetEntity existEntity) {
        PlansPlansmsoffnetEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLocalSmsOffnet(bean.getLocalSmsOffnet());
        updateEntity.setLocalSmsOffnetUnitrate(bean.getLocalSmsOffnetUnitrate());

        return updateEntity;
    }

    public PlansPlansmsoffnetEntity mapBeanToEntity(PlansPlansmsoffnet bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlansmsoffnetEntity updateEntity = new PlansPlansmsoffnetEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLocalSmsOffnet(bean.getLocalSmsOffnet());
        updateEntity.setLocalSmsOffnetUnitrate(bean.getLocalSmsOffnetUnitrate());

        return updateEntity;
    }

}

