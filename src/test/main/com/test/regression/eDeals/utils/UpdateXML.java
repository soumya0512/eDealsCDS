package com.test.regression.eDeals.utils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class UpdateXML {
	
	public void updateTestData() {

		   try {
		      File inputFile = new File("TestData.xml"); 	    	
		      DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		      DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		      Document doc = docBuilder.parse(inputFile);
		      Node testData = doc.getFirstChild();
		      Node newUser = doc.getElementsByTagName("newUsers").item(0);
		      Node authorizedUser = doc.getElementsByTagName("authorizedUsers").item(0);
		      
		      // loop the newUser child node
		      NodeList list = newUser.getChildNodes();
		      
		      for(int count = 0; count < list.getLength(); count++){
		    	  
		    	  Node users = list.item(count);
		    	  NodeList userChildNodes = users.getChildNodes();
		      
		      for (int temp = 0; temp < userChildNodes.getLength(); temp++) {
		         Node node = userChildNodes.item(temp);
		         
		         if (node.getNodeType() == Node.ELEMENT_NODE) {
		            Element eElement = (Element) node;
		            
		           
		            if ("UserName".equals(eElement.getNodeName())){
		            	
		            	String username = eElement.getTextContent();
		            	System.out.println("Username before Update : "+ username);
		            	
		            	List<String> splitUserName = Arrays.asList(username.split("@"));
		            	
		            	String temp1 = splitUserName.get(0);
		            	List<String> wantedUserName = Arrays.asList(temp1.split("_"));
		            	
		            	String numInUserName = wantedUserName.get(1);
		            	int updatedNumInUserName = Integer.parseInt(numInUserName);
		            	updatedNumInUserName++;
		            	
		            	String numInUserNameUpdated = String.valueOf(updatedNumInUserName);
		            	String updateUN = wantedUserName.get(0)+"_"+numInUserNameUpdated+"@"+splitUserName.get(1);
		            	
		            	System.out.println("Updated Username : " + updateUN);
		            	
		            	//setValue("UserName", eElement , updateUN);
		            	//node.setNodeValue(updateUN);
		            	eElement.setTextContent(updateUN);
		            
		            	//System.out.println("Updated Successfully..");
		            }
		            
		            else if("cardlessid".equals(eElement.getNodeName())){
		            	
		            	String cardlessId = eElement.getTextContent();
		            	
		            	long cardlessIdAsInt = Long.parseLong(cardlessId);
		            	long cardlessIdAsIntUpdated = cardlessIdAsInt+1;
		            	
		            	String cardlessIdAsStringUpdated = String.valueOf(cardlessIdAsIntUpdated);
		            	
		            	String cardlessIdAsStringUpdatedNFormatted = String.format("%011d", cardlessIdAsIntUpdated);
		            	
		            	eElement.setTextContent(cardlessIdAsStringUpdatedNFormatted);
		            }
		         }
		      }
		      }
		      
		      // loop the authorizedUser child node
		      NodeList list1 = authorizedUser.getChildNodes();
		      
		      for(int count1 = 0; count1 < list1.getLength(); count1++){
		    	  
		    	  Node authUsers = list1.item(count1);
		    	  NodeList authUserChildNodes = authUsers.getChildNodes();
		      
		      for (int temp = 0; temp < authUserChildNodes.getLength(); temp++) {
		         Node node = authUserChildNodes.item(temp);
		         if (node.getNodeType() == Node.ELEMENT_NODE) {
		            Element eElement = (Element) node;
		            
		           
		            if ("CouponToAdd".equals(eElement.getNodeName())){
		            	String wantedCoupon = eElement.getTextContent();
		            	int wantedCouponAsInt = Integer.parseInt(wantedCoupon);
		            	int wantedCouponAsIntUpdated = wantedCouponAsInt+1;
		            	System.out.println("wanted coupon in int : " + wantedCouponAsIntUpdated);
		            	
		            	String wantedCouponAsStringUpdated = String.valueOf(wantedCouponAsIntUpdated);
		            	
		            	System.out.println("Updated Wanted Coupon Value : " + wantedCouponAsStringUpdated);
		            	
		            	eElement.setTextContent(wantedCouponAsStringUpdated);
		            }
		           }
		         }
		      }
		    
		      
		      Transformer xformer = TransformerFactory.newInstance().newTransformer();
		      xformer.transform(new DOMSource(doc), new StreamResult(inputFile));

		    //For console Output. 
		      StreamResult consoleResult = new StreamResult(System.out); 
		      xformer.transform(new DOMSource(doc), consoleResult); 

		}catch(SAXException ex) {
		    ex.printStackTrace();
		}
		 
		   catch(TransformerException ex) {
			    ex.printStackTrace();
			}
		   catch(IOException ex) {
			    ex.printStackTrace();
			}
		   catch(ParserConfigurationException ex) {
			    ex.printStackTrace();
			}
			         
	}
	
}
