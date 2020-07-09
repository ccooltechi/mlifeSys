package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanprimary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchPlansDao {
	private static Logger logger = LoggerFactory.getLogger(SearchPlansDao.class);

	public SearchPlansDao()
	{
		
	}
	
	public List<PlansPlanprimary> findAllPlans()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimary> plansPlanprimary = null;
		Query query = session.getNamedQuery("PlansPlanprimary.findAll");
		logger.debug("findAllPlans Size = "+query.list().size());
		plansPlanprimary = (List<PlansPlanprimary>)query.list();
		return plansPlanprimary;
	}

	public List<PlansPlanprimary> findPlansByID(String planID)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimary> plansPlanprimary = null;
		Query query = session.getNamedQuery("PlansPlanprimary.findByPlanId");
		query.setParameter("planId", planID);
		logger.debug("findPlansByID Size = "+query.list().size());
		plansPlanprimary = (List<PlansPlanprimary>)query.list();
		return plansPlanprimary;
	}

	public List<PlansPlanprimary> findPlansByOperatorID(String operatorID)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimary> plansPlanprimary = null;
		try {
			List<PlansPlanprimary> plansPlanprimaryList = null;

			String query = "Select * from plans_planprimary where is_active=0 and operator_id ="+operatorID;
			logger.debug("query in findPlansByOperatorID for all " + query);
			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimary.class, query,"plans_planprimary");

			logger.debug("findPlansByOperatorID Size = "+plansPlanprimaryList.size());
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

	public static void main(String[] args) {
		SearchPlansDao searchPlan = new SearchPlansDao();
		searchPlan.findAllPlans();
//		searchPlan.findPlansByID("PLAN002");
//		searchPlan.findPlansByOperatorID("1");
	}

	public List<PlansPlanprimary> findPlansByFilter(String filterSqlQuery) {
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimary> plansPlanprimary = null;
		try {
			List<PlansPlanprimary> plansPlanprimaryList = null;
			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimary.class, filterSqlQuery,"plans_planprimary");

			logger.debug("findPlansByFilter Size = "+plansPlanprimaryList.size());
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


}
