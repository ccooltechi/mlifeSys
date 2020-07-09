package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanmiscellaneousBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanmiscellaneous;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlanmiscellaneousMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanmiscellaneousMapper.class);

    public List<PlansPlanmiscellaneousBean> mapBean(List<PlansPlanmiscellaneous> entityList) {
        List<PlansPlanmiscellaneousBean> retBean = new ArrayList<PlansPlanmiscellaneousBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanmiscellaneous entity = entityList.get(i);
            PlansPlanmiscellaneousBean bean = new PlansPlanmiscellaneousBean();
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
    
    public PlansPlanmiscellaneousBean mapBean(PlansPlanmiscellaneous entity) {
        PlansPlanmiscellaneousBean bean = new PlansPlanmiscellaneousBean();
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

    public PlansPlanmiscellaneous mapBeanToEntity(PlansPlanmiscellaneousBean bean, PlansPlanmiscellaneous existEntity) {
        PlansPlanmiscellaneous updateEntity = existEntity;
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

    public PlansPlanmiscellaneous mapBeanToEntity(PlansPlanmiscellaneousBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanmiscellaneous updateEntity = new PlansPlanmiscellaneous();
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

