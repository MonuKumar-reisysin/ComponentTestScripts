package com.framework.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.Logger.LoggerHelper;
import com.framework.PageObject.LoginPage;
import com.framework.PageObject.PageTabs;

import com.framework.excelReader.Excel_Reader;
import com.framework.testBase.Config;
import com.framework.testBase.TestBase;
import com.framework.utility.DropDownHelper;
import com.framework.utility.JavaScriptHelper;
import com.framework.utility.RedirectionHelper;
import com.framework.utility.WaitHelper;



public class PageTabScripts extends TestBase{
	
	private final Logger log = LoggerHelper.getLogger(PageTabScripts.class);
	LoginPage loginPage;
	JavaScriptHelper javaScripthelper;
	WaitHelper waithelper;
	String emailAddress;
	String password;
	PageTabs pagetab;
	RedirectionHelper browserhelper;
	DropDownHelper dropdownhelper;
	Excel_Reader excelReader;
	boolean methodPassed = false;
	
	
	@Test (priority=1)
	public void creationOfNewTabAtPageLayout() throws Exception{
		log.info(PageTabScripts.class.getName()+" started");
		
		Config config = new Config(OR);
		System.out.println(config);
		driver.get(config.getWebsite());
		
		loginPage = new LoginPage(driver);
		loginPage.enterUserName(config.getUserName());
		loginPage.enterPassword(config.getPassword());
		loginPage.clickOnSignInButton();
		
		pagetab = new PageTabs(driver);
		pagetab.govGrantsLauncher();
		
		waithelper = new WaitHelper(driver);
		waithelper.setPageLoadTimeout(90, TimeUnit.SECONDS);
		
		pagetab.dropdown_SelectApp();
		pagetab.SelectApp_AsGrantor();
		Thread.sleep(6000);
				
	    javaScripthelper = new JavaScriptHelper(driver);
	    javaScripthelper.scrollDownVertically();
	    
	    pagetab.stickyBottom();
	    pagetab.select_EnableGovgrantsSetup();
		pagetab.announcementTab();
		pagetab.draftLink();
		pagetab.icon_ViewUnderDraftAnnouncement();
	
		
		if(driver.getPageSource().contains("DemoTab")){
			System.out.println("Initiall  -> Fail");
		}else{
			System.out.println("Initial  -> Pass");
		}
		
		
/*		List<String> listExpectedTab = new ArrayList<String>();
		List<String> listActualTab = new ArrayList<String>();
		List<WebElement> listOfLiTabs = pagetab.label_alltabs(driver);
		for(WebElement li : listOfLiTabs) {
	        listActualTab.add(li.getAttribute("name"));
	       // System.out.println(listActualTab);
		}
		
		String[] strActualTabList = new String[listActualTab.size()];   // Convert List<String> array to string array.
		listActualTab.toArray(strActualTabList);
		System.out.println(strActualTabList);
		
*/		
		browserhelper = new RedirectionHelper(driver);
		browserhelper.getWindowHandlens();
		pagetab.icon_ModifyPageLayout();
		browserhelper.SwitchToWindow(1);
		
		/*javaScripthelper = new JavaScriptHelper(driver);
		WebElement newConfigPageTab = pagetab.button_NewConfigPageTab();
		javaScripthelper.scrollToElement(newConfigPageTab);*/
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 790)", "");
		
		pagetab.button_NewConfigPageTab();
		
		Thread.sleep(4000);
		
		dropdownhelper = new DropDownHelper(driver);
		WebElement selectRecordType = pagetab.selectConfig_PageTabRecordType();
		dropdownhelper.SelectUsingVisibleValue(selectRecordType, "Regular");
		pagetab.button_ContinueUnderSelectConfigPageTab();
		
		pagetab.txt_TabTitle();
		pagetab.txt_SortOrder();
		pagetab.button_SaveUnderPageTabEdit();
		Thread.sleep(3000);
		browserhelper.switchToParentWithChildClose();
		browserhelper.refresh();
		
		
		
/*
		List<TabNameVO> tablist= TestGetTabList.main();						  
		for(TabNameVO f: tablist){
			listExpectedTab.add(f.getGNT__TabName__c());					
		}
		
		String[] strExpectedTabList = new String[listExpectedTab.size()];   
		listExpectedTab.toArray(strExpectedTabList);
		
		if(strActualTabList.length==strExpectedTabList.length){				 			
			for (int i = 0; i < strExpectedTabList.length; i++){
				if(!(strActualTabList[i].equals(strExpectedTabList[i]))){
					Assert.assertEquals(strActualTabList[i],strExpectedTabList[i],"Test Case Fail: Tab on UI and on Config does not match");
				}
			}
			}else{
				Assert.assertEquals(strActualTabList.length,strExpectedTabList.length,"Test Case Fail: TAb count on UI and on Config does not match");
			}               		
		
	*/	
		
		if(driver.getPageSource().contains("DemoTab")){
			System.out.println("later  -> pass");
		}else{
			System.out.println("later  -> Fail");
			Assert.assertEquals(0,1);
			
		}
			methodPassed = true;
			
			pagetab.logoutButton();
			pagetab.select_logout();
		
	}
	
	@Test (priority=2)
	public void testHidePageTabForUserProfile() throws InterruptedException{
    log.info(PageTabScripts.class.getName()+" started");
		
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		
		loginPage = new LoginPage(driver);
		loginPage.enterUserName(config.getUserName());
		loginPage.enterPassword(config.getPassword());
		loginPage.clickOnSignInButton();
		
		pagetab = new PageTabs(driver);
		pagetab.govGrantsLauncher();
		
		waithelper = new WaitHelper(driver);
		waithelper.setPageLoadTimeout(60, TimeUnit.SECONDS);
		
		pagetab.dropdown_SelectApp();
		pagetab.SelectApp_AsGrantor();
		Thread.sleep(3000);
				
	    /*javaScripthelper = new JavaScriptHelper(driver);
	    javaScripthelper.scrollDownVertically();
	    
	    pagetab.stickyBottom();
	    pagetab.select_EnableGovgrantsSetup();*/
		pagetab.announcementTab();
		pagetab.draftLink();
		pagetab.icon_ViewUnderDraftAnnouncement();
		
		browserhelper = new RedirectionHelper(driver);
		browserhelper.getWindowHandlens();
		pagetab.icon_ModifyPageLayout();
		browserhelper.SwitchToWindow(1);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 790)", "");
		
		pagetab.link_EditUnderPageTabConfigOfOverview();
		javaScripthelper.scrollDownVertically();
		
		WebElement selectHideLogic = pagetab.select_HideForProfileUnderHideLogicSetting();
		dropdownhelper.SelectUsingVisibleValue(selectHideLogic, "PO");
		pagetab.button_AddUnderHideLogicSetting();
		//pagetab.button_SaveUnderPageTabEditbottom();
		
	}

}
