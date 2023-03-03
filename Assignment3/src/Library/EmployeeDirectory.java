package Library;

public class EmployeeDirectory {
	private Employee librarian;
	private Employee branchManager;
	
	public EmployeeDirectory() {
		this.librarian = new Employee();
		this.branchManager = new Employee();
	}
	
	public Employee getLibrarian() {
		return librarian;
	}
	public void setLibrarian(Employee librarian) {
		this.librarian = librarian;
	}
	public Employee getBranchManagerEmployee() {
		return branchManager;
	}
	public void setBranchManagerEmployee(Employee branchManagerEmployee) {
		this.branchManager = branchManagerEmployee;
	}
}
