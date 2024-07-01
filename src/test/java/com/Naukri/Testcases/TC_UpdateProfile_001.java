package com.Naukri.Testcases;

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
		home =lp.Login(Username, Password);
		logger.info("User logged in Successfully...");
		home.UploadResume(System.getProperty("user.dir")+"\\src\\test\\java\\com\\Naukri\\TestData\\Venkatrao Mamidi.pdf");
		logger.info("Uploaded the resume...");
		home.ValidatingResumeUploadedSuccessfully();			 
		logger.info("Validated that resume uploaded successfully or not...");
		Thread.sleep(5000);
		int count=0;
		 while (true)
		 {	 
			 home.clickResumeHeadlineLink();
			 home.editResumeHeadline();
			 logger.info("Clicked on the edit icon on the Resume headline...");
			 Thread.sleep(10000);						 
			 if (count%2==0)
			 {
				 home.setResumeHeadline(ResumeHeadline);
				 logger.info("Updated the resume headling without SPACE...");
				 count=0;
			 }
			 else
			 {
				 home.setResumeHeadline(ResumeHeadline_withSpace);
				 logger.info("Updated the resume headling by adding SPACE...");
			 }
			 
			 home.SaveResumeHeadline();
			 logger.info("Saved the Resume Headline...");
			 Thread.sleep(20000);
			 logger.info("Waited for 20 secs before starting the next update...");
			 count++;	
		 } 		
		
	}
	
}
