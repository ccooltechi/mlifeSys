package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlansmsoffnetEntity;
import com.mobilelife.persistance.entities.PlansPlansmsonnetEntity;

public class PlansPlansmsonnetDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlansmsonnetDao.class);

	public PlansPlansmsonnetDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlansmsonnetEntity> resultList = null;

			String query = "Select * from plans_plansmsonnet order by id desc";
			logger.debug("query in findID in  PlansPlansmsonnet " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlansmsonnetEntity.class, query,"plans_plansmsonnet");

			logger.debug("findID  in  PlansPlansmsonnet Size = "+resultList.size());
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

	public PlansPlansmsonnetEntity findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlansmsonnetEntity entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlansmsonnetEntity.findById");
			query.setParameter("id", id);
			entity = (PlansPlansmsonnetEntity)(query.list().get(0));
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

	public boolean saveData(PlansPlansmsonnetEntity entityObj) {
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

	public boolean updateData(PlansPlansmsonnetEntity entityObj) {
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
