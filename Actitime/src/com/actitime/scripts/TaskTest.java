package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;
import com.actitime.pageobjects.ActiveProjectCustPage;
import com.actitime.pageobjects.CreateNewCustPage;
import com.actitime.pageobjects.EditCustInfoPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.OpenTasksPage;

public class TaskTest extends BaseLib
{
@Test
public void createNewCustomer()
{
	String filepath = "./testdata/testdata.xlsx";
	String username = ExcelUtilities.readData(filepath, "sheet1", 3, 1);
	String password = ExcelUtilities.readData(filepath, "sheet1", 3, 2);
	String customerName = ExcelUtilities.readData(filepath, "sheet1",3,3);
	LoginPage lp = new LoginPage(driver);
	lp.login(username, password);
	EnterTimeTrackPage ettp = new EnterTimeTrackPage(driver);
	ettp.clickOnTasks();
	OpenTasksPage otp = new OpenTasksPage(driver);
	otp.clickOnProjNcustLink();
	ActiveProjectCustPage apct = new ActiveProjectCustPage(driver);
	apct.clickOnCreateNewCustBtn();
	CreateNewCustPage cncp = new CreateNewCustPage(driver);
	cncp.createCustomer(customerName);
	apct.verifyCreateCustMsg(customerName);
	apct.clickOnLogout();

}
@Test(dependsOnMethods=("createNewCustomer"))
public void deleteCustomer()
{
	String filepath = "./testdata/testdata.xlsx";
	String username = ExcelUtilities.readData(filepath, "sheet1", 4, 1);
	String password = ExcelUtilities.readData(filepath, "sheet1", 4, 2);
	LoginPage lp = new LoginPage(driver);
	lp.login(username, password);
	EnterTimeTrackPage ettp = new EnterTimeTrackPage(driver);
	ettp.clickOnTasks();
	OpenTasksPage otp = new OpenTasksPage(driver);
	otp.clickOnProjNcustLink();
	
	String customerName = ExcelUtilities.readData(filepath, "sheet1", 4, 3);
	ActiveProjectCustPage apct = new ActiveProjectCustPage(driver);
	apct.showCustomer(customerName);
	EditCustInfoPage ecip = new EditCustInfoPage(driver);
	ecip.deleteCustomer();
	apct.verifyDeleteCustMsg();
	apct.clickOnLogout();

}
}
