package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlannationaldata;
import com.mobilelife.persistance.entities.PlansPlannationalminutes;

public class PlansPlannationalminutesDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlannationalminutesDao.class);

	public PlansPlannationalminutesDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlannationalminutes> resultList = null;

			String query = "Select * from plans_plannationalminutes order by id desc";
			logger.debug("query in findID in  PlansPlannationalminutes " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlannationalminutes.class, query,"plans_plannationalminutes");

			logger.debug("findID  in  PlansPlannationalminutes Size = "+resultList.size());
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

	public PlansPlannationalminutes findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlannationalminutes entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlannationalminutes.findById");
			query.setParameter("id", id);
			entity = (PlansPlannationalminutes)(query.list().get(0));
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

	
	public boolean saveData(PlansPlannationalminutes entityObj) {
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
		return retVal;	}

	public boolean updateData(PlansPlannationalminutes entityObj) {
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
