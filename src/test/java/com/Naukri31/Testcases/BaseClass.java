package com.Naukri31.Testcases;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Naukri31.PageObjects.HomePage;
import com.Naukri31.PageObjects.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	public LoginPage lp;
	public HomePage home; 
	String Url = "https://www.naukri.com/mnjuser/profile?id=&altresid";
	String Username="venkey402@gmail.com";
	String Password="9030196907";
	String str = "9.5 Years experience in automation testing, manual testing and API testing.";
	String str_withSpace = "9.5 Years experience in automation testing, manual testing and API testing .";
		
		
	@BeforeClass
	public void setup()
	{
		logger = Logger.getLogger("Naukri");
		logger.config("log4j.properties");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		logger.info("chrome driver initialised...");
		driver.manage().window().maximize();
		logger.info("Window Maximised...");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		logger.info("Page load time out is set to 30 secs...");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		logger.info("implicit wait is set to 30 secs...");
		driver.get(Url);
		logger.info("url is opened...");
	}
	
		
	@AfterClass
	public void tearDown()
	{
		driver.quit();	
		logger.info("dirver quitted...");
	}
	

}
