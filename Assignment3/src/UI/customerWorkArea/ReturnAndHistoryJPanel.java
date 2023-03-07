package UI.customerWorkArea;

import javax.swing.JPanel;

import Business.Account;
import Business.Application;
import Business.Branch;
import Services.Request;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnAndHistoryJPanel extends JPanel {
	private JTable table;
	private JComboBox<String> comboBox;
	private ArrayList<Branch> branchs;
	private Branch currentBranch;
	private Application business;
	private Account account;
	private DefaultTableModel tableModel;
	
	/**
	 * Create the panel.
	 */
	public ReturnAndHistoryJPanel(Application business, Branch branch, Account account) {
		this.business = business;
		this.account = account;
		this.branchs = this.business.getBranchs();
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 739, 191);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Book Serial NO.", "Magzine Serial NO.", "Duration", "Price", "Status", "Username"
			}
		));
		scrollPane.setViewportView(table);
		this.tableModel = (DefaultTableModel) table.getModel();
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String selectedRequestID = table.getValueAt(table.getSelectedRow(), 0)+"";
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Haven't selected any row");
					return;
				}
				String selectedRequestID = table.getValueAt(table.getSelectedRow(), 0)+"";
				Request request = currentBranch.getLibrary().getMasterOrderDirectory().findById(selectedRequestID);
				if(request.getStatus().equals("rented")) {
					request.setStatus("returned");
					if (request.getBook()!=null) {
						request.getBook().setIsAvailable(true);
					}
					if (request.getMagzine()!=null) {
						request.getMagzine().setIsAvailable(true);
					}
					
				}else if (request.getStatus().equals("applying")) {
					JOptionPane.showMessageDialog(null, "This request has not been approved");
				}
				populateRequest();
			}
		});
		btnReturn.setBounds(303, 361, 93, 23);
		add(btnReturn);
		
		JLabel lblNewLabel = new JLabel("Branch:");
		lblNewLabel.setBounds(10, 46, 54, 15);
		add(lblNewLabel);
		
		this.comboBox = new JComboBox<>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentBranch = ReturnAndHistoryJPanel.this.business.findBranch(comboBox.getSelectedItem()+"");
				populateRequest();
			}
		});
		this.comboBox.setBounds(74, 42, 109, 23);
		add(this.comboBox);
		populateBranch();
		this.currentBranch = this.business.findBranch(comboBox.getSelectedItem()+"");
		

	}
	
	public void populateRequest() {
		this.tableModel.setRowCount(0);
		for(Request r:this.currentBranch.getLibrary().getMasterOrderDirectory().getOrders()) {
			if(r.getAccount() == this.account) {
				Object row[] = new Object[7];
				row[0] = r.getID();
				if(r.getBook()!=null) {
					row[1] = r.getBook().getSerialNumber();
				}else {
					row[1] = "";
				}
				if(r.getMagzine()!=null) {
					row[2] = r.getMagzine().getSerialNumber();
				}else {
					row[2] = "";
				}
				row[3] = r.getDuration();
				row[4] = r.getPrice();
				row[5] = r.getStatus();
				row[6] = r.getAccount().getUsername();
				
				this.tableModel.addRow(row);
			}
		}
	}
	
	public void populateBranch() {
		for(Branch b:this.branchs) {
			comboBox.addItem(b.getName());
		}
	}
}
