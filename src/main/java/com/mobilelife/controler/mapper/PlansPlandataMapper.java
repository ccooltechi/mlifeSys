package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlandataBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlandata;
import com.mobilelife.persistance.entities.PlansPlanfee;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlandataMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlandataMapper.class);

    public List<PlansPlandataBean> mapBean(List<PlansPlandata> entityList) {
        List<PlansPlandataBean> retBean = new ArrayList<PlansPlandataBean>();
        for (int i=0; i<entityList.size();i++)
        {
        	PlansPlandata entity = entityList.get(i);
            PlansPlandataBean bean = new PlansPlandataBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setDataSpeed(entity.getDataSpeed());
            bean.setRoamingData(entity.getRoamingData());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlandataBean mapBean(PlansPlandata entity) {
    	PlansPlandataBean bean = new PlansPlandataBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setDataSpeed(entity.getDataSpeed());
        bean.setRoamingData(entity.getRoamingData());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        return bean;
    }

    public PlansPlandata mapBeanToEntity(PlansPlandataBean bean, PlansPlandata existEntity) {
    	PlansPlandata updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setDataSpeed(bean.getDataSpeed());
        updateEntity.setRoamingData(bean.getRoamingData());
        return updateEntity;
    }

    public PlansPlandata mapBeanToEntity(PlansPlandataBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlandata updateEntity = new PlansPlandata();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setDataSpeed(bean.getDataSpeed());
        updateEntity.setRoamingData(bean.getRoamingData());
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        return updateEntity;
    }
}

