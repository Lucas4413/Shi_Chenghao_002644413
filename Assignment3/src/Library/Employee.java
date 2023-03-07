package Library;

import Personnel.Person;

public class Employee extends Person{
	private String ID;
	private String experience;
	private String designation;
	private static int count2 = 0;
	private float income = (float) 0;
	
	public String getID() {
		return ID;
	}
	public void setID() {
		this.count2++;
		this.ID = "Employee"+this.count2;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public static int getCount2() {
		return count2;
	}
	public static void setCount2(int count2) {
		Employee.count2 = count2;
	}
	public float getIncome() {
		return income;
	}
	public void setIncome(float income) {
		this.income = income;
	}
	public void addMoney(float money) {
		this.income += money;
	}

}
