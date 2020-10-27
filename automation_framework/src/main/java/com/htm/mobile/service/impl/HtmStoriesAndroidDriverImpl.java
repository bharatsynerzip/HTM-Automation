package com.htm.mobile.service.impl;

import static com.htm.utils.Constants.ANDROID_HTMSTORIES_APP_VERSION;
import static com.htm.utils.Constants.ANDROID_NEXUS_PHONENAME;
import static com.htm.utils.Constants.ANDROID_NEXUS_PHONE_OS;
import static com.htm.utils.Constants.APP;
import static com.htm.utils.Constants.APPIUM_VERSION;
import static com.htm.utils.Constants.APP_ACTIVITY;
import static com.htm.utils.Constants.APP_PACKAGE;
import static com.htm.utils.Constants.DEVICE_NAME;
import static com.htm.utils.Constants.HTMSTORIES_ACTIVITY_NAME;
import static com.htm.utils.Constants.HTMSTORIES_APK_PATH;
import static com.htm.utils.Constants.HTMSTORIES_PACKAGE_NAME;
import static com.htm.utils.Constants.MOBILE_HOST_URL;
import static com.htm.utils.Constants.NEW_COMMANDTIMEOUT;
import static com.htm.utils.Constants.NORESET;
import static com.htm.utils.Constants.PLATFORM_NAME;
import static com.htm.utils.Constants.PLATFROM_VERSION;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.htm.mobile.service.MobileAppDriver;
import com.htm.utils.ConfigurationUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

/**
 * This is a implementation for HTM stories android application
 * 
 * @author Bharat Puri
 *
 */
public class HtmStoriesAndroidDriverImpl implements MobileAppDriver {

	Logger log = Logger.getLogger(HtmStoriesAndroidDriverImpl.class);

	@SuppressWarnings("rawtypes")
	public AppiumDriver getMobileDriver() {
		AndroidDriver htmStoriesAndroidDriver = null;
		Properties config = ConfigurationUtil.getConfig();
		log.info("HTM Stories Android application is launching");

		try {
			htmStoriesAndroidDriver = new AndroidDriver(new URL(
					config.getProperty(MOBILE_HOST_URL)),
					this.populateAndroidConsumerCapabilities());
			htmStoriesAndroidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		/////////////////////######New caps################///////////////////////////////
		@SuppressWarnings("unchecked")
		Set<String> contextNames = htmStoriesAndroidDriver.getContextHandles();
		for (String contextName : contextNames) {
		    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		}
		htmStoriesAndroidDriver.context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1

		log.info("HTM Stories Android application is launch successfully");
		
		return htmStoriesAndroidDriver;
	}

	/**
	 * Setting all the required capabilities
	 * 
	 * @return capabilities
	 */
	private Capabilities populateAndroidConsumerCapabilities() {
		Properties config = ConfigurationUtil.getConfig();
		DesiredCapabilities capabilities = null;
		capabilities = new DesiredCapabilities();
		log.info("Started populating the Android capabilites");
		
		capabilities.setCapability(PLATFORM_NAME, "android");
		capabilities.setCapability(DEVICE_NAME,
				config.getProperty(ANDROID_NEXUS_PHONENAME));
		capabilities.setCapability(APP, System.getProperty("user.dir") + '/'
				+ config.getProperty(HTMSTORIES_APK_PATH));
		capabilities.setCapability(APP_PACKAGE,
				config.getProperty(HTMSTORIES_PACKAGE_NAME));
		capabilities.setCapability(PLATFROM_VERSION,
				config.getProperty(ANDROID_NEXUS_PHONE_OS));
		capabilities.setCapability(APPIUM_VERSION,
				config.getProperty(ANDROID_HTMSTORIES_APP_VERSION));
		capabilities.setCapability(NORESET, "true");
		capabilities.setCapability(APP_ACTIVITY,
				config.getProperty(HTMSTORIES_ACTIVITY_NAME));
		capabilities.setCapability(NEW_COMMANDTIMEOUT, 60*200);
		capabilities.setCapability("automationName", "UiAutomator2");
		log.info("Ended populating the Android capabilites");
		
		capabilities.setCapability("autoWebview", "true");
		//capabilities.setCapability("browserName", "chrome");
		
		return capabilities;
	}
	
}
