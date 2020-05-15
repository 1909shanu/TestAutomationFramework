package com.amazon.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.basetest.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[contains(text(),'Hello, Sudhanshu')]")
	WebElement nameLabel;
	
	@FindBy(id ="nav-cart")
	WebElement cartIcon;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchText;
	
	@FindBy(xpath="//input[@type='submit' and @class='nav-input']")
	WebElement magnifyingGlass;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String titleTest() {
		return driver.getTitle();
	}
	
	public Boolean validateNameLabel() {
		Boolean label = nameLabel.isDisplayed();
		return label;
	}
	
	public SearchPage validateSearchPage(String search) {
		searchText.sendKeys(search);
		magnifyingGlass.click();
		return new SearchPage();
	}
	
	public CartPage validateCartPage() {
		cartIcon.click();
		return new CartPage();
	}

}
