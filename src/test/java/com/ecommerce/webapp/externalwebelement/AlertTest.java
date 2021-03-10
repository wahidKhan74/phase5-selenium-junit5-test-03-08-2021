package com.ecommerce.webapp.externalwebelement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class AlertTest {

	final String siteURL = "file:///home/wahidkhan74gmai/automation-workspace/phase5-selenium-junit5-test/static/external-web-alert-js.html";
	final String driverPath = "driver/geckodriver";
	WebDriver driver;

	@BeforeEach
	void lauchBrowser() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(siteURL);
	}

	@AfterEach
	void closeBrowser() {
		driver.close();
	}

	@Test
	@DisplayName("Test :: Java Script alert window test")
	void testAlertDailogWindow() throws InterruptedException {
		WebElement alertButton = driver.findElement(By.cssSelector("body > p:nth-child(2) > button"));
		alertButton.click();
		
		// switch to alert
		Alert alert = driver.switchTo().alert();
		assertEquals("Are you sure !", alert.getText());
		Thread.sleep(3000);
		alert.accept();
	}
	
	@Test
	@DisplayName("Test :: Java Script Confirmation window test with Accept")
	void testConfirmationDailogWindowWithAccept() throws InterruptedException {
		
		WebElement confirmButton = driver.findElement(By.cssSelector("body > p:nth-child(4) > button"));
		confirmButton.click();
		
		// switch to alert
		Alert alert = driver.switchTo().alert();
		assertEquals("Press a button !", alert.getText());
		Thread.sleep(3000);
		alert.accept();
	}
	
	
	@Test
	@DisplayName("Test :: Java Script Confirmation window test with Dismiss")
	void testConfirmationDailogWindowWithDismiss() throws InterruptedException {
		
		WebElement confirmButton = driver.findElement(By.cssSelector("body > p:nth-child(4) > button"));
		confirmButton.click();
		
		// switch to alert
		Alert alert = driver.switchTo().alert();
		assertEquals("Press a button !", alert.getText());
		Thread.sleep(3000);
		alert.dismiss();
	}
	
	
	@Test
	@DisplayName("Test :: Java Script Prompt window test with Accept")
	void testPromptDailogWindowWithAccept() throws InterruptedException {
		
		WebElement confirmButton = driver.findElement(By.cssSelector("body > p:nth-child(6) > button"));
		confirmButton.click();
		
		// switch to alert
		Alert alert = driver.switchTo().alert();
		assertEquals("Please enter your name", alert.getText());
		Thread.sleep(3000);
		alert.accept();
	}

}
