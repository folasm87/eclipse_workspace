package net.mv.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MyDomParser {
	//DOM parser will load the entired XML into memory
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
			//load the file that I'm going to read frmo 
			File file = new File("src/people.xml");
			
			DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();
			
			//get a DocumentBuilder object from the factory
			DocumentBuilder dbuilder = dfactory.newDocumentBuilder();
			
			//parse the xml file into a document object
			Document doc = dbuilder.parse(file);
			
			//print the root element/node using the Document object
			System.out.println("Root element is: " + doc.getDocumentElement().getNodeName() );
			
			//Get all elements with name person, and store into a NodeList object
			
			NodeList nList = doc.getElementsByTagName("person");
			
			for (int i=0; i < nList.getLength(); i++){
				
				Node node = nList.item(i);
				System.out.println("Current element: " + node.getNodeName());
				
				Element element = (Element) node;
				System.out.println(element.getElementsByTagName("firstName").item(0).getTextContent());
				System.out.println(element.getElementsByTagName("lastName").item(0).getTextContent());
				System.out.println(element.getElementsByTagName("email").item(0).getTextContent());
				
			}
	}

}
