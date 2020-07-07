package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanprimaryEntity;

public class PlansPlanprimaryDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanprimaryDao.class);

	public PlansPlanprimaryDao()
	{
		
	}
	
	public List<PlansPlanprimaryEntity> findAll()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimaryEntity> plansPlanprimary = null;
		Query query = session.getNamedQuery("PlansPlanprimaryEntity.findAll");
		logger.debug("findAllPlans Size = "+query.list().size());
		plansPlanprimary = (List<PlansPlanprimaryEntity>)query.list();
		return plansPlanprimary;
	}

	public List<PlansPlanprimaryEntity> findAllPlans(int pageNumber, int results_per_page)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimaryEntity> plansPlanprimary = null;
		try {
			List<PlansPlanprimaryEntity> plansPlanprimaryList = null;

			String query = "Select a.* from plans_planprimary a, plans_planfee b  where a.is_active=1 and b.plan_primary_id =a.id order by b.plan_monthly_fee";
			logger.debug("query in findAllPlans for all " + query);
//			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimary.class, query,"plans_planprimary");
			plansPlanprimaryList = new HibernateDAO().findBySQLQueryWithPagination(session, query, PlansPlanprimaryEntity.class, "plans_planprimary", pageNumber, results_per_page);

			logger.debug("findPlansByOperatorID Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = plansPlanprimaryList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		System.out.println("plansPlanprimary.size "+plansPlanprimary.size());
		return plansPlanprimary;
	}

	public List<PlansPlanprimaryEntity> findPlansByIDs(String planID)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimaryEntity> plansPlanprimary = null;
		try {
			List<PlansPlanprimaryEntity> plansPlanprimaryList = null;

			String query = "Select a.* from plans_planprimary a where a.is_active=1 and a.id in ("+planID+")";
//			logger.debug("query in findPlansByIDs for all " + query);
			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimaryEntity.class, query,"plans_planprimary");
//			plansPlanprimaryList = new HibernateDAO().findBySQLQueryWithPagination(session, query, PlansPlanprimary.class, "plans_planprimary", pageNumber, results_per_page);

//			logger.debug("findPlansByIDs Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = plansPlanprimaryList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
//		System.out.println("plansPlanprimary.size "+plansPlanprimary.size());
		return plansPlanprimary;
	}
	
	public List<PlansPlanprimaryEntity> findPlansByPlanID(String planID)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimaryEntity> plansPlanprimary = null;
		Query query = session.getNamedQuery("PlansPlanprimaryEntity.findByPlanId");
		query.setParameter("planId", planID);
		logger.debug("findPlansByID planID = "+planID);
		plansPlanprimary = (List<PlansPlanprimaryEntity>)query.list();
		return plansPlanprimary;
	}

	public List<PlansPlanprimaryEntity> findByPlanID(String planID)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimaryEntity> plansPlanprimary = null;
		try {
			List<PlansPlanprimaryEntity> plansPlanprimaryList = null;

			String query = "Select a.* from plans_planprimary a where a.is_active=1 and a.plan_id = '"+planID+"'";
			logger.debug("query in findByPlanID for all " + query);
			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimaryEntity.class, query,"plans_planprimary");
