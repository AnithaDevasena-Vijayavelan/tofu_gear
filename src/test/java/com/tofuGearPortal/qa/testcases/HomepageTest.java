package com.tofuGearPortal.qa.testcases;

import org.apache.log4j.Logger;
//import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tofuGear.qa.base.TestBase;
import com.tofuGearPortal.qa.pages.HomePage;
import com.tofuGearPortal.qa.pages.digitaltransformationpage;
import com.tofuGearPortal.qa.pages.BlogPage;
import com.tofuGearPortal.qa.pages.AboutUsPage;
import com.tofuGearPortal.qa.pages.PlatformPage;
import com.tofuGearPortal.qa.pages.ContactPage;
import com.tofuGearPortal.qa.pages.CareerPage;
import com.tofuGearPortal.qa.pages.Ecommercepage;

public class HomepageTest extends TestBase {

	HomePage HomePage;
	digitaltransformationpage digitaltransformationpage;
	Ecommercepage Ecommercepage;
	BlogPage BlogPage;
	AboutUsPage AboutUsPage;
	ContactPage ContactPage;
	PlatformPage PlatformPage;
	CareerPage CareerPage;
	Logger log = Logger.getLogger(HomepageTest.class);
	
	
	
	public HomepageTest(){
		super();
	}
	

	@BeforeMethod
	public void setup() {
		initialization();
		HomePage = new HomePage();
	}
	
	@Test(priority=1,groups="content")
	public void validateTopcontent() {
		log.info("home page content");
		String topContent = HomePage.validateTopcontent();
		Assert.assertEquals(topContent, "Complex Commercial Experiences, Simplified with Technology","Top Content of the HomePage is not matched");
	}
	
	@Test(priority=2,groups="video")
	public void videovalidation() throws InterruptedException {
		
		log.fatal("**************************Video Player verification********************************");
		HomePage.playingvideo();
	}
	@Test(priority=3,groups="solutionMenu")
	public void solutionDigiMenu() {
		digitaltransformationpage = HomePage.solutionDigiMenu();
	}
	
	@Test(priority=4,groups="solutionMenu")
	public void solunecommerceMenu() {
		Ecommercepage = HomePage.solunecommerceMenu();
		log.debug("*****************************************Menu*****************************************************");
	}
	
	@Test(priority=5,groups="Menu")
	public void BlogMenu() {
		 BlogPage = HomePage.BlogMenu();
	}
	
	@Test(priority=6,groups="Menu")
	public void platformMenu() {
		 PlatformPage = HomePage.platformMenu();
	}
	
	@Test(priority=7,groups="Menu")
	public void AboutUsMenu() {
		AboutUsPage = HomePage.AboutUsMenu();
	}
	
	@Test(priority=8,groups="Menu")
	public void CareerMenu() {
		CareerPage = HomePage.CareerMenu();
	}
	
	@Test(priority=9,groups="Menu")
	public void ContactMenu() {
		ContactPage = HomePage.ContactMenu();
	}
	
	@Test(priority=10,groups="asiaexpo")
	public void RetailAsiaExpoPage() {
		String  RetailAsiaExpoURL= HomePage.AsiaExpo();
		Assert.assertEquals(RetailAsiaExpoURL, "http://www.retailasiaexpo.com/rae/","Asia Expo Page is not Displayed");
	}
	
	@Test(priority=11,groups="Clientconcernoptions")
	public void ClientConcernSelectionoptions() {
		int CCoptions = HomePage.ClientConcernSelectionoptions();
		Assert.assertEquals(CCoptions, 11, "Cliet Concern option is missing");
	}
	
	@Test(priority=12,groups="Clientconcernlist")
	public void digiTransformoptions() {
		String  DigiURl= HomePage.digiTransformoptions();
		Assert.assertEquals(DigiURl, "https://www.tofugear.com/digital-transformation/#digital-secton","mismatch url");
	}
	
	@Test(priority=13,groups="Clientconcernlist")
	public void Customerofflineoptions() {
		String CustomerofflineURl= HomePage.Customerofflineoptions();
		Assert.assertEquals(CustomerofflineURl, "https://www.tofugear.com/digital-transformation/#how-does-it-work","mismatch url");
	}
	
	@Test(priority=14,groups="Clientconcernlist")
	public void MaximizingInStoreeoptions() {
		String MaximizingInStoreURL= HomePage.MaximizingInStoreeoptions();
		Assert.assertEquals(MaximizingInStoreURL, "https://www.tofugear.com/digital-transformation/#digital-transformation-info","mismatch url");
	}
	
	@Test(priority=15,groups="Clientconcernlist")
	public void ExpandingStoreOptions() {
		String ExpandingStoreURL= HomePage.ExpandingStoreOptions();
		Assert.assertEquals(ExpandingStoreURL, "https://www.tofugear.com/digital-transformation/#unfold-the-solution","mismatch url");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
	
}
