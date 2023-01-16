package UI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JLabel lbWelcome;
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
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbName = new JLabel("Name");
		lbName.setBounds(10, 10, 404, 15);
		contentPane.add(lbName);
		
		tfName = new JTextField();
		tfName.setBounds(10, 40, 404, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel lbWelcome = new JLabel("");
		lbWelcome.setBounds(10, 134, 384, 15);
		contentPane.add(lbWelcome);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = tfName.getText();
				lbWelcome.setText("Hello " + text);
			}
		});
		btnOK.setBounds(10, 209, 404, 23);
		contentPane.add(btnOK);
	}
}
