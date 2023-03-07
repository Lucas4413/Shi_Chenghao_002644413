package UI.managerWorkArea;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Business.Application;
import Business.Branch;
import Customer.Customer;
import Customer.CustomerDirectory;
import Role.CustomerRole;
import Services.Request;
import Services.RequestDirectory;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RequestsJPanel extends JPanel {
	private JTable table;
	private Application business;
	private DefaultTableModel tableModel;
	private RequestDirectory requestDirectory;

	/**
	 * Create the panel.
	 */
	public RequestsJPanel(Application business, Branch branch) {
		this.business = business;
		this.requestDirectory = branch.getLibrary().getMasterOrderDirectory();
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 65, 766, 262);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Book Serial NO.", "Magzine Serial NO.", "Duration", "Price", "Status"
			}
		));
		
		JLabel lblNewLabel = new JLabel("Total Revenue:");
		lblNewLabel.setBounds(62, 389, 96, 15);
		add(lblNewLabel);
		
		JLabel lbIncome = new JLabel("");
		lbIncome.setBounds(168, 389, 175, 15);
		add(lbIncome);
		
		tableModel =(DefaultTableModel) table.getModel();

		populate();
		lbIncome.setText(branch.getLibrary().getEmployeeDirectory().getBranchManagerEmployee().getIncome()+"");
	}
	
	public void populate() {
		this.tableModel.setRowCount(0);
		for (Request r:this.requestDirectory.getOrders()) {
			Object row[] = new Object[6];
			row[0] = r.getID();
			row[1] = r.getBook().getSerialNumber();
			row[2] = r.getMagzine().getSerialNumber();
			row[3] = r.getDuration();
			row[4] = r.getPrice();
			row[5] = r.getStatus();
			this.tableModel.addRow(row);
		}
	}
}
