package Business;

import java.util.ArrayList;

import javax.swing.JFrame;

import Customer.CustomerDirectory;
import Library.AuthorDirectory;
import Library.BookDirectory;
import Library.GenreDirectory;
import Services.MasterRequestDirectory;
import UI.registerWorkArea.RegisterFrame;

public class Application {
	private CustomerDirectory customerDirectory;
	private ArrayList<Branch> branchs;

	public Application() {
		this.customerDirectory = new CustomerDirectory();
		this.branchs = new ArrayList<Branch>();
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
