package com.pack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FramesEg {
	// go to webpage, go to frame 0, enter first and last name and verify if it has been checked
		WebDriver driver;
		@Before
		public void setup()
		{
			driver = new FirefoxDriver();
			// launching gmail.com on the browser
			driver.get("http://toolsqa.com/iframe-practice-page/");
			// maximized the browser window
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		
		@Test
		public void FrameTest()
		{
			// to find total iframes on page
			List<WebElement> listFrames=driver.findElements(By.tagName("iFrame"));
			System.out.println("total iframes are:"+listFrames.size());
			
			
			// to switch to frame 0
			WebElement frame1=listFrames.get(1);
					
			driver.switchTo().frame(frame1);
			
			
			// to enter text in first name input box
			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("sandeep");
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("chaudhary");
			System.out.println("names entered.....!!");
			
			driver.switchTo().defaultContent();
			String title=driver.getTitle().toString();
			System.out.println("title:"+title);
			
			// to click on home tab
			driver.findElement(By.xpath("//ul[@id='main-nav']/li/a/span[contains(text(),'HOME')]")).click();
			
		}

}
