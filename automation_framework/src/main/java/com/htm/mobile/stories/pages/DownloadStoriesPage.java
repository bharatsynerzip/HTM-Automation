package com.htm.mobile.stories.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.htm.base.MobileElementActions;
import com.htm.utils.Utils;

import io.appium.java_client.AppiumDriver;


/**
 * This class contains all the elements of Download Story page with all
 * actions
 * 
 * @author Bharat Puri
 *
 */
public class DownloadStoriesPage extends MobileElementActions{
	
	FeedBackSendPage feedbackPage = new FeedBackSendPage(htmStoriesMobileDriver);
	
	@FindBy(xpath = "//div[contains(text(),'STORIES')]")
	private WebElement storiesButton;
	
	@FindBy(xpath = "(//button[contains(text(),'For free Users Only Test Test Test Test')])/following-sibling::button")
	private WebElement downloadFreeUserStoryFromList;
	
	@FindBy(xpath = "(//button[contains(text(),'MINICAT AND THE HOLE')])/following-sibling::button")
	private WebElement downloadMiniCatStoryFromList;
	
	@FindBy(xpath = "//a[(@id='tab-t0-2')]")
	private WebElement downloadButtonTab;
	
	@FindBy(xpath = "//ion-segment-button[contains(text(),'List')]")
	private WebElement downloadListTab;
	
	@FindBy(xpath = "//ion-segment-button[contains(text(),'By Group')]")
	private WebElement downloadByGroupTab;
	
	@FindBy(xpath = "//ion-segment-button[contains(text(),'By Playlist')]")
	private WebElement downloadByPlaylistTab;
	
	@FindBy(xpath = "(//button[contains(text(),'For free Users Only Test Test Test Test')])[2]")
	private WebElement freeUserStroyInDownloadList;
	
	@FindBy(xpath = "(//button[contains(text(),'MINICAT AND THE HOLE')])[2]")
	private WebElement minicatStroyInDownloadList;
	
	@FindBy(xpath = "//h5[contains(text(),'You have no downloads.')]")
	private WebElement emplyDownloadListOption;
	
	@FindBy(xpath = "//*[@id=\"tabpanel-t0-4\"]/page-more-options/ion-content/div[2]/ion-list/ion-item[8]/div[1]/div/ion-label/button")
	private WebElement deleteAllOfflieAudioOption;
	
	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	private WebElement deleteAllAudioYesOption;
	
	@FindBy(xpath = "//h3[(@id='alert-subhdr-1')]")
	private WebElement deleteAllAudioConfirmText;
	
	@FindBy(xpath = "//span[contains(text(),'OK')]")
	private WebElement deleteAllAudioConfirmOKOption;
	

	//*[@id="tabpanel-t0-2"]/page-downloads/ion-content/div[2]/ion-segment/ion-segment-button[1]
	
//	@FindBy(xpath = "//*/android.view.View[contains(@text,'download Downloads')]")
//	private WebElement downloadButtonTab;
	
//	@FindBy(xpath = "//*/android.widget.Button[contains(@text,'STORIES')]")
//	private WebElement storiesButton;
	
//	@FindBy(xpath = "//*/android.widget.Button[contains(@text,'For free Users Only Test Test Test Test')]")
//	private WebElement downloadFreeUserStoryFromList;
//	// wait for 30 second to download
	
//	@FindBy(xpath = "//*/android.widget.Button[contains(@text,'For free Users Only Test Test Test Test')]/following-sibling::android.widget.Button[contains(@text,'download')]")
//	private WebElement freeUserStroyInDownloadList;
	
	@FindBy(xpath = "//*/android.widget.Button[contains(@text,'For free Users Only Test Test Test Test')]/following-sibling::android.widget.Button[contains(@text,'download')]")
	private WebElement spaceSandwichStroyInDownloadList;
	
	@FindBy(xpath = "//*/android.widget.Button[contains(@text,'For free Users Only Test Test Test Test')]/following-sibling::android.widget.Button[contains(@text,'download')]")
	private WebElement miniCatAndTHeHoleStoryInDownloadList;
	
//	@FindBy(xpath = "//*/android.widget.ToggleButton[contains(@text,'List')]")
//	private WebElement downloadListTab;
	
	@FindBy(xpath = "//*/android.view.View[contains(@text,'You have no downloads.')]")
	private WebElement downloadListEmptyFromListTab;
	
	@SuppressWarnings("rawtypes")
	public DownloadStoriesPage(AppiumDriver mobileDriver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(mobileDriver, this);
	}

	
	
	public void clickOnStories() throws Exception {
		ClickOnMobileButton(storiesButton);
	}
	
	
	public void clickOnDownloadTab() throws Exception {
		ClickOnMobileButton(downloadButtonTab);
	}
	
	public void downloadFreeUserStory() throws Exception {
		ClickOnMobileButton(downloadFreeUserStoryFromList);
		Utils.waitInSeconds(25);
	}
	
	public void clickOnDownloadListTab() throws Exception {
		ClickOnMobileButton(downloadListTab);
	}
	
	public String getDownloadStoryText() {
		return getElementText(freeUserStroyInDownloadList);
	}
	   public String getEmptyDownloadListText() {
		   return getElementText(emplyDownloadListOption);
	   }
		
   public void clickOnDeleteAllAutioOption() throws Exception {
	   ClickOnMobileButton(deleteAllOfflieAudioOption);
   }
   public void clickOnYesOption() throws Exception {
	   ClickOnMobileButton(deleteAllAudioYesOption);
   }
   public String getDeleteAudioConfirmText() {
	   return getElementText(deleteAllAudioConfirmText);
   }
   
   public void clickOnConfirmOkOption() throws Exception {
	   ClickOnMobileButton(deleteAllAudioConfirmOKOption);
   }
	
	public void donwloadFreeUserStroy() throws Exception {
		clickOnStories();
		downloadFreeUserStory();
		clickOnDownloadTab();
		clickOnDownloadListTab();
		System.out.println(getDownloadStoryText());
	}
	
	public void deleteFeeUserStroty() throws Exception {
		feedbackPage.clickOnMoreButton();
		clickOnDeleteAllAutioOption();
		clickOnYesOption();
		System.out.println(getDeleteAudioConfirmText());
		clickOnConfirmOkOption();
		clickOnDownloadTab();
		clickOnDownloadListTab();
		System.out.println(getEmptyDownloadListText());
	}
}