//			plansPlanprimaryList = new HibernateDAO().findBySQLQueryWithPagination(session, query, PlansPlanprimary.class, "plans_planprimary", pageNumber, results_per_page);

			logger.debug("findPlansByIDs Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = plansPlanprimaryList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		System.out.println("plansPlanprimary.size "+plansPlanprimary.size());
		return plansPlanprimary;
	}


	public List<PlansPlanprimaryEntity> findPlansByID(String planID){
	Session session = HibernateSessionManager.getSession();
            try {                
		List<PlansPlanprimaryEntity> plansPlanprimary = null;
		Query query = session.getNamedQuery("PlansPlanprimaryEntity.findById");
		query.setParameter("id", Integer.parseInt(planID));
		// logger.debug("findPlansByID planID = "+planID);
		plansPlanprimary = (List<PlansPlanprimaryEntity>)query.list();
		return plansPlanprimary;
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                session.flush();
			session.clear();
			session.close();
            }
		return null;
	}

	public List<PlansPlanprimaryEntity> findPlansByName(String planNM){
	Session session = HibernateSessionManager.getSession();
            try {                
		List<PlansPlanprimaryEntity> plansPlanprimary = null;
		Query query = session.getNamedQuery("PlansPlanprimaryEntity.findByPlanName");
		query.setParameter("planName", planNM);
		 logger.debug("findPlansByName planID = "+planNM);
		plansPlanprimary = (List<PlansPlanprimaryEntity>)query.list();
		return plansPlanprimary;
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                session.flush();
			session.clear();
			session.close();
            }
		return null;
	}


	public List<PlansPlanprimaryEntity> findPlansByOperatorID(String operatorID)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimaryEntity> plansPlanprimary = null;
		int pageNumber=2;
		int results_per_page=10;
		try {
			List<PlansPlanprimaryEntity> plansPlanprimaryList = null;

			String query = "Select * from plans_planprimary where is_active=1 and operator_id ="+operatorID;
			logger.debug("query in findPlansByOperatorID for all " + query);
//			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimary.class, query,"plans_planprimary");
			plansPlanprimaryList = new HibernateDAO().findBySQLQueryWithPagination(session, query, PlansPlanprimaryEntity.class, "plans_planprimary", pageNumber, results_per_page);

			logger.debug("findPlansByOperatorID Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = plansPlanprimaryList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		System.out.println("plansPlanprimary.size "+plansPlanprimary.size());
		return plansPlanprimary;
	}

	public List<PlansPlanprimaryEntity> findPlansByFilter(String filterSqlQuery, int pageNumber, int results_per_page) {
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimaryEntity> plansPlanprimary = null;
		try {
			List<PlansPlanprimaryEntity> plansPlanprimaryList = null;
//			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimary.class, filterSqlQuery,"plans_planprimary");
			plansPlanprimaryList = new HibernateDAO().findBySQLQueryWithPagination(session, filterSqlQuery, PlansPlanprimaryEntity.class, "plans_planprimary", pageNumber, results_per_page);

			logger.debug("findPlansByFilter Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0)) 
			{
				plansPlanprimary = plansPlanprimaryList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return plansPlanprimary;
	}

	public int getTotalPlans(String filterSqlQuery) {
		Session session = HibernateSessionManager.getSession();
		int totalPlans = 0;
		try {
            List palnMasterDataList = new HibernateDAO().findBySQLQuery(session, filterSqlQuery);
			logger.debug("getTotalPlans Size = "+palnMasterDataList.size());
			if ((null!=palnMasterDataList) && (palnMasterDataList.size()>0))
			{
                totalPlans = palnMasterDataList.size();
//                for (int i = 0; i < palnMasterDataList.size(); i++) {
//                    totalPlans = Integer.parseInt(palnMasterDataList.get(i)+"");
//        			logger.debug("totalPlans = "+totalPlans);
//                }
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return totalPlans;
	}

	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanprimaryEntity> resultList = null;

			String query = "Select * from plans_planprimary order by id desc";
			logger.debug("query in findID in  PlansPlanprimary " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimaryEntity.class, query,"plans_planprimary");

			logger.debug("findID  in  PlansPlanprimary Size = "+resultList.size());
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

	public List<PlansPlanprimaryEntity> findPlansByPlanName(String planName, int plan_type, int operator_id, String flexinational)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimaryEntity> plansPlanprimary = null;
		try {
			String query = "";
			List<PlansPlanprimaryEntity> plansPlanprimaryList = null;
//			if (flexinational.trim().isEmpty())
				query = "Select a.* from plans_planprimary a where a.is_active=1 and operator_id="+operator_id+" and a.plan_type="+plan_type+" and a.plan_name in ('"+planName.trim()+"')";
//			else
//				query = "Select a.* from plans_planprimary a where a.is_active=1 and operator_id="+operator_id+" and a.plan_type="+plan_type+" and a.plan_name in ('"+planName.trim()+"') and plan_longname like '%"+flexinational+"%' ";
				
			logger.debug("query in findPlansByPlanName for all " + query);
			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimaryEntity.class, query,"plans_planprimary");
//			plansPlanprimaryList = new HibernateDAO().findBySQLQueryWithPagination(session, query, PlansPlanprimary.class, "plans_planprimary", pageNumber, results_per_page);

			logger.debug("findPlansByIDs Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = plansPlanprimaryList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		System.out.println("plansPlanprimary.size "+plansPlanprimary.size());
		return plansPlanprimary;
	}


	public boolean savePlansPlanprimary(PlansPlanprimaryEntity plansPlanprimary) {
		boolean retVal = false;
		Session session = HibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(plansPlanprimary);
			tx.commit();
			retVal = true;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}

	public boolean saveData(PlansPlanprimaryEntity entityObj) {
		boolean retVal = false;
		Session session = HibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(entityObj);
			tx.commit();
			retVal = true;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}

	public boolean updateData(PlansPlanprimaryEntity entityObj) {
		boolean retVal = false;
		Session session = HibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(entityObj);
			tx.commit();
			retVal = true;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}

	public PlansPlanprimaryEntity findByName(String deviceBrand)
	{
		Session session = HibernateSessionManager.getSession();
		PlansPlanprimaryEntity planDevicebrand = null;
		try {
			Query query = session.getNamedQuery("PlansPlanprimaryEntity.findByPlanName");
			query.setParameter("deviceBrand", deviceBrand);
			planDevicebrand = (PlansPlanprimaryEntity)query.list().get(0);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return planDevicebrand;
	}

	public PlansPlanprimaryEntity findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlanprimaryEntity entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlanprimaryEntity.findById");
			query.setParameter("id", id);
			entity = (PlansPlanprimaryEntity)(query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return entity;
	}

	public boolean deleteData(PlansPlanprimaryEntity entityObj) {
		boolean retVal = false;
		Session session = HibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(entityObj);
			tx.commit();
			retVal = true;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return retVal;
	}
	


}
