package com.tofuGearPortal.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tofuGear.qa.base.TestBase;
import com.tofuGearPortal.qa.pages.ContactPage;
import com.tofuGearPortal.qa.pages.HomePage;

public class ContactPageTest extends TestBase {
	
	HomePage HomePage;
	ContactPage ContactPage;
	Logger log = Logger.getLogger(ContactPageTest.class);
	
	public ContactPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		HomePage = new HomePage();
		ContactPage = HomePage.ContactMenu();
	}
	
	@Test(priority=1)
	public void FirstnameTest() {
		log.info("testing firstname is mandatory r not");
		String compulsory = ContactPage.Firstname();
		Assert.assertEquals(compulsory, "true","firstname is optional");
	}
	
	@Test(priority=3)
	public void submitenableTest() {
		log.info("submit button is enabled r not");
		Boolean compulsory = ContactPage.submitenable();
		//Assert.assertEquals(compulsory, "true","submit button isnot enabled");
		Assert.assertTrue(compulsory);
	}
	
	@Test(priority=2)
	public void EmailTest() {
		log.info("testing Emailaddress is mandatory r not");
		String compulsory = ContactPage.Emailaddress();
		Assert.assertEquals(compulsory, "true","Emailaddress is optional");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
