package Model;

public class Applicant {
	private String ID;
	private String firstName;
	private String lastName;
	private String date;
	private Pet pet;
	
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
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
}
