package com.htm.mobile.service;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public interface MobileAppDriver {
	@SuppressWarnings("rawtypes")
	public AppiumDriver getMobileDriver();

}
