package com.test.regression.eDeals.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.regression.eDeals.utils.Logg;
import com.test.regression.eDeals.utils.SuiteBase;

public class Create extends SuiteBase{
	
	WebDriver _driver;
	
	Logger log = Logg.createLogger();
	
	public Create(WebDriver driver) {
		super();
		_driver=driver;
		PageFactory.initElements(_driver, this);
	}

	
	@FindBy(xpath = "(//a[text()='LOGIN'])")
	private WebElement _LoginButtonHome;
	
	@FindBy(xpath = "(//input[@name='USER'])")
	private WebElement _userName;
	
	@FindBy(xpath = "(//input[@name='PASSWORD'])")
	private WebElement _password;

	@FindBy(xpath = "(//a[@href='https://wwwtest.svharbor.com/svcportal/home.jsf?portal=ism']/p)")
	private WebElement _svuIndependent;
	
	@FindBy(xpath = "(//*[@id='9'])")
	private WebElement _vendorDeals;
	
	@FindBy(xpath = "(//*[@id='pageMenu']/dd[16]/div[1]/a)")
	private WebElement _create;
	
	@FindBy(xpath = "(//*[@id='inputContractID'])")
	private WebElement _vndContractID;
	
	@FindBy(xpath = "(//*[@id='dealDescription'])")
	private WebElement _dealDescription;
	
	@FindBy(xpath = "(//*[@id='organizations:5'])")
	private WebElement _organization;
	
	@FindBy(xpath = "(//*[@id='banners:15'])")
	private WebElement _banners;
	
	@FindBy(xpath = "(//*[@id='nextButton']/span)")
	private WebElement _NxtStep;
	
	@FindBy(name = "dealDetailsTable:0:dealType")
	private WebElement _dealTypeDD;
	
	@FindBy(name = "dealDetailsTable:0:fromDate")
	private WebElement _dealBeginDt;
	
	@FindBy(name = "dealDetailsTable:0:toDate")
	private WebElement _dealEndDt;
	
	@FindBy(xpath = "//*[@id='hasCoupon:0']")
	private WebElement _couponReqd;
	
	@FindBy(xpath = "//*[@id='couponDistribution']/option[2]")
	private WebElement _couponDist;
	
	@FindBy(xpath = "//*[@id='couponType']")
	private WebElement _couponType;
	
	//@FindBy(xpath = "//*[@id='couponType']/option[6] - value = 'L'")
	//private WebElement _couponTypeSelect;
	
	@FindBy(xpath = "//*[@id='redeemAmount']")
	private WebElement _amount;
	
	@FindBy(xpath = "//*[@id='mustBuyQty']")
	private WebElement _mustBuyQty;
	
	@FindBy(xpath = "//*[@id='consumerLimitQty']")
	private WebElement _consumerLimitQty;
	
	@FindBy(xpath = "//*[@id='clipLimitQty']")
	private WebElement _clipLimitQty;
	
	@FindBy(xpath = "//*[@id='processCode']")
	private WebElement _processCode;
	
	@FindBy(xpath = "//*[@id='pluCode']")
	private WebElement _pluCode;
	
	@FindBy(xpath = "//*[@id='manufacturersCd']")
	private WebElement _manufacturerCode;
	
	@FindBy(xpath = "//*[@id='couponUPC']")
	private WebElement _couponUPC;
	
	@FindBy(xpath = "//*[@id='couponTitle']")
	private WebElement _couponTitle;
	
	@FindBy(xpath = "//*[@id='couponDesc']")
	private WebElement _couponDesc;
	
	@FindBy(xpath = "//*[@id='couponAdditionalDesc']")
	private WebElement _couponAddDesc;
	
	@FindBy(xpath = "//*[@id='couponDetails']")
	private WebElement _couponDetails;
	
	@FindBy(xpath = "//*[@id='couponBeginDate']")
	private WebElement _couponBegDt;
	
	@FindBy(xpath = "//*[@id='couponEndDate']")
	private WebElement _couponEndDt;
	
	@FindBy(xpath = "//*[@id='addrLink']")
	private WebElement _addrLink;
	
	@FindBy(xpath = "//*[@id='redemptionName']")
	private WebElement _addrSearch;
	
	@FindBy(xpath = "//*[@id='goButton']/span")
	private WebElement _searchButton;
	
