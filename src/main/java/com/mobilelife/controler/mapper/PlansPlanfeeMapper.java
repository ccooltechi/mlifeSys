package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanfeeBean;
import com.mobilelife.controler.mapper.bean.PlansPlantypeBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanfee;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlanfeeMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanfeeMapper.class);

    public List<PlansPlanfeeBean> mapBean(List<PlansPlanfee> entityList) {
        List<PlansPlanfeeBean> retBean = new ArrayList<PlansPlanfeeBean>();
        for (int i=0; i<entityList.size();i++)
        {
        	PlansPlanfee entity = entityList.get(i);
        	PlansPlanfeeBean bean = new PlansPlanfeeBean();
            bean.setId(entity.getId());
            bean.setActive(entity.getIsActive());
            bean.setPlanMonthlyFee(entity.getPlanMonthlyFee());
            bean.setPlanMonthlyFeeWas(entity.getPlanMonthlyFeeWas());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setSetupInfo(entity.getSetupInfo());
            bean.setSimActivationFee(entity.getSimActivationFee());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanfeeBean mapBean(PlansPlanfee entity) {
    	PlansPlanfeeBean bean = new PlansPlanfeeBean();
        bean.setId(entity.getId());
        bean.setActive(entity.getIsActive());
        bean.setPlanMonthlyFee(entity.getPlanMonthlyFee());
        bean.setPlanMonthlyFeeWas(entity.getPlanMonthlyFeeWas());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setSetupInfo(entity.getSetupInfo());
        bean.setSimActivationFee(entity.getSimActivationFee());
        return bean;
    }

    public PlansPlanfee mapBeanToEntity(PlansPlanfeeBean bean, PlansPlanfee existEntity) {
    	PlansPlanfee updateEntity = existEntity;
        updateEntity.setIsActive(bean.isActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanMonthlyFee(bean.getPlanMonthlyFee());
        updateEntity.setPlanMonthlyFeeWas(bean.getPlanMonthlyFeeWas());
        updateEntity.setSetupInfo(bean.getSetupInfo());
        updateEntity.setSimActivationFee(bean.getSimActivationFee());
        return updateEntity;
    }

    public PlansPlanfee mapBeanToEntity(PlansPlanfeeBean bean) {
    	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
    	PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
    	PlansPlanfee updateEntity = new PlansPlanfee();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setIsActive(bean.isActive());
        updateEntity.setPlanMonthlyFee(bean.getPlanMonthlyFee());
        updateEntity.setPlanMonthlyFeeWas(bean.getPlanMonthlyFeeWas());
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setSetupInfo(bean.getSetupInfo());
        updateEntity.setSimActivationFee(bean.getSimActivationFee());
        return updateEntity;
    }
}

