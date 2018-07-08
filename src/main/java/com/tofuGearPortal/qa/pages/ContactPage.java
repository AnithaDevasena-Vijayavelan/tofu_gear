package com.tofuGearPortal.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tofuGear.qa.base.TestBase;

public class ContactPage extends TestBase {
	//id = g572-firstname
	//g572-lastname
	//g572-emailaddress
	//g572-companyname
	//className=g572-companyname
	
	@FindBy(id = "g572-firstname")
	@CacheLookup
	private WebElement firstname;
	
	@FindBy(id = "g572-lastname")
	@CacheLookup
	private WebElement lastname;
	
	@FindBy(id = "g572-emailaddress")
	@CacheLookup
	private WebElement emailaddress;
	
	@FindBy(id = "g572-companyname")
	@CacheLookup
	private WebElement companyname;
	
	@FindBy(id = "contact-form-comment-g574-howcanwehelp")
	@CacheLookup
	private WebElement helptextarea;
	
	@FindBy(xpath = "//input[contains(@value, 'Get in touch')]")
	@CacheLookup
	private WebElement submitButton;
	
	
	
	//Initializing Page Object
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String Emailaddress()
	{
		String RequiredEmail = emailaddress.getAttribute("aria-required");
		return RequiredEmail;
		
	}
	
	public String Firstname()
	{
		String RequiredFname = firstname.getAttribute("aria-required");
		return RequiredFname;
		
	}
	
	public Boolean submitenable()
	{
		Boolean submitenable = submitButton.isDisplayed();
		return submitenable;
		
	}
	
}
