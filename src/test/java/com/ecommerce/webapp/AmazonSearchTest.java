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

class AmazonSearchTest {

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
	@DisplayName("Amazon Test ::: Search for Iphone 12 Product")
	void testForSearchIphone12() throws InterruptedException {
		
		WebElement seachBox = driver.findElement(By.id("twotabsearchtextbox"));
		assertTrue(seachBox.isDisplayed());
		
		// enter data into search field
		seachBox.sendKeys("Iphone 12");
		seachBox.submit();
		
		// add delay before closing
		Thread.sleep(5000);
		
		WebElement firstMobile = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a"));
		assertTrue(firstMobile.isDisplayed());
		Thread.sleep(2000);
		firstMobile.click();
		Thread.sleep(2000);
	}
	
	

}
