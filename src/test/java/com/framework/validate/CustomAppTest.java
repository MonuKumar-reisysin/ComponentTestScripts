package com.framework.validate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.framework.Logger.LoggerHelper;
import com.framework.PageObject.CustomAppPageObjects;
import com.framework.PageObject.LoginPage;
import com.framework.PageObject.PageTabs;
import com.framework.customApp.CustAppHelper;
import com.framework.main.PageTabScripts;
import com.framework.testBase.Config;
import com.framework.testBase.TestBase;
import com.framework.utility.WaitHelper;
import com.framework.vo.CustomAppVO;

public class CustomAppTest extends TestBase {
	private final Logger log = LoggerHelper.getLogger(PageTabScripts.class);
	
	LoginPage loginPage;
	WaitHelper waithelper;
	PageTabs pagetab;
	String emailAddress;
	String password;
	CustomAppPageObjects customAppPageObjects;
	boolean methodPassed = false;
	
	
	public void loginToEGMS() throws InterruptedException {
		
		
		
        log.info(PageTabScripts.class.getName()+" started");
		
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		
		loginPage = new LoginPage(driver);
		loginPage.enterUserName(config.getUserName());
		loginPage.enterPassword(config.getPassword());
		loginPage.clickOnSignInButton();
		Thread.sleep(7000);
		pagetab = new PageTabs(driver);
		pagetab.govGrantsLauncher();
		
		customAppPageObjects = new CustomAppPageObjects(driver);
		customAppPageObjects.button_CustomApp();
		
		waithelper = new WaitHelper(driver);
		waithelper.setPageLoadTimeout(90, TimeUnit.SECONDS);
	}
	
	public void verifyCustomAppOnUI(){
		
		List<String> ExpectedCustomApp = new ArrayList<String>();
		List<String> ActualCustomApp = new ArrayList<String>();
		
		List<WebElement> listOfCustomApp = CustomAppPageObjects.allcreatedCUstomApp(driver);
		for(WebElement li: listOfCustomApp){
			ActualCustomApp.add(li.getAttribute("title"));
		}
		
		String[] strActualCustomApp = new String [ActualCustomApp.size()];
		ActualCustomApp.toArray(strActualCustomApp);
		
		List<CustomAppVO> appList = CustAppHelper.getCustomApps();
		for(CustomAppVO f: appList){
			ExpectedCustomApp.add(f.getGNT__Label__c());
		}
		String[] strExpectedCustomApp = new String[ExpectedCustomApp.size()];
		ExpectedCustomApp.toArray(strExpectedCustomApp);
		//System.out.println("Actual"+ strActualCustomApp.length +"   Expected "+ strExpectedCustomApp.length);
		if(strActualCustomApp.length == strExpectedCustomApp.length){
			for(int i=0; i< strExpectedCustomApp.length; i++){
				System.out.println("Actual "+strActualCustomApp[i] +"  Expected " +strExpectedCustomApp[i]);
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


