package com.test.regression.eDeals.testscripts;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.xml.sax.SAXException;

import com.test.regression.eDeals.pages.Create;
import com.test.regression.eDeals.pages.Review;
import com.test.regression.eDeals.utils.DB2Connection;
import com.test.regression.eDeals.utils.Logg;
import com.test.regression.eDeals.utils.ReadXML;
import com.test.regression.eDeals.utils.SuiteBase;

public class NegativeFlow extends SuiteBase{

	Create home;	
	Review homeR;
	//WebDriver _driver;

	SoftAssert s_Assert = new SoftAssert();
		
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	
	DB2Connection con;
	
	
	@Test(priority=1,enabled=true)
	public void NegDeal() throws InterruptedException, XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "creator-user_Invalid1");
		String userId = validLogin.get("UserName");
		String password = validLogin.get("password");
		String promotionNbr = validLogin.get("promotionNbr");
		
		home = new Create(_driver);
		homeR = new Review(_driver);

		con = new DB2Connection();
		
		home.clickLogin();
		home.enterLoginDetails(userId, password);
		log.info("User " +userId+ " has logged in Successfully");
		Thread.sleep(3000);
		
		String title = _driver.getTitle();
		Assert.assertEquals("SVHarbor Home", title);
		
		home.clickSVUIndependent();
		Thread.sleep(3000);
		
		home.clickVendorDeals();
		Thread.sleep(3000);
		
		homeR.clickReview();
		log.info("User successfully entered in eDeals application");
		log.info("User in Review/Update flow");
		Thread.sleep(3000);
		
		homeR.searchCriteria(promotionNbr);
		log.info("Search for deal is successful");
		Thread.sleep(3000);
		
		homeR.viewWorkList();
		Thread.sleep(3000);
		
		log.info("Navigated to Deal Summary page successfully");
		homeR.openCouponPopup();
		log.info("Coupon popup opened successfully");
		Thread.sleep(3000);
		
		String PLUCode = validLogin.get("PLUCode");
		String ExpectedError = validLogin.get("ExpectedError");
		
		System.out.println(PLUCode);
		System.out.println(ExpectedError);
	
		//	Negative house= new Negative();
		
		homeR.couponUpdatePLUcode(PLUCode);// here
		log.info("PLUcode  field is updated successfully");
		
		homeR.popupSave();
		
		String ActualError=homeR.GetValidationMessage();
		
		CaptureScreenShot(_driver,"PLUcodeError");
		log.info("Screenshot captured successfully");
		
		log.info("PLUcode  error message is  successfully validated");
		
		s_Assert.assertEquals(ActualError, ExpectedError, "Pass");
			
		
				
	}
	@Test(priority=2,enabled=true)
	public void Disabled() throws InterruptedException, XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "creator-user_Invalid1");
		String userId = validLogin.get("UserName");
		String password = validLogin.get("password");
		String promotionNbr = validLogin.get("promotionNbr");
		
		home = new Create(_driver);
		homeR = new Review(_driver);

		con = new DB2Connection();
		
		home.clickLogin();
		home.enterLoginDetails(userId, password);
		log.info("User " +userId+ " has logged in Successfully");
		Thread.sleep(3000);
		
		String title = _driver.getTitle();
		Assert.assertEquals("SVHarbor Home", title);
		
		home.clickSVUIndependent();
		Thread.sleep(3000);
		
		home.clickVendorDeals();
		Thread.sleep(3000);
		
		homeR.clickReview();
		log.info("User successfully entered in eDeals application");
		log.info("User in Review/Update flow");
		Thread.sleep(3000);
		
		homeR.searchCriteria(promotionNbr);
		log.info("Search for deal is successful");
		Thread.sleep(3000);
		
		homeR.viewWorkList();
		Thread.sleep(3000);
		
		log.info("Navigated to Deal Summary page successfully");
		homeR.openCouponPopup();
		log.info("Coupon popup opened successfully");
		Thread.sleep(3000);
		
		boolean result=homeR.checkDisabledFields();
		log.info("Validated successfully if the fields are disabled as expected");
		System.out.println("Is the amount field enabled-->" +result);
		
//			if(result=false)
//				{
//				log.info("All the expected fields are disabled as expected");
//				
//				}
//			else
//				{
//				log.info("Error: fields are not disabled as expected");
//				}
			
		s_Assert.assertEquals(result, "false", "Pass");
		
		CaptureScreenShot(_driver,"AmounDisabled");
		log.info("screenshot captured successfully");
		
		homeR .popupSave();
		
	}
/*
	@Test(priority=1,enabled=true)
	public void NegAmountValidation() throws InterruptedException, XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "creator-user_Invalid2");
		String userId = validLogin.get("UserName");
		String password = validLogin.get("password");
		String promotionNbr = validLogin.get("promotionNbr");
		
		home = new Create(_driver);
		homeR = new Review(_driver);

		con = new DB2Connection();
		
		home.clickLogin();
		home.enterLoginDetails(userId, password);
		log.info("User " +userId+ " has logged in Successfully");
		Thread.sleep(3000);
		
		String title = _driver.getTitle();
		Assert.assertEquals("SVHarbor Home", title);
		
		home.clickSVUIndependent();
		Thread.sleep(3000);
		
		home.clickVendorDeals();
		Thread.sleep(3000);
		
		homeR.clickReview();
		log.info("User successfully entered in eDeals application");
		log.info("User in Review/Update flow");
		Thread.sleep(3000);
		
		homeR.searchCriteria(promotionNbr);
		log.info("Search for deal is successful");
		Thread.sleep(3000);
		
		homeR.viewWorkList();
		Thread.sleep(3000);
		
		log.info("Navigated to Deal Summary page successfully");
		homeR.openCouponPopup();
		log.info("Coupon popup opened successfully");
		Thread.sleep(3000);
		
		String DealAmount = validLogin.get("dealAmount");
		String ExpectedError = validLogin.get("ExpectedError");
		
		System.out.println(DealAmount);
		System.out.println(ExpectedError);
	//	Negative house= new Negative();
		
		homeR.couponUpdateAmount(DealAmount);// here
		log.info("Amount  field is updated successfully");
		
		homeR.popupSave();
		
		String ActualError=homeR.GetValidationMessage();
		CaptureScreenShot(_driver,"PLUcodeError");
		
		System.out.println("Coupon Title is verified successfully");
		
		s_Assert.assertEquals(ActualError, ExpectedError, "Pass");
}
*/
}