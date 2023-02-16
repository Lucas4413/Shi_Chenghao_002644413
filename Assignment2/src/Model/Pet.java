package Model;

import java.util.ArrayList;

public class Pet {
	private String name;
	private int age;
	private String gender;
	private String petType;
	private String breed;
	private ArrayList<Vaccine> vaccines;
	private Plan insurancePlan;
	
	public Pet() {
		this.vaccines = new ArrayList<Vaccine>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPetType() {
		return petType;
	}
	public void setPetType(String petType) {
		this.petType = petType;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public ArrayList<Vaccine> getVaccines() {
		return vaccines;
	}
	public void setVaccines(ArrayList<Vaccine> vaccines) {
		this.vaccines = vaccines;
	}
	public Plan getInsurancePlan() {
		return insurancePlan;
	}
	public void setInsurancePlan(Plan insurancePlan) {
		this.insurancePlan = insurancePlan;
	}
	
	public void addVaccine(String name, Boolean isCompleted) {
		Vaccine vaccine = new Vaccine();
		vaccine.setIsCourseCompleted(isCompleted);
		vaccine.setVaccineName(name);
		this.vaccines.add(vaccine);
	}
	
	public Boolean isInteger(String s) {
		try {
			Integer.valueOf(s);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
