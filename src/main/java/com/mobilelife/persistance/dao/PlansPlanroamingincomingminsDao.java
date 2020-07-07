package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanroamingdataEntity;
import com.mobilelife.persistance.entities.PlansPlanroamingincomingminsEntity;

public class PlansPlanroamingincomingminsDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanroamingincomingminsDao.class);

	public PlansPlanroamingincomingminsDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanroamingincomingminsEntity> resultList = null;

			String query = "Select * from plans_planroamingincomingmins order by id desc";
			logger.debug("query in findID in  PlansPlanroamingincomingmins " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlanroamingincomingminsEntity.class, query,"plans_planroamingincomingmins");

			logger.debug("findID  in  PlansPlanroamingincomingmins Size = "+resultList.size());
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

	public PlansPlanroamingincomingminsEntity findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlanroamingincomingminsEntity entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlanroamingincomingminsEntity.findById");
			query.setParameter("id", id);
			entity = (PlansPlanroamingincomingminsEntity)(query.list().get(0));
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

	public boolean saveData(PlansPlanroamingincomingminsEntity entityObj) {
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

	public boolean updateData(PlansPlanroamingincomingminsEntity entityObj) {
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
