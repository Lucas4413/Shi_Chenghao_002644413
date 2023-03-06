/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Role;

import Business.Account;
import Business.Application;
import Business.Branch;
import UI.customerWorkArea.CustomerFrame;
import javax.swing.JFrame;

/**
 *
 * @author Nidhi Raghavendra
 */
public class CustomerRole extends Role {

    @Override
    public JFrame createWorkArea(Application business, Branch branch, Account useraccount) {
        // return jframe
        return new CustomerFrame(business, useraccount);
        
    }
    
}
