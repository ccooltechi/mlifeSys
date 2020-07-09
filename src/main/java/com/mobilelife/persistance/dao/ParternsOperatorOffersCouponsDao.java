package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.ParternsOperatorOffersCoupons;
import com.mobilelife.persistance.entities.PlansPlanfee;

public class ParternsOperatorOffersCouponsDao {
	private static Logger logger = LoggerFactory.getLogger(ParternsOperatorOffersCouponsDao.class);

	public ParternsOperatorOffersCouponsDao()
	{
		
	}
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<ParternsOperatorOffersCoupons> parternsOperatorOffersCouponsList = null;

			String query = "Select * from parterns_operator_offers_coupons order by id desc limit 1";
			logger.debug("query in findID in  ParternsOperatorOffersCouponsDao " + query);
			parternsOperatorOffersCouponsList = new HibernateDAO().findBySQLQuery(session, ParternsOperatorOffersCoupons.class, query,"parterns_operator_offers_coupons");

			logger.debug("findID  in  ParternsOperatorOffersCouponsDao Size = "+parternsOperatorOffersCouponsList.size());
			if ((null!=parternsOperatorOffersCouponsList) && (parternsOperatorOffersCouponsList.size()>0))
			{
				rid = parternsOperatorOffersCouponsList.get(0).getId();
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

	public ParternsOperatorOffersCoupons findOffersCouponsByID(String offer_id)
	{
		Session session = HibernateSessionManager.getSession();
		ParternsOperatorOffersCoupons parternsOperatorOffersCoupons = null;
		try {
			List<ParternsOperatorOffersCoupons> parternsOperatorOffersCouponsList = null;

			String query = "Select * from parterns_operator_offers_coupons where is_active=1 and id="+offer_id;
			logger.debug("query in findID in  ParternsOperatorOffersCouponsDao " + query);
			parternsOperatorOffersCouponsList = new HibernateDAO().findBySQLQuery(session, ParternsOperatorOffersCoupons.class, query,"parterns_operator_offers_coupons");

			logger.debug("findID  in  ParternsOperatorOffersCouponsDao Size = "+parternsOperatorOffersCouponsList.size());
			if ((null!=parternsOperatorOffersCouponsList) && (parternsOperatorOffersCouponsList.size()>0))
			{
				parternsOperatorOffersCoupons = parternsOperatorOffersCouponsList.get(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return parternsOperatorOffersCoupons;
	}

	public List<ParternsOperatorOffersCoupons> findUnusedCoupons()
	{
		Session session = HibernateSessionManager.getSession();
		List<ParternsOperatorOffersCoupons> parternsOperatorOffersCouponsList = null;
		try {

			String query = "select * from  parterns_operator_offers_coupons where is_consumed =2 AND last_modified_datetime < DATE_SUB(NOW(), INTERVAL 1 HOUR);";
			logger.debug("query in findUnusedCoupons in  ParternsOperatorOffersCouponsDao " + query);
			parternsOperatorOffersCouponsList = new HibernateDAO().findBySQLQuery(session, ParternsOperatorOffersCoupons.class, query,"parterns_operator_offers_coupons");
			logger.debug("findUnusedCoupons  in  ParternsOperatorOffersCouponsDao Size = "+parternsOperatorOffersCouponsList.size());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return parternsOperatorOffersCouponsList;
	}

	
	public void saveData(ParternsOperatorOffersCoupons entityObj) {
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

	public void updateData(ParternsOperatorOffersCoupons entityObj) {
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
