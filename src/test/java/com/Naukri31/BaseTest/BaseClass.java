package com.Naukri31.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.Naukri31.PageObjects.HomePage;
import com.Naukri31.PageObjects.LoginPage;
import com.Naukri31.Utilities.ReadConfig;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	public LoginPage lp;
	public HomePage home; 
	ReadConfig rc = new ReadConfig();
	public String Url = rc.getBaseUrl();
	public String Username=rc.getUsername();
	public String Password=rc.getPassword();
	public String ResumeHeadline = rc.getResumeHeadline();
	public String ResumeHeadline_withSpace = rc.getResumeHeadline_withSpace();		
		
	@BeforeClass
	public void setup()
	{
		logger = Logger.getLogger("Naukri");
		logger.config("log4j.properties");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		logger.info("Chrome driver initialised...");
		driver.manage().window().maximize();
		logger.info("Window Maximised...");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		logger.info("Page load time out is set to 30 secs...");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		logger.info("Implicit wait is set to 30 secs...");
		driver.get(Url);
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
