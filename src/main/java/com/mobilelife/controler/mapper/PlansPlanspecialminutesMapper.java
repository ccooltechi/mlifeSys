package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanspecialminutesBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanprimary;
import com.mobilelife.persistance.entities.PlansPlanspecialminutes;

public class PlansPlanspecialminutesMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanspecialminutesMapper.class);

    public List<PlansPlanspecialminutesBean> mapBean(List<PlansPlanspecialminutes> entityList) {
        List<PlansPlanspecialminutesBean> retBean = new ArrayList<PlansPlanspecialminutesBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanspecialminutes entity = entityList.get(i);
            PlansPlanspecialminutesBean bean = new PlansPlanspecialminutesBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setSpecialMinutes(entity.getSpecialMinutes());
            bean.setSpecialMinutesDescription(entity.getSpecialMinutesDescription());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanspecialminutesBean mapBean(PlansPlanspecialminutes entity) {
        PlansPlanspecialminutesBean bean = new PlansPlanspecialminutesBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setSpecialMinutes(entity.getSpecialMinutes());
        bean.setSpecialMinutesDescription(entity.getSpecialMinutesDescription());

        return bean;
    }

    public PlansPlanspecialminutes mapBeanToEntity(PlansPlanspecialminutesBean bean, PlansPlanspecialminutes existEntity) {
        PlansPlanspecialminutes updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setSpecialMinutes(bean.getSpecialMinutes());
        updateEntity.setSpecialMinutesDescription(bean.getSpecialMinutesDescription());

        return updateEntity;
    }

    public PlansPlanspecialminutes mapBeanToEntity(PlansPlanspecialminutesBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanspecialminutes updateEntity = new PlansPlanspecialminutes();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setSpecialMinutes(bean.getSpecialMinutes());
        updateEntity.setSpecialMinutesDescription(bean.getSpecialMinutesDescription());

        return updateEntity;
    }
}

