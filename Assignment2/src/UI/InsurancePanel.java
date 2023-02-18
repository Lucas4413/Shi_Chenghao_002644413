package UI;

import javax.swing.JPanel;

import Model.Business;
import Model.InsurancePlans;
import Model.Plan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsurancePanel extends JPanel {
	private Business business;
	private InsurancePlans insurancePlans;
	private JTable table;
	private JTextField tfInsuranceName;
	private JTextField tfCostPerMonth;
	private JTextField tfCostPerYear;
	private DefaultTableModel tableModel;
	private Plan selectedPlan; 
	
	/**
	 * Create the panel.
	 */
	public InsurancePanel(Business business) {
		this.business = business;
		this.insurancePlans = this.business.getInsurancePlans();
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mange the Insurances Plans");
		lblNewLabel.setBounds(305, 36, 193, 15);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(402, 115, 360, 361);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Plan ID", "Plan Name", "Cost Per Month", "Cost Per Year"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(103);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		this.tableModel = (DefaultTableModel) table.getModel();
		
		tfInsuranceName = new JTextField();
		tfInsuranceName.setBounds(191, 168, 166, 21);
		add(tfInsuranceName);
		tfInsuranceName.setColumns(10);
		
		JLabel lbInsuranceName = new JLabel("Insurance Name");
		lbInsuranceName.setBounds(53, 171, 111, 15);
		add(lbInsuranceName);
		
		tfCostPerMonth = new JTextField();
		tfCostPerMonth.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String cpm = tfCostPerMonth.getText();
				if(insurancePlans.isFloat(cpm)) {
					String cpy = Float.parseFloat(cpm)*12 + "";
					tfCostPerYear.setText(cpy);
				}else {
					JOptionPane.showMessageDialog(null, "The cost should be a number!");
					return; 
				}
			}
		});
		tfCostPerMonth.setColumns(10);
		tfCostPerMonth.setBounds(191, 230, 166, 21);
		add(tfCostPerMonth);
		
		JLabel lblCostPerMonth = new JLabel("Cost Per Month");
		lblCostPerMonth.setBounds(53, 233, 111, 15);
		add(lblCostPerMonth);
		
		tfCostPerYear = new JTextField();
		tfCostPerYear.setEnabled(false);
		tfCostPerYear.setColumns(10);
		tfCostPerYear.setBounds(191, 291, 166, 21);
		add(tfCostPerYear);
		
		JLabel lblCostPerYear = new JLabel("Cost Per Year");
		lblCostPerYear.setBounds(53, 294, 111, 15);
		add(lblCostPerYear);
		
		JLabel lblNewLabel_1 = new JLabel("ID of Selected Plan:");
		lblNewLabel_1.setBounds(53, 116, 128, 15);
		add(lblNewLabel_1);
		
		JLabel lbSelectedID = new JLabel("");
		lbSelectedID.setBounds(191, 116, 54, 15);
		add(lbSelectedID);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPlan = null;
				lbSelectedID.setText("");
				String name = tfInsuranceName.getText();
				String cpm = tfCostPerMonth.getText();
				String cpy = tfCostPerYear.getText();
				
				if(!business.isEmptyOrNull(cpm)&&!business.isEmptyOrNull(cpy)&&!business.isEmptyOrNull(name)) {
					insurancePlans.createPlan(name, Float.parseFloat(cpm), Float.parseFloat(cpy));
				}else if (insurancePlans.searchByName(name)!= null) {
					JOptionPane.showMessageDialog(null, "Please enter an unique plan name!");
					return;
				}else {
					JOptionPane.showMessageDialog(null, "Please fill out all the content!");
					return;
				}
				display();
			}
		});
		btnAdd.setBounds(149, 369, 93, 23);
		add(btnAdd);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				Plan targetPlan = insurancePlans.getInsurancePlans().get(selectedRow);
				selectedPlan = targetPlan;
				lbSelectedID.setText(targetPlan.getID());
				tfInsuranceName.setText(targetPlan.getPlanName());
				tfCostPerMonth.setText(targetPlan.getCostPerMonth()+"");
				tfCostPerYear.setText(targetPlan.getCostPerYear()+"");
			}
		});
		btnView.setBounds(402, 510, 93, 23);
		add(btnView);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPlan = null;
				lbSelectedID.setText("");
				int selectedRow = table.getSelectedRow();
				if(selectedRow !=-1) {
					insurancePlans.deletePlan(selectedRow);
				}else {
					return;
				}
				display();
			}
		});
		btnDelete.setBounds(540, 510, 93, 23);
		add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedPlan==null) {
					JOptionPane.showMessageDialog(null, "You haven't select any plan yet");
					return;
				}else {
					String name = tfInsuranceName.getText();
					String cpm = tfCostPerMonth.getText();
					String cpy = tfCostPerYear.getText();
					
					if(!business.isEmptyOrNull(cpm)&&!business.isEmptyOrNull(cpy)&&!business.isEmptyOrNull(name)) {
						insurancePlans.updatePlan(selectedPlan, name, Float.parseFloat(cpm), Float.parseFloat(cpy));
					}else if (insurancePlans.searchByName(name)!= null) {
						JOptionPane.showMessageDialog(null, "Please enter an unique plan name!");
						return;
					}else {
						JOptionPane.showMessageDialog(null, "Please fill out all the content!");
						return;
					}
					display();
				}
				selectedPlan = null;
				lbSelectedID.setText("");
			}
		});
		btnUpdate.setBounds(671, 510, 93, 23);
		add(btnUpdate);
		
		display();
	}
	
	public void display() {
		this.tableModel.setRowCount(0);
		for(Plan plan : this.insurancePlans.getInsurancePlans()) {
			Object row[] = new Object[4];
			row[0] = plan.getID();
			row[1] = plan.getPlanName();
			row[2] = plan.getCostPerMonth();
			row[3] = plan.getCostPerYear();
			
			tableModel.addRow(row);
		}
	}
}
