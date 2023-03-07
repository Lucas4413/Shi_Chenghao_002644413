package Business;

import Library.Employee;
import Library.Library;
import Services.RequestDirectory;

public class Branch {
	private String name;
	private Library library;
	private AccountDirectory accountDirectory;

	
	public Branch(String name) {
		this.name = name;
		this.library = new Library();
		this.accountDirectory = new AccountDirectory();
	}
	
	public AccountDirectory getAccountDirectory() {
		return accountDirectory;
	}

	public void setAccountDirectory(AccountDirectory accountDirectory) {
		this.accountDirectory = accountDirectory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

}
