package com.htm.base;

import java.util.List;

import javax.swing.text.html.HTML;

import org.apache.log4j.Logger;
import org.glassfish.grizzly.filterchain.RerunFilterAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.htm.utils.Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MobileElementActions extends MobileTestBase {

	static Logger log = Logger.getLogger(MobileElementActions.class);
	public static WebDriverWait wait;
	@SuppressWarnings("rawtypes")
	public static AndroidDriver androidDriver;
	@SuppressWarnings("unused")
	private WebElement dropdown = null;
	private Select selectList = null;
	JavascriptExecutor myExecutor;

	public MobileElementActions() {

		wait = new WebDriverWait(htmStoriesMobileDriver, 60 * 20);
	}

	/**
	 * Wrapper method for WebDriverWait (ExpectedCondition = elementToBeClickable)
	 * 
	 * @param element
	 * @param timeInSeconds
	 */
	public static void waitForElementClickable(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Wrapper method for WebDriverWait (ExpectedCondition = visibilityOf element)
	 * 
	 * @param element
	 * @param timeInSeconds
	 */
	public static void waitForElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Wrapper method for WebDriverWait (ExpectedCondition = presenceof element)
	 * 
	 * @param element
	 * @param timeInSeconds
	 */
	public static void waitForElementToBePresent(String locatorXpath) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorXpath)));
	}

	/**
	 * Checks if element is displayed
	 * 
	 * @return
	 * @throws Exception
	 */
	public static boolean isElementDisplayed(WebElement element) {
		Utils.waitInSeconds(1);
		return isElementDisplayed(element);
	}

	/**
	 * Checks if element is enabled
	 */
	public static boolean isElementEnabled(WebElement element) {
		Utils.waitInSeconds(1);
		return element.isEnabled();
	}

	/**
	 * Wrapper method for clickOnMenu
	 * 
	 * @param element
	 * @param timeInSecondsx
	 */

	public void selectListValue(String clickMenu, List<WebElement> selectMenu) {
		for (WebElement li : selectMenu) {

			if (li.getText().equalsIgnoreCase(clickMenu)) {
				li.click();
				log.info("Click action performed on element");
				break;
			}
		}
	}
	
	
	/**
	 * clicks On Element
	 * 
	 * @throws Exception
	 */
	public void clickOnElement(WebElement element) throws Exception {
	    waitForElementVisible(element);
		waitForElementClickable(element);
		Utils.waitInSeconds(4);
		if (isElementDisplayed(element)) {
			element.click();
			log.info("Click action performed on element");
		} else
			throw new Exception("Failed to click on element on this locator: " + element.toString());
	}

	public void ClickOnMobileButton(WebElement element) throws Exception {

		Utils.waitInSeconds(2);
		waitForElementClickable(element);
		element.click();
	}

	/**
	 * Get the text present on Web element
	 * 
	 * @param element
	 * @return Text
	 */
	public String getElementText(WebElement element) {
		waitForElementVisible(element);
		Utils.waitInSeconds(1);
		return element.getText();
	}

	public String getElementsText(String clickMenu, List<WebElement> selectMenu) {

		for (WebElement li : selectMenu) {
			waitForElementVisible(li);
			Utils.waitInSeconds(1);
			if (li.getText().equalsIgnoreCase(clickMenu)) {
				log.info("Verified send value is " + clickMenu);
				break;
			}
		}
		return clickMenu;
	}

	/**
	 * Enter the text in any text input element
	 * 
	 * @param text
	 * @param element
	 */
	public void sendTextToElement(String text, WebElement element) {

		waitForElementVisible(element);
		Utils.waitInSeconds(4);
		element.sendKeys(text);
		Utils.waitInSeconds(1);

	}

	/**
	 * This method will clear the text from provided text box element
	 * 
	 * @param element
	 */
	public void clearTextBox(WebElement element) {
		element.clear();
	}

	@SuppressWarnings("unused")
	public void verifyElementFromDropdown(String bytype, WebElement option) {
		selectList = new Select(option);
		List<WebElement> elementCount = selectList.getOptions();
		for (int i = 0; i < elementCount.size(); i++) {
			if (bytype.equalsIgnoreCase(elementCount.get(i).getText()))
				;
			log.info("Verified send value is " + bytype);
			break;
		}
	}

	@SuppressWarnings("rawtypes")
	public void verifyElementByJavascriptExecutorMobile(String text, WebElement option, AppiumDriver javascriptDriver) {
		myExecutor = ((JavascriptExecutor) javascriptDriver);
		myExecutor.executeScript("arguments[0].value='" + text + "';", option);
	}

	@SuppressWarnings("rawtypes")
	public void pressAndroidBackButton(AppiumDriver appiumDriver) {
		androidDriver = (AndroidDriver) appiumDriver;
		androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	
	@SuppressWarnings("rawtypes")
	public void pressTabButton(AppiumDriver appiumDriver) {
		androidDriver = (AndroidDriver) appiumDriver;
		androidDriver.pressKey(new KeyEvent(AndroidKey.TAB));
	}

//	@SuppressWarnings("rawtypes")
//	public void pressTabButton(AppiumDriver appiumDriver) {
//		androidDriver = (AndroidDriver) appiumDriver;
//		androidDriver.pressKey(new KeyEvent(AndroidKey.));
//	}

	public void verifyListValue(String clickMenu, List<WebElement> selectMenu) {
		for (WebElement li : selectMenu) {

			if (li.getText().equalsIgnoreCase(clickMenu)) {
				log.info("Verified send value is " + clickMenu);
				break;
			}
		}
	}

	/**
	 * Select value by text from drop-down list
	 * 
	 * @param element
	 * @param text
	 */
	public void selectValueByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * get first Selected value from drop-down list
	 * 
	 * @param element
	 * @param text
	 */
	public String getFirstSelectedText(WebElement element) {
		Select select = new Select(element);
		WebElement option = select.getFirstSelectedOption();
		return option.getAttribute("innerText");
	}

	
	public void clickOnElementUsingJavaScript(AppiumDriver driver, WebElement element) {
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].click()", element); 
	}
	
	public WebElement scrollToAnElementByText(AppiumDriver<WebElement> driver, String text) {
		return driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector())" + ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
	}

}
