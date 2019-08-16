package com.gogo.interview.core;

/**
 * @author cb-dinesh
 *
 */

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;

/**
 * BaseTest class for all your test classes. 
 * All the test classes under this framework must extend this class
 * This class listens to TestNGListener class 
 */

@Listeners(TestNGListener.class)
public class BaseTest extends DriverManager{
	
	protected static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());
	protected WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		logger.info("Starting the testsuite");
		driver = getDriver();
	}
	
	@AfterSuite
	public void afterSuite() {
		logger.info("Completing the testsuite");
		driver.quit();
	}
}
