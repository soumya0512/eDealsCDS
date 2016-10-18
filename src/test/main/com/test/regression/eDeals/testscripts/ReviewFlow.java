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

public class ReviewFlow extends SuiteBase{

	Create home;	
	Review homeR;
		
	Logger log = Logg.createLogger();
	ReadXML readxml = new ReadXML();
	
	DB2Connection con;
	
	
	@Test(priority=1,enabled=true)
	public void reviewDeal() throws InterruptedException, XPathExpressionException, ParserConfigurationException, SAXException, IOException
	{
		Map<String, String> validLogin = readxml.getUserData("TestData.xml", "approver-user");
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
		
		//  here we need to call the data from the coupon pop up in UI and compare with the query result.
		dataValidation();
		Thread.sleep(3000);
		
		homeR.closeCouponPopup();
		Thread.sleep(3000);
		
		home.logout();
		Thread.sleep(3000);
	}
	
	public void dataValidation() throws InterruptedException, XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		
		homeR = new Review(_driver);

		con = new DB2Connection();
		
		String query = "select * from CID92D.DEAL_COUPON WHERE DC_MKR_PR_NBR= 1742553";
		
		con.setUp();
		ResultSet rs = con.couponData(query);
		CouponDetailsBean CD = new CouponDetailsBean(); 
		 
