package com.htm.utils;

import io.appium.java_client.AppiumDriver;

import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;

/**
 * This class contains all the common method which work for Android and iOS
 * driver
 * 
 * @author Bharat Puri
 *
 */
public class AndroidIOSCommonActions {

	Properties config = ConfigurationUtil.getConfig();

	/**
	 * This method will switch to the Native App based on mobile driver.
	 * 
	 * @param consumerMobileDriver
	 */
	@SuppressWarnings("rawtypes")
	public void switchToNativeApp(AppiumDriver consumerMobileDriver) {
		consumerMobileDriver.context("NATIVE_APP");
	}

	/**
	 * This method will switch to the Web app based on mobile driver.
	 * 
	 * @param mobileDriver
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void swithToWebViewOnConsumer(AppiumDriver mobileDriver) {
		Properties config = ConfigurationUtil.getConfig();
		if (config.getProperty("mobile_platform").equalsIgnoreCase("android")) {
			mobileDriver.context("WEBVIEW_ionic.concishare.consumer.beta");
		}
		if (config.getProperty("mobile_platform").equalsIgnoreCase("ios")) {
			Set<String> contextHandles = mobileDriver.getContextHandles();
			String context = mobileDriver.getContext();
			if (context.equals("NATIVE_APP")) {
				mobileDriver.context((String) contextHandles.toArray()[1]);
			}
		}
	}

	/**
	 * This method will switch to the Web app based on mobile driver.
	 * 
	 * @param mobileDriver
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void swithToWebViewOnProvider(AppiumDriver mobileDriver) {
		if (config.getProperty("mobile_platform").equalsIgnoreCase("android")) {
			mobileDriver.context("WEBVIEW_ionic.concishare.provider.beta");
		}
		if (config.getProperty("mobile_platform").equalsIgnoreCase("ios")) {
			Set<String> contextHandles = mobileDriver.getContextHandles();
			String context = mobileDriver.getContext();
			if (context.equals("NATIVE_APP")) {
				mobileDriver.context((String) contextHandles.toArray()[1]);
			}
		}
	}

	/**
	 * This method will clear user data and restart the app.
	 * 
	 * @param androidDriver
	 */
	@SuppressWarnings("rawtypes")
	public void resetApp(AppiumDriver consumerMobileDriver) {
		Utils.waitInSeconds(2);
		consumerMobileDriver.resetApp();
		Utils.waitInSeconds(3);
	}

	@SuppressWarnings("rawtypes")
	public void pressBackButton(AppiumDriver appiumDriver) {
		appiumDriver.navigate().back();
	}

	@SuppressWarnings("rawtypes")
	public void scrollPage(AppiumDriver appiumDriver) {
		String driverType = appiumDriver.getClass().toString();
		if (driverType.equals(config.getProperty("iOSDriverType"))) {
			JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "down");
			js.executeScript("mobile: scroll", scrollObject);
			js.executeScript("mobile: scroll", scrollObject);
			js.executeScript("mobile: scroll", scrollObject);
		}
	}
}
