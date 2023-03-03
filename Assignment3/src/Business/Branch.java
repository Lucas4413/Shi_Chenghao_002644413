package Business;

import Library.Employee;
import Library.Library;

public class Branch {
	private String name;
	private Library library;
	private AccountDirectory accountDirectory;
	
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

	public AccountDirectory getAccountDirectory() {
		return accountDirectory;
	}

	public void setAccountDirectory(AccountDirectory accountDirectory) {
		this.accountDirectory = accountDirectory;
	}

	public Branch() {
		this.library = new Library();
		this.accountDirectory = new AccountDirectory();
	}
}
