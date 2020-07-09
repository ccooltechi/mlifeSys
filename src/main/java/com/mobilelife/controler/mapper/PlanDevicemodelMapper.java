package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlanDevicemodelBean;
import com.mobilelife.persistance.entities.PlanDevicemodel;

public class PlanDevicemodelMapper {
	private static Logger logger = LoggerFactory.getLogger(PlanDevicemodelMapper.class);

    public List<PlanDevicemodelBean> mapBean(List<PlanDevicemodel> entityList) {
        List<PlanDevicemodelBean> retBean = new ArrayList<PlanDevicemodelBean>();
        for (int i=0; i<entityList.size();i++)
        {
        	PlanDevicemodel entity = entityList.get(i);
            PlanDevicemodelBean bean = new PlanDevicemodelBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setDeviceModel(entity.getDeviceModel());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlanDevicemodelBean mapBean(PlanDevicemodel entity) {
    	PlanDevicemodelBean bean = new PlanDevicemodelBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setDeviceModel(entity.getDeviceModel());
        return bean;
    }

    public PlanDevicemodel mapBeanToEntity(PlanDevicemodelBean bean, PlanDevicemodel existEntity) {
    	PlanDevicemodel updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setDeviceModel(bean.getDeviceModel());
        return updateEntity;
    }

    public PlanDevicemodel mapBeanToEntity(PlanDevicemodelBean bean) {
    	PlanDevicemodel updateEntity = new PlanDevicemodel();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setDeviceModel(bean.getDeviceModel());
        return updateEntity;
    }
}

