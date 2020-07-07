package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlanDevicebrand;
import com.mobilelife.controler.mapper.bean.PlansPlantype;
import com.mobilelife.persistance.entities.PlanDevicebrandEntity;
import com.mobilelife.persistance.entities.PlansPlantypeEntity;

public class PlanDevicebrandMapper {
	private static Logger logger = LoggerFactory.getLogger(PlanDevicebrandMapper.class);

    public List<PlanDevicebrand> mapBean(List<PlanDevicebrandEntity> entityList) {
        List<PlanDevicebrand> retBean = new ArrayList<PlanDevicebrand>();
        for (int i=0; i<entityList.size();i++)
        {
        	PlanDevicebrandEntity entity = entityList.get(i);
        	PlanDevicebrand bean = new PlanDevicebrand();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setDeviceBrand(entity.getDeviceBrand());
            bean.setDeviceType(entity.getDeviceType());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlanDevicebrand mapBean(PlanDevicebrandEntity entity) {
    	PlanDevicebrand bean = new PlanDevicebrand();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setDeviceBrand(entity.getDeviceBrand());
        bean.setDeviceType(entity.getDeviceType());
        return bean;
    }

    public PlanDevicebrandEntity mapBeanToEntity(PlanDevicebrand bean, PlanDevicebrandEntity existEntity) {
    	PlanDevicebrandEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setDeviceBrand(bean.getDeviceBrand());
        updateEntity.setDeviceType(bean.getDeviceType());
        return updateEntity;
    }

    public PlanDevicebrandEntity mapBeanToEntity(PlanDevicebrand bean) {
    	PlanDevicebrandEntity updateEntity = new PlanDevicebrandEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setDeviceBrand(bean.getDeviceBrand());
        updateEntity.setDeviceType(bean.getDeviceType());
        return updateEntity;
    }
}

