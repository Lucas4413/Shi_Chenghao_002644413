package Business;

import java.util.ArrayList;

import javax.swing.JFrame;

import Customer.CustomerDirectory;
import Library.AuthorDirectory;
import Library.BookDirectory;
import Library.GenreDirectory;
import Role.Role;
import Role.SystemAdminRole;
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
		
		this.accountDirectory.createAccount("admin", new SystemAdminRole(), "admin");
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

	public void addBranch(String name) {
		this.branchs.add(new Branch(name));
	}
	
	public Branch findBranch(String name) {
		for(Branch b:this.branchs) {
			if(b.getName().equals(name)) {
				return b;
			}
		}
		return null;
	}
	
	public void deleteBranch(String name) {
		this.branchs.remove(this.findBranch(name));
	}
	
	public Branch findAccountInBranch(String username, String password) {
		for(Branch b:this.branchs) {
			if(b.getAccountDirectory().getAccount(username, password)!=null) {
				return b;
			}
		}
		return null;
	}
	
	public JFrame goToRegister(Application business) {
		return new RegisterFrame(business);
	}
}
