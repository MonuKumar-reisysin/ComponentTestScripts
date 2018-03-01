package com.ComponentTestScripts.loginPage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ComponentTestScripts.PageObject.LoginPage;
import com.ComponentTestScripts.helper.Logger.LoggerHelper;
import com.ComponentTestScripts.testBase.Config;
import com.ComponentTestScripts.testBase.TestBase;


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
