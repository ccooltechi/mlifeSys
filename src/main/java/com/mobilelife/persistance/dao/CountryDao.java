package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.CountriesEntity;

public class CountryDao {
	private static Logger logger = LoggerFactory.getLogger(CountryDao.class);

	public CountryDao()
	{
		
	}
	
	public List<CountriesEntity> findAll()
	{
		Session session = HibernateSessionManager.getSession();
		List<CountriesEntity> countriesList = null;
		Query query = session.getNamedQuery("CountriesEntity.findAll");
		System.out.println("Size = "+query.list().size());
		countriesList = (List<CountriesEntity>)query.list();
		return countriesList;
	}
	public CountriesEntity findById(Integer id)
	{
		Session session = HibernateSessionManager.getSession();
		CountriesEntity country = null;
		Query query = session.getNamedQuery("CountriesEntity.findById");
		query.setParameter("id", id);
		System.out.println("findPlansByCountryByID = "+id);
		country = (CountriesEntity)(query.list().get(0));
		return country;
	}
	

	public List<CountriesEntity> findByName(String countryName)
	{
		Session session = HibernateSessionManager.getSession();
		List<CountriesEntity> countriesList = null;
		Query query = session.getNamedQuery("CountriesEntity.findByCountryName");
		query.setParameter("countryName", countryName);
		System.out.println("findPlansByCountryByName = "+countryName);
		countriesList = (List<CountriesEntity>)query.list();
		return countriesList;
	}
	
	public List<CountriesEntity> findByCode(String countryCode)
	{
		Session session = HibernateSessionManager.getSession();
		List<CountriesEntity> countriesList = null;
		Query query = session.getNamedQuery("CountriesEntity.findByCountryCode");
		query.setParameter("countryCode", countryCode);
		System.out.println("Size = "+query.list().size());
		countriesList = (List<CountriesEntity>)query.list();
		return countriesList;
	}

	public List<CountriesEntity> findByCodes(String countryCode)
	{
		Session session = HibernateSessionManager.getSession();
		List<CountriesEntity> countriesList = null;
		try
		{
			String query = "Select * from countries where country_code in("+countryCode+")";
			logger.debug("query in findBucketByCountry in  countries " + query);
			List<CountriesEntity> resultList = null;
			resultList = new HibernateDAO().findBySQLQuery(session, CountriesEntity.class, query,"countries");
			logger.debug("findID  in  plans_planbucket Size = ");
			if ((null!=resultList) && (resultList.size()>0))
			{
				countriesList = resultList; 
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return countriesList;
	}
	

	public boolean saveData(CountriesEntity entityObj) {
		boolean retVal = false;
		Session session = HibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(entityObj);
			tx.commit();
			retVal = true;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return retVal;
	}

	public boolean updateData(CountriesEntity entityObj) {
		boolean retVal = false;
		Session session = HibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(entityObj);
			tx.commit();
			retVal = true;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return retVal;
	}

	public boolean deleteData(CountriesEntity entityObj) {
		boolean retVal = false;
		Session session = HibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(entityObj);
			tx.commit();
			retVal = true;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return retVal;
	}
}
