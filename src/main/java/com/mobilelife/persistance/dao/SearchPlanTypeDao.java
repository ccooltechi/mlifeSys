package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlanDevicemodelEntity;
import com.mobilelife.persistance.entities.PlansPlantypeEntity;;

public class SearchPlanTypeDao {
	private static Logger logger = LoggerFactory.getLogger(SearchPlanTypeDao.class);

	public SearchPlanTypeDao()
	{
		
	}
	
	public List<PlansPlantypeEntity> findAllPlanTypes()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlantypeEntity> plansOperator = null;
		Query query = session.getNamedQuery("PlansPlantype.findAll");
		System.out.println("Size = "+query.list().size());
		plansOperator = query.list();
//		System.out.println("operator ID = "+plansOperator.getId());
//		System.out.println("operator Name = "+plansOperator.getOperatorName());
		return plansOperator;
	}

	public PlansPlantypeEntity findPlanTypeByID(int plan_id)
	{
		Session session = HibernateSessionManager.getSession();
		PlansPlantypeEntity plansOperator = null;
		Query query = session.getNamedQuery("PlansPlantype.findById");
		query.setParameter("id", plan_id);
		System.out.println("Size = "+query.list().size());
		plansOperator = (PlansPlantypeEntity)query.list().get(0);
		return plansOperator;
	}

	public static void main(String[] args) {
		SearchPlanTypeDao searchPlan = new SearchPlanTypeDao();
		searchPlan.findAllPlanTypes();
//		searchPlan.findPlansByOperator("Vigin KSA");
	}

}
