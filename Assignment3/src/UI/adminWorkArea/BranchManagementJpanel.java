package UI.adminWorkArea;

import javax.swing.JPanel;

import Business.Application;
import Business.Branch;
import Customer.Customer;
import Library.Author;
import Library.AuthorDirectory;
import Library.Book;
import Library.BookDirectory;
import Library.Genre;
import Library.GenreDirectory;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class BranchManagementJpanel extends JPanel {
	private Application business;
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField tfName;
//	private LibrarianDirectory agentDirectory;
	/**
	 * Create the panel.
	 */
	public BranchManagementJpanel(Application business) {
		this.business = business;
		
//		this.agentDirectory = this.business.getAgentDirectory();
		
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 27, 553, 233);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Branch Name", "Library Building NO."
			}
		));
		scrollPane.setViewportView(table);
		tableModel = (DefaultTableModel) table.getModel();
		
		JLabel lblNewLabel = new JLabel("Branch Name");
		lblNewLabel.setBounds(231, 312, 85, 15);
		add(lblNewLabel);
		
		tfName = new JTextField();
		tfName.setBounds(331, 309, 167, 21);
		add(tfName);
		tfName.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameString = tfName.getText();
				
				if(BranchManagementJpanel.this.business.findBranch(nameString) == null) {
					BranchManagementJpanel.this.business.addBranch(nameString);
					populate();
				}else {
					JOptionPane.showMessageDialog(null, "please enter an unique name");
				}
				
			}
		});
		btnAdd.setBounds(231, 423, 93, 23);
		add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nameString = table.getValueAt( table.getSelectedRow(), 0)+"";
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Haven't selected any row");
					return;
				}
				String nameString = table.getValueAt( table.getSelectedRow(), 0)+"";
				BranchManagementJpanel.this.business.deleteBranch(nameString);
				populate();
			}
		});
		btnDelete.setBounds(400, 423, 93, 23);
		add(btnDelete);
		
		
		populate();
	} 
	public void populate() {
		this.tableModel.setRowCount(0);
		for (Branch b:this.business.getBranchs()) {
			Object row[] = new Object[2];
			row[0] = b.getName();
			row[1] = b.getLibrary().getBuildingNO();
			
			this.tableModel.addRow(row);
		}
	}
	
}
