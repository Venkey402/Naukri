package com.Naukri.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Naukri.BaseTest.BaseClass;

public class LoginPage extends BaseClass{
	
	public HomePage home;
	WebDriver driver;
	// Constructor
	
	public LoginPage(WebDriver driver)
	{		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Locators
		
	@FindBy(how=How.ID,using="usernameField")
	WebElement txtUsername;
	
	@FindBy(how=How.ID,using="passwordField")
	WebElement txtPassword;
	
	@FindBy(how=How.XPATH,using="//button[text()='Login']")
	WebElement btnSignIn;
	
	// Action methods
	
	public void setUsername(String Username)
	{
		txtUsername.sendKeys(Username);
	}
	public void setPassword(String Password)
	{
		txtPassword.sendKeys(Password);
	}
	public HomePage ClickSignIn()
	{
		btnSignIn.click();
		return new HomePage(driver);
	}	
	
	public HomePage Login(String Username,String Password)
	{
		txtUsername.sendKeys(Username);
		txtPassword.sendKeys(Password);
		btnSignIn.click();
		return new HomePage(driver);
	}
}
