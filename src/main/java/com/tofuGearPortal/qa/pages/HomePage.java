package com.tofuGearPortal.qa.pages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tofuGear.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//PageFactory - Object Repository
	
	@FindBy(xpath = "//*[@id=\\\"slide-1-layer-14\\\"]")
	@CacheLookup
	private WebElement ViewSolutionBtn;
	
	
	@FindBy(xpath = "//*[@id=\"slide-1-layer-15\"]")
	@CacheLookup
	private WebElement GetinTouchBtn;
	
	@FindBy(xpath = "//*[@id=\"Solutions-menu\"]/a")
	@CacheLookup
	private WebElement solutions;
	
	@FindBy(xpath = "//*[@id=\"Digital Transformation-menu\"]")
	@CacheLookup
	private WebElement digitaltranform;
	
	@FindBy(xpath = "//*[@id=\"E-commerce to Bricks-menu\"]")
	@CacheLookup
	private WebElement ecommerce;
	
	@FindBy(xpath = "//*[@id=\"Platform-menu\"]/a")
	@CacheLookup
	private WebElement platform;
	
	@FindBy(xpath = "//*[@id=\"Blog-menu\"]/a")
	@CacheLookup
	private WebElement blog;
	
	@FindBy(xpath = "//*[@id=\"About Us-menu\"]/a")
	@CacheLookup
	private WebElement aboutus;
	
	@FindBy(xpath = "//*[@id=\"Careers-menu\"]/a")
	@CacheLookup
	private WebElement careers;
	
	@FindBy(xpath = "//*[@id=\"Contact-menu\"]/a")
	@CacheLookup
	private WebElement contact;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div[2]")
	@CacheLookup
	private WebElement TopContent;
	
	@FindBy(id = "categories-selector")
	@CacheLookup
	private WebElement ClientConcern;
	
	@FindBy(id = "front-page-learn-more")
	@CacheLookup
	private WebElement learnmorebtn;
	
	@FindBy(className = "event-link-button")
	@CacheLookup
	private WebElement AsiaExpobtn;
	
	@FindBy(className = "resizelistener")
	@CacheLookup
	private WebElement homevideo;
	
	Logger log = Logger.getLogger(HomePage.class);
	
	//Initializing Page Object
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateTopcontent()
	{
		return TopContent.getText();
		
	}
	
	public void playingvideo() throws InterruptedException{
		log.info("click to play");
		homevideo.click();
		
		Thread.sleep(10000);
		log.info("click to pause");
		homevideo.click();
		
	}
	
	public digitaltransformationpage solutionDigiMenu(){
		Actions action = new Actions(driver);
		action.moveToElement(solutions).build().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		digitaltranform.click();
		return new digitaltransformationpage();
	}
	
	public Ecommercepage solunecommerceMenu(){
		Actions action = new Actions(driver);
		action.moveToElement(solutions).build().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ecommerce.click();
		return new Ecommercepage();
	}
	
	public PlatformPage platformMenu(){
		platform.click();
		return new PlatformPage();
	}
	
	public BlogPage BlogMenu(){
		blog.click();
		return new BlogPage();
	}
	
	public AboutUsPage AboutUsMenu(){
		aboutus.click();
		return new AboutUsPage();
	}
	public CareerPage CareerMenu(){
		careers.click();
		return new CareerPage();
	}
	
	public ContactPage ContactMenu(){
		contact.click();
		return new ContactPage();
	}
	
	public String AsiaExpo(){
		AsiaExpobtn.click();
		Set <String> Handles = driver.getWindowHandles();
	    Iterator iter = Handles.iterator();
	    String maintab=(String) iter.next();//maintab holds the 1st browser window
	   String childtab=(String) iter.next();//childtab holds the next browser window

	   driver.switchTo().window(childtab); //move to child browser window
		String Expourl = driver.getCurrentUrl();
		return Expourl;
	
	}
	
	public int ClientConcernSelectionoptions() {
		Select ClientConcernlist = new Select(ClientConcern);
		java.util.List<WebElement> l = ClientConcernlist.getOptions();
		int c1 = l.size();
		return c1;
	}
	
	public String digiTransformoptions() {
		Select ClientConcernlist = new Select(ClientConcern);
		ClientConcernlist.selectByVisibleText("Digital Transformation");
		learnmorebtn.click();
		String digiTransURL = driver.getCurrentUrl();
		return digiTransURL;
	}
	
	public String Customerofflineoptions() {
		Select ClientConcernlist = new Select(ClientConcern);
		ClientConcernlist.selectByVisibleText("Understanding your Customers Offline");
		learnmorebtn.click();
		String CustomerofflineURL = driver.getCurrentUrl();
		return CustomerofflineURL;
	}
	
	public String MaximizingInStoreeoptions() {
		Select ClientConcernlist = new Select(ClientConcern);
		ClientConcernlist.selectByVisibleText("Maximizing the In-Store Conversion");
		learnmorebtn.click();
		String  MaximizingInStoreURL = driver.getCurrentUrl();
		return  MaximizingInStoreURL;
	}
	
	public String ExpandingStoreOptions() {
		Select ClientConcernlist = new Select(ClientConcern);
		ClientConcernlist.selectByVisibleText("Expanding into Physical Stores");
		learnmorebtn.click();
		String  ExpandingStoreURL = driver.getCurrentUrl();
		return  ExpandingStoreURL;
	}
}
