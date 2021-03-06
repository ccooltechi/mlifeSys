package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanpreferrednumbers;
import com.mobilelife.persistance.entities.PlansPlanroamingdata;

public class PlansPlanroamingdataDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanroamingdataDao.class);

	public PlansPlanroamingdataDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanroamingdata> resultList = null;

			String query = "Select * from plans_planroamingdata order by id desc";
			logger.debug("query in findID in  PlansPlanroamingdata " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlanroamingdata.class, query,"plans_planroamingdata");

			logger.debug("findID  in  PlansPlanroamingdata Size = "+resultList.size());
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

	public boolean saveData(PlansPlanroamingdata entityObj) {
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

	public boolean updateData(PlansPlanroamingdata entityObj) {
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

	public PlansPlanroamingdata findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlanroamingdata entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlanroamingdata.findById");
			query.setParameter("id", id);
			entity = (PlansPlanroamingdata)(query.list().get(0));
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
