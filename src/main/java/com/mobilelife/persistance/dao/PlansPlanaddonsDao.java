package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.Countries;
import com.mobilelife.persistance.entities.PlansPlanaddons;
import com.mobilelife.persistance.entities.PlansPlanflexi;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlanaddonsDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanaddonsDao.class);

	public PlansPlanaddonsDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanaddons> resultList = null;

			String query = "Select * from plans_planaddons order by id desc limit 1";
			logger.debug("query in findID in  PlansPlanaddons " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlanaddons.class, query,"plans_planaddons");

			logger.debug("findID  in  PlansPlanaddons Size = ");
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

	public void saveData(PlansPlanaddons entityObj) {
		Session session = HibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(entityObj);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}
	
    public List<PlansPlanaddons> findCustomPlansByFilter(String filterSqlQuery) {
        Session session = HibernateSessionManager.getSession();
        List<PlansPlanaddons> plansPlanaddons = null;
		logger.debug("query in findCustomPlansByFilter " + filterSqlQuery);
        try {
            List<PlansPlanaddons> plansPlanaddonsList = null;
            plansPlanaddonsList = new HibernateDAO().findBySQLQuery(session, PlansPlanaddons.class, filterSqlQuery, "plans_planaddons");

            logger.debug("findCustomPlansByFilter Size = "+plansPlanaddonsList.size());
            if ((null!=plansPlanaddonsList) && (plansPlanaddonsList.size()>0))
            {
            	plansPlanaddons = plansPlanaddonsList;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.flush();
            session.clear();
            session.close();
            // HibernateSessionManager.closeSession()();
        }
        return plansPlanaddons;
    }

	public List<PlansPlanaddons> findCustomPlansID(int custPlanID)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanaddons> plansPlanaddonsList = null;
		Query query = session.getNamedQuery("PlansPlanaddons.findById");
		query.setParameter("id", custPlanID);
		System.out.println("Size = "+query.list().size());
		plansPlanaddonsList = (List<PlansPlanaddons>)query.list();
		return plansPlanaddonsList;
	}

}
