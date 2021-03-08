package com.ecommerce.webapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonHomePageTest {

	// 1. formulate test domain url
	final String siteURL = "https://www.amazon.in/";
	// 2. locate driver
	final String driverPath = "/home/wahidkhan74gmai/automation-workspace/phase5-selenium-test-03-08-2021/driver/geckodriver";

	@Test
	@DisplayName("Amazon Test :: Verify title of the homepage")
	public void testAmazonHomePageTitle() {
		
		// 3. set system property
		System.setProperty("webdriver.gecko.driver", driverPath);

		// 4. instantiating selenium web driver
		WebDriver driver = new FirefoxDriver();

		// 5. launch browser
		driver.get(siteURL);
		
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle = driver.getTitle();
		
		assertEquals(expectedTitle, actualTitle);

	}
}
