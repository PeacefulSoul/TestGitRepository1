package com.pack;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowPopUps {
	// login to gmail and click try to add an attachment to an email
	WebDriver drv;

	@Before
	public void setup() throws InterruptedException {

		// initializing drv variable using FirefoxDriver
		drv = new FirefoxDriver();
		// launching gmail.com on the browser
		drv.get("http://www.gmail.com");
		// maximized the browser window
		drv.manage().window().maximize();
		drv.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException, AWTException {

		// WebElement gmailLink=drv.findElement(By.linkText("Gmail"));
		// gmailLink.click();

		// click on Signin - locator ID

		drv.findElement(By.id("Email")).sendKeys("sandeep19.1989@gmail.com");

		drv.findElement(By.xpath("//input[@value='Next']")).click();
		// driver.findElement(By.id("gmail-sign-in")).click();

		// enter password - locator name
		drv.findElement(By.name("Passwd")).sendKeys("bhariwas123");

		// click button - locator ClassName
		// WebElement btn=driver.findElement(By.className("rc-button
		// rc-button-submit"));

		WebElement btn = drv.findElement(By.xpath("//*[@id='signIn']"));
		btn.click();
		// explicit wait - to wait for the compose button to be click-able
		WebDriverWait wait = new WebDriverWait(drv, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
		// click on the compose button as soon as the "compose" button is
		// visible

		drv.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();

		// click on attach file icon
		drv.findElement(By.xpath("//table/tbody/tr/td[4]/div/div[1]/div/div/div")).click();

		// create object of robot class to handle window pop ups
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_SEMICOLON);
		robot.keyRelease(KeyEvent.VK_SEMICOLON);
		robot.keyRelease(KeyEvent.VK_SHIFT);

		robot.keyPress(KeyEvent.VK_BACK_SLASH);
		robot.keyRelease(KeyEvent.VK_BACK_SLASH);
		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_I);
		robot.keyRelease(KeyEvent.VK_I);

		robot.keyPress(KeyEvent.VK_M);
		robot.keyRelease(KeyEvent.VK_M);

		robot.keyPress(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_G);
		Thread.sleep(2000);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

	}

	@After
	public void teardown() {
		// closes all the browser windows opened by web driver
		// drv.quit();
	}

}
