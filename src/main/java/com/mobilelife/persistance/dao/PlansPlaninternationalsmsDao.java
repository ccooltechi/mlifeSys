package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlaninternationalmmsEntity;
import com.mobilelife.persistance.entities.PlansPlaninternationalsmsEntity;

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
			List<PlansPlaninternationalsmsEntity> resultList = null;

			String query = "Select * from plans_planinternationalsms order by id desc";
			logger.debug("query in findID in  PlansPlaninternationalsms " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlaninternationalsmsEntity.class, query,"plans_planinternationalsms");

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

	public boolean saveData(PlansPlaninternationalsmsEntity entityObj) {
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
	
	public boolean updateData(PlansPlaninternationalsmsEntity entityObj) {
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
	
	public PlansPlaninternationalsmsEntity findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlaninternationalsmsEntity entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlaninternationalsmsEntity.findById");
			query.setParameter("id", id);
			entity = (PlansPlaninternationalsmsEntity)(query.list().get(0));
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
