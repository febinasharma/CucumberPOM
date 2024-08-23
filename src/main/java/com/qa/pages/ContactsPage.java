package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.TestBase;

public class ContactsPage extends TestBase{
//PageFactory
	
	@FindBy (xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
// Since 'Krishna is hardcoded in this xpath, we cant use @FindBy. Instead use By class within the method	
//	@FindBy (xpath="//a[contains(text(),'Krishna')]/../..//input[@type='checkbox']")
//	WebElement checkbox;
	
	@FindBy (xpath="//select[@name='title']")
	WebElement titleSelect;
	
	@FindBy (xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy (xpath="//input[@name='surname']")
	WebElement lastName;
	
	@FindBy (name="client_lookup")
	WebElement company;
	
	@FindBy (xpath="//td[@colspan='2']/input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	@FindBy (xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy (xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;

//Initializing the Page Objects
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsPageLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String contactName)
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+contactName+"')]/../..//input[@type='checkbox']")).click();
		
	}
//	public void clickOnNewContactsLink()
//	{
//		
//		driver.switchTo().frame(prop.getProperty("HomePageMainframe"));
//		
//		Actions action = new Actions(driver);
//		action.moveToElement(contactsLink).build().perform();
//		newContactsLink.click();
////		try {
////		Actions action = new Actions(driver);
////		action.moveToElement(contactsLink).build();
////		
//		
//		//action.scrollToElement(contactsLink).build().perform();
//		//Thread.sleep(3000);
//		
////		JavascriptExecutor js = (JavascriptExecutor) driver;
////		js.executeScript("document.getElementByXpath('//a[contains(text(),'New Contact')]').click();");
////		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
////		WebElement newContacts=wait.until(ExpectedConditions.elementToBeClickable(newContactsLink));
//		System.out.println("Found Element---------");
//		//driver.switchTo().frame(prop.getProperty("HomePageMainframe"));
////		newContactsLink.click();
//		}
////		catch(InvocationTargetException ite) {
////			ite.getCause().printStackTrace();
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//	}
	public void createNewContact(String title,String ftName, String ltName, String compName)
	{
		Select select=new Select(titleSelect);
		select.selectByVisibleText(title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(compName);
		saveBtn.click();
		
	}

}