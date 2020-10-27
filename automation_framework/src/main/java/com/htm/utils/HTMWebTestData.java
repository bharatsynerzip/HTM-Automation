package com.htm.utils;

import static com.htm.utils.ConfigurationUtil.getTestData;

import java.util.Properties;

public class HTMWebTestData {
	
	static Properties testData;

	static {
		testData = getTestData();
	}
	
	
	
	public static final String memberUsername = testData.getProperty("memberUsername");
	public static final String memberPassword = testData.getProperty("memberPassword");
	public static final String memberLoginMsg = testData.getProperty("memberSuccessLoginMsg");
	
	
	
	// Data for dashborad 
	public static final String dashboard_userName = testData.getProperty("dashboardemailid");
	public static final String dashboard_password = testData.getProperty("dashboardpassword");
	
	public static final String dashboard_cityName = testData.getProperty("dashboardCityName");
	public static final String dashboard_state = testData.getProperty("dashboardStateName");
	public static final String dashboard_timeZone = testData.getProperty("dashboardTimeZone");
	public static final String addCity_successMsg = testData.getProperty("addCitySuccessMsg");
	public static final String disabledCity_successMsg = testData.getProperty("disabledCity");
		
	public static final String editPreferences_successMsg = testData.getProperty("editPreferencesSuccessMsg");
	public static final String editPreferences_value = testData.getProperty("editPreferencesValue");
	public static final String editPreferences_name = testData.getProperty("editPreferencesName");
}
