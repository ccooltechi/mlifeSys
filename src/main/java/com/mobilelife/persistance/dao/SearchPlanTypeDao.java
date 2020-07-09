package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlanDevicemodel;
import com.mobilelife.persistance.entities.PlansPlantype;;

public class SearchPlanTypeDao {
	private static Logger logger = LoggerFactory.getLogger(SearchPlanTypeDao.class);

	public SearchPlanTypeDao()
	{
		
	}
	
	public List<PlansPlantype> findAllPlanTypes()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlantype> plansOperator = null;
		Query query = session.getNamedQuery("PlansPlantype.findAll");
		System.out.println("Size = "+query.list().size());
		plansOperator = query.list();
//		System.out.println("operator ID = "+plansOperator.getId());
//		System.out.println("operator Name = "+plansOperator.getOperatorName());
		return plansOperator;
	}

	public PlansPlantype findPlanTypeByID(int plan_id)
	{
		Session session = HibernateSessionManager.getSession();
		PlansPlantype plansOperator = null;
		Query query = session.getNamedQuery("PlansPlantype.findById");
		query.setParameter("id", plan_id);
		System.out.println("Size = "+query.list().size());
		plansOperator = (PlansPlantype)query.list().get(0);
		return plansOperator;
	}

	public static void main(String[] args) {
		SearchPlanTypeDao searchPlan = new SearchPlanTypeDao();
		searchPlan.findAllPlanTypes();
//		searchPlan.findPlansByOperator("Vigin KSA");
	}

}
