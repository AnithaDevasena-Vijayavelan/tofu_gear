package com.tofuGear.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.tofuGear.qa.Util.TestUtil;
import com.tofuGear.qa.Util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Applications/Eclipse/Amirtha/selenium/com.tofuGearPortal/src/main/java/com/tofuGear"+"/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Applications/Eclipse/xyz/chromedriver");	
			driver = new ChromeDriver(); 
		}
		else if (browserName.equals("ff")){
			System.setProperty("webdriver.gecko.driver", "/Applications/Eclipse/xyz/geckodriver");	
			driver = new FirefoxDriver(); 
		}
	
		
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
	     WebEventListener handler = new WebEventListener();
		eventDriver.register(handler);
		driver = eventDriver;
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);


}
}

