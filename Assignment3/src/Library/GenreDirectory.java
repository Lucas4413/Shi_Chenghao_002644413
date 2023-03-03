package Library;

import java.util.ArrayList;

public class GenreDirectory {
	ArrayList<Genre> genres;
	
	public GenreDirectory() {
		this.genres = new ArrayList<Genre>();
	}

	public ArrayList<Genre> getGenres() {
		return genres;
	}

	public void setGenres(ArrayList<Genre> genres) {
		this.genres = genres;
	}
	
	public void addGenre(String g) {
		if(g!=null&&g.length()>0) {
			this.genres.add(new Genre(g));
		}
		
	}
	
	public Genre search(String g) {
		for (Genre genre:this.genres) {
			if(genre.getGenre().equals(g)) {
				return genre;
			}
		}
		return null;
	}
}
