package UI.customerWorkArea;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.Account;
import Business.Application;
import Customer.CustomerDirectory;
import Library.Book;
import Library.BookDirectory;
import Services.RequestDirectory;
import UI.MainFrame;
import UI.adminWorkArea.AdminFrame;

import javax.swing.JSplitPane;
import javax.sound.midi.Soundbank;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class CustomerFrame extends JFrame {

	private JPanel contentPane;
	private Application business;
	private Account account;
	private JTable table;
	private BookDirectory bookDirectory;
	private DefaultTableModel tableModel;
	private RequestDirectory masterRequestDirectory;
	private CustomerDirectory customerDirectory;
	private JTextField tfstart;
	private JTextField tfend;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CustomerFrame frame = new CustomerFrame();
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
	public CustomerFrame(Application business,Account account) {
		this.business = business;
		this.account = account;
		this.customerDirectory = this.business.getCustomerDirectory();
		
		System.out.println(this.bookDirectory.getBooks().size());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 608);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setResizeWeight(0.2);
		splitPane.setBounds(0, 0, 647, 569);
		contentPane.add(splitPane);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(null);
		
		JButton btnLogout = new JButton("Log out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MainFrame(CustomerFrame.this.business).setVisible(true);
			}
		});
		btnLogout.setBounds(55, 51, 93, 23);
		panel.add(btnLogout);
		
		JLabel lbacc = new JLabel("");
		lbacc.setBounds(194, 55, 54, 15);
		panel.add(lbacc);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(38, 270, 335, 15);
		panel_1.add(lblNewLabel);
		
		JButton btnPlaceOrder = new JButton("Request");
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = table.getValueAt(table.getSelectedRow(), 0)+"";
				
				lblNewLabel.setText("request submitted");
				String startString = tfstart.getText();
				String endString = tfend.getText();
				
				populate();
			}
		});
		btnPlaceOrder.setBounds(257, 394, 129, 23);
		panel_1.add(btnPlaceOrder);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 26, 572, 234);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Book ID", "Book Name", "Author ID", "Author Name", "Genre", "Price", "Status"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Start Date");
		lblNewLabel_1.setBounds(82, 338, 87, 15);
		panel_1.add(lblNewLabel_1);
		
		tfstart = new JTextField();
		tfstart.setBounds(183, 336, 105, 21);
		panel_1.add(tfstart);
		tfstart.setColumns(10);
		
		tfend = new JTextField();
		tfend.setColumns(10);
		tfend.setBounds(470, 335, 105, 21);
		panel_1.add(tfend);
		
		JLabel lblNewLabel_1_1 = new JLabel("End Date");
		lblNewLabel_1_1.setBounds(369, 337, 87, 15);
		panel_1.add(lblNewLabel_1_1);
		tableModel = (DefaultTableModel) table.getModel();
		
		lbacc.setText(this.account.getUsername());
		
		setVisible(true);
		populate();
	}
	
	public void populate() {
		tableModel.setRowCount(0);
		for (Book b:this.bookDirectory.getBooks()) {
			Object row[] = new Object[7];
			
			
			tableModel.addRow(row);
		}
	}
}
