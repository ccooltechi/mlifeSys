package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanlocalcallsmsBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanlocalcallsms;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlanlocalcallsmsMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanlocalcallsmsMapper.class);

    public List<PlansPlanlocalcallsmsBean> mapBean(List<PlansPlanlocalcallsms> entityList) {
        List<PlansPlanlocalcallsmsBean> retBean = new ArrayList<PlansPlanlocalcallsmsBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanlocalcallsms entity = entityList.get(i);
            PlansPlanlocalcallsmsBean bean = new PlansPlanlocalcallsmsBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setLocalCallSms(entity.getLocalCallSms());
            bean.setLocalCallSmsPulse(entity.getLocalCallSmsPulse());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanlocalcallsmsBean mapBean(PlansPlanlocalcallsms entity) {
        PlansPlanlocalcallsmsBean bean = new PlansPlanlocalcallsmsBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setLocalCallSms(entity.getLocalCallSms());
        bean.setLocalCallSmsPulse(entity.getLocalCallSmsPulse());

        return bean;
    }

    public PlansPlanlocalcallsms mapBeanToEntity(PlansPlanlocalcallsmsBean bean, PlansPlanlocalcallsms existEntity) {
        PlansPlanlocalcallsms updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLocalCallSms(bean.getLocalCallSms());
        updateEntity.setLocalCallSmsPulse(bean.getLocalCallSmsPulse());

        return updateEntity;
    }

    public PlansPlanlocalcallsms mapBeanToEntity(PlansPlanlocalcallsmsBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanlocalcallsms updateEntity = new PlansPlanlocalcallsms();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLocalCallSms(bean.getLocalCallSms());
        updateEntity.setLocalCallSmsPulse(bean.getLocalCallSmsPulse());

        return updateEntity;
    }
}

