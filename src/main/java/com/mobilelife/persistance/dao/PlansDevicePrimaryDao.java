package com.mobilelife.persistance.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansDeviceprimary;

public class PlansDevicePrimaryDao {
	private static Logger logger = LoggerFactory.getLogger(PlansDevicePrimaryDao.class);

	public List<PlansDeviceprimary> findAllPlans()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansDeviceprimary> plansPlanprimary = null;
		Query query = session.getNamedQuery("PlansDeviceprimary.findAll");
		logger.debug("findAllDevicePlans Size = "+query.list().size());
		plansPlanprimary = (List<PlansDeviceprimary>)query.list();
		return plansPlanprimary;
	}

	public List<PlansDeviceprimary> findAllPlans(int pageNumber, int results_per_page)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansDeviceprimary> plansPlanprimary = null;
		try {
			List<PlansDeviceprimary> plansPlanprimaryList = null;

			String query = "Select a.* from plans_deviceprimary a  where a.is_active=1 ";
			logger.debug("query in findAllPlans for all " + query);
//			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimary.class, query,"plans_planprimary");
			plansPlanprimaryList = new HibernateDAO().findBySQLQueryWithPagination(session, query, PlansDeviceprimary.class, "plans_deviceprimary", pageNumber, results_per_page);

			logger.debug("findAllPlans Size = "+plansPlanprimaryList.size());
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
		System.out.println("PlansDeviceprimary.size "+plansPlanprimary.size());
		return plansPlanprimary;
	}
	
	public List<PlansDeviceprimary> findPlansByIDs(String planID)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansDeviceprimary> plansPlanprimary = null;
		try {
			List<PlansDeviceprimary> plansPlanprimaryList = null;

			String query = "Select a.* from plans_deviceprimary a where a.is_active=1 and a.id in ("+planID+")";
			logger.debug("query in findPlansByIDs for all " + query);
			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansDeviceprimary.class, query,"plans_deviceprimary");

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
		System.out.println("plans_deviceprimary.size "+plansPlanprimary.size());
		return plansPlanprimary;
	}

	public PlansDeviceprimary findDevicePlansByIDs(String planID)
	{
		Session session = HibernateSessionManager.getSession();
		PlansDeviceprimary plansPlanprimary = null;
		try {
			List<PlansDeviceprimary> plansPlanprimaryList = null;

			String query = "Select a.* from plans_deviceprimary a where a.is_active=1 and a.id in ("+planID+")";
			logger.debug("query in findPlansByIDs for all " + query);
			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansDeviceprimary.class, query,"plans_deviceprimary");

			logger.debug("findPlansByIDs Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = plansPlanprimaryList.get(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
//		System.out.println("plans_deviceprimary.size "+plansPlanprimary.size());
		return plansPlanprimary;
	}


	public List<PlansDeviceprimary> findPlansByFilterOLD(String query, int pageNumber, int results_per_page)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansDeviceprimary> plansPlanprimary = null;
		try {
			List<PlansDeviceprimary> plansPlanprimaryList = null;

//			String query = "Select a.* from plans_deviceprimary a  where a.is_active=1 order by a.cost";
			logger.debug("query in findAllPlans for all " + query);
//			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimary.class, query,"plans_planprimary");
			plansPlanprimaryList = new HibernateDAO().findBySQLQueryWithPagination(session, query, PlansDeviceprimary.class, "plans_deviceprimary", pageNumber, results_per_page);

			logger.debug("findAllPlans Size = "+plansPlanprimaryList.size());
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
		System.out.println("PlansDeviceprimary.size ");
		return plansPlanprimary;
	}
	
	public List<HashMap> findPlansByFilter(String query, int pageNumber, int results_per_page)
	{
		Session session = HibernateSessionManager.getSession();
		List<HashMap> plansPlanprimary = null;
		try {
			List plansPlanprimaryList = null;
			logger.debug("query in findAllPlans for all " + query);
//			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimary.class, query,"plans_planprimary");
			plansPlanprimaryList = new HibernateDAO().findBySQLQueryWithPagination(session, query,  pageNumber, results_per_page);

			logger.debug("findAllPlans Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = new ArrayList<HashMap>();
				for (int i=0;i<plansPlanprimaryList.size();i++)
				{
					System.out.println("PlansDeviceprimary data is "+plansPlanprimaryList.get(i));
                    Object[] webCustomerObj = ((Object[]) plansPlanprimaryList.get(i));

					String idx = (String)webCustomerObj[0].toString();
					String textx = (String)webCustomerObj[1].toString();
					Double costx = Double.parseDouble((String)webCustomerObj[2].toString());
					HashMap addmap = new HashMap();
					addmap.put("deviceid",idx);
					addmap.put("planid",textx);
					addmap.put("devicePlanCost",costx);
					logger.debug("deviceid  = "+idx+", planid ="+textx+", costx ="+costx);
					plansPlanprimary.add(addmap);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		System.out.println("PlansDeviceprimary.size ");
		return plansPlanprimary;
	}

	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansDeviceprimary> resultList = null;

			String query = "Select * from plans_deviceprimary order by id desc";
			logger.debug("query in findID in  PlansDeviceprimary " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansDeviceprimary.class, query,"plans_deviceprimary");

			logger.debug("findID  in  PlansDeviceprimary Size = ");
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
	
	public int getTotalPlans(String filterSqlQuery) {
		Session session = HibernateSessionManager.getSession();
		int totalPlans = 0;
		try {
            List palnDeviceDataList = new HibernateDAO().findBySQLQuery(session, filterSqlQuery);
			logger.debug("getTotalPlans Size = "+palnDeviceDataList.size());
			if ((null!=palnDeviceDataList) && (palnDeviceDataList.size()>0))
			{
                for (int i = 0; i < palnDeviceDataList.size(); i++) {
                    totalPlans = Integer.parseInt(palnDeviceDataList.get(i)+"");
        			logger.debug("totalPlans = "+totalPlans);
                }
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

	public List<HashMap> findFiltersForDevice(String fieldName, String tableName, String brandId)
	{
		Session session = HibernateSessionManager.getSession();
		List<HashMap> plansPlanprimary = null;
		try {

			String query = "select id, "+fieldName+" from "+tableName+" where id in (Select distinct ("+fieldName+") from plans_deviceprimary a  where a.is_active=1 and a.brand_type ="+brandId+" order by "+fieldName+")";
			logger.debug("query in findAllPlans for all " + query);
            List plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, query);

			logger.debug("findAllPlans Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = new ArrayList<HashMap>();
				for (int i=0;i<plansPlanprimaryList.size();i++)
				{
					System.out.println("PlansDeviceprimary data is "+plansPlanprimaryList.get(i));
                    Object[] webCustomerObj = ((Object[]) plansPlanprimaryList.get(i));

					String idx = (String)webCustomerObj[0].toString();
					String textx = (String)webCustomerObj[1].toString();
//					Map<String, String> addmap = Collections.singletonMap(idx,textx); 
					HashMap addmap = new HashMap();
					addmap.put("Id",idx);
					addmap.put("Name",textx);
//                    Object[] webCustomerObj = ((Object[]) plansPlanprimaryList.get(i));
					plansPlanprimary.add(addmap);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		System.out.println("PlansDeviceprimary.size "+plansPlanprimary.size());
		return plansPlanprimary;
	}

	public List<HashMap> findFiltersForDeviceBrands()
	{
		Session session = HibernateSessionManager.getSession();
		List<HashMap> plansPlanprimary = null;
		try {

			String query = "select id, device_brand from plan_devicebrand where is_active=1 and id in (Select distinct (brand_type) from plans_deviceprimary a  where a.is_active=1 order by brand_type) order by device_brand";
			logger.debug("query in findFiltersForDeviceBrands for all " + query);
            List plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, query);

			logger.debug("findAllPlans Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = new ArrayList<HashMap>();
				for (int i=0;i<plansPlanprimaryList.size();i++)
				{
					System.out.println("PlansDeviceprimary data is "+plansPlanprimaryList.get(i));
                    Object[] webCustomerObj = ((Object[]) plansPlanprimaryList.get(i));

					String idx = (String)webCustomerObj[0].toString();
					String textx = (String)webCustomerObj[1].toString();
//					Map<String, String> addmap = Collections.singletonMap(idx,textx); 
					HashMap addmap = new HashMap();
					addmap.put("Id",idx);
					addmap.put("Name",textx);
//                    Object[] webCustomerObj = ((Object[]) plansPlanprimaryList.get(i));
					plansPlanprimary.add(addmap);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		System.out.println("PlansDeviceprimary.size "+plansPlanprimary.size());
		return plansPlanprimary;
	}
	
	public List<String> findFiltersForDevice(String fieldName)
	{
		Session session = HibernateSessionManager.getSession();
		List<String> plansPlanprimary = null;
		try {

			String query = "Select distinct("+fieldName+") from plans_deviceprimary a  where a.is_active=1 and "+fieldName+">0 order by "+fieldName;
			logger.debug("query in findAllPlans for all " + query);
            List plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, query);

			logger.debug("findAllPlans Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = new ArrayList<String>();
				for (int i=0;i<plansPlanprimaryList.size();i++)
				{
					System.out.println("PlansDeviceprimary data is "+plansPlanprimaryList.get(i));
//                    Object[] webCustomerObj = ((Object[]) plansPlanprimaryList.get(i));
					plansPlanprimary.add(plansPlanprimaryList.get(i).toString());
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		System.out.println("PlansDeviceprimary.size "+plansPlanprimary.size());
		return plansPlanprimary;
	}

	public List<String> findFiltersForDeviceMemory(String fieldName, String model_type)
	{
		Session session = HibernateSessionManager.getSession();
		List<String> plansPlanprimary = null;
		try {
			String query = "Select distinct("+fieldName+") from plans_deviceprimary a  where a.is_active=1 and a.device_model = "+model_type+" and "+fieldName+">0 order by "+fieldName;
			logger.debug("query in findAllPlans for all " + query);
            List plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, query);

			logger.debug("findFiltersForDeviceMemory Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = new ArrayList<String>();
				for (int i=0;i<plansPlanprimaryList.size();i++)
				{
					System.out.println("PlansDeviceprimary data is "+plansPlanprimaryList.get(i));
//                    Object[] webCustomerObj = ((Object[]) plansPlanprimaryList.get(i));
					plansPlanprimary.add(plansPlanprimaryList.get(i).toString());
				}
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

	public List<String> findFiltersForDeviceModel(String fieldName, String deviceModel)
	{
		Session session = HibernateSessionManager.getSession();
		List<String> plansPlanprimary = null;
		try {

			String query = "Select distinct("+fieldName+") from plans_deviceprimary a  where a.is_active=1 and device_model in ('"+deviceModel+"') order by "+fieldName;
			logger.debug("query in findAllPlans for all " + query);
            List plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, query);

			logger.debug("findAllPlans Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = new ArrayList<String>();
				for (int i=0;i<plansPlanprimaryList.size();i++)
				{
					System.out.println("PlansDeviceprimary data is "+plansPlanprimaryList.get(i));
//                    Object[] webCustomerObj = ((Object[]) plansPlanprimaryList.get(i));
					plansPlanprimary.add(plansPlanprimaryList.get(i).toString());
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		System.out.println("PlansDeviceprimary.size "+plansPlanprimary.size());
		return plansPlanprimary;
	}



	public PlansDeviceprimary findPlansByBrandModelOperatorIDs(String operator, String brand, String device, int memory, String commitment)
	{
		Session session = HibernateSessionManager.getSession();
		PlansDeviceprimary plansPlanprimary = null;
		try {
			List<PlansDeviceprimary> plansPlanprimaryList = null;

			String query = "Select a.* from plans_deviceprimary a where a.is_active=1 and a.operator_id="+operator+" and brand_type = '"+brand+"' and device_model ='"+device+"' and device_memory="+memory+" and commitment='"+commitment+"'";
			logger.debug("query in findPlansByIDs for all " + query);
			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansDeviceprimary.class, query,"plans_deviceprimary");

			logger.debug("findPlansByIDs Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = plansPlanprimaryList.get(0);
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

	public void saveData(PlansDeviceprimary entityObj) {
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

	public static void main(String arg[])
	{
		String query= "select a.id, b.plan_primary_id  from plans_deviceprimary a , plans_deviceplans b where b.deviceprimary_id=a.id  and a.is_active=1 and a.device_memory >0 and a.upfront_plan=0  and a.commitment like '12%' order by a.device_model asc, a.device_memory asc, a.commitment desc, b.cost";
		int pageNumber = 1;
		int results_per_page =10;
		PlansDevicePrimaryDao test = new PlansDevicePrimaryDao();
		test.findPlansByFilter(query, pageNumber, results_per_page);
	}
}
