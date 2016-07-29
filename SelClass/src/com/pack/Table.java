package com.pack;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Table {
	public static void main(String args[]) throws InterruptedException{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.espncricinfo.com/icc-cricket-world-cup-2015/engine/match/656405.html");
		driver.manage().window().maximize();
		WebElement htmltable=driver.findElement(By.xpath("//table[@class='batting-table innings'][1]"));
		List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
		int rnum=0;
		mainLoop:
		while(rnum < rows.size()){
			List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));	
			int cnum=0;
			while(cnum < columns.size()){		
				if (columns.get(cnum).getText().equalsIgnoreCase("RA Jadeja")){
					columns.get(0).click();
					break mainLoop;
				}
			cnum++;	
			}
			rnum++;
		}
		String text=rows.get(rnum+1).findElements(By.tagName("td")).get(1).getText();
		
		
		try{
		Assert.assertEquals(text, "148.6 76.8 mph, slower ball this time at the base of the off stump, and Jadeja is beaten slogging. Beats me why Rahane hasn't come out to bat yet. India might fall 20 short of what they were looking good for. Good bowling by Pakistan over the last five overs 296/5");
		System.out.println("Pass");
		}
		catch (AssertionError  e)
		{
				System.out.println("Fail");
				File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);	
				try {
					FileUtils.copyFile(imageFile, new File("Sandeep.jpeg"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
		}
	}
}

