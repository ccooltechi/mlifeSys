package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanfee;

public class AlianceCampaignAgeDao {
	private static Logger logger = LoggerFactory.getLogger(AlianceCampaignAgeDao.class);

	public AlianceCampaignAgeDao()
	{
		
	}
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanfee> plansPlanfeeList = null;

			String query = "Select * from plans_planfee order by id desc";
			logger.debug("query in findID in  PlansPlanfeeDao " + query);
			plansPlanfeeList = new HibernateDAO().findBySQLQuery(session, PlansPlanfee.class, query,"plans_planfee");

			logger.debug("findID  in  PlansPlanfeeDao Size = "+plansPlanfeeList.size());
			if ((null!=plansPlanfeeList) && (plansPlanfeeList.size()>0))
			{
				rid = plansPlanfeeList.get(0).getId();
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
	public void saveData(PlansPlanfee entityObj) {
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
	
}
