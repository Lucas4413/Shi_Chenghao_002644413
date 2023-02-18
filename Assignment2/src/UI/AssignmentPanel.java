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
import Model.InsurancePlans;
import Model.Plan;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;

public class AssignmentPanel extends JPanel {
	private JTable table;
	private JComboBox<String> comboBoxPlan;
	private JTextField tfCostPerMonth;
	private JTextField tfPlanName;
	private JTextField tfCostPerYear;
	private Business business;
	private ApplicantsDirectory applicantsDirectory;
	private InsurancePlans insurancePlans;
	private DefaultTableModel tableModel;
	
	/**
	 * Create the panel.
	 */
	public AssignmentPanel(Business business) {
		setBackground(SystemColor.inactiveCaptionBorder);
		this.business = business;
		this.applicantsDirectory = this.business.getApplicantsDirectory();
		this.insurancePlans = this.business.getInsurancePlans();
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Assign an Insurance Plan to your Pet");
		lblNewLabel.setBounds(330, 20, 262, 15);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 914, 232);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Application ID", "Pet Name", "Pet Age", "Pet Gender", "Pet Type", "Pet Breed", "Insurance Plan ID", "Cost per Month"
			}
		));
		scrollPane.setViewportView(table);
		this.tableModel = (DefaultTableModel) table.getModel();
		
		JLabel lblNewLabel_1 = new JLabel("Please choose one plan:");
		lblNewLabel_1.setBounds(107, 370, 161, 15);
		add(lblNewLabel_1);
		
		comboBoxPlan = new JComboBox<>();
		comboBoxPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Plan targetPlan = insurancePlans.searchById(comboBoxPlan.getSelectedItem()+"");
				tfCostPerMonth.setText(targetPlan.getCostPerMonth()+"");
				tfCostPerYear.setText(targetPlan.getCostPerYear()+"");
				tfPlanName.setText(targetPlan.getPlanName());
			}
		});
		comboBoxPlan.setBounds(256, 394, 188, 23);
		add(comboBoxPlan);
		
		JLabel lblNewLabel_2 = new JLabel("Plan Name:");
		lblNewLabel_2.setBounds(521, 398, 71, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Plan ID:");
		lblNewLabel_3.setBounds(173, 398, 64, 15);
		add(lblNewLabel_3);
		
		tfCostPerMonth = new JTextField();
		tfCostPerMonth.setFont(new Font("宋体", Font.BOLD, 12));
		tfCostPerMonth.setEnabled(false);
		tfCostPerMonth.setColumns(10);
		tfCostPerMonth.setBounds(256, 454, 188, 21);
		add(tfCostPerMonth);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cost per month:");
		lblNewLabel_2_1.setBounds(131, 457, 106, 15);
		add(lblNewLabel_2_1);
		
		tfPlanName = new JTextField();
		tfPlanName.setFont(new Font("宋体", Font.BOLD, 12));
		tfPlanName.setEnabled(false);
		tfPlanName.setColumns(10);
		tfPlanName.setBounds(602, 395, 188, 21);
		add(tfPlanName);
		
		tfCostPerYear = new JTextField();
		tfCostPerYear.setEnabled(false);
		tfCostPerYear.setFont(new Font("宋体", Font.BOLD, 12));
		tfCostPerYear.setColumns(10);
		tfCostPerYear.setBounds(602, 454, 188, 21);
		add(tfCostPerYear);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Cost per year:");
		lblNewLabel_2_1_1.setBounds(496, 457, 96, 15);
		add(lblNewLabel_2_1_1);
		
		JLabel lbResDisplay = new JLabel("");
		lbResDisplay.setBounds(10, 73, 902, 15);
		add(lbResDisplay);
		
		JButton btnAssign = new JButton("Assign");
		btnAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String targetID = table.getValueAt(table.getSelectedRow(), 0)+"";
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Haven't selected any row");
					return;
				}
				
				String targetID = table.getValueAt(table.getSelectedRow(), 0)+"";
				Plan chosedPlan = insurancePlans.searchById(comboBoxPlan.getSelectedItem()+"");
				
				applicantsDirectory.searchById(targetID).getPet().setInsurancePlan(chosedPlan);
				lbResDisplay.setText("The Insurance Plan " + chosedPlan.getPlanName() +" has been assigned to application " + targetID +" Pet Name:"+applicantsDirectory.searchById(targetID).getPet().getName());
			
				displayTable();
			}
		});
		btnAssign.setBounds(422, 515, 106, 49);
		add(btnAssign);

		displayTable();
		populatePlans();
	}
	
	public void displayTable() {
		this.table.removeAll();
		this.tableModel.setRowCount(0);
		for(Applicant a : this.applicantsDirectory.getApplicants()) {
			Object row[] = new Object[8];
			row[0] = a.getID();
			row[1] = a.getPet().getName();
			row[2] = a.getPet().getAge();
			row[3] = a.getPet().getGender();
			row[4] = a.getPet().getPetType();
			row[5] = a.getPet().getBreed();
			row[6] = a.getPet().getInsurancePlan().getID();
			row[7] = a.getPet().getInsurancePlan().getCostPerMonth();
			
			tableModel.addRow(row);
		}
	}
	
	public void populatePlans() {
		if(this.insurancePlans.getInsurancePlans().size()<=0) {
			return;
		}
		
		for(Plan p:this.insurancePlans.getInsurancePlans()) {
			this.comboBoxPlan.addItem(p.getID());
		}
		Plan targetPlan = insurancePlans.searchById(comboBoxPlan.getSelectedItem()+"");
		tfCostPerMonth.setText(targetPlan.getCostPerMonth()+"");
		tfCostPerYear.setText(targetPlan.getCostPerYear()+"");
		tfPlanName.setText(targetPlan.getPlanName());
	}
}
