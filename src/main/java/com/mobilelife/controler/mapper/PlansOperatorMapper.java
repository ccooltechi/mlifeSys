package com.mobilelife.controler.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.controler.mapper.bean.CountriesBean;
import com.mobilelife.controler.mapper.bean.PlansOperatorBean;
import com.mobilelife.persistance.entities.Countries;
import com.mobilelife.persistance.entities.PlansOperator;

public class PlansOperatorMapper {
	private static Logger logger = LoggerFactory.getLogger(PlansOperatorMapper.class);

	public List<PlansOperatorBean> mapBean(List<PlansOperator> entityList) {
		List<PlansOperatorBean> retBean = new ArrayList<PlansOperatorBean>();
		for (int i=0; i<entityList.size();i++)
		{
			PlansOperator entity = entityList.get(i);
			PlansOperatorBean bean = new PlansOperatorBean();
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
	
	public PlansOperatorBean mapBean(PlansOperator entity) {
		PlansOperatorBean bean = new PlansOperatorBean();
		bean.setId(entity.getId());
		bean.setLogo(entity.getLogo());
		bean.setIsActive(entity.getIsActive());
		bean.setOperatorName(entity.getOperatorName());
		bean.setSupportOnline(entity.isSupportOnline());
		bean.setSupportRetail(entity.isSupportRetail());
		return bean;
	}

	public PlansOperator mapBeanToEntity(PlansOperatorBean bean, PlansOperator existEntity) {
		PlansOperator updateEntity = existEntity;
		updateEntity.setIsActive(bean.getIsActive());
		updateEntity.setLastModifiedDatetime(new Timestamp(System.currentTimeMillis()));
		updateEntity.setLogo(bean.getLogo());
		updateEntity.setSupportOnline(bean.isSupportOnline());
		updateEntity.setSupportRetail(bean.isSupportRetail());
		return updateEntity;
	}

	public PlansOperator mapBeanToEntity(PlansOperatorBean bean) {
		PlansOperator updateEntity = new PlansOperator();
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

