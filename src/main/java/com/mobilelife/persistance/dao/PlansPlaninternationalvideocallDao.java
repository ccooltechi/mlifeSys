package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlaninternationalsms;
import com.mobilelife.persistance.entities.PlansPlaninternationalvideocall;

public class PlansPlaninternationalvideocallDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalvideocallDao.class);

	public PlansPlaninternationalvideocallDao()
	{
		
	}

	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlaninternationalvideocall> resultList = null;

			String query = "Select * from plans_planinternationalvideocall order by id desc";
			logger.debug("query in findID in  PlansPlaninternationalvideocall " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlaninternationalvideocall.class, query,"plans_planinternationalvideocall");

			logger.debug("findID  in  PlansPlaninternationalvideocall Size = "+resultList.size());
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

	public boolean saveData(PlansPlaninternationalvideocall entityObj) {
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

	public boolean updateData(PlansPlaninternationalvideocall entityObj) {
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

	public PlansPlaninternationalvideocall findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlaninternationalvideocall entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlaninternationalvideocall.findById");
			query.setParameter("id", id);
			entity = (PlansPlaninternationalvideocall)(query.list().get(0));
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
