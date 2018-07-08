package com.tofuGearPortal.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tofuGear.qa.base.TestBase;
import com.tofuGearPortal.qa.pages.PlatformPage;
import com.tofuGearPortal.qa.pages.HomePage;

public class PlatformPageTest extends TestBase {
	
	HomePage HomePage;
	PlatformPage PlatformPage;
	Logger log = Logger.getLogger(ContactPageTest.class);
	SoftAssert softassert =  new SoftAssert();
	
	
	public PlatformPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		HomePage = new HomePage();
		PlatformPage = HomePage.platformMenu();
	}
	
	@Test(priority=1)
	public void PlatformPagestartingTest() {
	String Title = driver.getTitle();
	softassert.assertEquals(Title, "plat", "Mismatch in the page title");
	log.info("demo video testing");
	Boolean demodisplay = PlatformPage.demodisplay();
	softassert.assertTrue(demodisplay);	
	softassert.assertAll();
	}
	

	@Test(priority=2)
	public void contactenableTest() {
	Boolean contactenable = PlatformPage.contactenable();
	Assert.assertTrue(contactenable);	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}