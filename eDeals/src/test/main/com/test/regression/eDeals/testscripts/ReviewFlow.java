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
		dataValidation();
		Thread.sleep(3000);
		//  here we need to call the data from the coupon pop up in UI and compare with the query result.
	CouponDetailsBean CD =dataValidation();
	
	}
	
	public CouponDetailsBean dataValidation(){
		
		String query = "select * from CID92D.DEAL_COUPON WHERE DC_MKR_PR_NBR= 1742749";
		
		ResultSet rs = con.couponData(query);
		CouponDetailsBean CD= new CouponDetailsBean(); 
		 
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
				int amount = rs.getInt("DC_COUP_RDM_AMT");
				CD.setAmount(amount);
				int multQty = rs.getInt("DC_COUP_MULT_QTY");
				CD.setMultQty(multQty);
				String manfctCdQty = rs.getString("DC_COUP_MFG_CD");
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
				String city = rs.getString("DC_RDMTN_CITY_NM");
				CD.setCity(city);
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
			}
			
		}catch(Exception e){
			
			e.printStackTrace();	
			
		}
		return (CD);
	}
}
