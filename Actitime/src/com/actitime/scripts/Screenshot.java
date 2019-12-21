package com.actitime.scripts;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Screenshot {

	public static void main(String args[]) throws Exception{
		String key ="webdriver.ie.driver";
		String value= ".\\Exefiles\\IEDriverServer.exe";
	     System.setProperty(key,value);
	     WebDriver driver = new InternetExplorerDriver();
	     
	     
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.allenedwin.com/");
		
     Thread.sleep(2000);
     ru.yandex.qatools.ashot.Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
     ImageIO.write(fpScreenshot.getImage(),"PNG",new File("C:/ShareDK/newabc.png"));
     driver.quit();
        }
}
