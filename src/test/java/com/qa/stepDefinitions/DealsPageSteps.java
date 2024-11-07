package com.qa.stepDefinitions;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Assert;

import com.qa.pages.ContactsPage;
import com.qa.pages.DealsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DealsPageSteps extends TestBase{
	
	LoginPage loginPg;
	HomePage homePg;
	DealsPage dealsPg;
	@Given("User is logged into the application and is on the Home Page")
	public void user_is_logged_into_the_application() throws InterruptedException, IOException {
		TestBase.initialize();
		loginPg=new LoginPage();
		homePg=loginPg.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(homePg.verifyPageTitle(), "CRMPRO");
//		TestUtil.takeScreenshotAtEndOfTest();
	}
	
	
	@When("User is on the New Deals Page")
	public void user_is_on_the_new_deals_page() {
		//homePg.clickOnNewDealsLink();
	}
	@Then("User clicks on New Deals from the menu")
	public void user_clicks_on_new_deals_from_the_menu() {
		dealsPg=homePg.clickOnNewDealsLink();
	}
	@Then("^User enters new deals details (.*),(.*),(.*)$")
	public void user_enters_new_deals_details(String compName, String primaryContact, String closeDate) throws InterruptedException, ParseException {
//		System.out.println("Date:"+closeDate);    
		dealsPg.createNewDeals(compName, primaryContact, closeDate);
	}

}
