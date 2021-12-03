package com.Naukri31.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Naukri31.Testcases.BaseClass;

public class HomePage extends BaseClass{
	
	// Constructor
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Locators
	
	@FindBy(how=How.XPATH,using="//div[@class='resumeHeadline']/div/div/div/span[text()='Resume Headline']/../span[@class='edit icon']")
	WebElement icnResumeHeadLine;
		
	@FindBy(how=How.ID,using="resumeHeadlineTxt")
	WebElement txtResumeHeadLine;
	
	@FindBy(how=How.XPATH,using="//div[@class='action s12']/button[text()='Save']")
	WebElement btnSaveInResumeHeadline;
	
	// Action methods
	
	public void editResumeHeadline()
	{
		icnResumeHeadLine.click();
	}
	public void setResumeHeadline(String Headline)
	{
		txtResumeHeadLine.clear();
		txtResumeHeadLine.sendKeys(Headline);
	}
	public void SaveResumeHeadline()
	{
		btnSaveInResumeHeadline.click();
	}
	
}
