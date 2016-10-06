package com.test.regression.eDeals.utils;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.test.regression.eDeals.utils.Constant;

public class SuiteBase {	
	
	Logger log = Logg.createLogger();
	protected static WebDriver _driver;
	
	/*@BeforeSuite(alwaysRun = true)
	public void DataSetUp(){
		UpdateXML dataUpdateObj = new UpdateXML();
		dataUpdateObj.updateTestData();
	}*/
 
	@AfterMethod
	public void closeDriver(Method method)
	{
		
		_driver.quit();
		
		log.info(method.getName() + " execution Complete.............");
		
	}
	
    /*
     @AfterMethod
 	public void breakDown(ITestResult result)
 	{
 		if(result.getStatus()==ITestResult.FAILURE)
 		{
 			CaptureScreenShot(_driver, result.getName());
 			
 	}
 	}*/
   
       
   @BeforeMethod
   public void initialization(Method method) throws InterruptedException {
	   
	   
	   log.info("***************************************************************");
	   
	   log.info("Starting " + method.getName() + " ................");
	   
	   log.info("***************************************************************");
	   
    	 _driver = InitializeDriver(Constant.browser_name);
    	 	 _driver.get(Constant.URL);
    	 
    	 log.info("Launched "+ Constant.URL + " Successfully!");
         
     }

 	
 	public WebDriver InitializeDriver(String browser) throws InterruptedException {
 		 		 
 		  if(browser.equalsIgnoreCase("firefox")) {	
 			
// 			 System.setProperty("webDriver.firefox.driver", "./exeFiles/firefox.exe");
 			 
 			 _driver = new FirefoxDriver();
 			 System.out.println("Mozilla Launched Successfully!!");
 		 
 		  }
 		  
 		  else if(browser.equalsIgnoreCase("chrome")){
 			  
// 			 System.setProperty("webdriver.chrome.driver", "./exeFiles/chromedriver.exe");
 			 
 			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\ssub002\\Soumya\\Selenium\\Driver_exe\\chromedriver.exe");
 			 
 			  _driver = new ChromeDriver();
 			  System.out.println("Chrome Launched Successfully!!");
 		  }
 		  
 		  else if (browser.equalsIgnoreCase("ie")) { 


// 			DESIREDCAPABILITIES CAPABILITIESIE = DESIREDCAPABILITIES.INTERNETEXPLORER();
// 			CAPABILITIESIE.SETCAPABILITY(
// 					INTERNETEXPLORERDRIVER.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, TRUE);
// 			CAPABILITIESIE.SETCAPABILITY("NATIVEEVENTS", FALSE);
// 			CAPABILITIESIE.SETCAPABILITY("IE.ENSURECLEANSESSION", TRUE);
// 			  
// 			SYSTEM.SETPROPERTY("WEBDRIVER.IE.DRIVER","./EXEFILES/IEDRIVERSERVER.EXE");
// 				      
// 			THREAD.SLEEP(5000);
// 			  
 				  
// 			System.setProperty("webdriver.ie.driver","./exeFiles/IEDriverServer.exe");
// 			_driver = new InternetExplorerDriver(capabilitiesIE);

 			System.setProperty("webdriver.ie.driver","C:\\Users\\ssub002\\Soumya\\Selenium\\Driver_exe\\IEDriverServer.exe");
 			System.out.println("Initialized IE!!!");
 		 }
 		  
	_driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
 	_driver.manage().window().maximize();
 	
 	return _driver;
 		
 	}
    
 	// Method to capture screenshot
    public static void CaptureScreenShot(WebDriver driver,String screenshotName){
					
    	try{
    		
			TakesScreenshot tsc=(TakesScreenshot)driver;
			File source = tsc.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenShot/"+screenshotName+".png") );
			
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
			
	}  
     
     
 	public void waitFor(WebElement webElement, int sec){
		WebDriverWait wait = new WebDriverWait(getDriver(), sec);
        wait.until(ExpectedConditions.visibilityOf(webElement));
     
	}
	
 	public void waitFor(WebElement webElement){
	    waitFor(webElement, 30);
	}
	 
	public void setDriver(WebDriver driver) {
        _driver = driver;
	}

/**
* Retrieve the current WebDriver for this page.
*
* @return The selenium WebDriver instance for this page.
*/
	
	public WebDriver getDriver() {
        return _driver;
	}
 }

