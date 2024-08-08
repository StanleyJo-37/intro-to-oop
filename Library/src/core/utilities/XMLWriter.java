package core.utilities;

import java.lang.Object;
import java.util.UUID;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document; 
import org.w3c.dom.Element;
// import org.w3c.dom.Node;

import core.library.components.Request;


public class XMLWriter {
	
	private static boolean initiated = false;
	private static DocumentBuilder documentBuilder;
	private static Transformer transformer;
	private XMLWriter() {}
	
	public static boolean usable() {
		return XMLWriter.initiated;
	}
	
	public static final boolean init() {
		try {
			if (XMLWriter.usable()) return true;
			XMLWriter.documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			XMLWriter.transformer = TransformerFactory.newInstance().newTransformer();
			XMLWriter.initiated = true;
			
			return true;
		} catch (ParserConfigurationException | TransformerConfigurationException | TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	private static class ElementFilepath {
		private Element element;
		private String filepath;
		private File file;
		
		ElementFilepath(Element element, String filepath, File file) {
			this.element = element;
			this.filepath = filepath;
			this.file = file;
		}
		
		public Element getElement() {
			return this.element;
		}
		
		public String getFilepath() {
			return this.filepath;
		}
		
		public File getFile() {
			return this.file;
		}
	}
	
	private static XMLWriter.ElementFilepath structureElement(Document document, String rootName, DocumentType docType, Object object) {
		try {
			
			Element root = null;
			String filepath = Filestream.Filepath.get(docType);
			File file = null;
			
			if (docType == DocumentType.STUDENT) {
				
			} else if (docType == DocumentType.LIBRARIAN) {
				
			} else if (docType == DocumentType.REQUEST) {
				Request castedObject = (Request)object;
				UUID requestID = castedObject.getRequestID();
				
				UUID studentID = castedObject.getStudentID();
				UUID bookID = castedObject.getBookID();

				filepath = System.getProperty("user.dir") + filepath + "req-" + studentID + ".xml";
				file = new File(filepath);
				
				root = file.exists() ? XMLReader.readXML(filepath, rootName) : document.createElement(rootName);
				
				Element rootNode = document.createElement(rootName);
				
				Element studentNode = document.createElement("student");
				studentNode.appendChild(document.createTextNode(studentID.toString()));
				Element bookNode = document.createElement("book");
				bookNode.appendChild(document.createTextNode(bookID.toString()));
				
				rootNode.appendChild(studentNode);
				rootNode.appendChild(bookNode);
				
				root.setAttribute("id", requestID.toString());
				root.appendChild(rootNode);
			} 
			
			return new XMLWriter.ElementFilepath(root, filepath, file);
		} catch (DOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String writeXML(String rootName, Object object, DocumentType docType) {
		try {
			Document document = documentBuilder.newDocument();
			
			ElementFilepath resolve = structureElement(document, rootName, docType, object);
			document.appendChild(resolve.getElement());
			
			DOMSource source = new DOMSource(document);
			
			String filepath = resolve.getFilepath();
			
			File newFile = resolve.getFile();
			newFile.createNewFile();
			
			StreamResult result = new StreamResult(new FileOutputStream(filepath, true));
			
			transformer.transform(source, result);
			
			System.out.println("Successfully saved to " + resolve.getFilepath());
			
			XMLWriter.documentBuilder.reset();
			XMLWriter.transformer.reset();
			
			return resolve.getFilepath();
		} catch (DOMException | TransformerException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
}
