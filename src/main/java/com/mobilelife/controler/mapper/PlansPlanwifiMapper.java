package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanwifiBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanprimary;
import com.mobilelife.persistance.entities.PlansPlanwifi;

public class PlansPlanwifiMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanwifiMapper.class);

    public List<PlansPlanwifiBean> mapBean(List<PlansPlanwifi> entityList) {
        List<PlansPlanwifiBean> retBean = new ArrayList<PlansPlanwifiBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanwifi entity = entityList.get(i);
            PlansPlanwifiBean bean = new PlansPlanwifiBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setWifiAccess(entity.getWifiAccess());
            bean.setWifiAccessUnit(entity.getWifiAccessUnit());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanwifiBean mapBean(PlansPlanwifi entity) {
        PlansPlanwifiBean bean = new PlansPlanwifiBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setWifiAccess(entity.getWifiAccess());
        bean.setWifiAccessUnit(entity.getWifiAccessUnit());

        return bean;
    }

    public PlansPlanwifi mapBeanToEntity(PlansPlanwifiBean bean, PlansPlanwifi existEntity) {
        PlansPlanwifi updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setWifiAccess(bean.getWifiAccess());
        updateEntity.setWifiAccessUnit(bean.getWifiAccessUnit());

        return updateEntity;
    }

    public PlansPlanwifi mapBeanToEntity(PlansPlanwifiBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanwifi updateEntity = new PlansPlanwifi();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setWifiAccess(bean.getWifiAccess());
        updateEntity.setWifiAccessUnit(bean.getWifiAccessUnit());

        return updateEntity;
    }
}

