package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;
import com.qa.util.TestUtil;

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
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactsMenu;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealsMenu;
	
	@FindBy(xpath="//a[contains(.,'New Deal')]")
	WebElement newDealMenuOption;
	
	@FindBy(xpath="(//a[@title='Full Search Form'])[3]")
	WebElement fullSearchform;


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
	
	public ContactsPage clickOnContactsMenu()
	{
		TestUtil.switchToFrame(prop.getProperty("HomePageMainframe"));
		TestUtil.performMenuAction(contactsMenu);
		contactsMenu.click();
		return new ContactsPage();
		
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
	public DealsPage clickOnNewDealsLink()
	{
		TestUtil.switchToFrame(prop.getProperty("HomePageMainframe"));
		TestUtil.performMenuAction(dealsLink);
		newDealMenuOption.click();
		return new DealsPage();
	}
	
	public DealsPage clickOnDealsMenu()
	{
		TestUtil.switchToFrame(prop.getProperty("HomePageMainframe"));
		dealsMenu.click();
		return new DealsPage();
	}
	

	public DealsPage clickOnFullSearchForm()
	{
		TestUtil.switchToFrame(prop.getProperty("HomePageMainframe"));
		TestUtil.performMenuAction(dealsLink);
		fullSearchform.click();
		return new DealsPage();
	}
}
