package com.purchase.pagefactory;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public String parentWinow;

	public loginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}
	
	@FindBy(xpath ="//a[@href='http://automationpractice.com/index.php?controller=my-account' and @class='login']")
	WebElement signin;
	
	@FindBy(css ="#email")
	WebElement emailAdrs;
	
	@FindBy(css ="#passwd")
	WebElement password;
	
	@FindBy(xpath ="//i[@class='icon-lock left']")
	WebElement submit;
	
	public void Signin() throws Exception {
		
		parentWinow = driver.getWindowHandle();
		//System.out.println("parentwindow1: "+parentWinow);
		
		wait.until(ExpectedConditions.elementToBeClickable(signin));
		Thread.sleep(4000);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", signin);
	}
	
	public WebElement EmailAddress() throws Exception {
		
		WebElement element2 = driver.findElement(By.cssSelector("#email"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element2);
		Thread.sleep(2000);
		
		return emailAdrs;
	}
	
	public WebElement Password() throws Exception {
		
		return password;
	}
	
	public void Submit() throws Exception {
		
		Thread.sleep(2000);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
	}
	
	public void windowhandle() {
		
		Set<String> window = driver.getWindowHandles();
		
		//int numberOfWindows = window.size();
		
		//System.out.println("Count"+numberOfWindows);


	    for (String winHandle : driver.getWindowHandles()) {
	    	
	    	if(winHandle.equalsIgnoreCase(parentWinow)) {
	    		
	    		//System.out.println("Window"+parentWinow);
		        driver.switchTo().window(parentWinow);
	    	}
	    	else {
	    		
	    		//System.out.println("Window"+winHandle);
		        driver.switchTo().window(winHandle);
		        driver.close();
	    		
	    	}

	    }
	      
		driver.switchTo().defaultContent();
		
	}
	
	

}
