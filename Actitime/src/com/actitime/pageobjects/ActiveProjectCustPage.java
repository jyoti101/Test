package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class ActiveProjectCustPage extends BasePage 
{
	@FindBy(css="input[value='Create New Customer']")
	private WebElement createnewCustBtn;
	
	@FindBy(className="successmsg")
	private WebElement successMsg;
	
	@FindBy(name="selectedCustomer")
	private WebElement customerDrpDwn;
	
	@FindBy(css="input[value*='Show']")
	private WebElement showBtn;
	@FindBy(xpath = "//td[starts-with(@id,'customerNameCell')]//a[contains(@href,'customerId')]")
	private WebElement custNameLink;
	public ActiveProjectCustPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCreateNewCustBtn()
	{
		createnewCustBtn.click();
	}
public void verifyCreateCustMsg(String customerName)
{
	//String expMsg = "Customer \"GE HealthCare\" has been successfully created.";  //double quotes can not be written in double qoutes use backward slash
	Assert.assertTrue(successMsg.isDisplayed());
	Assert.assertTrue(successMsg.getText().contains(customerName));
	Reporter.log(successMsg.getText(),true);
}
public void showCustomer(String customerName)
{
	Select sel = new Select(customerDrpDwn);
	sel.selectByVisibleText(customerName);
	showBtn.click();
	if(custNameLink.getText().equals(customerName))
	{
		custNameLink.click();	
	}
	else
	{
		System.out.println(customerName+"does not exist");
	}
}

public void verifyDeleteCustMsg()
{
	String expMsg = "Customer has been successfully deleted.";
	String actmsg = successMsg.getText();
Assert.assertEquals(expMsg, actmsg);
Reporter.log(expMsg, true);
}
}

