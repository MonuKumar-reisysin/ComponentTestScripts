package com.ComponentTestScripts.loginPage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.Logger.LoggerHelper;
import com.framework.PageObject.LoginPage;
import com.framework.testBase.Config;
import com.framework.testBase.TestBase;


public class LoginTest extends TestBase {
	private final Logger log = LoggerHelper.getLogger(LoginTest.class);
	
	@Test
	public void testLoginToEGMS(){
		log.info(LoginTest.class.getName()+" started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.loginToApplication(config.getUserName(), config.getPassword());
		boolean status = loginPage.verifyLoginSuccess();
		if(status){
			   log.info("login is sucessful");	
			}
			else{
				Assert.assertTrue(false, "login is not sucessful");
			}
	}

}
