package com.htm.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;

/**
 * This class contains all the common method for Android driver.
 * @author Bharat Puri
 *
 */
@SuppressWarnings("deprecation")
public class AndroidCommonActions {

	@SuppressWarnings("rawtypes")
	public static AndroidDriver androidDriver;
	
	@SuppressWarnings({ "rawtypes" })
	public void pressBackButton(AppiumDriver consumerMobileDriver){
	//	((PressesKey) consumerMobileDriver).pressKeyCode(AndroidKeyCode.BACK);
		
	}
	
	
	@SuppressWarnings({ "rawtypes" })
	public void homeScreen(AppiumDriver consumerMobileDriver){
		//((PressesKey) consumerMobileDriver).pressKeyCode(AndroidKeyCode.HOME);
		
	}
	
	@SuppressWarnings("rawtypes")
	public void getBackToCurrentActivity(AppiumDriver consumerMobileDriver){
		((StartsActivity)consumerMobileDriver).currentActivity();
	}
	@SuppressWarnings("rawtypes")
	public void closeApp(AppiumDriver consumerMobileDriver){
		consumerMobileDriver.closeApp();
	//	 androidDriver.resetApp();
		
	}
	
	@SuppressWarnings("rawtypes")
	public void startApp(AppiumDriver consumerMobileDriver){
		Utils.waitInSeconds(2);
		consumerMobileDriver.launchApp();
		Utils.waitInSeconds(2);
		
	}
	
	/**
	 * This method will clear user data and restart the app.
	 * @param androidDriver
	 */
	@SuppressWarnings("rawtypes")
	public void resetApp(AppiumDriver mobileDriver){
		Utils.waitInSeconds(2);
		mobileDriver.resetApp();
		 Utils.waitInSeconds(3);
	}
	/**
	 * This method will switch to the Web app.
	 * 
	 * @param androidDriver
	 */
	@SuppressWarnings("rawtypes")
	public void switchToWebApp(AppiumDriver mobileDriver) {
		mobileDriver.context("WEBVIEW_ionic.concishare.consumer.beta");
	}

	/**
	 * This method will switch to the Web app.
	 * 
	 * @param androidDriver
	 */
	@SuppressWarnings("rawtypes")
	public void switchToNativeApp(AppiumDriver mobileDriver) {
		mobileDriver.context("NATIVE_APP");
	}
	
	 
	 
	 /**
		 * Method added to press back button for Android Device
		 * 
		 * @param androidDriver
		 */
		@SuppressWarnings("rawtypes")
	public static void pressAndroidBackButton(AppiumDriver appiumDriver) {
		androidDriver = (AndroidDriver) appiumDriver;
		androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	
}
