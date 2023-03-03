package Role;


import Business.Application;
import UI.adminWorkArea.AdminFrame;
import Business.Account;

import javax.swing.JFrame;
import Business.Application;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nidhi Raghavendra
 */
public class ManagerRole extends Role {

    public ManagerRole() {
    }

    
    @Override
    public JFrame getWorkArea(Application business, Account useraccount) {
        return new AdminFrame(business, useraccount);
    }
    
}
