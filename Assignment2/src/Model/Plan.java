package Model;

public class Plan {
	private String ID;
	private String planName;
	private float costPerMonth;
	private float costPerYear;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public float getCostPerMonth() {
		return costPerMonth;
	}
	public void setCostPerMonth(float costPerMonth) {
		this.costPerMonth = costPerMonth;
	}
	public float getCostPerYear() {
		return costPerYear;
	}
	public void setCostPerYear(float costPerYear) {
		this.costPerYear = costPerYear;
	}
}
