package com.tofuGearPortal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tofuGear.qa.base.TestBase;

public class PlatformPage extends TestBase {

	//Page Factory - Object Repository
	
	@FindBy(xpath = "//div[@class='normal-button popup-youtube']")
	@CacheLookup
	private WebElement demoButton;
	
	//div[@class='normal-button get-in-touch']
	
	@FindBy(xpath = "//div[@class='normal-button get-in-touch']")
	@CacheLookup
	private WebElement contactbtn;
	
	public PlatformPage() {
		PageFactory.initElements(driver, this);
	}
	

	public boolean demodisplay()
	{
		return demoButton.isDisplayed(); 
	}
	
	public boolean contactenable()
	{
		return contactbtn.isEnabled(); 
	}

}
