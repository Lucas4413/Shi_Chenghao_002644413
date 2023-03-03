package UI.adminWorkArea;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.Account;
import Business.Application;
import UI.MainFrame;

import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminFrame extends JFrame {

	private JPanel contentPane;
	private Application business;
	private Account account;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ManagerFrame frame = new ManagerFrame();
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
	public AdminFrame(Application business, Account account) {
		this.business = business;
		this.account = account;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setResizeWeight(0.2);
		splitPane.setBounds(0, 0, 887, 620);
		contentPane.add(splitPane);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(null);
		
		JButton btnLogout = new JButton("Log out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MainFrame(AdminFrame.this.business).setVisible(true);
			}
		});
		btnLogout.setBounds(10, 42, 93, 23);
		panel.add(btnLogout);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				splitPane.setRightComponent(new CustomerManagementJPanel(business));
			}
		});
		btnCustomer.setBounds(462, 42, 93, 23);
		panel.add(btnCustomer);
		
		JButton btnOrder = new JButton("Gnere and Author");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				splitPane.setRightComponent(new GenreAndAuthorManagementJpanel(business));
			}
		});
		btnOrder.setBounds(565, 42, 162, 23);
		panel.add(btnOrder);
		
		JButton btnAgent = new JButton("Book");
		btnAgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				splitPane.setRightComponent(new BookManagementJpanel(business));
			}
		});
		btnAgent.setBounds(737, 42, 93, 23);
		panel.add(btnAgent);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(null);
		
		setVisible(true);
	}
}
