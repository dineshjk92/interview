package com.gogo.interview.core;

/**
 * @author cb-dinesh
 *
 */

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A constant file for all Selenium core related configuration data
 */

public class WebDriverConstants {

    public enum BrowserNames{
        CHROME, FIREFOX, INTERNET_EXPLORER
    }

	public static long TIME_OUT_SECONDS = 30;
    public static final Map<String, String> DRIVER_LOCATIONS;
    static {
        Map<String, String> tmp = new LinkedHashMap<String, String>();
        tmp.put("chrome", System.getProperty("user.dir") + "/resources/drivers/chromedriver");
        tmp.put("firefox",System.getProperty("user.dir") + "/resources/drivers/geckodriver");
        tmp.put("internet_explorer","");
        DRIVER_LOCATIONS = Collections.unmodifiableMap(tmp);
    }


    public static String getDriverExecutable(String browserName) {
    	return DRIVER_LOCATIONS.get(browserName.toLowerCase());
    }



}
