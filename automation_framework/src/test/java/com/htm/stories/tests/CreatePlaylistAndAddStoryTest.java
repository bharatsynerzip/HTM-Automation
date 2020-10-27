package com.htm.stories.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.htm.base.MobileTestBase;
import com.htm.mobile.stories.pages.CreatePlayListPage;
import com.htm.mobile.stories.pages.StoriesLoginPage;
import com.htm.utils.MobileTestData;


/**
 * This Test case will Verify the Create playlist and add story into the same playlist  
 * @author Bharat Puri
 *
 */
public class CreatePlaylistAndAddStoryTest extends MobileTestBase {
	StoriesLoginPage loginPage;
    CreatePlayListPage createPlaylistPage;

	@BeforeClass
	public void setUp() {
		loginPage = new StoriesLoginPage(htmStoriesMobileDriver);
		createPlaylistPage = new CreatePlayListPage(htmStoriesMobileDriver);
	}

	@Test(priority = 1)
	public void login() throws Exception {

		loginPage.storiesLogin(MobileTestData.storiesUsername, MobileTestData.storiesPassword);
	}

	@Test(priority = 2)
	public void createPlaylistAndAddFreeStoryIntoPlaylist() throws Exception {

		createPlaylistPage.createNewPlaylistAndVerifyAddedStory(MobileTestData.playlistName, MobileTestData.freeUserStroyName);
		
	}

	@AfterClass
	public void tearDown() throws Exception {
		loginPage.logoutFromApp();

	}
}
