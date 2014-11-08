package net.mv.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
//import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.*;
import org.xml.sax.*;

public class MySaxParser {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory sfactory = SAXParserFactory.newInstance();
		SAXParser sparser = sfactory.newSAXParser();
		
		//inner class
		DefaultHandler handler = new DefaultHandler(){
			boolean bid = false;
			boolean bfname = false;
			boolean blname = false;
			boolean bemail = false;
			
			public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
				if (qName.equalsIgnoreCase("id")){bid=true;}
				if (qName.equalsIgnoreCase("firstName")){bfname=true;}
				if (qName.equalsIgnoreCase("lastName")){blname=true;}
				if (qName.equalsIgnoreCase("email")){bemail=true;}
			}
			
			public void characters(char[] ch, int start, int length){
				if(bid){
					System.out.println("ID: " + new String(ch, start, length));
				}
				if(bfname){
					System.out.println("First Name: " + new String(ch, start, length));
				}
				if(blname){
					System.out.println("Last Name: " + new String(ch, start, length));
				}
				
				if(bemail){
					System.out.println("Email: " + new String(ch, start, length));
				}
			}
			
			public void endElement(String uri, String localName, String qName) throws SAXException{
				System.out.println("End element: " + qName);
			}
			
		};
		
		
		sparser.parse("src/people.xml", handler);
	}

}
