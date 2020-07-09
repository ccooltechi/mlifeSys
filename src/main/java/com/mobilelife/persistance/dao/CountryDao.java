package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.Countries;

public class CountryDao {
	private static Logger logger = LoggerFactory.getLogger(CountryDao.class);

	public CountryDao()
	{
		
	}
	
	public List<Countries> findAll()
	{
		Session session = HibernateSessionManager.getSession();
		List<Countries> countriesList = null;
		Query query = session.getNamedQuery("Countries.findAll");
		System.out.println("Size = "+query.list().size());
		countriesList = (List<Countries>)query.list();
		return countriesList;
	}
	public Countries findById(Integer id)
	{
		Session session = HibernateSessionManager.getSession();
		Countries country = null;
		Query query = session.getNamedQuery("Countries.findById");
		query.setParameter("id", id);
		System.out.println("findPlansByCountryByID = "+id);
		country = (Countries)(query.list().get(0));
		return country;
	}
	

	public List<Countries> findByName(String countryName)
	{
		Session session = HibernateSessionManager.getSession();
		List<Countries> countriesList = null;
		Query query = session.getNamedQuery("Countries.findByCountryName");
		query.setParameter("countryName", countryName);
		System.out.println("findPlansByCountryByName = "+countryName);
		countriesList = (List<Countries>)query.list();
		return countriesList;
	}
	
	public List<Countries> findByCode(String countryCode)
	{
		Session session = HibernateSessionManager.getSession();
		List<Countries> countriesList = null;
		Query query = session.getNamedQuery("Countries.findByCountryCode");
		query.setParameter("countryCode", countryCode);
		System.out.println("Size = "+query.list().size());
		countriesList = (List<Countries>)query.list();
		return countriesList;
	}

	public List<Countries> findByCodes(String countryCode)
	{
		Session session = HibernateSessionManager.getSession();
		List<Countries> countriesList = null;
		try
		{
			String query = "Select * from countries where country_code in("+countryCode+")";
			logger.debug("query in findBucketByCountry in  countries " + query);
			List<Countries> resultList = null;
			resultList = new HibernateDAO().findBySQLQuery(session, Countries.class, query,"countries");
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
	

	public boolean saveData(Countries entityObj) {
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

	public boolean updateData(Countries entityObj) {
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

	public boolean deleteData(Countries entityObj) {
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
