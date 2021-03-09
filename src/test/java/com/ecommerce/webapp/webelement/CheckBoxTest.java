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

class CheckBoxTest {

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
	@DisplayName("Test :: To Verify Check Box Exist")
	void testToVerifyCheckBoxExist() {
		
		WebElement checkoBox1 = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkoBox1.isDisplayed());
		assertEquals(true, checkoBox1.isEnabled());
		assertEquals(false, checkoBox1.isSelected());
		
		//default selected check box
		WebElement checkoBox2 = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkoBox2.isDisplayed());
		assertEquals(true, checkoBox2.isEnabled());
		assertEquals(true, checkoBox2.isSelected());
		
		WebElement checkoBox3 = driver.findElement(By.id("vehicle3"));
		assertEquals(true, checkoBox3.isDisplayed());
		assertEquals(true, checkoBox3.isEnabled());
		assertEquals(false, checkoBox3.isSelected());
	}

	@Test
	@DisplayName("Test :: To Verify Check Box Click")
	void testToVerifyCheckBoxClick() {
		
		WebElement checkoBox3 = driver.findElement(By.id("vehicle3"));
		assertEquals(true, checkoBox3.isDisplayed());
		assertEquals(true, checkoBox3.isEnabled());
		// radio button click
		checkoBox3.click();
		assertEquals(true, checkoBox3.isSelected());
	}
}
