package com.pack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class windowHandle {
public static void main(String args[]){
	WebDriver driver=new FirefoxDriver();
	driver.get("http://www.naukri.com/");
	driver.manage().window().maximize();
	String mainWinddow=driver.getWindowHandle();
	System.out.println("****************************Initial******************************");
	System.out.print(mainWinddow+"------");
	System.out.println(driver.getTitle());
	System.out.println("****************************all window handle******************************");
	for(String w:driver.getWindowHandles()){
		System.out.print(w+"--------");
		driver.switchTo().window(w);
		System.out.println(driver.getTitle());
	} 
	
	System.out.println("****************************closing popup******************************");
		 
	for(String w:driver.getWindowHandles()){
		if(!mainWinddow.equals(w))
		{
		driver.switchTo().window(w);
		System.out.println(driver.getTitle());
		driver.close();
		} 
	}
	
	System.out.println("***************************after clicking link*******************************");
	driver.switchTo().window(mainWinddow);
	driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[1]/ul/li[1]/a/img")).click();
	for(String w:driver.getWindowHandles()){
		System.out.print(w+"--------------");
		driver.switchTo().window(w);
		System.out.println(driver.getTitle());
	} 
	
	
	System.out.println("****************************closing CTS******************************");
	for(String w:driver.getWindowHandles()){
		if(!mainWinddow.equals(w))
		{
		driver.switchTo().window(w);
		System.out.println(driver.getTitle());
		driver.close();
		} 
	}
	
	System.out.println("******************************Finally****************************");
	driver.switchTo().window(mainWinddow);
	System.out.println(driver.getTitle());
	driver.quit();
}
}
	 


