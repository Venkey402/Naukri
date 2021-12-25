package com.Naukri.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Naukri.BaseTest.BaseClass;

public class DragandDrop extends BaseClass {

	
	@Test
	public void draganddrop() throws InterruptedException
	{
		driver.get("https://jqueryui.com/droppable/");
		logger.info("drag & drop url is opened...");		
		WebElement myframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));		
		driver.switchTo().frame(myframe);
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement dest = driver.findElement(By.id("droppable"));		
		Actions action = new Actions(driver);
		action.clickAndHold(src).moveToElement(dest).release().build().perform();
		logger.info("src is dragged and dropped...");		
	}

}
