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
	
	public void createPlan(String id, String name, float cpm, float cpy) {
		Plan plan = new Plan();
		plan.setCostPerMonth(cpm);
		plan.setCostPerYear(cpy);
		plan.setID(id);
		plan.setPlanName(name);
		this.insurancePlans.add(plan);
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
}
