package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanlocalcallsmsEntity;
import com.mobilelife.persistance.entities.PlansPlanlocalmmsEntity;

public class PlansPlanlocalmmsDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanlocalmmsDao.class);

	public PlansPlanlocalmmsDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanlocalmmsEntity> resultList = null;

			String query = "Select * from plans_planlocalmms order by id desc";
			logger.debug("query in findID in  PlansPlanlocalmms " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlanlocalmmsEntity.class, query,"plans_planlocalmms");

			logger.debug("findID  in  PlansPlanlocalmms Size = "+resultList.size());
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

	public boolean saveData(PlansPlanlocalmmsEntity entityObj) {
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

	public boolean updateData(PlansPlanlocalmmsEntity entityObj) {
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
	
	public PlansPlanlocalmmsEntity findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlanlocalmmsEntity entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlanlocalmmsEntity.findById");
			query.setParameter("id", id);
			entity = (PlansPlanlocalmmsEntity)(query.list().get(0));
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
