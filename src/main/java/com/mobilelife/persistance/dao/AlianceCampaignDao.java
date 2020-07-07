package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.AlianceCampaignEntity;
import com.mobilelife.persistance.entities.PlansPlanfeeEntity;

public class AlianceCampaignDao {
	private static Logger logger = LoggerFactory.getLogger(AlianceCampaignDao.class);

	public AlianceCampaignDao()
	{
		
	}
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<AlianceCampaignEntity> AlianceCampaignList = null;

			String query = "Select * from aliance_campaign order by id desc limit 1";
			logger.debug("query in findID in  AlianceCampaignDao " + query);
			AlianceCampaignList = new HibernateDAO().findBySQLQuery(session, AlianceCampaignEntity.class, query,"aliance_campaign");

			logger.debug("findID  in  AlianceCampaignDao Size = "+AlianceCampaignList.size());
			if ((null!=AlianceCampaignList) && (AlianceCampaignList.size()>0))
			{
				rid = AlianceCampaignList.get(0).getId();
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
	public void saveData(AlianceCampaignEntity entityObj) {
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
