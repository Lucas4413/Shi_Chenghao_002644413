package UI.adminWorkArea;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Business.Application;
import Customer.Customer;
import Customer.CustomerDirectory;
import Services.Request;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerManagementJPanel extends JPanel {
	private JTable table;
	private JTextField tfID;
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
		scrollPane.setBounds(276, 51, 253, 262);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Username", "Name", "Age"
			}
		));
		
		tableModel =(DefaultTableModel) table.getModel();
		
		tfID = new JTextField();
		tfID.setBounds(130, 83, 121, 21);
		add(tfID);
		tfID.setColumns(10);
		
		JLabel lbPersonID = new JLabel("ID");
		lbPersonID.setBounds(31, 86, 54, 15);
		add(lbPersonID);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(130, 139, 121, 21);
		add(tfName);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(31, 142, 54, 15);
		add(lblName);
		
		tfAge = new JTextField();
		tfAge.setColumns(10);
		tfAge.setBounds(130, 201, 121, 21);
		add(tfAge);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(31, 204, 54, 15);
		add(lblAge);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tfID.getText();
				String name = tfName.getText();
				String age = tfAge.getText();
				String password = tfPassword.getText();
				business.getCustomerDirectory().createCustomer(id, name, age);
				business.getAccountDirectory().createAccount(id, "customer", password);
				populate();
			}
		});
		btnAdd.setBounds(89, 394, 93, 23);
		add(btnAdd);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(31, 319, 68, 15);
		add(lblPassword);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(130, 316, 121, 21);
		add(tfPassword);

		populate();
	}
	
	public void populate() {
		this.tableModel.setRowCount(0);
		for (Customer c:this.customerDirectory.getCustomers()) {
			Object row[] = new Object[3];
			row[0] = c.getPersonID();
			row[1] = c.getName();
			row[2] = c.getAge();
			this.tableModel.addRow(row);
		}
	}
}
