package com.Naukri31.Testcases;

import org.testng.annotations.Test;

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
			 logger.info("Editing the Resume headline...");
			 Thread.sleep(10000);
						 
			 if (count%2==0)
			 {
				 home.setResumeHeadline(str);
				 logger.info("Updating the resume headling without SPACE...");
				 count=0;
			 }
			 else
			 {
				 home.setResumeHeadline(str_withSpace);
				 logger.info("Updating the resume headling by adding SPACE...");
			 }
			 
			 home.SaveResumeHeadline();
			 Thread.sleep(20000);
			 count++;		 
		 } 
		
		
	}
	
}
