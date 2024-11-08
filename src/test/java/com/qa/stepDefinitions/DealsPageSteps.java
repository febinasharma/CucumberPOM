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
	public void user_is_logged_into_the_application_and_is_on_the_Home_Page() throws InterruptedException, IOException {
		TestBase.initialize();
		loginPg=new LoginPage();
		homePg=loginPg.login(prop.getProperty("username"), prop.getProperty("password"));
		
//		TestUtil.takeScreenshotAtEndOfTest();
	}
	
	@When("User clicks on Deals from the  Menu option")
	public void user_clicks_on_deals_from_the_menu_option() {
		dealsPg=homePg.clickOnDealsMenu();
	}
	@Then("User is navigated to Deals page")
	public void user_is_navigated_to_deals_page() {
	   Assert.assertTrue(dealsPg.getDealsLabel());
	}
	
	@When("User clicks on New Deals from the Deals menu")
	public void user_clicks_on_new_deals_from_the_menu() {
		dealsPg=homePg.clickOnNewDealsLink();
	}
	@Then("^User enters new deals details (.*),(.*),(.*)$")
	public void user_enters_new_deals_details(String compName, String primaryContact, String closeDate) throws InterruptedException, ParseException {
		dealsPg.createNewDeals(compName, primaryContact, closeDate);
	}
	
	
	@When("User clicks on Full Form Search from Deals menu option")
	public void user_clicks_on_full_form_search_from_deals_menu_option() {
	    dealsPg=homePg.clickOnFullSearchForm();
	}
	@When("User clicks on Closed Status radio button")
	public void user_clicks_on_closed_status_radio_button() {
	    dealsPg.clickClosedStatus();
	}
	@When("User clicks on Search Deals button")
	public void user_clicks_on_search_deals_button() {
	    dealsPg.clickSearchDealsBtn();
	}
	@Then("All the Closed deals are displayed")
	public void all_the_closed_deals_are_displayed() {
		Assert.assertTrue(dealsPg.verifySearchForm());
	}

}
