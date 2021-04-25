package com.purchase.stepdefinitions;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.purchase.pagefactory.AddToCartPage;
import com.purchase.pagefactory.ProductDetailPage;
import com.purchase.pagefactory.ProductHomePage;
import com.purchase.pagefactory.loginPage;
import com.purchase.utility.BrowserUtility;
import com.purchase.utility.PropertiesFileReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BrowserUtility{
	
	WebDriver driver;
	WebDriverWait wait;
	
	loginPage logInpage;
	ProductHomePage productHomepage;
	ProductDetailPage productDetailPage;
	AddToCartPage addToCartPage;
	
	String productStatus=null;
	PropertiesFileReader obj = new PropertiesFileReader();
	 
	
	@Given("Open the online purchase application")
	public void open_the_online_purchase_application() throws Exception {
		
		Properties properties = obj.getProperty();
		driver = BrowserUtility.OpenBrowser(driver, wait, properties.getProperty("browser.name"),
				properties.getProperty("browser.baseURL"));
		
		logInpage = new loginPage(driver);
		logInpage.Signin();
		waitForPageLoad(driver, wait);
		logInpage.windowhandle();
		
	}

	@When("login into the application with valid {string} username and {string} password")
	public void login_into_the_application_with_valid_username_and_password(String username, String password) throws Exception {
		
		
		logInpage.EmailAddress().sendKeys(username);
		logInpage.Password().sendKeys(password);
		logInpage.Submit();
		waitForPageLoad(driver, wait);
		logInpage.windowhandle();
		
		productHomepage = new ProductHomePage(driver);
		Assert.assertEquals(true, productHomepage.SignOut().isDisplayed());
		
	}
	
	@When("Click the dresses tab and choose the casualdresses")
	public void click_the_dresses_tab_and_choose_the_casualdresses() throws Exception {
		
		productHomepage.Dresses().click();
		waitForPageLoad(driver, wait);
		productHomepage.CasualDress().click();
		waitForPageLoad(driver, wait);
	  
	}

	@When("click more button for product details")
	public void click_more_button_for_product_details() throws Exception {
		
		productHomepage.PrintedDress();
		waitForPageLoad(driver, wait);
	}
	
	@When("Verify the product details if the product details has {string} this information")
	public void verify_the_product_details_if_the_product_details_has_this_information(String productDetails) throws Exception {
		
		productDetailPage = new ProductDetailPage(driver);
		String productDetail = productDetailPage.ProductDesc(productDetails).getText();
		
		String status=null;
		
		if(productDetail.contains(productDetails)) {
			
			status="PASS";
		}
		else
		{
			status="FAIL";
			productStatus="FAIL";
			
			System.out.println("Dress Description:"+productDetail);
		}
		
		Assert.assertEquals("PASS", status);
		
	}

	@Then("Verify the product price {string}  size {string} size1 {string} and colour {string} colour2 {string}")
	public void verify_the_product_price_size_size1_and_colour_colour2(String price, String size, String size2, String colour, String colour2) throws Exception {
	
		String productPrice = productDetailPage.Price().getText();
		String updatedPrice = productPrice.replace("$", "");
		String expPrice = price.replace("$", "");
		
		double dressPrice = Double.parseDouble(updatedPrice); 
		int roundPrice = (int)Math.round(dressPrice);
		int expDressPrice =Integer.parseInt(expPrice);  
		
		String priceStatus = null;
		
		if(roundPrice<expDressPrice) {
			
			priceStatus="PASS";
		}
		else {
			
			priceStatus="FAIL";
			productStatus="FAIL";
			System.out.println("Product Price:"+productPrice);
		}
		
		String actualSize = productDetailPage.Size().getAttribute("title");
		
		String sizeStatus = null;
		
		if(size.equalsIgnoreCase(actualSize) || size2.equalsIgnoreCase(actualSize) ) {
			
			sizeStatus="PASS";
		}
		else {
			
			sizeStatus="FAIL";
			productStatus="FAIL";
			System.out.println("Actual product size: "+actualSize);
		}
		
		String actualColour = productDetailPage.Colour().getAttribute("title");
		
		String colourStatus = null;
		
		if(colour.equalsIgnoreCase(actualColour) || colour2.equalsIgnoreCase(actualColour) ) {
			
			colourStatus="PASS";
		}
		else {
			
			colourStatus="FAIL";
			productStatus="FAIL";
			System.out.println("Actual product Colour: "+actualColour);
		}
		
		Assert.assertEquals("PASS", priceStatus);
		Assert.assertEquals("PASS", sizeStatus);
		Assert.assertEquals("PASS", colourStatus);
		
		
	
	}
	
	@Then("Purchase the dress")
	public void purchase_the_dress() throws Exception {
		
		if(!(productStatus==null)) {
			
			System.out.println("The above product criteria is not satisfied");
		}
		else {
			
			addToCartPage = new AddToCartPage(driver);
			addToCartPage.AddToCart().click();
			waitForPageLoad(driver, wait);
			addToCartPage.ProceedToCheckout().click();
			waitForPageLoad(driver, wait);
			addToCartPage.Summary().click();
			waitForPageLoad(driver, wait);
			addToCartPage.Address().click();
			waitForPageLoad(driver, wait);
			addToCartPage.ShippingCheckbox().click();
			waitForPageLoad(driver, wait);
			addToCartPage.Shipping().click();
			
			System.out.println("Product successfully purchased");
		}
		
	}


	

}
