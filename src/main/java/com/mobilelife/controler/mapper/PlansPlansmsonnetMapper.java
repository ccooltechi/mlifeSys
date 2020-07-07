package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlansmsonnet;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;
import com.mobilelife.persistance.entities.PlansPlansmsonnetEntity;

public class PlansPlansmsonnetMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlansmsonnetMapper.class);

    public List<PlansPlansmsonnet> mapBean(List<PlansPlansmsonnetEntity> entityList) {
        List<PlansPlansmsonnet> retBean = new ArrayList<PlansPlansmsonnet>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlansmsonnetEntity entity = entityList.get(i);
            PlansPlansmsonnet bean = new PlansPlansmsonnet();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setLocalSmsOnnet(entity.getLocalSmsOnnet());
            bean.setLocalSmsOnnetUnitrate(entity.getLocalSmsOnnetUnitrate());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlansmsonnet mapBean(PlansPlansmsonnetEntity entity) {
        PlansPlansmsonnet bean = new PlansPlansmsonnet();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setLocalSmsOnnet(entity.getLocalSmsOnnet());
        bean.setLocalSmsOnnetUnitrate(entity.getLocalSmsOnnetUnitrate());

        return bean;
    }

    public PlansPlansmsonnetEntity mapBeanToEntity(PlansPlansmsonnet bean, PlansPlansmsonnetEntity existEntity) {
        PlansPlansmsonnetEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLocalSmsOnnet(bean.getLocalSmsOnnet());
        updateEntity.setLocalSmsOnnetUnitrate(bean.getLocalSmsOnnetUnitrate());

        return updateEntity;
    }

    public PlansPlansmsonnetEntity mapBeanToEntity(PlansPlansmsonnet bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlansmsonnetEntity updateEntity = new PlansPlansmsonnetEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLocalSmsOnnet(bean.getLocalSmsOnnet());
        updateEntity.setLocalSmsOnnetUnitrate(bean.getLocalSmsOnnetUnitrate());

        return updateEntity;
    }
}

