package com.qa.stepDefinitions;

import java.io.IOException;

import org.junit.Assert;

import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;
import com.qa.util.TestUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactsPageSteps extends TestBase{
	
	static LoginPage loginPg;
	static HomePage homePg;
	ContactsPage contactsPg;
	@Given("User is logged into the application")
	public void user_is_logged_into_the_application() throws InterruptedException, IOException {
		TestBase.initialize();
		loginPg=new LoginPage();
//		homePg=new HomePage();
//		contactsPg=new ContactsPage();
		homePg=loginPg.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(homePg.verifyPageTitle(), "CRMPRO");
//		TestUtil.takeScreenshotAtEndOfTest();
	}
	@When("User is on the contacts page")
	public void user_is_on_the_contacts_page() throws InterruptedException {
		
		contactsPg=homePg.clickOnContactLink();
				
	}
	@Then("User clicks on New Contacts from the menu")
	public void user_clicks_on_new_contacts_from_the_menu() {
		//driver.switchTo().frame(prop.getProperty("HomePageMainframe"));
		//contactsPg.clickOnNewContactsLink();
		}
	@Then("^User enters new contact details (.*),(.*),(.*),(.*)$")
	public void user_enters_new_contact_details(String title, String fName, String lName, String cName) throws IOException {
		contactsPg.createNewContact(title,fName, lName, cName);
		TestUtil.takeScreenshotAtEndOfTest();
		TestBase.tearDown();
	}
	
}
