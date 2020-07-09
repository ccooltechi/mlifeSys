package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlantypeConf;;

public class PlanTypeConfigDao {
	private static Logger logger = LoggerFactory.getLogger(PlanTypeConfigDao.class);

	public PlanTypeConfigDao()
	{
		
	}
	
	public List<PlansPlantypeConf> findAllPlanTypesConf()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlantypeConf> plansPlantypeConf = null;
		Query query = session.getNamedQuery("PlansPlantypeConf.findAll");
		System.out.println("Size = "+query.list().size());
		plansPlantypeConf = query.list();
		return plansPlantypeConf;
	}

	public PlansPlantypeConf findPlanTypesConf(int planTypeID, String filterType)
	{
		Session session = HibernateSessionManager.getSession();
		PlansPlantypeConf plansPlantypeConf = null;
		try {
			List<PlansPlantypeConf> plansPlantypeConfList = null;

			String query = "Select * from plans_plantype_conf where is_active=1 and filter_type='"+filterType+"' and plan_type_id="+planTypeID;
			logger.debug("query in findPlanTypesConf for  " + query);
			plansPlantypeConfList = new HibernateDAO().findBySQLQuery(session, PlansPlantypeConf.class, query,"plans_plantype_conf");

			logger.debug("findPlanTypesConf Size = "+plansPlantypeConfList.size());
			if ((null!=plansPlantypeConfList) && (plansPlantypeConfList.size()>0))
			{
				plansPlantypeConf = plansPlantypeConfList.get(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return plansPlantypeConf;
	}
	
	public static void main(String[] args) {
		PlanTypeConfigDao searchPlan = new PlanTypeConfigDao();
//		searchPlan.findAllPlanTypes();
//		searchPlan.findPlansByOperator("Vigin KSA");
	}

}
