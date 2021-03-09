package com.ecommerce.webapp.webelement;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

class RadioButtonTest {

	final String siteURL = "file:///home/wahidkhan74gmai/automation-workspace/phase5-selenium-junit5-test/static/web-elements.html";
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
	@DisplayName("Test :: To Verify Radio Button Exist")
	void testToVerifyRadioButtonExist() {
		
		WebElement radio1 = driver.findElement(By.id("male"));
		assertEquals(true, radio1.isDisplayed());
		assertEquals(true, radio1.isEnabled());
		assertEquals(false, radio1.isSelected());
		
		WebElement radio2 = driver.findElement(By.id("female"));
		assertEquals(true, radio2.isDisplayed());
		assertEquals(true, radio2.isEnabled());
		assertEquals(false, radio2.isSelected());
		
		WebElement radio3 = driver.findElement(By.id("other"));
		assertEquals(true, radio3.isDisplayed());
		assertEquals(true, radio3.isEnabled());
		assertEquals(false, radio3.isSelected());
	}
	
	@Test
	@DisplayName("Test :: To Verify Radio Button Click")
	void testToVerifyRadioButtonClick() {
		
		WebElement radio1 = driver.findElement(By.id("male"));
		assertEquals(true, radio1.isDisplayed());
		assertEquals(true, radio1.isEnabled());
		// radio button click
		radio1.click();

		assertEquals(true, radio1.isSelected());
	}
	
	@Test
	@DisplayName("Test :: To Verify Radio Button Click 2")
	void testToVerifyRadioButtonClick2() {
		
		WebElement radio2 = driver.findElement(By.id("female"));
		assertEquals(true, radio2.isDisplayed());
		assertEquals(true, radio2.isEnabled());
		// radio button click
		radio2.click();

		assertEquals(true, radio2.isSelected());
	}

}
