package com.amazon.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.basetest.TestBase;

public class LoginPage extends TestBase{
	
	
	//Factory Repository or Object Repository
	@FindBy(linkText = "Sign in")
	WebElement signIn;
	
	@FindBy(xpath ="//i[@aria-label='Amazon']")
	WebElement logoImage;
	
	@FindBy(name = "email")
	WebElement userName;
	
	@FindBy(id = "continue")
	WebElement continueButton;
	
	@FindBy(id="createAccountSubmit")
	WebElement createAccount;
	
	@FindBy(name ="password")
	WebElement password;
	
	@FindBy(id = "signInSubmit")
	WebElement loginButton;
	
	
	//initializing page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle() {
		signIn.click();
		return driver.getTitle();
	}
	
	public Boolean validatLogo() {
		signIn.click();
		Boolean image = logoImage.isDisplayed();
		return image;
	}
	
	public HomePage validateLogin(String usr, String pass) {
		signIn.click();
		userName.sendKeys(usr);
		continueButton.click();
		password.sendKeys(pass);
		loginButton.click();
		return new HomePage();
	}
}
