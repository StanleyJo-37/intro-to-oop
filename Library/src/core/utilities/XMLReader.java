package core.utilities;
  
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerConfigurationException;
//import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
//import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.io.File;
import java.io.IOException;

public class XMLReader {
	
	private static boolean initiated = false;
	private static DocumentBuilder documentBuilder;
//	private static Transformer transformer;
	private XMLReader() {}
	
	public static boolean usable() {
		return XMLReader.initiated;
	}
	
	public static final boolean init() {
		try {
			if (XMLReader.usable()) return true;
			XMLReader.documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//			XMLReader.transformer = TransformerFactory.newInstance().newTransformer();
			XMLReader.initiated = true;
			
			return true;
		} catch (ParserConfigurationException /*| TransformerConfigurationException */| TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static Element readXML(String filepath, String rootName) {
		
		try {
			File file = new File(filepath);
			Document document = documentBuilder.parse(file);
			document.getDocumentElement().normalize();
//			NodeList nodes = document.getElementsByTagName(rootName);
			Node node = document.importNode(document.getElementsByTagName("requests").item(0), true);
			return (Element)node;
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
