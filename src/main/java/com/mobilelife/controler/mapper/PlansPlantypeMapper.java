package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansOperator;
import com.mobilelife.controler.mapper.bean.PlansPlantype;
import com.mobilelife.persistance.entities.PlansOperatorEntity;
import com.mobilelife.persistance.entities.PlansPlantypeEntity;

public class PlansPlantypeMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlantypeMapper.class);

	public List<PlansPlantype> mapBean(List<PlansPlantypeEntity> entityList) {
		List<PlansPlantype> retBean = new ArrayList<PlansPlantype>();
		for (int i=0; i<entityList.size();i++)
		{
			PlansPlantypeEntity entity = entityList.get(i);
			PlansPlantype bean = new PlansPlantype();
			bean.setId(entity.getId());
			bean.setActive(entity.getIsActive());
			bean.setPlanType(entity.getPlanType());
			bean.setPlanLabel(entity.getPlanLabel());
			retBean.add(bean);
		}
		return retBean;
	}
	
	public PlansPlantype mapBean(PlansPlantypeEntity entity) {
		PlansPlantype bean = new PlansPlantype();
		bean.setId(entity.getId());
		bean.setActive(entity.getIsActive());
		bean.setPlanType(entity.getPlanType());
		bean.setPlanLabel(entity.getPlanLabel());
		return bean;
	}

	public PlansPlantypeEntity mapBeanToEntity(PlansPlantype bean, PlansPlantypeEntity existEntity) {
		PlansPlantypeEntity updateEntity = existEntity;
		updateEntity.setIsActive(bean.isActive());
		updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
		updateEntity.setPlanType(bean.getPlanType());
		updateEntity.setPlanLabel(bean.getPlanLabel());
		return updateEntity;
	}

	public PlansPlantypeEntity mapBeanToEntity(PlansPlantype bean) {
		PlansPlantypeEntity updateEntity = new PlansPlantypeEntity();
		updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
		updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
		updateEntity.setIsActive(bean.isActive());
		updateEntity.setPlanType(bean.getPlanType());
		updateEntity.setPlanLabel(bean.getPlanLabel());
		return updateEntity;
	}
}

