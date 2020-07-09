package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.AlianceParterns;
import com.mobilelife.persistance.entities.PlansPlanfee;

public class AlianceParternsDao {
	private static Logger logger = LoggerFactory.getLogger(AlianceParternsDao.class);

	public AlianceParternsDao()
	{
		
	}
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<AlianceParterns> alianceParternList = null;

			String query = "Select * from aliance_parterns order by id desc limit 1";
			logger.debug("query in findID in  alianceParternDao " + query);
			alianceParternList = new HibernateDAO().findBySQLQuery(session, AlianceParterns.class, query,"aliance_parterns");

			logger.debug("findID  in  alianceParternDao Size = "+alianceParternList.size());
			if ((null!=alianceParternList) && (alianceParternList.size()>0))
			{
				rid = alianceParternList.get(0).getId();
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
	public void saveData(AlianceParterns entityObj) {
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
