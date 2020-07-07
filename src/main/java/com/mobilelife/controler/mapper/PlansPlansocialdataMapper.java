package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlansocialdata;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;
import com.mobilelife.persistance.entities.PlansPlansocialdataEntity;

public class PlansPlansocialdataMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlansocialdataMapper.class);

    public List<PlansPlansocialdata> mapBean(List<PlansPlansocialdataEntity> entityList) {
        List<PlansPlansocialdata> retBean = new ArrayList<PlansPlansocialdata>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlansocialdataEntity entity = entityList.get(i);
            PlansPlansocialdata bean = new PlansPlansocialdata();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setSocialDataGb(entity.getSocialDataGb());
            bean.setSocialDataInfo(entity.getSocialDataInfo());
            bean.setSocialDataUnitrate(entity.getSocialDataUnitrate());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlansocialdata mapBean(PlansPlansocialdataEntity entity) {
        PlansPlansocialdata bean = new PlansPlansocialdata();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setSocialDataGb(entity.getSocialDataGb());
        bean.setSocialDataInfo(entity.getSocialDataInfo());
        bean.setSocialDataUnitrate(entity.getSocialDataUnitrate());

        return bean;
    }

    public PlansPlansocialdataEntity mapBeanToEntity(PlansPlansocialdata bean, PlansPlansocialdataEntity existEntity) {
        PlansPlansocialdataEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setSocialDataGb(bean.getSocialDataGb());
        updateEntity.setSocialDataInfo(bean.getSocialDataInfo());
        updateEntity.setSocialDataUnitrate(bean.getSocialDataUnitrate());

        return updateEntity;
    }

    public PlansPlansocialdataEntity mapBeanToEntity(PlansPlansocialdata bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlansocialdataEntity updateEntity = new PlansPlansocialdataEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setSocialDataGb(bean.getSocialDataGb());
        updateEntity.setSocialDataInfo(bean.getSocialDataInfo());
        updateEntity.setSocialDataUnitrate(bean.getSocialDataUnitrate());

        return updateEntity;
    }
}

