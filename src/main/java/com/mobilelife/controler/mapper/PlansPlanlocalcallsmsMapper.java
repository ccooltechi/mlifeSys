package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanlocalcallsms;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanlocalcallsmsEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansPlanlocalcallsmsMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanlocalcallsmsMapper.class);

    public List<PlansPlanlocalcallsms> mapBean(List<PlansPlanlocalcallsmsEntity> entityList) {
        List<PlansPlanlocalcallsms> retBean = new ArrayList<PlansPlanlocalcallsms>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanlocalcallsmsEntity entity = entityList.get(i);
            PlansPlanlocalcallsms bean = new PlansPlanlocalcallsms();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setLocalCallSms(entity.getLocalCallSms());
            bean.setLocalCallSmsPulse(entity.getLocalCallSmsPulse());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanlocalcallsms mapBean(PlansPlanlocalcallsmsEntity entity) {
        PlansPlanlocalcallsms bean = new PlansPlanlocalcallsms();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setLocalCallSms(entity.getLocalCallSms());
        bean.setLocalCallSmsPulse(entity.getLocalCallSmsPulse());

        return bean;
    }

    public PlansPlanlocalcallsmsEntity mapBeanToEntity(PlansPlanlocalcallsms bean, PlansPlanlocalcallsmsEntity existEntity) {
        PlansPlanlocalcallsmsEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLocalCallSms(bean.getLocalCallSms());
        updateEntity.setLocalCallSmsPulse(bean.getLocalCallSmsPulse());

        return updateEntity;
    }

    public PlansPlanlocalcallsmsEntity mapBeanToEntity(PlansPlanlocalcallsms bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanlocalcallsmsEntity updateEntity = new PlansPlanlocalcallsmsEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLocalCallSms(bean.getLocalCallSms());
        updateEntity.setLocalCallSmsPulse(bean.getLocalCallSmsPulse());

        return updateEntity;
    }
}

