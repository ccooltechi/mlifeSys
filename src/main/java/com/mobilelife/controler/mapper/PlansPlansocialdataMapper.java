package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlansocialdataBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanprimary;
import com.mobilelife.persistance.entities.PlansPlansocialdata;

public class PlansPlansocialdataMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlansocialdataMapper.class);

    public List<PlansPlansocialdataBean> mapBean(List<PlansPlansocialdata> entityList) {
        List<PlansPlansocialdataBean> retBean = new ArrayList<PlansPlansocialdataBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlansocialdata entity = entityList.get(i);
            PlansPlansocialdataBean bean = new PlansPlansocialdataBean();
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
    
    public PlansPlansocialdataBean mapBean(PlansPlansocialdata entity) {
        PlansPlansocialdataBean bean = new PlansPlansocialdataBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setSocialDataGb(entity.getSocialDataGb());
        bean.setSocialDataInfo(entity.getSocialDataInfo());
        bean.setSocialDataUnitrate(entity.getSocialDataUnitrate());

        return bean;
    }

    public PlansPlansocialdata mapBeanToEntity(PlansPlansocialdataBean bean, PlansPlansocialdata existEntity) {
        PlansPlansocialdata updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setSocialDataGb(bean.getSocialDataGb());
        updateEntity.setSocialDataInfo(bean.getSocialDataInfo());
        updateEntity.setSocialDataUnitrate(bean.getSocialDataUnitrate());

        return updateEntity;
    }

    public PlansPlansocialdata mapBeanToEntity(PlansPlansocialdataBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlansocialdata updateEntity = new PlansPlansocialdata();
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

