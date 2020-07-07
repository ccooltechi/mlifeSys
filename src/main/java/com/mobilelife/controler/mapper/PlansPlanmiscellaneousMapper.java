package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanmiscellaneous;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanmiscellaneousEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansPlanmiscellaneousMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanmiscellaneousMapper.class);

    public List<PlansPlanmiscellaneous> mapBean(List<PlansPlanmiscellaneousEntity> entityList) {
        List<PlansPlanmiscellaneous> retBean = new ArrayList<PlansPlanmiscellaneous>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanmiscellaneousEntity entity = entityList.get(i);
            PlansPlanmiscellaneous bean = new PlansPlanmiscellaneous();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setAddedBenefitsInfo(entity.getAddedBenefitsInfo());
            bean.setEarly_Termination_Fees(entity.getEarly_Termination_Fees());
            bean.setHowToSubscribeInfo(entity.getHowToSubscribeInfo());
            bean.setHowToUnsubscribeInfo(entity.getHowToUnsubscribeInfo());
            bean.setOptionalBenefitsInfo(entity.getOptionalBenefitsInfo());
            bean.setPeakOffPeakInfo(entity.getPeakOffPeakInfo());
            bean.setPlanActivationInfo(entity.getPlanActivationInfo());
            bean.setSimActivationInfo(entity.getSimActivationInfo());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanmiscellaneous mapBean(PlansPlanmiscellaneousEntity entity) {
        PlansPlanmiscellaneous bean = new PlansPlanmiscellaneous();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setAddedBenefitsInfo(entity.getAddedBenefitsInfo());
        bean.setEarly_Termination_Fees(entity.getEarly_Termination_Fees());
        bean.setHowToSubscribeInfo(entity.getHowToSubscribeInfo());
        bean.setHowToUnsubscribeInfo(entity.getHowToUnsubscribeInfo());
        bean.setOptionalBenefitsInfo(entity.getOptionalBenefitsInfo());
        bean.setPeakOffPeakInfo(entity.getPeakOffPeakInfo());
        bean.setPlanActivationInfo(entity.getPlanActivationInfo());
        bean.setSimActivationInfo(entity.getSimActivationInfo());

        return bean;
    }

    public PlansPlanmiscellaneousEntity mapBeanToEntity(PlansPlanmiscellaneous bean, PlansPlanmiscellaneousEntity existEntity) {
        PlansPlanmiscellaneousEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setAddedBenefitsInfo(bean.getAddedBenefitsInfo());
        updateEntity.setEarly_Termination_Fees(bean.getEarly_Termination_Fees());
        updateEntity.setHowToSubscribeInfo(bean.getHowToSubscribeInfo());
        updateEntity.setHowToUnsubscribeInfo(bean.getHowToUnsubscribeInfo());
        updateEntity.setOptionalBenefitsInfo(bean.getOptionalBenefitsInfo());
        updateEntity.setPeakOffPeakInfo(bean.getPeakOffPeakInfo());
        updateEntity.setPlanActivationInfo(bean.getPlanActivationInfo());
        updateEntity.setSimActivationInfo(bean.getSimActivationInfo());

        return updateEntity;
    }

    public PlansPlanmiscellaneousEntity mapBeanToEntity(PlansPlanmiscellaneous bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanmiscellaneousEntity updateEntity = new PlansPlanmiscellaneousEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setAddedBenefitsInfo(bean.getAddedBenefitsInfo());
        updateEntity.setEarly_Termination_Fees(bean.getEarly_Termination_Fees());
        updateEntity.setHowToSubscribeInfo(bean.getHowToSubscribeInfo());
        updateEntity.setHowToUnsubscribeInfo(bean.getHowToUnsubscribeInfo());
        updateEntity.setOptionalBenefitsInfo(bean.getOptionalBenefitsInfo());
        updateEntity.setPeakOffPeakInfo(bean.getPeakOffPeakInfo());
        updateEntity.setPlanActivationInfo(bean.getPlanActivationInfo());
        updateEntity.setSimActivationInfo(bean.getSimActivationInfo());

        return updateEntity;
    }
}

