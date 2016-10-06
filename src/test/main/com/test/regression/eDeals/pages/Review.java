package com.test.regression.eDeals.pages;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import org.testng.asserts.SoftAssert;

import com.test.regression.eDeals.utils.SuiteBase;


public class Review extends SuiteBase{
	
	WebDriver _driver;
	SoftAssert s_Assert = new SoftAssert();
	
	public Review(WebDriver driver) {
		super();
		_driver=driver;
		PageFactory.initElements(_driver, this);
	}

	@FindBy(xpath = "//*[@id='pageMenu']/dd[16]/div[3]/a")
	private WebElement _review;
	
	@FindBy(xpath = "//input[@name='txtPromotionNbr']")
	private WebElement _promotionNbr;
	
	@FindBy(xpath = "//*[text()='Go']")
	private WebElement _goBtn;
	
	@FindBy(xpath = "//*[@id='sortableTable0']/tbody/tr/td[1]/a")
	private WebElement _searchedPromNbr;
	
	@FindBy(xpath = "//*[@id='dealCouponPopupLink']")
	private WebElement _couponPopupLink;
	
	@FindBy(xpath = "//*[@id='couponDistribution']")
	private WebElement _coupDist;
	
	@FindBy(xpath = "//*[@id='couponOwnerRadio:0']")
	private WebElement _manufacturer;
	
	@FindBy(xpath = "//*[@id='couponOwnerRadio:1']")
	private WebElement _store;
	
	@FindBy(xpath = "//*[@name='couponType']")
	private WebElement _coupType;
	
	@FindBy(xpath = "//*[@id='redeemAmount']")
	private WebElement _rdmAmount;
	
	@FindBy(xpath = "//*[@id='mustBuyQty']")
	private WebElement _mustBuyQty;
	
	@FindBy(xpath = "//*[@id='consumerLimitQty']")
	private WebElement _consLmtQty;
	
	@FindBy(xpath = "//*[@id='clipLimitQty']")
	private WebElement _clipLmtQty;
	
	@FindBy(xpath = "//*[@id='processCode']")
	private WebElement _processCd;
	
	@FindBy(xpath = "//*[@id='pluCode']")
	private WebElement _pluCd;
	
	@FindBy(xpath = "//*[@id='manufacturersCd']")
	private WebElement _manufacturerCd;
	
	@FindBy(xpath = "//*[@id='couponUPC']")
	private WebElement _coupUPC;
	
	@FindBy(xpath = "//*[@id='couponTitle']")
	private WebElement _coupTitle;
	
	@FindBy(xpath = "//*[@id='couponDesc']")
	private WebElement _coupDesc;
	
	@FindBy(xpath = "//*[@id='couponAdditionalDesc']")
	private WebElement _coupAddDesc;
	
	@FindBy(xpath = "//*[@id='couponDetails']")
	private WebElement _coupDtls;
	
	@FindBy(xpath = "//*[@id='couponBeginDate']")
	private WebElement _coupBegDt;
	
	@FindBy(xpath = "//*[@id='couponEndDate']")
	private WebElement _coupEndDt;
	
	@FindBy(xpath = "//*[@id='termsAndConditions']")
	private WebElement _termsNCdtn;
	
	@FindBy(xpath = "//*[@id='vendorName']")
	private WebElement _vendName;
	
	@FindBy(xpath = "//*[@id='addressLine1']")
	private WebElement _addrLine1;
	
	@FindBy(xpath = "//*[@id='addressLine2']")
	private WebElement _addrLine2;
	
	@FindBy(xpath = "//*[@id='city']")
	private WebElement _city;
	
	@FindBy(xpath = "//*[@id='zipcode']")
	private WebElement _zipcode;
	
	@FindBy(xpath = "//*[@id='redemptionInfo']")
	private WebElement _rdmInfo;
	
	@FindBy(xpath = "//*[@id='popupTitle']")
	private WebElement _popupTitle;
	
	@FindBy(xpath = "//*[@id='saveCouponTxt']")
	private WebElement _saveCoupon;
	
	@FindBy(xpath = "//*[@id='topLinks']/a")
	private WebElement _closeWindow;
	
	@FindBy(xpath = "//*[@id='updateLink']/span")
	private WebElement _updateBtn;
	
	
	public void clickReview(){
		waitFor(_review);
		_review.click();
	}
	
	
	public void searchCriteria(String promotionNbr) throws InterruptedException{
		
		waitFor(_promotionNbr);
		_promotionNbr.clear();
		_promotionNbr.sendKeys(promotionNbr);
		Thread.sleep(3000);
		
		waitFor(_goBtn);
		_goBtn.click();
		Thread.sleep(3000);
	}	
	
	public void viewWorkList() throws InterruptedException{
				
		waitFor(_searchedPromNbr);
		_searchedPromNbr.click();
		Thread.sleep(3000);
	}	
	
	public void openCouponPopup() throws InterruptedException{
	
		waitFor(_couponPopupLink);
		_couponPopupLink.click();
		Thread.sleep(3000);
	}
	
