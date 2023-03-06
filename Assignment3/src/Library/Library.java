package Library;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import Services.RequestDirectory;

public class Library {
	private EmployeeDirectory employeeDirectory;
	private int BuildingNO;
	private AuthorDirectory authorDirectory;
	private GenreDirectory genreDirectory;
	private RequestDirectory masterOrderDirectory;
	private BookDirectory bookDirectory;
	private General general;
	
	public BookDirectory getBookDirectory() {
		return bookDirectory;
	}
	public void setBookDirectory(BookDirectory bookDirectory) {
		this.bookDirectory = bookDirectory;
	}
	public General getGeneral() {
		return general;
	}
	public void setGeneral(General general) {
		this.general = general;
	}
	public EmployeeDirectory getEmployeeDirectory() {
		return employeeDirectory;
	}
	public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
		this.employeeDirectory = employeeDirectory;
	}
	public int getBuildingNO() {
		return BuildingNO;
	}
	public void setBuildingNO(int buildingNO) {
		BuildingNO = buildingNO;
	}
	public Library() {
		this.employeeDirectory = new EmployeeDirectory();
	}
	public RequestDirectory getMasterOrderDirectory() {
		return masterOrderDirectory;
	}
	public void setMasterOrderDirectory(RequestDirectory masterOrderDirectory) {
		this.masterOrderDirectory = masterOrderDirectory;
	}
	public AuthorDirectory getAuthorDirectory() {
		return authorDirectory;
	}
	public void setAuthorDirectory(AuthorDirectory authorDirectory) {
		this.authorDirectory = authorDirectory;
	}
	public GenreDirectory getGenreDirectory() {
		return genreDirectory;
	}
	public void setGenreDirectory(GenreDirectory genreDirectory) {
		this.genreDirectory = genreDirectory;
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
}
