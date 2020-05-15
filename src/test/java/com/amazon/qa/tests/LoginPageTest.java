package com.amazon.qa.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.Pages.HomePage;
import com.amazon.qa.Pages.LoginPage;
import com.amazon.qa.basetest.TestBase;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();    
		
	}
	
	@Test (priority=1)
	public void titleTest() {
		String title  = loginPage.validateTitle();
		Assert.assertEquals(title, "Amazon Sign-In");
	}
	
	@Test(priority=2)
	public void logoTest() {
		Boolean logo = loginPage.validatLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
