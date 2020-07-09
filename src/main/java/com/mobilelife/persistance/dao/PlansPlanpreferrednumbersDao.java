package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanoutofbundle;
import com.mobilelife.persistance.entities.PlansPlanpreferrednumbers;

public class PlansPlanpreferrednumbersDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanpreferrednumbersDao.class);

	public PlansPlanpreferrednumbersDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanpreferrednumbers> resultList = null;

			String query = "Select * from plans_planpreferrednumbers order by id desc";
			logger.debug("query in findID in  PlansPlanpreferrednumbers " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlanpreferrednumbers.class, query,"plans_planpreferrednumbers");

			logger.debug("findID  in  PlansPlanpreferrednumbers Size = "+resultList.size());
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

	public boolean saveData(PlansPlanpreferrednumbers entityObj) {
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

	public boolean updateData(PlansPlanpreferrednumbers entityObj) {
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

	public PlansPlanpreferrednumbers findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlanpreferrednumbers entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlanpreferrednumbers.findById");
			query.setParameter("id", id);
			entity = (PlansPlanpreferrednumbers)(query.list().get(0));
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
