package com.Naukri31.Testcases;

import org.testng.annotations.Test;
import com.Naukri31.BaseTest.BaseClass;
import com.Naukri31.PageObjects.HomePage;
import com.Naukri31.PageObjects.LoginPage;

public class TC_UpdateProfile_001 extends BaseClass
{
	HomePage home; 
	LoginPage lp ; 
	@Test
	public void test1() throws InterruptedException
	{ 
		lp = new LoginPage(driver);
		home =lp.Login(Username, Password);
		int count=0;
		 while (true)
		 {	 
			 home.editResumeHeadline();
			 logger.info("Clicked on the edit icon on the Resume headline...");
			 Thread.sleep(10000);
						 
			 if (count%2==0)
			 {
				 home.setResumeHeadline(str);
				 logger.info("Updated the resume headling without SPACE...");
				 count=0;
			 }
			 else
			 {
				 home.setResumeHeadline(str_withSpace);
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
