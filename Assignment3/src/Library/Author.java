package Library;

public class Author {
	String name;
	String nationality;
	String ID;
	private static int count = 0;
	
	public Author(String name, String nationality) {
		this.name = name;
		this.nationality = nationality;
		this.count++;
		this.ID = this.count+"";
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Author.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
}
