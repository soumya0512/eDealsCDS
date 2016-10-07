package com.test.regression.eDeals.testscripts;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.test.regression.eDeals.pages.Create;
import com.test.regression.eDeals.pages.Review;
import com.test.regression.eDeals.utils.Logg;
import com.test.regression.eDeals.utils.ReadXML;
import com.test.regression.eDeals.utils.SuiteBase;
import com.test.regression.eDeals.utils.CouponDetailsBean;
import com.test.regression.eDeals.utils.DB2Connection;

public class CouponContentValidationFlow extends SuiteBase{

	Create home;	
	//Review homeR;
		
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	
	@Test(priority=1,enabled=true)
	public void couponContentValidation() throws InterruptedException, XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "CoupContValidation-user");
		String userId = validLogin.get("UserName");
		String password = validLogin.get("password");
		
		String vndCntrctID = validLogin.get("vndContractID");
		String dealDscrptn = validLogin.get("dealDscrptn");
		
		String dealBegDt = validLogin.get("beginDate");
		String dealEndDt = validLogin.get("endDate");
		
		String amount = validLogin.get("amount");
		String mustBuyQty = validLogin.get("mustBuyQty");
		String consLmtQty = validLogin.get("consLmtQty");
		String clipLmt = validLogin.get("clipLmt");
		String processCd = validLogin.get("processCd");
		String pluCd = validLogin.get("pluCd");
		String manufacturerCd = validLogin.get("manufacturerCd");
		String couponUPC = validLogin.get("couponUPC");
		
		String invalidCouponTitle = validLogin.get("invalidCouponTitle");
		String emptyCouponTitle = validLogin.get("emptyCouponTitle");
		String couponTitle = validLogin.get("couponTitle");
		String invalidCouponDesc = validLogin.get("invalidCouponDesc");
		String emptyCouponDesc = validLogin.get("emptyCouponDesc");
		
		/*String couponDesc = validLogin.get("couponDesc");
		String couponAddDesc = validLogin.get("couponAddDesc");
		String couponDtls = validLogin.get("couponDtls");
		
		String couponBegDt = validLogin.get("couponBegDt");
		String couponEndDt = validLogin.get("couponEndDt");*/		
		
		
		home = new Create(_driver);
		
		home.clickLogin();
		home.enterLoginDetails(userId, password);
		log.info("User" +userId+ " has logged in Successfully");
		Thread.sleep(3000);
		
		home.clickSVUIndependent();
		Thread.sleep(3000);
		
		home.clickVendorDeals();
		Thread.sleep(3000);
		
		home.clickCreate();
		log.info("User successfully entered in eDeals application");
		log.info("User in Create flow");
		Thread.sleep(3000);
		
		//String title1 = _driver.getTitle();
		//Assert.assertEquals("Enter Deal Details", title1);
		
		home.enterDealDetails(vndCntrctID, dealDscrptn);
		log.info("Entered all details in Enter Deals Details page");
		Thread.sleep(3000);
		
		//String title2 = _driver.getTitle();
		//Assert.assertEquals("Select Deal Types", title2);
		
		home.selectDealType(dealBegDt, dealEndDt);
		log.info("Deal Type is selected successfully");
		Thread.sleep(3000);
		
		//String title3 = _driver.getTitle();
		//Assert.assertEquals("Enter Items", title3);
		
		home.selectCouponType();
		log.info("Coupon Type is selected successfully");
		Thread.sleep(3000);
		
		home.couponExecution(amount, mustBuyQty, consLmtQty, clipLmt, processCd, pluCd, manufacturerCd, couponUPC);
		log.info("Coupon Execution details are entered successfully");
		Thread.sleep(3000);
		
		
		log.info("In Coupon Content section entering a title which has more than 40 characters");
		
		int len1= invalidCouponTitle.length();
		log.info("Entered title is :"+ invalidCouponTitle+"\nThe length of the entered title is:"+len1);
		
		int len2= home.couponContentInvalidTitleValidation(invalidCouponTitle);
		if (len2!= len1){
		   if(len2<=40){
			   System.out.println("Validation proves title field does not accept more than 40 characters");
			   home.couponContentEmptyTitleValidation(emptyCouponTitle);
			   log.info("Validation proves that title field cannot be left empty");
			   
			   {
			   		log.info("In Coupon Content section entering a coupon description which has more than 40 characters");
				
			   		int len3= invalidCouponTitle.length();
			   		log.info("Entered coupon desc is :"+ invalidCouponTitle+"\nThe length of the entered coupon description is:"+len3);
				
			   		int len4= home.couponContentInvalidDescValidation(invalidCouponDesc,couponTitle);
			   		if (len3!= len4){
			 		   if(len4<=40){
			 			   System.out.println("Validation proves coupon description field does not accept more than 40 characters");
			 			   home.couponContentEmptyDescValidation(emptyCouponDesc);
			 			   log.info("Validation proves that coupon description field cannot be left empty");
			 		   }
			 		   
			 		   else{
						   System.out.println("Coupon Description field accepts more than 40 characters");
						   Assert.fail();
					   }
			   		}		
			   }	   
		   }
		   else{
			   System.out.println("Title field accepts more than 40 characters");
			   Assert.fail();
		   }
			   
		}
		log.info("Title Field Validation successful");
		Thread.sleep(3000);		
		
	}
	
}