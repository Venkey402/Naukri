package com.Naukri.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	

	@FindBy(xpath="//div[@class='card quickLink ']//span[text()='Resume headline']")
	WebElement linkResumeHeadline;	
	
	@FindBy(how=How.XPATH,using="//*[@class='widgetHead']//*[@class='edit icon']")
	WebElement icnResumeHeadLine;
		
	@FindBy(how=How.ID,using="resumeHeadlineTxt")
	WebElement txtResumeHeadLine;
	
	@FindBy(how=How.XPATH,using="//div[@class='action s12']/button[text()='Save']")
	WebElement btnSaveInResumeHeadline;
	
	
	@FindBy(how=How.ID,using="attachCV")
	WebElement btnUpdateResume;
	
	@FindBy(how=How.XPATH,using="//p[text()='Resume has been successfully uploaded.']")
	WebElement lblResumeUploadedSuccessfully;
	
	@FindBy(how=How.XPATH,using="//p[text()='Resume Headline has been successfully saved.']")
	WebElement lblResumeHeadLineUpdatedSuccessfully;
	
	
	// Action methods
	
	public void closeChatBot()
	{
		List<WebElement> chatBot = driver.findElements(By.xpath("//div[@class='chatbot_Nav']/div"));
		
		if(chatBot.size()>0)
		{
			chatBot.get(0).click();
			logger.info("Closed chatBot Window");
		}		
		else
		{
			logger.info("ChatBot Window not appeared");
		}		
	}
	
	public void clickResumeHeadlineLink()
	{
		linkResumeHeadline.click();
		logger.info("Clicked on resume headline quick link");
	}
	
	public void editResumeHeadline()
	{
		icnResumeHeadLine.click();
	}
	public void setResumeHeadline(String Headline)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", txtResumeHeadLine);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		WebDriverWait wait = new WebDriverWait(driver, 20);		
		wait.until(ExpectedConditions.visibilityOf(lblResumeUploadedSuccessfully));
	}	
	
	public boolean verifyResumeHeadlineUpdatedSuccessfully()
	{
		
		return lblResumeHeadLineUpdatedSuccessfully.isDisplayed();
	}	
	
	
	
	
}
