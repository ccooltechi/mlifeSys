package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanspecialminutesEntity;

public class PlansPlanspecialminutesDao {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanprimaryDao.class);
	
	public PlansPlanspecialminutesDao()
	{
		
	}
	
	public List<PlansPlanspecialminutesEntity> findPlansPlanspecialminutesID(int planID)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanspecialminutesEntity> plansPlanprimary = null;
		try {
			List<PlansPlanspecialminutesEntity> plansPlanprimaryList = null;

			String query = "Select a.* from plans_planspecialminutes a where a.is_active=1 and a.plan_primary_id ="+planID;
			logger.debug("query in findPlansTncByPlanID for all " + query);
			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlanspecialminutesEntity.class, query,"plans_planspecialminutes");

			logger.debug("findPlansTncByPlanID Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = plansPlanprimaryList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return plansPlanprimary;
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanspecialminutesEntity> plansPlanOperatorTncList = null;

			String query = "Select * from plans_planspecialminutes order by id desc limit 2";
			logger.debug("query in findID in  PlansPlanOperatorTncDao " + query);
			plansPlanOperatorTncList = new HibernateDAO().findBySQLQuery(session, PlansPlanspecialminutesEntity.class, query,"plans_planspecialminutes");

			logger.debug("findID  in  PlansPlanfeeDao Size = "+plansPlanOperatorTncList.size());
			if ((null!=plansPlanOperatorTncList) && (plansPlanOperatorTncList.size()>0))
			{
				rid = plansPlanOperatorTncList.get(0).getId();
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

	public PlansPlanspecialminutesEntity findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlanspecialminutesEntity entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlanspecialminutesEntity.findById");
			query.setParameter("id", id);
			entity = (PlansPlanspecialminutesEntity)(query.list().get(0));
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

	public boolean saveData(PlansPlanspecialminutesEntity entityObj) {
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

	public boolean updateData(PlansPlanspecialminutesEntity entityObj) {
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
