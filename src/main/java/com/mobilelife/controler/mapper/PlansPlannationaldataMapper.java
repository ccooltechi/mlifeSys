package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlannationaldata;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlannationaldataEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansPlannationaldataMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlannationaldataMapper.class);

    public List<PlansPlannationaldata> mapBean(List<PlansPlannationaldataEntity> entityList) {
        List<PlansPlannationaldata> retBean = new ArrayList<PlansPlannationaldata>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlannationaldataEntity entity = entityList.get(i);
            PlansPlannationaldata bean = new PlansPlannationaldata();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setDataNationalGb(entity.getDataNationalGb());
            bean.setDataNationalGbDiscount(entity.getDataNationalGbDiscount());
            bean.setDataNationalGbUnitrate(entity.getDataNationalGbUnitrate());
            bean.setDataNationalGbWas(entity.getDataNationalGbWas());
            bean.setDataNationalRollOverGb(entity.getDataNationalRollOverGb());

            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlannationaldata mapBean(PlansPlannationaldataEntity entity) {
        PlansPlannationaldata bean = new PlansPlannationaldata();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setDataNationalGb(entity.getDataNationalGb());
        bean.setDataNationalGbDiscount(entity.getDataNationalGbDiscount());
        bean.setDataNationalGbUnitrate(entity.getDataNationalGbUnitrate());
        bean.setDataNationalGbWas(entity.getDataNationalGbWas());
        bean.setDataNationalRollOverGb(entity.getDataNationalRollOverGb());

        return bean;
    }

    public PlansPlannationaldataEntity mapBeanToEntity(PlansPlannationaldata bean, PlansPlannationaldataEntity existEntity) {
        PlansPlannationaldataEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setDataNationalGb(bean.getDataNationalGb());
        updateEntity.setDataNationalGbDiscount(bean.getDataNationalGbDiscount());
        updateEntity.setDataNationalGbUnitrate(bean.getDataNationalGbUnitrate());
        updateEntity.setDataNationalGbWas(bean.getDataNationalGbWas());
        updateEntity.setDataNationalRollOverGb(bean.getDataNationalRollOverGb());

        return updateEntity;
    }

    public PlansPlannationaldataEntity mapBeanToEntity(PlansPlannationaldata bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlannationaldataEntity updateEntity = new PlansPlannationaldataEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setDataNationalGb(bean.getDataNationalGb());
        updateEntity.setDataNationalGbDiscount(bean.getDataNationalGbDiscount());
        updateEntity.setDataNationalGbUnitrate(bean.getDataNationalGbUnitrate());
        updateEntity.setDataNationalGbWas(bean.getDataNationalGbWas());
        updateEntity.setDataNationalRollOverGb(bean.getDataNationalRollOverGb());

        return updateEntity;
    }
}

