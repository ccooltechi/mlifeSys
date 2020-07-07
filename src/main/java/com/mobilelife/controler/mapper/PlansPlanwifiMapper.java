package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanwifi;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;
import com.mobilelife.persistance.entities.PlansPlanwifiEntity;

public class PlansPlanwifiMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanwifiMapper.class);

    public List<PlansPlanwifi> mapBean(List<PlansPlanwifiEntity> entityList) {
        List<PlansPlanwifi> retBean = new ArrayList<PlansPlanwifi>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanwifiEntity entity = entityList.get(i);
            PlansPlanwifi bean = new PlansPlanwifi();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setWifiAccess(entity.getWifiAccess());
            bean.setWifiAccessUnit(entity.getWifiAccessUnit());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanwifi mapBean(PlansPlanwifiEntity entity) {
        PlansPlanwifi bean = new PlansPlanwifi();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setWifiAccess(entity.getWifiAccess());
        bean.setWifiAccessUnit(entity.getWifiAccessUnit());

        return bean;
    }

    public PlansPlanwifiEntity mapBeanToEntity(PlansPlanwifi bean, PlansPlanwifiEntity existEntity) {
        PlansPlanwifiEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setWifiAccess(bean.getWifiAccess());
        updateEntity.setWifiAccessUnit(bean.getWifiAccessUnit());

        return updateEntity;
    }

    public PlansPlanwifiEntity mapBeanToEntity(PlansPlanwifi bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanwifiEntity updateEntity = new PlansPlanwifiEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setWifiAccess(bean.getWifiAccess());
        updateEntity.setWifiAccessUnit(bean.getWifiAccessUnit());

        return updateEntity;
    }
}

