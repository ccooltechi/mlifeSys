package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlanDevicecolorBean;
import com.mobilelife.persistance.entities.PlanDevicecolor;

public class PlanDevicecolorMapper {
	private static Logger logger = LoggerFactory.getLogger(PlanDevicecolorMapper.class);

    public List<PlanDevicecolorBean> mapBean(List<PlanDevicecolor> entityList) {
        List<PlanDevicecolorBean> retBean = new ArrayList<PlanDevicecolorBean>();
        for (int i=0; i<entityList.size();i++)
        {
        	PlanDevicecolor entity = entityList.get(i);
            PlanDevicecolorBean bean = new PlanDevicecolorBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setDeviceColor(entity.getDeviceColor());
            bean.setDeviceColorHex(entity.getDeviceColorHex());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlanDevicecolorBean mapBean(PlanDevicecolor entity) {
    	PlanDevicecolorBean bean = new PlanDevicecolorBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setDeviceColor(entity.getDeviceColor());
        bean.setDeviceColorHex(entity.getDeviceColorHex());
        return bean;
    }

    public PlanDevicecolor mapBeanToEntity(PlanDevicecolorBean bean, PlanDevicecolor existEntity) {
    	PlanDevicecolor updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setDeviceColor(bean.getDeviceColor());
        updateEntity.setDeviceColorHex(bean.getDeviceColorHex());
        return updateEntity;
    }

    public PlanDevicecolor mapBeanToEntity(PlanDevicecolorBean bean) {
    	PlanDevicecolor updateEntity = new PlanDevicecolor();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setDeviceColor(bean.getDeviceColor());
        updateEntity.setDeviceColorHex(bean.getDeviceColorHex());
        return updateEntity;
    }
}

