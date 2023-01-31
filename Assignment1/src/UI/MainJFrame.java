package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Recipe;

import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MainJFrame extends JFrame {

	private JPanel contentPane;
	private ArrayList<Recipe> recipes = new ArrayList<Recipe>();
	private ArrayList<String> usernames = new ArrayList<String>();
	
	// functions for validation checking
	public Boolean isBoolean(String s) {
		if(s.equals("yes")||s.equals("no")) {
			return true;
		}
		return false;
	}
	
	public Boolean isEmptyOrNull(String tf) {
		if(tf == null || tf.length() == 0) {
			return true;
		}
		return false;
	}
	
	public Boolean checkSpecialSymbol(String name) {
		String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(name);
        return m.find();
	}
	
	public Boolean isInteger(String s) {
		try {
			Integer.valueOf(s);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public Boolean isFloat(String s) {
		try {
			Float.parseFloat(s);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public Boolean hasDigit(String s) {
		Pattern p = Pattern.compile("[0-9]{1,}");  
	    Matcher m = p.matcher(s);  
	    return m.find(); 
	}
	
	
	public Boolean isDigit(String s) {
		Pattern p = Pattern.compile("[0-9]{1,}");  
	    Matcher m = p.matcher(s);  
	    return m.matches(); 
	}
	
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
		setBounds(100, 100, 1287, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.2);
		splitPane.setBounds(0, 0, 1276, 614);
		contentPane.add(splitPane);
		
		JPanel Control = new JPanel();
		splitPane.setLeftComponent(Control);
		Control.setLayout(null);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreatePage createPage = new CreatePage(recipes, usernames);
				splitPane.setRightComponent(createPage);
			}
		});
		btnCreate.setBounds(47, 48, 93, 23);
		Control.add(btnCreate);
		
		JButton btnRead = new JButton("Read");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadPage readPage = new ReadPage(recipes, usernames);
				splitPane.setRightComponent(readPage);
			}
		});
		btnRead.setBounds(47, 106, 93, 23);
		Control.add(btnRead);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdatePage updatePage = new UpdatePage(recipes, usernames);
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
