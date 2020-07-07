package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanfeeEntity;

public class PlansPlanfeeDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanfeeDao.class);

	public PlansPlanfeeDao()
	{
		
	}
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanfeeEntity> plansPlanfeeList = null;

			String query = "Select * from plans_planfee order by id desc limit 1";
			logger.debug("query in findID in  PlansPlanfeeDao " + query);
			plansPlanfeeList = new HibernateDAO().findBySQLQuery(session, PlansPlanfeeEntity.class, query,"plans_planfee");

			logger.debug("findID  in  PlansPlanfeeDao Size = "+plansPlanfeeList.size());
			if ((null!=plansPlanfeeList) && (plansPlanfeeList.size()>0))
			{
				rid = plansPlanfeeList.get(0).getId();
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
	public boolean saveData(PlansPlanfeeEntity entityObj) {
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
	
	public boolean updateData(PlansPlanfeeEntity entityObj) {
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
	
	public PlansPlanfeeEntity findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlanfeeEntity entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlanfeeEntity.findById");
			query.setParameter("id", id);
			entity = (PlansPlanfeeEntity)(query.list().get(0));
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
