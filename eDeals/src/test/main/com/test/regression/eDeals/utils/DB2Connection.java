package com.test.regression.eDeals.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

public class DB2Connection {

	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	
	private Connection connection;
	private static Statement statement;
	private static ResultSet rs;

	
	@BeforeClass
	public void setUp() throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		
		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "db2-user");
		String url = validLogin.get("url");
		String db2user = validLogin.get("db2user");
		String db2pwd = validLogin.get("db2pwd");
						
        try {
        	Class.forName("com.ibm.db2.jcc.DB2Driver");	    
			connection = DriverManager.getConnection(url, db2user, db2pwd);
			
			if(connection!= null){
            System.out.println("Connecting to Database...");
			}
            
        } 
        
        catch (SQLException ex) {
           ex.printStackTrace();
        }
        
        catch (ClassNotFoundException ex) {
           ex.printStackTrace();
        }
	}
	
	
	@Test
    public ResultSet couponData(String query) {
        
		try {

            statement = connection.createStatement();
            rs = statement.executeQuery(query);                         
        } 
		
		catch (SQLException ex) {
           ex.printStackTrace();
        }
		return rs;
		
    }
	
	
	@AfterClass
    public void tearDown() {
      if (connection != null) {
    	  
                try {
                    System.out.println("Closing Database Connection...");
                    connection.close();
                } 
                
                catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
      }

	
}

