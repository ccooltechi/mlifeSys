package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanfee;
import com.mobilelife.controler.mapper.bean.PlansPlantype;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanfeeEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansPlanfeeMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanfeeMapper.class);

    public List<PlansPlanfee> mapBean(List<PlansPlanfeeEntity> entityList) {
        List<PlansPlanfee> retBean = new ArrayList<PlansPlanfee>();
        for (int i=0; i<entityList.size();i++)
        {
        	PlansPlanfeeEntity entity = entityList.get(i);
        	PlansPlanfee bean = new PlansPlanfee();
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
    
    public PlansPlanfee mapBean(PlansPlanfeeEntity entity) {
    	PlansPlanfee bean = new PlansPlanfee();
        bean.setId(entity.getId());
        bean.setActive(entity.getIsActive());
        bean.setPlanMonthlyFee(entity.getPlanMonthlyFee());
        bean.setPlanMonthlyFeeWas(entity.getPlanMonthlyFeeWas());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setSetupInfo(entity.getSetupInfo());
        bean.setSimActivationFee(entity.getSimActivationFee());
        return bean;
    }

    public PlansPlanfeeEntity mapBeanToEntity(PlansPlanfee bean, PlansPlanfeeEntity existEntity) {
    	PlansPlanfeeEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.isActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanMonthlyFee(bean.getPlanMonthlyFee());
        updateEntity.setPlanMonthlyFeeWas(bean.getPlanMonthlyFeeWas());
        updateEntity.setSetupInfo(bean.getSetupInfo());
        updateEntity.setSimActivationFee(bean.getSimActivationFee());
        return updateEntity;
    }

    public PlansPlanfeeEntity mapBeanToEntity(PlansPlanfee bean) {
    	PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
    	PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
    	PlansPlanfeeEntity updateEntity = new PlansPlanfeeEntity();
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

