package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanlocalmms;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanlocalmmsEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansPlanlocalmmsMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanlocalmmsMapper.class);

    public List<PlansPlanlocalmms> mapBean(List<PlansPlanlocalmmsEntity> entityList) {
        List<PlansPlanlocalmms> retBean = new ArrayList<PlansPlanlocalmms>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanlocalmmsEntity entity = entityList.get(i);
            PlansPlanlocalmms bean = new PlansPlanlocalmms();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setLocalMms(entity.getLocalMms());
            bean.setLocalMmsUnitrate(entity.getLocalMmsUnitrate());

            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanlocalmms mapBean(PlansPlanlocalmmsEntity entity) {
        PlansPlanlocalmms bean = new PlansPlanlocalmms();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setLocalMms(entity.getLocalMms());
        bean.setLocalMmsUnitrate(entity.getLocalMmsUnitrate());

        return bean;
    }

    public PlansPlanlocalmmsEntity mapBeanToEntity(PlansPlanlocalmms bean, PlansPlanlocalmmsEntity existEntity) {
        PlansPlanlocalmmsEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLocalMms(bean.getLocalMms());
        updateEntity.setLocalMmsUnitrate(bean.getLocalMmsUnitrate());

        return updateEntity;
    }

    public PlansPlanlocalmmsEntity mapBeanToEntity(PlansPlanlocalmms bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanlocalmmsEntity updateEntity = new PlansPlanlocalmmsEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLocalMms(bean.getLocalMms());
        updateEntity.setLocalMmsUnitrate(bean.getLocalMmsUnitrate());

        return updateEntity;
    }
}

