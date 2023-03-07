package UI.agentWorkArea;

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

public class RequestManagementJPanel extends JPanel {
	private JTable table;
	private Application business;
	private DefaultTableModel tableModel;
	private RequestDirectory requestDirectory;

	/**
	 * Create the panel.
	 */
	public RequestManagementJPanel(Application business, Branch branch) {
		this.business = business;
		this.requestDirectory = branch.getLibrary().getMasterOrderDirectory();
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 31, 766, 262);
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
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String selectedRequestID = table.getValueAt(table.getSelectedRow(), 0)+"";
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Haven't selected any row");
					return;
				}
				String selectedRequestID = table.getValueAt(table.getSelectedRow(), 0)+"";
				Request request = branch.getLibrary().getMasterOrderDirectory().findById(selectedRequestID);
				if(request.getStatus().equals("applying")) {
					request.setStatus("rented");
					branch.getLibrary().getEmployeeDirectory().getBranchManagerEmployee().addMoney(request.getPrice());
				}
				populate();
			}
		});
		btnAccept.setBounds(179, 395, 93, 23);
		add(btnAccept);
		
		JButton btnReject = new JButton("Reject");
		btnReject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String selectedRequestID = table.getValueAt(table.getSelectedRow(), 0)+"";
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Haven't selected any row");
					return;
				}
				String selectedRequestID = table.getValueAt(table.getSelectedRow(), 0)+"";
				Request request = branch.getLibrary().getMasterOrderDirectory().findById(selectedRequestID);
				if(request.getStatus().equals("applying")) {
					request.setStatus("rejected");
					if (request.getBook()!=null) {
						request.getBook().setIsAvailable(true);
					}
					if (request.getMagzine()!=null) {
						request.getMagzine().setIsAvailable(true);
					}
				}
				populate();
			}
		});
		btnReject.setBounds(532, 395, 93, 23);
		add(btnReject);
		
		tableModel =(DefaultTableModel) table.getModel();

		populate();
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
