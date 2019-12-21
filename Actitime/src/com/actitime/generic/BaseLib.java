package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib {
	public WebDriver driver;    //global driver in this framework , all the available driver should be equal to this driver
	
	@BeforeMethod
	@Parameters({"browser", "baseurl"})
	
	public void setUp(String browserName, String url)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./exefiles/geckodriver.exe");
		
		driver = new FirefoxDriver();
			Reporter.log("Firefox launched", true);
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./exefiles/chromedriver.exe");
			driver = new ChromeDriver();
			Reporter.log("chrome launched", true);
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "./exefiles/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			Reporter.log("IE launched", true);
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.exe", "./exefiles/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			Reporter.log("Edge launched", true);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		Reporter.log(url+"url navigated", true);
	}

	@AfterMethod
	public void tearDown(ITestResult result)
	{
		String scriptName = result.getMethod().getMethodName();
		if(result.isSuccess())    //true--------------->Pass
		{
			Reporter.log(scriptName+"Script is passed :)", true);
		}
		else                  //false
		{
		Reporter.log(scriptName+"Script is failed", false);	
		ScreenshotLib slib = new ScreenshotLib();
		slib.takeScreenshot(driver, scriptName);
		Reporter.log("screenshot has been taken", true);
		}
		driver.close();
		Reporter.log("Browser Closed", true);
	}

}
