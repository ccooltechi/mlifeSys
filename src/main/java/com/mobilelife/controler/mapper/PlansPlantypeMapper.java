package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.PlansOperatorBean;
import com.mobilelife.controler.mapper.bean.PlansPlantypeBean;
import com.mobilelife.persistance.entities.PlansOperator;
import com.mobilelife.persistance.entities.PlansPlantype;

public class PlansPlantypeMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansPlantypeMapper.class);

	public List<PlansPlantypeBean> mapBean(List<PlansPlantype> entityList) {
		List<PlansPlantypeBean> retBean = new ArrayList<PlansPlantypeBean>();
		for (int i=0; i<entityList.size();i++)
		{
			PlansPlantype entity = entityList.get(i);
			PlansPlantypeBean bean = new PlansPlantypeBean();
			bean.setId(entity.getId());
			bean.setActive(entity.getIsActive());
			bean.setPlanType(entity.getPlanType());
			bean.setPlanLabel(entity.getPlanLabel());
			retBean.add(bean);
		}
		return retBean;
	}
	
	public PlansPlantypeBean mapBean(PlansPlantype entity) {
		PlansPlantypeBean bean = new PlansPlantypeBean();
		bean.setId(entity.getId());
		bean.setActive(entity.getIsActive());
		bean.setPlanType(entity.getPlanType());
		bean.setPlanLabel(entity.getPlanLabel());
		return bean;
	}

	public PlansPlantype mapBeanToEntity(PlansPlantypeBean bean, PlansPlantype existEntity) {
		PlansPlantype updateEntity = existEntity;
		updateEntity.setIsActive(bean.isActive());
		updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
		updateEntity.setPlanType(bean.getPlanType());
		updateEntity.setPlanLabel(bean.getPlanLabel());
		return updateEntity;
	}

	public PlansPlantype mapBeanToEntity(PlansPlantypeBean bean) {
		PlansPlantype updateEntity = new PlansPlantype();
		updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
		updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
		updateEntity.setIsActive(bean.isActive());
		updateEntity.setPlanType(bean.getPlanType());
		updateEntity.setPlanLabel(bean.getPlanLabel());
		return updateEntity;
	}
}

