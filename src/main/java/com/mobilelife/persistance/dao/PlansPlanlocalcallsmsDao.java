package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlaninternationalvideocallEntity;
import com.mobilelife.persistance.entities.PlansPlanlocalcallsmsEntity;

public class PlansPlanlocalcallsmsDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanlocalcallsmsDao.class);

	public PlansPlanlocalcallsmsDao()
	{
		
	}

	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanlocalcallsmsEntity> resultList = null;

			String query = "Select * from plans_planlocalcallsms order by id desc";
			logger.debug("query in findID in  PlansPlanlocalcallsms " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlanlocalcallsmsEntity.class, query,"plans_planlocalcallsms");

			logger.debug("findID  in  PlansPlanlocalcallsms Size = "+resultList.size());
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

	public boolean saveData(PlansPlanlocalcallsmsEntity entityObj) {
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

	public boolean updateData(PlansPlanlocalcallsmsEntity entityObj) {
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
		return retVal;	}

	public PlansPlanlocalcallsmsEntity findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlanlocalcallsmsEntity entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlanlocalcallsmsEntity.findById");
			query.setParameter("id", id);
			entity = (PlansPlanlocalcallsmsEntity)(query.list().get(0));
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
