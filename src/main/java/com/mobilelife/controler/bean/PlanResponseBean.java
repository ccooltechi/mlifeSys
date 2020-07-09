package com.mobilelife.controler.bean;

import java.util.List;

import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlanResponseBean {

	List<PlansPlanprimary> plansPlanprimaryList; 
	int totalPlans ;
	/**
	 * @return the plansPlanprimaryList
	 */
	public List<PlansPlanprimary> getPlansPlanprimaryList() {
		return plansPlanprimaryList;
	}
	/**
	 * @param plansPlanprimaryList the plansPlanprimaryList to set
	 */
	public void setPlansPlanprimaryList(List<PlansPlanprimary> plansPlanprimaryList) {
		this.plansPlanprimaryList = plansPlanprimaryList;
	}
	/**
	 * @return the totalPlans
	 */
	public int getTotalPlans() {
		return totalPlans;
	}
	/**
	 * @param totalPlans the totalPlans to set
	 */
	public void setTotalPlans(int totalPlans) {
		this.totalPlans = totalPlans;
	}
	
	
}
