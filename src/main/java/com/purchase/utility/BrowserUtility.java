package com.purchase.utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtility {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	
	static String sysprojectpath = System.getProperty("user.dir");

	public static WebDriver OpenBrowser(WebDriver driver, WebDriverWait wait, String browserName, String url) throws InterruptedException {
		if (browserName.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver",sysprojectpath + "\\src\\main\\java\\resources\\drivers\\chromedriver.exe");
			
		    ChromeOptions options  = new ChromeOptions();
		    //options.addArguments("incognito");
		    options.addArguments("--disable-popup-blocking");
		    DesiredCapabilities capabilities = new DesiredCapabilities();
		    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		    driver = new ChromeDriver(capabilities);
			driver.manage().window().maximize();
			driver.get(url);
			waitForPageLoad(driver, wait);
			//Thread.sleep(5000);
			return driver;

		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					sysprojectpath + "//src//test//resources//drivers//IEDriverServer.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			// DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "accept");
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability("ignoreZoomSetting", true);
			capabilities.setCapability("requireWindowFocus", true);// to move mouse manually
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();
			driver.get(url);
			return driver;

		} else if (browserName.equals("Firefox")) {

			System.setProperty("webdriver.gecko.driver",sysprojectpath + "//src//main//java//resources//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);
			return driver;
		}
		return null;
	}
	
	 public static void waitForPageLoad(WebDriver driver, WebDriverWait wait)
	 {
		  
	  	wait = new WebDriverWait(driver, 450);
	  	ExpectedCondition<Boolean> pageLoaded = new ExpectedCondition<Boolean>() 
	  	{
	  		public Boolean apply(WebDriver input)
	  		{
	  			return ((JavascriptExecutor) input).executeScript("return document.readyState").equals("complete");
	  		}
	  	};
	  	wait.until(pageLoaded);
	  	      //System.out.println("Page loaded completely");
	  }



}
