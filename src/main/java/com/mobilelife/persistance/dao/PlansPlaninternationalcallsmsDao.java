package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanflexi;
import com.mobilelife.persistance.entities.PlansPlaninternationalcallsms;

public class PlansPlaninternationalcallsmsDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalcallsmsDao.class);

	public PlansPlaninternationalcallsmsDao()
	{
		
	}
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlaninternationalcallsms> resultList = null;

			String query = "Select * from plans_planinternationalcallsms order by id desc";
			logger.debug("query in findID in  plans_planinternationalcallsms " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlaninternationalcallsms.class, query,"plans_planinternationalcallsms");

			logger.debug("findID  in  plans_planinternationalcallsms Size = "+resultList.size());
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
	
	public boolean saveData(PlansPlaninternationalcallsms entityObj) {
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
	
	public boolean updateData(PlansPlaninternationalcallsms entityObj) {
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
	
	public PlansPlaninternationalcallsms findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlaninternationalcallsms entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlaninternationalcallsms.findById");
			query.setParameter("id", id);
			entity = (PlansPlaninternationalcallsms)(query.list().get(0));
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
