package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlaninternationalsmsEntity;
import com.mobilelife.persistance.entities.PlansPlaninternationalvideocallEntity;

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
			List<PlansPlaninternationalvideocallEntity> resultList = null;

			String query = "Select * from plans_planinternationalvideocall order by id desc";
			logger.debug("query in findID in  PlansPlaninternationalvideocall " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlaninternationalvideocallEntity.class, query,"plans_planinternationalvideocall");

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

	public boolean saveData(PlansPlaninternationalvideocallEntity entityObj) {
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

	public boolean updateData(PlansPlaninternationalvideocallEntity entityObj) {
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

	public PlansPlaninternationalvideocallEntity findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlaninternationalvideocallEntity entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlaninternationalvideocallEntity.findById");
			query.setParameter("id", id);
			entity = (PlansPlaninternationalvideocallEntity)(query.list().get(0));
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
