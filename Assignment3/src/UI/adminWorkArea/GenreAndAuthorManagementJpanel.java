package UI.adminWorkArea;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.html.HTMLTableCaptionElement;

import Business.Application;
import Library.Author;
import Library.AuthorDirectory;
import Library.Genre;
import Library.GenreDirectory;
import Services.RequestDirectory;
import Services.Request;

import java.awt.Choice;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class GenreAndAuthorManagementJpanel extends JPanel {
	private JTable table;
	private DefaultTableModel tableModel;
	private Application business;
	private RequestDirectory masterOrderDirectory;
	private JTextField tfName;
	private JTextField tfNationality;
	private JTextField tfGenre;
	private AuthorDirectory authorDirectory;
	private GenreDirectory genreDirectory;
	private JComboBox<String> comboBoxGenre;
	
	/**
	 * Create the panel.
	 */
	public GenreAndAuthorManagementJpanel(Application business) {
		this.business = business;
		
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 31, 472, 133);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Author ID", "Author Name", "Nationality"
			}
		));
		
		tableModel =(DefaultTableModel) table.getModel();
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(73, 199, 85, 15);
		add(lblNewLabel);
		
		tfName = new JTextField();
		tfName.setBounds(168, 199, 195, 21);
		add(tfName);
		tfName.setColumns(10);
		
		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setBounds(73, 243, 85, 15);
		add(lblNationality);
		
		tfNationality = new JTextField();
		tfNationality.setColumns(10);
		tfNationality.setBounds(168, 243, 195, 21);
		add(tfNationality);
		
		JButton btnAddAuthor = new JButton("Add");
		btnAddAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameString = tfName.getText();
				String nationalityString = tfNationality.getText();
				authorDirectory.createAuthor(nameString, nationalityString);
				populate();
			}
		});
		btnAddAuthor.setBounds(407, 223, 93, 23);
		add(btnAddAuthor);
		
		comboBoxGenre = new JComboBox<>();
		comboBoxGenre.setBounds(71, 367, 242, 23);
		add(comboBoxGenre);
		
		tfGenre = new JTextField();
		tfGenre.setBounds(73, 433, 240, 21);
		add(tfGenre);
		tfGenre.setColumns(10);
		
		JButton btnAddGenre = new JButton("Add");
		btnAddGenre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(genreDirectory.search(tfGenre.getText())!=null) {
					return;
				}
				genreDirectory.addGenre(tfGenre.getText());
				populateGenre();
			}
		});
		btnAddGenre.setBounds(382, 432, 93, 23);
		add(btnAddGenre);

		populate();
		populateGenre();
	}
	
	public void populate() {
		this.tableModel.setRowCount(0);
		for (Author a:this.authorDirectory.getAuthors()) {
			Object row[] = new Object[3];
			row[0] = a.getID();
			row[1] = a.getName();
			row[2] = a.getNationality();
			this.tableModel.addRow(row);
		}
	}
	
	public void populateGenre() {
		this.comboBoxGenre.removeAllItems();
		for(Genre g: this.genreDirectory.getGenres()) {
			this.comboBoxGenre.addItem(g.getGenre());
		}
	}
}
