package UI.adminWorkArea;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Business.Application;
import Customer.Customer;
import Customer.CustomerDirectory;
import Role.CustomerRole;
import Services.Request;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerManagementJPanel extends JPanel {
	private JTable table;
	private JTextField tfUserName;
	private JTextField tfName;
	private JTextField tfAge;
	private Application business;
	private DefaultTableModel tableModel;
	private CustomerDirectory customerDirectory;
	private JTextField tfPassword;

	/**
	 * Create the panel.
	 */
	public CustomerManagementJPanel(Application business) {
		this.business = business;
		this.customerDirectory = this.business.getCustomerDirectory();
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(344, 51, 319, 262);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Person ID", "Username", "Name", "Age"
			}
		));
		
		tableModel =(DefaultTableModel) table.getModel();
		
		tfUserName = new JTextField();
		tfUserName.setBounds(145, 185, 121, 21);
		add(tfUserName);
		tfUserName.setColumns(10);
		
		JLabel lbPersonID = new JLabel("UserName");
		lbPersonID.setBounds(46, 188, 68, 15);
		add(lbPersonID);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(145, 71, 121, 21);
		add(tfName);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(46, 74, 54, 15);
		add(lblName);
		
		tfAge = new JTextField();
		tfAge.setColumns(10);
		tfAge.setBounds(145, 133, 121, 21);
		add(tfAge);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(46, 136, 54, 15);
		add(lblAge);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tfUserName.getText();
				String name = tfName.getText();
				String age = tfAge.getText();
				String password = tfPassword.getText();
				System.out.println();
				if(!CustomerManagementJPanel.this.business.getAccountDirectory().accountExists(id, password)) {
					business.getCustomerDirectory().createCustomer(name, age);
					business.getAccountDirectory().createAccount(id, new CustomerRole(), password);
					populate();
				}else {
					JOptionPane.showMessageDialog(null, "This customer has existed");
				}
				
			}
		});
		btnAdd.setBounds(111, 350, 93, 23);
		add(btnAdd);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(46, 251, 68, 15);
		add(lblPassword);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(145, 248, 121, 21);
		add(tfPassword);

		populate();
	}
	
	public void populate() {
		this.tableModel.setRowCount(0);
		for (Customer c:this.customerDirectory.getCustomers()) {
			Object row[] = new Object[4];
			row[0] = c.getPersonID();
			row[1] = business.getAccountDirectory().findById(c.getPersonID()).getUsername();
			row[2] = c.getName();
			row[3] = c.getAge();
			this.tableModel.addRow(row);
		}
	}
}
