package com.actitime.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScreenshotLib  
 {
         public void  takeScreenshot(WebDriver driver, String scriptName)
         {
        	 EventFiringWebDriver efw = new EventFiringWebDriver(driver);
        	 File srcFile = efw.getScreenshotAs(OutputType.FILE);
        	 File destFile = new File("./screenshots/"+scriptName+".png");
        	 
        	 try {
        		 FileUtils.copyFile(srcFile, destFile);
        	 }catch(IOException e)
        	 {
        		 e.printStackTrace();
        	 }
        	 
         }

}
