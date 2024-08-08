package core.library.literatures;

import java.time.Year;
import java.util.ArrayList;

import core.library.enums.Genre;
import core.library.enums.Rating;
import core.personnel.person.Author;
import core.personnel.person.Publisher;

public class Book extends Literature {
	
	public Book(String bookTitle, ArrayList<Author> author, Publisher publisher, String isbn, String bookDesc, ArrayList<Genre> genres, Year releasedYear, Rating rating) {
		super(bookTitle, author, publisher);
		this.isbn = isbn;
		this.bookDesc = bookDesc;
		this.setGenres(genres);
		this.setReleasedYear(releasedYear);
		this.rating = rating;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	
	public void setGenres(ArrayList<Genre> genres) {
		this.genres = genres;
	}
	
	public void addGenres(ArrayList<Genre> genres) {
		for (Genre genre : genres) {
			this.genres.add(genre);
		}
	}
	
	public void addGenre(Genre genre) {
		this.genres.add(genre);
	}
	
	public void deleteGenres(ArrayList<Genre> genres) {
		for (Genre genre : genres) {
			this.genres.remove(genre);
		}
	}
	
	public void deleteGenre(Genre genre) {
		this.genres.remove(genre);
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public String getBookDesc() {
		return this.bookDesc;
	}
	
	public ArrayList<Genre> getGenres() {
		return this.genres;
	}

	public Rating getRating() {
		return this.rating;
	}

	public Year getReleasedYear() {
		return releasedYear;
	}

	public void setReleasedYear(Year releasedYear) {
		this.releasedYear = releasedYear;
	}
	
	private String isbn, bookDesc;
	private ArrayList<Genre> genres;
	private Year releasedYear;
	private Rating rating;
	
}
