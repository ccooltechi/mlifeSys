package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlanFilters;
import com.mobilelife.persistance.dao.PlansTypePlanDao;
import com.mobilelife.persistance.entities.PlanFiltersEntity;
import com.mobilelife.persistance.entities.PlansPlantypeEntity;

public class PlanFiltersMapper {
	private static Logger logger = LoggerFactory.getLogger(PlanFiltersMapper.class);

    public List<PlanFilters> mapBean(List<PlanFiltersEntity> entityList) {
        List<PlanFilters> retBean = new ArrayList<PlanFilters>();
        for (int i=0; i<entityList.size();i++)
        {
            PlanFiltersEntity entity = entityList.get(i);
            PlanFilters bean = new PlanFilters();
            bean.setId(entity.getId());
            bean.setActive(entity.isActive());
            bean.setPlanType(entity.getPlanType().getId());
            bean.setAddon(entity.isAddon());
            bean.setConcatinate(entity.isConcatinate());
            bean.setIconsClass(entity.getIconsClass());
            bean.setCountry(entity.getCountry());
            bean.setKeyMajor(entity.getKeyMajor());
            bean.setKeyName(entity.getKeyName());
            bean.setKeyNameLabel(entity.getKeyNameLabel());
            bean.setKeyNameLabel2(entity.getKeyNameLabel2());
            bean.setKeyUnitsMax(entity.getKeyUnitsMax());
            bean.setKeyUnitsMin(entity.getKeyUnitsMin());
            bean.setKeyValueMax(entity.getKeyValueMax());
            bean.setKeyValueMin(entity.getKeyValueMin());
            bean.setLabel(entity.getLabel());
            bean.setLabel2(entity.getLabel2());
            bean.setLabel3(entity.getLabel3());
            bean.setLanguage(entity.getLanguage());
            bean.setOrderno(entity.getOrderno());
            bean.setReturnType(entity.getReturnType());
            bean.setSteps(entity.getSteps());
            bean.setStepValues(entity.getStepValues());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlanFilters mapBean(PlanFiltersEntity entity) {
        PlanFilters bean = new PlanFilters();
        bean.setId(entity.getId());
        bean.setActive(entity.isActive());
        bean.setPlanType(entity.getPlanType().getId());
        bean.setAddon(entity.isAddon());
        bean.setConcatinate(entity.isConcatinate());
        bean.setIconsClass(entity.getIconsClass());
        bean.setCountry(entity.getCountry());
        bean.setKeyMajor(entity.getKeyMajor());
        bean.setKeyName(entity.getKeyName());
        bean.setKeyNameLabel(entity.getKeyNameLabel());
        bean.setKeyNameLabel2(entity.getKeyNameLabel2());
        bean.setKeyUnitsMax(entity.getKeyUnitsMax());
        bean.setKeyUnitsMin(entity.getKeyUnitsMin());
        bean.setKeyValueMax(entity.getKeyValueMax());
        bean.setKeyValueMin(entity.getKeyValueMin());
        bean.setLabel(entity.getLabel());
        bean.setLabel2(entity.getLabel2());
        bean.setLabel3(entity.getLabel3());
        bean.setLanguage(entity.getLanguage());
        bean.setOrderno(entity.getOrderno());
        bean.setReturnType(entity.getReturnType());
        bean.setSteps(entity.getSteps());
        bean.setStepValues(entity.getStepValues());
        return bean;
    }

    public PlanFiltersEntity mapBeanToEntity(PlanFilters bean, PlanFiltersEntity existEntity) {
        PlanFiltersEntity updateEntity = existEntity;
        PlansPlantypeEntity plantypeentity = new PlansTypePlanDao().findById(bean.getPlanType());
        updateEntity.setActive(bean.isActive());
        updateEntity.setPlanType(plantypeentity);
        updateEntity.setAddon(bean.isAddon());
        updateEntity.setConcatinate(bean.isConcatinate());
        updateEntity.setIconsClass(bean.getIconsClass());
        updateEntity.setCountry(bean.getCountry());
        updateEntity.setKeyMajor(bean.getKeyMajor());
        updateEntity.setKeyName(bean.getKeyName());
        updateEntity.setKeyNameLabel(bean.getKeyNameLabel());
        updateEntity.setKeyNameLabel2(bean.getKeyNameLabel2());
        updateEntity.setKeyUnitsMax(bean.getKeyUnitsMax());
        updateEntity.setKeyUnitsMin(bean.getKeyUnitsMin());
        updateEntity.setKeyValueMax(bean.getKeyValueMax());
        updateEntity.setKeyValueMin(bean.getKeyValueMin());
        updateEntity.setLabel(bean.getLabel());
        updateEntity.setLabel2(bean.getLabel2());
        updateEntity.setLabel3(bean.getLabel3());
        updateEntity.setLanguage(bean.getLanguage());
        updateEntity.setOrderno(bean.getOrderno());
        updateEntity.setReturnType(bean.getReturnType());
        updateEntity.setSteps(bean.getSteps());
        updateEntity.setStepValues(bean.getStepValues());
        return updateEntity;
    }

    public PlanFiltersEntity mapBeanToEntity(PlanFilters bean) {
        PlanFiltersEntity updateEntity = new PlanFiltersEntity();
        PlansPlantypeEntity plantypeentity = new PlansTypePlanDao().findById(bean.getPlanType());
        updateEntity.setActive(bean.isActive());
        updateEntity.setPlanType(plantypeentity);
        updateEntity.setAddon(bean.isAddon());
        updateEntity.setConcatinate(bean.isConcatinate());
        updateEntity.setIconsClass(bean.getIconsClass());
        updateEntity.setCountry(bean.getCountry());
        updateEntity.setKeyMajor(bean.getKeyMajor());
        updateEntity.setKeyName(bean.getKeyName());
        updateEntity.setKeyNameLabel(bean.getKeyNameLabel());
        updateEntity.setKeyNameLabel2(bean.getKeyNameLabel2());
        updateEntity.setKeyUnitsMax(bean.getKeyUnitsMax());
        updateEntity.setKeyUnitsMin(bean.getKeyUnitsMin());
        updateEntity.setKeyValueMax(bean.getKeyValueMax());
        updateEntity.setKeyValueMin(bean.getKeyValueMin());
        updateEntity.setLabel(bean.getLabel());
        updateEntity.setLabel2(bean.getLabel2());
        updateEntity.setLabel3(bean.getLabel3());
        updateEntity.setLanguage(bean.getLanguage());
        updateEntity.setOrderno(bean.getOrderno());
        updateEntity.setReturnType(bean.getReturnType());
        updateEntity.setSteps(bean.getSteps());
        updateEntity.setStepValues(bean.getStepValues());
        return updateEntity;
    }
}

