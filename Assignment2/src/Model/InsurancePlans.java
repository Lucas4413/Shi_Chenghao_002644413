package Model;

import java.util.ArrayList;

public class InsurancePlans {
	ArrayList<Plan> insurancePlans;
	
	public InsurancePlans() {
		this.insurancePlans = new ArrayList<Plan>();
	}

	public ArrayList<Plan> getInsurancePlans() {
		return insurancePlans;
	}

	public void setInsurancePlans(ArrayList<Plan> insurancePlans) {
		this.insurancePlans = insurancePlans;
	}
	
	public void createPlan(String name, float cpm, float cpy) {
		Plan plan = new Plan();
		plan.setCostPerMonth(cpm);
		plan.setCostPerYear(cpy);
		plan.setID(plan.getCount()+"");
		plan.setPlanName(name);
		this.insurancePlans.add(plan);
	}
	
	public void deletePlan(int idx) {
		this.insurancePlans.remove(idx);
	}
	
	public void updatePlan(Plan targetPlan, String name, float cpm, float cpy) {
		if(targetPlan!=null) {
			targetPlan.setPlanName(name);
			targetPlan.setCostPerMonth(cpm);
			targetPlan.setCostPerYear(cpy);
		}
	}
	
	public Boolean isFloat(String s) {
		try {
			Float.parseFloat(s);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public Plan searchById(String s) {
		for(Plan p:this.insurancePlans) {
			if(p.getID().equals(s)) {
				return p;
			}
		}
		return null;
	}
	
	public Plan searchByName(String name) {
		for(Plan p:this.insurancePlans) {
			if(p.getPlanName().equals(name)) {
				return p;
			}
		}
		return null;
	}
}
