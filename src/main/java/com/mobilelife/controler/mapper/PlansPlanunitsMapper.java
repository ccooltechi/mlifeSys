package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanunits;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;
import com.mobilelife.persistance.entities.PlansPlanunitsEntity;

public class PlansPlanunitsMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanunitsMapper.class);

    public List<PlansPlanunits> mapBean(List<PlansPlanunitsEntity> entityList) {
        List<PlansPlanunits> retBean = new ArrayList<PlansPlanunits>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanunitsEntity entity = entityList.get(i);
            PlansPlanunits bean = new PlansPlanunits();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setUnits(entity.getUnits());
            bean.setUnitsLabel(entity.getUnitsLabel());
            bean.setUnitsRollover(entity.getUnitsRollover());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanunits mapBean(PlansPlanunitsEntity entity) {
        PlansPlanunits bean = new PlansPlanunits();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setUnits(entity.getUnits());
        bean.setUnitsLabel(entity.getUnitsLabel());
        bean.setUnitsRollover(entity.getUnitsRollover());

        return bean;
    }

    public PlansPlanunitsEntity mapBeanToEntity(PlansPlanunits bean, PlansPlanunitsEntity existEntity) {
        PlansPlanunitsEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setUnits(bean.getUnits());
        updateEntity.setUnitsLabel(bean.getUnitsLabel());
        updateEntity.setUnitsRollover(bean.getUnitsRollover());

        return updateEntity;
    }

    public PlansPlanunitsEntity mapBeanToEntity(PlansPlanunits bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanunitsEntity updateEntity = new PlansPlanunitsEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setUnits(bean.getUnits());
        updateEntity.setUnitsLabel(bean.getUnitsLabel());
        updateEntity.setUnitsRollover(bean.getUnitsRollover());

        return updateEntity;
    }
}

