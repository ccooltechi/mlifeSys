package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanoutofbundle;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanoutofbundleEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansPlanoutofbundleMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanoutofbundleMapper.class);

    public List<PlansPlanoutofbundle> mapBean(List<PlansPlanoutofbundleEntity> entityList) {
        List<PlansPlanoutofbundle> retBean = new ArrayList<PlansPlanoutofbundle>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanoutofbundleEntity entity = entityList.get(i);
            PlansPlanoutofbundle bean = new PlansPlanoutofbundle();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setOutOfBundleRateInternationalMinsBucketcode(entity.getOutOfBundleRateInternationalMinsBucketcode());
            bean.setOutOfBundleRateInternationalMms(entity.getOutOfBundleRateInternationalMms());
            bean.setOutOfBundleRateInternationalSms(entity.getOutOfBundleRateInternationalSms());
            bean.setOutofbundleratenationaldataMb(entity.getOutofbundleratenationaldataMb());
            bean.setOutOfBundleRateNationalMins(entity.getOutOfBundleRateNationalMins());
            bean.setOutOfBundleRateNationalMms(entity.getOutOfBundleRateNationalMms());
            bean.setOutOfBundleRateNationalOffnetMins(entity.getOutOfBundleRateNationalOffnetMins());
            bean.setOutOfBundleRateNationalOffnetSms(entity.getOutOfBundleRateNationalOffnetSms());
            bean.setOutOfBundleRateNationalOnnetMins(entity.getOutOfBundleRateNationalOnnetMins());
            bean.setOutOfBundleRateNationalOnnetSms(entity.getOutOfBundleRateNationalOnnetSms());
            bean.setOutOfBundleRateNationalSms(entity.getOutOfBundleRateNationalSms());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanoutofbundle mapBean(PlansPlanoutofbundleEntity entity) {
        PlansPlanoutofbundle bean = new PlansPlanoutofbundle();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setOutOfBundleRateInternationalMinsBucketcode(entity.getOutOfBundleRateInternationalMinsBucketcode());
        bean.setOutOfBundleRateInternationalMms(entity.getOutOfBundleRateInternationalMms());
        bean.setOutOfBundleRateInternationalSms(entity.getOutOfBundleRateInternationalSms());
        bean.setOutofbundleratenationaldataMb(entity.getOutofbundleratenationaldataMb());
        bean.setOutOfBundleRateNationalMins(entity.getOutOfBundleRateNationalMins());
        bean.setOutOfBundleRateNationalMms(entity.getOutOfBundleRateNationalMms());
        bean.setOutOfBundleRateNationalOffnetMins(entity.getOutOfBundleRateNationalOffnetMins());
        bean.setOutOfBundleRateNationalOffnetSms(entity.getOutOfBundleRateNationalOffnetSms());
        bean.setOutOfBundleRateNationalOnnetMins(entity.getOutOfBundleRateNationalOnnetMins());
        bean.setOutOfBundleRateNationalOnnetSms(entity.getOutOfBundleRateNationalOnnetSms());
        bean.setOutOfBundleRateNationalSms(entity.getOutOfBundleRateNationalSms());

        return bean;
    }

    public PlansPlanoutofbundleEntity mapBeanToEntity(PlansPlanoutofbundle bean, PlansPlanoutofbundleEntity existEntity) {
        PlansPlanoutofbundleEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setOutOfBundleRateInternationalMinsBucketcode(bean.getOutOfBundleRateInternationalMinsBucketcode());
        updateEntity.setOutOfBundleRateInternationalMms(bean.getOutOfBundleRateInternationalMms());
        updateEntity.setOutOfBundleRateInternationalSms(bean.getOutOfBundleRateInternationalSms());
        updateEntity.setOutofbundleratenationaldataMb(bean.getOutofbundleratenationaldataMb());
        updateEntity.setOutOfBundleRateNationalMins(bean.getOutOfBundleRateNationalMins());
        updateEntity.setOutOfBundleRateNationalMms(bean.getOutOfBundleRateNationalMms());
        updateEntity.setOutOfBundleRateNationalOffnetMins(bean.getOutOfBundleRateNationalOffnetMins());
        updateEntity.setOutOfBundleRateNationalOffnetSms(bean.getOutOfBundleRateNationalOffnetSms());
        updateEntity.setOutOfBundleRateNationalOnnetMins(bean.getOutOfBundleRateNationalOnnetMins());
        updateEntity.setOutOfBundleRateNationalOnnetSms(bean.getOutOfBundleRateNationalOnnetSms());
        updateEntity.setOutOfBundleRateNationalSms(bean.getOutOfBundleRateNationalSms());

        return updateEntity;
    }

    public PlansPlanoutofbundleEntity mapBeanToEntity(PlansPlanoutofbundle bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanoutofbundleEntity updateEntity = new PlansPlanoutofbundleEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setOutOfBundleRateInternationalMinsBucketcode(bean.getOutOfBundleRateInternationalMinsBucketcode());
        updateEntity.setOutOfBundleRateInternationalMms(bean.getOutOfBundleRateInternationalMms());
        updateEntity.setOutOfBundleRateInternationalSms(bean.getOutOfBundleRateInternationalSms());
        updateEntity.setOutofbundleratenationaldataMb(bean.getOutofbundleratenationaldataMb());
        updateEntity.setOutOfBundleRateNationalMins(bean.getOutOfBundleRateNationalMins());
        updateEntity.setOutOfBundleRateNationalMms(bean.getOutOfBundleRateNationalMms());
        updateEntity.setOutOfBundleRateNationalOffnetMins(bean.getOutOfBundleRateNationalOffnetMins());
        updateEntity.setOutOfBundleRateNationalOffnetSms(bean.getOutOfBundleRateNationalOffnetSms());
        updateEntity.setOutOfBundleRateNationalOnnetMins(bean.getOutOfBundleRateNationalOnnetMins());
        updateEntity.setOutOfBundleRateNationalOnnetSms(bean.getOutOfBundleRateNationalOnnetSms());
        updateEntity.setOutOfBundleRateNationalSms(bean.getOutOfBundleRateNationalSms());

        return updateEntity;
    }
}