	@FindBy(xpath = "//*[@id='radioBtn:7']")
	private WebElement _addrInfo;
	
	@FindBy(xpath = "//*[@id='selectButton']/label")
	private WebElement _addButton;
	
	@FindBy(xpath = "//*[@id='redemptionInfo']")
	private WebElement _redemInfo;
		
	@FindBy(xpath = "//*[@id='okButton']")
	private WebElement _okButton;
	
	@FindBy(xpath = "//*[@id='itemGroupNm']")
	private WebElement _itemGrpNm;
	
	@FindBy(xpath = "//*[@id='searchButton']/span")
	private WebElement _searchBtn;
	
	@FindBy(xpath = "//*[@id='checkBox1:0']")
	private WebElement _chkBox1;
	
	@FindBy(xpath = "//*[@id='checkBox1:2']")
	private WebElement _chkBox2;
	
	@FindBy(xpath = "//div[@id='getItems']/a[@id='getItemsButton']/span")
	private WebElement _getItemsBtn;
	
	@FindBy(xpath = "//*[@id='selectButtonTop']/span")
	private WebElement _addSelectBtnTop;
	
	@FindBy(xpath = "//*[@id='itemDetailsTable:0:j_idt222:0_0:allAmt1']")
	private WebElement _dealAmt;
	
	@FindBy(xpath = "//*[@id='itemDetailsTable:0:j_idt222:0_0:floodIcon']")
	private WebElement _floodIcon;
	
	@FindBy(xpath = "//*[@id='saveButton']/span")
	private WebElement _saveBtn;
	
	@FindBy(xpath = "//*[@id='creatorComment']")
	private WebElement _creatorComment;
	
	@FindBy(xpath = ".//*[@id='termsconditions']")
	private WebElement _termsCndtn;
	
	@FindBy(xpath = "//*[@id='submitButton']/span")
	private WebElement _submitBtn;
	
	@FindBy(xpath = "//*[@id='topLinks']/ul/li[4]/a")
	private WebElement _logout;
	
	@FindBy(xpath = "//*[@id='LOButton']")
	private WebElement _logoutPopup;
	
	//Negative Validation Xpath
	
	@FindBy(xpath = "//*[@id='status']/li")
	private WebElement _errorMessage;
	
	public void clickLogin(){
		
		waitFor(_LoginButtonHome);
		_LoginButtonHome.click();
	}
	
	public void enterLoginDetails(String username, String password){
		
		waitFor(_userName);
		_userName.sendKeys(username);
		
		waitFor(_password);
		_password.sendKeys(password);
		
		_password.sendKeys(Keys.ENTER);
					
	}
	
	public void clickSVUIndependent(){
		waitFor(_svuIndependent);
		_svuIndependent.click();
	}
	
	public void clickVendorDeals(){
		waitFor(_vendorDeals);
		_vendorDeals.click();
	}
	
	public void clickCreate(){
		waitFor(_create);
		_create.click();
	}
	
	public void enterDealDetails(String vndContractID, String dealDscrptn) throws InterruptedException{
		
		waitFor(_vndContractID);
		_vndContractID.sendKeys(vndContractID);
		Thread.sleep(3000);
		
		waitFor(_dealDescription);
		_dealDescription.sendKeys(dealDscrptn);
		Thread.sleep(3000);
		
		waitFor(_organization);
		_organization.click();
		Thread.sleep(3000);
		
		waitFor(_banners);
		_banners.click();
		Thread.sleep(3000);
		
		waitFor(_NxtStep);
		_NxtStep.click();
		Thread.sleep(5000);
	}
	
	public void selectDealType(String beginDate, String endDate) throws InterruptedException{
		
		waitFor(_dealTypeDD);
		
		Select sel = new Select(_dealTypeDD);
		sel.selectByIndex(1);
		Thread.sleep(5000);
		
		waitFor(_dealBeginDt);
		_dealBeginDt.sendKeys(beginDate);
		Thread.sleep(3000);
		
		waitFor(_dealEndDt);
		_dealEndDt.sendKeys(endDate);
		Thread.sleep(3000);
	}
	
