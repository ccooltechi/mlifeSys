package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanbucketEntity;

public class PlansPlanBucketDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanBucketDao.class);

	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanbucketEntity> resultList = null;

			String query = "Select * from plans_planbucket order by id desc";
			logger.debug("query in findID in  plans_planbucket " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlanbucketEntity.class, query,"plans_planbucket");

			logger.debug("findID  in  plans_planbucket Size = ");
			if ((null!=resultList) && (resultList.size()>0))
			{
				rid = resultList.get(0).getId();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return rid;
	}

	
	public PlansPlanbucketEntity findBucketByCountry(int plan_id, int countryid)
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		PlansPlanbucketEntity plansPlanbucket = null;
		try {
			List<PlansPlanbucketEntity> resultList = null;

			String query = "Select * from plans_planbucket where is_active=1 and plan_primary_id = "+plan_id+" and country_id ="+countryid;
			logger.debug("query in findBucketByCountry in  plans_planbucket " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlanbucketEntity.class, query,"plans_planbucket");

			logger.debug("findID  in  plans_planbucket Size = ");
			if ((null!=resultList) && (resultList.size()>0))
			{
				plansPlanbucket = resultList.get(0); 
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return plansPlanbucket;
	}
	
	public void saveData(PlansPlanbucketEntity entityObj) {
		Session session = HibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(entityObj);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

}
