package UI.registerWorkArea;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.AccountDirectory;
import Business.Application;
import Customer.CustomerDirectory;
import UI.MainFrame;
import UI.customerWorkArea.CustomerFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JTextField tfPassword;
	private JTextField tfName;
	private JTextField tfAge;
	private Application business;
	private AccountDirectory accountDirectory;
	private CustomerDirectory customerDirectory;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegisterFrame frame = new RegisterFrame();
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
	public RegisterFrame(Application business) {
		this.business = business;
		this.accountDirectory = this.business.getAccountDirectory();
		this.customerDirectory = this.business.getCustomerDirectory();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 891, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Here");
		lblNewLabel.setBounds(377, 42, 126, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(278, 125, 68, 15);
		contentPane.add(lblNewLabel_1);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(392, 122, 193, 21);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(278, 187, 68, 15);
		contentPane.add(lblNewLabel_1_1);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(392, 184, 193, 21);
		contentPane.add(tfPassword);
		
		JLabel lblNewLabel_1_2 = new JLabel("Name");
		lblNewLabel_1_2.setBounds(278, 256, 68, 15);
		contentPane.add(lblNewLabel_1_2);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(392, 253, 193, 21);
		contentPane.add(tfName);
		
		JLabel lblNewLabel_1_3 = new JLabel("Age");
		lblNewLabel_1_3.setBounds(278, 329, 68, 15);
		contentPane.add(lblNewLabel_1_3);
		
		tfAge = new JTextField();
		tfAge.setColumns(10);
		tfAge.setBounds(392, 326, 193, 21);
		contentPane.add(tfAge);
		
		JLabel lbRes = new JLabel("");
		lbRes.setBounds(278, 75, 307, 15);
		contentPane.add(lbRes);
		setVisible(true);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = tfUsername.getText();
				String password = tfPassword.getText();
				String name = tfName.getText();
				String age = tfAge.getText();
				accountDirectory.createAccount(username, "customer", password);
				customerDirectory.createCustomer(username, name, age);
				lbRes.setText("Success");
			}
		});
		btnRegister.setBounds(278, 427, 118, 23);
		contentPane.add(btnRegister);
		
		JButton btnBack = new JButton("Back to Login");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MainFrame(RegisterFrame.this.business).setVisible(true);
			}
		});
		btnBack.setBounds(474, 427, 111, 23);
		contentPane.add(btnBack);
	}
}
