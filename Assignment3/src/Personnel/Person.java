package Personnel;

public class Person {
	String personID;
	String name;
	String age;
	
	public Person() {
			
	}
	
	public Person(String id, String name, String age) {
		this.personID = id;
		this.name = name;
		this.age = age;
	}

	public String getPersonID() {
		return personID;
	}

	public void setPersonID(String personID) {
		this.personID = personID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
