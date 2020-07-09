package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlansmsonnetBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanprimary;
import com.mobilelife.persistance.entities.PlansPlansmsonnet;

public class PlansPlansmsonnetMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlansmsonnetMapper.class);

    public List<PlansPlansmsonnetBean> mapBean(List<PlansPlansmsonnet> entityList) {
        List<PlansPlansmsonnetBean> retBean = new ArrayList<PlansPlansmsonnetBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlansmsonnet entity = entityList.get(i);
            PlansPlansmsonnetBean bean = new PlansPlansmsonnetBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setLocalSmsOnnet(entity.getLocalSmsOnnet());
            bean.setLocalSmsOnnetUnitrate(entity.getLocalSmsOnnetUnitrate());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlansmsonnetBean mapBean(PlansPlansmsonnet entity) {
        PlansPlansmsonnetBean bean = new PlansPlansmsonnetBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setLocalSmsOnnet(entity.getLocalSmsOnnet());
        bean.setLocalSmsOnnetUnitrate(entity.getLocalSmsOnnetUnitrate());

        return bean;
    }

    public PlansPlansmsonnet mapBeanToEntity(PlansPlansmsonnetBean bean, PlansPlansmsonnet existEntity) {
        PlansPlansmsonnet updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLocalSmsOnnet(bean.getLocalSmsOnnet());
        updateEntity.setLocalSmsOnnetUnitrate(bean.getLocalSmsOnnetUnitrate());

        return updateEntity;
    }

    public PlansPlansmsonnet mapBeanToEntity(PlansPlansmsonnetBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlansmsonnet updateEntity = new PlansPlansmsonnet();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLocalSmsOnnet(bean.getLocalSmsOnnet());
        updateEntity.setLocalSmsOnnetUnitrate(bean.getLocalSmsOnnetUnitrate());

        return updateEntity;
    }
}

