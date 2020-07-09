package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlannationalminutes;
import com.mobilelife.persistance.entities.PlansPlannationalminutesoffnet;

public class PlansPlannationalminutesoffnetDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlannationalminutesoffnetDao.class);

	public PlansPlannationalminutesoffnetDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlannationalminutesoffnet> resultList = null;

			String query = "Select * from plans_plannationalminutesoffnet order by id desc";
			logger.debug("query in findID in  PlansPlannationalminutesoffnet " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlannationalminutesoffnet.class, query,"plans_plannationalminutesoffnet");

			logger.debug("findID  in  PlansPlannationalminutesoffnet Size = "+resultList.size());
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

	public PlansPlannationalminutesoffnet findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlannationalminutesoffnet entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlannationalminutesoffnet.findById");
			query.setParameter("id", id);
			entity = (PlansPlannationalminutesoffnet)(query.list().get(0));
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

	public boolean saveData(PlansPlannationalminutesoffnet entityObj) {
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

	public boolean updateData(PlansPlannationalminutesoffnet entityObj) {
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
