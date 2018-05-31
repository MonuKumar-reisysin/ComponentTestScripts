package com.framework.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhasesPageObjects {
	WebDriver driver;
	@FindBy(id="myTabNew")
	private WebElement list_element;;
	
	@FindBy(xpath="//button[@id='appBtnId']")
	WebElement dropdownSelectApp;
	
	@FindBy(linkText="As a Grantor")
	WebElement SelectAppAsaGrantor;
	
	@FindBy(linkText="As a Grantee")
	WebElement SelectAppAsaGrantee;
	
	@FindBy(xpath="//*[@class='fa fa-home']")
	WebElement IconHome;
	
	@FindBy(xpath="//div[@id='headerIdActivity']")
	WebElement SidebarActivityMenu;
	
	@FindBy(xpath="//div[@id='headerIdBI&Analytics']")
	WebElement SidebarBIAnalyticsMenu;
	
	@FindBy(xpath="//div[@id='headerIdTask']")
	WebElement SidebarTaskMenu;
		
	@FindBy(xpath=".//*[@id='SearchApp']/div[1]")
	WebElement SidebarSearch;
	
	@FindBy(xpath="//div[@id='recentlyViewedHeaderId']")
	WebElement SidebarRecentlyViewed;
	
	@FindBy(xpath="//div[@id='extLinkHeaderId']")
	WebElement SidebarExternalLinks;
	
	@FindBy(xpath="//div[@id='headerId']")
	WebElement SidebarTechnicalSupport;
	
	@FindBy(id="GrantorHome")
	WebElement GrantorHome;
	
	public  List<WebElement> label_allPhase(){
		return list_element.findElements(By.tagName("a"));
	}
	
	public PhasesPageObjects(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		/*waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, govGrantsLauncherButton,new Config(TestBase.OR).getExplicitWait());*/
	}
	public void dropdown_SelectApp(){
		this.dropdownSelectApp.click();
	}
	public void SelectApp_AsaGrantor(){
		SelectAppAsaGrantor.click();	
	}
	public void SelectApp_AsaGrantee(){
		SelectAppAsaGrantee.click();
	}
	public WebElement Icon_Home(){
		return IconHome;	
	}
	public WebElement Sidebar_ActivityMenu(){
		return SidebarActivityMenu;	
	}
	public WebElement Sidebar_BIAnalyticsMenu(){
	   return SidebarBIAnalyticsMenu;	
	}
	public WebElement Sidebar_TaskMenu(){
	   return SidebarTaskMenu;	
	}
	public WebElement Sidebar_Search(){
	   return SidebarSearch;	
	}
	public WebElement Sidebar_RecentlyViewed(){
	   return SidebarRecentlyViewed;	
	}
	public WebElement Sidebar_ExternalLinks(){
      return SidebarExternalLinks;	
	}
	public WebElement Sidebar_TechnicalSupport(){
	  return SidebarTechnicalSupport;	
	}
	public void Grantor_Home(){
		GrantorHome.click();	
	}

}
