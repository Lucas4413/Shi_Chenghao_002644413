package Business;

import java.util.ArrayList;

import Role.Role;

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

	public Account createAccount(String username, Role role, String password) {
		if(this.getAccount(username, password)!=null) {
			return null;
		}
		Account userAccount = new Account(username, password, role);
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
	
	public Account getAccount(String username, String password) {
		for (Account acc:this.accountDirectory) {
			if (acc.getUsername().equals(username) && acc.getPassword().equals(password)) {
				return acc;
			}
		}
		return null;
	}
	
	public Boolean accountExists(String username, String password) {
		for (Account acc:this.accountDirectory) {
			if (acc.getUsername().equals(username) && acc.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}
