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
import org.openqa.selenium.support.ui.Select;

class SelectDropDownTest {

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
	@DisplayName("Test :: For First Select Element")
	void testForFirstSelectElement() throws InterruptedException {
		
		WebElement select = driver.findElement(By.id("vehicle"));
		
		Select vehicelSelect = new Select(select);
		// select bike as select option
		vehicelSelect.selectByVisibleText("Bike");
		
		WebElement selectedElem = vehicelSelect.getFirstSelectedOption();
		
		assertEquals("Bike", selectedElem.getText());
		
		Thread.sleep(3000);
	}
	
	
	@Test
	@DisplayName("Test :: For Select 2nd Index Element")
	void testForSecondIndexSelectElement() throws InterruptedException {
		
		WebElement select = driver.findElement(By.id("vehicle"));
		
		Select vehicelSelect = new Select(select);
		// select 2nd index option
		vehicelSelect.selectByIndex(2);
		
		WebElement selectedElem = vehicelSelect.getFirstSelectedOption();
		
		assertEquals("Train", selectedElem.getText());
		
		Thread.sleep(3000);
	}
	
	@Test
	@DisplayName("Test :: For Select Element By Value")
	void testForSelectElementByValue() throws InterruptedException {
		
		WebElement select = driver.findElement(By.id("vehicle"));
		
		Select vehicelSelect = new Select(select);
		// select element by value 
		vehicelSelect.selectByValue("airplane");
		
		WebElement selectedElem = vehicelSelect.getFirstSelectedOption();
		
		assertEquals("Airplane", selectedElem.getText());
		
		Thread.sleep(3000);
	}

}
