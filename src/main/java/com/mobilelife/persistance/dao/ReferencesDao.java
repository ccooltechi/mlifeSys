package com.mobilelife.persistance.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PartnerRouteChildEntity;
import com.mobilelife.persistance.entities.PartnerRouteMasterEntity;
import com.mobilelife.persistance.entities.PlansPlanfeeEntity;
import com.mobilelife.persistance.entities.ReferencesChildEntity;
import com.mobilelife.persistance.entities.ReferencesMasterEntity;

public class ReferencesDao {
	private static Logger logger = LoggerFactory.getLogger(ReferencesDao.class);

	public ReferencesDao()
	{
		
	}

	public int findIdreferencesMasterNextID()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<ReferencesMasterEntity> referencesMaster = null;

			String query = "Select * from references_master order by id desc limit 1";
			logger.debug("query in findIdreferencesMaster in  ReferencesDao " + query);
			referencesMaster = new HibernateDAO().findBySQLQuery(session, ReferencesMasterEntity.class, query,"references_master");

			logger.debug("findIdreferencesMaster in  ReferencesDao Size = "+referencesMaster.size());
			if ((null!=referencesMaster) && (referencesMaster.size()>0))
			{
				rid = referencesMaster.get(0).getId();
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

	public int findIdreferencesChildNextID()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<ReferencesChildEntity> referencesChild = null;

			String query = "Select * from references_child order by id desc limit 1";
			logger.debug("query in findIdreferencesChild in  ReferencesDao " + query);
			referencesChild = new HibernateDAO().findBySQLQuery(session, ReferencesChildEntity.class, query,"references_child");

			logger.debug("findIdreferencesChild in  ReferencesDao Size = "+referencesChild.size());
			if ((null!=referencesChild) && (referencesChild.size()>0))
			{
				rid = referencesChild.get(0).getId();
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

	public void saveData(ReferencesMasterEntity entityObj) {
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

	public void updateData(ReferencesMasterEntity entityObj) {
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

	public void saveData(ReferencesChildEntity entityObj) {
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

	public void updateData(ReferencesChildEntity entityObj) {
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

	public static void main(String[] args) {
		ReferencesDao searchPlan = new ReferencesDao();
	}
}
