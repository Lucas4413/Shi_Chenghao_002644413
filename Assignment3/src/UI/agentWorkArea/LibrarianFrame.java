package UI.agentWorkArea;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.Account;
import Business.Application;
import Services.MasterRequestDirectory;
import Services.Request;
import UI.MainFrame;
import UI.adminWorkArea.AdminFrame;

import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class LibrarianFrame extends JFrame {

	private JPanel contentPane;
	private Application business;
	private Account account;
	private DefaultTableModel tableModel;
	private MasterRequestDirectory masterOrderDirectory;
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AgentFrame frame = new AgentFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public LibrarianFrame(Application business, Account account) {
		this.business = business;
		this.account = account;
		this.masterOrderDirectory = business.getMasterOrderDirectory();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 608);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBounds(323, 10, 1, 1);
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(contentPane_1);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.2);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(0, 0, 647, 569);
		contentPane_1.add(splitPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		splitPane.setLeftComponent(panel);
		
		JButton btnLogout = new JButton("Log out");
		btnLogout.setBounds(55, 51, 93, 23);
		panel.add(btnLogout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		splitPane.setRightComponent(panel_1);
		
		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.setBounds(255, 416, 129, 23);
		panel_1.add(btnPlaceOrder);
		
		JPanel contentPane_2 = new JPanel();
		contentPane_2.setLayout(null);
		contentPane_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_2.setBounds(0, 0, 647, 569);
		contentPane.add(contentPane_2);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.2);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setBounds(0, 0, 647, 569);
		contentPane_2.add(splitPane_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		splitPane_1.setLeftComponent(panel_2);
		
		JButton btnLogout_1 = new JButton("Log out");
		btnLogout_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MainFrame(LibrarianFrame.this.business).setVisible(true);
			}
		});
		btnLogout_1.setBounds(55, 51, 93, 23);
		panel_2.add(btnLogout_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(178, 55, 294, 15);
		panel_2.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		splitPane_1.setRightComponent(panel_1_1);
		
		JButton btnApprove = new JButton("Approve");
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String selectedId = table.getValueAt(table.getSelectedRow(), 0)+"";
				} catch (Exception e2) {
					// TODO: handle exception
					return;
				}
				String selectedId = table.getValueAt(table.getSelectedRow(), 0)+"";
				masterOrderDirectory.findById(selectedId).setStatus("approved");
				masterOrderDirectory.findById(selectedId).getBook().setStatus("rented");
				populate();
			}
		});
		btnApprove.setBounds(182, 390, 93, 23);
		panel_1_1.add(btnApprove);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 625, 273);
		panel_1_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Request ID", "Book ID", "Customer ID", "Start Date", "End Date", "Status"
			}
		));
		scrollPane.setViewportView(table);
		tableModel = (DefaultTableModel) table.getModel();
		
		JButton btnReject = new JButton("Reject");
		btnReject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String selectedId = table.getValueAt(table.getSelectedRow(), 0)+"";
				} catch (Exception e2) {
					// TODO: handle exception
					return;
				}
				String selectedId = table.getValueAt(table.getSelectedRow(), 0)+"";
				masterOrderDirectory.findById(selectedId).setStatus("rejected");
				masterOrderDirectory.findById(selectedId).getBook().setStatus("ready");
				populate();
			}
		});
		btnReject.setBounds(363, 390, 93, 23);
		panel_1_1.add(btnReject);
		
		lblNewLabel.setText(this.account.getUsername());
		
		setVisible(true);
		populate();
	}
	
	public void populate() {
		this.tableModel.setRowCount(0);
		for (Request r:masterOrderDirectory.getOrders()) {
			Object row[] = new Object[6];
			row[0] = r.getRequestId();
			row[1] = r.getBook().getID();
			row[2] = r.getCustomer().getPersonID();
			row[3] = r.getStartDate();
			row[4] = r.getEndDate();
			row[5] = r.getStatus();
			
			tableModel.addRow(row);
		}
	}
}
