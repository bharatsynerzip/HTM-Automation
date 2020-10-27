package com.htm.mobile.service.impl;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import static com.htm.utils.Constants.ANDROID;
import static com.htm.utils.Constants.ANDROID_PROVIDER_APP_VERSION;
import static com.htm.utils.Constants.APP;
import static com.htm.utils.Constants.APPIUM_VERSION;
import static com.htm.utils.Constants.APP_ACTIVITY;
import static com.htm.utils.Constants.APP_PACKAGE;
import static com.htm.utils.Constants.DEVICE_NAME;
import static com.htm.utils.Constants.MOBILE_HOST_URL;
import static com.htm.utils.Constants.NEW_COMMANDTIMEOUT;
import static com.htm.utils.Constants.NORESET;
import static com.htm.utils.Constants.PLATFORM_NAME;
import static com.htm.utils.Constants.PLATFROM_VERSION;
import static com.htm.utils.Constants.PROVIDER_ACTIVITY_NAME;
import static com.htm.utils.Constants.PROVIDER_APK_PATH;
import static com.htm.utils.Constants.PROVIDER_PACKAGE_NAME;
import static com.htm.utils.Constants.ANDROID_NEXUS_PHONENAME;
import static com.htm.utils.Constants.ANDROID_NEXUS_PHONE_OS;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.htm.mobile.service.MobileAppDriver;
import com.htm.utils.ConfigurationUtil;



/**
 * This is a implementation for Provider android application
 * @author Bharat Puri	
 *
 */
public class ProviderAndroidDriverImpl implements MobileAppDriver {

	Logger log = Logger.getLogger(ProviderAndroidDriverImpl.class);

	@SuppressWarnings("rawtypes")
	public AndroidDriver getMobileDriver() {
		AndroidDriver providerAndroidDriver = null;
		Properties config = ConfigurationUtil.getConfig();
		log.info("Provider Android application is launching");

		try {
			providerAndroidDriver = new AndroidDriver(new URL(config.getProperty(MOBILE_HOST_URL)), this.populateAndroidProvicerCapabilities());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		log.info("Provider Android application is launch successfully");
		return providerAndroidDriver;
	}
	
	/**
	 * Setting all the required capabilities for Provider Android app
	 * @return capabilities 
	 */
	private Capabilities populateAndroidProvicerCapabilities(){
		Properties config = ConfigurationUtil.getConfig();
		DesiredCapabilities capabilities = null;
		capabilities = new DesiredCapabilities();
		log.info("Started populating the Android capabilites for Provicer app");
		
		capabilities.setCapability(PLATFORM_NAME, ANDROID);
		capabilities.setCapability(DEVICE_NAME, config.getProperty(ANDROID_NEXUS_PHONENAME));
		//capabilities.setCapability(DEVICE_NAME, "GT-S7392");
		capabilities.setCapability(APP, System.getProperty("user.dir") + '/' + config.getProperty(PROVIDER_APK_PATH));
		capabilities.setCapability(APP_PACKAGE, config.getProperty(PROVIDER_PACKAGE_NAME));
		capabilities.setCapability(PLATFROM_VERSION, config.getProperty(ANDROID_NEXUS_PHONE_OS));
		//capabilities.setCapability(PLATFROM_VERSION, "4.1.2");
		capabilities.setCapability(APPIUM_VERSION, config.getProperty(ANDROID_PROVIDER_APP_VERSION));
		capabilities.setCapability(NORESET, "true");
		capabilities.setCapability(APP_ACTIVITY,config.getProperty(PROVIDER_ACTIVITY_NAME));
		capabilities.setCapability(NEW_COMMANDTIMEOUT, 60 * 20);
		
		return capabilities;
	}

}
