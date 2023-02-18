package Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Applicant {
	private String ID;
	private String firstName;
	private String lastName;
	private String fullName;
	private Date date;
	private Pet pet;
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Applicant() {
		this.pet = new Pet();
	}
	
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void createPet(String name,int age,String gender,String petType,String breed) {
		Pet pet = new Pet();
		pet.setAge(age);
		pet.setBreed(breed);
		pet.setGender(gender);
		pet.setName(name);
		pet.setPetType(petType);
		this.pet = pet;
	}
	
	public String dateToString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		return simpleDateFormat.format(this.date);
	}
	
	public Date stringToDate(String string) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		try {
			Date date = simpleDateFormat.parse(string);
			return date;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
