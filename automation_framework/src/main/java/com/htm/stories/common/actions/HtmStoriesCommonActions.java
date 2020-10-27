package com.htm.stories.common.actions;

import com.htm.base.MobileTestBase;
import com.htm.mobile.stories.pages.HTMStoriesRegisterPage;
import com.htm.mobile.stories.pages.StoriesLoginPage;
import com.htm.utils.MobileTestData;

public class HtmStoriesCommonActions extends MobileTestBase {

	StoriesLoginPage loginPage;
	HTMStoriesRegisterPage registerPage;
	
	public HtmStoriesCommonActions () {
		loginPage = new StoriesLoginPage(htmStoriesMobileDriver);
		registerPage = new HTMStoriesRegisterPage(htmStoriesMobileDriver);
	}
	
	public void htmStoriesLogin(String username, String password) throws Exception {
		log.info("-----------------HTM Stories Login----Begin-----------------");
		loginPage.storiesLogin(MobileTestData.storiesUsername, MobileTestData.storiesPassword);
		log.info("-----------------HTM Stories Login----End-----------------");
	}
	
	public void htmRegisterNewUser(String firstName, String lastName, String phone, String email, String pass, String rePass) throws Exception {
		
		registerPage.registerNewUserStories(firstName, lastName, phone, email, pass, rePass);
	}
}
