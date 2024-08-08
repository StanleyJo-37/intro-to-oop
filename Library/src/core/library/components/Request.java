package core.library.components;

import java.util.UUID;

public class Request {
	
	public Request(UUID studentID, UUID bookID) {
		this.requestID = UUID.randomUUID();
		this.studentID = studentID;
		this.bookID = bookID;
	}
	
	public UUID getRequestID() {
		return this.requestID;
	}
	
	public UUID getStudentID() {
		return this.studentID;
	}
	
	public UUID getBookID() {
		return this.bookID;
	}
	
	private UUID requestID;
	private UUID studentID;
	private UUID bookID;
	
}
