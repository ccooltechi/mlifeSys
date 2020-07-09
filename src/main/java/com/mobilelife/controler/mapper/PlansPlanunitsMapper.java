package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanunitsBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanprimary;
import com.mobilelife.persistance.entities.PlansPlanunits;

public class PlansPlanunitsMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanunitsMapper.class);

    public List<PlansPlanunitsBean> mapBean(List<PlansPlanunits> entityList) {
        List<PlansPlanunitsBean> retBean = new ArrayList<PlansPlanunitsBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanunits entity = entityList.get(i);
            PlansPlanunitsBean bean = new PlansPlanunitsBean();
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
    
    public PlansPlanunitsBean mapBean(PlansPlanunits entity) {
        PlansPlanunitsBean bean = new PlansPlanunitsBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setUnits(entity.getUnits());
        bean.setUnitsLabel(entity.getUnitsLabel());
        bean.setUnitsRollover(entity.getUnitsRollover());

        return bean;
    }

    public PlansPlanunits mapBeanToEntity(PlansPlanunitsBean bean, PlansPlanunits existEntity) {
        PlansPlanunits updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setUnits(bean.getUnits());
        updateEntity.setUnitsLabel(bean.getUnitsLabel());
        updateEntity.setUnitsRollover(bean.getUnitsRollover());

        return updateEntity;
    }

    public PlansPlanunits mapBeanToEntity(PlansPlanunitsBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanunits updateEntity = new PlansPlanunits();
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

