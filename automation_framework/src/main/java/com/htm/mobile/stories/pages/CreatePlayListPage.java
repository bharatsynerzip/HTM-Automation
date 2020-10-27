package com.htm.mobile.stories.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.htm.base.MobileElementActions;
import com.htm.utils.Utils;

import io.appium.java_client.AppiumDriver;

public class CreatePlayListPage extends MobileElementActions{
	
	DownloadStoriesPage downloadPage = new DownloadStoriesPage(htmStoriesMobileDriver);
	
	@FindBy(xpath = "((//button[contains(text(),'For free Users Only Test Test Test Test')])/following-sibling::button)[2]")
	private WebElement addToPlaylistOption;
	
	@FindBy(xpath = "//span[contains(text(),'Create New Playlist')]")
	private WebElement createNewPlaylistOption;
	
	@FindBy(xpath = "//input[(@id='alert-input-0-0')]")
	private WebElement enterNewPlaylistTextBox;
	
	@FindBy(xpath = "//span[contains(text(),'Save')]")
	private WebElement saveNewPlaylistOption;

	
	@FindBy(xpath = "(//span[(@class='button-inner')])[3]")
	private WebElement backOptionFromStroiesList;
	
	@FindBy(xpath = "//div[contains(text(),'myplaylist1')]")
	private WebElement myPlaylistOneOption;
	
	@FindBy(xpath = "((//span[(@class='button-inner')])/div)")
	private List<WebElement> list;
	
	@FindBy(xpath = "(/html/body/ion-app/ion-modal/div/page-playlist-module/ion-content/div[2]/ion-list/ion-item[2]/div[1]/div/ion-label/button/span/text())[2]")
	private WebElement myPlaylist1;
	
	@FindBy(xpath = "//button[contains(text(),'Free User Test')]")
	private WebElement freeUserTestInMyPlaylist;
	
	@FindBy(xpath = "//*[@id=\"categoryScroll\"]/div/div/playlist/div/ion-slides/div/div[1]/ion-slide/div/ion-card/ion-row/ion-col[1]/button")
	private WebElement myPlaylistOption;


	@SuppressWarnings("rawtypes")
	public CreatePlayListPage(AppiumDriver mobileDriver) {
		// This initElements method will create all WebElements
		PageFactory.initElements(mobileDriver, this);
	}
	
	public void clickOnAddToPlaylistOption() throws Exception {
		ClickOnMobileButton(addToPlaylistOption);
	}
	
	public void clickOnCreatePlaylistOption() throws Exception {
		ClickOnMobileButton(createNewPlaylistOption);
	}
	
	public void enterPlaylistName(String playlistName) {
		sendTextToElement(playlistName, enterNewPlaylistTextBox);
		
	}
	
	public void clickOnSaveNewPlaylistOption() throws Exception {
		ClickOnMobileButton(saveNewPlaylistOption);
	}
	
	
	public void clickOnBackOptionFromStoriesListScreen() throws Exception {
		ClickOnMobileButton(backOptionFromStroiesList);
	}
	
	public String getPlaylistNameByText(String playlistName) {
		
		System.out.println(list.size());
		
		for (WebElement li : list) {
			Utils.waitInSeconds(2);
			if (li.getText().equalsIgnoreCase(playlistName)) {
				break;
			}
		}
		return playlistName;
	}
	
	public void ClickOnMyplayList1(String playlistName) throws Exception {
		
		System.out.println(list.size());
		
		for (WebElement li : list) {
			Utils.waitInSeconds(2);
			if (li.getText().equalsIgnoreCase(playlistName)) {
				clickOnElementUsingJavaScript(htmStoriesMobileDriver,li);
				break;
			}
		}
		
	}
	
	public void clickOnMyplaylist() throws Exception {
		ClickOnMobileButton(myPlaylist1);
	}
	
	public String getFreeUserTestStoryTest() {
		return getElementText(freeUserTestInMyPlaylist);
	}
	
	public void createNewPlaylistAndVerifyAddedStory(String playlistName, String stroyName) throws Exception {
		downloadPage.clickOnStories();
		clickOnAddToPlaylistOption();
		clickOnCreatePlaylistOption();
		enterPlaylistName(playlistName);
		clickOnSaveNewPlaylistOption();
		pressAndroidBackButton(htmStoriesMobileDriver);
		clickOnBackOptionFromStoriesListScreen();	
		Assert.assertEquals(getPlaylistNameByText(playlistName), playlistName);
		ClickOnMyplayList1(playlistName);
		Assert.assertEquals(getFreeUserTestStoryTest(), stroyName);
		clickOnBackOptionFromStoriesListScreen();
		System.out.println("Test pass");
	}
}
