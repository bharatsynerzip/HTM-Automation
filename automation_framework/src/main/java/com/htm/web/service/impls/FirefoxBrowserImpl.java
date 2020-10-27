package com.htm.web.service.impls;
import static com.htm.utils.Constants.OS_NAME;
import static com.htm.utils.Constants.WINDOWS_FIREFOX_DRIVER;
import static com.htm.utils.Constants.WINDOWS_FIREFOX_DRIVERPATH;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.htm.utils.ConfigurationUtil;


public class FirefoxBrowserImpl extends BaseBrowserImpl {
	Logger log = Logger.getLogger(FirefoxBrowserImpl.class);

	public WebDriver getDriver() {
		String os = System.getProperty(OS_NAME).toLowerCase();
		log.info("Operating system: " + os);
		Properties config = ConfigurationUtil.getConfig();
		WebDriver driver = null;
		System.setProperty(WINDOWS_FIREFOX_DRIVER,
				config.getProperty(WINDOWS_FIREFOX_DRIVERPATH));
		driver = new FirefoxDriver();
		postConfigure(driver);
		log.info("Execution started on url: " + driver.getCurrentUrl());
		return driver;
	}
}
