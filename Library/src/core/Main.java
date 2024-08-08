package core;

import core.utilities.XMLWriter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import core.library.components.Request;
import core.personnel.person.Student;
import core.utilities.DocumentType;
import core.utilities.Filestream;
import core.utilities.XMLReader;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		// TODO Auto-generated method stub
//		Filestream.init();
//		
//		Student student = new Student("Stanley");
//		
//		String filepath = XMLWriter.writeXML("requests", new Request(student.getID(), UUID.randomUUID()), DocumentType.REQUEST);
//		XMLWriter.writeXML("request", new Request(student.getID(), UUID.randomUUID()), DocumentType.REQUEST);
//	
//		XMLReader.readXML(filepath, "requests");
	}

}
