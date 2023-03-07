package Library;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import Services.RequestDirectory;

public class Library {
	private EmployeeDirectory employeeDirectory;
	private String BuildingNO;
	private AuthorDirectory authorDirectory;
	private GenreDirectory genreDirectory;
	private RequestDirectory masterOrderDirectory;
	private BookDirectory bookDirectory;
	private General general;
	private static int count = 0;
	
	public Library() {
		this.employeeDirectory = new EmployeeDirectory();
		this.count++;
		this.BuildingNO = this.count+"";
		this.authorDirectory = new AuthorDirectory();
		this.genreDirectory = new GenreDirectory();
		this.masterOrderDirectory = new RequestDirectory();
		this.bookDirectory = new BookDirectory();
		this.general = new General();
	}
	
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
	public String getBuildingNO() {
		return BuildingNO;
	}
	public void setBuildingNO(String buildingNO) {
		BuildingNO = buildingNO;
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
