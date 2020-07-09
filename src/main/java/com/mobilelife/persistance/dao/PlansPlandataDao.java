package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlandata;
import com.mobilelife.persistance.entities.PlansPlanfee;

public class PlansPlandataDao {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanprimaryDao.class);
	
	public PlansPlandataDao()
	{
		
	}
	
	public List<PlansPlandata> findPlansPlandataID(int planID)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlandata> plansPlanprimary = null;
		try {
			List<PlansPlandata> plansPlanprimaryList = null;

			String query = "Select a.* from plans_plandata a where a.is_active=1 and a.plan_primary_id ="+planID;
			logger.debug("query in findPlansTncByPlanID for all " + query);
			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlandata.class, query,"plans_plandata");

			logger.debug("findPlansPlandataID Size = "+plansPlanprimaryList.size());
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
			List<PlansPlandata> plansPlanOperatorTncList = null;

			String query = "Select * from plans_plandata order by id desc limit 2";
			logger.debug("query in findID in  PlansPlanOperatorTncDao " + query);
			plansPlanOperatorTncList = new HibernateDAO().findBySQLQuery(session, PlansPlandata.class, query,"plans_plandata");

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

	public boolean saveData(PlansPlandata entityObj) {
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

	public boolean updateData(PlansPlandata entityObj) {
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
	
	public PlansPlandata findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlandata entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlandata.findById");
			query.setParameter("id", id);
			entity = (PlansPlandata)(query.list().get(0));
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
