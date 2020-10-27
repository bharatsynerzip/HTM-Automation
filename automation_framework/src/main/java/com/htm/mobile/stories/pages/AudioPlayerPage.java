package com.htm.mobile.stories.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.htm.base.MobileElementActions;
import com.htm.utils.Utils;

import io.appium.java_client.AppiumDriver;

public class AudioPlayerPage extends MobileElementActions {
	
	
	DownloadStoriesPage downloadPage = new DownloadStoriesPage(htmStoriesMobileDriver);
	CreatePlayListPage createPlaylistPage = new CreatePlayListPage(htmStoriesMobileDriver);
	
	@FindBy(xpath = "//button[contains(text(),'MINICAT AND THE HOLE')]")
	private WebElement minicatAndTheHoleStroy;
	
	@FindBy(xpath = "//div[contains(text(),'MINICAT AND THE HOLE')]")
	private WebElement playMinicatHoleStory;
	
	@FindBy(xpath = "//div[contains(text(),'For free Users Only Test')]")
	private WebElement playForFreeStory;
	
	@FindBy(xpath = "(//ion-label[(@class='htm-time-label label label-md')])/span[1]")
	private WebElement runningTime;
	
	@FindBy(xpath = "(//ion-label[(@class='htm-time-label label label-md')])/span[2]")
	private WebElement totalTime;
	
	@FindBy(xpath = "(//button[(@class='htm-player-btn')])[5]")
	private WebElement forwordNextStory;
	
	@FindBy(xpath = "(//button[(@class='htm-player-btn')])[3]")
	private WebElement previousStory;
	
	@FindBy(xpath = "(//button[(@class='htm-player-btn')])[4]")
	private WebElement playStoryOption;
	
	@FindBy(xpath = "(//button[(@class='htm-player-btn')])[2]")
	private WebElement backward30SecondOption;
	
	@FindBy(xpath = "(//button[(@class='htm-player-btn')])[1]")
	private WebElement forward30SecondOption;

	
	@SuppressWarnings("rawtypes")
	public AudioPlayerPage(AppiumDriver mobileDriver) {
		// This initElements method will create all WebElements
		PageFactory.initElements(mobileDriver, this);
	}
	
	public void clickToPlayMiniCatStroy() throws Exception {
		ClickOnMobileButton(minicatAndTheHoleStroy);
	}
	
	public String getPlayingStoryName() {
		return getElementText(playMinicatHoleStory);
	}
	
	public void clickOnPauseOption() throws Exception {
		ClickOnMobileButton(playStoryOption);
	}
	
	public void clickOnPlayNextStroyOption() throws Exception {
		ClickOnMobileButton(forwordNextStory);
	}
	
	public String getPlayingFreeUserStoryName() {
		return getElementText(playForFreeStory);
	}
	
	public void clickOnPlayPreviousStroyOption() throws Exception {
		ClickOnMobileButton(previousStory);
	}
	
	public void clickOnFastForwardOption() throws Exception {
		ClickOnMobileButton(forward30SecondOption);
	}
	
	public void clickOnBackOption() throws Exception {
		ClickOnMobileButton(backward30SecondOption);
	}
	
	public String getCurrentRunningTime() {
		return getElementText(runningTime);
	}
	
	public void verifyAudioPlayerFunctions(String minicatHoleName, String freeUserStroyName) throws Exception {
		downloadPage.clickOnStories();
		clickToPlayMiniCatStroy();
		System.out.println(getPlayingStoryName());
		Assert.assertEquals(getPlayingStoryName(), minicatHoleName);
		clickOnPlayNextStroyOption();
		System.out.println(getPlayingFreeUserStoryName());
		Assert.assertEquals(getPlayingFreeUserStoryName(), freeUserStroyName);
		clickOnPlayPreviousStroyOption();
		System.out.println(getPlayingStoryName());
		Assert.assertEquals(getPlayingStoryName(), minicatHoleName);
		clickOnPauseOption();
		createPlaylistPage.clickOnBackOptionFromStoriesListScreen();
	}
	
	public void verifyFastForwardOptionOnAudioPlayer() throws Exception {
		downloadPage.clickOnStories();
		clickToPlayMiniCatStroy();
		Utils.waitInSeconds(2);
		System.out.println(getCurrentRunningTime());
		clickOnFastForwardOption();
		System.out.println(getCurrentRunningTime());
		clickOnBackOption();
		System.out.println(getCurrentRunningTime());
		clickOnPauseOption();
		createPlaylistPage.clickOnBackOptionFromStoriesListScreen();
	}
}
