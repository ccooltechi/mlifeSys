package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanlocalmms;
import com.mobilelife.persistance.entities.PlansPlanlocalvideocall;

public class PlansPlanlocalvideocallDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanlocalvideocallDao.class);

	public PlansPlanlocalvideocallDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanlocalvideocall> resultList = null;

			String query = "Select * from plans_planlocalvideocall order by id desc";
			logger.debug("query in findID in  PlansPlanlocalvideocall " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlanlocalvideocall.class, query,"plans_planlocalvideocall");

			logger.debug("findID  in  PlansPlanlocalvideocall Size = "+resultList.size());
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

	public boolean saveData(PlansPlanlocalvideocall entityObj) {
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

	public boolean updateData(PlansPlanlocalvideocall entityObj) {
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

	public PlansPlanlocalvideocall findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlanlocalvideocall entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlanlocalvideocall.findById");
			query.setParameter("id", id);
			entity = (PlansPlanlocalvideocall)(query.list().get(0));
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
