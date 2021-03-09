package com.ecommerce.webapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class AmazonNavLinksTest {

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
	@DisplayName("Amazon Test :: Mobile Link Verification")
	void testMobileNavigationLink() {
		
		WebElement mobileLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)"));
		
		assertTrue(mobileLink.isDisplayed());
		assertTrue(mobileLink.isEnabled());		
		mobileLink.click();
		
		String expected = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		assertEquals(expected, driver.getTitle());
		
	}
	
	@Test
	@DisplayName("Amazon Test :: Todays Deal Link Verification")
	void testTodaysDealNavigationLink() {
		
		WebElement todayLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(4)"));
		
		assertTrue(todayLink.isDisplayed());
		assertTrue(todayLink.isEnabled());		
		todayLink.click();
		
		String expected = "Amazon.in Today's Deals: Great Savings. Every Day.";
		assertEquals(expected, driver.getTitle());
		
	}

	// TODO :: verify 3 more links from amazon nav links
	// 
	
}
