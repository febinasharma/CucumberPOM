package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory
	@FindBy (xpath="//td[contains(text(),'User: Gagan Khanna')]")
	WebElement userNameLabel;
		
	@FindBy (xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy (xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
		
	@FindBy (xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;	
	@FindBy (xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;


	//Initializing the Page Objects
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public String verifyPageTitle()
	{
		return driver.getTitle();
	}
	public boolean verifyUsernameLabel()
	{
		
		return userNameLabel.isDisplayed();
	}
	public ContactsPage clickOnContactLink() throws InterruptedException
	{
		//contactsLink.click();
		driver.switchTo().frame(prop.getProperty("HomePageMainframe"));
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
		Thread.sleep(3000);
		return new ContactsPage();
	}
	

}
