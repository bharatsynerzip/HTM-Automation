package com.htm.mobile.service;

import java.util.HashMap;
import java.util.Map;

import com.htm.enums.MobileEnums;
import com.htm.mobile.service.impl.HtmStoriesAndroidDriverImpl;

import io.appium.java_client.AppiumDriver;

/**
 * Factory framework allows us to put in place a single entry point while
 * handling Android driver operations. Depending on the application,
 **/
@SuppressWarnings("rawtypes")
public class MobileDriverFactory {

	private static Map<String, MobileAppDriver> mobileDriverFactory;
	static MobileAppDriver htmStoriesAndroidDriver = new HtmStoriesAndroidDriverImpl();
	//static MobileAppDriver providerAndroidDriver = new ProviderAndroidDriverImpl();
	
	//static MobileAppDriver consumeriOSDriver = new ConsumerIOSDriverImpl();
	//static MobileAppDriver provideriOSDriver = new ProviderIOSDriverImpl();

	static {

		mobileDriverFactory = new HashMap<String, MobileAppDriver>();
		// android mobile driver
		mobileDriverFactory.put(MobileEnums.HTMSTORIES_ANDROID.getValue(),
				htmStoriesAndroidDriver);
		//mobileDriverFactory.put(MobileEnums.PROVIDER_ANDROID.getValue(),
			//	providerAndroidDriver);
//		// ios mobile driver
//		mobileDriverFactory.put(MobileEnums.CONSUMER_IOS.getValue(),
//				consumeriOSDriver);
//		mobileDriverFactory.put(MobileEnums.PROVIDER_IOS.getValue(),
//				provideriOSDriver);

	}

	/**
	 * This operation creates mobile driver instance
	 * 
	 * @param type
	 * @return mobile instance
	 */
	public static AppiumDriver getMobileInstance(String type) {
		return mobileDriverFactory.get(type).getMobileDriver();
	}

}
