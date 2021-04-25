package com.purchase.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductHomePage {
	
	WebDriver driver;
	WebDriverWait wait;

	public ProductHomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}
	
	@FindBy(xpath ="//a[@class='logout']")
	WebElement signout;
	
	@FindBy(xpath ="//body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")
	WebElement dresses;
	
	@FindBy(xpath ="//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")
	WebElement casualDress;
	
	@FindBy(xpath ="//img[@alt='Printed Dress']")
	WebElement printedDress;
	
	@FindBy(xpath ="//a[@title='View']")
	WebElement more;
	
	public WebElement SignOut() throws Exception {
		
		return signout;
	}
	
	public WebElement Dresses() throws Exception {
		
		wait.until(ExpectedConditions.elementToBeClickable(dresses));
		
		return dresses;
	}
	
	public WebElement CasualDress() throws Exception {
		
		wait.until(ExpectedConditions.elementToBeClickable(casualDress));
		return casualDress;
	}
	
	public void PrintedDress() throws Exception {
		
		wait.until(ExpectedConditions.elementToBeClickable(printedDress));
		
		WebElement element2 = driver.findElement(By.xpath("//img[@alt='Printed Dress']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element2);
		Thread.sleep(2000);
		
		Actions action = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//img[@alt='Printed Dress']"));
		action.moveToElement(mainMenu).moveToElement(driver.findElement(By.xpath("//a[@title='View']"))).click().build().perform();
		
	}
	
	

}
