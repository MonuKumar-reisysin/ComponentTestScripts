package com.framework.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.Eyes;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.RectangleSize;
import com.framework.PageObject.LoginPage;
import com.framework.testBase.Config;

public class VisualTest {
	static LoginPage loginPage;
	String emailAddress;
	String password;
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		Eyes eyes = new Eyes();
	    eyes.setApiKey("pALfmEOqXn107pGl111DMLQOCdmNumMnf11197VCHWCZ81wGyQ110");
	    eyes.setMatchLevel(MatchLevel.LAYOUT2);
	    try{
	    	eyes.open(driver, "pluralsight.com", "pluralsight Audition",new RectangleSize(1000, 600));
	    	
	    	driver.get("https://www.pluralsight.com");
	    	eyes.checkWindow("Pluralsight Main Page");
	    	
	    	driver.findElement(By.xpath("//*[@class='header_nav--menu header_nav_courses']//a")).click();
	    	
	    	eyes.checkWindow("Browse courses");
	    	eyes.close();
	    	
	    }finally{
	    	driver.quit();
	    }
		
	}

}
