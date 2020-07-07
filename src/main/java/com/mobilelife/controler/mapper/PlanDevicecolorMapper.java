package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlanDevicecolor;
import com.mobilelife.persistance.entities.PlanDevicecolorEntity;

public class PlanDevicecolorMapper {
	private static Logger logger = LoggerFactory.getLogger(PlanDevicecolorMapper.class);

    public List<PlanDevicecolor> mapBean(List<PlanDevicecolorEntity> entityList) {
        List<PlanDevicecolor> retBean = new ArrayList<PlanDevicecolor>();
        for (int i=0; i<entityList.size();i++)
        {
        	PlanDevicecolorEntity entity = entityList.get(i);
            PlanDevicecolor bean = new PlanDevicecolor();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setDeviceColor(entity.getDeviceColor());
            bean.setDeviceColorHex(entity.getDeviceColorHex());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlanDevicecolor mapBean(PlanDevicecolorEntity entity) {
    	PlanDevicecolor bean = new PlanDevicecolor();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setDeviceColor(entity.getDeviceColor());
        bean.setDeviceColorHex(entity.getDeviceColorHex());
        return bean;
    }

    public PlanDevicecolorEntity mapBeanToEntity(PlanDevicecolor bean, PlanDevicecolorEntity existEntity) {
    	PlanDevicecolorEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setDeviceColor(bean.getDeviceColor());
        updateEntity.setDeviceColorHex(bean.getDeviceColorHex());
        return updateEntity;
    }

    public PlanDevicecolorEntity mapBeanToEntity(PlanDevicecolor bean) {
    	PlanDevicecolorEntity updateEntity = new PlanDevicecolorEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setDeviceColor(bean.getDeviceColor());
        updateEntity.setDeviceColorHex(bean.getDeviceColorHex());
        return updateEntity;
    }
}

