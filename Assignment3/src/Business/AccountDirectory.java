package Business;

import java.util.ArrayList;

public class AccountDirectory {
	ArrayList<Account> accountDirectory;

	public AccountDirectory() {
		this.accountDirectory = new ArrayList<Account>();
	}
	
	public ArrayList<Account> getAccountDirectory() {
		return accountDirectory;
	}

	public void setAccountDirectory(ArrayList<Account> accountDirectory) {
		this.accountDirectory = accountDirectory;
	}

	public Account createAccount(String username, String role, String password) {
		Account userAccount = new Account(username, role, password);
		this.accountDirectory.add(userAccount);
		return userAccount;
	}
	
	public Account findById(String id) {
		for (Account acc:this.accountDirectory) {
			if (acc.getAccountId().equals(id)) {
				return acc;
			}
		}
		return null;
	}
	
	public Account getAccount(String username, String role, String password) {
		for (Account acc:this.accountDirectory) {
			if (acc.getUsername().equals(username) && acc.getPassword().equals(password) && acc.getRole().equals(role)) {
				return acc;
			}
		}
		return null;
	}
	
	public Boolean accountExists(String username, String role, String password) {
		for (Account acc:this.accountDirectory) {
			if (acc.getUsername().equals(username) && acc.getPassword().equals(password) && acc.getRole().equals(role)) {
				return true;
			}
		}
		return false;
	}
}
