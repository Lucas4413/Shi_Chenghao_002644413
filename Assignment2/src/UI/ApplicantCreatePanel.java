package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Model.Applicant;
import Model.ApplicantsDirectory;
import Model.Business;
import Model.Pet;
import Model.Plan;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class ApplicantCreatePanel extends JPanel {
	private JTable table;
	private JTextField tfAppId;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfPetName;
	private JTextField tfAge;
	private JTextField tfPetType;
	private JTextField tfPetBreed;
	private Business business;
	private ApplicantsDirectory applicantsDirectory;
	private DefaultTableModel tableModel;
	private JTextField tfSearch;
	private ArrayList<Applicant> appsToDisplay;
	
	/**
	 * Create the panel.
	 */
	public ApplicantCreatePanel(Business business) {
		setBackground(Color.PINK);
		this.business = business;
		this.applicantsDirectory = this.business.getApplicantsDirectory();
		this.appsToDisplay = new ArrayList<Applicant>();
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Your Application");
		lblNewLabel.setBounds(297, 27, 178, 15);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 107, 620, 202);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Application ID", "First Name", "Last Name", "Date", "Pet Name"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(107);
		scrollPane.setViewportView(table);
		tableModel = (DefaultTableModel) table.getModel();
		
		JLabel lblNewLabel_1 = new JLabel("Application's Information:");
		lblNewLabel_1.setBounds(10, 331, 172, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pet's Information:");
		lblNewLabel_1_1.setBounds(10, 434, 126, 15);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Owner's Information:");
		lblNewLabel_1_2.setBounds(397, 331, 140, 15);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBounds(82, 356, 54, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Date");
		lblNewLabel_2_1.setBounds(82, 393, 54, 15);
		add(lblNewLabel_2_1);
		
		tfAppId = new JTextField();
		tfAppId.setBounds(146, 353, 148, 21);
		add(tfAppId);
		tfAppId.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(146, 387, 148, 21);
		add(dateChooser);
		
		JLabel lblNewLabel_2_2 = new JLabel("First Name");
		lblNewLabel_2_2.setBounds(448, 356, 89, 15);
		add(lblNewLabel_2_2);
		
		tfFirstName = new JTextField();
		tfFirstName.setColumns(10);
		tfFirstName.setBounds(560, 353, 148, 21);
		add(tfFirstName);
		
		JLabel lblNewLabel_2_3 = new JLabel("Last Name");
		lblNewLabel_2_3.setBounds(448, 390, 89, 15);
		add(lblNewLabel_2_3);
		
		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(560, 387, 148, 21);
		add(tfLastName);
		
		JLabel lblNewLabel_3 = new JLabel("Pet Name");
		lblNewLabel_3.setBounds(82, 459, 65, 15);
		add(lblNewLabel_3);
		
		tfPetName = new JTextField();
		tfPetName.setText("");
		tfPetName.setBounds(157, 456, 137, 21);
		add(tfPetName);
		tfPetName.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Pet Age");
		lblNewLabel_3_1.setBounds(82, 510, 65, 15);
		add(lblNewLabel_3_1);
		
		tfAge = new JTextField();
		tfAge.setText("");
		tfAge.setColumns(10);
		tfAge.setBounds(157, 507, 137, 21);
		add(tfAge);
		
		JLabel lblNewLabel_3_2 = new JLabel("Pet Gender");
		lblNewLabel_3_2.setBounds(82, 569, 74, 15);
		add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Pet Type");
		lblNewLabel_3_3.setBounds(448, 456, 65, 15);
		add(lblNewLabel_3_3);
		
		tfPetType = new JTextField();
		tfPetType.setText("");
		tfPetType.setColumns(10);
		tfPetType.setBounds(523, 453, 137, 21);
		add(tfPetType);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Pet Breed");
		lblNewLabel_3_1_1.setBounds(448, 507, 65, 15);
		add(lblNewLabel_3_1_1);
		
		tfPetBreed = new JTextField();
		tfPetBreed.setText("");
		tfPetBreed.setColumns(10);
		
		tfPetBreed.setBounds(523, 504, 137, 21);
		add(tfPetBreed);
		
		JComboBox comboBoxGender = new JComboBox();
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBoxGender.setBounds(157, 565, 137, 23);
		add(comboBoxGender);
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String appId = tfAppId.getText();
				Date date = dateChooser.getDate();
				String firstName = tfFirstName.getText();
				String lastName = tfLastName.getText();
				String fullName = firstName+" "+lastName;
				String pName = tfPetName.getText();
				String pAge = tfAge.getText();
				String pGender = comboBoxGender.getSelectedItem()+"";
				String pType = tfPetType.getText();
				String pBreed = tfPetBreed.getText();
			
				if(applicantsDirectory.isEmptyOrNull(appId) || applicantsDirectory.isEmptyOrNull(firstName) || applicantsDirectory.isEmptyOrNull(lastName)
						 || applicantsDirectory.isEmptyOrNull(pName) || applicantsDirectory.isEmptyOrNull(pAge) || applicantsDirectory.isEmptyOrNull(pGender)
						 || applicantsDirectory.isEmptyOrNull(pType) || applicantsDirectory.isEmptyOrNull(pBreed) || date == null) {
					JOptionPane.showMessageDialog(null, "Please fill out all the content!");
					return;
				}else if(!applicantsDirectory.isInteger(pAge)) {
					JOptionPane.showMessageDialog(null, "The Pet Age should be a integer number");
					return;
				}else if (applicantsDirectory.searchById(appId)!=null) {
					JOptionPane.showMessageDialog(null, "The applicant ID should be unique!");
					return;
				}else {
					Pet p = new Pet(pName, Integer.valueOf(pAge), pGender, pType, pBreed);
					applicantsDirectory.createApplicant(appId, firstName, lastName, fullName, date, p);
				}
				
				display();
			}
		});
		btnAdd.setBounds(661, 107, 93, 23);
		add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String targetID = table.getValueAt(table.getSelectedRow(), 0)+"";
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Haven't selected any row");
					return;
				}
				
				String targetID = table.getValueAt(table.getSelectedRow(), 0)+"";
				
				if(!applicantsDirectory.isEmptyOrNull(targetID)) {
					applicantsDirectory.deleteApplicant(targetID);
				}
				
				display();
			}
		});
		btnDelete.setBounds(661, 166, 93, 23);
		add(btnDelete);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String targetID = table.getValueAt(table.getSelectedRow(), 0)+"";
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Haven't selected any row");
					return;
				}
				
				String targetID = table.getValueAt(table.getSelectedRow(), 0)+"";
				
				if(!applicantsDirectory.isEmptyOrNull(targetID)) {
					Applicant targetApplicant = applicantsDirectory.searchById(targetID);
					tfAge.setText(targetApplicant.getPet().getAge()+"");
					tfAppId.setText(targetApplicant.getID());
					tfFirstName.setText(targetApplicant.getFirstName());
					tfLastName.setText(targetApplicant.getLastName());
					tfPetBreed.setText(targetApplicant.getPet().getBreed());
					tfPetName.setText(targetApplicant.getPet().getName());
					tfPetType.setText(targetApplicant.getPet().getPetType());
					dateChooser.setDate(targetApplicant.getDate());
					if(targetApplicant.getPet().getGender().equals("Male")) {
						comboBoxGender.setSelectedIndex(0);;
					}else {
						comboBoxGender.setSelectedIndex(1);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Haven't selected any row");
				}
								
			}
		});
		btnView.setBounds(661, 225, 93, 23);
		add(btnView);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String targetID = table.getValueAt(table.getSelectedRow(), 0)+"";
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Haven't selected any row");
					return;
				}
				
				String targetID = table.getValueAt(table.getSelectedRow(), 0)+"";
				String appId = tfAppId.getText();
				Date date = dateChooser.getDate();
				String firstName = tfFirstName.getText();
				String lastName = tfLastName.getText();
				String fullName = firstName+" "+lastName;
				String pName = tfPetName.getText();
				String pAge = tfAge.getText();
				String pGender = comboBoxGender.getSelectedItem()+"";
				String pType = tfPetType.getText();
				String pBreed = tfPetBreed.getText();
				
				if(applicantsDirectory.isEmptyOrNull(appId) || applicantsDirectory.isEmptyOrNull(firstName) || applicantsDirectory.isEmptyOrNull(lastName)
						 || applicantsDirectory.isEmptyOrNull(pName) || applicantsDirectory.isEmptyOrNull(pAge) || applicantsDirectory.isEmptyOrNull(pGender)
						 || applicantsDirectory.isEmptyOrNull(pType) || applicantsDirectory.isEmptyOrNull(pBreed) || date == null) {
					JOptionPane.showMessageDialog(null, "Please fill out all the content!");
					return;
				}else if(!applicantsDirectory.isInteger(pAge)) {
					JOptionPane.showMessageDialog(null, "The Pet Age should be a integer number");
					return;
				}else{
					Applicant targetApplicant = applicantsDirectory.searchById(targetID);
					if(targetApplicant.getID().equals(appId)) {
						applicantsDirectory.updateApplicant(targetApplicant, appId, firstName, lastName, fullName, date,
								pName, Integer.valueOf(pAge), pGender, pType, pBreed);
					}else {
						if (applicantsDirectory.searchById(appId)!=null) {
							JOptionPane.showMessageDialog(null, "The applicant ID should be unique!");
							return;
						}else {
							applicantsDirectory.updateApplicant(targetApplicant, appId, firstName, lastName, fullName, date,
									pName, Integer.valueOf(pAge), pGender, pType, pBreed);
						}
					}
				}
				
				display();
			}
		});
		btnUpdate.setBounds(661, 286, 93, 23);
		add(btnUpdate);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(31, 64, 245, 21);
		add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnNameSearch = new JButton("Search by Name");
		btnNameSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchContent = tfSearch.getText();
				
				if(!applicantsDirectory.isEmptyOrNull(searchContent)) {
					applicantsDirectory.searchByName(appsToDisplay, searchContent);
				}
				
				display(appsToDisplay);
			}
		});
		btnNameSearch.setBounds(297, 63, 135, 23);
		add(btnNameSearch);
		
		JButton btnIdSearch = new JButton("Search by ID");
		btnIdSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchContent = tfSearch.getText();
				
				if(!applicantsDirectory.isEmptyOrNull(searchContent)) {
					appsToDisplay.removeAll(appsToDisplay);
					if(applicantsDirectory.searchById(searchContent)!=null) {
						appsToDisplay.add(applicantsDirectory.searchById(searchContent));
					}
				}
				
				display(appsToDisplay);
			}
		});
		btnIdSearch.setBounds(442, 63, 117, 23);
		add(btnIdSearch);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display();
			}
		});
		btnReset.setBounds(569, 63, 82, 23);
		add(btnReset);

		display();
	}
	
	public void display() {
		tfSearch.setText("");
		this.table.removeAll();
		this.tableModel.setRowCount(0);
		for(Applicant a : this.applicantsDirectory.getApplicants()) {
			Object row[] = new Object[5];
			row[0] = a.getID();
			row[1] = a.getFirstName();
			row[2] = a.getLastName();
			row[3] = a.dateToString();
			row[4] = a.getPet().getName();
			
			tableModel.addRow(row);
		}
	}
	
	public void display(ArrayList<Applicant> applicants) {
		this.table.removeAll();
		this.tableModel.setRowCount(0);
		for(Applicant a : applicants) {
			Object row[] = new Object[5];
			row[0] = a.getID();
			row[1] = a.getFirstName();
			row[2] = a.getLastName();
			row[3] = a.dateToString();
			row[4] = a.getPet().getName();
			
			tableModel.addRow(row);
		}
	}
}
