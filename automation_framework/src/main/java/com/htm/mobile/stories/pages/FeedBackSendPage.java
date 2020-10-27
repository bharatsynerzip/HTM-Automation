package com.htm.mobile.stories.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.htm.base.MobileElementActions;

import io.appium.java_client.AppiumDriver;


/**
 * This class contains all the elements of Feedback page with all
 * actions
 * 
 * @author Bharat Puri
 *
 */
public class FeedBackSendPage extends MobileElementActions {

	
	@FindBy(xpath = "//a[(@id='tab-t0-4')]")
	private WebElement moreButton;
	
	@FindBy(xpath = "//*[@id=\"tabpanel-t0-4\"]/page-more-options/ion-content/div[2]/ion-list/ion-item[1]/div[1]/div/ion-label/button")
	private WebElement contactUsButton;
	
	@FindBy(xpath = "//ion-input[(@name='subject')]/input")
    private WebElement subjectTextBox;
	
	@FindBy(xpath = "//ion-textarea[(@name='feedback')]/textarea")
	private WebElement feedbackTextBox;
	
	@FindBy(xpath = "//span[contains(text(),'Send')]")
	private WebElement feedbackSendButton;
	
	@FindBy(xpath = "//h3[(@id='alert-subhdr-0')]")
	private WebElement feedbackSuccessMsg;
	
	@FindBy(xpath = "//span[contains(text(),'OK')]")
	private WebElement okButtonOnFeedbackDialog;

	
//	@FindBy(xpath = "//*/android.view.View[contains(@text,'more More')]")
//	private WebElement moreButton;
	
//	@FindBy(xpath = "//*/android.widget.Button[contains(@text,'paper plane Contact us')]")
//	private WebElement contactUsButton;
//	
//	@FindBy(xpath = "//*/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.widget.EditText")
//	private WebElement subjectTextBox;
//	
//	@FindBy(xpath = "//*/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.widget.EditText")
//	private WebElement feedbackTextBox;
//
//	@FindBy(xpath = "//*/android.widget.Button[contains(@text,'SEND')]")
//	private WebElement feedbackSendButton;
//	
//	@FindBy(xpath = "//*/android.view.View[contains(@text,'Your feedback is submitted.')]")
//	private WebElement feedbackSuccessMsg;
//	
//	@FindBy(xpath = "//*/android.widget.Button[contains(@text,'OK')]")
//	private WebElement okButtonOnFeedbackDialog;

	
	@SuppressWarnings("rawtypes")
	public FeedBackSendPage(AppiumDriver mobileDriver) {
		// This initElements method will create all WebElements
		PageFactory.initElements(mobileDriver, this);
	}

	
	public void clickOnMoreButton() throws Exception {
		ClickOnMobileButton(moreButton);
	}
	
	public void clickOnContactUsButton() throws Exception {
		ClickOnMobileButton(contactUsButton);
	}
	
	public void enterSubject(String text) throws Exception {
		sendTextToElement(text, subjectTextBox);
	}
	
	public void enterfeedback(String text) throws Exception {
		sendTextToElement(text, feedbackTextBox);
	}
	
	public void clickOnSendButton() throws Exception {
		ClickOnMobileButton(feedbackSendButton);
	}
	
	 public String getActualTextOnFeedbackDialog() {
		 return getElementText(feedbackSuccessMsg);
	 }

	
	public void clickOnOkButton() throws Exception {
		ClickOnMobileButton(okButtonOnFeedbackDialog);
	}
	
	
	public void sendFeedback(String subject, String feedback, String expectedFeedbackMsg) throws Exception {
		clickOnMoreButton();
		clickOnContactUsButton();
		enterSubject(subject);
		enterfeedback(feedback);
		clickOnSendButton();
		System.out.println(getActualTextOnFeedbackDialog());
		Assert.assertEquals(getActualTextOnFeedbackDialog(), expectedFeedbackMsg);
		clickOnOkButton();
		pressAndroidBackButton(htmStoriesMobileDriver);
	}
}

