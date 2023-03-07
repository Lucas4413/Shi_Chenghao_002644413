package Library;

public class EmployeeDirectory {
	private Employee librarian;
	private Employee branchManager;
	
	public EmployeeDirectory() {
		
	}
	
	public Employee getLibrarian() {
		return librarian;
	}
	public void setLibrarian(String name, String age, String experience, String designation) {
		this.librarian = new Employee();
		this.librarian.setExperience(experience);
		this.librarian.setExperience(experience);
		this.librarian.setDesignation(designation);
		this.librarian.setID();
		this.librarian.Person(name, age);
	}
	public Employee getBranchManagerEmployee() {
		return branchManager;
	}
	public void setBranchManagerEmployee(String name, String age, String experience, String designation) {
		this.branchManager = new Employee();
		this.branchManager.setExperience(experience);
		this.branchManager.setExperience(experience);
		this.branchManager.setDesignation(designation);
		this.branchManager.setID();
		this.branchManager.Person(name, age);
	}
	
	
}
