package com.mobilelife.controler.mapper;

import java.util.ArrayList;
import java.util.List;

import com.mobilelife.controler.mapper.bean.CountriesBean;
import com.mobilelife.persistance.entities.Countries;

public class CountryMapper {

	public List<CountriesBean> mapBean(List<Countries> entityList) {
		List<CountriesBean> retBean = new ArrayList<CountriesBean>();
		for (int i=0; i<entityList.size();i++)
		{
			Countries entity = entityList.get(i);
			CountriesBean bean = new CountriesBean();
			bean.setCountryCode(entity.getCountryCode());
			bean.setCountryName(entity.getCountryName());
			bean.setId(entity.getId());
			retBean.add(bean);
		}
		return retBean;
	}

	public CountriesBean mapBean(Countries entity) {
		CountriesBean bean = new CountriesBean();
		bean.setCountryCode(entity.getCountryCode());
		bean.setCountryName(entity.getCountryName());
		bean.setId(entity.getId());
		return bean;
	}


}
