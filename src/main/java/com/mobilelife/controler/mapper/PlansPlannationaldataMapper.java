package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlannationaldataBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlannationaldata;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlannationaldataMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlannationaldataMapper.class);

    public List<PlansPlannationaldataBean> mapBean(List<PlansPlannationaldata> entityList) {
        List<PlansPlannationaldataBean> retBean = new ArrayList<PlansPlannationaldataBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlannationaldata entity = entityList.get(i);
            PlansPlannationaldataBean bean = new PlansPlannationaldataBean();
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
    
    public PlansPlannationaldataBean mapBean(PlansPlannationaldata entity) {
        PlansPlannationaldataBean bean = new PlansPlannationaldataBean();
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

    public PlansPlannationaldata mapBeanToEntity(PlansPlannationaldataBean bean, PlansPlannationaldata existEntity) {
        PlansPlannationaldata updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setDataNationalGb(bean.getDataNationalGb());
        updateEntity.setDataNationalGbDiscount(bean.getDataNationalGbDiscount());
        updateEntity.setDataNationalGbUnitrate(bean.getDataNationalGbUnitrate());
        updateEntity.setDataNationalGbWas(bean.getDataNationalGbWas());
        updateEntity.setDataNationalRollOverGb(bean.getDataNationalRollOverGb());

        return updateEntity;
    }

    public PlansPlannationaldata mapBeanToEntity(PlansPlannationaldataBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlannationaldata updateEntity = new PlansPlannationaldata();
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

