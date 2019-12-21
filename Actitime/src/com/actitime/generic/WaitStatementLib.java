package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatementLib 
{
	WebDriver driver;
	/***************************Constructor************************************************************/
	public WaitStatementLib(WebDriver driver)
	{
		this.driver= driver;
	}
/******************************************HardcodeWait****************************************************************************/
	public void iSleep(int secs)
	{
		try {
		Thread.sleep(secs*1000);
	}catch(InterruptedException e)
		{
		e.printStackTrace();
		}
	}
	
	/*************************************ImplicitWait****************************************************************************/
	
	public void iWaitForSecs(int secs)
	{
		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
	}
	
	/********************************************ExplicitWait**********************************************/
	public void eWaitForVisible(int secs, WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, secs);
		wait.until(ExpectedConditions.visibilityOf(ele));
	} 
	/***************************************Explicit Wait*************************************************/
	public void eRefresh(int secs, WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,secs);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ele)));				
	}
}
