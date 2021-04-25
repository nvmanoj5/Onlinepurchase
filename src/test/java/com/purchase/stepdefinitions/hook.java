package com.purchase.stepdefinitions;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.purchase.utility.BrowserUtility;
import com.purchase.utility.PropertiesFileReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hook extends BrowserUtility {

	
	
	//public BrowserUtility base;
	  
	 
	/*
	 * public hook(BrowserUtility base) { this.base=base; }
	 */

	@Before
	public void startup() throws Exception {
		System.out.println("Test execution started");

		
	}

	
	
	/*
	 * @After public void teardown() {
	 * 
	 * driver.close(); driver.quit(); }
	 */
	 

}
