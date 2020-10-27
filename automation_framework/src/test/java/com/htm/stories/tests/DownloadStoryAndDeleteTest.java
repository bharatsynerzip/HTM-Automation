package com.htm.stories.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.htm.base.MobileTestBase;
import com.htm.mobile.stories.pages.DownloadStoriesPage;
import com.htm.mobile.stories.pages.StoriesLoginPage;
import com.htm.utils.MobileTestData;


/**
 * This Test case will Verify download the story and delete it  
 * @author Bharat Puri
 *
 */

public class DownloadStoryAndDeleteTest extends MobileTestBase {
	StoriesLoginPage loginPage;
    DownloadStoriesPage downloadPage;

	@BeforeClass
	public void setUp() {
		loginPage = new StoriesLoginPage(htmStoriesMobileDriver);
		downloadPage = new DownloadStoriesPage(htmStoriesMobileDriver);
	}

	@Test(priority = 1)
	public void login() throws Exception {

		loginPage.storiesLogin(MobileTestData.storiesUsername, MobileTestData.storiesPassword);
	}

	@Test(priority = 2)
	public void downloadFeeUserStory() throws Exception {
		
		downloadPage.donwloadFreeUserStroy();
		
	}
	
	@Test(priority = 3)
	public void deleteDownloadedFeeUserStory() throws Exception {
		
		downloadPage.deleteFeeUserStroty();
	}

	@AfterClass
	public void tearDown() throws Exception {
		loginPage.logoutFromApp();

	}
}
