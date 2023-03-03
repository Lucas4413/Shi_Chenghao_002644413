package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.Account;
import Business.AccountDirectory;
import Business.Application;

import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.io.Closeable;
import java.security.PublicKey;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
	private Application business;
	private JPanel contentPane;
	private JTextField tfUsername;
	private JTextField tfPassword;
	private AccountDirectory accountDirectory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainFrame(Application business) {
		this.business = business;
		this.accountDirectory = this.business.getAccountDirectory();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 946, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(403, 104, 242, 21);
		contentPane.add(tfUsername);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(403, 156, 242, 21);
		contentPane.add(tfPassword);
		
		JLabel lbUserName = new JLabel("Username");
		lbUserName.setBounds(285, 107, 76, 15);
		contentPane.add(lbUserName);
		
		JLabel lbPassword = new JLabel("Password");
		lbPassword.setBounds(285, 159, 76, 15);
		contentPane.add(lbPassword);
		
		Choice choice = new Choice();
		choice.setBounds(403, 228, 153, 21);
		contentPane.add(choice);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(403, 51, 84, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = tfUsername.getText();
				String password = tfPassword.getText();
				String role = choice.getSelectedItem();
				System.out.println(accountDirectory.getAccountDirectory().size());
				if (accountDirectory.accountExists(username, role, password)) {
					setVisible(false);
					Account account = accountDirectory.getAccount(username, role, password);
					account.getWorkArea(role, business, account);
				}
			}
		});
		
		btnLogin.setBounds(336, 299, 93, 23);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				business.goToRegister(business);
			}
		});
		btnRegister.setBounds(535, 299, 93, 23);
		contentPane.add(btnRegister);
		choice.add("manager");
		choice.add("customer");
		choice.add("librarian");
	
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		this.business = new Application();
		this.accountDirectory = this.business.getAccountDirectory();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 946, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(403, 104, 242, 21);
		contentPane.add(tfUsername);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(403, 156, 242, 21);
		contentPane.add(tfPassword);
		
		JLabel lbUserName = new JLabel("Username");
		lbUserName.setBounds(285, 107, 76, 15);
		contentPane.add(lbUserName);
		
		JLabel lbPassword = new JLabel("Password");
		lbPassword.setBounds(285, 159, 76, 15);
		contentPane.add(lbPassword);
		
		Choice choice = new Choice();
		choice.setBounds(403, 228, 153, 21);
		contentPane.add(choice);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(403, 51, 84, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = tfUsername.getText();
				String password = tfPassword.getText();
				String role = choice.getSelectedItem();
				System.out.println(accountDirectory.getAccountDirectory().size());
				if (accountDirectory.accountExists(username, role, password)) {
					setVisible(false);
					Account account = accountDirectory.getAccount(username, role, password);
					account.getWorkArea(role, business, account);
				}
			}
		});
		
		btnLogin.setBounds(336, 299, 93, 23);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				business.goToRegister(business);
			}
		});
		btnRegister.setBounds(535, 299, 93, 23);
		contentPane.add(btnRegister);
		choice.add("admin");
		choice.add("manager");
		choice.add("customer");
		choice.add("librarian");
	
	}
}
