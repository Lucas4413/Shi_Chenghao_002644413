package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Model.Applicant;
import Model.ApplicantsDirectory;
import Model.Business;
import Model.Pet;
import Model.Plan;
import Model.Vaccine;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VaccineMangementPanel extends JPanel {
	private JTable table;
	private JTextField tfVaccineName;
	private Business business;
	private ApplicantsDirectory applicantsDirectory;
	private JComboBox<String> comboBoxAppId;
	private DefaultTableModel tableModel;
	private Pet selectedPet;

	/**
	 * Create the panel.
	 */
	public VaccineMangementPanel(Business business) {
		this.business = business;
		this.applicantsDirectory = this.business.getApplicantsDirectory();
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Pets' Vaccine");
		lblNewLabel.setBounds(333, 29, 144, 15);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(451, 138, 372, 379);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Vaccine Name", "Course Completed?"
			}
		));
		scrollPane.setViewportView(table);
		tableModel = (DefaultTableModel) table.getModel();
		
		JLabel lbSelectedPetName = new JLabel("");
		lbSelectedPetName.setBounds(687, 109, 136, 15);
		add(lbSelectedPetName);
		
		comboBoxAppId = new JComboBox<>();
		comboBoxAppId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPet = applicantsDirectory.searchById(comboBoxAppId.getSelectedItem()+"").getPet();
				lbSelectedPetName.setText(selectedPet.getName());
				display();
			}
		});
		comboBoxAppId.setBounds(452, 105, 81, 23);
		add(comboBoxAppId);
		
		JLabel lblNewLabel_1 = new JLabel("Select the pet you want to view:");
		lblNewLabel_1.setBounds(452, 80, 272, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Vaccine Name");
		lblNewLabel_2.setBounds(70, 191, 116, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Course Completed?");
		lblNewLabel_2_1.setBounds(70, 250, 116, 15);
		add(lblNewLabel_2_1);
		
		tfVaccineName = new JTextField();
		tfVaccineName.setBounds(196, 188, 184, 21);
		add(tfVaccineName);
		tfVaccineName.setColumns(10);
		
		JComboBox comboBoxComplete = new JComboBox<>();
		comboBoxComplete.setModel(new DefaultComboBoxModel(new String[] {"yes", "no"}));
		comboBoxComplete.setBounds(196, 246, 184, 23);
		add(comboBoxComplete);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vaccineName = tfVaccineName.getText();
				String courseComplete = comboBoxComplete.getSelectedItem()+"";
				Boolean ifCourseComplete = false;
				if(courseComplete.equals("yes")) {
					ifCourseComplete = true;
				}
				if (applicantsDirectory.isEmptyOrNull(vaccineName)) {
					JOptionPane.showMessageDialog(null, "The Vaccine Name should not be empty");
					return;
				}else if (selectedPet.searchByName(vaccineName)!=null) {
					JOptionPane.showMessageDialog(null, "Information of this vaccine has been recorded");
					return;
				}else {
					selectedPet.addVaccine(vaccineName, ifCourseComplete);
				}
				display();
			}
		});
		btnAdd.setBounds(93, 362, 93, 23);
		add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String targetName = table.getValueAt(table.getSelectedRow(), 0)+"";
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Haven't selected any row");
					return;
				}
				
				String targetName = table.getValueAt(table.getSelectedRow(), 0)+"";
				selectedPet.deleteVaccine(targetName);
				
				display();
			}
		});
		btnDelete.setBounds(275, 362, 93, 23);
		add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String targetName = table.getValueAt(table.getSelectedRow(), 0)+"";
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Haven't selected any row");
					return;
				}
				
				String targetName = table.getValueAt(table.getSelectedRow(), 0)+"";
				Vaccine targetVaccine = selectedPet.searchByName(targetName);
				String newName = tfVaccineName.getText();
				String newCourseComplete = comboBoxComplete.getSelectedItem()+"";
				Boolean ifCourseComplete = false;
				if(newCourseComplete.equals("yes")) {
					ifCourseComplete = true;
				}
				if(newName.equals(targetVaccine.getVaccineName())) {
					selectedPet.updateVaccine(targetVaccine, newName, ifCourseComplete);
				}else {
					if(selectedPet.searchByName(newName)!=null) {
						selectedPet.updateVaccine(targetVaccine, newName, ifCourseComplete);
					}else {
						JOptionPane.showMessageDialog(null, "This kind of vaccine has been recorded");
						return;
					}
				}
				
				display();
			}
		});
		btnUpdate.setBounds(275, 433, 93, 23);
		add(btnUpdate);
		
		JLabel lblNewLabel_3 = new JLabel("Selected Pet's name:");
		lblNewLabel_3.setBounds(543, 109, 136, 15);
		add(lblNewLabel_3);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String targetName = table.getValueAt(table.getSelectedRow(), 0)+"";
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Haven't selected any row");
					return;
				}
				
				String targetName = table.getValueAt(table.getSelectedRow(), 0)+"";
				Vaccine selectedVaccine = selectedPet.searchByName(targetName);
				if(selectedVaccine == null) {
					return;
				}else {
					tfVaccineName.setText(selectedVaccine.getVaccineName());
					if(selectedVaccine.getIsCourseCompleted()) {
						comboBoxComplete.setSelectedIndex(0);
					}else {
						comboBoxComplete.setSelectedIndex(1);
					}
				}
			}
		});
		btnView.setBounds(93, 433, 93, 23);
		add(btnView);
		
		populateApps();
	}
	
	public void display() {
		if(selectedPet == null) {
			JOptionPane.showMessageDialog(null, "No Pet selected");
			return;
		}
		
		this.table.removeAll();
		this.tableModel.setRowCount(0);
		selectedPet = this.applicantsDirectory.searchById(this.comboBoxAppId.getSelectedItem()+"").getPet();
		for(Vaccine v : this.selectedPet.getVaccines()) {
			
			Object row[] = new Object[2];
			row[0] = v.getVaccineName();
			if(v.getIsCourseCompleted()) {
				row[1] = "yes";
			}else {
				row[1] = "no";
			}
			
			tableModel.addRow(row);
		}
	}
	
	public void populateApps() {
		if(this.applicantsDirectory.getApplicants().size()<=0) {
			return;
		}
		for(Applicant a:this.applicantsDirectory.getApplicants()) {
			this.comboBoxAppId.addItem(a.getID());
		}
		this.selectedPet = this.applicantsDirectory.searchById(this.comboBoxAppId.getSelectedItem()+"").getPet();
		display();
	}

}
