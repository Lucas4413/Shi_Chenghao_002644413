package UI.agentWorkArea;

import javax.swing.JPanel;

import Business.Application;
import Business.Branch;
import Customer.Customer;
import Library.Author;
import Library.AuthorDirectory;
import Library.Book;
import Library.BookDirectory;
import Library.General;
import Library.Genre;
import Library.GenreDirectory;
import Library.Magzine;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class MagzineManagementJpanel extends JPanel {
	private Application business;
	private Branch branch;
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField tfName;
	private JTextField tfPrice;
	private General general;
	private JLabel lblPage;
	private JTextField tfCompanyName;
	private JTextField tfIssueType;

	/**
	 * Create the panel.
	 */
	public MagzineManagementJpanel(Application business, Branch branch) {
		this.business = business;
		this.branch = branch;
		this.general = branch.getLibrary().getGeneral();

		
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 897, 233);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Serial Number", "Name", "Company Name", "Register Date", "Issue Type", "Price"
			}
		));
		scrollPane.setViewportView(table);
		tableModel = (DefaultTableModel) table.getModel();
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(100, 309, 85, 15);
		add(lblNewLabel);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(100, 436, 85, 15);
		add(lblPrice);
		
		tfName = new JTextField();
		tfName.setBounds(177, 306, 167, 21);
		add(tfName);
		tfName.setColumns(10);
		
		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		tfPrice.setBounds(177, 433, 167, 21);
		add(tfPrice);
		
		lblPage = new JLabel("Company Name");
		lblPage.setBounds(421, 306, 85, 15);
		add(lblPage);
		
		tfCompanyName = new JTextField();
		tfCompanyName.setColumns(10);
		tfCompanyName.setBounds(532, 306, 143, 21);
		add(tfCompanyName);
		
		tfIssueType = new JTextField();
		tfIssueType.setColumns(10);
		tfIssueType.setBounds(177, 367, 167, 21);
		add(tfIssueType);
		
		JLabel lblNewLabel_1 = new JLabel("Issue Type");
		lblNewLabel_1.setBounds(100, 370, 85, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Register Date");
		lblNewLabel_2.setBounds(421, 370, 85, 15);
		add(lblNewLabel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(532, 367, 143, 21);
		add(dateChooser);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameString = tfName.getText();
				Float price = Float.parseFloat(tfPrice.getText());
				String issueType = tfIssueType.getText();
				Date registerDate = dateChooser.getDate();
				String company = tfCompanyName.getText();
				
				if(registerDate == null) {
					return;
				}
			
				general.createMagzine(nameString, price, registerDate, company, issueType);
				
				populate();
			}
		});
		btnAdd.setBounds(488, 432, 93, 23);
		add(btnAdd);
		
		populate();
	} 
	public void populate() {
		this.tableModel.setRowCount(0);
		for (Magzine m:this.general.getMagzines()) {
			Object row[] = new Object[6];
			row[0] = m.getSerialNumber();
			row[1] = m.getName();
			row[2] = m.getCompany();
			row[3] = m.dateToString(m.getRegisteredDate());
			row[4] = m.getIssueType();
			row[5] = m.getPrice();
			
			this.tableModel.addRow(row);
		}
	}
}
