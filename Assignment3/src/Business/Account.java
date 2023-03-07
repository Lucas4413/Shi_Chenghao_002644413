package Business;

import javax.management.relation.RoleResult;
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
	private Role role;
	private static int count = -1;

	public Account(String username, String password, Role role1) {
		this.count++;
		this.accountId = this.count+"";
		this.username = username;
		this.password = password;
		this.role = role1;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
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

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Account.count = count;
	}
	
}
