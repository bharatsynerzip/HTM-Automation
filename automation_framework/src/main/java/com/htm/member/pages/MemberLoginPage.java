package com.htm.member.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.htm.base.ElementActions;

/**
 * This class contains all the elements of Member login page with all
 * actions
 * 
 * @author Bharat Puri
 *
 */
public class MemberLoginPage extends ElementActions {
	
	@FindBy(xpath = "(//*[@id=\"htm-login-username\"])")
	private WebElement memberUserNameTextBox;
	
	@FindBy(xpath = "(//*[@id=\"htm-login-password\"])")
	private WebElement memberPasswordTextBox;
	
	@FindBy(xpath = "(//*[@id=\"htm-login-submit\"])")
	private WebElement memberLoginButton;
	
	@FindBy(xpath = "(//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li/h4)")
	private WebElement memberLoginMsg;
	
	
	
	public MemberLoginPage(WebDriver webDriver) {
		// This initElements method will create all WebElements
		PageFactory.initElements(webDriver, this);
	}
	
	/**
	 * enter username
	 * 
	 * @throws Exception
	 */
	public void enterUsername(String username) {
		sendTextToElement(username, memberUserNameTextBox);

	}
	
	/**
	 * enter password
	 * 
	 * @throws Exception
	 */
	public void enterPassword(String password) {
		sendTextToElement(password, memberPasswordTextBox);

	}
	
	public String getLoginMsg() {
		
		return getElementText(memberLoginMsg);
		
	}
	
	/**
	 * click on login button
	 * 
	 * @throws Exception
	 */
	public void clickHTMLoginButton() throws Exception {
		clickOnElement(memberLoginButton);
	}
	
	public void htmMemberLogin(String username, String password) throws Exception {
		enterUsername(username);
		enterPassword(password);
		clickHTMLoginButton();
	}
}
