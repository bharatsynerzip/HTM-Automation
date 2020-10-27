package com.htm.base;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;

import com.htm.enums.MobileEnums;
import com.htm.mobile.service.MobileDriverFactory;
import com.htm.utils.ConfigurationUtil;
import com.htm.utils.Utils;

import io.appium.java_client.AppiumDriver;

public class MobileTestBase {
	
	protected static Logger log = Logger.getLogger("HTMeLogger");
	@SuppressWarnings("rawtypes")
	protected static AppiumDriver htmStoriesMobileDriver;

	@BeforeSuite
	public void launchMobileApp() {
		Properties config = ConfigurationUtil.getConfig();
		if (config.getProperty("mobile_platform").equalsIgnoreCase("android")) {
			androidInstance();
		}
//		if (config.getProperty("mobile_platform").equalsIgnoreCase("ios")) {
//			iOSInstance();
//		}
	}
	
	public void androidInstance() {
		//Properties config = ConfigurationUtil.getConfig();
		//if (isConsumerRequired) {
			htmStoriesMobileDriver = MobileDriverFactory.getMobileInstance(MobileEnums.HTMSTORIES_ANDROID.getValue());
			Utils.waitInSeconds(30);
		//}
//		if (isProviderRequired) {
//			providerMobileDriver = MobileDriverFactory.getMobileInstance(MobileEnums.PROVIDER_ANDROID.getValue());
//		}
	}

}
