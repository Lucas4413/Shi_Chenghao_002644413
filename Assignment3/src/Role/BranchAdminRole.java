/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Role;

import Business.Account;
import Business.Application;
import Business.Branch;
import UI.managerWorkArea.BranchManagerFrame;
import javax.swing.JFrame;

/**
 *
 * @author Nidhi Raghavendra
 */
public class BranchAdminRole extends Role {

    @Override
    public JFrame createWorkArea(Application business, Branch branch, Account useraccount) {
       return new BranchManagerFrame(business, useraccount);
    }
    
}
