package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlannationalminutesonnetEntity;
import com.mobilelife.persistance.entities.PlansPlanoutofbundleEntity;

public class PlansPlanoutofbundleDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanoutofbundleDao.class);

	public PlansPlanoutofbundleDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanoutofbundleEntity> resultList = null;

			String query = "Select * from plans_planoutofbundle order by id desc";
			logger.debug("query in findID in  PlansPlanoutofbundle " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlanoutofbundleEntity.class, query,"plans_planoutofbundle");

			logger.debug("findID  in  PlansPlanoutofbundle Size = "+resultList.size());
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

	public boolean saveData(PlansPlanoutofbundleEntity entityObj) {
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

	public boolean updateData(PlansPlanoutofbundleEntity entityObj) {
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

	public PlansPlanoutofbundleEntity findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlanoutofbundleEntity entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlanoutofbundleEntity.findById");
			query.setParameter("id", id);
			entity = (PlansPlanoutofbundleEntity)(query.list().get(0));
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
