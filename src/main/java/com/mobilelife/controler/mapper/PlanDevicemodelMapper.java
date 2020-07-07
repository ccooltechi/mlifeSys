package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlanDevicemodel;
import com.mobilelife.persistance.entities.PlanDevicemodelEntity;

public class PlanDevicemodelMapper {
	private static Logger logger = LoggerFactory.getLogger(PlanDevicemodelMapper.class);

    public List<PlanDevicemodel> mapBean(List<PlanDevicemodelEntity> entityList) {
        List<PlanDevicemodel> retBean = new ArrayList<PlanDevicemodel>();
        for (int i=0; i<entityList.size();i++)
        {
        	PlanDevicemodelEntity entity = entityList.get(i);
            PlanDevicemodel bean = new PlanDevicemodel();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setDeviceModel(entity.getDeviceModel());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlanDevicemodel mapBean(PlanDevicemodelEntity entity) {
    	PlanDevicemodel bean = new PlanDevicemodel();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setDeviceModel(entity.getDeviceModel());
        return bean;
    }

    public PlanDevicemodelEntity mapBeanToEntity(PlanDevicemodel bean, PlanDevicemodelEntity existEntity) {
    	PlanDevicemodelEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setDeviceModel(bean.getDeviceModel());
        return updateEntity;
    }

    public PlanDevicemodelEntity mapBeanToEntity(PlanDevicemodel bean) {
    	PlanDevicemodelEntity updateEntity = new PlanDevicemodelEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setDeviceModel(bean.getDeviceModel());
        return updateEntity;
    }
}

