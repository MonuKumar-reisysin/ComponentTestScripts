package com.framework.PageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.Logger.LoggerHelper;
import com.framework.testBase.Config;
import com.framework.testBase.TestBase;
import com.framework.utility.WaitHelper;

public class CustomAppPageObjects {
	private final Logger log = LoggerHelper.getLogger(PageTabs.class);
	WebDriver driver;
	private static List<WebElement> list_element = null;
	WaitHelper waitHelper;
	
	
	
	@FindBy(xpath=".//*[@id='tabContainer']//*[@title='GovGrants Launcher Tab']")
	WebElement govGrantsLauncherButton;
	
	@FindBy(id="appBtnId")
	WebElement customappbuton;
	
	public CustomAppPageObjects(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		/*waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, govGrantsLauncherButton,new Config(TestBase.OR).getExplicitWait());*/
	}
	
	public void govGrantsLauncher(){
		log.info("clicking sticky button..");
		this.govGrantsLauncherButton.click();
	}
	
	public void button_CustomApp(){
		log.info("clicking on customApp button");
		this.customappbuton.click();
	}
	
	public static List<WebElement> allcreatedCUstomApp(WebDriver driver){
		list_element = driver.findElement(By.id("appDropDownMenuId")).findElements(By.tagName("a"));
		return list_element;
	}
	
	public static List<WebElement> allcreatedCUstomApplogo(WebDriver driver){
		list_element = driver.findElement(By.id("appDropDownMenuId")).findElements(By.tagName("img"));
		return list_element;
	}

}
