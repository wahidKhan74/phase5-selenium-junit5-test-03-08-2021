package com.ecommerce.webapp.externalwebelement;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

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

public class BrowserWindowPopupTest {

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
	@DisplayName("Amazon Test ::: Amazon Location Popup Window")
	void testForlocationPopup() throws InterruptedException, IOException {
		// open a popup window
		Thread.sleep(3000);
		driver.findElement(By.id("nav-global-location-popover-link")).click();
		Thread.sleep(3000);

		// Switch to browser popup window
		// 1. find main window
		String mainWindow = driver.getWindowHandle();

		// 2. get sub windows and then switch
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();

		while (itr.hasNext()) {
			String childWindow = itr.next();
			driver.switchTo().window(childWindow);

			// find new popup window element
			driver.findElement(By.id("GLUXZipUpdateInput")).sendKeys("500038");
			Thread.sleep(3000);

			takeScreenShot();
			driver.findElement(By.cssSelector("#GLUXZipUpdate > span > input")).click();
		}

		driver.switchTo().window(mainWindow);
		Thread.sleep(3000);
	}

	private void takeScreenShot() throws IOException {
		// type cast driver object to screen shot object
		TakesScreenshot tsc = (TakesScreenshot) driver;

		// take screen shot as file
		File src = tsc.getScreenshotAs(OutputType.FILE);

		FileHandler.copy(src,
				new File("/home/wahidkhan74gmai/automation-workspace/automation-test-screenshot/amzon.location.popup.png"));
	}
}
