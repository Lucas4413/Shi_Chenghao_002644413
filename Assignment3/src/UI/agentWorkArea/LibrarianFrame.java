package UI.agentWorkArea;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.Account;
import Business.Application;
import Business.Branch;
import Services.RequestDirectory;
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
	private RequestDirectory masterOrderDirectory;

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
	public LibrarianFrame(Application business, Branch branch, Account account) {
		this.business = business;
		this.account = account;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 942, 809);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_2 = new JPanel();
		contentPane_2.setLayout(null);
		contentPane_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_2.setBounds(0, 0, 926, 770);
		contentPane.add(contentPane_2);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.2);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setBounds(0, 0, 926, 770);
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
		btnLogout_1.setBounds(26, 26, 93, 23);
		panel_2.add(btnLogout_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(149, 30, 180, 15);
		panel_2.add(lblNewLabel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		splitPane_1.setRightComponent(panel_1_1);
		
		lblNewLabel.setText(this.account.getUsername());
		
		JButton btnAuthorAndGenre = new JButton("Author and Genre");
		btnAuthorAndGenre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				splitPane_1.setRightComponent(new AuthorAndGenreManagementJPanel(LibrarianFrame.this.business, branch));
			}
		});
		btnAuthorAndGenre.setBounds(209, 105, 151, 23);
		panel_2.add(btnAuthorAndGenre);
		
		JButton btnBookManagement = new JButton("Book Management");
		btnBookManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				splitPane_1.setRightComponent(new BookManagementJpanel(LibrarianFrame.this.business, branch));
			}
		});
		btnBookManagement.setBounds(370, 105, 172, 23);
		panel_2.add(btnBookManagement);
		
		JButton btnRequestManagement = new JButton("Request Management");
		btnRequestManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				splitPane_1.setRightComponent(new RequestManagementJPanel(LibrarianFrame.this.business, branch));
			}
		});
		btnRequestManagement.setBounds(734, 105, 162, 23);
		panel_2.add(btnRequestManagement);
		
		JButton btnMagzineManagement = new JButton("Magzine Management");
		btnMagzineManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				splitPane_1.setRightComponent(new MagzineManagementJpanel(LibrarianFrame.this.business, branch));
			}
		});
		btnMagzineManagement.setBounds(552, 105, 172, 23);
		panel_2.add(btnMagzineManagement);
		
		setVisible(true);
	}
}
