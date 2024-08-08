package core.library.literatures;

import java.util.ArrayList;

import core.library.enums.Topic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import core.personnel.person.Author;
import core.personnel.person.Publisher;

public class News extends Literature {
	
	public News(String title, ArrayList<Author> authors, Publisher publisher, ArrayList<Topic> topics, String headline, String summary, ArrayList<String> sources, LocalDateTime timestamp) {
		super(title, authors, publisher);
		this.timestamp = LocalDateTime.parse(dtf.format(timestamp));
		this.headline = headline;
		this.summary = summary;
		for (String source : sources) {
			this.sources.add(source);
		}
	}
	
	public ArrayList<Topic> getTopics() {
		return topics;
	}

	public void setTopics(ArrayList<Topic> topics) {
		this.topics = topics;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public ArrayList<String> getSources() {
		return sources;
	}

	public void setSources(ArrayList<String> sources) {
		this.sources = sources;
	}
	
	static private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	private LocalDateTime timestamp;
	private ArrayList<Topic> topics;
	private String headline, summary;
	private ArrayList<String> sources = new ArrayList<String>();
	
}
