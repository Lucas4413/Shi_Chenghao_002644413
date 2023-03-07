package UI.agentWorkArea;

import javax.swing.JPanel;

import Business.Application;
import Business.Branch;
import Customer.Customer;
import Library.Author;
import Library.AuthorDirectory;
import Library.Book;
import Library.BookDirectory;
import Library.Genre;
import Library.GenreDirectory;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class BookManagementJpanel extends JPanel {
	private Application business;
	private Branch branch;
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField tfName;
	private JTextField tfPrice;
	private BookDirectory bookDirectory;
	private JComboBox<String> comboBoxGenre;
	private JComboBox<String> comboBoxAuthor;
	private JTextField tfAuthorName;
	private AuthorDirectory authorDirectory;
	private GenreDirectory genreDirectory;
	private JLabel lblPage;
	private JTextField tfPage;
	private JLabel lblLanguage;
	private JTextField tfLanguage;
	private JTextField tfBinding;
//	private LibrarianDirectory agentDirectory;
	/**
	 * Create the panel.
	 */
	public BookManagementJpanel(Application business, Branch branch) {
		this.business = business;
		this.branch = branch;
		this.bookDirectory = this.branch.getLibrary().getBookDirectory();
		this.genreDirectory = this.branch.getLibrary().getGenreDirectory();
		this.authorDirectory = this.branch.getLibrary().getAuthorDirectory();
//		this.agentDirectory = this.business.getAgentDirectory();
		
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 897, 233);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Serial Number", "Name", "Author Name", "Genre", "Register Date", "pages", "Binding Type", "Language", "Price"
			}
		));
		scrollPane.setViewportView(table);
		tableModel = (DefaultTableModel) table.getModel();
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(100, 309, 85, 15);
		add(lblNewLabel);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(100, 436, 85, 15);
		add(lblPrice);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(421, 508, 85, 15);
		add(lblAuthor);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(421, 436, 85, 15);
		add(lblGenre);
		
		tfName = new JTextField();
		tfName.setBounds(157, 306, 167, 21);
		add(tfName);
		tfName.setColumns(10);
		
		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		tfPrice.setBounds(157, 433, 167, 21);
		add(tfPrice);
		
		comboBoxAuthor = new JComboBox<>();
		comboBoxAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String authorId = comboBoxAuthor.getSelectedItem()+"";
				tfAuthorName.setText(authorDirectory.saerchById(authorId).getName());
			}
		});
		comboBoxAuthor.setBounds(492, 504, 61, 23);
		add(comboBoxAuthor);
		
		comboBoxGenre = new JComboBox<>();
		comboBoxGenre.setBounds(492, 432, 167, 23);
		add(comboBoxGenre);
		
		tfAuthorName = new JTextField();
		tfAuthorName.setBounds(563, 505, 96, 21);
		add(tfAuthorName);
		tfAuthorName.setColumns(10);
		
		lblPage = new JLabel("Page");
		lblPage.setBounds(100, 507, 85, 15);
		add(lblPage);
		
		tfPage = new JTextField();
		tfPage.setColumns(10);
		tfPage.setBounds(157, 504, 167, 21);
		add(tfPage);
		
		lblLanguage = new JLabel("Language");
		lblLanguage.setBounds(421, 306, 85, 15);
		add(lblLanguage);
		
		tfLanguage = new JTextField();
		tfLanguage.setColumns(10);
		tfLanguage.setBounds(492, 303, 167, 21);
		add(tfLanguage);
		
		tfBinding = new JTextField();
		tfBinding.setColumns(10);
		tfBinding.setBounds(157, 367, 167, 21);
		add(tfBinding);
		
		JLabel lblNewLabel_1 = new JLabel("Binding");
		lblNewLabel_1.setBounds(100, 370, 85, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Register Date");
		lblNewLabel_2.setBounds(421, 370, 85, 15);
		add(lblNewLabel_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(516, 367, 143, 21);
		add(dateChooser);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameString = tfName.getText();
				Float price = Float.parseFloat(tfPrice.getText());
				String genre = comboBoxGenre.getSelectedItem()+"";
				String author = comboBoxAuthor.getSelectedItem()+"";
				String language = tfLanguage.getText();
				String binding = tfBinding.getText();
				Date registerDate = dateChooser.getDate();
				int pages = Integer.valueOf(tfPage.getText());
				
				if(registerDate == null) {
					return;
				}
				
				bookDirectory.createBook(nameString, price, authorDirectory.saerchById(author), genreDirectory.search(genre), pages, language, binding, registerDate);
			
				populate();
			}
		});
		btnAdd.setBounds(331, 554, 93, 23);
		add(btnAdd);
		
		populate();
		populateAuthor();
		populateGenre();
	} 
	public void populate() {
		this.tableModel.setRowCount(0);
		for (Book b:this.bookDirectory.getBooks()) {
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
			
			this.tableModel.addRow(row);
		}
	}
	
	public void populateGenre() {
		this.comboBoxGenre.removeAllItems();
		for(Genre g:this.genreDirectory.getGenres()) {
			this.comboBoxGenre.addItem(g.getGenre());
		}
	}
	
	public void populateAuthor() {
		this.comboBoxAuthor.removeAllItems();
		for(Author a:this.authorDirectory.getAuthors()) {
			this.comboBoxAuthor.addItem(a.getID());
		}
	}
}