	public void selectCouponType() throws InterruptedException{
		
		waitFor(_couponReqd);
		_couponReqd.click();
		Thread.sleep(3000);
		
		waitFor(_couponDist);
		_couponDist.click();
		Thread.sleep(5000);
		
		waitFor(_couponType);
		
		Select sel = new Select(_couponType);
		sel.selectByVisibleText("Loyalty");
		Thread.sleep(5000);
	}
	
	public void couponExecution(String amount, String mustBuyQty, String consLmtQty, String clipLmt, String processCd, String pluCd, String manufacturerCd, String couponUPC) throws InterruptedException{
		
		waitFor(_amount);
		_amount.sendKeys(amount);
		Thread.sleep(3000);
		
		waitFor(_mustBuyQty);
		_mustBuyQty.sendKeys(mustBuyQty);
		Thread.sleep(3000);
		
		waitFor(_consumerLimitQty);
		_consumerLimitQty.sendKeys(consLmtQty);
		Thread.sleep(3000);
		
		waitFor(_clipLimitQty);
		_clipLimitQty.sendKeys(clipLmt);
		Thread.sleep(3000);
		
		waitFor(_processCode);
		_processCode.sendKeys(processCd);
		Thread.sleep(3000);
		
		waitFor(_pluCode);
		_pluCode.sendKeys(pluCd);
		Thread.sleep(3000);
		
		waitFor(_manufacturerCode);
		_manufacturerCode.sendKeys(manufacturerCd);
		Thread.sleep(3000);
		
		waitFor(_couponUPC);
		_couponUPC.sendKeys(couponUPC);
		Thread.sleep(3000);
	}
	
	public void couponContent(String couponTitle, String couponDesc, String couponAddDesc, String couponDtls, String couponBegDt, String couponEndDt) throws InterruptedException{
		
		waitFor(_couponTitle);
		_couponTitle.sendKeys(couponTitle);
		Thread.sleep(3000);
		
		waitFor(_couponDesc);			
		_couponDesc.clear();
		_couponDesc.sendKeys(couponDesc);
		Thread.sleep(3000);
		
		waitFor(_couponAddDesc);
		_couponAddDesc.sendKeys(couponAddDesc);
		Thread.sleep(3000);
		
		waitFor(_couponDetails);
		_couponDetails.sendKeys(couponDtls);
		Thread.sleep(3000);
		
		waitFor(_couponBegDt);
		_couponBegDt.sendKeys(couponBegDt);
		Thread.sleep(3000);
		
		waitFor(_couponEndDt);
		_couponEndDt.sendKeys(couponEndDt);
		Thread.sleep(3000);
	}
	
	public void optionalCouponDetails(String addrSearch, String redemInfo) throws InterruptedException{
		
		waitFor(_addrLink);
		_addrLink.click();
		Thread.sleep(3000);
		
		waitFor(_addrSearch);
		_addrSearch.sendKeys(addrSearch);
		Thread.sleep(3000);
		
		waitFor(_searchButton);
		_searchButton.click();
		Thread.sleep(3000);
		
		waitFor(_addrInfo);
		_addrInfo.click();
		Thread.sleep(3000);
		
		waitFor(_addButton);
		_addButton.click();
		Thread.sleep(3000);
		
		waitFor(_redemInfo);
		_redemInfo.sendKeys(redemInfo);
		Thread.sleep(3000);
		
		waitFor(_NxtStep);
		_NxtStep.click();
		Thread.sleep(5000);
		
		waitFor(_okButton);
		_okButton.click();
		Thread.sleep(5000);
	}
	
	public void enterItems(String itemGrpName, String dealAmount) throws InterruptedException{
		
		waitFor(_itemGrpNm);
		_itemGrpNm.sendKeys(itemGrpName);
		Thread.sleep(3000);
		
		waitFor(_searchBtn);
		_searchBtn.click();
		Thread.sleep(10000);
		
		waitFor(_chkBox1);
		_chkBox1.click();
		Thread.sleep(3000);
		
		waitFor(_chkBox2);
		_chkBox2.click();
		Thread.sleep(3000);
		
		waitFor(_getItemsBtn);
		_getItemsBtn.click();
		Thread.sleep(3000);
		
		waitFor(_addSelectBtnTop);
		_addSelectBtnTop.click();
		Thread.sleep(3000);
		
		waitFor(_dealAmt);
		_dealAmt.sendKeys(dealAmount);
		Thread.sleep(3000);
		
		waitFor(_floodIcon);
		_floodIcon.click();
		Thread.sleep(3000);
		
		waitFor(_saveBtn);
		_saveBtn.click();
		Thread.sleep(3000);
		
		waitFor(_NxtStep);
		_NxtStep.click();
		Thread.sleep(3000);	
	}
	
