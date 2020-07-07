package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanspecialminutes;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;
import com.mobilelife.persistance.entities.PlansPlanspecialminutesEntity;

public class PlansPlanspecialminutesMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanspecialminutesMapper.class);

    public List<PlansPlanspecialminutes> mapBean(List<PlansPlanspecialminutesEntity> entityList) {
        List<PlansPlanspecialminutes> retBean = new ArrayList<PlansPlanspecialminutes>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanspecialminutesEntity entity = entityList.get(i);
            PlansPlanspecialminutes bean = new PlansPlanspecialminutes();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setSpecialMinutes(entity.getSpecialMinutes());
            bean.setSpecialMinutesDescription(entity.getSpecialMinutesDescription());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanspecialminutes mapBean(PlansPlanspecialminutesEntity entity) {
        PlansPlanspecialminutes bean = new PlansPlanspecialminutes();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setSpecialMinutes(entity.getSpecialMinutes());
        bean.setSpecialMinutesDescription(entity.getSpecialMinutesDescription());

        return bean;
    }

    public PlansPlanspecialminutesEntity mapBeanToEntity(PlansPlanspecialminutes bean, PlansPlanspecialminutesEntity existEntity) {
        PlansPlanspecialminutesEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setSpecialMinutes(bean.getSpecialMinutes());
        updateEntity.setSpecialMinutesDescription(bean.getSpecialMinutesDescription());

        return updateEntity;
    }

    public PlansPlanspecialminutesEntity mapBeanToEntity(PlansPlanspecialminutes bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanspecialminutesEntity updateEntity = new PlansPlanspecialminutesEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setSpecialMinutes(bean.getSpecialMinutes());
        updateEntity.setSpecialMinutesDescription(bean.getSpecialMinutesDescription());

        return updateEntity;
    }
}

