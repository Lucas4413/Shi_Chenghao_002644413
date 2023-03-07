package Library;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Book extends Material{

	private Author author;
	private Genre genre;
	private int pageNumber;
	private String language;
	private String typeOfBinding;
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getTypeOfBinding() {
		return typeOfBinding;
	}
	public void setTypeOfBinding(String typeOfBinding) {
		this.typeOfBinding = typeOfBinding;
	}
	
	public String dateToString(Date registeredDate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		return simpleDateFormat.format(registeredDate);
	}
}
