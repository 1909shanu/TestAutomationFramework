package com.amazon.qa.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.Pages.HomePage;
import com.amazon.qa.Pages.LoginPage;
import com.amazon.qa.Pages.SearchPage;
import com.amazon.qa.basetest.TestBase;

@Test
public class SearchPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	SearchPage searchPage;
	public SearchPageTest() {
		super();
	}
	

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		homePage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		searchPage=homePage.validateSearchPage(prop.getProperty("searchText"));
		
	}
	
	/*@Test (priority=1)
	public void searchImageTest() {
		searchPage.validateSearchImage();
		System.out.println("searchImage is clicked");
	}*/
	
	@Test
	public void listTest() {
		searchPage.validateSearchImage();
		searchPage.validateList();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}
