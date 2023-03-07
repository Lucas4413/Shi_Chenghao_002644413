package UI.adminWorkArea;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.html.HTMLTableCaptionElement;

import Business.Account;
import Business.AccountDirectory;
import Business.Application;
import Business.Branch;
import Library.Author;
import Library.AuthorDirectory;
import Library.Employee;
import Library.Genre;
import Library.GenreDirectory;
import Library.Library;
import Library.Magzine;
import Role.BranchAdminRole;
import Role.LibrarianRole;
import Services.RequestDirectory;
import Services.Request;

import java.awt.Choice;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class EmployeeManagementJpanel extends JPanel {
	private JTable table;
	private DefaultTableModel tableModel;
	private Application business;
	private JTextField tfName;
	private JTextField tfAge;
	private AuthorDirectory authorDirectory;
	private GenreDirectory genreDirectory;
	private JComboBox<String> comboBoxDesignation;
	private JTextField tfUsername;
	private JTextField tfPassword;
	private Branch currentBranch;
	private ArrayList<Branch> branchs;
	private JTextField tfExperience;
	
	/**
	 * Create the panel.
	 */
	public EmployeeManagementJpanel(Application business) {
		this.business = business;
		this.branchs = this.business.getBranchs();
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 66, 708, 133);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Emploee ID", "Person ID", "Name", "Age", "Username", "Password", "Designation"
			}
		));
		
		tableModel =(DefaultTableModel) table.getModel();
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(55, 254, 85, 15);
		add(lblNewLabel);
		
		tfName = new JTextField();
		tfName.setBounds(135, 254, 195, 21);
		add(tfName);
		tfName.setColumns(10);
		
		JLabel lblNationality = new JLabel("Age");
		lblNationality.setBounds(55, 298, 85, 15);
		add(lblNationality);
		
		tfAge = new JTextField();
		tfAge.setColumns(10);
		tfAge.setBounds(135, 298, 195, 21);
		add(tfAge);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameString = tfName.getText();
				String age = tfAge.getText();
				String username = tfUsername.getText();
				String password = tfPassword.getText();
				String designation = comboBoxDesignation.getSelectedItem()+"";
				String experience = tfExperience.getText();
				if(EmployeeManagementJpanel.this.business.getAccountDirectory().accountExists(username, password)) {
					JOptionPane.showMessageDialog(null, "This account has existed");
					return;
				}
				
				if(designation.equals("librarian") && currentBranch.getLibrary().getEmployeeDirectory().getLibrarian()==null) {
					Account acc = EmployeeManagementJpanel.this.business.getAccountDirectory().createAccount(username, new LibrarianRole(), password);
//					EmployeeManagementJpanel.this.business.getCustomerDirectory().createCustomer(nameString, age);
					currentBranch.getAccountDirectory().getAccountDirectory().add(acc);
					System.out.println(acc.getAccountId());
					currentBranch.getLibrary().getEmployeeDirectory().setLibrarian(nameString, age, experience, designation);
					System.out.println(currentBranch.getLibrary().getEmployeeDirectory().getLibrarian().getPersonID());
				}else if (designation .equals("branch manager") && currentBranch.getLibrary().getEmployeeDirectory().getBranchManagerEmployee()==null) {
					Account acc = EmployeeManagementJpanel.this.business.getAccountDirectory().createAccount(username, new BranchAdminRole(), password);
//					EmployeeManagementJpanel.this.business.getCustomerDirectory().createCustomer(nameString, age);
					currentBranch.getAccountDirectory().getAccountDirectory().add(acc);
					currentBranch.getLibrary().getEmployeeDirectory().setBranchManagerEmployee(nameString, age, experience, designation);
				}else {
					JOptionPane.showMessageDialog(null, "this position has been assigned");
				}
				populate();
			}
		});
		btnAdd.setBounds(327, 429, 93, 23);
		add(btnAdd);
		
		comboBoxDesignation = new JComboBox<>();
		comboBoxDesignation.setBounds(135, 363, 195, 23);
		add(comboBoxDesignation);
		comboBoxDesignation.addItem("librarian");
		comboBoxDesignation.addItem("branch manager");
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentBranch = EmployeeManagementJpanel.this.business.findBranch(comboBox.getSelectedItem()+"");
				populate();
			}
		});
		comboBox.setBounds(160, 33, 85, 23);
		add(comboBox);
		for(Branch b:this.business.getBranchs()) {
			comboBox.addItem(b.getName());
		}
		this.currentBranch = EmployeeManagementJpanel.this.business.findBranch(comboBox.getSelectedItem()+"");
		
		JLabel lblNewLabel_1 = new JLabel("Select Branch Here:");
		lblNewLabel_1.setBounds(20, 37, 130, 15);
		add(lblNewLabel_1);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(407, 254, 85, 15);
		add(lblUsername);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(487, 254, 195, 21);
		add(tfUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(407, 298, 85, 15);
		add(lblPassword);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(487, 298, 195, 21);
		add(tfPassword);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setBounds(55, 367, 85, 15);
		add(lblDesignation);
		
		JLabel lblNewLabel_2 = new JLabel("Experience");
		lblNewLabel_2.setBounds(407, 367, 76, 15);
		add(lblNewLabel_2);
		
		tfExperience = new JTextField();
		tfExperience.setColumns(10);
		tfExperience.setBounds(487, 364, 195, 21);
		add(tfExperience);

	}
	
	public void populate() {
		this.tableModel.setRowCount(0);
		Employee librarian = this.currentBranch.getLibrary().getEmployeeDirectory().getLibrarian();
		Employee manager = this.currentBranch.getLibrary().getEmployeeDirectory().getBranchManagerEmployee();
		AccountDirectory accountDirectory = this.business.getAccountDirectory();
		Object row[] = new Object[7];
		if(librarian != null) {
			row[0] = librarian.getID();
			row[1] = librarian.getPersonID();
			row[2] = librarian.getName();
			row[3] = librarian.getAge();
			row[4] = accountDirectory.findById(librarian.getPersonID()).getUsername();
			row[5] = accountDirectory.findById(librarian.getPersonID()).getPassword();
			row[6] = librarian.getDesignation();
			this.tableModel.addRow(row);
		}
		if(manager != null) {
			row[0] = manager.getID();
			row[1] = manager.getPersonID();
			row[2] = manager.getName();
			row[3] = manager.getAge();
			row[4] = accountDirectory.findById(manager.getPersonID()).getUsername();
			row[5] = accountDirectory.findById(manager.getPersonID()).getPassword();
			row[6] = manager.getDesignation();
			this.tableModel.addRow(row);
		}
		
	}
	
	public void populateGenre() {
		this.comboBoxDesignation.removeAllItems();
		for(Genre g: this.genreDirectory.getGenres()) {
			this.comboBoxDesignation.addItem(g.getGenre());
		}
	}
}
