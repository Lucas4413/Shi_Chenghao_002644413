package Library;

import Personnel.Person;

public class Employee extends Person{
	private String ID;
	private String experience;
	private String designation;
	private static int count = 0;
	
	public String getID() {
		return ID;
	}
	public void setID() {
		this.count++;
		this.ID = "Employee"+this.count;
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

}
