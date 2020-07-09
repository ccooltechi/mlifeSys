package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansPlanpreferrednumbersBean;
import com.mobilelife.persistance.dao.PlansPlanprimaryDao;
import com.mobilelife.persistance.entities.PlansPlanpreferrednumbers;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlanpreferrednumbersMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanpreferrednumbersMapper.class);

    public List<PlansPlanpreferrednumbersBean> mapBean(List<PlansPlanpreferrednumbers> entityList) {
        List<PlansPlanpreferrednumbersBean> retBean = new ArrayList<PlansPlanpreferrednumbersBean>();
        for (int i=0; i<entityList.size();i++)
        {
            PlansPlanpreferrednumbers entity = entityList.get(i);
            PlansPlanpreferrednumbersBean bean = new PlansPlanpreferrednumbersBean();
            bean.setId(entity.getId());
            bean.setIsActive(entity.getIsActive());
            bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
            bean.setPreferredNumbersCallsmin(entity.getPreferredNumbersCallsmin());
            bean.setPreferredNumbersCallsminOffnet(entity.getPreferredNumbersCallsminOffnet());
            bean.setPreferredNumbersCallsminOnnet(entity.getPreferredNumbersCallsminOnnet());
            bean.setPrefferedNumbersNboflines(entity.getPrefferedNumbersNboflines());
            bean.setPrefferedNumbersNboflinesOffnet(entity.getPrefferedNumbersNboflinesOffnet());
            bean.setPrefferedNumbersUnits(entity.getPrefferedNumbersUnits());
            bean.setPrefferedNumbersUnitsOffnet(entity.getPrefferedNumbersUnitsOffnet());
            bean.setPrefferedNumbersUnitsOnnet(entity.getPrefferedNumbersUnitsOnnet());
            bean.setPrefferedNumbersNboflinesOnnet(entity.getPrefferedNumbersNboflinesOnnet());
            retBean.add(bean);
        }
        return retBean;
    }
    
    public PlansPlanpreferrednumbersBean mapBean(PlansPlanpreferrednumbers entity) {
        PlansPlanpreferrednumbersBean bean = new PlansPlanpreferrednumbersBean();
        bean.setId(entity.getId());
        bean.setIsActive(entity.getIsActive());
        bean.setPlanPrimaryId(entity.getPlanPrimaryId().getId());
        bean.setPreferredNumbersCallsmin(entity.getPreferredNumbersCallsmin());
        bean.setPreferredNumbersCallsminOffnet(entity.getPreferredNumbersCallsminOffnet());
        bean.setPreferredNumbersCallsminOnnet(entity.getPreferredNumbersCallsminOnnet());
        bean.setPrefferedNumbersNboflines(entity.getPrefferedNumbersNboflines());
        bean.setPrefferedNumbersNboflinesOffnet(entity.getPrefferedNumbersNboflinesOffnet());
        bean.setPrefferedNumbersUnits(entity.getPrefferedNumbersUnits());
        bean.setPrefferedNumbersUnitsOffnet(entity.getPrefferedNumbersUnitsOffnet());
        bean.setPrefferedNumbersUnitsOnnet(entity.getPrefferedNumbersUnitsOnnet());
        bean.setPrefferedNumbersNboflinesOnnet(entity.getPrefferedNumbersNboflinesOnnet());

        return bean;
    }

    public PlansPlanpreferrednumbers mapBeanToEntity(PlansPlanpreferrednumbersBean bean, PlansPlanpreferrednumbers existEntity) {
        PlansPlanpreferrednumbers updateEntity = existEntity;
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPreferredNumbersCallsmin(bean.getPreferredNumbersCallsmin());
        updateEntity.setPreferredNumbersCallsminOffnet(bean.getPreferredNumbersCallsminOffnet());
        updateEntity.setPreferredNumbersCallsminOnnet(bean.getPreferredNumbersCallsminOnnet());
        updateEntity.setPrefferedNumbersNboflines(bean.getPrefferedNumbersNboflines());
        updateEntity.setPrefferedNumbersNboflinesOffnet(bean.getPrefferedNumbersNboflinesOffnet());
        updateEntity.setPrefferedNumbersUnits(bean.getPrefferedNumbersUnits());
        updateEntity.setPrefferedNumbersUnitsOffnet(bean.getPrefferedNumbersUnitsOffnet());
        updateEntity.setPrefferedNumbersUnitsOnnet(bean.getPrefferedNumbersUnitsOnnet());
        updateEntity.setPrefferedNumbersNboflinesOnnet(bean.getPrefferedNumbersNboflinesOnnet());

        return updateEntity;
    }

    public PlansPlanpreferrednumbers mapBeanToEntity(PlansPlanpreferrednumbersBean bean) {
        PlansPlanprimaryDao planrepository = new PlansPlanprimaryDao();
        PlansPlanprimary plansPlanprimaryEntity = planrepository.findById(bean.getPlanPrimaryId());
        PlansPlanpreferrednumbers updateEntity = new PlansPlanpreferrednumbers();
        updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
        updateEntity.setPlanPrimaryId(plansPlanprimaryEntity);
        updateEntity.setIsActive(bean.getIsActive());
        updateEntity.setPreferredNumbersCallsmin(bean.getPreferredNumbersCallsmin());
        updateEntity.setPreferredNumbersCallsminOffnet(bean.getPreferredNumbersCallsminOffnet());
        updateEntity.setPreferredNumbersCallsminOnnet(bean.getPreferredNumbersCallsminOnnet());
        updateEntity.setPrefferedNumbersNboflines(bean.getPrefferedNumbersNboflines());
        updateEntity.setPrefferedNumbersNboflinesOffnet(bean.getPrefferedNumbersNboflinesOffnet());
        updateEntity.setPrefferedNumbersUnits(bean.getPrefferedNumbersUnits());
        updateEntity.setPrefferedNumbersUnitsOffnet(bean.getPrefferedNumbersUnitsOffnet());
        updateEntity.setPrefferedNumbersUnitsOnnet(bean.getPrefferedNumbersUnitsOnnet());
        updateEntity.setPrefferedNumbersNboflinesOnnet(bean.getPrefferedNumbersNboflinesOnnet());

        return updateEntity;
    }
}

