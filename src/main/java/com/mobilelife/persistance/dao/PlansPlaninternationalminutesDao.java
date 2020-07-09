package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlaninternationalcallsms;
import com.mobilelife.persistance.entities.PlansPlaninternationalminutes;

public class PlansPlaninternationalminutesDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalminutesDao.class);

	public PlansPlaninternationalminutesDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlaninternationalminutes> resultList = null;

			String query = "Select * from plans_planinternationalminutes order by id desc";
			logger.debug("query in findID in  PlansPlaninternationalminutes " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlaninternationalminutes.class, query,"plans_planinternationalminutes");

			logger.debug("findID  in  PlansPlaninternationalminutes Size = "+resultList.size());
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

	public boolean saveData(PlansPlaninternationalminutes entityObj) {
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

	public boolean updateData(PlansPlaninternationalminutes entityObj) {
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
	
	public PlansPlaninternationalminutes findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlaninternationalminutes entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlaninternationalminutes.findById");
			query.setParameter("id", id);
			entity = (PlansPlaninternationalminutes)(query.list().get(0));
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