	public void couponUIValidation() throws InterruptedException{
		
		waitFor(_popupTitle);
		
		String expectedTitle = "Deal Coupon Popup";
		String actualTitle = _popupTitle.getText();
		
		s_Assert.assertEquals(actualTitle, expectedTitle, "Pass");
		System.out.println("Coupon Title is verified successfully");
		
		//System.out.println("Coupon Title is invalid");
				
		waitFor(_closeWindow);
		
		String expectedCloseLink = "Close Window";
		String actualCloseLink = _closeWindow.getText();
		
		s_Assert.assertEquals(actualCloseLink, expectedCloseLink);
		System.out.println("Close Window is verified successfully");
		
		//System.out.println("Close Window is unavailable");	
		
		waitFor(_saveCoupon);
		
		String expectedSaveBtn = "Save Coupon";
		String actualSaveBtn = _saveCoupon.getText();
		
		s_Assert.assertEquals(actualSaveBtn, expectedSaveBtn);
		if(_saveCoupon.isDisplayed()){
			
			System.out.println("Save Coupon button is verified successfully");
		
		}
	}
	
	public String coupDistValidation() throws InterruptedException{
		
		waitFor(_coupDist);
		
		Select sel = new Select(_coupDist);
		String cpDist = sel.getFirstSelectedOption().getText();
		
		return cpDist;
		
	}
	
	public String coupTypeValidation() throws InterruptedException{
		
		waitFor(_coupType);
		
		Select sel = new Select(_coupType);
		String cpType = sel.getFirstSelectedOption().getText();
		
		return cpType;
		
	}
	
	public double amountValidation() throws InterruptedException{
		
		waitFor(_rdmAmount);
		String amount = _rdmAmount.getAttribute("value");
		double uiAmount = Double.valueOf(amount);
		
		return uiAmount;
		
	}
	
	public int mustBuyQtyValidation() throws InterruptedException{
		
		waitFor(_mustBuyQty);
		String mstBuyQty = _mustBuyQty.getAttribute("value");
		int mustBuyQty = Integer.parseInt(mstBuyQty);

		return mustBuyQty;
		
	}

	public int consLmtValidation() throws InterruptedException{
	
		waitFor(_consLmtQty);
		String consLmt = _consLmtQty.getAttribute("value");
		int uiConsLmt = Integer.parseInt(consLmt);
	
		return uiConsLmt;
	
	}

	public int clipLmtValidation() throws InterruptedException{
	
		waitFor(_clipLmtQty);
		String clipLmt = _clipLmtQty.getAttribute("value");
		int uiClipLmt = Integer.parseInt(clipLmt);
	
		return uiClipLmt;
	
	}
	
	public int processCodeValidation() throws InterruptedException{
		
		waitFor(_processCd);
		String processCode = _processCd.getAttribute("value");
		int uiProcessCd = Integer.parseInt(processCode);
		
		return uiProcessCd;
		
	}
	
	public int pluCodeValidation() throws InterruptedException{
		
		waitFor(_pluCd);
		String pluCode = _pluCd.getAttribute("value");
		int uiPluCode = Integer.parseInt(pluCode);
		
		return uiPluCode;
		
	}
	
	public int manuCodeValidation() throws InterruptedException{
		
		waitFor(_manufacturerCd);
		String manuCode = _manufacturerCd.getAttribute("value");
		int uiManuCode = Integer.parseInt(manuCode);
		
		return uiManuCode;
	
	}
	
	public int couponUPCValidation() throws InterruptedException{
		
		waitFor(_coupUPC);
		String couponUPC = _coupUPC.getAttribute("value");
		int uiCoupUPC = Integer.parseInt(couponUPC);
		
		return uiCoupUPC;
		
	}
	
	public String couponTitleValidation() throws InterruptedException{
		
		waitFor(_coupTitle);
		String couponTitle = _coupTitle.getAttribute("value");
		
		return couponTitle;
		
	}
	
	public String couponDescValidation() throws InterruptedException{
		
		waitFor(_coupDesc);
		String couponDesc = _coupDesc.getAttribute("value");
		
		return couponDesc;
		
	}
	
	public String couponAddDescValidation() throws InterruptedException{
		
		waitFor(_coupAddDesc);
		String coupAddDesc = _coupAddDesc.getAttribute("value");
		
		return coupAddDesc;
		
	}
	
	public String couponDetailsValidation() throws InterruptedException{
		
		waitFor(_coupDtls);
		String couponDetails = _coupDtls.getAttribute("value");
		
		return couponDetails;
		
	}
	
