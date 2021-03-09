package com.ecommerce.webapp.screenshot;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

class BrowserWindowsScreenShotTest {

	final String siteURL = "https://www.amazon.in/";
	final String driverPath = "driver/geckodriver";
	WebDriver driver;

	@BeforeEach
	void setUp() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(siteURL);
	}

	@AfterEach
	void tearDown() {
		driver.close();
	}
	
	@Test
	@DisplayName("Test :: Amazon Home Page Screen Shot Test")
	void testToTakeScreenShot() throws IOException {
		
		// type cast driver object to screen shot object 		
		TakesScreenshot tsc = (TakesScreenshot) driver;
		
		// take screen shot as file
		File src = tsc.getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(src, new File("/home/wahidkhan74gmai/automation-workspace/automation-test-screenshot/amzon.in.png"));
	}
	
	@Test
	@DisplayName("Test :: Amazon Mobile Page Screen Shot Test")
	void testToTakeScreenShotForMobile() throws IOException {
		
		// navigate to mobile link
		driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)")).click();
		
		// type cast driver object to screen shot object 		
		TakesScreenshot tsc = (TakesScreenshot) driver;
		
		// take screen shot as file
		File src = tsc.getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(src, new File("/home/wahidkhan74gmai/automation-workspace/automation-test-screenshot/amzon.mbile.in.png"));
	}

}
