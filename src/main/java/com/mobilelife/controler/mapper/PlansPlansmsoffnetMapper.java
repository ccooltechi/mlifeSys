package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlansmsoffnetBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanprimary;
import com.mobilelife.persistance.entities.PlansPlansmsoffnet;

public class PlansPlansmsoffnetMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlansmsoffnetMapper.class);

    public List<PlansPlansmsoffnetBean> mapBean(List<PlansPlansmsoffnet> entityList) {
        List<PlansPlansmsoffnetBean> retBean = new ArrayList<PlansPlansmsoffnetBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlansmsoffnet entity = entityList.get(i);
            PlansPlansmsoffnetBean bean = new PlansPlansmsoffnetBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setLocalSmsOffnet(entity.getLocalSmsOffnet());
            bean.setLocalSmsOffnetUnitrate(entity.getLocalSmsOffnetUnitrate());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlansmsoffnetBean mapBean(PlansPlansmsoffnet entity) {
        PlansPlansmsoffnetBean bean = new PlansPlansmsoffnetBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setLocalSmsOffnet(entity.getLocalSmsOffnet());
        bean.setLocalSmsOffnetUnitrate(entity.getLocalSmsOffnetUnitrate());

        return bean;
    }

    public PlansPlansmsoffnet mapBeanToEntity(PlansPlansmsoffnetBean bean, PlansPlansmsoffnet existEntity) {
        PlansPlansmsoffnet updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLocalSmsOffnet(bean.getLocalSmsOffnet());
        updateEntity.setLocalSmsOffnetUnitrate(bean.getLocalSmsOffnetUnitrate());

        return updateEntity;
    }

    public PlansPlansmsoffnet mapBeanToEntity(PlansPlansmsoffnetBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlansmsoffnet updateEntity = new PlansPlansmsoffnet();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLocalSmsOffnet(bean.getLocalSmsOffnet());
        updateEntity.setLocalSmsOffnetUnitrate(bean.getLocalSmsOffnetUnitrate());

        return updateEntity;
    }

}

