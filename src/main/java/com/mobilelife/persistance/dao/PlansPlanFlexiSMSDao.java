package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanflexisms;

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
			List<PlansPlanflexisms> resultList = null;

			String query = "Select * from plans_planflexisms order by id desc";
			logger.debug("query in findID in  PlansPlanflexisms " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlanflexisms.class, query,"plans_planflexisms");

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

	public boolean saveData(PlansPlanflexisms entityObj) {
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

	public boolean updateData(PlansPlanflexisms entityObj) {
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

	public PlansPlanflexisms findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlanflexisms entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlanflexisms.findById");
			query.setParameter("id", id);
			entity = (PlansPlanflexisms)(query.list().get(0));
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
