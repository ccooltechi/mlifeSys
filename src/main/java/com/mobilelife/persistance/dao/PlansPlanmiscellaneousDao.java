package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanlocalvideocall;
import com.mobilelife.persistance.entities.PlansPlanmiscellaneous;

public class PlansPlanmiscellaneousDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanmiscellaneousDao.class);

	public PlansPlanmiscellaneousDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanmiscellaneous> resultList = null;

			String query = "Select * from plans_planmiscellaneous order by id desc";
			logger.debug("query in findID in  PlansPlanmiscellaneous " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlanmiscellaneous.class, query,"plans_planmiscellaneous");

			logger.debug("findID  in  PlansPlanmiscellaneous Size = "+resultList.size());
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

	public PlansPlanmiscellaneous findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlanmiscellaneous entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlanmiscellaneous.findById");
			query.setParameter("id", id);
			entity = (PlansPlanmiscellaneous)(query.list().get(0));
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

	public boolean saveData(PlansPlanmiscellaneous entityObj) {
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

	public boolean updateData(PlansPlanmiscellaneous entityObj) {
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

}
