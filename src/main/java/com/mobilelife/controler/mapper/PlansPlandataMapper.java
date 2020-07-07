package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlandata;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlandataEntity;
import com.mobilelife.persistance.entities.PlansPlanfeeEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansPlandataMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlandataMapper.class);

    public List<PlansPlandata> mapBean(List<PlansPlandataEntity> entityList) {
        List<PlansPlandata> retBean = new ArrayList<PlansPlandata>();
        for (int i=0; i<entityList.size();i++)
        {
        	PlansPlandataEntity entity = entityList.get(i);
            PlansPlandata bean = new PlansPlandata();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setDataSpeed(entity.getDataSpeed());
            bean.setRoamingData(entity.getRoamingData());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlandata mapBean(PlansPlandataEntity entity) {
    	PlansPlandata bean = new PlansPlandata();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setDataSpeed(entity.getDataSpeed());
        bean.setRoamingData(entity.getRoamingData());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        return bean;
    }

    public PlansPlandataEntity mapBeanToEntity(PlansPlandata bean, PlansPlandataEntity existEntity) {
    	PlansPlandataEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setDataSpeed(bean.getDataSpeed());
        updateEntity.setRoamingData(bean.getRoamingData());
        return updateEntity;
    }

    public PlansPlandataEntity mapBeanToEntity(PlansPlandata bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlandataEntity updateEntity = new PlansPlandataEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setDataSpeed(bean.getDataSpeed());
        updateEntity.setRoamingData(bean.getRoamingData());
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        return updateEntity;
    }
}

