package com.htm.mobile.service.impl;

import io.appium.java_client.android.AndroidDriver;

import static com.htm.utils.Constants.ANDROID;
import static com.htm.utils.Constants.ANDROID_HTMSTORIES_APP_VERSION;
import static com.htm.utils.Constants.ANDROID_MI_PHONE;
import static com.htm.utils.Constants.ANDROID_MI_PHONE_OS;
import static com.htm.utils.Constants.APP;
import static com.htm.utils.Constants.APPIUM_VERSION;
import static com.htm.utils.Constants.APP_ACTIVITY;
import static com.htm.utils.Constants.APP_PACKAGE;
import static com.htm.utils.Constants.DEVICE_NAME;
import static com.htm.utils.Constants.MOBILE_HOST_URL;
import static com.htm.utils.Constants.NORESET;
import static com.htm.utils.Constants.PLATFORM_NAME;
import static com.htm.utils.Constants.PLATFROM_VERSION;
import static com.htm.utils.Constants.REACT_APK_PATH;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.htm.utils.ConfigurationUtil;
import com.htm.utils.Utils;

public class ReactDeMo {
	
	Logger log = Logger.getLogger(HtmStoriesAndroidDriverImpl.class);

	@SuppressWarnings("rawtypes")
	public void getMobileDriver() {
		AndroidDriver consumerAndroidDriver = null;
		Properties config = ConfigurationUtil.getConfig();
		log.info("Consumer Android application is launching");

		try {
			consumerAndroidDriver = new AndroidDriver(new URL(
					config.getProperty(MOBILE_HOST_URL)),
					this.populateAndroidConsumerCapabilities());
			consumerAndroidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		log.info("Consumer Android application is launch successfully");
		
		
		Utils.waitInSeconds(5);
		
		consumerAndroidDriver.findElementByXPath("//android.widget.TextView[contains(text(),'Login')]").click();
		consumerAndroidDriver.findElementByXPath("//android.widget.EditText[@text='Phone Number *']").sendKeys("1515151515");
		//consumerAndroidDriver.findElement(By.xpath("//android.widget.EditText[@text='Phone Number *']")).sendKeys("1515151515");
		Utils.waitInSeconds(1);
		consumerAndroidDriver.findElement(By.xpath("//android.widget.EditText[@text='Password *']")).sendKeys("qwerqwer");
		Utils.waitInSeconds(1);
		consumerAndroidDriver.findElement(By.xpath("//android.widget.TextView[@text='Login']")).click();
		Utils.waitInSeconds(1);
		
		//return consumerAndroidDriver;;
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
		capabilities.setCapability(PLATFORM_NAME, ANDROID);
		capabilities.setCapability(DEVICE_NAME,
				config.getProperty(ANDROID_MI_PHONE));
		capabilities.setCapability(APP, System.getProperty("user.dir") + '/'
				+ config.getProperty(REACT_APK_PATH));
		capabilities.setCapability(APP_PACKAGE,
				config.getProperty("com.reactconcishareprovider"));
		capabilities.setCapability(PLATFROM_VERSION,
				config.getProperty(ANDROID_MI_PHONE_OS));
		capabilities.setCapability(APPIUM_VERSION,
				config.getProperty(ANDROID_HTMSTORIES_APP_VERSION));
		capabilities.setCapability(NORESET, "true");
		capabilities.setCapability(APP_ACTIVITY,
				config.getProperty("com.reactconcishareprovider.*"));
		capabilities.setCapability("appWaitActivity","com.reactconcishareprovider.*");
		capabilities.setCapability("waitForQuiescence",false);
		capabilities.setCapability("automationName","uiautomator2");
		return capabilities;
	}
	public static void main(String[] args) {
		ReactDeMo object = new ReactDeMo();
		object.getMobileDriver();
	}

}
