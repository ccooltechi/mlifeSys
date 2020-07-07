package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanflexiEntity;
import com.mobilelife.persistance.entities.PlansPlaninternationalcallsmsEntity;

public class PlansPlaninternationalcallsmsDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlaninternationalcallsmsDao.class);

	public PlansPlaninternationalcallsmsDao()
	{
		
	}
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlaninternationalcallsmsEntity> resultList = null;

			String query = "Select * from plans_planinternationalcallsms order by id desc";
			logger.debug("query in findID in  plans_planinternationalcallsms " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlaninternationalcallsmsEntity.class, query,"plans_planinternationalcallsms");

			logger.debug("findID  in  plans_planinternationalcallsms Size = "+resultList.size());
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
	
	public boolean saveData(PlansPlaninternationalcallsmsEntity entityObj) {
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
	
	public boolean updateData(PlansPlaninternationalcallsmsEntity entityObj) {
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
	
	public PlansPlaninternationalcallsmsEntity findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlaninternationalcallsmsEntity entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlaninternationalcallsmsEntity.findById");
			query.setParameter("id", id);
			entity = (PlansPlaninternationalcallsmsEntity)(query.list().get(0));
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
