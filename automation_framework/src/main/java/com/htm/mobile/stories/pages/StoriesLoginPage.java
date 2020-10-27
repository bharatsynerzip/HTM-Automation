package com.htm.mobile.stories.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.htm.base.MobileElementActions;
import com.htm.utils.Utils;

import io.appium.java_client.AppiumDriver;

/**
 * This class contains all the elements of Member login page with all
 * actions
 * 
 * @author Bharat Puri
 *
 */
public class StoriesLoginPage extends MobileElementActions {
	
	FeedBackSendPage feedbackPage = new FeedBackSendPage(htmStoriesMobileDriver);
	
//	@FindBy(xpath = "//*/android.widget.EditText[1]")
//	private WebElement storiesUserNameTextBox;
	
	@FindBy(xpath = "//input[(@name='dashboardUsername')]")
	private WebElement storiesUserNameTextBox;
	
	@FindBy(xpath = "//input[(@name='dashboardPassword')]")
	private WebElement storiesPasswordTextBox;
	
	@FindBy(xpath = "(//div[(@class='login-img-overlay')]/button/span)")
	private WebElement storiesLoginButton;
	
	@FindBy(xpath = "//*[@id=\"tabpanel-t0-4\"]/page-more-options/ion-content/div[2]/ion-list/button/div[1]/div")
	private WebElement myProfileButton;
	
	@FindBy(xpath = "(//span[contains(text(),'Name')]/following-sibling::p)")
	private WebElement userName;
	
	@FindBy(xpath = "(//span[contains(text(),'Signed in as')]/following-sibling::p)")
	private WebElement userLoginAs;
	
	@FindBy(xpath = "(//span[contains(text(),'Email address')]/following-sibling::p)")
	private WebElement userEmail;
	
	@FindBy(xpath = "(//span[contains(text(),'User Type')]/following-sibling::p)")
	private WebElement userType;
	
	
	@FindBy(xpath = "//span[contains(text(),'Back')]")
	private WebElement profileBackButton;
	
	@FindBy(xpath = "//*[@id=\"tabpanel-t0-4\"]/page-more-options/ion-content/div[2]/ion-list/ion-item[9]/div[1]/div/ion-label/button")
	private WebElement logoutButton;
	
	//span[contains(text(),'Back')]
//	@FindBy(xpath = "//*/android.widget.EditText[@text='password']")
//	private WebElement storiesPasswordTextBox;
//	
//	@FindBy(xpath = "//*/android.widget.Button[contains(@text,'LOGIN')]")
//	private WebElement storiesLoginButton;
//	
//	@FindBy(xpath = "//*/android.view.View[contains(text(),'Forgot password?')]")
//	private WebElement forgotPassword;
//	
//	@FindBy(xpath = "//*/android.view.Button[contains(@text,'power Logout')]")
//	private WebElement logoutButton;
	
	//*[@id="tabpanel-t0-4"]/page-more-options/ion-content/div[2]/ion-list/button/div[1]/div/ion-label/button
	//*[@id="tabpanel-t0-4"]/page-more-options/ion-content/div[2]/ion-list/ion-item[1]/div[1]/div/ion-label/button

//	@FindBy(xpath = "//*/android.widget.Button[contains(@text,'bug My profile')]")
//	private WebElement myProfileButton;
	
	
	
//	
//	@FindBy(xpath = "//*/android.widget.Button[contains(@text,'arrow back BACK')]")
//	private WebElement profileBackButton;
//	
//	@FindBy(xpath = "//*/android.widget.TextView[contains(@text,'Name')]/following-sibling::android.view.View")
//	private WebElement userName;
//	
//	@FindBy(xpath = "//*/android.widget.TextView[contains(@text,'Signed in as')]/following-sibling::android.view.View")
//	private WebElement userLoginAs;
//	
//	@FindBy(xpath = "//*/android.widget.TextView[contains(@text,'Email address')]/following-sibling::android.view.View")
//	private WebElement userEmail;
//	
//	@FindBy(xpath = "//*/android.widget.TextView[contains(@text,'User Type')]/following-sibling::android.view.View")
//	private WebElement userType;
	
	@SuppressWarnings("rawtypes")
	public StoriesLoginPage(AppiumDriver mobileDriver) {
		// This initElements method will create all WebElements
		PageFactory.initElements(mobileDriver, this);
	}
	
	/**
	 * enter username
	 * 
	 * @throws Exception
	 */
	public void enterUsername(String username) {
		sendTextToElement(username, storiesUserNameTextBox);

	}
	
	/**
	 * enter password
	 * 
	 * @throws Exception
	 */
	public void enterPassword(String password) {
		sendTextToElement(password, storiesPasswordTextBox);

	}

	
	/**
	 * click on login button
	 * 
	 * @throws Exception
	 */
	public void clickStoriesLoginButton() throws Exception {
		ClickOnMobileButton(storiesLoginButton);
	}
	
	
	public void storiesLogin(String username, String password) throws Exception {
		enterUsername(username);
		enterPassword(password);
		clickStoriesLoginButton();
	}
	
	public void clickOnMyProfileButton() throws Exception {
		Utils.waitInSeconds(2);
		myProfileButton.click();
	}
	
	public String getUserName() {
		return getElementText(userName);
	}
	
	public String getSingedUserName() {
		return getElementText(userLoginAs);
	}
	
	public String getUserEmail() {
		return getElementText(userEmail);
	}
	
	public String getUserType() {
		return getElementText(userType);
	}
	
	public void clickOnLogoutButton() throws Exception {
		ClickOnMobileButton(logoutButton);
	}
	public void verifyLoginedUserDetails(String userName,String signedName, String email, String userType) throws Exception {
		feedbackPage.clickOnMoreButton();
		clickOnMyProfileButton();
		Assert.assertEquals(getUserName(), userName);
		Assert.assertEquals(getSingedUserName(), signedName);
		Assert.assertEquals(getUserEmail(), email);
		
	}
	public void logoutFromApp() throws Exception {
		feedbackPage.clickOnMoreButton();
		clickOnLogoutButton();
	}
}
