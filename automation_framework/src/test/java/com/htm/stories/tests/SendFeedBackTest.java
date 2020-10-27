package com.htm.stories.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.htm.base.MobileTestBase;
import com.htm.mobile.stories.pages.FeedBackSendPage;
import com.htm.mobile.stories.pages.StoriesLoginPage;
import com.htm.utils.MobileTestData;


/**
 * This Test case will send the feedback 
 * @author Bharat Puri
 *
 */
public class SendFeedBackTest extends MobileTestBase {
	StoriesLoginPage loginPage;
    FeedBackSendPage feedbackPage;

	@BeforeClass
	public void setUp() {
		loginPage = new StoriesLoginPage(htmStoriesMobileDriver);
		feedbackPage = new FeedBackSendPage(htmStoriesMobileDriver);
	}

	@Test(priority = 1)
	public void login() throws Exception {

		loginPage.storiesLogin(MobileTestData.storiesUsername, MobileTestData.storiesPassword);
	}

	@Test(priority = 2)
	public void sendFeedback() throws Exception {

		feedbackPage.sendFeedback(MobileTestData.feedbackSubject, MobileTestData.feedbackMessage, MobileTestData.feedbackExpectedMsg);
		
	}

	@AfterClass
	public void tearDown() throws Exception {
		loginPage.logoutFromApp();

	}
}
