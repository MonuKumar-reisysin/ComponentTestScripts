package com.framework.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.Logger.LoggerHelper;
import com.framework.PageObject.LoginPage;
import com.framework.testBase.Config;
import com.framework.testBase.TestBase;
import com.framework.utility.VerificationHelper;
import com.framework.utility.WaitHelper;


public class LoginPage {
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	
	
	@FindBy(xpath=".//*[@id='username']")
	WebElement userName;
	
	@FindBy(xpath=".//*[@id='password']")
	WebElement password;
	
	@FindBy(xpath=".//*[@id='Login']")
	WebElement buttonLogin;
	
	@FindBy(xpath=".//*[@id='tabContainer']//*[@title='GovGrants Launcher Tab']")
	WebElement successLogin;
		

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		/*waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, buttonLogin,new Config(TestBase.OR).getExplicitWait());*/
	}
	
	public void clickOnSignInButton(){
		log.info("clicked on sign in Button...");
		buttonLogin.click();
	}
	
	public void enterUserName(String emailAddress){
		log.info("entering email address...."+emailAddress);
		this.userName.sendKeys(emailAddress);
	}
	
	public void enterPassword(String password){
		log.info("entering password...."+password);
		this.password.sendKeys(password);
	}
	
	/*public boolean verifySuccessLoginMsg(){
		return new GenricHelper().isDisplayed(successLogin);
	}*/
	
	public boolean verifyLoginSuccess(){
		new VerificationHelper();
		return VerificationHelper.verifyElementPresent(successLogin);
	}
	
	
	public void loginToApplication(String emailAddress, String password){
		
		enterUserName(emailAddress);
		enterPassword(password);
		clickOnSignInButton();
		
	}


}
