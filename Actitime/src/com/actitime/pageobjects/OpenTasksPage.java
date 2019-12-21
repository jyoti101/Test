package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenTasksPage
{
	@FindBy(linkText ="Projects & Customers")
	private WebElement projNCustLink;
	
	public OpenTasksPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void clickOnProjNcustLink()
	{
		projNCustLink.click();
	}
}
