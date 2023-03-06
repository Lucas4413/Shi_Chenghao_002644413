package Business;

import javax.swing.JFrame;

import Role.Role;
import UI.adminWorkArea.AdminFrame;
import UI.agentWorkArea.LibrarianFrame;
import UI.customerWorkArea.CustomerFrame;
import UI.managerWorkArea.BranchManagerFrame;

public class Account{
	private String username;
	private String password;
	private String accountId;
	private String role;
	private static int count = 0;

	public Account(String username, String role, String password) {
		this.accountId = "ACC" + count++;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Account.count = count;
	}
	
	public JFrame getWorkArea(String role,Application business, Account account) {
		if(role.equals("admin")) {
			return new AdminFrame(business, account);
		}
		if(role.equals("customer")) {
			return new CustomerFrame(business, account);
		}
		if(role.equals("librarian")) {
			return new LibrarianFrame(business, account);
		}
		if(role.equals("branch manager")) {
			return new BranchManagerFrame(business, account);
		}
		return null;
	}
}
