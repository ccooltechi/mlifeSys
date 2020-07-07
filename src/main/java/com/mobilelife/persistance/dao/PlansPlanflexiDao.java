package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlandataEntity;
import com.mobilelife.persistance.entities.PlansPlanflexiEntity;

public class PlansPlanflexiDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanflexiDao.class);

	public PlansPlanflexiDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanflexiEntity> resultList = null;

			String query = "Select * from plans_planflexi order by id desc limit 1";
			logger.debug("query in findID in  PlansPlanflexiDao " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlanflexiEntity.class, query,"plans_planflexi");

			logger.debug("findID  in  PlansPlanflexiDao Size = "+resultList.size());
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

	public boolean saveData(PlansPlanflexiEntity entityObj) {
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
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}

	public boolean updateData(PlansPlanflexiEntity entityObj) {
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
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}

	public PlansPlanflexiEntity findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlanflexiEntity entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlanflexiEntity.findById");
			query.setParameter("id", id);
			entity = (PlansPlanflexiEntity)(query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return entity;
	}

}
