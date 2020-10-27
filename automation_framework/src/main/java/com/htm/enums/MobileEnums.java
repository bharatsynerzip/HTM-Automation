package com.htm.enums;

/**
 * This is a Mobile Application enum to hold values for available application
 * 
 * @author Bharat Puri
 *
 */
public enum MobileEnums {
	CONSUMER_IOS("consumer_ios"), HTMSTORIES_ANDROID("htmStories_android"), PROVIDER_IOS(
			"provider_ios"), PROVIDER_ANDROID("provider_android");

	private String value;

	private MobileEnums(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
