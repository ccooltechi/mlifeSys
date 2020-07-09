package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlanDevicebrandBean;
import com.mobilelife.controler.mapper.bean.PlansPlantypeBean;
import com.mobilelife.persistance.entities.PlanDevicebrand;
import com.mobilelife.persistance.entities.PlansPlantype;

public class PlanDevicebrandMapper {
	private static Logger logger = LoggerFactory.getLogger(PlanDevicebrandMapper.class);

    public List<PlanDevicebrandBean> mapBean(List<PlanDevicebrand> entityList) {
        List<PlanDevicebrandBean> retBean = new ArrayList<PlanDevicebrandBean>();
        for (int i=0; i<entityList.size();i++)
        {
        	PlanDevicebrand entity = entityList.get(i);
        	PlanDevicebrandBean bean = new PlanDevicebrandBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setDeviceBrand(entity.getDeviceBrand());
            bean.setDeviceType(entity.getDeviceType());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlanDevicebrandBean mapBean(PlanDevicebrand entity) {
    	PlanDevicebrandBean bean = new PlanDevicebrandBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setDeviceBrand(entity.getDeviceBrand());
        bean.setDeviceType(entity.getDeviceType());
        return bean;
    }

    public PlanDevicebrand mapBeanToEntity(PlanDevicebrandBean bean, PlanDevicebrand existEntity) {
    	PlanDevicebrand updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setDeviceBrand(bean.getDeviceBrand());
        updateEntity.setDeviceType(bean.getDeviceType());
        return updateEntity;
    }

    public PlanDevicebrand mapBeanToEntity(PlanDevicebrandBean bean) {
    	PlanDevicebrand updateEntity = new PlanDevicebrand();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setDeviceBrand(bean.getDeviceBrand());
        updateEntity.setDeviceType(bean.getDeviceType());
        return updateEntity;
    }
}