	public Date couponBegDtValidation() throws InterruptedException{
		
		waitFor(_coupBegDt);
		String couponBegDt = _coupBegDt.getAttribute("value");
		DateFormat format = new SimpleDateFormat("MMddyy", Locale.ENGLISH);
		Date uiCoupBegDt = null;
		try {
			
			uiCoupBegDt = (Date) format.parse(couponBegDt);
		} 
		catch (ParseException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return uiCoupBegDt;
		
	}
	
	public Date couponEndDtValidation() throws InterruptedException{
		
		waitFor(_coupEndDt);
		String couponEndDt = _coupEndDt.getAttribute("value");
		DateFormat format = new SimpleDateFormat("MMddyy", Locale.ENGLISH);
		Date uiCoupEndDt = null;
		try {
			
			uiCoupEndDt = (Date) format.parse(couponEndDt);
		} 
		catch (ParseException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return uiCoupEndDt;
		
	}
	
	public String TermsNCondtnValidation() throws InterruptedException{
		
		waitFor(_termsNCdtn);
		String TermsNCondtn = _termsNCdtn.getAttribute("value");
		
		return TermsNCondtn;
		
	}
	
	public String vendorNameValidation() throws InterruptedException{
		
		waitFor(_vendName);
		String vendorName = _vendName.getAttribute("value");
		
		return vendorName;
		
	}
	
	public String vendorAddrLine1Validation() throws InterruptedException{
		
		waitFor(_addrLine1);
		String vendAddrLine1 = _addrLine1.getAttribute("value");
		
		return vendAddrLine1;
		
	}
	
	public String vendorAddrLine2Validation() throws InterruptedException{
		
		waitFor(_addrLine2);
		String vendAddrLine2 = _addrLine2.getAttribute("value");
		
		return vendAddrLine2;
		
	}
	
	public String cityValidation() throws InterruptedException{
		
		waitFor(_city);
		String city = _city.getAttribute("value");
		String[] uiValue = city.split("/");
		String uiCity = uiValue[0];
						
		return uiCity;
		
	}

	public String stateValidation() throws InterruptedException{
		
		waitFor(_city);
		String city = _city.getAttribute("value");
		String[] uiValue = city.split("/");
		String uiState = uiValue[1];
						
		return uiState;
		
	}
	
	public String zipCodeValidation() throws InterruptedException{
		
		waitFor(_zipcode);
		String zipCode = _zipcode.getAttribute("value");
		
		return zipCode;
		
	}
	
	public String redeemInfoValidation() throws InterruptedException{
		
		waitFor(_rdmInfo);
		String redeemInfo = _rdmInfo.getAttribute("value");
		
		return redeemInfo;
		
	}
	
	public void closeCouponPopup() throws InterruptedException{
			
		waitFor(_closeWindow);
		_closeWindow.click();
		Thread.sleep(3000);
		
		waitFor(_updateBtn);
		_updateBtn.click();
		Thread.sleep(3000);
	}	
	

	@FindBy(xpath = "//*[@id='redeemAmount']")
	private WebElement _amount;
	
	@FindBy(xpath = ".//*[@id='messaging']/li")
	private WebElement _Validationmessage;
	
	@FindBy(xpath = "//*[@id='pluCode']")
	private WebElement _pluCode;
	
	@FindBy(xpath = ".//*[@id='saveCouponTxt']")
	private WebElement _popupSave;
	
	
	
	public void closeCouponPopuponly() throws InterruptedException{
		
		waitFor(_closeWindow);
		_closeWindow.click();
		Thread.sleep(3000);
		
		
	}	
	
	public  void popupSave() throws InterruptedException{
		
		waitFor(_popupSave);
		_popupSave.click();
		Thread.sleep(3000);
		
	}

	public void couponUpdatePLUcode(String PLUcode) throws InterruptedException
	{
		System.out.println("PLUcode");
		waitFor(_pluCode);
		_pluCode.clear();
		_pluCode.sendKeys(PLUcode);
		Thread.sleep(3000);
	}
	
	public void couponUpdateAmount(String Amount) throws InterruptedException
	{
		System.out.println(Amount);
		waitFor(_rdmAmount);
		_amount.clear();
		_amount.sendKeys(Amount);
		Thread.sleep(3000);
	}
	
	public String GetValidationMessage() throws InterruptedException
	{
		waitFor(_Validationmessage);
		String ValidatMessage = _Validationmessage.getAttribute("value");
		
		return ValidatMessage;
	}

	public boolean checkDisabledFields() throws InterruptedException
	{
		boolean FinalResult;
		waitFor(_amount);
		boolean amountresult=_amount.isEnabled();
		System.out.println("is amount enabled :"+amountresult);
		if(amountresult==false)
		{
			waitFor(_mustBuyQty);
			boolean mustBuyresult=_mustBuyQty.isEnabled();
			System.out.println("is must Buy field enabled :"+mustBuyresult);
				if (mustBuyresult==false)
				{
					waitFor(_consLmtQty);
					boolean conslmtQty=_consLmtQty.isEnabled();
					System.out.println("is customer limit field enabled :"+conslmtQty);
					if (conslmtQty==false)
					{
							waitFor(_clipLmtQty);
							boolean clipLmtQty=_clipLmtQty.isEnabled();
							System.out.println("is clip limit field enabled :"+clipLmtQty);
							 FinalResult=false;
					} else FinalResult=true; 
				}else FinalResult=true; 
		}else FinalResult=true; 
		//waitfor()
		return FinalResult;
	}
	
}
