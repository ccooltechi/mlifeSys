package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlantype;;

public class PlanTypeDao {
	private static Logger logger = LoggerFactory.getLogger(PlanTypeDao.class);

	public PlanTypeDao()
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

	public PlansPlantype findPlanTypesByName(String plan_type)
	{
		Session session = HibernateSessionManager.getSession();
		System.out.println("plan_type = "+plan_type);
		PlansPlantype plansType = null;
		Query query = session.getNamedQuery("PlansPlantype.findByPlanType");
		query.setParameter("planType", plan_type);
		System.out.println("Size = "+query.list().size());
		plansType = (PlansPlantype) query.list().get(0);
		return plansType;
	}

	public PlansPlantype findPlanTypesById(int plan_id)
	{
		Session session = HibernateSessionManager.getSession();
		System.out.println("plan_id = "+plan_id);
		PlansPlantype plansType = null;
		Query query = session.getNamedQuery("PlansPlantype.findById");
		query.setParameter("id", plan_id);
		System.out.println("Size = "+query.list().size());
		plansType = (PlansPlantype) query.list().get(0);
		return plansType;
	}

	public List<PlansPlantype> findPlanTypesByCountry(String country)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlantype> plansOperator = null;
		Query query = session.getNamedQuery("PlansPlantype.findByCountry");
		query.setParameter("country", country);
		System.out.println("Size = "+query.list().size());
		plansOperator = query.list();
//		System.out.println("operator ID = "+plansOperator.getId());
//		System.out.println("operator Name = "+plansOperator.getOperatorName());
		return plansOperator;
	}

	public static void main(String[] args) {
		PlanTypeDao searchPlan = new PlanTypeDao();
		searchPlan.findAllPlanTypes();
//		searchPlan.findPlansByOperator("Vigin KSA");
	}

}
