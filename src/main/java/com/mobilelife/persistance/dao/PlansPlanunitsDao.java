package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlansocialdataEntity;
import com.mobilelife.persistance.entities.PlansPlanunitsEntity;

public class PlansPlanunitsDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanunitsDao.class);

	public PlansPlanunitsDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanunitsEntity> resultList = null;

			String query = "Select * from plans_planunits order by id desc";
			logger.debug("query in findID in  PlansPlanunits " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlanunitsEntity.class, query,"plans_planunits");

			logger.debug("findID  in  PlansPlanunits Size = "+resultList.size());
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

	public PlansPlanunitsEntity findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlanunitsEntity entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlanunitsEntity.findById");
			query.setParameter("id", id);
			entity = (PlansPlanunitsEntity)(query.list().get(0));
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

	public boolean saveData(PlansPlanunitsEntity entityObj) {
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

	public boolean updateData(PlansPlanunitsEntity entityObj) {
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
