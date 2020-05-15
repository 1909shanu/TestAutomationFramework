package com.amazon.qa.Pages;

import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.basetest.TestBase;

public class CartPage extends TestBase{
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}

	
	public String cartPageTitleTest() {
		return driver.getTitle();
	}
}
