package Library;

import java.util.ArrayList;

public class AuthorDirectory {
	ArrayList<Author> authors;
	
	public AuthorDirectory() {
		this.authors = new ArrayList<Author>();
	}

	public ArrayList<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<Author> authors) {
		this.authors = authors;
	}
	
	public void createAuthor(String name, String nationality) {
		this.authors.add(new Author(name, nationality));
	}
	
	public Author saerchById(String id) {
		for(Author a:this.authors) {
			if (a.getID().equals(id)) {
				return a;
			}
		}
		return null;
	}
}
