package com.test.regression.eDeals.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML {

	
	public NodeList eval(String testDataFileName, String wantedUserData) 
	        throws XPathExpressionException, ParserConfigurationException, SAXException, IOException  {
		File fXmlFile = new File(testDataFileName);
		System.out.println("Found the xml file!!!");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		
				
		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();

		XPath xpath = XPathFactory.newInstance().newXPath();
		System.out.println("xpath obj created..");
		XPathExpression expr = xpath.compile("//user[@userid='"+wantedUserData+"']");
		//change this when u update anything in TestData.xml
		
		System.out.println("Completed searching for user1"); 
		Object exprResult =  expr.evaluate(doc, XPathConstants.NODESET);
		System.out.println("executed exprResult step");
		
		
		NodeList nList = (NodeList)exprResult;
		return nList;
	}

	public List<Map<String, String>> fromNodeList(final NodeList nodes) {
	    final List<Map<String, String>> out = new ArrayList<Map<String,String>>(); 
	    int len = (nodes != null) ? nodes.getLength() : 0;
	    for (int i = 0; i < len; i++) {
	        NodeList children = nodes.item(i).getChildNodes();
	        Map<String, String> childMap = new HashMap<String, String>();
	        for (int j = 0; j < children.getLength(); j++) {
	            Node child = children.item(j);
	            if (child.getNodeType() == Node.ELEMENT_NODE)
	                childMap.put(child.getNodeName(), child.getTextContent());
	        }
	        out.add(childMap);
	    }
	    return out;
	}
	
	public Map<String,String> getUserData(String testDataFileName, String wantedTestUserDetail) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		NodeList nList = eval(testDataFileName, wantedTestUserDetail);
		List<Map<String, String>> nodes = fromNodeList(nList);
		System.out.println(nodes);
		
		Map<String, String> userDetail = nodes.get(0);
		System.out.println("Fetched "+wantedTestUserDetail +" user data..!!");
		return userDetail;
	}
}
