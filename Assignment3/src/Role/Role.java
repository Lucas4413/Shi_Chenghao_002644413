package Role;

import javax.swing.JFrame;

import Business.Application;
import Business.Branch;
import Business.Account;

public abstract class Role {
    
    private static String[] roles = {"branch manager", "system admin", "customer", "librarian"};
    
    public static String[] getAllRoles() {
        return roles;
    }
    
    public abstract JFrame createWorkArea(Application application, Branch branch, Account useraccount);
}
