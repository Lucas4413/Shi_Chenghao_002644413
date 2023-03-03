package Library;

import java.util.ArrayList;
import java.util.Date;

public class BookDirectory {
	ArrayList<Book> books;
	
	public BookDirectory() {
		this.books = new ArrayList<Book>();
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	public void createBook(String name, Float price, Author author, Genre genre, int pages, String lang, String bindingType, Date registerdDate) {
		Book book = new Book();
		book.setAuthor(author);
		book.setGenre(genre);
		book.setName(name);
		book.setPrice(price);
		book.setSerialNumber();
		book.setPageNumber(pages);
		book.setLanguage(lang);
		book.setTypeOfBinding(bindingType);
		book.setRegisteredDate(registerdDate);
		book.setIsAvailable(true);
		this.books.add(book);
	}
	
	public Book searchById(String id) {
		for (Book b:this.books) {
			if(b.getSerialNumber().equals(id)) {
				return b;
			}
		}
		return null;
	}
}
