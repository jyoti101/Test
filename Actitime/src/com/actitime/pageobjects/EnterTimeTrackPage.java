package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage extends BasePage 
{
	WebDriver driver;
public EnterTimeTrackPage(WebDriver driver)
{
	super(driver); //super statement should be first statement, it will call the super class constructor.
	this.driver =driver;
}
	public void verifyHomePageTitle()
	{
		String expTitle = "actiTIME - Enter Time-Track";
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);
		Reporter.log("Home Page Title is verified", true);
	}

}
