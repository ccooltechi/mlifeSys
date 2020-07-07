package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanflexismsEntity;

public class PlansPlanFlexiSMSDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanFlexiSMSDao.class);

	public PlansPlanFlexiSMSDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanflexismsEntity> resultList = null;

			String query = "Select * from plans_planflexisms order by id desc";
			logger.debug("query in findID in  PlansPlanflexisms " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlanflexismsEntity.class, query,"plans_planflexisms");

			logger.debug("findID  in  PlansPlanflexisms Size = "+resultList.size());
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

	public boolean saveData(PlansPlanflexismsEntity entityObj) {
		boolean retVal = false;;
		Session session = HibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(entityObj);
			tx.commit();
			retVal = true;;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
			retVal = false;;
		} finally {
			session.close();
		}
		return retVal;
	}

	public boolean updateData(PlansPlanflexismsEntity entityObj) {
		boolean retVal = false;;
		Session session = HibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(entityObj);
			tx.commit();
			retVal = true;;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
			retVal = false;;
		} finally {
			session.close();
		}
		return retVal;
	}

	public PlansPlanflexismsEntity findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlanflexismsEntity entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlanflexismsEntity.findById");
			query.setParameter("id", id);
			entity = (PlansPlanflexismsEntity)(query.list().get(0));
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