	public void reviewMarketDeals() throws InterruptedException{
		
		waitFor(_NxtStep);
		_NxtStep.click();
		Thread.sleep(3000);
	}
	
	public void auditMarketDeals() throws InterruptedException{
		
		waitFor(_NxtStep);
		_NxtStep.click();
		Thread.sleep(3000);
	}
	
	public void dealSummary(String creatorCmnt) throws InterruptedException{
		
		waitFor(_creatorComment);
		_creatorComment.sendKeys(creatorCmnt);
		Thread.sleep(3000);
		
		waitFor(_termsCndtn);
		_termsCndtn.click();
		Thread.sleep(3000);
		
		waitFor(_submitBtn);
		_submitBtn.click();
		Thread.sleep(3000);
	}
	
	public void logout() throws InterruptedException{
		
		waitFor(_logout);
		_logout.click();
		Thread.sleep(3000);
		
		waitFor(_logoutPopup);
		_logoutPopup.click();
		Thread.sleep(3000);
	}
	
	//Negative Validation // Aishwarya
	
		public int couponContentInvalidTitleValidation(String invalidCouponTitle) throws InterruptedException{
			
			waitFor(_couponTitle);
			_couponTitle.sendKeys(invalidCouponTitle);
			Thread.sleep(3000);
			
			String actualTitle = _couponTitle.getAttribute("value");		
			int len= actualTitle.length();
			
			System.out.println("Text displayed in Title Field in Application UI:"+ actualTitle+"\nThe length of the title displayed in Application UI is:"+len); 

			return len;
		}
		
	public void couponContentEmptyTitleValidation(String emptyCouponTitle) throws InterruptedException{
			
			waitFor(_couponTitle);
			_couponTitle.clear();
			_couponTitle.sendKeys(emptyCouponTitle);
			Thread.sleep(3000);
			
			waitFor(_NxtStep);
			_NxtStep.click();
			Thread.sleep(3000);
			
			waitFor(_errorMessage);
			boolean value=_errorMessage.isDisplayed();
			
			CaptureScreenShot(_driver,"Title Field Error");
			log.info("screenshot captured successfully");
			
			if(value=true){
				System.out.println("Error message: 'TITLE FIELD CANNOT BE EMPTY' is displayed succesfully");
			}
			else{
				System.out.println("No error message warning user that title field cannot be empty.");
			}
				
			Thread.sleep(3000);			
		}

	public int couponContentInvalidDescValidation(String invalidCouponDesc,String couponTitle) throws InterruptedException{
		
			waitFor(_couponTitle);
			_couponTitle.sendKeys(couponTitle);
			Thread.sleep(3000);
			
			waitFor(_couponDesc);
			_couponDesc.clear();
			_couponDesc.sendKeys(invalidCouponDesc);
			Thread.sleep(3000);
			
			String actualDesc = _couponDesc.getAttribute("value");
			System.out.println("Text displayed in Title Field in Application UI:"+ actualDesc); 
			
			int len= actualDesc.length();
			
			return len;
	}

	public void couponContentEmptyDescValidation(String emptyCouponDesc) throws InterruptedException{
		
			waitFor(_couponDesc);
			_couponDesc.clear();
			_couponDesc.sendKeys(emptyCouponDesc);
			Thread.sleep(3000);
			
			waitFor(_NxtStep);
			_NxtStep.click();
			Thread.sleep(3000);
			
			waitFor(_errorMessage);
			boolean value=_errorMessage.isDisplayed();
			
			CaptureScreenShot(_driver,"Empty Description Error");
			log.info("screenshot captured successfully");
			
			if(value=true){
				System.out.println("Error message: 'COUPON DESCRIPTION FIELD CANNOT BE EMPTY' is displayed succesfully");
			}
			else{
				System.out.println("No error message warning user that coupon description field cannot be empty.");
			}
				
			Thread.sleep(3000);			
	}
}  
