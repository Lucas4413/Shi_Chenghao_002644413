package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Business;

import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private Business business;

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

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		this.business = new Business();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1089, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.25);
		splitPane.setBounds(0, 0, 1073, 690);
		contentPane.add(splitPane);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(null);
		
		JButton btnInsurancePlans = new JButton("Manage Insurance Plans");
		btnInsurancePlans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsurancePanel insurancePanel = new InsurancePanel(business);
				splitPane.setRightComponent(insurancePanel);
			}
		});
		btnInsurancePlans.setBounds(10, 54, 226, 23);
		panel.add(btnInsurancePlans);
		
		JButton btnManageApplication = new JButton("Manage Applications");
		btnManageApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				splitPane.setRightComponent(new ApplicantCreatePanel(business));
			}
		});
		btnManageApplication.setBounds(10, 125, 226, 23);
		panel.add(btnManageApplication);
		
		JButton btnManageVaccines = new JButton("Manage Vaccines");
		btnManageVaccines.setBounds(10, 203, 226, 23);
		panel.add(btnManageVaccines);
		
		JButton btnAssignInsurance = new JButton("Assign Insurance");
		btnAssignInsurance.setBounds(10, 279, 226, 23);
		panel.add(btnAssignInsurance);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
	}
}
