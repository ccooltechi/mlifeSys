package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanoutofbundleBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanoutofbundle;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlanoutofbundleMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanoutofbundleMapper.class);

    public List<PlansPlanoutofbundleBean> mapBean(List<PlansPlanoutofbundle> entityList) {
        List<PlansPlanoutofbundleBean> retBean = new ArrayList<PlansPlanoutofbundleBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanoutofbundle entity = entityList.get(i);
            PlansPlanoutofbundleBean bean = new PlansPlanoutofbundleBean();
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
    
    public PlansPlanoutofbundleBean mapBean(PlansPlanoutofbundle entity) {
        PlansPlanoutofbundleBean bean = new PlansPlanoutofbundleBean();
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

    public PlansPlanoutofbundle mapBeanToEntity(PlansPlanoutofbundleBean bean, PlansPlanoutofbundle existEntity) {
        PlansPlanoutofbundle updateEntity = existEntity;
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

    public PlansPlanoutofbundle mapBeanToEntity(PlansPlanoutofbundleBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanoutofbundle updateEntity = new PlansPlanoutofbundle();
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

