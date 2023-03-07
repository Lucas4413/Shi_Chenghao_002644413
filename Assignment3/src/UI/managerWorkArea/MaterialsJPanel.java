package UI.managerWorkArea;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Business.Application;
import Business.Branch;
import Library.Book;
import Library.BookDirectory;
import Library.General;
import Library.Magzine;
import Services.RequestDirectory;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class MaterialsJPanel extends JPanel {
	private JTable table;
	private Application business;
	private DefaultTableModel tableModelBook;
	private DefaultTableModel tableModelMagzine;
	private RequestDirectory requestDirectory;
	private JTable tableBook;
	private JTable tableMagzine;
	private BookDirectory bookDirectory;
	private General general;
	
	/**
	 * Create the panel.
	 */
	public MaterialsJPanel(Application business, Branch branch) {
		this.business = business;
		this.bookDirectory = branch.getLibrary().getBookDirectory();
		this.general = branch.getLibrary().getGeneral();
		
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 807, 244);
		add(scrollPane);
		
		tableBook = new JTable();
		tableBook.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Serial Number", "Name", "Author Name", "Genre", "Register Date", "Pages", "Binding Type", "Language", "Price"
			}
		));
		scrollPane.setViewportView(tableBook);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 356, 807, 244);
		add(scrollPane_1);
		
		tableMagzine = new JTable();
		tableMagzine.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Serial Number", "Name", "Company Name", "Register Date", "Issue Type", "Price"
			}
		));
		scrollPane_1.setViewportView(tableMagzine);
		
		this.tableModelBook = (DefaultTableModel)tableBook.getModel();
		this.tableModelMagzine = (DefaultTableModel)tableMagzine.getModel();
		
		JLabel lblNewLabel = new JLabel("Books:");
		lblNewLabel.setBounds(10, 21, 94, 15);
		add(lblNewLabel);
		
		JLabel lblMagzines = new JLabel("Magzines:");
		lblMagzines.setBounds(10, 331, 94, 15);
		add(lblMagzines);
		
		populateBook();
		populateMagzine();

	}
	public void populateBook() {
		this.tableModelBook.setRowCount(0);
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
			
			this.tableModelBook.addRow(row);
		}
	}
	
	public void populateMagzine() {
		this.tableModelMagzine.setRowCount(0);
		for (Magzine m:this.general.getMagzines()) {
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
