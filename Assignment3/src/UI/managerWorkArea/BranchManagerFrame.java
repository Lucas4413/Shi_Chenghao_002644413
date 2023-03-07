package UI.managerWorkArea;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.Account;
import Business.Application;
import Business.Branch;
import UI.MainFrame;
import UI.customerWorkArea.CustomerFrame;

import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BranchManagerFrame extends JFrame {

	private JPanel contentPane;
	private Application application;
	private Account account;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BranchManagerFrame frame = new BranchManagerFrame();
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
	public BranchManagerFrame(Application application, Branch branch, Account account) {
		this.application = application;
		this.account = account;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 902);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.2);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(0, 0, 892, 863);
		contentPane.add(splitPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		splitPane.setLeftComponent(panel);
		
		JButton btnLogout = new JButton("Log out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MainFrame(BranchManagerFrame.this.application).setVisible(true);
			}
		});
		btnLogout.setBounds(54, 86, 93, 23);
		panel.add(btnLogout);
		
		JLabel lbacc = new JLabel((String) null);
		lbacc.setBounds(193, 90, 54, 15);
		panel.add(lbacc);
		
		JButton btnMaterials = new JButton("Materials");
		btnMaterials.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				splitPane.setRightComponent(new MaterialsJPanel(application, branch));
			}
		});
		btnMaterials.setBounds(481, 86, 93, 23);
		panel.add(btnMaterials);
		
		JButton btnRequests = new JButton("Requests");
		btnRequests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				splitPane.setRightComponent(new RequestsJPanel(application, branch));
			}
		});
		btnRequests.setBounds(624, 86, 93, 23);
		panel.add(btnRequests);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		splitPane.setRightComponent(panel_1);
		setVisible(true);
		lbacc.setText(account.getUsername());
		
		JLabel lbBranch = new JLabel("");
		lbBranch.setBounds(283, 90, 54, 15);
		panel.add(lbBranch);
		lbBranch.setText(branch.getName());
		
	}
}
