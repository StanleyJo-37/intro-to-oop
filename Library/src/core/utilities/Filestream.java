package core.utilities;

import java.util.HashMap;
import java.util.Map;

final public class Filestream {
	final static Map<DocumentType, String> Filepath = new HashMap<DocumentType, String>();
	
	public static void init() {
		String ROOT = "\\data\\";
		String BOOK = ROOT + "book\\";
		String REQUEST = ROOT + "request\\";
		String PERSONNEL = ROOT + "personnel\\";
		String STUDENT = PERSONNEL + "student\\";
		String LIBRARIAN = PERSONNEL + "librarian\\";
		
		Filepath.put(DocumentType.BOOK, BOOK);
		Filepath.put(DocumentType.REQUEST, REQUEST);
		Filepath.put(DocumentType.STUDENT, STUDENT);
		Filepath.put(DocumentType.LIBRARIAN, LIBRARIAN);
		
		if (!XMLWriter.init()) System.out.println("Failed to initiate XMLWriter.");
		if (!XMLReader.init()) System.out.println("Failed to initiate XMLReader.");
	}
}