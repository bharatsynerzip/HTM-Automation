package com.htm.stories.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.htm.base.MobileTestBase;
import com.htm.mobile.stories.pages.HTMStoriesRegisterPage;

public class RegisterUser extends MobileTestBase {
	
	HTMStoriesRegisterPage registerPage;

	@BeforeClass
	public void setUp() {
		registerPage = new HTMStoriesRegisterPage(htmStoriesMobileDriver);
	}
	
  @Test
  public void registerNewUser() throws Exception {

	  registerPage.registerNewUserStories("bharat", "Puri", "9922383338", "puribharat1@yahoo.com", "bhraaT", "bharaT");
	  
  }
}
