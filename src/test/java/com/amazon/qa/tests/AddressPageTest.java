package com.amazon.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.qa.Pages.AddressPage;
import com.amazon.qa.Pages.HomePage;
import com.amazon.qa.Pages.LoginPage;
import com.amazon.qa.basetest.TestBase;
import com.amazon.qa.util.TestUtil;

public class AddressPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
    AddressPage addressPage;
    TestUtil testUtil;
    
    String sheetName="Address";
	
	public AddressPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage=new LoginPage();
		loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		addressPage = new AddressPage();
		
	}
	
	@DataProvider
	public Object[][] getAmazonTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1,dataProvider = "getAmazonTestData")
	public void addressTest(String fName, String addLine, String city) throws InterruptedException {
		addressPage.validateAddAddress(fName, addLine, city);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
