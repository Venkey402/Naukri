package com.Naukri.Testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Naukri.BaseTest.BaseClass;
import com.Naukri.PageObjects.HomePage;
import com.Naukri.PageObjects.LoginPage;

public class TC_UpdateProfile_001 extends BaseClass
{
	HomePage home; 
	LoginPage lp ; 
	@Test
	public void test1() throws InterruptedException
	{ 
		lp = new LoginPage(driver);
		home =lp.Login(username, password);
		logger.info("User logged in Successfully...");
		home.UploadResume(System.getProperty("user.dir")+"\\src\\test\\java\\com\\Naukri\\TestData\\Venkatrao_Mamidi.pdf");
		logger.info("Uploaded the resume...");
		home.ValidatingResumeUploadedSuccessfully();			 
		logger.info("Validated that resume uploaded successfully or not...");		 
		home.clickResumeHeadlineLink();
		
		home.editResumeHeadline();
		logger.info("Clicked on the edit icon on the Resume headline...");	 
		
		home.setResumeHeadline(resumeHeadline);
		logger.info("Updated the resume headling without SPACE...");
		
		home.SaveResumeHeadline();
		logger.info("Saved the Resume Headline...");	
		
		Assert.assertTrue(home.verifyResumeHeadlineUpdatedSuccessfully());
		
		logger.info("verified the Resume Headline updated successfully...");	
		
		Thread.sleep(5000);
	}	
}
