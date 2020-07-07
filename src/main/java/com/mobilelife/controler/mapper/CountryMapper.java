package com.mobilelife.controler.mapper;

import java.util.ArrayList;
import java.util.List;

import com.mobilelife.controler.mapper.bean.Countries;
import com.mobilelife.persistance.entities.CountriesEntity;

public class CountryMapper {

	public List<Countries> mapBean(List<CountriesEntity> entityList) {
		List<Countries> retBean = new ArrayList<Countries>();
		for (int i=0; i<entityList.size();i++)
		{
			CountriesEntity entity = entityList.get(i);
			Countries bean = new Countries();
			bean.setCountryCode(entity.getCountryCode());
			bean.setCountryName(entity.getCountryName());
			bean.setId(entity.getId());
			retBean.add(bean);
		}
		return retBean;
	}

	public Countries mapBean(CountriesEntity entity) {
		Countries bean = new Countries();
		bean.setCountryCode(entity.getCountryCode());
		bean.setCountryName(entity.getCountryName());
		bean.setId(entity.getId());
		return bean;
	}


}
