package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlaninternationalmms;
import com.mobilelife.persistance.entities.PlansPlaninternationalsms;

public class PlansPlaninternationalsmsDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalsmsDao.class);

	public PlansPlaninternationalsmsDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlaninternationalsms> resultList = null;

			String query = "Select * from plans_planinternationalsms order by id desc";
			logger.debug("query in findID in  PlansPlaninternationalsms " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlaninternationalsms.class, query,"plans_planinternationalsms");

			logger.debug("findID  in  PlansPlaninternationalsms Size = "+resultList.size());
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

	public boolean saveData(PlansPlaninternationalsms entityObj) {
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
	
	public boolean updateData(PlansPlaninternationalsms entityObj) {
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
	
	public PlansPlaninternationalsms findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlaninternationalsms entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlaninternationalsms.findById");
			query.setParameter("id", id);
			entity = (PlansPlaninternationalsms)(query.list().get(0));
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
