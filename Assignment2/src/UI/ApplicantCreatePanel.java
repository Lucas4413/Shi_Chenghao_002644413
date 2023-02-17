package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Model.Business;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

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

	/**
	 * Create the panel.
	 */
	public ApplicantCreatePanel(Business business) {
		this.business = business;
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Your Application");
		lblNewLabel.setBounds(297, 27, 178, 15);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 61, 620, 202);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Application ID", "Date", "First Name", "Last Name", "Pet Name"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(107);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Application's Information:");
		lblNewLabel_1.setBounds(10, 285, 172, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pet's Information:");
		lblNewLabel_1_1.setBounds(10, 388, 126, 15);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Owner's Information:");
		lblNewLabel_1_2.setBounds(397, 285, 140, 15);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBounds(82, 310, 54, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Date");
		lblNewLabel_2_1.setBounds(82, 347, 54, 15);
		add(lblNewLabel_2_1);
		
		tfAppId = new JTextField();
		tfAppId.setBounds(146, 307, 148, 21);
		add(tfAppId);
		tfAppId.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("MM/dd/YYYY");
		dateChooser.setBounds(146, 341, 148, 21);
		add(dateChooser);
		
		JLabel lblNewLabel_2_2 = new JLabel("First Name");
		lblNewLabel_2_2.setBounds(448, 310, 89, 15);
		add(lblNewLabel_2_2);
		
		tfFirstName = new JTextField();
		tfFirstName.setColumns(10);
		tfFirstName.setBounds(560, 307, 148, 21);
		add(tfFirstName);
		
		JLabel lblNewLabel_2_3 = new JLabel("Last Name");
		lblNewLabel_2_3.setBounds(448, 344, 89, 15);
		add(lblNewLabel_2_3);
		
		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(560, 341, 148, 21);
		add(tfLastName);
		
		JLabel lblNewLabel_3 = new JLabel("Pet Name");
		lblNewLabel_3.setBounds(82, 413, 65, 15);
		add(lblNewLabel_3);
		
		tfPetName = new JTextField();
		tfPetName.setText("");
		tfPetName.setBounds(157, 410, 137, 21);
		add(tfPetName);
		tfPetName.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Pet Age");
		lblNewLabel_3_1.setBounds(82, 464, 65, 15);
		add(lblNewLabel_3_1);
		
		tfAge = new JTextField();
		tfAge.setText("");
		tfAge.setColumns(10);
		tfAge.setBounds(157, 461, 137, 21);
		add(tfAge);
		
		JLabel lblNewLabel_3_2 = new JLabel("Pet Gender");
		lblNewLabel_3_2.setBounds(82, 523, 74, 15);
		add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Pet Type");
		lblNewLabel_3_3.setBounds(448, 410, 65, 15);
		add(lblNewLabel_3_3);
		
		tfPetType = new JTextField();
		tfPetType.setText("");
		tfPetType.setColumns(10);
		tfPetType.setBounds(523, 407, 137, 21);
		add(tfPetType);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Pet Breed");
		lblNewLabel_3_1_1.setBounds(448, 461, 65, 15);
		add(lblNewLabel_3_1_1);
		
		tfPetBreed = new JTextField();
		tfPetBreed.setText("");
		tfPetBreed.setColumns(10);
		tfPetBreed.setBounds(523, 458, 137, 21);
		add(tfPetBreed);
		
		JComboBox comboBoxGender = new JComboBox();
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBoxGender.setBounds(157, 519, 137, 23);
		add(comboBoxGender);
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String appId = tfAppId.getText();
				Date date = dateChooser.getDate();
				String firstName = tfFirstName.getText();
				String lastName = tfLastName.getText();
				String pName = tfPetName.getName();
				String pAge = tfAge.getText();
				String pGender = comboBoxGender.getSelectedItem()+"";
				String pType = tfPetType.getText();
				String pBreed = tfPetBreed.getText();
				
			}
		});
		btnAdd.setBounds(661, 61, 93, 23);
		add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(661, 120, 93, 23);
		add(btnDelete);
		
		JButton btnView = new JButton("View");
		btnView.setBounds(661, 179, 93, 23);
		add(btnView);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(661, 240, 93, 23);
		add(btnUpdate);

	}
}
