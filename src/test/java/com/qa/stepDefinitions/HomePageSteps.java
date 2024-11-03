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

public class HomePageSteps extends TestBase{
	LoginPage loginPg;
	HomePage homePg;
	ContactsPage contactsPg;
	@Given("^User opens the browser and enter the url$")
	public void user_opens_the_browser_and_enter_the_url(){
		TestBase.initialize();
	}

	@When("^User is on the login page of the application$")
	public void user_is_on_the_login_page_of_the_application(){
	  loginPg=new LoginPage();
	  Assert.assertEquals("Free CRM software for customer relationship management, sales, and support.", loginPg.validateLoginPageTitle());
	 // System.out.println(loginPg);
	}
	
	@Then("^User enters valid credentials and logs into appilcation$")
	public void user_enters_valid_credentials_and_logs_into_appilcation() throws IOException {
	homePg=loginPg.login(prop.getProperty("username"), prop.getProperty("password"));
	TestUtil.takeScreenshotAtEndOfTest();
	}

	@Then("^User is navigated to Home Page$")
	public void user_is_navigated_to_Home_Page(){
		Assert.assertEquals("CRMPRO", homePg.verifyPageTitle());
		//TestBase.tearDown();
	}
	
	
	@When("User clicks on the Contacts menu option")
	public void user_clicks_on_the_contacts_menu_option() throws InterruptedException {
	    contactsPg=homePg.clickOnContactsMenu();
	}
	@Then("User is on the Contacts Page")
	public void user_is_on_the_contacts_page() {
	    Assert.assertTrue(contactsPg.verifyContactsPageLabel());
	    TestBase.tearDown();
	}

}
