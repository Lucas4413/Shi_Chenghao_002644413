package Business;

import java.util.ArrayList;

import javax.swing.JFrame;

import Customer.CustomerDirectory;
import Library.AuthorDirectory;
import Library.BookDirectory;
import Library.GenreDirectory;
import Services.RequestDirectory;
import UI.registerWorkArea.RegisterFrame;

public class Application {
	private CustomerDirectory customerDirectory;
	private ArrayList<Branch> branchs;
	private AccountDirectory accountDirectory;

	public Application() {
		this.customerDirectory = new CustomerDirectory();
		this.branchs = new ArrayList<Branch>();
		this.accountDirectory = new AccountDirectory();
		
		this.accountDirectory.createAccount("admin", "admin", "admin");
	}
	
	public ArrayList<Branch> getBranchs() {
		return branchs;
	}

	public void setBranchs(ArrayList<Branch> branchs) {
		this.branchs = branchs;
	}

	public AccountDirectory getAccountDirectory() {
		return accountDirectory;
	}

	public void setAccountDirectory(AccountDirectory accountDirectory) {
		this.accountDirectory = accountDirectory;
	}

	public static Application getBusinessInstance() {
		return new Application();
	}
	public CustomerDirectory getCustomerDirectory() {
		return this.customerDirectory;
	}
	public void setCustomerDirectory(CustomerDirectory customerDirectory) {
		this.customerDirectory = customerDirectory;
	}

	
	public JFrame goToRegister(Application business) {
		return new RegisterFrame(business);
	}
}
