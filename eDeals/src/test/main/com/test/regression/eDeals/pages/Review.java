package com.test.regression.eDeals.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.regression.eDeals.utils.SuiteBase;

public class Review extends SuiteBase{
	
	WebDriver _driver;
	
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
	
	public void closeCouponPopup() throws InterruptedException{
			
		waitFor(_closeWindow);
		_closeWindow.click();
		Thread.sleep(3000);
		
		waitFor(_updateBtn);
		_updateBtn.click();
		Thread.sleep(3000);
	}	
	
}
