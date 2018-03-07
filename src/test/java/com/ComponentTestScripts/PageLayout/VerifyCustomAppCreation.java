package com.ComponentTestScripts.PageLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.Logger.LoggerHelper;
import com.framework.PageObject.CustomAppPageObjects;
import com.framework.PageObject.LoginPage;
import com.framework.PageObject.PageTabs;
import com.framework.customApp.TestCreationOfCustApp;
import com.framework.testBase.Config;
import com.framework.testBase.TestBase;
import com.framework.utility.WaitHelper;
import com.framework.vo.CustomAppVO;

public class VerifyCustomAppCreation extends TestBase {
	private final Logger log = LoggerHelper.getLogger(PageTabScripts.class);
	
	LoginPage loginPage;
	WaitHelper waithelper;
	PageTabs pagetab;
	boolean methodPassed = false; 
	
	@Test
	public void creationOfTestCustomApp(){
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
		waithelper.setPageLoadTimeout(90, TimeUnit.SECONDS);
		
		List<String> ExpectedCustomApp = new ArrayList<String>();
		List<String> ActualCustomApp = new ArrayList<String>();
		
		List<WebElement> listOfCustomApp = CustomAppPageObjects.allcreatedCUstomApp(driver);
		for(WebElement li: listOfCustomApp){
			ActualCustomApp.add(li.getAttribute("title"));
		}
		
		String[] strActualCustomApp = new String [ActualCustomApp.size()] ;
		ActualCustomApp.toArray(strActualCustomApp);
		
		List<CustomAppVO> appList = TestCreationOfCustApp.main();
		for(CustomAppVO f: appList){
			ExpectedCustomApp.add(f.getGNT__Label__c());
		}
		String[] strExpectedCustomApp = new String[ExpectedCustomApp.size()];
		ExpectedCustomApp.toArray(strExpectedCustomApp);
		
		if(strActualCustomApp.length == strExpectedCustomApp.length){
			for(int i=0; i< strExpectedCustomApp.length; i++){
				if(!(strActualCustomApp[i].equals(strExpectedCustomApp[i]))){
					Assert.assertEquals(strActualCustomApp[i],strExpectedCustomApp[i],"Test case fail: Custom App on config doesnot match with ui custom App");
				}
			}
		}
		else{
				Assert.assertEquals(strActualCustomApp.length, strExpectedCustomApp.length,"Custom App count on config and on ui doesnot match");
				}
		methodPassed = true;
		}
	}


