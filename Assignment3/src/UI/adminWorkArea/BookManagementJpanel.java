package UI.adminWorkArea;

import javax.swing.JPanel;

import Business.Application;
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
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class BookManagementJpanel extends JPanel {
	private Application business;
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
//	private LibrarianDirectory agentDirectory;
	/**
	 * Create the panel.
	 */
	public BookManagementJpanel(Application business) {
		this.business = business;
		
//		this.agentDirectory = this.business.getAgentDirectory();
		
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 10, 662, 233);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Author ID", "Author Name", "Genre", "Price"
			}
		));
		scrollPane.setViewportView(table);
		tableModel = (DefaultTableModel) table.getModel();
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(100, 309, 85, 15);
		add(lblNewLabel);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(100, 387, 85, 15);
		add(lblPrice);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(421, 309, 85, 15);
		add(lblAuthor);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(421, 387, 85, 15);
		add(lblGenre);
		
		tfName = new JTextField();
		tfName.setBounds(157, 306, 167, 21);
		add(tfName);
		tfName.setColumns(10);
		
		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		tfPrice.setBounds(157, 384, 167, 21);
		add(tfPrice);
		
		comboBoxAuthor = new JComboBox<>();
		comboBoxAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfAuthorName.setText(comboBoxAuthor.getSelectedItem()+"");
			}
		});
		comboBoxAuthor.setBounds(492, 305, 61, 23);
		add(comboBoxAuthor);
		
		comboBoxGenre = new JComboBox<>();
		comboBoxGenre.setBounds(492, 383, 167, 23);
		add(comboBoxGenre);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameString = tfName.getText();
				Float price = Float.parseFloat(tfPrice.getText());
				String genre = comboBoxGenre.getSelectedItem()+"";
				String author = comboBoxAuthor.getSelectedItem()+"";
				
				
			
				populate();
			}
		});
		btnAdd.setBounds(331, 450, 93, 23);
		add(btnAdd);
		
		tfAuthorName = new JTextField();
		tfAuthorName.setBounds(563, 306, 96, 21);
		add(tfAuthorName);
		tfAuthorName.setColumns(10);
		
		populate();
		populateAuthor();
		populateGenre();
	} 
	public void populate() {
		this.tableModel.setRowCount(0);
		for (Book b:this.bookDirectory.getBooks()) {
			Object row[] = new Object[5];
			row[0] = b.getName();
			row[1] = b.getAuthor().getID();
			row[2] = b.getAuthor().getName();
			row[3] = b.getGenre().getGenre();
			row[4] = b.getPrice();
			
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
