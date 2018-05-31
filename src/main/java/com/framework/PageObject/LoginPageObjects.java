package com.framework.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.Logger.LoggerHelper;
import com.framework.PageObject.LoginPageObjects;
import com.framework.testBase.Config;
import com.framework.testBase.TestBase;
import com.framework.utility.WaitHelper;


public class LoginPageObjects {
	
	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPageObjects.class);
	WaitHelper waitHelper;
	
	
	@FindBy(xpath=".//*[@id='username']")
	WebElement userName;
	
	@FindBy(xpath=".//*[@id='password']")
	WebElement password;
	
	@FindBy(xpath=".//*[@id='Login']")
	WebElement buttonLogin;
	
	@FindBy(xpath=".//*[@id='tryLexDialogX']")
	WebElement popUpWindow;
	
	@FindBy(xpath="//div[@id='tabContainer']//*[@title='GovGrantsLauncher Tab']")
	WebElement govGrantsLauncherButton;
	
	public LoginPageObjects(WebDriver driver) {
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
	
	
	public void popUpClosing(){
		log.info("closing advertisement popup...");
		popUpWindow.click();
	}
	
	public void govGrantsLauncher(){
		log.info("clicking on govgrant launcher button..");
		this.govGrantsLauncherButton.click();
	}
	
		
	public void loginToApplication(String emailAddress, String password){
		
		enterUserName(emailAddress);
		enterPassword(password);
		clickOnSignInButton();
		
	}


}
