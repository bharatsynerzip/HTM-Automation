package com.htm.stories.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.htm.base.MobileTestBase;
import com.htm.mobile.stories.pages.StoriesLoginPage;
import com.htm.utils.MobileTestData;
import com.htm.utils.Utils;


/**
 * This Test case will Verify login and user details 
 * @author Bharat Puri
 *
 */

public class LoginAndVerifyLoginUserDetailsTest extends MobileTestBase {
	
	Logger log = Logger.getLogger(LoginAndVerifyLoginUserDetailsTest.class);
	
	StoriesLoginPage loginPage;
	
	@BeforeClass
	public void setUp() {
		loginPage = new StoriesLoginPage(htmStoriesMobileDriver);
	}

	@Test(priority=1)
	public void htmStoriesLogin() throws Exception {
		loginPage.storiesLogin(MobileTestData.storiesUsername, MobileTestData.storiesPassword);
		Utils.waitInSeconds(6);
		//downloadPage.donwloadFreeUserStroy();
		//downloadPage.deleteFeeUserStroty();
		
	}
	
	@Test(priority=2)
	public void verifyLoginUserDetails() throws Exception {
		loginPage.verifyLoginedUserDetails(MobileTestData.userName,MobileTestData.signedUser,MobileTestData.userEmail, MobileTestData.userType);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		loginPage.logoutFromApp();
	}
	
}
