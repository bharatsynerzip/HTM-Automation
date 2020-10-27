package com.htm.base;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import com.htm.utils.ConfigurationUtil;
import com.htm.web.service.BrowserFactory;

public abstract class TestBase {

	protected static Logger log = Logger.getLogger("HTMeLogger");

	//protected static AppiumDriver htmStoriesMobileDriver = null;
//	@SuppressWarnings("rawtypes")
//	protected static AppiumDriver providerMobileDriver = null;
	protected static WebDriver webDriver = null;

//	boolean isConsumerRequired;
//	boolean isProviderRequired;
//	boolean isWebRequired;

	/**
	 * This method will initialize drivers based on conditions
	 * 
	 * @param isConsumerRequired
	 * @param isProviderRequired
	 * @param isWebRequired
	 */
//	public void initializeDrivers(boolean isConsumerRequired, boolean isProviderRequired, boolean isWebRequired) {
//		this.isConsumerRequired = isConsumerRequired;
//		this.isProviderRequired = isProviderRequired;
//		this.isWebRequired = isWebRequired;
//
//	}	
//
//	@BeforeSuite
//	public void launchMobileApp() {
//		Properties config = ConfigurationUtil.getConfig();
//		if (config.getProperty("mobile_platform").equalsIgnoreCase("android")) {
//			androidInstance();
//		}
//		if (config.getProperty("mobile_platform").equalsIgnoreCase("ios")) {
//			iOSInstance();
//		}
	//}

//	public void androidInstance() {
	//	Properties config = ConfigurationUtil.getConfig();
		//if (isConsumerRequired) {
			//htmStoriesMobileDriver = MobileDriverFactory.getMobileInstance(MobileEnums.HTMSTORIES_ANDROID.getValue());
		//}
//		if (isProviderRequired) {
//			providerMobileDriver = MobileDriverFactory.getMobileInstance(MobileEnums.PROVIDER_ANDROID.getValue());
//		}
//		if (isWebRequired) {
//			webDriver = BrowserFactory.createBrowser(config.getProperty("browser"));
//		}
	//}
//
//	public void iOSInstance() {
//		Properties config = ConfigurationUtil.getConfig();
//		if (isConsumerRequired) {
//			consumerMobileDriver = MobileDriverFactory.getMobileInstance(MobileEnums.CONSUMER_IOS.getValue());
//		}
//		if (isProviderRequired) {
//			providerMobileDriver = MobileDriverFactory.getMobileInstance(MobileEnums.PROVIDER_IOS.getValue());
//		}
//		if (isWebRequired) {
//			webDriver = BrowserFactory.createBrowser(config.getProperty("browser"));
//		}
//	}

	/**
	 * Initialize driver as per the configuration/properties file's browser type
	 */
	@BeforeSuite
	protected void initWebDriver() {
		Properties config = ConfigurationUtil.getConfig();
		log.info("Before initializing driver");
		webDriver = BrowserFactory.createBrowser(config.getProperty("browser"));
	}

	/**
	 * Close the web driver.
	 */
	public static void closeWebDriver() {
		webDriver.close();
		webDriver = null;
		log.debug("Closing the Browser");
	}

	/**
	 * Quit the web driver.
	 */
	public static void quitWebDriver() {
		webDriver.quit();
		webDriver = null;
		log.debug("Quiting the Browser");
	}

	/**
	 * Quit consumer Android mobile driver
	 */
//	public static void quitConsumerAndroidDriver() {
//		consumerMobileDriver.quit();
//	}

}
