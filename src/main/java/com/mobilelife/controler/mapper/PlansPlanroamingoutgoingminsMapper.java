package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanroamingoutgoingminsBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanprimary;
import com.mobilelife.persistance.entities.PlansPlanroamingoutgoingmins;

public class PlansPlanroamingoutgoingminsMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanroamingoutgoingminsMapper.class);

    public List<PlansPlanroamingoutgoingminsBean> mapBean(List<PlansPlanroamingoutgoingmins> entityList) {
        List<PlansPlanroamingoutgoingminsBean> retBean = new ArrayList<PlansPlanroamingoutgoingminsBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanroamingoutgoingmins entity = entityList.get(i);
            PlansPlanroamingoutgoingminsBean bean = new PlansPlanroamingoutgoingminsBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setRoamingOutgoingBucketcode(entity.getRoamingOutgoingBucketcode());
            bean.setRoamingOutgoingMins(entity.getRoamingOutgoingMins());
            bean.setRoamingOutgoingMinsPulse(entity.getRoamingOutgoingMinsPulse());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanroamingoutgoingminsBean mapBean(PlansPlanroamingoutgoingmins entity) {
        PlansPlanroamingoutgoingminsBean bean = new PlansPlanroamingoutgoingminsBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setRoamingOutgoingBucketcode(entity.getRoamingOutgoingBucketcode());
        bean.setRoamingOutgoingMins(entity.getRoamingOutgoingMins());
        bean.setRoamingOutgoingMinsPulse(entity.getRoamingOutgoingMinsPulse());

        return bean;
    }

    public PlansPlanroamingoutgoingmins mapBeanToEntity(PlansPlanroamingoutgoingminsBean bean, PlansPlanroamingoutgoingmins existEntity) {
        PlansPlanroamingoutgoingmins updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setRoamingOutgoingBucketcode(bean.getRoamingOutgoingBucketcode());
        updateEntity.setRoamingOutgoingMins(bean.getRoamingOutgoingMins());
        updateEntity.setRoamingOutgoingMinsPulse(bean.getRoamingOutgoingMinsPulse());

        return updateEntity;
    }

    public PlansPlanroamingoutgoingmins mapBeanToEntity(PlansPlanroamingoutgoingminsBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanroamingoutgoingmins updateEntity = new PlansPlanroamingoutgoingmins();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setRoamingOutgoingBucketcode(bean.getRoamingOutgoingBucketcode());
        updateEntity.setRoamingOutgoingMins(bean.getRoamingOutgoingMins());
        updateEntity.setRoamingOutgoingMinsPulse(bean.getRoamingOutgoingMinsPulse());

        return updateEntity;
    }
}

