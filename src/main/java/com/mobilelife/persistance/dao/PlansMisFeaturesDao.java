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
import com.mobilelife.persistance.entities.PlansMisFeaturesEntity;
import com.mobilelife.persistance.entities.PlansPlanaddonsEntity;
import com.mobilelife.persistance.entities.PlansPlanflexiEntity;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansMisFeaturesDao {
	private static Logger logger = LoggerFactory.getLogger(PlansMisFeaturesDao.class);

	public PlansMisFeaturesDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansMisFeaturesEntity> resultList = null;

			String query = "Select * from plans_mis_features order by id desc limit 1";
			logger.debug("query in findID in  plans_mis_features " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansMisFeaturesEntity.class, query,"plans_mis_features");

			logger.debug("findID  in  plans_mis_features Size = ");
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


	public void saveData(PlansMisFeaturesEntity entityObj) {
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
	

	public List<PlansMisFeaturesEntity> findMisFeaturebyPlansID(Integer planid)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansMisFeaturesEntity> resultList = null;
		try {

			String query = "Select * from plans_mis_features where plan_primary_id="+planid;
			logger.debug("query in findID in  plans_mis_features " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansMisFeaturesEntity.class, query,"plans_mis_features");

			logger.debug("findID  in  plans_mis_features Size = ");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return resultList;
	}

}
