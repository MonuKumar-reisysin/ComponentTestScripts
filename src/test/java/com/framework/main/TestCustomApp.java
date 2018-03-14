package com.framework.main;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
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
import com.framework.customApp.CustAppHelper;
import com.framework.excelReader.Csv_Reader;
import com.framework.testBase.Config;
import com.framework.testBase.TestBase;
import com.framework.utility.WaitHelper;
import com.framework.validate.CustomAppTest;
import com.framework.vo.CustomAppVO;

public class TestCustomApp extends TestBase {
	private final Logger log = LoggerHelper.getLogger(PageTabScripts.class);
	
	Csv_Reader csv_Reader = new Csv_Reader();
	
	LoginPage loginPage;
	WaitHelper waithelper;
	PageTabs pagetab;
	String emailAddress;
	String password;
	CustomAppPageObjects customAppPageObjects;
	boolean methodPassed = false;
	
		
	@SuppressWarnings("static-access")
	@Test
	public void creationOfTestCustomApp() throws Exception{
		
		CustAppHelper custapphelper = new CustAppHelper();
		custapphelper.newCSVReader();
		
		/*CustomAppTest customapptest = new CustomAppTest();
		customapptest.loginToEGMS();
		customapptest.verifyCustomAppOnUI();*/
		
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
	
	
	@Test
	public void verifyCustomAppLogoOnUI() throws UnsupportedEncodingException{
		
		List<String> ExpectedCustomApp = new ArrayList<String>();
		List<String> ActualCustomApp = new ArrayList<String>();
		
		List<WebElement> listOfCustomApp = CustomAppPageObjects.allcreatedCUstomApplogo(driver);
		for(WebElement li: listOfCustomApp){
			ActualCustomApp.add(li.getAttribute("src"));
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
				String actualUrl = strActualCustomApp[i];
				
				try {
					URL url = new URL(actualUrl);
					
					System.out.println("Url Query "+url.getQuery());
					
					String pair = url.getQuery();
					int idx = pair.indexOf("=");
					
					String param_name = URLDecoder.decode(pair.substring(0, idx), "UTF-8");
					String param_val = URLDecoder.decode(pair.substring(idx + 1), "UTF-8");
					
					System.out.println("Param name "+param_name);
					System.out.println("Param val "+param_val);
					
					
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
//				if(!(strActualCustomApp[i].equals(strExpectedCustomApp[i]))){
//					Assert.assertEquals(strActualCustomApp[i],strExpectedCustomApp[i],"Test case fail: Custom App logo on config doesnot match with ui custom App logo");
//				}
//			}
//		}
//		else{
//				Assert.assertEquals(strActualCustomApp.length, strExpectedCustomApp.length,"Custom App logo count on config and on ui doesnot match");
//				}
		methodPassed = true;
//		}
		
	}}}}



