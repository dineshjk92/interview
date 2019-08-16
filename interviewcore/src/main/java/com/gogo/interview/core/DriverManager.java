package com.gogo.interview.core;

/**
 * @author cb-dinesh
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.File;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;

public class DriverManager {

	Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());
    WebDriver driver;

    /**
     * setup Selenium webdriver 
     * System property 'webdriver.browser' is used to set the browser in which the test cases to be run
     *  
     */
    public WebDriver getDriver() {
        if(driver == null) {
            logger.info("No driver found. Creating a one");
            String browserName = System.getProperty("webdriver.browser", "chrome").toLowerCase(Locale.ENGLISH);
            switch (WebDriverConstants.BrowserNames.valueOf(browserName.toUpperCase())) {
                case CHROME:
                    File choromeDriver = new File(WebDriverConstants.getDriverExecutable(String.valueOf(WebDriverConstants.BrowserNames.CHROME)));
                    choromeDriver.setExecutable(true);
                    System.setProperty("webdriver.chrome.driver", choromeDriver.getAbsolutePath());
                    driver = new ChromeDriver(new ChromeOptions());
                    break;
                case FIREFOX:
                    File ieDriver = new File(WebDriverConstants.getDriverExecutable(String.valueOf(WebDriverConstants.BrowserNames.FIREFOX)));
                    ieDriver.setExecutable(true);
                    System.setProperty("webdriver.gecko.driver", ieDriver.getAbsolutePath());
                    driver = new FirefoxDriver(new FirefoxOptions());
                    break;
                case INTERNET_EXPLORER:
                    File geckoDriver = new File(WebDriverConstants.getDriverExecutable(String.valueOf(WebDriverConstants.BrowserNames.INTERNET_EXPLORER)));
                    geckoDriver.setExecutable(true);
                    System.setProperty("webdriver.ie.driver", geckoDriver.getAbsolutePath());
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Argument for browser name : " + browserName);

            }
        }
        logger.info("Launching driver");
        return driver;
    }
}