		try{
			
			while(rs.next()){
				int locKey = rs.getInt("DC_MKR_LOC_KEY");
				CD.setLocKey(locKey);
				
				int promNbr = rs.getInt("DC_MKR_PR_NBR");
				CD.setPromNbr(promNbr);
				
				Date coupBegDt = rs.getDate("DC_COUP_BEG_DT");
				CD.setCoupBegDt(coupBegDt);
				
				Date coupEndDt = rs.getDate("DC_COUP_END_DT");
				CD.setCoupEndDt(coupEndDt);
				
				String coupType = rs.getString("DC_COUP_TYP_CD");
				CD.setCoupType(coupType);
				
				double amount = rs.getDouble("DC_COUP_RDM_AMT");
				CD.setAmount(amount);
				
				int multQty = rs.getInt("DC_COUP_MULT_QTY");
				CD.setMultQty(multQty);
				
				int manfctCdQty = rs.getInt("DC_COUP_MFG_CD");
				CD.setManfctCdQty(manfctCdQty);
				
				int coupUPC = rs.getInt("DC_COUP_UPC_CD");
				CD.setCoupUPC(coupUPC);
				
				int coupPLU = rs.getInt("DC_COUP_PLU_CD");
				CD.setCoupPLU(coupPLU);
				
				int processCd = rs.getInt("DC_PROCESS_CD");
				CD.setProcessCd(processCd);
				
				String name = rs.getString("DC_RDMTN_NM");
				CD.setName(name);
				
				String addr1 = rs.getString("DC_RDMTN_LN1_ADDR");
				CD.setAddr1(addr1);
				
				String addr2 = rs.getString("DC_RDMTN_LN2_ADDR");
				CD.setAddr2(addr2);
				
				String city1 = rs.getString("DC_RDMTN_CITY_NM");
				CD.setCity(city1);
				
				String city2 = rs.getString("DC_RDMTN_ST_CD");
				CD.setCity(city2);
				
				String state = rs.getString("DC_RDMTN_ST_CD");
				CD.setState(state);
				
				String postalCd = rs.getString("DC_RDMTN_PSTL_CD");
				CD.setPostalCd(postalCd);
				
				String user = rs.getString("DC_UPDT_USR_ID");
				CD.setUser(user);
				
				String timestamp = rs.getString("DC_UPDT_TS");
				CD.setTimestamp(timestamp);
				
				String text = rs.getString("DC_COUP_RDMTN_TXT");
				CD.setText(text);
				
				int coupFlag = rs.getInt("DC_STORE_COUP_FL");
				CD.setCoupFlag(coupFlag);
				
				String distCd = rs.getString("DC_COUP_DIST_CD");
				CD.setDistCd(distCd);
				
				int srpMult = rs.getInt("DC_COUP_SRP_MULT");
				CD.setSrpMult(srpMult);
				
				int srpAmt = rs.getInt("DC_COUP_SRP_AMT");
				CD.setSrpAmt(srpAmt);
				
				int percent = rs.getInt("DC_COUP_PCT_OFF");
				CD.setPercent(percent);
				
				int mustBuyQty = rs.getInt("DC_MUST_BUY_QTY");
				CD.setMustBuyQty(mustBuyQty);
				
				int clipLmtQty = rs.getInt("DC_CLIP_LMT_QTY");
				CD.setClipLmtQty(clipLmtQty);
				
				String title = rs.getString("DC_COUP_TITLE");
				CD.setTitle(title);
				
				String desc = rs.getString("DC_COUP_DESC");
				CD.setDesc(desc);
				
				String addDesc = rs.getString("DC_COUP_ADDL_DESC");
				CD.setAddDesc(addDesc);
				
				String details = rs.getString("DC_COUP_DTLS_TXT");
				CD.setDetails(details);
				
				String imgUrl = rs.getString("DC_COUP_IMG_URL");
				CD.setImgUrl(imgUrl);
				
				String termsNCdtn = rs.getString("DC_COUP_TERMS_TXT");
				CD.setTermsNCdtn(termsNCdtn);
				
				Date endTS = rs.getDate("DC_COUP_FRC_END_TS");
				CD.setEndTS(endTS);
				
				
				String uiCPType = homeR.coupTypeValidation();
				//if(uiCPType.equals(coupType)){
				
				switch(coupType){
					case "B" :
						System.out.println("Coupon Type selected is: " +uiCPType);
						break;
						
					case "C" :
						System.out.println("Coupon Type selected is: " +uiCPType);
						break;
						
					case "E" :
						System.out.println("Coupon Type selected is: " +uiCPType);
						break;
						
					case "F" :
						System.out.println("Coupon Type selected is: " +uiCPType);
						break;
						
					case "G" :
						System.out.println("Coupon Type selected is: " +uiCPType);
						break;
						
					case "H" :
						System.out.println("Coupon Type selected is: " +uiCPType);
						break;
						
					case "L" :
						System.out.println("Coupon Type selected is: " +uiCPType);
						break;
						
					case "N" :
						System.out.println("Coupon Type selected is: " +uiCPType);
						break;
						
					case "P" :
						System.out.println("Coupon Type selected is: " +uiCPType);
						break;
						
					case "R" :
						System.out.println("Coupon Type selected is: " +uiCPType);
						break;
						
					case "S" :
						System.out.println("Coupon Type selected is: " +uiCPType);
						break;
						
					case "T" :
						System.out.println("Coupon Type selected is: " +uiCPType);
						break;
						
					case "V" :
						System.out.println("Coupon Type selected is: " +uiCPType);
						break;
						
					case "W" :
						System.out.println("Coupon Type selected is: " +uiCPType);
						break;
						
					case "X" :
						System.out.println("Coupon Type selected is: " +uiCPType);
						break;
						
					case "Y" :
						System.out.println("Coupon Type selected is: " +uiCPType);
						break;
						
					case "Z" :
						System.out.println("Coupon Type selected is: " +uiCPType);
						break;	
				}
								
				
				double uiAmt = homeR.amountValidation();		
				try{
					
					if(uiAmt == amount){
					System.out.println("Amount given is: " +uiAmt);
					}
				else{
					System.out.println("Amount is mismatched");					
					}
				}catch(NumberFormatException e){
					System.out.println("Invalid number found");
					System.out.println("DB Amount: " +amount);
					System.out.println("UI Amount: " +uiAmt);
					System.out.println(e.getMessage());
				}
				
				
				int uiMustBuyQty = homeR.mustBuyQtyValidation();
				 
				if(uiMustBuyQty == mustBuyQty){
					System.out.println("Must Buy Quantity given is: " +uiMustBuyQty);
				}
				else{
					System.out.println("Must Buy Quantity is mismatched");					
				}
				
				
				int uiConsLmt = homeR.consLmtValidation();
				if(uiConsLmt == multQty){
					System.out.println("Consumer Limit given is: " +uiConsLmt);
				}
				else{
					System.out.println("Consumer Limit is mismatched");					
				}
				
				
				int uiClipLmt = homeR.clipLmtValidation();
				if(uiClipLmt == clipLmtQty){
					System.out.println("Clip Limit given is: " +uiClipLmt);
				}
				else{
					System.out.println("Clip Limit is mismatched");					
				}
				
				
				int uiProcessCd = homeR.processCodeValidation();
				if(uiProcessCd == processCd){
					System.out.println("Process Code given is: " +uiProcessCd);
				}
				else{
					System.out.println("Process Code is mismatched");					
				}
				
				
				int uiPluCode = homeR.pluCodeValidation();
				if(uiPluCode == coupPLU){
					System.out.println("PLU Code given is: " +uiPluCode);
				}
				else{
					System.out.println("PLU Code is mismatched");					
				}
				
				
				int uiManCd = homeR.manuCodeValidation();
				if(uiManCd == manfctCdQty){
					System.out.println("Manufacturer Code given is: " +uiManCd);
				}
				else{
					System.out.println("Manufacturer Code is mismatched");
				}
				
				
				int uiCoupUPC = homeR.couponUPCValidation();
				if(uiCoupUPC == coupPLU){
					System.out.println("Coupon UPC given is: " +uiCoupUPC);
				}
				else{
					System.out.println("Coupon UPC is mismatched");					
				}
				
				
				String uiTitle = homeR.couponTitleValidation();
				if(uiTitle.equals(title)){
					System.out.println("Title given is: " +uiTitle);
				}
				else{
					System.out.println("Title is mismatched");					
				}
				
				
				String uiDesc = homeR.couponDescValidation();
				if(uiDesc.equals(desc)){
					System.out.println("Description given is: " +uiDesc);
				}
				else{
					System.out.println("Description is mismatched");
				}
				
				
				String uiAdDesc = homeR.couponAddDescValidation();
				if(uiAdDesc.equals(addDesc)){
					System.out.println("Additional description given is: " +uiAdDesc);
				}
				else{
					System.out.println("Additional description is mismatched");
				}
				
				
				String uiCoupDtls = homeR.couponDetailsValidation();
				if(uiCoupDtls.equals(details)){
					System.out.println("Coupon Details given is: " +uiCoupDtls);
				}
				else{
					System.out.println("Coupon Details is mismatched");					
				}
				
								
				java.util.Date uiCoupBegDt = homeR.couponBegDtValidation();
				if(uiCoupBegDt.equals(coupBegDt)){
					System.out.println("Coupon Begin Date given is: " +uiCoupBegDt);
				}
				else{
					System.out.println("Coupon Begin Date is mismatched");					
				}
				
				
				java.util.Date uiCoupEndDt = homeR.couponEndDtValidation();
				if(uiCoupEndDt.equals(coupEndDt)){
					System.out.println("Coupon End Date given is: " +uiCoupEndDt);
				}
				else{
					System.out.println("Coupon End Date is mismatched");					
				}
				
				
				String uiVendNm = homeR.vendorNameValidation();
				if(uiVendNm.trim().equals(name.trim())){
					System.out.println("Vendor Name given is: " +uiVendNm);
				}
				else{
					System.out.println("Vendor Name is mismatched");
				}
				
				
				String uiAddrLine1 = homeR.vendorAddrLine1Validation();
				if(uiAddrLine1.trim().equals(addr1.trim())){
					System.out.println("Address at Line 1 given is: " +uiAddrLine1);
				}
				else{
					System.out.println("Address at Line 1 is mismatched");
				}
				
								
				String uiAddrLine2 = homeR.vendorAddrLine2Validation();
				if(uiAddrLine2.trim().equals(addr2.trim())){
					System.out.println("Address at Line 2 given is: " +uiAddrLine2);
				}
				else{
					System.out.println("Address at Line 2 is mismatched");	
				}
				
				
				String uiCity = homeR.cityValidation();
				if(uiCity.equals(city1.trim())){
					System.out.println("City given is: " +uiCity);
				}
				else{
					System.out.println("City is mismatched");	
					System.out.println("UI City: " +uiCity);
					System.out.println("DB City: " +city1);
				}
				
				
				String uiState = homeR.stateValidation();
				if(uiState.equals(city2.trim())){
					System.out.println("State given is: " +uiState);
				}
				else{
					System.out.println("State is mismatched");	
					System.out.println("UI State: " +uiState);
					System.out.println("DB State: " +city2);
				}
				
				
				String uiZipCode = homeR.zipCodeValidation();
				if(uiZipCode.equals(postalCd)){
					System.out.println("Postal Code given is: " +uiZipCode);
				}
				else{
					System.out.println("Postal Code is mismatched");
				}
				
				
				String uiRdmInfo = homeR.redeemInfoValidation();
				if(uiRdmInfo.equals(text)){
					System.out.println("Redeemption Info given is: " +uiRdmInfo);
				}
				else{
					System.out.println("Redeemption Info is mismatched");					
				}
			}
			
		}catch(Exception e){
			
			e.printStackTrace();	
			
		}
		
		homeR.couponUIValidation();
		log.info("All required buttons & links are available in coupon popup");
		
		String uiCPDist = homeR.coupDistValidation();
		System.out.println("Distribution type selected is: "+uiCPDist);
			
		con.tearDown();
	}
}
