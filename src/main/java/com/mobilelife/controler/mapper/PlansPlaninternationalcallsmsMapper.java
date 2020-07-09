package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlaninternationalcallsmsBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlaninternationalcallsms;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlaninternationalcallsmsMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalcallsmsMapper.class);

    public List<PlansPlaninternationalcallsmsBean> mapBean(List<PlansPlaninternationalcallsms> entityList) {
        List<PlansPlaninternationalcallsmsBean> retBean = new ArrayList<PlansPlaninternationalcallsmsBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlaninternationalcallsms entity = entityList.get(i);
            PlansPlaninternationalcallsmsBean bean = new PlansPlaninternationalcallsmsBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setInternationalSmsCalls(entity.getInternationalSmsCalls());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlaninternationalcallsmsBean mapBean(PlansPlaninternationalcallsms entity) {
        PlansPlaninternationalcallsmsBean bean = new PlansPlaninternationalcallsmsBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setInternationalSmsCalls(entity.getInternationalSmsCalls());

        return bean;
    }

    public PlansPlaninternationalcallsms mapBeanToEntity(PlansPlaninternationalcallsmsBean bean, PlansPlaninternationalcallsms existEntity) {
        PlansPlaninternationalcallsms updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setInternationalSmsCalls(bean.getInternationalSmsCalls());

        return updateEntity;
    }

    public PlansPlaninternationalcallsms mapBeanToEntity(PlansPlaninternationalcallsmsBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlaninternationalcallsms updateEntity = new PlansPlaninternationalcallsms();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setInternationalSmsCalls(bean.getInternationalSmsCalls());

        return updateEntity;
    }
}

