package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.Countries;
import com.mobilelife.controler.mapper.bean.PlansOperator;
import com.mobilelife.persistance.entities.CountriesEntity;
import com.mobilelife.persistance.entities.PlansOperatorEntity;

public class PlansOperatorMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansOperatorMapper.class);

	public List<PlansOperator> mapBean(List<PlansOperatorEntity> entityList) {
		List<PlansOperator> retBean = new ArrayList<PlansOperator>();
		for (int i=0; i<entityList.size();i++)
		{
			PlansOperatorEntity entity = entityList.get(i);
			PlansOperator bean = new PlansOperator();
			bean.setId(entity.getId());
			bean.setLogo(entity.getLogo());
			bean.setIsActive(entity.getIsActive());
			bean.setOperatorName(entity.getOperatorName());
			bean.setSupportOnline(entity.isSupportOnline());
			bean.setSupportRetail(entity.isSupportRetail());
			retBean.add(bean);
		}
		return retBean;
	}
	
	public PlansOperator mapBean(PlansOperatorEntity entity) {
		PlansOperator bean = new PlansOperator();
		bean.setId(entity.getId());
		bean.setLogo(entity.getLogo());
		bean.setIsActive(entity.getIsActive());
		bean.setOperatorName(entity.getOperatorName());
		bean.setSupportOnline(entity.isSupportOnline());
		bean.setSupportRetail(entity.isSupportRetail());
		return bean;
	}

	public PlansOperatorEntity mapBeanToEntity(PlansOperator bean, PlansOperatorEntity existEntity) {
		PlansOperatorEntity updateEntity = existEntity;
		updateEntity.setIsActive(bean.getIsActive());
		updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
		updateEntity.setLogo(bean.getLogo());
		updateEntity.setSupportOnline(bean.isSupportOnline());
		updateEntity.setSupportRetail(bean.isSupportRetail());
		return updateEntity;
	}

	public PlansOperatorEntity mapBeanToEntity(PlansOperator bean) {
		PlansOperatorEntity updateEntity = new PlansOperatorEntity();
		updateEntity.setCreationDatetime(new Timestamp(System.currentTimeMillis()));
		updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
		updateEntity.setOperatorName(bean.getOperatorName());
		updateEntity.setIsActive(bean.getIsActive());
		updateEntity.setLogo(bean.getLogo());
		updateEntity.setSupportOnline(bean.isSupportOnline());
		updateEntity.setSupportRetail(bean.isSupportRetail());
		return updateEntity;
	}
}

