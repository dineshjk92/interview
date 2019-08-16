package com.gogo.interview.core;

/**
 * @author cb-dinesh
 *
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


/**
 * BasePage class for all your page factory classes. 
 * All the Page factory classes under this framework must extend this class
 */

public class BasePage {
	
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(WebDriverConstants.TIME_OUT_SECONDS, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public JavascriptExecutor getJSExecutor(WebDriver driver) {
		return (JavascriptExecutor) driver;
	}
	public void clearAndType(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	public String getElementText(WebElement element) {
		return element.getAttribute("innerText").trim();
	}
	public void selectValueFromDropDown(WebElement element, String by, String value) {
		Select dropdown = new Select(element);
		switch(by.toLowerCase()) {
		case "index":
			dropdown.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			dropdown.selectByValue(value);
			break;
		case "text":
			dropdown.selectByVisibleText(value);
			break;
		}
	}
	
	public boolean isElementPresentAndDisplayed(WebElement element) {
		return (element.isDisplayed() && element.isEnabled());
	}
	
}
