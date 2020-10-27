package com.htm.stories.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.htm.base.MobileTestBase;
import com.htm.mobile.stories.pages.AudioPlayerPage;
import com.htm.mobile.stories.pages.StoriesLoginPage;
import com.htm.utils.MobileTestData;

/**
 * This Test case will Verify the Audio player functions 
 * @author Bharat Puri
 *
 */
public class VerifyAudioPlayerTest extends MobileTestBase {

	StoriesLoginPage loginPage;
	AudioPlayerPage audioPage;

	@BeforeClass
	public void setUp() {
		loginPage = new StoriesLoginPage(htmStoriesMobileDriver);
		audioPage = new AudioPlayerPage(htmStoriesMobileDriver);
	}

	@Test(priority = 1)
	public void login() throws Exception {

		loginPage.storiesLogin(MobileTestData.storiesUsername, MobileTestData.storiesPassword);
	}

	@Test(priority = 2)
	public void verifyAudioPlayerFuntions() throws Exception {

		audioPage.verifyAudioPlayerFunctions(MobileTestData.actualMinicatStoryName, MobileTestData.actualFreeUserStoryName);
		audioPage.verifyFastForwardOptionOnAudioPlayer();
	}

	@AfterClass
	public void tearDown() throws Exception {
		loginPage.logoutFromApp();

	}
}
