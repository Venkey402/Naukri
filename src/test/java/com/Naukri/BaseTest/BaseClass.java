package com.Naukri.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Naukri.PageObjects.HomePage;
import com.Naukri.PageObjects.LoginPage;
import com.Naukri.Utilities.ReadConfig;

public class BaseClass {
	
	public WebDriver driver;
	public static Logger logger;
	public LoginPage lp;
	public HomePage home; 
	ReadConfig rc;
	public String url;
	public String username;
	public String password;
	public String resumeHeadline;

		
	@BeforeClass
	public void setup()
	{		
		rc = new ReadConfig();
		url = rc.getBaseUrl();
		username=rc.getUsername();
		password=rc.getPassword();
		resumeHeadline = System.getProperty("yearsOfExperience")+" "+rc.getResumeHeadline();
		logger = Logger.getLogger("Naukri");
		PropertyConfigurator.configure("log4j.properties");

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		logger.info("Chrome driver initialised...");
		driver.manage().window().maximize();
		logger.info("Window Maximised...");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		logger.info("Page load time out is set to 30 secs...");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		logger.info("Implicit wait is set to 10 secs...");
		driver.get(url);
		logger.info("url is opened...");
	}
	
		
	@AfterClass
	public void tearDown()
	{
		driver.quit();	
		logger.info("dirver quitted...");
	}
	
	public void TakeScreenshot()
	{		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String FileName = "Screenshot_"+dateformat.format(date)+".png";
		TakesScreenshot tss = (TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		logger.info("Screenshot taken...");
		File dest = new File(System.getProperty("user.dir")+"\\Screenshots\\"+FileName);		
		try 
		{
			FileUtils.copyFile(src, dest);
			logger.info("Screenshot placed in the screenshot folder...");
		} catch (IOException e) 
		{
			e.printStackTrace();
		} 
		
	}

}
