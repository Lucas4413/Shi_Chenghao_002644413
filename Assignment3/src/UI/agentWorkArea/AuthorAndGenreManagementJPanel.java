package UI.agentWorkArea;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Business.Application;
import Business.Branch;
import Library.Author;
import Library.AuthorDirectory;
import Library.Genre;
import Library.GenreDirectory;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AuthorAndGenreManagementJPanel extends JPanel {
	private JTextField tfName;
	private JTextField tfNationality;
	private JTextField tfGenre;
	private JTable table;
	private DefaultTableModel tableModel;
	private Application application;
	private AuthorDirectory authorDirectory;
	private GenreDirectory genreDirectory;
	private JComboBox<String> comboBoxGenre;

	/**
	 * Create the panel.
	 */
	public AuthorAndGenreManagementJPanel(Application application, Branch branch) {
		this.application = application;
		this.authorDirectory = branch.getLibrary().getAuthorDirectory();
		this.genreDirectory = branch.getLibrary().getGenreDirectory();
		
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 24, 522, 133);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Author ID", "Author Name", "Nationality"
			}
		));
		scrollPane.setViewportView(table);
		this.tableModel = (DefaultTableModel) table.getModel();
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(195, 192, 85, 15);
		add(lblNewLabel);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(290, 192, 195, 21);
		add(tfName);
		
		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setBounds(195, 236, 85, 15);
		add(lblNationality);
		
		tfNationality = new JTextField();
		tfNationality.setColumns(10);
		tfNationality.setBounds(290, 236, 195, 21);
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
		btnAddAuthor.setBounds(529, 216, 93, 23);
		add(btnAddAuthor);
		
		this.comboBoxGenre = new JComboBox<String>();
		this.comboBoxGenre.setBounds(193, 360, 242, 23);
		add(this.comboBoxGenre);
		
		tfGenre = new JTextField();
		tfGenre.setColumns(10);
		tfGenre.setBounds(195, 426, 240, 21);
		add(tfGenre);
		
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
		btnAddGenre.setBounds(504, 425, 93, 23);
		add(btnAddGenre);
		
		JLabel lblNewLabel_1 = new JLabel("Genre:");
		lblNewLabel_1.setBounds(195, 335, 54, 15);
		add(lblNewLabel_1);
		
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
