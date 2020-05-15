package com.amazon.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.basetest.TestBase;

public class SearchPage extends TestBase{
	
	@FindBy(xpath="//span[@class='a-color-state a-text-bold']")
	WebElement searchLabel;
	
	@FindBy(xpath="//img[@src='https://m.media-amazon.com/images/I/61zLDSMp+5L._AC_UL320_.jpg']")
	WebElement searchImage;
	
	@FindBy (id ="add-to-wishlist-button-submit")
	WebElement selectList;
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public Boolean validateLabel() {
		return searchLabel.isDisplayed();
	}
	
	public void validateSearchImage() {
		searchImage.click();
	}
	
	public void validateList() {
		Select s = new Select(driver.findElement(By.id("native_dropdown_selected_size_name")));
		s.selectByVisibleText("10");
	}

}
