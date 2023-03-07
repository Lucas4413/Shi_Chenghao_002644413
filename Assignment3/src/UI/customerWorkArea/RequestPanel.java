package UI.customerWorkArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
import Services.Request;

public class RequestPanel extends JPanel {

	private JPanel contentPane;
	private Application business;
	private Account account;
	private JTable tableBook;
	private BookDirectory bookDirectory;
	private General general;
	private DefaultTableModel tableModelBook;
	private DefaultTableModel tableModelMagzine;
	private RequestDirectory masterRequestDirectory;
	private CustomerDirectory customerDirectory;
	private JTextField tfBook;
	private JTextField tfMagzine;
	private JTable tableMagzine;
	private Branch currentBranch;
	private ArrayList<Branch> branchs;
	private JComboBox<String> comboBox;
	private JTextField tfDuration;
	/**
	 * Create the panel.
	 */
	public RequestPanel(Application business, Branch branch, Account account) {
		this.business = business;
		this.account = account;
		this.customerDirectory = this.business.getCustomerDirectory();
		this.branchs = this.business.getBranchs();
		
		setLayout(null);
		setBounds(100, 100, 912, 777);
		contentPane = new JPanel();

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(138, 320, 335, 15);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 76, 817, 216);
		add(scrollPane);
		
		tableBook = new JTable();
		tableBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String selectedBookID = tableBook.getValueAt(tableBook.getSelectedRow(), 0)+"";
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Haven't selected any row");
					return;
				}
				String selectedBookID = tableBook.getValueAt(tableBook.getSelectedRow(), 0)+"";
				tfBook.setText(selectedBookID);
			}
		});
		tableBook.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Serial Number", "Name", "Author Name", "Genre", "Register Date", "Pages", "Binding Type", "Language", "Price"
			}
		));
		scrollPane.setViewportView(tableBook);
		
		JLabel lblNewLabel_1 = new JLabel("selected Book");
		lblNewLabel_1.setBounds(80, 576, 87, 15);
		add(lblNewLabel_1);
		
		tfBook = new JTextField();
		tfBook.setBounds(181, 574, 105, 21);
		add(tfBook);
		tfBook.setColumns(10);
		
		tfMagzine = new JTextField();
		tfMagzine.setColumns(10);
		tfMagzine.setBounds(451, 573, 105, 21);
		add(tfMagzine);
		
		JLabel lblNewLabel_1_1 = new JLabel("selected Magzine");
		lblNewLabel_1_1.setBounds(331, 576, 114, 15);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Branch:");
		lblNewLabel_2.setBounds(38, 34, 60, 15);
		add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(38, 320, 817, 216);
		add(scrollPane_1);
		
		tableMagzine = new JTable();
		tableMagzine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String selectedMagzineID = tableMagzine.getValueAt(tableMagzine.getSelectedRow(), 0)+"";
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Haven't selected any row");
					return;
				}
				String selectedMagzineID = tableMagzine.getValueAt(tableMagzine.getSelectedRow(), 0)+"";
				tfMagzine.setText(selectedMagzineID);
			}
		});
		tableMagzine.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Serial Number", "Name", "Company Name", "Register Date", "Issue Type", "Price"
			}
		));
		scrollPane_1.setViewportView(tableMagzine);
		
		this.tableModelBook = (DefaultTableModel) tableBook.getModel();
		this.tableModelMagzine = (DefaultTableModel) tableMagzine.getModel();
		
		this.comboBox = new JComboBox<>();
		this.comboBox.setBounds(108, 30, 114, 23);
		add(this.comboBox);
		
		populateBranch();
		this.currentBranch = this.business.findBranch(comboBox.getSelectedItem()+"");
		this.bookDirectory = this.currentBranch.getLibrary().getBookDirectory();
		this.general = this.currentBranch.getLibrary().getGeneral();
		this.comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentBranch = RequestPanel.this.business.findBranch(comboBox.getSelectedItem()+"");
				bookDirectory = currentBranch.getLibrary().getBookDirectory();
				general = currentBranch.getLibrary().getGeneral();
				populateBook();
				populateMagzine();
			}
		});
		
		JButton btnRequest = new JButton("Place Request");
		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book book = bookDirectory.searchById(tfBook.getText());
				Magzine magzine = general.searchById(tfMagzine.getText());
				String duration = tfDuration.getText();
				Float price = (float) 0;
				if(book != null) {
					price += book.getPrice();
					book.setIsAvailable(false);
				}
				if(magzine != null) {
					price += magzine.getPrice();
					magzine.setIsAvailable(false);
				}
				
				Request request = currentBranch.getLibrary().getMasterOrderDirectory().createOrder(duration, price, book, magzine, account);
				
				populateBook();
				populateMagzine();
				tfBook.setText("");
				tfMagzine.setText("");
			}
		});
		btnRequest.setBounds(360, 617, 131, 23);
		add(btnRequest);
		
		tfDuration = new JTextField();
		tfDuration.setColumns(10);
		tfDuration.setBounds(693, 569, 105, 21);
		add(tfDuration);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Duration");
		lblNewLabel_1_1_1.setBounds(607, 572, 114, 15);
		add(lblNewLabel_1_1_1);
		
		setVisible(true);
		populateBook();
		populateMagzine();
	}

	public void populateBook() {
		this.tableModelBook.setRowCount(0);
		for (Book b:this.bookDirectory.getBooks()) {
			if(b.getIsAvailable()) {
				Object row[] = new Object[9];
				row[0] = b.getSerialNumber();
				row[1] = b.getName();
				row[2] = b.getAuthor().getName();
				row[3] = b.getGenre().getGenre();
				row[4] = b.dateToString(b.getRegisteredDate());
				row[5] = b.getPageNumber();
				row[6] = b.getTypeOfBinding();
				row[7] = b.getLanguage();
				row[8] = b.getPrice();
				
				this.tableModelBook.addRow(row);
			}
		}
	}
	
	public void populateMagzine() {
		this.tableModelMagzine.setRowCount(0);
		for (Magzine m:this.general.getMagzines()) {
			if(m.getIsAvailable()) {
				Object row[] = new Object[6];
				row[0] = m.getSerialNumber();
				row[1] = m.getName();
				row[2] = m.getCompany();
				row[3] = m.dateToString(m.getRegisteredDate());
				row[4] = m.getIssueType();
				row[5] = m.getPrice();
				
				this.tableModelMagzine.addRow(row);
			}
		}
	}
	
	public void populateBranch() {
		for(Branch b:this.branchs) {
			comboBox.addItem(b.getName());
		}
	}
}
