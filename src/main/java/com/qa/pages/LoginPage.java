package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.qa.util.TestBase;

public class LoginPage extends TestBase{
	//Page Factory
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign')]")
	WebElement signUpLink;
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	WebElement crmlogoImage;
	
	@FindBy (xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy (xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;

	//Initializing the Page Objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) 
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
//		driver.switchTo().frame(prop.getProperty("HomePageMainframe"));
//		Actions action = new Actions(driver);
//		action.moveToElement(contactsLink).build().perform();
//		newContactsLink.click();
//		Thread.sleep(3000);
//		return new ContactsPage();
		return new HomePage();
	}
	
	


}
