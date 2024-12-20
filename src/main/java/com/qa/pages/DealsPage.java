package com.qa.pages;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.TestBase;
import com.qa.util.TestUtil;

public class DealsPage extends TestBase{
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement dealCompany;
	
	@FindBy (xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(.,'New Deal')]")
	WebElement newDealMenuOption;
	
	@FindBy(xpath="//input[@value='Lookup']")
	List<WebElement> lookUp;
	
	@FindBy(xpath="//input[@id='search']")
	WebElement searchTxtbox;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//input[@value='Set to None']")
	WebElement setToNoneColumn;
	
	@FindBy(xpath="//a")
	WebElement selectContact;
		
	@FindBy(xpath="//input[@value='X']")
	WebElement closeBtn;
	
	@FindBy(xpath="//strong[contains(text(),'No results')]")
	WebElement noResults;
	
	@FindBy(xpath="//input[@name='contact_lookup']")
	WebElement primaryContactTxtbox;
	
	@FindBy(xpath="//input[@id='fieldId_close_date']")
	WebElement predictedCloseDate;
	
	@FindBy(xpath="(//div[@class='calendar']//td[@class='day'])[5]")
	WebElement daySelect;
	
	@FindBy(xpath="//img[@title='Date selector' and @id='f_trigger_c_actual_close_date']")
	WebElement dateSelectorIcon;
	
	@FindBy(xpath="//div[@class='calendar']")
	WebElement calendar;
	
	@FindBy(xpath="(//div[@class='calendar']//td[@class='title'])[1]")
	WebElement monthYear;
	
	@FindBy(xpath="(//div[@class='calendar']//td[@class='button nav'])[4]")
	WebElement yearForward;
	
	@FindBy(xpath="(//div[@class='calendar']//td[@class='button nav'])[3]")
	WebElement monthForward;
	
	@FindBy(xpath="(//div[@class='calendar']//td[@class='button nav'])[1]")
	WebElement yearBackward;
	
	@FindBy(xpath="(//div[@class='calendar']//td[@class='button nav'])[2]")
	WebElement monthBackward;
	
	@FindBy(xpath="//input[@value='Save' and @type='submit']")
	WebElement submitBtnSaveDeals;
	
	@FindBy(xpath="(//td[contains(.,'Deals') and contains(.,'State')])[4]")
	WebElement dealsLabel;
	
	@FindBy(xpath="(//a[@title='Full Search Form'])[3]")
	WebElement fullSearchform;
	
	@FindBy(xpath="//input[@name='cs_closed' and @value='Y']")
	WebElement statusClosed;
	
	@FindBy(xpath="//input[@value='Search Deals']")
	WebElement searchDealsbtn;
	
	@FindBy(xpath="//td//strong[contains(.,'Actual Close Date')]//..//..//..//td[contains(.,'Apr') or contains(.,'Jul')]")
	WebElement actCloseDateValue;
	
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createNewDeals(String company, String pContact, String closeDate) throws InterruptedException
	{
		dealCompany.sendKeys(company);
		// code for handling multiple windows
		String parentWindow= driver.getWindowHandle();
		lookUp.get(1).click();
		TestUtil.selectOpenWindow(parentWindow,"CRMPRO - Contact lookup");
		searchTxtbox.sendKeys(pContact);
		submitBtn.click();
		try
		{
		if(selectContact.isDisplayed())
			selectContact.click();
			driver.switchTo().window(parentWindow);
			TestUtil.switchToFrame(prop.getProperty("HomePageMainframe"));
		}
		catch(Exception e)
		{
			closeBtn.click();
			driver.switchTo().window(parentWindow);
			TestUtil.switchToFrame(prop.getProperty("HomePageMainframe"));
			primaryContactTxtbox.sendKeys("hjghgj");
			
		}
		// code for calling calendar function
		dateSelectorIcon.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(calendar));
		TestUtil.pickDateFromCalendar(monthYear, closeDate, yearForward, monthForward, yearBackward, monthBackward);
		submitBtnSaveDeals.click();
	}
	
	public boolean getDealsLabel()
	{
		return dealsLabel.isDisplayed();
	}
	
	public void clickClosedStatus()
	{
		statusClosed.click();
	}
	
	public void clickSearchDealsBtn()
	{
		searchDealsbtn.click();
	}
	public boolean verifySearchForm()
	{
		return actCloseDateValue.isDisplayed();
	}

}
