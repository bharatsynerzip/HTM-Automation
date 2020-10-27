package com.htm.utils;

import static com.htm.utils.ConfigurationUtil.getMobileTestData;

import java.util.Properties;

public class MobileTestData {
	static Properties testData;

	static {
		testData = getMobileTestData();
	}
	
	//Stories user name and password
	public static final  String storiesUsername = testData.getProperty("storiesUsername");
	public static final  String storiesPassword = testData.getProperty("storiesPassword");
	
	public static final  String feedbackSubject = testData.getProperty("feedbackSubject");
	public static final  String feedbackMessage = testData.getProperty("feedbackMessage");
	public static final  String feedbackExpectedMsg = testData.getProperty("feedbackExpectedSucessMsg");
	
	public static final  String userName = testData.getProperty("userName");
	public static final  String userType = testData.getProperty("userType");
	public static final  String userEmail = testData.getProperty("userEmail");
	public static final  String signedUser = testData.getProperty("singedAsUser");
	
	public static final  String actualMinicatStoryName = testData.getProperty("minicatHoleName");
	public static final  String actualFreeUserStoryName = testData.getProperty("freeUserStroyName");
	
	public static final  String playlistName = testData.getProperty("playlistName");
	public static final  String freeUserStroyName = testData.getProperty("stroyName");
	
	
	
	
	
	
	
	
	
	

//	// Data variables for Create new consumer from Test Data properly file
//	public static final  String consumerFullName = testData.getProperty("consumerFullName");
//	public static final  String consumerEmail = testData.getProperty("consumerEmail");
//	public static final String consumerPhoneNumber = testData.getProperty("consumerPhoneNumber");
//	public static final  String consumerPassword = testData.getProperty("consumerPassword");
//	public static final  String consumerConfirmPassword = testData.getProperty("consumerConfirmPassword");
//	public static final  String consumerVerificationCode = testData.getProperty("consumerVerificationCode");
//	
//	public static final String loginWelcomeMessage = testData.getProperty("consumerLoginWelcomeMessage");
//	
//	//Expected login error messages
//	public static final  String expectedConsumerInvalidPhoneNumberErrorMsg = testData.getProperty("expectedConsumerInvalidPhoneNumberErrorMsg");
//	public static final  String expectedConsumerInvalidPasswordErrorMsg = testData.getProperty("expectedConsumerInvalidPasswordErrorMsg");
//	
//	
//	// Data for Create new Provider
//	public static final String provider_FName = testData.getProperty("providerFirstName");
//	public static final String provider_LName = testData.getProperty("providerLastName");
//	public static final String provider_Email = testData.getProperty("providerEmail");
//	public static final String provider_Password = testData.getProperty("providerPassword");
//	public static final String provider_ConfirmPass = testData.getProperty("providerConfirmPassword");
//	public static final String provider_AddressOne = testData.getProperty("providerAddressOne");
//	public static final String provider_AddressTwo = testData.getProperty("providerAddressTwo");
//	public static final String provider_ZipCode = testData.getProperty("providerZipCode");
//	public static final String provider_YearOFService = testData.getProperty("providerYearsOfService");
//	public static final String provider_AboutMe = testData.getProperty("providerAboutMe");
//	public static final String provider_CardNo = testData.getProperty("providerCardNumber");
//	public static final String provider_CardExpireDate = testData.getProperty("providerCardExpireDate");
//	public static final String provider_CardCVVNo = testData.getProperty("providerCVVNumber");
//	public static final String provider_confirmCode = testData.getProperty("providerCodeNumber");
//	
//	public static final String provider_ValidPhone = testData.getProperty("providerValidPhone");
//	public static final String provider_ValidPass = testData.getProperty("providerValidPassword");
//	public static final String provider_Name = testData.getProperty("providerName");
//	
	
	
	
}

