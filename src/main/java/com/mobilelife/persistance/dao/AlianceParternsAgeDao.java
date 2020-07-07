package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.AlianceParternsAgeEntity;
import com.mobilelife.persistance.entities.PlansPlanfeeEntity;

public class AlianceParternsAgeDao {
	private static Logger logger = LoggerFactory.getLogger(AlianceParternsAgeDao.class);

	public AlianceParternsAgeDao()
	{
		
	}
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<AlianceParternsAgeEntity> alianceParternsAgeList = null;

			String query = "Select * from aliance_parterns_age order by id desc limit 1";
			logger.debug("query in findID in  AlianceParternsAgeDao " + query);
			alianceParternsAgeList = new HibernateDAO().findBySQLQuery(session, AlianceParternsAgeEntity.class, query,"aliance_parterns_age");

			logger.debug("findID  in  AlianceParternsAgeDao Size = "+alianceParternsAgeList.size());
			if ((null!=alianceParternsAgeList) && (alianceParternsAgeList.size()>0))
			{
				rid = alianceParternsAgeList.get(0).getId();
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
	public void saveData(AlianceParternsAgeEntity entityObj) {
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
