package com.test.regression.eDeals.testscripts;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.test.regression.eDeals.pages.Create;
import com.test.regression.eDeals.utils.Logg;
import com.test.regression.eDeals.utils.ReadXML;
import com.test.regression.eDeals.utils.SuiteBase;

public class CreateFlow extends SuiteBase{
	Create home;
	
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	
// Navigate to different tabs in About us page 

	@Test(priority=1,enabled=false)
	public void signIn() throws InterruptedException, XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "creator-user");
		String userId = validLogin.get("UserName");
		String password = validLogin.get("password");
		
		home = new Create(_driver);
			
		home.clickLogin();
		home.enterLoginDetails(userId, password);
		Thread.sleep(3000);
				
		String title = _driver.getTitle();
		Assert.assertEquals("SVHarbor Home", title);
	}
	
	@Test(priority=2,enabled=true)
	public void createDeal() throws InterruptedException, XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "creator-user");
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
		
		String couponTitle = validLogin.get("couponTitle");
		String couponDesc = validLogin.get("couponDesc");
		String couponAddDesc = validLogin.get("couponAddDesc");
		String couponDtls = validLogin.get("couponDtls");
		
		String couponBegDt = validLogin.get("couponBegDt");
		String couponEndDt = validLogin.get("couponEndDt");
		
		String addrSearch = validLogin.get("addrSearch");
		String redemInfo = validLogin.get("redemInfo");
		
		String itemGrpNm = validLogin.get("itemGrpName");
		String dealAmt = validLogin.get("dealAmount");
		
		String creatorComnt = validLogin.get("creatorCmnt");
		
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
		
		home.couponContent(couponTitle, couponDesc, couponAddDesc, couponDtls, couponBegDt, couponEndDt);
		log.info("Coupon Content details are entered successfully");
		Thread.sleep(3000);
		
		home.optionalCouponDetails(addrSearch, redemInfo);
		log.info("Optional Coupon details are entered successfully");
		Thread.sleep(3000);
		
		log.info("Navigated to Enter Items page successfully");
		home.enterItems(itemGrpNm, dealAmt);
		log.info("Items are entered successfully");
		Thread.sleep(3000);
		
		log.info("Navigated to Review Market Deals page successfully");
		home.reviewMarketDeals();
		Thread.sleep(3000);
		
		log.info("Navigated to Audit Market Deals page successfully");
		home.auditMarketDeals();
		Thread.sleep(3000);
		
		log.info("Navigated to Deal Summary page successfully");
		home.dealSummary(creatorComnt);
		Thread.sleep(3000);
		
		log.info("Submitted Deal successfully");
		home.logout();
		log.info("User" +userId+ " logged out of the application successfully");
		Thread.sleep(3000);
	}
}
	
	
	

