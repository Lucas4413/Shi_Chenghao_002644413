package Personnel;

public class Person {
	private String personID;
	private String name;
	private String age;
	private static int count = 0;
	
	public Person() {
	}
	
	public void Person(String name, String age) {
		this.count++;
		this.personID = this.count+"";
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
