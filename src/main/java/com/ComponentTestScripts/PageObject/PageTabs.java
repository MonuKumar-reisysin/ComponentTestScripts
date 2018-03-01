package com.ComponentTestScripts.PageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





import com.ComponentTestScripts.helper.Logger.LoggerHelper;
import com.ComponentTestScripts.helper.Wait.WaitHelper;
import com.ComponentTestScripts.testBase.Config;
import com.ComponentTestScripts.testBase.TestBase;
import com.ComponentTestScripts.excelReader.ExcelUtils;

public class PageTabs {
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(PageTabs.class);
	WaitHelper waitHelper;
	private static List<WebElement> list_element = null;
	
	
	
	@FindBy(xpath = ".//button[@id='sticky_bottom_Menu']")
	public WebElement stickyBottomDrpdown;
	
	@FindBy(linkText = "Enable GovGrants Setup")
	public WebElement selectStickyBottomDrpdown;
	
	@FindBy(xpath=".//*[@id='tabContainer']//*[@title='GovGrants Launcher Tab']")
	WebElement govGrantsLauncherButton;
	
	@FindBy(id="appBtnId")
	WebElement selectApp;
	
	@FindBy(linkText="As a Grantor")
	WebElement selectAppAsaGrantor;
	
	@FindBy(xpath=".//*[@id='FundingOpportunity' and @title='Announcements']")
	WebElement tabAnnouncement;
	
	@FindBy(partialLinkText="Draft")
	WebElement linkDraft;
	
	@FindBy(xpath=".//*[@id='toggleFlexTableDraftAnnouncements']//table/tbody/tr[1]/td[8]//*[@title='View']")
	WebElement viewIconUnderDraftAnnouncement;
	
	@FindBy(xpath=".//*[@id='headerButtonsPanel']/div/a")
	WebElement IconModifyPageLayout;
	
	@FindBy(xpath="//input[@type='button' and @title='New Config: Page Tab']")
	WebElement buttonNewConfigPageTab;
	
	@FindBy(xpath="//div[@id='ep']//table/tbody/tr[1]/td[2]//select")
	WebElement recordTypeOfNewRecord;
	
	@FindBy(xpath="//div[@id='ep']//table/tbody/tr[1]/td[2]//*[@title='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//*[@class='pbSubsection']//*[@type='text' and @tabindex='1']")
	WebElement tabTitleText;
	
	@FindBy(xpath="//*[@class='pbSubsection']//*[@type='text' and @tabindex='7']")
	WebElement sortOrderText;
	
	@FindBy(xpath="//*[@class='pbHeader']/table/tbody/tr/td[2]//*[@title='Save']")
	WebElement saveButton;
	
	@FindBy(xpath="//div[@class='bPageBlock brandSecondaryBrd secondaryPalette']//table/tbody/tr[3]/td[1]//a[@title='Edit - Record 2 - TAB-475']")
	WebElement editLink;
	
	@FindBy(xpath=".//div[@class='pbSubsection']/table/tbody/tr[2]/td[2]//select[@title='Hide for Profile - Available']")
	WebElement hideForProfile;
	
	@FindBy(xpath=".//div[@class='pbSubsection']//table/tbody/tr[2]/td[2]//a[@title='Add' and @tabindex='20']")
	WebElement addbutton;
	
	@FindBy(xpath="//*[@id='bottomButtonRow']//*[@title='Save']")
	WebElement savebuttonbottom;
	
	@FindBy(xpath=".//button[@id='profileNamePlaceHolderId']")
	WebElement buttonlogout;
	
	@FindBy(id="Logout")
	WebElement selectlogout;
	
	public PageTabs(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, govGrantsLauncherButton,new Config(TestBase.OR).getExplicitWait());
	}
	
	public void govGrantsLauncher(){
		log.info("clicking sticky button..");
		this.govGrantsLauncherButton.click();
	}
	
	public void dropdown_SelectApp(){
		log.info("clicking sticky button..");
		this.selectApp.click();
	}
	
	public void SelectApp_AsGrantor(){
		log.info("clicking sticky button..");
		this.selectAppAsaGrantor.click();
	}
	
	public void stickyBottom(){
		log.info("clicking sticky button..");
		this.stickyBottomDrpdown.click();
	}
	
	public void select_EnableGovgrantsSetup(){
		log.info("clicking sticky button..");
		this.selectStickyBottomDrpdown.click();
	}
	
	public void draftLink(){
		log.info("clicking on link draft on left side");
		this.linkDraft.click();
	}
	
	public void announcementTab(){
		log.info("clicking on Announcement tab");
		this.tabAnnouncement.click();
	}
	
	public void icon_ViewUnderDraftAnnouncement(){
		log.info("clicking on view icon at record level");
		this.viewIconUnderDraftAnnouncement.click();
	}
	
	public void icon_ModifyPageLayout(){
		log.info("clicking on view icon at record level");
		this.IconModifyPageLayout.click();
	}
	
	public WebElement button_NewConfigPageTab(){
		log.info("clicking on new config page tab button");
		this.buttonNewConfigPageTab.click();
		return buttonNewConfigPageTab;
	}
	
	public WebElement selectConfig_PageTabRecordType(){
		log.info("selecting value as regular from dropdown");
		this.recordTypeOfNewRecord.click();
		return recordTypeOfNewRecord;
	}
	
	public void button_ContinueUnderSelectConfigPageTab(){
		log.info("clicking on continue button");
		this.continueButton.click();
	}
	
	public void txt_TabTitle() throws Exception{
		log.info("clicking and inputing on tab title input box");
	//	System.out.println("--->>"+ExcelUtils.class.getClassLoader().getResource("./").getPath());
	//	ExcelUtils.setExcelFile("\E:\\FrameworkComponents-TestScripts\ComponentTestScripts\src\main\java\com\ComponentTestScripts\data","PageTabInput");
	//	this.tabTitleText.sendKeys(ExcelUtils.getCellData(1,3));
		this.tabTitleText.sendKeys("DemoTab");
	}
	
	public void txt_SortOrder(){
		log.info("clicking and inputing on sort order input box");
		this.sortOrderText.sendKeys("1");
	}
	
	public void button_SaveUnderPageTabEdit(){
		log.info("clicking on save button");
		this.saveButton.click();
	}
	
	public static List<WebElement> label_alltabs(WebDriver driver){
		list_element = driver.findElement(By.id("myTabs")).findElements(By.tagName("a"));
		return list_element;
	}
	
	public void link_EditUnderPageTabConfigOfOverview(){
		log.info("clicking on save button");
		this.editLink.click();
	}
	
	public WebElement select_HideForProfileUnderHideLogicSetting(){
		log.info("clicking on save button");
		this.hideForProfile.click();
		return hideForProfile;
	}
	
	public void button_AddUnderHideLogicSetting(){
		log.info("clicking on save button");
		this.addbutton.click();
	}
	
	public void button_SaveUnderPageTabEditbottom(){
		log.info("clicking on save button");
		this.savebuttonbottom.click();
	}
	
	public void logoutButton(){
		log.info("clicking on logout button");
		this.buttonlogout.click();
	}
	
	public void select_logout(){
		log.info("clicking on logout button");
		this.selectlogout.click();
	}

}
