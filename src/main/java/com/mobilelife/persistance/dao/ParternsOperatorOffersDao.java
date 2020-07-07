package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.ParternsOperatorOffersEntity;
import com.mobilelife.persistance.entities.PlansPlanfeeEntity;

public class ParternsOperatorOffersDao {
	private static Logger logger = LoggerFactory.getLogger(ParternsOperatorOffersDao.class);

	public ParternsOperatorOffersDao()
	{
		
	}
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<ParternsOperatorOffersEntity> parternsOperatorOffersList = null;

			String query = "Select * from parterns_operator_offers order by id desc limit 1";
			logger.debug("query in findID in  ParternsOperatorOffersDao " + query);
			parternsOperatorOffersList = new HibernateDAO().findBySQLQuery(session, ParternsOperatorOffersEntity.class, query,"parterns_operator_offers");

			logger.debug("findID  in  ParternsOperatorOffersDao Size = "+parternsOperatorOffersList.size());
			if ((null!=parternsOperatorOffersList) && (parternsOperatorOffersList.size()>0))
			{
				rid = parternsOperatorOffersList.get(0).getId();
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
	public ParternsOperatorOffersEntity findOperatorOffersByID(String rid)
	{
		Session session = HibernateSessionManager.getSession();
		ParternsOperatorOffersEntity parternsOperatorOffers = null;
		try {
			List<ParternsOperatorOffersEntity> parternsOperatorOffersList = null;

			String query = "Select * from parterns_operator_offers where is_active=1 and id="+rid;
			logger.debug("query in findID in  ParternsOperatorOffersDao " + query);
			parternsOperatorOffersList = new HibernateDAO().findBySQLQuery(session, ParternsOperatorOffersEntity.class, query,"parterns_operator_offers");

			logger.debug("findID  in  ParternsOperatorOffersDao Size = "+parternsOperatorOffersList.size());
			if ((null!=parternsOperatorOffersList) && (parternsOperatorOffersList.size()>0))
			{
				parternsOperatorOffers = parternsOperatorOffersList.get(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return parternsOperatorOffers;
	}
	
	public void saveData(ParternsOperatorOffersEntity entityObj) {
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

	public void updateData(ParternsOperatorOffersEntity entityObj) {
		Session session = HibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(entityObj);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}
	
}
