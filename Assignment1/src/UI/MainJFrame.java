package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJFrame frame = new MainJFrame();
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
	public MainJFrame() {
		setTitle(" Recipes Processing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1017, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.2);
		splitPane.setBounds(0, 0, 1001, 614);
		contentPane.add(splitPane);
		
		JPanel Control = new JPanel();
		splitPane.setLeftComponent(Control);
		Control.setLayout(null);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreatePage createPage = new CreatePage();
				splitPane.setRightComponent(createPage);
			}
		});
		btnCreate.setBounds(47, 48, 93, 23);
		Control.add(btnCreate);
		
		JButton btnRead = new JButton("Read");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadPage readPage = new ReadPage();
				splitPane.setRightComponent(readPage);
			}
		});
		btnRead.setBounds(47, 106, 93, 23);
		Control.add(btnRead);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdatePage updatePage = new UpdatePage();
				splitPane.setRightComponent(updatePage);
			}
		});
		btnUpdate.setBounds(47, 170, 93, 23);
		Control.add(btnUpdate);
		
		JPanel Display = new JPanel();
		splitPane.setRightComponent(Display);
		Display.setLayout(null);
	}
}
