package com.Naukri.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Naukri.BaseTest.BaseClass;

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
	
	
	@FindBy(how=How.ID,using="attachCV")
	WebElement btnUpdateResume;
	
	@FindBy(how=How.XPATH,using="//p[text()='Resume has been successfully uploaded.']")
	WebElement lblResumeUploadedSuccessfully;
	
	
	
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
	
	public void UploadResume(String Resumepath)
	{
		btnUpdateResume.sendKeys(Resumepath);
	}
	
	public void ValidatingResumeUploadedSuccessfully()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);		
		wait.until(ExpectedConditions.visibilityOf(lblResumeUploadedSuccessfully));
	}	
	
}
