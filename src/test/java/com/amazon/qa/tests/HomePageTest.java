package com.amazon.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.Pages.CartPage;
import com.amazon.qa.Pages.HomePage;
import com.amazon.qa.Pages.LoginPage;
import com.amazon.qa.Pages.SearchPage;
import com.amazon.qa.basetest.TestBase;


public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	SearchPage searchPage;
	CartPage cartPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homePagetitleTest() {
		String title = homePage.titleTest();
		Assert.assertEquals(title, "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
	}
	
	@Test(priority=2)
	public void labelTest() {
		Boolean b = homePage.validateNameLabel();
		Assert.assertTrue(b);
	}
	
	@Test(priority=3)
	public void cartPageTest() {
		cartPage=homePage.validateCartPage();
		String title = cartPage.cartPageTitleTest();
		Assert.assertEquals(title, "Amazon.com Shopping Cart");
	}
	
	@Test(priority=4)
	public void searchPageTest() {
		searchPage=homePage.validateSearchPage(prop.getProperty("searchText"));
		Assert.assertTrue(searchPage.validateLabel());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
