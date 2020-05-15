package com.amazon.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.basetest.TestBase;

public class AddressPage extends TestBase{
	
	@FindBy(id="nav-link-accountList")
	@CacheLookup               //store in cache and increase speed
	WebElement accountLink;
	
	@FindBy(linkText="Your addresses")
	WebElement yourAddressLink;
	
	
	@FindBy(id="ya-myab-plus-address-icon")
	WebElement addAddress;
	
	@FindBy(name="address-ui-widgets-enterAddressFullName")
	WebElement fullName;
	
	@FindBy(id="address-ui-widgets-enterAddressLine1")
	WebElement addressLine;
	
	@FindBy(id="address-ui-widgets-enterAddressCity")
	WebElement addCity;
	
	@FindBy(id="address-ui-widgets-enterAddressStateOrRegion")
	WebElement addState;
	
	@FindBy(id="address-ui-widgets-enterAddressPostalCode")
	WebElement addZip;
	
	
	
	
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void validateAddAddress(String fname, String addLine, String city) throws InterruptedException {
		//Actions action = new Actions(driver);
		//action.moveToElement(accountLink).build().perform();
		//driver.findElement(By.linkText("Your Account")).click();
		accountLink.click();
		yourAddressLink.click();
		addAddress.click();
		Select select = new Select(driver.findElement(By.id("address-ui-widgets-countryCode-dropdown-nativeId")));
		select.selectByVisibleText("India");
		Thread.sleep(2000);
		
		fullName.sendKeys(fname);
		addressLine.sendKeys(addLine);
		addCity.sendKeys(city);
		
		Select selectState = new Select(driver.findElement(By.name("address-ui-widgets-enterAddressStateOrRegion")));
		selectState.selectByVisibleText("MAHARASHTRA");
		//addState.sendKeys(state);
		
		
		//fullName.click();
		
	}

}
