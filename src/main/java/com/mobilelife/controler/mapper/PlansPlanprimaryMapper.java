package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanprimaryBean;
import com.mobilelife.persistance.dao.OperatorDao;
import com.mobilelife.persistance.dao.PlansTypePlanDao;
import com.mobilelife.persistance.entities.PlansOperator;
import com.mobilelife.persistance.entities.PlansPlanprimary;
import com.mobilelife.persistance.entities.PlansPlanprimaryLocale;
import com.mobilelife.persistance.entities.PlansPlantype;
public class PlansPlanprimaryMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanprimaryMapper.class);

    public List<PlansPlanprimaryBean> mapBean(List<PlansPlanprimary> entityList) {
        List<PlansPlanprimaryBean> retBean = new ArrayList<PlansPlanprimaryBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanprimary entity = entityList.get(i);
            PlansPlanprimaryBean bean = new PlansPlanprimaryBean();
            bean.setId(entity.getId());
            bean.setActive(entity.getIsActive());
            bean.setAddon(entity.getIsAddon());
            bean.setAutorenewedFlag(entity.getAutorenewedFlag());
            bean.setContractPeriod(entity.getContractPeriod());
            bean.setContractPeriodUnit(entity.getContractPeriodUnit());
            bean.setDataOnly(entity.isDataOnly());
            bean.setDiscountedUpfrontPayment(entity.isDiscountedUpfrontPayment());
            bean.setDiscountext(entity.getDiscountext());
            bean.setFeatured(entity.getFeatured());
            bean.setId(entity.getId());
            bean.setLinkTopUp(entity.getLinkTopUp());
            bean.setLocalExpat(entity.getLocalExpat());
            bean.setNumberOfMultiSims(entity.getNumberOfMultiSims());
            bean.setOneTimeAddon(entity.getOneTimeAddon());
            bean.setOperatorId(entity.getOperatorId().getId());
            bean.setPlanBucket(entity.getPlanBucket());
            bean.setPlanEndDate(entity.getPlanEndDate());
            bean.setPlanFeature(entity.getPlanFeature());
            bean.setPlanId(entity.getPlanId());
            bean.setPlanLayout(entity.getPlanLayout());
            bean.setPlanLongName(entity.getPlanLongName());
            bean.setPlanName(entity.getPlanName());
            bean.setPlanParent(entity.getPlanParent());
            bean.setPlanStartDate(entity.getPlanStartDate());
            bean.setPlanStatus(entity.getPlanStatus());
            bean.setPlanType(entity.getPlanType().getId());
            bean.setPlanUrl(entity.getPlanUrl());
            bean.setPlanValidity(entity.getPlanValidity());
            bean.setPlanValidityUnit(entity.getPlanValidityUnit());
            bean.setPlanVatPer(entity.getPlanVatPer());
            bean.setPriority(entity.getPriority());
            bean.setRechargeFrequency(entity.getRechargeFrequency());
            bean.setRechargeFrequencyUnit(entity.getRechargeFrequencyUnit());
            bean.setRecurringBbundle(entity.getRecurringBbundle());
            bean.setSubscriptionCode(entity.getSubscriptionCode());
            bean.setTaxIncluded(entity.getIsTaxIncluded());
            bean.setTopupsallowedFlag(entity.getTopupsallowedFlag());           
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanprimaryBean mapBean(PlansPlanprimary entity) {
        PlansPlanprimaryBean bean = new PlansPlanprimaryBean();
        bean.setId(entity.getId());
        bean.setActive(entity.getIsActive());
        bean.setAddon(entity.getIsAddon());
        bean.setAutorenewedFlag(entity.getAutorenewedFlag());
        bean.setContractPeriod(entity.getContractPeriod());
        bean.setContractPeriodUnit(entity.getContractPeriodUnit());
        bean.setDataOnly(entity.isDataOnly());
        bean.setDiscountedUpfrontPayment(entity.isDiscountedUpfrontPayment());
        bean.setDiscountext(entity.getDiscountext());
        bean.setFeatured(entity.getFeatured());
        bean.setId(entity.getId());
        bean.setLinkTopUp(entity.getLinkTopUp());
        bean.setLocalExpat(entity.getLocalExpat());
        bean.setNumberOfMultiSims(entity.getNumberOfMultiSims());
        bean.setOneTimeAddon(entity.getOneTimeAddon());
        bean.setOperatorId(entity.getOperatorId().getId());
        bean.setPlanBucket(entity.getPlanBucket());
        bean.setPlanEndDate(entity.getPlanEndDate());
        bean.setPlanFeature(entity.getPlanFeature());
        bean.setPlanId(entity.getPlanId());
        bean.setPlanLayout(entity.getPlanLayout());
        bean.setPlanLongName(entity.getPlanLongName());
        bean.setPlanName(entity.getPlanName());
        bean.setPlanParent(entity.getPlanParent());
        bean.setPlanStartDate(entity.getPlanStartDate());
        bean.setPlanStatus(entity.getPlanStatus());
        bean.setPlanType(entity.getPlanType().getId());
        bean.setPlanUrl(entity.getPlanUrl());
        bean.setPlanValidity(entity.getPlanValidity());
        bean.setPlanValidityUnit(entity.getPlanValidityUnit());
        bean.setPlanVatPer(entity.getPlanVatPer());
        bean.setPriority(entity.getPriority());
        bean.setRechargeFrequency(entity.getRechargeFrequency());
        bean.setRechargeFrequencyUnit(entity.getRechargeFrequencyUnit());
        bean.setRecurringBbundle(entity.getRecurringBbundle());
        bean.setSubscriptionCode(entity.getSubscriptionCode());
        bean.setTaxIncluded(entity.getIsTaxIncluded());
        bean.setTopupsallowedFlag(entity.getTopupsallowedFlag());           
        return bean;
    }

    public PlansPlanprimary mapBeanToEntity(PlansPlanprimaryBean bean, PlansPlanprimary existEntity) {
        PlansPlanprimary updateEntity = existEntity;
        updateEntity.setIsActive(bean.isActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setIsAddon(bean.isAddon());
        updateEntity.setAutorenewedFlag(bean.getAutorenewedFlag());
        updateEntity.setContractPeriod(bean.getContractPeriod());
        updateEntity.setContractPeriodUnit(bean.getContractPeriodUnit());
        updateEntity.setDataOnly(bean.isDataOnly());
        updateEntity.setDiscountedUpfrontPayment(bean.isDiscountedUpfrontPayment());
        updateEntity.setDiscountext(bean.getDiscountext());
        updateEntity.setFeatured(bean.getFeatured());
        updateEntity.setLinkTopUp(bean.getLinkTopUp());
        updateEntity.setLocalExpat(bean.getLocalExpat());
        updateEntity.setNumberOfMultiSims(bean.getNumberOfMultiSims());
        updateEntity.setOneTimeAddon(bean.getOneTimeAddon());
        updateEntity.setPlanBucket(bean.getPlanBucket());
        updateEntity.setPlanEndDate(bean.getPlanEndDate());
        updateEntity.setPlanFeature(bean.getPlanFeature());
        updateEntity.setPlanId(bean.getPlanId());
        updateEntity.setPlanLayout(bean.getPlanLayout());
        updateEntity.setPlanLongName(bean.getPlanLongName());
        updateEntity.setPlanName(bean.getPlanName());
        updateEntity.setPlanParent(bean.getPlanParent());
        updateEntity.setPlanStartDate(bean.getPlanStartDate());
        updateEntity.setPlanStatus(bean.getPlanStatus());
        updateEntity.setPlanUrl(bean.getPlanUrl());
        updateEntity.setPlanValidity(bean.getPlanValidity());
        updateEntity.setPlanValidityUnit(bean.getPlanValidityUnit());
        updateEntity.setPlanVatPer(bean.getPlanVatPer());
        updateEntity.setPriority(bean.getPriority());
        updateEntity.setRechargeFrequency(bean.getRechargeFrequency());
        updateEntity.setRechargeFrequencyUnit(bean.getRechargeFrequencyUnit());
        updateEntity.setRecurringBbundle(bean.getRecurringBbundle());
        updateEntity.setSubscriptionCode(bean.getSubscriptionCode());
        updateEntity.setIsTaxIncluded(bean.isTaxIncluded());
        updateEntity.setTopupsallowedFlag(bean.isTopupsallowedFlag());           
        return updateEntity;
    }

    public PlansPlanprimary mapBeanToEntity(PlansPlanprimaryBean bean) {
        PlansPlanprimary updateEntity = new PlansPlanprimary();
        
        PlansPlantype plantypeentity = new PlansTypePlanDao().findById(bean.getPlanType());
        PlansOperator operatoreentity = new OperatorDao().findById(bean.getOperatorId());

        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setIsActive(bean.isActive());
        updateEntity.setId(bean.getId());
        updateEntity.setIsAddon(bean.isAddon());
        updateEntity.setAutorenewedFlag(bean.getAutorenewedFlag());
        updateEntity.setContractPeriod(bean.getContractPeriod());
        updateEntity.setContractPeriodUnit(bean.getContractPeriodUnit());
        updateEntity.setDataOnly(bean.isDataOnly());
        updateEntity.setDiscountedUpfrontPayment(bean.isDiscountedUpfrontPayment());
        updateEntity.setDiscountext(bean.getDiscountext());
        updateEntity.setFeatured(bean.getFeatured());
        updateEntity.setLinkTopUp(bean.getLinkTopUp());
        updateEntity.setLocalExpat(bean.getLocalExpat());
        updateEntity.setNumberOfMultiSims(bean.getNumberOfMultiSims());
        updateEntity.setOneTimeAddon(bean.getOneTimeAddon());
        updateEntity.setOperatorId(operatoreentity);
        updateEntity.setPlanBucket(bean.getPlanBucket());
        updateEntity.setPlanEndDate(bean.getPlanEndDate());
        updateEntity.setPlanFeature(bean.getPlanFeature());
        updateEntity.setPlanId(bean.getPlanId());
        updateEntity.setPlanLayout(bean.getPlanLayout());
        updateEntity.setPlanLongName(bean.getPlanLongName());
        updateEntity.setPlanName(bean.getPlanName());
        updateEntity.setPlanParent(bean.getPlanParent());
        updateEntity.setPlanStartDate(bean.getPlanStartDate());
        updateEntity.setPlanStatus(bean.getPlanStatus());
        updateEntity.setPlanType(plantypeentity);
        updateEntity.setPlanUrl(bean.getPlanUrl());
        updateEntity.setPlanValidity(bean.getPlanValidity());
        updateEntity.setPlanValidityUnit(bean.getPlanValidityUnit());
        updateEntity.setPlanVatPer(bean.getPlanVatPer());
        updateEntity.setPriority(bean.getPriority());
        updateEntity.setRechargeFrequency(bean.getRechargeFrequency());
        updateEntity.setRechargeFrequencyUnit(bean.getRechargeFrequencyUnit());
        updateEntity.setRecurringBbundle(bean.getRecurringBbundle());
        updateEntity.setSubscriptionCode(bean.getSubscriptionCode());
        updateEntity.setIsTaxIncluded(bean.isTaxIncluded());
        updateEntity.setTopupsallowedFlag(bean.isTopupsallowedFlag());           
        return updateEntity;
    }

	public PlansPlanprimaryLocale mapLocaleBeanToEntity(PlansPlanprimaryBean bean) {
		// TODO Auto-generated method stub
		return null;
	}
}

