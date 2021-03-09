package com.ecommerce.webapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class AmazonHomePageSourceURLTest {

	// 1. formulate test domain url
	final String siteURL = "https://www.amazon.in/";
	// 2. locate driver
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
	@DisplayName("Amazon Test :: Verify Amazon Home Page Source URL")
	void testAmazonHomePageSourceURL() {
		assertEquals(siteURL, driver.getCurrentUrl());
	}
	
	
	@Test
	@DisplayName("Amazon Test :: Verify Amazon Home Page Title")
	void testAmazonHomePageTitle() {
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}

	
}
