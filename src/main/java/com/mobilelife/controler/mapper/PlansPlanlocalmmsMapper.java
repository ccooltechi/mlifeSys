package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanlocalmmsBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanlocalmms;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlanlocalmmsMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanlocalmmsMapper.class);

    public List<PlansPlanlocalmmsBean> mapBean(List<PlansPlanlocalmms> entityList) {
        List<PlansPlanlocalmmsBean> retBean = new ArrayList<PlansPlanlocalmmsBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanlocalmms entity = entityList.get(i);
            PlansPlanlocalmmsBean bean = new PlansPlanlocalmmsBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setLocalMms(entity.getLocalMms());
            bean.setLocalMmsUnitrate(entity.getLocalMmsUnitrate());

            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanlocalmmsBean mapBean(PlansPlanlocalmms entity) {
        PlansPlanlocalmmsBean bean = new PlansPlanlocalmmsBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setLocalMms(entity.getLocalMms());
        bean.setLocalMmsUnitrate(entity.getLocalMmsUnitrate());

        return bean;
    }

    public PlansPlanlocalmms mapBeanToEntity(PlansPlanlocalmmsBean bean, PlansPlanlocalmms existEntity) {
        PlansPlanlocalmms updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLocalMms(bean.getLocalMms());
        updateEntity.setLocalMmsUnitrate(bean.getLocalMmsUnitrate());

        return updateEntity;
    }

    public PlansPlanlocalmms mapBeanToEntity(PlansPlanlocalmmsBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanlocalmms updateEntity = new PlansPlanlocalmms();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLocalMms(bean.getLocalMms());
        updateEntity.setLocalMmsUnitrate(bean.getLocalMmsUnitrate());

        return updateEntity;
    }
}

