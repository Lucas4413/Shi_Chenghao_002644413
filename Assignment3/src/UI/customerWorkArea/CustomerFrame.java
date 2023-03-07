package UI.customerWorkArea;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.Account;
import Business.Application;
import Business.Branch;
import Customer.CustomerDirectory;
import Library.Book;
import Library.BookDirectory;
import Library.General;
import Library.Magzine;
import Services.RequestDirectory;
import UI.MainFrame;
import UI.adminWorkArea.AdminFrame;

import javax.swing.JSplitPane;
import javax.sound.midi.Soundbank;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomerFrame extends JFrame {

	private JPanel contentPane;
	private Application business;
	private Account account;
	private BookDirectory bookDirectory;
	private General general;
	private DefaultTableModel tableModelBook;
	private DefaultTableModel tableModelMagzine;
	private RequestDirectory masterRequestDirectory;
	private CustomerDirectory customerDirectory;
	private Branch currentBranch;
	private ArrayList<Branch> branchs;
	
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
	public CustomerFrame(Application business, Branch branch ,Account account) {
		this.business = business;
		this.account = account;
		this.customerDirectory = this.business.getCustomerDirectory();
		this.branchs = this.business.getBranchs();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 876);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setResizeWeight(0.2);
		splitPane.setBounds(0, 0, 896, 837);
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
		btnLogout.setBounds(54, 86, 93, 23);
		panel.add(btnLogout);
		
		JLabel lbacc = new JLabel("");
		lbacc.setBounds(193, 90, 54, 15);
		panel.add(lbacc);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(null);
		
		lbacc.setText(this.account.getUsername());
		
		JButton btnRequestPage = new JButton("Request");
		btnRequestPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				splitPane.setRightComponent(new RequestPanel(CustomerFrame.this.business, branch, CustomerFrame.this.account));
			}
		});
		btnRequestPage.setBounds(506, 86, 93, 23);
		panel.add(btnRequestPage);
		
		JButton btnReturnAndHistory = new JButton("Return and History");
		btnReturnAndHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				splitPane.setRightComponent(new ReturnAndHistoryJPanel(business, branch, CustomerFrame.this.account));
			}
		});
		btnReturnAndHistory.setBounds(631, 86, 147, 23);
		panel.add(btnReturnAndHistory);
		
		setVisible(true);
	}
	
}
