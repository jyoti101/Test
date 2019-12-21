package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage {
	@FindBy(name="username")
	private WebElement unTxtBx;
	@FindBy(name ="pwd")
	private WebElement pwdTxtBx;
	@FindBy(id="loginButton")
	private WebElement loginBtn;
	@FindBy(xpath="//span[contains(text(), 'Please try again')]")
	private WebElement invalidLoginMsg;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void login(String username, String password)
	{
		unTxtBx.sendKeys(username);
		pwdTxtBx.sendKeys(password);
		loginBtn.click();
	}
	public void verifyInvalidLoginMsg()
	{
		String expMsg = "Username or Password is invalid. Please try again.";
		String actmsg = invalidLoginMsg.getText();
		Assert.assertEquals(expMsg, actmsg);
		Reporter.log("Invalid Login Message is verified", true);
	}
}
