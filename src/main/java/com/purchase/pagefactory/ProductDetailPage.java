package com.purchase.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public String productStatus=null;
	public String descStatus=null;
	
	public ProductDetailPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}
	
	@FindBy(id ="short_description_content")
	WebElement productdesc;
	
	@FindBy(id ="our_price_display")
	WebElement price;
	
	@FindBy(xpath ="//select//option[@selected='selected']")
	WebElement size;
	
	@FindBy(xpath ="//a[@class='color_pick selected']")
	WebElement colour;
	
	public WebElement ProductDesc(String productDetails) throws Exception {
		
		wait.until(ExpectedConditions.elementToBeClickable(productdesc));
		
		String productDetail = productdesc.getText();
		
		
		if(productDetail.contains(productDetails)) {
			
			descStatus="PASS";
		}
		else
		{
			descStatus="FAIL";
			productStatus="FAIL";
			
			System.out.println("Dress Description:"+productDetail);
		}
		
		return productdesc;
		
	}
	
	public WebElement Price() throws Exception {
		
		return price;
	}
	
	public WebElement Size() throws Exception {
		
		return size;
	}
	
	public WebElement Colour() throws Exception {
		
		return colour;
	}


}
