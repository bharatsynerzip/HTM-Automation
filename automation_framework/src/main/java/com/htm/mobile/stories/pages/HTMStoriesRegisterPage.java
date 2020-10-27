package com.htm.mobile.stories.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.htm.base.MobileElementActions;

import io.appium.java_client.AppiumDriver;

/**
 * This class contains all the elements of Member Register page with all
 * actions
 * 
 * @author Bharat Puri
 *
 */
public class HTMStoriesRegisterPage extends MobileElementActions {
	
	@FindBy(xpath = "//*/android.widget.Button[contains(@text,'NOT A MEMBER REGISTER PSST')]")
	private WebElement registerButton;
	
	@FindBy(xpath = "//*/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[3]/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	private WebElement firstName;
	
	@FindBy(xpath = "//*/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[3]/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	private WebElement lastName;
	
	@FindBy(xpath = "//*/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[3]/android.view.View[5]/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	private WebElement phoneNumber;
	
	@FindBy(xpath = "//*/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[3]/android.view.View[7]/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	private WebElement email;
	
	@FindBy(xpath = "//*/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[3]/android.view.View[9]/android.view.View/android.view.View/android.view.View/android.widget.EditText")
	private WebElement password;
	
	@FindBy(xpath = "//*/android.widget.EditText[@text='Retype your password']")
	private WebElement rePassword;
	
	
	@FindBy(xpath = "//*/android.widget.CheckBox[contains(@resource-id,'checkbox-8-0')]")
	private WebElement checkBox;

//	@FindBy(xpath = "//*/android.widget.Button[contains(@text,'READY TO CALM DOWN NOW')]")
//	private WebElement readyToCalmDownNowButton;
	
	@FindBy(xpath = "//*/android.view.View[contains(text(),'Already registered')]")
	private WebElement alreadyRegister;

	//*/android.view.View[contains(text(),'Already registered')]

//	@FindBy(className=".input.username")
//	private WebElement registerButton1;
	
	@SuppressWarnings("rawtypes")
	public HTMStoriesRegisterPage(AppiumDriver mobileDriver) {
		// This initElements method will create all WebElements
		PageFactory.initElements(mobileDriver, this);
	}


	public void clickOnRegisterButon() throws Exception {
		clickOnElement(registerButton);

	}
	public void enterFirstName(String text)  {
		sendTextToElement(text, firstName);
		//int abc = firstName.size();
		//System.out.println(" The list of elements " + abc);
		 //firstName.get(0).sendKeys(text);

	}
	
	public void enterLastName(String text)  {
		sendTextToElement(text, lastName);
		//firstName.get(1).sendKeys(text);

	}
	public void enterPhoneNumber(String phone)  {
		sendTextToElement(phone, phoneNumber);

	}
	
	public void enterEmail(String emailId)  {
		sendTextToElement(emailId, email);

	}
	
	public void enterPassword(String text)  {
		sendTextToElement(text, password);

	}
	
	public void enterRePassword(String text)  {
		sendTextToElement(text, rePassword);

	}
	
	public void clickOnCheckBox() throws Exception {
		clickOnElement(checkBox);

	}
	
	
	public void clickReadyToCalmDownNowButton() throws Exception {
//		WebElement readyToCalmDownButton = htmStoriesMobileDriver.findElement(By.xpath("//*/android.widget.Button[contains(@text,'READY TO CALM DOWN NOW')]"));
//		readyToCalmDownButton.click();
		WebElement element = htmStoriesMobileDriver.findElement(By.xpath("//*/android.widget.Button[contains(@text,'READY TO CALM DOWN NOW')]"));
		JavascriptExecutor executor = (JavascriptExecutor)htmStoriesMobileDriver;
		executor.executeScript("arguments[0].removeAttribute(\"disabled\");", element);
		
		
//		
//		input_field = browser.find_element(:xpath, '/html/body/div[5]/div/div[3]/div[2]/div[2]/div/div/div/div/div/div/input')
//				browser.execute_script('arguments[0].removeAttribute("disabled");', input_field)

	}
	

	
	public void registerNewUserStories(String firstName, String lastName, String phone, String email, String pass, String rePass) throws Exception {
		clickOnRegisterButon();
		enterFirstName(firstName);
		enterLastName(lastName);
		enterPhoneNumber(phone);
		enterEmail(email);
		enterPassword(pass);
		scrollToAnElementByText(htmStoriesMobileDriver, "READY TO CALM DOWN NOW");
		enterRePassword(rePass);
		clickOnCheckBox();

		clickReadyToCalmDownNowButton();
	}
}
