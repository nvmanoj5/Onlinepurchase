package com.purchase.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage {
	
	WebDriver driver;
	WebDriverWait wait;

	public AddToCartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}
	
	@FindBy(xpath ="//span[contains(text(),'Add to cart')]")
	WebElement addToCart;
	
	@FindBy(xpath ="//span[contains(.,'Proceed to checkout')]")
	WebElement proceedtoCheckout;
	
	@FindBy(xpath ="//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(.,'Proceed to checkout')]")
	WebElement summary;
	
	@FindBy(xpath ="//button[@class='button btn btn-default button-medium']//span[contains(.,'Proceed to checkout')]")
	WebElement address;
	
	@FindBy(id ="cgv")
	WebElement shippingCheckbox;
	
	@FindBy(xpath ="//button[@class='button btn btn-default standard-checkout button-medium']//span[contains(.,'Proceed to checkout')]")
	WebElement shipping;
	
	public WebElement AddToCart() throws Exception {
		
		return addToCart;
	}
	
	public WebElement ProceedToCheckout() throws Exception {
		
		wait.until(ExpectedConditions.elementToBeClickable(proceedtoCheckout));
		Thread.sleep(4000);
		
		return proceedtoCheckout;
	}
	
	public WebElement Summary() throws Exception {
		
		WebElement element2 = driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(.,'Proceed to checkout')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element2);
		Thread.sleep(2000);
		
		return summary;
	}
	
	public WebElement Address() throws Exception {
		
		WebElement element2 = driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']//span[contains(.,'Proceed to checkout')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element2);
		Thread.sleep(2000);
		
		return address;
	}
	
	public WebElement ShippingCheckbox() throws Exception {
		
		WebElement element2 = driver.findElement(By.id("cgv"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element2);
		Thread.sleep(2000);
		
		return shippingCheckbox;
	}
	
	public WebElement Shipping() throws Exception {
		
		WebElement element2 = driver.findElement(By.xpath("//button[@class='button btn btn-default standard-checkout button-medium']//span[contains(.,'Proceed to checkout')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element2);
		Thread.sleep(2000);
		
		return shipping;
		
	}

}
