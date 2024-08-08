package core.library.literatures;

import java.util.UUID;
import java.util.ArrayList;

import core.personnel.person.Author;
import core.personnel.person.Publisher;

public abstract class Literature {
	
	public Literature(String title, ArrayList<Author> authors, Publisher publisher) {
		this.liteartureID = UUID.randomUUID();
		this.title = title;
		this.authors = authors;
		this.publisher = publisher;
		this.quantity = 1;
	}
	
	public UUID getLiteartureID() {
		return this.liteartureID;
	}

	public void setLiteartureID(UUID liteartureID) {
		this.liteartureID = liteartureID;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<Author> getAuthor() {
		return this.authors;
	}

	public void setAuthor(ArrayList<Author> authors) {
		this.authors = authors;
	}
	
	public void addAuthors(ArrayList<Author> authors) {
		for (Author author : authors) {
			this.authors.add(author);
		}
	}
	
	public void addAuthor(Author author) {
		this.authors.add(author);
	}
	
	public void deleteAuthors(ArrayList<Author> authors) {
		for (Author author : authors) {
			this.authors.remove(author);
		}
	}
	
	public void deleteAuthor(Author author) {
		this.authors.remove(author);
	}

	public Publisher getPublisher() {
		return this.publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	private UUID liteartureID;
	private String title;
	private ArrayList<Author> authors;
	private Publisher publisher;
	private int quantity;
	
}
