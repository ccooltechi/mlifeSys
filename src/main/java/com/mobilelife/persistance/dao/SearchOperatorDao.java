package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansOperator;

public class SearchOperatorDao {
	private static Logger logger = LoggerFactory.getLogger(SearchOperatorDao.class);

	public SearchOperatorDao()
	{
		
	}
	
	public List<PlansOperator> findAllOperators()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansOperator> plansOperator = null;
		Query query = session.getNamedQuery("PlansOperator.findAll");
		System.out.println("Size = "+query.list().size());
		plansOperator = query.list();
//		System.out.println("operator ID = "+plansOperator.getId());
//		System.out.println("operator Name = "+plansOperator.getOperatorName());
		return plansOperator;
	}

	private PlansOperator findPlansByOperator(String operator_name)
	{
		Session session = HibernateSessionManager.getSession();
		PlansOperator plansOperator = null;
		Query query = session.getNamedQuery("PlansOperator.findByOperatorName");
		query.setParameter("operatorName", operator_name);
		System.out.println("Size = "+query.list().size());
		plansOperator = (PlansOperator)query.list().get(0);
		System.out.println("operator ID = "+plansOperator.getId());
		System.out.println("operator Name = "+plansOperator.getOperatorName());
		return plansOperator;
	}

	public static void main(String[] args) {
		SearchOperatorDao searchPlan = new SearchOperatorDao();
		searchPlan.findAllOperators();
//		searchPlan.findPlansByOperator("Vigin KSA");
	}


}
