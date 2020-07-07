package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlaninternationalcallsms;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlaninternationalcallsmsEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansPlaninternationalcallsmsMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalcallsmsMapper.class);

    public List<PlansPlaninternationalcallsms> mapBean(List<PlansPlaninternationalcallsmsEntity> entityList) {
        List<PlansPlaninternationalcallsms> retBean = new ArrayList<PlansPlaninternationalcallsms>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlaninternationalcallsmsEntity entity = entityList.get(i);
            PlansPlaninternationalcallsms bean = new PlansPlaninternationalcallsms();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setInternationalSmsCalls(entity.getInternationalSmsCalls());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlaninternationalcallsms mapBean(PlansPlaninternationalcallsmsEntity entity) {
        PlansPlaninternationalcallsms bean = new PlansPlaninternationalcallsms();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setInternationalSmsCalls(entity.getInternationalSmsCalls());

        return bean;
    }

    public PlansPlaninternationalcallsmsEntity mapBeanToEntity(PlansPlaninternationalcallsms bean, PlansPlaninternationalcallsmsEntity existEntity) {
        PlansPlaninternationalcallsmsEntity updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setInternationalSmsCalls(bean.getInternationalSmsCalls());

        return updateEntity;
    }

    public PlansPlaninternationalcallsmsEntity mapBeanToEntity(PlansPlaninternationalcallsms bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimaryEntity plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlaninternationalcallsmsEntity updateEntity = new PlansPlaninternationalcallsmsEntity();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setInternationalSmsCalls(bean.getInternationalSmsCalls());

        return updateEntity;
    }
}

